/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import java.util.ArrayList;

/**
 *
 * @author Guil
 */
public class VendaPrazo {
    
    private int idVenda, idCliente, idFormaPagamento, tipoPagamento;
    private String valor;
    private ArrayList<ProdutoVenda> listVenda = new ArrayList<ProdutoVenda>();
    
    public VendaPrazo() {
        listVenda = new ArrayList<ProdutoVenda>();
    }
    
    public int getTipoPagamento() {
        return tipoPagamento;
    }
    
    public void setTipoPagamento(int tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    
    public int getIdCliente() {
        return idCliente;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }
    
    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }
    
    public int getIdVenda() {
        return idVenda;
    }
    
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }
    
    public ArrayList<ProdutoVenda> getListVenda() {
        return listVenda;
    }
    
    public ArrayList<ProdutoVenda> getListVendaDatas() {
        ArrayList<String> datas = new ArrayList<String>();
        for (int i = 0; i < listVenda.size(); i++) {
            if (!datas.contains(listVenda.get(i).getData())) {
                datas.add(listVenda.get(i).getData());
            }
        }
        ArrayList<ProdutoVenda> retorno = new ArrayList<ProdutoVenda>();
        for (int i = 0; i < datas.size(); i++) {
            for (int j = 0; j < listVenda.size(); j++) {
                if (listVenda.get(j).getData().equals(datas.get(i))) {
                    boolean controle = true;
                    for (int k = 0; k < retorno.size(); k++) {
                        if (listVenda.get(j).getProduto().getIdProduto() == retorno.get(k).getProduto().getIdProduto()
                                && listVenda.get(j).getData().equals(retorno.get(k).getData())) {
                            retorno.get(k).setQnt(retorno.get(k).getQnt() + listVenda.get(j).getQnt());
                            controle = false;
                        }
                    }
                    if (controle) {
                        retorno.add(listVenda.get(j));
                    }
                }
            }
        }
        return retorno;
    }
    
    public void setListVenda(ArrayList<ProdutoVenda> listVenda) {
        this.listVenda = listVenda;
    }
    
    public String getValor() {
        return valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }
}
