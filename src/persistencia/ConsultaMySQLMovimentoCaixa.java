/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import fachada.MovimentoCaixa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Guil
 */
public class ConsultaMySQLMovimentoCaixa {

    private static final String SQL_BUSCA = "SELECT * FROM movimento_caixa WHERE idmovimento_caixa=?";
    private static final String SQL_INCLUIR = "INSERT INTO movimento_caixa(data, forma_pagamento, valor)"
            + "VALUES (?, ?, ?)";
    private static final String SQL_EXCLUIR = "DELETE FROM movimento_caixa WHERE idmovimento_caixa = ?";
    private static final String SQL_EDITAR = "UPDATE movimento_caixa SET idmovimento_caixa=?,data=?,forma_pagamento=?,valor=?";
    public ArrayList<String> buscarMovimento;

    public ConsultaMySQLMovimentoCaixa() {
    }

    public String excluirItemCaixa(MovimentoCaixa mCaixa) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = (Connection) ConexaoMySQL.conectar();
            stmt = (PreparedStatement) con.prepareStatement(SQL_EXCLUIR);
            stmt.setInt(1, mCaixa.getIdMovimentoCaixa());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Exclusão do Cliente não foi efetuada";
        }
        return "Exclusão do Cliente efetuada com sucesso!";
    }

    public void cadastrarItemCaixa(MovimentoCaixa mCaixa) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = (Connection) ConexaoMySQL.conectar();
            stmt = (PreparedStatement) con.prepareStatement(SQL_INCLUIR);
            stmt.setString(1, mCaixa.getData());
            stmt.setInt(2, mCaixa.getTipoPagamento());
            stmt.setString(3, mCaixa.getValor());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String editarItemCaixa(MovimentoCaixa mCaixa) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = (Connection) ConexaoMySQL.conectar();
            stmt = (PreparedStatement) con.prepareStatement(SQL_EDITAR);
            stmt.setString(1, mCaixa.getData());
            stmt.setString(2, String.valueOf(mCaixa.getTipoPagamento()));
            stmt.setString(3, mCaixa.getValor());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Erro na alteração do Cliente";
        }
        return "Cliente alterado com sucesso!";
    }

    public ArrayList<MovimentoCaixa> buscarItensNoCaixa() {
        ArrayList<MovimentoCaixa> mCaixa = new ArrayList<MovimentoCaixa>();
        String query = SQL_BUSCA;
        try {
            ResultSet rs = ConexaoMySQL.getInstance().executeQuery(query);
            while (rs.next()) {
                MovimentoCaixa v = new MovimentoCaixa();
                v.setData(rs.getString("data"));
                v.setTipoPagamento(Integer.parseInt(rs.getString("idforma_pagamento")));
                v.setIdMovimentoCaixa(Integer.parseInt(rs.getString("idmovimento_caixa")));
                v.setValor(rs.getString("valor"));
                mCaixa.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mCaixa;
    }
}
