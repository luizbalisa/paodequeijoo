/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.FormaPagamento;
import java.text.Normalizer;
import java.util.ArrayList;
import persistencia.ConsultaFormaDePagamentoMySQL;

/**
 *
 * @author miserani
 */
public class FormaDePagamentoController {

    FormaPagamento formaPagamento = new FormaPagamento();
    ArrayList<FormaPagamento> listaFormaPagamento = new ArrayList<FormaPagamento>();

    public FormaDePagamentoController() {
    }

    public int getIdFormaPagamento(String forma) {
        for (int i = 0; i < this.listaFormaPagamento.size(); i++) {
            if (this.listaFormaPagamento.get(i).getDescricao().equals(forma)) {
                return listaFormaPagamento.get(i).getIdformaPAgamento();
            }
        }
        return 0;
    }

    public String cadastrar() {
        ConsultaFormaDePagamentoMySQL consultasFormaDePagamentoMySQL = new ConsultaFormaDePagamentoMySQL();
        return consultasFormaDePagamentoMySQL.cadastrarFormaPAgamento(formaPagamento);
    }

    public String editar() {
        ConsultaFormaDePagamentoMySQL consultasFormaDePagamentoMySQL = new ConsultaFormaDePagamentoMySQL();
        return consultasFormaDePagamentoMySQL.editarFormaPagamento(formaPagamento);
    }

    public String excluirFormaPagamento() {
        ConsultaFormaDePagamentoMySQL consultasFormaDePagamentoMySQL = new ConsultaFormaDePagamentoMySQL();
        return consultasFormaDePagamentoMySQL.excluirFormaPagamento(formaPagamento);
    }

    public void buscarFormaPagamento() {
        ConsultaFormaDePagamentoMySQL consultasFormaDePagamentoMySQL = new ConsultaFormaDePagamentoMySQL();
        this.listaFormaPagamento = consultasFormaDePagamentoMySQL.buscarFormaPagamento();
    }

    public ArrayList<FormaPagamento> getListFormaPagamento() {
        return listaFormaPagamento;
    }

    public void setListFormaPagamento(ArrayList<FormaPagamento> listFormaPagamentos) {
        this.listaFormaPagamento = listFormaPagamentos;
    }

//    public Produto getProduto(int id) {
//        return produto;
//    }
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPAgamento) {
        this.formaPagamento = formaPAgamento;
    }

    public void getFormaPagamento(int id) {
        for (int i = 0; i < this.listaFormaPagamento.size(); i++) {
            if (this.listaFormaPagamento.get(i).getIdformaPAgamento() == id) {
                formaPagamento = listaFormaPagamento.get(i);
            }
        }
    }
}
