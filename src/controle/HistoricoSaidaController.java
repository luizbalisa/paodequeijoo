/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.HistoricoSaidaProduto;
import java.util.ArrayList;

/**
 *
 * @author Guil
 */
public class HistoricoSaidaController {
    private HistoricoSaidaProduto historico = new HistoricoSaidaProduto();
    private ArrayList<HistoricoSaidaProduto> listaHistorico = new ArrayList<HistoricoSaidaProduto>();

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
