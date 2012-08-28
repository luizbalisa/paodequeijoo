/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.HistoricoSaidaProduto;
import java.util.ArrayList;
import persistencia.ConsultaHistoricoMySQL;

/**
 *
 * @author Guil
 */
public class HistoricoSaidaController {

    private HistoricoSaidaProduto historico = new HistoricoSaidaProduto();
    private ArrayList<HistoricoSaidaProduto> listaHistorico = new ArrayList<HistoricoSaidaProduto>();

    public HistoricoSaidaController() {
    }

    public void buscarHistorico() {
        ConsultaHistoricoMySQL c = new ConsultaHistoricoMySQL();
        listaHistorico = c.buscarHistoricos();
    }

    public int dataToInt(String data) {
        String aux[] = data.split("/");
        String date = aux[2] + aux[1] + aux[0];
        return Integer.parseInt(date);
    }

    public HistoricoSaidaProduto getHistorico() {
        return historico;
    }

    public void setHistorico(HistoricoSaidaProduto historico) {
        this.historico = historico;
    }

    public ArrayList<HistoricoSaidaProduto> getListaHistorico() {
        return listaHistorico;
    }

    public void setListaHistorico(ArrayList<HistoricoSaidaProduto> listaHistorico) {
        this.listaHistorico = listaHistorico;
    }
}
