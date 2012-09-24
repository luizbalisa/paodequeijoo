/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.FormaPagamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author miserani
 */
public class ConsultaFormaPagamentoCompraMySQL {

    private static final String SQL_BUSCA_FORMA_PAGAMENTO = "SELECT * FROM forma_pagamento_compra ORDER BY descricao";

    public ConsultaFormaPagamentoCompraMySQL() {
    }

   

    public ArrayList<FormaPagamento> buscarFormaPagamento() {
        ArrayList<FormaPagamento> formaPagamentos = new ArrayList<FormaPagamento>();
        String query = SQL_BUSCA_FORMA_PAGAMENTO;

        try {
            ResultSet rs = ConexaoMySQL.getInstance().executeQuery(query);
            while (rs.next()) {
                FormaPagamento formaPagamento = new FormaPagamento();
                formaPagamento.setIdformaPAgamento(rs.getInt("idforma_pagamento_compra"));
                formaPagamento.setDescricao(rs.getString("descricao"));
                formaPagamento.setTipoDePagamento(rs.getInt("tipo"));
                formaPagamentos.add(formaPagamento);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return formaPagamentos;
    }
}
