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
    private String[] colunasMes;

    public HistoricoSaidaController() {
    }

    public void buscarHistorico() {
        ConsultaHistoricoMySQL c = new ConsultaHistoricoMySQL();
        listaHistorico = c.buscarHistoricos();
    }

    public ArrayList<String[]> colunasHistoricoMes(int mes, int ano) {
        ArrayList<String> r = new ArrayList<String>();
        String m = String.valueOf(mes);
        if (m.length() < 2) {
            m = "0" + m;
        }
        String inicio = ano + "" + m + "00";
        String fim = ano + "" + m + "32";
        int begin = Integer.parseInt(inicio);
        int end = Integer.parseInt(fim);
        for (int i = 0; i < listaHistorico.size(); i++) {
            int data = dataToInt(listaHistorico.get(i).getData());
            if (data > begin && data < end) {
                String aux = listaHistorico.get(i).getData().substring(0, 5);
                if (!r.contains(aux)) {
                    r.add(aux);
                }
            }
        }
        colunasMes = new String[r.size() + 3];
        colunasMes[0] = "Produto";
        for (int i = 0; i < r.size(); i++) {
            colunasMes[i + 1] = r.get(i);
        }
        colunasMes[colunasMes.length - 2] = "Total";
        colunasMes[colunasMes.length - 1] = "Receita";
        ProdutoController prod = new ProdutoController();
        prod.buscarProdutos();
        ArrayList<String[]> lista = new ArrayList<String[]>();
        for (int i = 0; i < prod.getListProdutos().size(); i++) {
            String[] linha = new String[colunasMes.length];
            linha[0] = prod.getListProdutos().get(i).getNome();
            for (int j = 1; j < colunasMes.length ; j++) {
                int qnt = 0;
                for (int k = 0; k < listaHistorico.size(); k++) {
                    if (listaHistorico.get(k).getData().contains(colunasMes[j])&& listaHistorico.get(k).getIdProduto()==prod.getListProdutos().get(i).getIdProduto()) {
                        qnt += listaHistorico.get(k).getQuantidade();
                        break;
                    }
                }
                linha[j] = String.valueOf(qnt);
            }
            lista.add(linha);
        }
        return lista;
    }

    public int dataToInt(String data) {
        String aux[] = data.split("/");
        String date = aux[2] + aux[1] + aux[0];
        return Integer.parseInt(date);
    }

    public String[] getColunasMes() {
        return colunasMes;
    }

    public void setColunasMes(String[] colunasMes) {
        this.colunasMes = colunasMes;
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
