/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.VendaGeral;
import java.util.ArrayList;
import persistencia.ConsultaVendaGeralMySQL;

/**
 *
 * @author HIGOR
 */
public class VendaGeralController {
    private VendaGeral venda = new VendaGeral();
    ArrayList<VendaGeral> listaVenda = new ArrayList<VendaGeral>();

    public VendaGeralController() {
    }

    public VendaGeral getVenda() {
        return venda;
    }

    public void setVenda(VendaGeral venda) {
        this.venda = venda;
    }

    public ArrayList<VendaGeral> getListaVenda() {
        return listaVenda;
    }

    public void setListaVenda(ArrayList<VendaGeral> listaVenda) {
        this.listaVenda = listaVenda;
    }
    
    public void incluirVendaGeral(){
        ConsultaVendaGeralMySQL vendaGeral = new ConsultaVendaGeralMySQL();
        vendaGeral.insertVenda(venda);
    }
    
    public void buscarVendaGeral(){
        ConsultaVendaGeralMySQL vendaGeral = new ConsultaVendaGeralMySQL();
        listaVenda = vendaGeral.buscarTodas();
    }
    
}
