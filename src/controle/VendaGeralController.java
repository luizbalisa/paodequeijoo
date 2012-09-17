/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.ProdutoVenda;
import fachada.ProdutoVendaGeral;
import fachada.StatusVenda;
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
    private StatusVenda statusVenda = new StatusVenda();
    ArrayList<ProdutoVendaGeral> pV = new ArrayList<ProdutoVendaGeral>();

    public VendaGeralController() {
    }

    public void armazenaVenda(VendaController v, String valorTotal) {
        Date data = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm");

        if (v.getVendaPrazo().getIdCliente() == 0) {
            venda.setIdCliente(0);//0 para venda dinheiro
            venda.setIdVendaPrazo(0);
        } else {

            venda.setIdCliente(v.getVendaPrazo().getIdCliente());
            venda.setIdVendaPrazo(v.getVendaPrazo().getIdVenda());
        }

        venda.setIdVenda(statusVenda.getIdStatus());
        venda.setIdFormaPagamento(v.getVendaPrazo().getIdFormaPagamento());
        venda.setData(format.format(data));
        venda.setHora(time.format(data));
        venda.setValor(valorTotal);

        incluirVendaGeral();
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

    public void list() {
        ConsultaVendaGeralMySQL vendaGeral = new ConsultaVendaGeralMySQL();

        for (int i = 0; i < listaProdVendaGeral.size(); i++) {
            p = new ProdutoVendaGeral();
            p.setIdProduto(listaProdVendaGeral.get(i).getProduto().getIdProduto());
            p.setQnt(listaProdVendaGeral.get(i).getQnt());
            p.setIdVendaGeral(vendaGeral.buscarID());
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
}
