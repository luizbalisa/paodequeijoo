
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

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
public class HistSaidaMPMySQL {

    private static final String SQL_BUSCA = "SELECT * FROM historico_saida_mp WHERE idProduto=? AND data=? AND destino=?";
    private static final String SQL_BUSCA_TODOS = "SELECT * FROM historico_saida_mp ORDER BY destino";
    private static final String SQL_BUSCA_DESTINO = "SELECT * FROM historico_saida_mp WHERE destino=?";
    private static final String SQL_UPDATE = "UPDATE historico_saida_mp SET quantidade=? WHERE idProduto=? AND data=? AND iddestino=?";
    private static final String SQL_INCLUIR = "INSERT INTO historico_saida_mp(idProduto,data,quantidade,destino,preco_custo)"
            + "VALUES (?,?,?,?,?)";

    public int buscaHistoricoSaidaProdutosIguais(HistSaidaProdutoMP historicoProduto) {
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
        } catch (SQLException ex) {
        }

        return 0;
    }

    public ArrayList<HistSaidaProdutoMP> buscaHistoricoestino(int destino) {
        Connection con;
        PreparedStatement stmt;
        ArrayList<HistSaidaProdutoMP> retorno = new ArrayList<HistSaidaProdutoMP>();
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA_DESTINO);

            stmt.setInt(1, destino);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HistSaidaProdutoMP aux = new HistSaidaProdutoMP(rs.getInt("idProduto"), rs.getInt("destino"), rs.getInt("quantidade"), rs.getString("data"), rs.getString("preco_custo"));
                aux.setId(rs.getInt("idhistorico_saida_mp"));
                retorno.add(aux);
            }
        } catch (SQLException ex) {
        }

        return retorno;
    }

    public ArrayList<HistSaidaProdutoMP> buscaHistorico() {
        Connection con;
        PreparedStatement stmt;
        ArrayList<HistSaidaProdutoMP> retorno = new ArrayList<HistSaidaProdutoMP>();
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA_TODOS);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HistSaidaProdutoMP aux = new HistSaidaProdutoMP(rs.getInt("idProduto"), rs.getInt("destino"), rs.getInt("quantidade"), rs.getString("data"), rs.getString("preco_custo"));
                aux.setId(rs.getInt("idhistorico_saida_mp"));
                retorno.add(aux);
            }
        } catch (SQLException ex) {
        }

        return retorno;
    }

    public void updateHistoricoSaidaProdutosIguais(HistSaidaProdutoMP historicoProduto) {
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
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertHistoricoSaidaProdutos(HistSaidaProdutoMP historicoProduto) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_INCLUIR);
            stmt.setInt(1, historicoProduto.getIdProd());
            stmt.setString(2, historicoProduto.getData());
            stmt.setInt(3, historicoProduto.getQnt());
            stmt.setInt(4, historicoProduto.getIdDest());
            stmt.setString(5, historicoProduto.getPreco());
            stmt.executeUpdate();
        } catch (SQLException ex) {
        }
    }
}
