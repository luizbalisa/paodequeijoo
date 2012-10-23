/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.ProdutoVenda;
import fachada.ProdutoVendaGeral;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author miserani
 */
public class ConsultaListaProdutoMYSQL {

    private static final String SQL_INCLUIR = "INSERT INTO lista_produto(idVenda, idProduto, quantidade)"
            + "VALUES (?,?,?)";
    private static final String SQL_BUSCA_PRODUTO = "SELECT * FROM lista_produto WHERE idProduto=? AND idVenda=?";
    private static final String SQL_BUSCA = "SELECT * from lista_produto WHERE idVenda=?";

    public void insertProdutoVendaGeral(int idVenda, int id, int qnt) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_INCLUIR);
            stmt.setInt(1, idVenda);
            stmt.setInt(2, id);
            stmt.setInt(3, qnt);
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
        }
    }

    public ArrayList<ProdutoVendaGeral> buscaListaProdutoVendaGeral(int idVenda) {
        Connection con;
        PreparedStatement stmt;
        ArrayList<ProdutoVendaGeral> retorno = new ArrayList<ProdutoVendaGeral>();
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA);
            stmt.setInt(1, idVenda);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProdutoVendaGeral aux = new ProdutoVendaGeral();
                aux.setIdProduto(rs.getInt("idProduto"));
                aux.setQnt(rs.getInt("quantidade"));
                retorno.add(aux);
            }
            con.close();
        } catch (SQLException ex) {
        }
        return retorno;
    }
}
