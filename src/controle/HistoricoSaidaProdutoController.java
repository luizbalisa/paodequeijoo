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
public class HistoricoSaidaProdutoController {

    private HistoricoSaidaProduto historico = new HistoricoSaidaProduto();
    private ArrayList<HistoricoSaidaProduto> listaHistorico = new ArrayList<HistoricoSaidaProduto>();
    private String[] colunasMes;
    private ArrayList<String[]> listaMes;
    private ArrayList<HistoricoSaidaProduto> listaDatas;
    private ValidadorCampos validar = new ValidadorCampos();

    public HistoricoSaidaProdutoController() {
    }

    public void buscarHistorico() {
        ConsultaHistoricoMySQL c = new ConsultaHistoricoMySQL();
        listaHistorico = c.buscarHistoricos();
    }

    public void buscarHistoricoSomadoDia(String data) {
        ConsultaHistoricoMySQL c = new ConsultaHistoricoMySQL();
        listaHistorico = c.buscarHistoricos();
        for (int i = 0; i < listaHistorico.size(); i++) {
            for (int j = i + 1; j < listaHistorico.size(); j++) {
                if (dataToInt(listaHistorico.get(i).getData())== dataToInt(data) && dataToInt(listaHistorico.get(j).getData()) == dataToInt(data)) {
                    if (listaHistorico.get(i).getIdProduto() == listaHistorico.get(j).getIdProduto()) {
                        listaHistorico.get(i).setQuantidade(listaHistorico.get(i).getQuantidade() + listaHistorico.get(j).getQuantidade());
                        listaHistorico.add(listaHistorico.get(i));
                        listaHistorico.remove(j);
                        listaHistorico.remove(i);
                    }
                }

            }
        }
    }
    public void buscarHistoricoSomadoPeriodo(String dataDe, String dataAte) {
        ConsultaHistoricoMySQL c = new ConsultaHistoricoMySQL();
        listaHistorico = c.buscarHistoricos();
        for (int i = 0; i < listaHistorico.size(); i++) {
            for (int j = i + 1; j < listaHistorico.size(); j++) {
                if ((dataToInt(listaHistorico.get(i).getData()) >= dataToInt(dataDe)) && (dataToInt(listaHistorico.get(i).getData()))<= dataToInt(dataAte)  &&(dataToInt(listaHistorico.get(j).getData()) >= dataToInt(dataDe)) && (dataToInt(listaHistorico.get(j).getData()))<= dataToInt(dataAte)) {
                    if (listaHistorico.get(i).getIdProduto() == listaHistorico.get(j).getIdProduto()) {
                        listaHistorico.get(i).setQuantidade(listaHistorico.get(i).getQuantidade() + listaHistorico.get(j).getQuantidade());
                        listaHistorico.add(listaHistorico.get(i));
                        listaHistorico.remove(j);
                        listaHistorico.remove(i);
                    }
                }

            }
        }
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

    public ArrayList<HistoricoSaidaProduto> buscaDimamicaData(String busca) {
        String desc2 = busca;
        desc2 = Normalizer.normalize(desc2, Normalizer.Form.NFD);
        desc2 = desc2.replaceAll("[^\\p{ASCII}]", "");
        desc2 = desc2.toUpperCase();
        ProdutoController p = new ProdutoController();
        p.buscarProdutosTotal();
        ArrayList<HistoricoSaidaProduto> retorno = new ArrayList<HistoricoSaidaProduto>();
        for (int i = 0; i < listaDatas.size(); i++) {
            p.getProduto(listaDatas.get(i).getIdProduto());
            String comp = p.getProduto().getNome();
            comp = Normalizer.normalize(comp, Normalizer.Form.NFD);
            comp = comp.replaceAll("[^\\p{ASCII}]", "");
            comp = comp.toUpperCase();
            if (comp.contains(desc2)) {
                retorno.add(listaDatas.get(i));
            }
        }
        return retorno;
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

    public void getHistoricoDia(String dia, int categoria) {
        listaDatas = new ArrayList<HistoricoSaidaProduto>();
        if (categoria == -1) {//TODOS
            for (int i = 0; i < this.listaHistorico.size(); i++) {
                if (dataToInt(this.listaHistorico.get(i).getData()) == dataToInt(dia)) {
                    listaDatas.add(this.listaHistorico.get(i));
                }
            }
        } else if (categoria == 0) {//PRODUZIDO
            for (int i = 0; i < this.listaHistorico.size(); i++) {
                int c = this.listaHistorico.get(i).getIdCategoria();
                if (dataToInt(this.listaHistorico.get(i).getData()) == dataToInt(dia)) {
                    if (c == 0) {
                        listaDatas.add(this.listaHistorico.get(i));
                    }
                }
            }
        } else if (categoria == 1) {//ATACADO
            for (int i = 0; i < this.listaHistorico.size(); i++) {
                int c = this.listaHistorico.get(i).getIdCategoria();
                if (dataToInt(this.listaHistorico.get(i).getData()) == dataToInt(dia)) {
                    if (c == 1) {
                        listaDatas.add(this.listaHistorico.get(i));
                    }
                }
            }
        }

    }

    public ArrayList<HistoricoSaidaProduto> getHistoricoSaidaProduto(int idCategoria) {
        ArrayList<HistoricoSaidaProduto> list = new ArrayList<HistoricoSaidaProduto>();
        for (int i = 0; i < this.listaHistorico.size(); i++) {
            if (this.listaHistorico.get(i).getIdCategoria() == idCategoria) {
                list.add(this.listaHistorico.get(i));
            }
        }
        return list;
    }

    public void getHistoricoData(String dataDE, String dataATE, int categoria) {
        listaDatas = new ArrayList<HistoricoSaidaProduto>();
        if (categoria == -1) {//TODOS
            for (int i = 0; i < this.listaHistorico.size(); i++) {
                String d = this.listaHistorico.get(i).getData();
                if (dataToInt(d) >= dataToInt(dataDE) && dataToInt(d) <= dataToInt(dataATE)) {
                    for (int j = 0; j < listaDatas.size(); j++) {
                    }
                    listaDatas.add(this.listaHistorico.get(i));
                }
            }
        } else if (categoria == 0) {//ATACADO
            for (int i = 0; i < this.listaHistorico.size(); i++) {
                String d = this.listaHistorico.get(i).getData();
                int c = this.listaHistorico.get(i).getIdCategoria();
                if (dataToInt(d) >= dataToInt(dataDE) && dataToInt(d) <= dataToInt(dataATE)) {
                    if (c == 0) {
                        listaDatas.add(this.listaHistorico.get(i));
                    }
                }
            }
        } else if (categoria == 1) {//ATACADO
            for (int i = 0; i < this.listaHistorico.size(); i++) {
                String d = this.listaHistorico.get(i).getData();
                int c = this.listaHistorico.get(i).getIdCategoria();
                if (dataToInt(d) >= dataToInt(dataDE) && dataToInt(d) <= dataToInt(dataATE)) {
                    if (c == 1) {
                        listaDatas.add(this.listaHistorico.get(i));
                    }
                }
            }
        }
    }

    public ArrayList<HistoricoSaidaProduto> getListaDatas() {
        return listaDatas;
    }

    public void setListaDatas(ArrayList<HistoricoSaidaProduto> listaDatas) {
        this.listaDatas = listaDatas;
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
}
