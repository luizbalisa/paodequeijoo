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

    public void inserirNoCaixa() {
        ConsultaMovimentoCaixaMySQL consultaCaixa = new ConsultaMovimentoCaixaMySQL();
        String buscaValor = consultaCaixa.buscarItemCaixaIguais(movimento);

        if (buscaValor.isEmpty()) {
            consultaCaixa.cadastrarItemCaixa(movimento);
            movimento = new MovimentoCaixa();
        } else {
            String valor = String.valueOf(Double.parseDouble(movimento.getValor().replace(",", ".")) + Double.parseDouble(buscaValor.replace(",", ".")));
            movimento.setValor(valor);
            consultaCaixa.updateListaProdutoVendaIguais(movimento);
        }
    }

    public MovimentoCaixa getMovimento() {
        return movimento;
    }

    public void setMovimento(MovimentoCaixa movimento) {
        this.movimento = movimento;
    }
    
}
