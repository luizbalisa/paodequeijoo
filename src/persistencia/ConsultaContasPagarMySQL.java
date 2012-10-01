/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import fachada.ContasPagar;
import fachada.MovimentoCaixa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guil
 */
public class ConsultaContasPagarMySQL {

    private static final String SQL_INCLUIR = "INSERT INTO contas_pagar(data, descricao, tipo, valor, status) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_BUSCAR = "SELECT * FROM movimento_caixa";
    private static final String SQL_EXCLUIR = "DELETE FROM movimento_caixa WHERE idmovimento_caixa=?";

    public ConsultaContasPagarMySQL() {
    }

    public void cadastrar(ContasPagar contas) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = (Connection) ConexaoMySQL.conectar();
            stmt = (PreparedStatement) con.prepareStatement(SQL_INCLUIR);
            stmt.setString(1, contas.getData());
            stmt.setString(2, contas.getDescricao());
            stmt.setInt(3, contas.getTipo());
            stmt.setString(4, contas.getValor());
            stmt.setInt(5, contas.getStatus());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
        }
    }

//    public void excluirMovimento(int id) {
//        Connection con;
//        PreparedStatement stmt;
//        try {
//            con = (Connection) ConexaoMySQL.conectar();
//            stmt = (PreparedStatement) con.prepareStatement(SQL_EXCLUIR);
//            stmt.setInt(1, id);
//            stmt.executeUpdate();
//        } catch (SQLException ex) {
//        }
//    }
//
//    public ArrayList<MovimentoCaixa> buscarTodos() {
//        ArrayList<MovimentoCaixa> retorno = new ArrayList<MovimentoCaixa>();
//        try {
//            ResultSet rs = ConexaoMySQL.getInstance().executeQuery(SQL_BUSCAR);
//            while (rs.next()) {
//                MovimentoCaixa aux = new MovimentoCaixa();
//                aux.setIdMovimentoCaixa(rs.getInt("idmovimento_caixa"));
//                aux.setData(rs.getString("data"));
//                aux.setFormaPagamento(rs.getInt("forma_pagamento"));
//                aux.setValor(rs.getString("valor"));
//                aux.setDescricao(rs.getString("descricao"));
//                retorno.add(aux);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ConsultaContasPagarMySQL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return retorno;
//    }
}
