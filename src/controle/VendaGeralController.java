/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.ContasPagar;
import fachada.ProdutoVenda;
import fachada.ProdutoVendaGeral;
import fachada.VendaGeral;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import persistencia.ConsultaListaProdutoMYSQL;
import persistencia.ConsultaVendaGeralMySQL;

/**
 *
 * @author HIGOR
 */
public class VendaGeralController {

    ArrayList<ProdutoVenda> listaProdVendaGeral = new ArrayList<ProdutoVenda>();
    ProdutoVendaGeral p;
    private VendaGeral venda = new VendaGeral();
    ArrayList<ProdutoVendaGeral> pV = new ArrayList<ProdutoVendaGeral>();
    private ArrayList<VendaGeral> listaVenda = new ArrayList<VendaGeral>();

    public VendaGeralController() {
    }

    public String estornarVenda() {
        HistoricoSaidaProdutoController hist = new HistoricoSaidaProdutoController();
        ProdutoController prod = new ProdutoController();
        MovimentoDeCaixaController mov = new MovimentoDeCaixaController();
        VendaController vendaPrazo = new VendaController();

        ArrayList<int[]> prods = buscaProdutos();
        for (int i = 0; i < prods.size(); i++) {
            prod.estornar(prods.get(i)[0], prods.get(i)[1]);
            hist.estornar(prods.get(i)[1], prods.get(i)[0], venda.getData());
        }
        if (venda.getIdVendaPrazo() != 0) {
            vendaPrazo.buscaVendaPrazo(venda.getIdVendaPrazo());
            for (int i = 0; i < prods.size(); i++) {
                vendaPrazo.estornar(venda.getIdVendaPrazo(), prods.get(i)[0], venda.getData());
            }
            vendaPrazo.buscaVendaPrazo(venda.getIdVendaPrazo());
            double novoValor = 0;
            ArrayList<ProdutoVenda> prodVenda = vendaPrazo.getVendaPrazo().getListVendaDatas();
            if (!prodVenda.isEmpty()) {
                for (int i = 0; i < prodVenda.size(); i++) {
                    novoValor += prodVenda.get(i).getQnt() * Double.parseDouble(prodVenda.get(i).getValor().replace(",", "."));
                }
                vendaPrazo.novoValor(String.valueOf(novoValor), venda.getIdVendaPrazo());
            } else {
                vendaPrazo.excluir(venda.getIdVendaPrazo());
            }
        } else {
            mov.buscarMovimento();
            for (int i = 0; i < mov.getListaMovimento().size(); i++) {
                if (mov.getListaMovimento().get(i).getData().equals(venda.getData())
                        && mov.getListaMovimento().get(i).getFormaPagamento() == venda.getIdFormaPagamento()
                        && Double.parseDouble(mov.getListaMovimento().get(i).getValor().replace(",", ".")) == Double.parseDouble(venda.getValor().replace(",", "."))) {
                    mov.excluir(mov.getListaMovimento().get(i).getIdMovimentoCaixa());
                    break;
                }
            }
        }
        venda.setIdStatus(3);
        ConsultaVendaGeralMySQL c = new ConsultaVendaGeralMySQL();
        c.updateVenda(venda);
        return "Estorno realizado com sucesso.";
    }

    public ArrayList<int[]> buscaProdutos() {
        ConsultaVendaGeralMySQL c = new ConsultaVendaGeralMySQL();
        return c.buscarProdutos(venda.getIdVenda());
    }

    public void buscarVendasID(int id) {
        ConsultaVendaGeralMySQL c = new ConsultaVendaGeralMySQL();
        venda = c.buscarVenda(id);
    }

    public void buscarVendas() {
        ConsultaVendaGeralMySQL c = new ConsultaVendaGeralMySQL();
        listaVenda = c.buscarTodas();
    }

    public void armazenaVenda(VendaController v, String valorTotal) {
        Date data = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");

        if (v.getVendaPrazo().getIdCliente() == 0) {
            venda.setIdCliente(0);//0 para venda dinheiro
            venda.setIdVendaPrazo(0);
        } else {

            venda.setIdCliente(v.getVendaPrazo().getIdCliente());
            venda.setIdVendaPrazo(v.getVendaPrazo().getIdVenda());
        }

        venda.setIdFormaPagamento(v.getVendaPrazo().getIdFormaPagamento());
        venda.setData(format.format(data));
        venda.setHora(time.format(data));
        venda.setValor(valorTotal);

        incluirVendaGeral();
        ConsultaVendaGeralMySQL vendaGeral = new ConsultaVendaGeralMySQL();
        venda.setIdVenda(vendaGeral.buscarID());

        list();
        insetList();
    }

    public VendaGeral getVenda() {
        return venda;
    }

    public void setVenda(VendaGeral venda) {
        this.venda = venda;
    }

    public void incluirVendaGeral() {
        ConsultaVendaGeralMySQL vendaGeral = new ConsultaVendaGeralMySQL();
        vendaGeral.insertVenda(venda);

    }

    public void setListaProdVendaGeral(ArrayList<ProdutoVenda> listaProdVendaGeral) {
        this.listaProdVendaGeral = listaProdVendaGeral;
    }

    public ArrayList<VendaGeral> lista(String dataInicio, String dataFim, int tipo) {
        ArrayList<VendaGeral> retorno = new ArrayList<VendaGeral>();
        for (int i = 0; i < listaVenda.size(); i++) {
            if (dataToInt(dataInicio) <= dataToInt(listaVenda.get(i).getData())
                    && dataToInt(dataFim) >= dataToInt(listaVenda.get(i).getData())
                    && (tipo == listaVenda.get(i).getIdFormaPagamento() || tipo == 0)) {
                retorno.add(listaVenda.get(i));
            }
        }
        return ordenar(retorno);
    }

    public void list() {
        for (int i = 0; i < listaProdVendaGeral.size(); i++) {
            p = new ProdutoVendaGeral();
            p.setIdProduto(listaProdVendaGeral.get(i).getProduto().getIdProduto());
            p.setQnt(listaProdVendaGeral.get(i).getQnt());
            p.setIdVendaGeral(venda.getIdVenda());
            pV.add(p);
        }
        venda.setListaProduto(pV);
    }

    public void insetList() {
        ConsultaListaProdutoMYSQL c = new ConsultaListaProdutoMYSQL();
        for (int i = 0; i < pV.size(); i++) {
            c.insertProdutoVendaGeral(venda.getListaProduto().get(i).getIdVendaGeral(), venda.getListaProduto().get(i).getIdProduto(), venda.getListaProduto().get(i).getQnt());
        }
    }

    public ArrayList<VendaGeral> getListaVenda() {
        return listaVenda;
    }

    public void setListaVenda(ArrayList<VendaGeral> listaVenda) {
        this.listaVenda = listaVenda;
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
    public ArrayList<VendaGeral> ordenar(ArrayList<VendaGeral> lista) {
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
                    VendaGeral c = lista.get(i + 1);
                    lista.set(i + 1, lista.get(i));
                    lista.set(i, c);
                    houveTroca = true;
                }
            }
        }
        return lista;
    }
}
