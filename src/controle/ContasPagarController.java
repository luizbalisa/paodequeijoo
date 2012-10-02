/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.ContasPagar;
import fachada.Fornecedor;
import fachada.MovimentoCaixa;
import fachada.Produto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import persistencia.ConsultaContasPagarMySQL;
import persistencia.ConsultaMovimentoCaixaMySQL;
import persistencia.ConsultaProdutoMySQL;

/**
 *
 * @author Rafael
 */
public class ContasPagarController {

    private ContasPagar conta = new ContasPagar();
    private ArrayList<ContasPagar> lista = new ArrayList<ContasPagar>();

    public ContasPagarController() {
    }

    public String lancar() {
        ConsultaMovimentoCaixaMySQL cm = new ConsultaMovimentoCaixaMySQL();
        if (conta.getStatus() == 1) {
            MovimentoCaixa m = new MovimentoCaixa();
            m.setData(conta.getData());
            m.setDescricao("Pagamento p/ " + conta.getDescricao());
            m.setFormaPagamento(conta.getTipo());
            m.setValor("-" + conta.getValor());
            cm.cadastrarItemCaixa(m);
        }
        conta.cadastrar();
        return "Lançamento efetuado com sucesso.";
    }
    
    public void buscar() {
        ConsultaContasPagarMySQL c = new ConsultaContasPagarMySQL();
        lista = c.buscar();
    }

    public void darBaixa(int id) {
        getConta(id);
        conta.darBaixa(id);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ConsultaMovimentoCaixaMySQL cm = new ConsultaMovimentoCaixaMySQL();
        MovimentoCaixa m = new MovimentoCaixa();
        m.setData(sdf.format(new Date()));
        m.setDescricao("Pagamento p/ " + conta.getDescricao());
        m.setFormaPagamento(conta.getTipo());
        m.setValor("-" + conta.getValor());
        cm.cadastrarItemCaixa(m);
    }

    public ArrayList<ContasPagar> lista(String dataInicio, String dataFim, int tipo, int status) {
        ArrayList<ContasPagar> retorno = new ArrayList<ContasPagar>();
        for (int i = 0; i < lista.size(); i++) {
            if (dataToInt(dataInicio) <= dataToInt(lista.get(i).getData())
                    && dataToInt(dataFim) >= dataToInt(lista.get(i).getData())
                    && (tipo == lista.get(i).getTipo() || tipo == 0)) {
                if (lista.get(i).getStatus() == 0 && status == 1) {
                    retorno.add(lista.get(i));
                } else if (lista.get(i).getStatus() == 1 && status == 0) {
                    retorno.add(lista.get(i));
                } else if (status == -1) {
                    retorno.add(lista.get(i));
                }
            }
        }
        return ordenar(retorno);
    }

    public ContasPagar getConta() {
        return conta;
    }

    public void setConta(ContasPagar conta) {
        this.conta = conta;
    }

    public ArrayList<ContasPagar> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ContasPagar> lista) {
        this.lista = lista;
    }

    public void getConta(int id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdcontas() == id) {
                conta = lista.get(i);
                break;
            }
        }
    }

    public ArrayList<ContasPagar> ordenar(ArrayList<ContasPagar> lista) {
        ArrayList<Integer> datas = new ArrayList<Integer>();
        for (int i = 0; i < lista.size(); i++) {
            datas.add(dataToInt(lista.get(i).getData()));
        }
        boolean houveTroca = true;
        while (houveTroca) {
            houveTroca = false;
            for (int i = 0; i < datas.size() - 1; i++) {
                if (datas.get(i) < datas.get(i + 1)) {
                    int variavelAuxiliar = datas.get(i + 1);
                    datas.set(i + 1, datas.get(i));
                    datas.set(i, variavelAuxiliar);
                    ContasPagar c = lista.get(i + 1);
                    lista.set(i + 1, lista.get(i));
                    lista.set(i, c);
                    houveTroca = true;
                }
            }
        }
        return lista;
    }

    public int dataToInt(String data) {
        String aux[] = data.split("/");
        String d = String.valueOf(aux[0]);
        String m = String.valueOf(aux[1]);
        if (d.length() < 2) {
            d = "0" + d;
        }
        if (m.length() < 2) {
            m = "0" + m;
        }
        String date = aux[2] + m + d;
        return Integer.parseInt(date);
    }
}
