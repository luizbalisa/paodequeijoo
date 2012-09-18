/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.ProdutoVendaGeral;
import fachada.VendaGeral;
import fachada.VendaPrazo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HIGOR
 */
public class ConsultaVendaGeralMySQL {

    private static final String SQL_INCLUIR = "INSERT INTO venda(idCliente, idVendaPrazo, idStatus, idFormaPagamento, data, hora, valor)"
            + "VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_BUSCAR_ID = "SELECT MAX(idVenda) FROM venda";
    private static final String SQL_BUSCAR = "SELECT * FROM venda";
    private static final String SQL_BUSCA_STATUS = "SELECT descricao from status_venda WHERE idStatus=?";

    public void insertVenda(VendaGeral venda) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_INCLUIR);
            stmt.setInt(1, venda.getIdCliente());
            stmt.setInt(2, venda.getIdVendaPrazo());
            stmt.setInt(3, venda.getIdStatus());
            stmt.setInt(4, venda.getIdFormaPagamento());
            stmt.setString(5, venda.getData());
            stmt.setString(6, venda.getHora());
            stmt.setString(7, venda.getValor());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int buscarID() {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCAR_ID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public ArrayList<VendaGeral> buscarTodas() {
        ArrayList<VendaGeral> retorno = new ArrayList<VendaGeral>();
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCAR);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VendaGeral aux = new VendaGeral();
                aux.setIdVenda(rs.getInt("idVenda"));
                aux.setIdCliente(rs.getInt("idCliente"));
                aux.setIdVendaPrazo(rs.getInt("idVendaPrazo"));
                aux.setIdStatus(rs.getInt("idStatus"));
                aux.setIdFormaPagamento(rs.getInt("idFormaPagamento"));
                aux.setData(rs.getString("data"));
                aux.setHora(rs.getString("hora"));
                aux.setValor(rs.getString("valor"));
                retorno.add(aux);
            }
        } catch (SQLException ex) {
        }
        return retorno;
    }

    public String buscaStatus(int idStatus) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA_STATUS);
            stmt.setInt(1, idStatus);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getString("descricao");
            }
        } catch (SQLException ex) {
        }
        return null;
    }
}
