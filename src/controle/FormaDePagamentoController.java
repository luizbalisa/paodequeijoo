/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.FormaPagamento;
import java.text.Normalizer;
import java.util.ArrayList;
import persistencia.ConsultasFormaDePagamentoMySQL;

/**
 *
 * @author miserani
 */
public class FormaDePagamentoController {

    FormaPagamento formaPagamento = new FormaPagamento();
    ArrayList<FormaPagamento> listaFormaPagamento = new ArrayList<FormaPagamento>();

    public FormaDePagamentoController() {
    }

    public String cadastrar() {
        ConsultasFormaDePagamentoMySQL consultasFormaDePagamentoMySQL = new ConsultasFormaDePagamentoMySQL();
        return consultasFormaDePagamentoMySQL.cadastrarFormaPAgamento(formaPagamento);
    }

    public String editar() {
        ConsultasFormaDePagamentoMySQL consultasFormaDePagamentoMySQL = new ConsultasFormaDePagamentoMySQL();
        return consultasFormaDePagamentoMySQL.editarFormaPagamento(formaPagamento);
    }

    public String excluirFormaPagamento() {
        ConsultasFormaDePagamentoMySQL consultasFormaDePagamentoMySQL = new ConsultasFormaDePagamentoMySQL();
        return consultasFormaDePagamentoMySQL.excluirFormaPagamento(formaPagamento);
    }

    public void buscarFormaPagamento() {
        ConsultasFormaDePagamentoMySQL consultasFormaDePagamentoMySQL = new ConsultasFormaDePagamentoMySQL();
        this.listaFormaPagamento = consultasFormaDePagamentoMySQL.buscarFormaPagamento();
    }

    public ArrayList<FormaPagamento> buscaDinamicaFormaPagamento(String busca) {
        String desc2 = busca;
        desc2 = Normalizer.normalize(desc2, Normalizer.Form.NFD);
        desc2 = desc2.replaceAll("[^\\p{ASCII}]", "");
        desc2 = desc2.toUpperCase();
        ArrayList<FormaPagamento> formaPagamentos = new ArrayList<FormaPagamento>();
        for (int i = 0; i < listaFormaPagamento.size(); i++) {
            String comp = listaFormaPagamento.get(i).getDescricao();
            comp = Normalizer.normalize(comp, Normalizer.Form.NFD);
            comp = comp.replaceAll("[^\\p{ASCII}]", "");
            comp = comp.toUpperCase();
            if (comp.contains(desc2)) {
                formaPagamentos.add(listaFormaPagamento.get(i));
            }
        }
        return formaPagamentos;
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
