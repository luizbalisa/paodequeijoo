/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.Cliente;
import fachada.ProdutoVenda;
import fachada.VendaPrazo;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import persistencia.ConsultaListaProdutoVendaMySQL;
import persistencia.ConsultaVendaPrazoMySQL;
import persistencia.ConsultaClienteMySQL;

/**
 *
 * @author Guil
 */
public class VendaController {

    private VendaPrazo venda = new VendaPrazo();
    private ArrayList<VendaPrazo> listaVenda = new ArrayList<VendaPrazo>();
    private HashMap<Integer, String> clientes = new HashMap<Integer, String>();

    public VendaController() {
    }

    public void excluir(int id) {
        ConsultaVendaPrazoMySQL c = new ConsultaVendaPrazoMySQL();
        c.deleteVendaPrazo(id);
    }

    public void estornar(int idVenda, int idProd, String data) {
        ConsultaListaProdutoVendaMySQL c = new ConsultaListaProdutoVendaMySQL();
        c.updateEstorno(idVenda, idProd, data);
    }

    public void novoValor(String valor, int id) {
        ConsultaVendaPrazoMySQL c = new ConsultaVendaPrazoMySQL();
        c.updateVendaPrazoEstorno(valor, id);
    }

    public void buscaVendas() {
        listaVenda = new ArrayList<VendaPrazo>();
        ConsultaVendaPrazoMySQL vendas = new ConsultaVendaPrazoMySQL();
        listaVenda = vendas.buscarTodas();
        ConsultaClienteMySQL c = new ConsultaClienteMySQL();
        for (int i = 0; i < listaVenda.size(); i++) {
            clientes.put(listaVenda.get(i).getIdCliente(), c.buscarClienteId(listaVenda.get(i).getIdCliente()).getNome());
        }
    }

    public void buscaVendaPrazo(int id) {
        buscaVendas();
        for (int i = 0; i < listaVenda.size(); i++) {
            if (listaVenda.get(i).getIdVenda() == id) {
                venda = new VendaPrazo();
                venda = listaVenda.get(i);
                break;
            }
        }
    }

    public void excluirProdutoVenda(int id, int qnt) {
        for (int i = 0; i < venda.getListVenda().size(); i++) {
            if (id == venda.getListVenda().get(i).getProduto().getIdProduto() && qnt == venda.getListVenda().get(i).getQnt()) {
                venda.getListVenda().remove(i);
            }
        }
    }

    public void editarProdutoVenda(ProdutoVenda p, ProdutoVenda p2) {
        for (int i = 0; i < venda.getListVenda().size(); i++) {
            if (p.getProduto().getIdProduto() == venda.getListVenda().get(i).getProduto().getIdProduto() && p.getQnt() == venda.getListVenda().get(i).getQnt()) {
                venda.getListVenda().remove(i);
                venda.getListVenda().add(i, p2);
            }
        }
    }

    public void inserirVendaPrazo() {
        ConsultaVendaPrazoMySQL vendaP = new ConsultaVendaPrazoMySQL();
        String banco = vendaP.bsucaCliente(venda.getIdCliente());
        if (banco != null) {
            String aux[] = banco.split(" ");
            String valor = aux[0];
            int id = Integer.parseInt(aux[1]);
            venda.setValor(String.valueOf(Double.parseDouble(valor.replace(",", ".")) + Double.parseDouble(venda.getValor().replace(",", "."))));
            venda.setIdVenda(id);
            vendaP.updateVendaPrazo(venda);
        } else {
            vendaP.insertVendaPrazo(venda);
            venda.setIdVenda(vendaP.buscarID());
        }
    }

    public void inserirProdutoVenda() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        ProdutoController p = new ProdutoController();
        Date data = new Date();
        ConsultaListaProdutoVendaMySQL ProdutoV = new ConsultaListaProdutoVendaMySQL();
        ArrayList<Integer> excluidos = new ArrayList<Integer>();
        for (int i = 0; i < venda.getListVenda().size(); i++) {
            if (!excluidos.contains(i)) {
                for (int j = 0; j < venda.getListVenda().size(); j++) {
                    if (i != j && venda.getListVenda().get(i).getProduto().getIdProduto() == venda.getListVenda().get(j).getProduto().getIdProduto()) {
                        venda.getListVenda().get(i).setQnt(venda.getListVenda().get(i).getQnt() + venda.getListVenda().get(j).getQnt());
                        venda.getListVenda().get(i).setValor(String.valueOf(venda.getListVenda().get(i).getQnt() * Double.parseDouble(venda.getListVenda().get(i).getProduto().getPreco().replace(",", "."))));
                        excluidos.add(j);
                    }
                }
            }
        }
        for (int i = 0; i < venda.getListVenda().size(); i++) {
            if (!excluidos.contains(i)) {
                venda.getListVenda().get(i).setData(format.format(data));
                ProdutoV.insertProdutoVendaPrazo(venda.getIdVenda(), venda.getListVenda().get(i));
            }
        }
    }

    public ArrayList<VendaPrazo> buscaDinamicaClientes(String busca) {
        String desc2 = busca;
        desc2 = Normalizer.normalize(desc2, Normalizer.Form.NFD);
        desc2 = desc2.replaceAll("[^\\p{ASCII}]", "");
        desc2 = desc2.toUpperCase();
        ArrayList<VendaPrazo> vendas = new ArrayList<VendaPrazo>();
        for (int i = 0; i < listaVenda.size(); i++) {
            String comp = clientes.get(listaVenda.get(i).getIdCliente());
            comp = Normalizer.normalize(comp, Normalizer.Form.NFD);
            comp = comp.replaceAll("[^\\p{ASCII}]", "");
            comp = comp.toUpperCase();
            if (comp.contains(desc2)) {
                vendas.add(listaVenda.get(i));
            }
        }
        return vendas;
    }

    public HashMap<Integer, String> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<Integer, String> clientes) {
        this.clientes = clientes;
    }

    public VendaPrazo getVendaPrazo() {
        return venda;
    }

    public void setVendaPrazo(VendaPrazo venda) {
        this.venda = venda;
    }

    public ArrayList<VendaPrazo> getListaVenda() {
        return listaVenda;
    }

    public void setListaVenda(ArrayList<VendaPrazo> listaVenda) {
        this.listaVenda = listaVenda;
    }
}
