
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.ControleProducao;
import fachada.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class ConsultaControleProducaoMySQL {

    private static final String SQL_BUSCA = "SELECT * FROM historico_producao WHERE idProduto=? AND data=? AND idOrigem=?";
    private static final String SQL_BUSCA_TODOS = "SELECT * FROM historico_producao";
    private static final String SQL_BUSCA_DESTINO = "SELECT * FROM historico_producao WHERE idOrigem=?";
    private static final String SQL_UPDATE = "UPDATE historico_producao SET quantidade=?, valor=? WHERE idProduto=? AND data=? AND idOrigem=?";
    private static final String SQL_INCLUIR = "INSERT INTO historico_producao(idProduto,data,quantidade,idOrigem,valor)"
            + "VALUES (?,?,?,?,?)";

    public String buscaHistoricoSaidaProdutosIguais(ControleProducao historicoProduto) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA);

            stmt.setInt(1, historicoProduto.getIdProd());
            stmt.setString(2, historicoProduto.getData());
            stmt.setInt(3, historicoProduto.getIdDest());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getString("valor");
            }
            con.close();
        } catch (SQLException ex) {
        }

        return "n";
    }

    public String buscaHistoricoSaidaProdutosIguaisQtd(ControleProducao historicoProduto) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA);

            stmt.setInt(1, historicoProduto.getIdProd());
            stmt.setString(2, historicoProduto.getData());
            stmt.setInt(3, historicoProduto.getIdDest());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getString("quantidade");
            }
            con.close();
        } catch (SQLException ex) {
        }

        return "0";
    }

    public ArrayList<ControleProducao> buscaHistoricoestino(int destino) {
        Connection con;
        PreparedStatement stmt;
        ArrayList<ControleProducao> retorno = new ArrayList<ControleProducao>();
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA_DESTINO);

            stmt.setInt(1, destino);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ControleProducao aux = new ControleProducao(rs.getInt("idProduto"), rs.getInt("idOrigem"), rs.getString("quantidade"), rs.getString("data"), rs.getString("valor"));
                aux.setId(rs.getInt("idhistorico_producao"));
                retorno.add(aux);
            }
            con.close();
        } catch (SQLException ex) {
        }

        return retorno;
    }

    public ArrayList<ControleProducao> buscaHistorico() {
        Connection con;
        PreparedStatement stmt;
        ArrayList<ControleProducao> retorno = new ArrayList<ControleProducao>();
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA_TODOS);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ControleProducao aux = new ControleProducao(rs.getInt("idProduto"), rs.getInt("idOrigem"), rs.getString("quantidade"), rs.getString("data"), rs.getString("valor"));
                aux.setId(rs.getInt("idhistorico_producao"));
                retorno.add(aux);
            }
            con.close();
        } catch (SQLException ex) {
        }

        return retorno;
    }

    public void updateHistoricoProducao(ControleProducao historicoProduto) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_UPDATE);
            String qtd = buscaHistoricoSaidaProdutosIguaisQtd(historicoProduto);
            qtd = String.valueOf(Double.parseDouble(qtd.replace(",", ".")) + Double.parseDouble(historicoProduto.getQnt().replace(",", ".")));
            stmt.setString(1, qtd);
            stmt.setString(2, historicoProduto.getValor());
            stmt.setInt(3, historicoProduto.getIdProd());
            stmt.setString(4, historicoProduto.getData());
            stmt.setInt(5, historicoProduto.getIdDest());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertHistoricoProducao(ControleProducao historicoProduto) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_INCLUIR);
            stmt.setInt(1, historicoProduto.getIdProd());
            stmt.setString(2, historicoProduto.getData());
            stmt.setString(3, historicoProduto.getQnt());
            stmt.setInt(4, historicoProduto.getIdDest());
            stmt.setString(5, historicoProduto.getValor());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
        }
    }
}
