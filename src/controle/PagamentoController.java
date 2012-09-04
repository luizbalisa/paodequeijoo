/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.Pagamento;
import java.util.ArrayList;
import persistencia.ConsultaPagamentoMySQL;
import persistencia.ConsultaVendaPrazoMySQL;

/**
 *
 * @author Rafael
 */
public class PagamentoController {

    private Pagamento pagamento = new Pagamento();
    private ArrayList<Pagamento> listaPagamento = new ArrayList<Pagamento>();

    public PagamentoController() {
    }

    public double totalPagamento() {
        double total = 0;
        for (int i = 0; i < listaPagamento.size(); i++) {
            total += Double.parseDouble(listaPagamento.get(i).getValor().replace(",", "."));
        }
        return total;
    }

    public String cadastrarPagamento(String forma) {
        FormaDePagamentoController f = new FormaDePagamentoController();
        f.buscarFormaPagamento();
        MovimentoDeCaixaController c = new MovimentoDeCaixaController();
        c.getMovimento().setData(pagamento.getData());
        c.getMovimento().setFormaPagamento(f.getIdFormaPagamento(forma));
        c.getMovimento().setValor(pagamento.getValor());
        c.inserirNoCaixa();
        ConsultaPagamentoMySQL cp = new ConsultaPagamentoMySQL();
        return cp.cadastrarPagamento(pagamento);
    }
    
    public void darBaixa(){
        ConsultaVendaPrazoMySQL c = new ConsultaVendaPrazoMySQL();
        c.deleteVendaPrazo(pagamento.getIdVenda());
    }

    public void buscarPagamentos(int idVenda) {
        ConsultaPagamentoMySQL c = new ConsultaPagamentoMySQL();
        listaPagamento = c.bsucaPagamentos(idVenda);
    }

    public ArrayList<Pagamento> getListaPagamento() {
        return listaPagamento;
    }

    public void setListaPagamento(ArrayList<Pagamento> listaPagamento) {
        this.listaPagamento = listaPagamento;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
