/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.FormaPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author miserani
 */
public class ConsultasFormaDePagamentoMySQL {

    private static final String SQL_EXCLUIR_FORMA_PAGAMENTO = "DELETE FROM forma_pagamento WHERE idforma_pagamento=?";
    private static final String SQL_BUSCA_FORMA_PAGAMENTO = "SELECT * FROM forma_pagamento ORDER BY descricao";
    private static final String SQL_INCLUIR_FORMA_PAGAMENTO = "INSERT INTO forma_pagamento (descricao, vista_prazo) "
            + "VALUES (?, ?)";
    private static final String SQL_EDITAR_FORMA_PAGAMENTO = "UPDATE forma_pagamento SET descricao=?, vista_prazo=? WHERE idforma_pagamento=? ";
    private static final String SQL_BUSCAR_FORMA_PAGAMENTO_ID = "SELECT descricao FROM forma_pagamento WHERE idforma_pagamento=?";
    private static final String SQL_BUSCAR_FORMA_PAGAMENTO_DESCRICAO = "SELECT idforma_pagamento FROM forma_pagamento WHERE descricao=?";

    public ConsultasFormaDePagamentoMySQL() {
    }

    public String excluirFormaPagamento(FormaPagamento formaPagamento) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_EXCLUIR_FORMA_PAGAMENTO);
            stmt.setInt(1, formaPagamento.getIdformaPAgamento());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Exclusão de forma de pagamento não foi efetuada";
        }
        return "Exclusão de forma de pagamento efetuada com sucesso!";
    }

    public String cadastrarFormaPAgamento(FormaPagamento formaPagamento) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_INCLUIR_FORMA_PAGAMENTO);
            stmt.setString(1, formaPagamento.getDescricao());
            stmt.setInt(2, formaPagamento.getTipoDePagamento());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Cadastro de Forma de pagamento não foi efetuada";
        }
        return "Cadastro de Forma de pagamento efetuado com sucesso!";
    }

    public String editarFormaPagamento(FormaPagamento formaPagamento) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_EDITAR_FORMA_PAGAMENTO);
            stmt.setString(1, formaPagamento.getDescricao());
            stmt.setInt(2, formaPagamento.getTipoDePagamento());
            stmt.setInt(3, formaPagamento.getIdformaPAgamento());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Erro na alteração da forma de pagamento";
        }
        return "Forma de pagamento alterada com sucesso ";
    }

    public String buscarNomeForma(int id) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCAR_FORMA_PAGAMENTO_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getString("descricao");
            }
        } catch (SQLException ex) {
        }
        return "Erro";
    }

    public int buscarIdForma(String nome) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCAR_FORMA_PAGAMENTO_DESCRICAO);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("idforma_pagamento");
            }
        } catch (SQLException ex) {
        }
        return 0;
    }

    public ArrayList<FormaPagamento> buscarFormaPagamento() {
        ArrayList<FormaPagamento> formaPagamentos = new ArrayList<FormaPagamento>();
        String query = SQL_BUSCA_FORMA_PAGAMENTO;

        try {
            ResultSet rs = ConexaoMySQL.getInstance().executeQuery(query);
            while (rs.next()) {
                FormaPagamento formaPagamento = new FormaPagamento();
                formaPagamento.setIdformaPAgamento(rs.getInt("idforma_pagamento"));
                formaPagamento.setDescricao(rs.getString("descricao"));
                formaPagamento.setTipoDePagamento(rs.getInt("vista_prazo"));
                formaPagamentos.add(formaPagamento);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return formaPagamentos;
    }
}
