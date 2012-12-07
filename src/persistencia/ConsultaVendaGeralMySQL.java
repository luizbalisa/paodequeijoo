/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.VendaGeral;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author HIGOR
 */
public class ConsultaVendaGeralMySQL {

    private static final String SQL_INCLUIR = "INSERT INTO venda(idCliente, idVendaPrazo, idStatus, idFormaPagamento, data, hora, valor)"
            + "VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_BUSCAR_ID = "SELECT MAX(idVenda) FROM venda";
    private static final String SQL_BUSCAR = "SELECT * FROM venda";
    private static final String SQL_BUSCA_STATUS = "SELECT * from status_venda ";
    private static final String SQL_BUSCAR_VENDA = "SELECT * FROM venda WHERE idVenda=?";
    private static final String SQL_PRODUTOS = "SELECT * FROM lista_produto WHERE idVenda=?";
    private static final String SQL_ATUALIZAR = "UPDATE venda SET idStatus=? WHERE idVenda=?";

    public void updateVenda(VendaGeral venda) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_ATUALIZAR);
            stmt.setInt(1, venda.getIdStatus());
            stmt.setInt(2, venda.getIdVenda());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
        }
    }

    public ArrayList<String[]> buscarProdutos(int id) {
        Connection con;
        PreparedStatement stmt;
        ArrayList<String[]> retorno = new ArrayList<String[]>();
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_PRODUTOS);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String[] aux = new String[2];
                aux[0] = rs.getString("idProduto");
                aux[1] = rs.getString("quantidade");
                retorno.add(aux);
            }
            con.close();
        } catch (SQLException ex) {
        }
        return retorno;
    }

    public VendaGeral buscarVenda(int id) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCAR_VENDA);
            stmt.setInt(1, id);
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
                return aux;
            }
            con.close();
        } catch (SQLException ex) {
        }
        return null;
    }

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
            con.close();
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
            con.close();
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
            con.close();
        } catch (SQLException ex) {
        }
        return retorno;
    }

    public HashMap<Integer, String> buscaStatus() {
        Connection con;
        PreparedStatement stmt;
        HashMap<Integer, String> status = new HashMap<Integer, String>();
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCA_STATUS);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                status.put(rs.getInt("idStatus"), rs.getString("descricao"));
            }
            con.close();
        } catch (SQLException ex) {
        }
        return status;
    }
}
