/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.MovimentoCaixa;
import java.util.ArrayList;
import persistencia.ConsultaMovimentoCaixaMySQL;

/**
 *
 * @author Guil
 */
public class MovimentoDeCaixaController {

    private MovimentoCaixa movimento = new MovimentoCaixa();
    private ArrayList<MovimentoCaixa> listaMovimento = new ArrayList<MovimentoCaixa>();

    public void excluir(int id){
        ConsultaMovimentoCaixaMySQL c = new ConsultaMovimentoCaixaMySQL();
        c.excluirMovimento(id);
    }
    
    public void inserirNoCaixa() {
        ConsultaMovimentoCaixaMySQL consultaCaixa = new ConsultaMovimentoCaixaMySQL();
        consultaCaixa.cadastrarItemCaixa(movimento);
        movimento = new MovimentoCaixa();
    }

    public void buscarMovimento() {
        ConsultaMovimentoCaixaMySQL c = new ConsultaMovimentoCaixaMySQL();
        listaMovimento = c.buscarTodos();
    }

    public ArrayList<MovimentoCaixa> lista(String dataInicio, String dataFim, int tipo, int IO) {
        ArrayList<MovimentoCaixa> retorno = new ArrayList<MovimentoCaixa>();
        for (int i = 0; i < listaMovimento.size(); i++) {
            if (dataToInt(dataInicio) <= dataToInt(listaMovimento.get(i).getData())
                    && dataToInt(dataFim) >= dataToInt(listaMovimento.get(i).getData())
                    && (tipo == listaMovimento.get(i).getFormaPagamento() || tipo == 0)) {
                if (Double.parseDouble(listaMovimento.get(i).getValor().replace(",", ".")) > 0 && IO == 0) {
                    retorno.add(listaMovimento.get(i));
                } else if (Double.parseDouble(listaMovimento.get(i).getValor().replace(",", ".")) < 0 && IO == 1) {
                    retorno.add(listaMovimento.get(i));
                } else if (IO == -1) {
                    retorno.add(listaMovimento.get(i));
                }
            }
        }
        return retorno;
    }

    public ArrayList<MovimentoCaixa> getListaMovimento() {
        return listaMovimento;
    }

    public void setListaMovimento(ArrayList<MovimentoCaixa> listaMovimento) {
        this.listaMovimento = listaMovimento;
    }

    public MovimentoCaixa getMovimento() {
        return movimento;
    }

    public void setMovimento(MovimentoCaixa movimento) {
        this.movimento = movimento;
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
