/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.Cliente;
import fachada.HistoricoSaidaProduto;
import java.text.Normalizer;
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
    private ArrayList<String[]> listaMes;

    public HistoricoSaidaController() {
    }

    public void buscarHistorico() {
        ConsultaHistoricoMySQL c = new ConsultaHistoricoMySQL();
        listaHistorico = c.buscarHistoricos();
    }

    public void colunasHistoricoMes(int mes, int ano, int categoria) {
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
        listaMes = new ArrayList<String[]>();
        colunasMes = new String[r.size() + 3];
        colunasMes[0] = "Produto";
        for (int i = 0; i < r.size(); i++) {
            colunasMes[i + 1] = r.get(i);
        }
        colunasMes[colunasMes.length - 2] = "Total";
        colunasMes[colunasMes.length - 1] = "Receita";
        if (r.size() > 0) {
            ProdutoController prod = new ProdutoController();
            prod.buscarProdutosHist();
            for (int i = 0; i < prod.getListProdutos().size(); i++) {
                if (categoria == -1 || categoria == prod.getListProdutos().get(i).getCategoria()) {
                    String[] linha;
                    linha = new String[colunasMes.length];
                    linha[0] = prod.getListProdutos().get(i).getNome();
                    int total = 0;
                    double valor = 0;
                    for (int j = 1; j < colunasMes.length; j++) {
                        int qnt = 0;
                        for (int k = 0; k < listaHistorico.size(); k++) {
                            if (listaHistorico.get(k).getData().contains(colunasMes[j]) && listaHistorico.get(k).getIdProduto() == prod.getListProdutos().get(i).getIdProduto()) {
                                qnt += listaHistorico.get(k).getQuantidade();
                                valor += Double.parseDouble(listaHistorico.get(k).getPreco_venda().replace(",", ".")) * qnt;
                                break;
                            }
                        }
                        total += qnt;
                        linha[j] = String.valueOf(qnt);
                    }
                    linha[colunasMes.length - 2] = String.valueOf(total);
                    linha[colunasMes.length - 1] = String.valueOf(valor);
                    listaMes.add(linha);
                }
            }
        }
    }

    public ArrayList<String[]> buscaDinamicaMes(String busca) {
        String desc2 = busca;
        desc2 = Normalizer.normalize(desc2, Normalizer.Form.NFD);
        desc2 = desc2.replaceAll("[^\\p{ASCII}]", "");
        desc2 = desc2.toUpperCase();
        ArrayList<String[]> retorno = new ArrayList<String[]>();
        for (int i = 0; i < listaMes.size(); i++) {
            String comp = listaMes.get(i)[0];
            comp = Normalizer.normalize(comp, Normalizer.Form.NFD);
            comp = comp.replaceAll("[^\\p{ASCII}]", "");
            comp = comp.toUpperCase();
            if (comp.contains(desc2)) {
                retorno.add(listaMes.get(i));
            }
        }
        return retorno;
    }

    public int dataToInt(String data) {
        String aux[] = data.split("/");
        String date = aux[2] + aux[1] + aux[0];
        return Integer.parseInt(date);
    }

    public ArrayList<String[]> getListaMes() {
        return listaMes;
    }

    public void setListaMes(ArrayList<String[]> listaMes) {
        this.listaMes = listaMes;
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

    public ArrayList<HistoricoSaidaProduto> getHistoricoSaidaProduto(int idCategoria) {
        ArrayList<HistoricoSaidaProduto> list = new ArrayList<HistoricoSaidaProduto>();
        for (int i = 0; i < this.listaHistorico.size(); i++) {
            if (this.listaHistorico.get(i).getIdCategoria() == idCategoria) {
                list.add(this.listaHistorico.get(i));
            }else if(idCategoria == -1){
                list.add(this.listaHistorico.get(i));
            }
        }
        return list;
    }

    public ArrayList<HistoricoSaidaProduto> getHistoricoData(String dataDE, String dataATE, int idCategoria) {
        ArrayList<HistoricoSaidaProduto> list = new ArrayList<HistoricoSaidaProduto>();
        for (int i = 0; i < this.listaHistorico.size(); i++) {
            String d = this.listaHistorico.get(i).getData();
            if (dataToInt(d) >= dataToInt(dataDE) && dataToInt(d) <= dataToInt(dataATE)) {
                if (this.listaHistorico.get(i).getIdCategoria() == idCategoria) {
                    list.add(this.listaHistorico.get(i));
                }else if(idCategoria == -1){
                    list.add(this.listaHistorico.get(i));
                }
            }
        }
        return list;
    }

    public ArrayList<HistoricoSaidaProduto> getHistoricoDia(String dia, int idCategoria) {
        ArrayList<HistoricoSaidaProduto> list = new ArrayList<HistoricoSaidaProduto>();
        for (int i = 0; i < this.listaHistorico.size(); i++) {
            if (dataToInt(this.listaHistorico.get(i).getData()) == dataToInt(dia)) {
                if (idCategoria == this.listaHistorico.get(i).getIdCategoria()) {
                    list.add(this.listaHistorico.get(i));
                } else if(idCategoria == -1){
                    list.add(this.listaHistorico.get(i));
                }
            }
        }
        return list;
    }
}
