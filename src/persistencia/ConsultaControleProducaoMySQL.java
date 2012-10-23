
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.ControleProducao;
import fachada.HistSaidaProdutoMP;
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
    private static final String SQL_BUSCA_TODOS = "SELECT * FROM historico_producao ORDER BY idOrigem";
    private static final String SQL_BUSCA_DESTINO = "SELECT * FROM historico_producao WHERE idOrigem=?";
    private static final String SQL_UPDATE = "UPDATE historico_producao SET quantidade=? WHERE idProduto=? AND data=? AND idOrigem=?";
    private static final String SQL_INCLUIR = "INSERT INTO historico_producao(idProduto,data,quantidade,idOrigem)"
            + "VALUES (?,?,?,?)";

    public int buscaHistoricoSaidaProdutosIguais(ControleProducao historicoProduto) {
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
                return rs.getInt("quantidade");
            }
            con.close();
        } catch (SQLException ex) {
        }

        return 0;
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
                ControleProducao aux = new ControleProducao(rs.getInt("idProduto"), rs.getInt("destino"), rs.getInt("quantidade"), rs.getString("data"));
                aux.setId(rs.getInt("idhistorico_saida_mp"));
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
                ControleProducao aux = new ControleProducao(rs.getInt("idProduto"), rs.getInt("destino"), rs.getInt("quantidade"), rs.getString("data"));
                aux.setId(rs.getInt("idhistorico_saida_mp"));
                retorno.add(aux);
            }
            con.close();
        } catch (SQLException ex) {
        }

        return retorno;
    }

    public void updateHistoricoSaidaProdutosIguais(ControleProducao historicoProduto) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, historicoProduto.getQnt());
            stmt.setInt(2, historicoProduto.getIdProd());
            stmt.setString(3, historicoProduto.getData());
            stmt.setInt(4, historicoProduto.getIdDest());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertHistoricoSaidaProdutos(ControleProducao historicoProduto) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_INCLUIR);
            stmt.setInt(1, historicoProduto.getIdProd());
            stmt.setString(2, historicoProduto.getData());
            stmt.setInt(3, historicoProduto.getQnt());
            stmt.setInt(4, historicoProduto.getIdDest());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
        }
    }
}
