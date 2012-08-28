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
    
    public ArrayList<HistoricoSaidaProduto> getHistoricoSaidaProduto(int idCategoria){
        ArrayList<HistoricoSaidaProduto> list = new ArrayList<HistoricoSaidaProduto>();
        for (int i = 0; i < this.listaHistorico.size(); i++) {
            if(this.listaHistorico.get(i).getIdCategoria() == idCategoria){
                list.add(this.listaHistorico.get(i));
            }
        }
        return list;
    }
    
    public ArrayList<HistoricoSaidaProduto> getHistoricoData(String dataDE, String dataATE){
        ArrayList<HistoricoSaidaProduto> list = new ArrayList<HistoricoSaidaProduto>();
        for (int i = 0; i < this.listaHistorico.size(); i++) {
            String d = this.listaHistorico.get(i).getData();
            if(dataToInt(d)>=dataToInt(dataDE) && dataToInt(d)<= dataToInt(dataATE)){
                list.add(this.listaHistorico.get(i));
            }
        }
        return list;
    }
    
    public ArrayList<HistoricoSaidaProduto> getHistoricoDia(String dia){
        ArrayList<HistoricoSaidaProduto> list = new ArrayList<HistoricoSaidaProduto>();
        for (int i = 0; i < this.listaHistorico.size(); i++) {
            if(dataToInt(this.listaHistorico.get(i).getData()) == dataToInt(dia)){
                list.add(this.listaHistorico.get(i));
            }
        }
        return list;
    }
}
