/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.VendaPrazo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author miserani
 */
public class ConsultaVendaPrazoMySQL {

    private static final String SQL_INCLUIR = "INSERT INTO venda_prazo(idcliente, valor, forma_pagamento)"
            + "VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE venda_prazo SET valor=? WHERE idcliente=?";
    private static final String SQL_BUSCAR_CLIENTE = "SELECT * FROM venda_prazo WHERE idcliente=?";
    private static final String SQL_BUSCAR_ID = "SELECT MAX(idvenda_prazo) FROM venda_prazo";
    private static final String SQL_BUSCAR = "SELECT * FROM venda_prazo";
    private static final String SQL_EXCLUIR = "DELETE FROM venda_prazo WHERE idvenda_prazo=?";

    public void insertVendaPrazo(VendaPrazo vendaPrazo) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_INCLUIR);
            stmt.setInt(1, vendaPrazo.getIdCliente());
            stmt.setString(2, vendaPrazo.getValor());
            stmt.setInt(3, vendaPrazo.getIdFormaPagamento());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteVendaPrazo(int vendaPrazo) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_EXCLUIR);
            stmt.setInt(1, vendaPrazo);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateVendaPrazo(VendaPrazo vendaPrazo) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vendaPrazo.getValor());
            stmt.setInt(2, vendaPrazo.getIdCliente());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String bsucaCliente(int idCliente) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCAR_CLIENTE);
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getString("valor") + " " + rs.getInt("idvenda_prazo");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
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

    public ArrayList<VendaPrazo> buscarTodas() {
        ArrayList<VendaPrazo> retorno = new ArrayList<VendaPrazo>();
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCAR);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VendaPrazo aux = new VendaPrazo();
                aux.setIdCliente(rs.getInt("idCliente"));
                aux.setIdVenda(rs.getInt("idvenda_prazo"));
                aux.setIdFormaPagamento(rs.getInt("forma_pagamento"));
                aux.setValor(rs.getString("valor"));
                ConsultaListaProdutoVendaMySQL prods = new ConsultaListaProdutoVendaMySQL();
                aux.setListVenda(prods.buscaListaProdutoVenda(aux.getIdVenda()));
                retorno.add(aux);
            }
        } catch (SQLException ex) {
        }
        return retorno;
    }
}
