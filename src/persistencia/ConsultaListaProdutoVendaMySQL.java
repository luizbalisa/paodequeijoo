/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.ProdutoVenda;
import fachada.VendaPrazo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Guil
 */
public class ConsultaListaProdutoVendaMySQL {

    private static final String SQL_INCLUIR = "INSERT INTO lista_produto_venda(idVenda, idProduto, quantidade, valor, data)"
            + "VALUES (?,?,?,?,?)";
    private static final String SQL_BUSCA_PROD = "SELECT * FROM lista_produto_venda WHERE idVenda=? AND idProduto=?";
    private static final String SQL_BUSCA = "SELECT * FROM lista_produto_venda WHERE idVenda=?";
    private static final String SQL_UPDATE = "UPDATE lista_produto_venda SET quantidade=? AND valor=? WHERE idlista_produto_venda=?";
    private static final String SQL_DELETE_ESTORNO = "DELETE FROM lista_produto_venda WHERE idVenda=? and idProduto=? and data=?";

    public void insertProdutoVendaPrazo(int idVenda, ProdutoVenda produto) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_INCLUIR);
            stmt.setInt(1, idVenda);
            stmt.setInt(2, produto.getProduto().getIdProduto());
            stmt.setInt(3, produto.getQnt());
            stmt.setString(4, produto.getValor());
            stmt.setString(5, produto.getData());
            stmt.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public double[] buscaListaProdutoVendaIguais(VendaPrazo venda, ProdutoVenda produto) {
        Connection con;
        PreparedStatement stmt;
        double[] a = new double[3];
        a[0] = 0;//considerar produto inexistente na lista
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA_PROD);
            stmt.setInt(1, venda.getIdVenda());
            stmt.setInt(2, produto.getProduto().getIdProduto());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                a[0] = rs.getInt("quantidade");
                a[2] = rs.getInt("idlista_produto_venda");
            }
        } catch (SQLException ex) {
        }

        return a;
    }

    public ArrayList<ProdutoVenda> buscaListaProdutoVenda(int idVenda) {
        Connection con;
        PreparedStatement stmt;
        ArrayList<ProdutoVenda> retorno = new ArrayList<ProdutoVenda>();
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA);
            stmt.setInt(1, idVenda);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProdutoVenda aux = new ProdutoVenda();
                aux.setData(rs.getString("data"));
                aux.setQnt(rs.getInt("quantidade"));
                aux.setValor(rs.getString("valor"));
                ConsultaProdutoMySQL prod = new ConsultaProdutoMySQL();
                aux.setProduto(prod.buscarProduto(rs.getInt("idProduto")));
                retorno.add(aux);
            }
        } catch (SQLException ex) {
        }

        return retorno;
    }

    public void updateListaProdutoVendaIguais(double valores[]) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, (int) valores[0]);
            stmt.setString(2, String.valueOf(valores[1]));
            stmt.setInt(3, (int) (valores[2]));
            stmt.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    public void updateEstorno( int idVenda, int idProd, String data) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_DELETE_ESTORNO);
            stmt.setInt(1, idVenda);
            stmt.setInt(2, idProd);
            stmt.setString(3, data);
            stmt.executeUpdate();
        } catch (SQLException ex) {
        }
    }
}
