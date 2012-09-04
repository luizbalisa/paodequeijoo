/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import fachada.MovimentoCaixa;
import fachada.VendaPrazo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Guil
 */
public class ConsultaMovimentoCaixaMySQL {

    private static final String SQL_BUSCAR = "SELECT * FROM movimento_caixa WHERE data=? AND forma_pagamento=?";
    private static final String SQL_INCLUIR = "INSERT INTO movimento_caixa(data, forma_pagamento, valor) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE movimento_caixa SET valor=? WHERE data=? AND forma_pagamento=?";

    public ConsultaMovimentoCaixaMySQL() {
    }

    public void cadastrarItemCaixa(MovimentoCaixa mCaixa) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = (Connection) ConexaoMySQL.conectar();
            stmt = (PreparedStatement) con.prepareStatement(SQL_INCLUIR);
            stmt.setString(1, mCaixa.getData());
            stmt.setInt(2, mCaixa.getFormaPagamento());
            stmt.setString(3, mCaixa.getValor());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String buscarItemCaixaIguais(MovimentoCaixa mCaixa) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = (Connection) ConexaoMySQL.conectar();
            stmt = (PreparedStatement) con.prepareStatement(SQL_BUSCAR);
            stmt.setString(1, mCaixa.getData());
            stmt.setInt(2, mCaixa.getFormaPagamento());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getString("valor");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }

    public void updateListaProdutoVendaIguais(MovimentoCaixa mCaixa) {
        java.sql.Connection con;
        java.sql.PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, mCaixa.getValor());
            stmt.setString(2, mCaixa.getData());
            stmt.setInt(3, mCaixa.getFormaPagamento());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
