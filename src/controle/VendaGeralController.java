/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.*;
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
        return retorno;
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
}
