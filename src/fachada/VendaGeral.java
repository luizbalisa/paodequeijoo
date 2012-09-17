/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import java.util.ArrayList;

/**
 *
 * @author HIGOR
 */
public class VendaGeral {
    
    private int idVenda, idFormaPagamento, idCliente, idVendaPrazo, idStatus;
    private String valor, data, hora;
    
    private ArrayList<ProdutoVendaGeral> listaProduto = new ArrayList<ProdutoVendaGeral>();

    public ArrayList<ProdutoVendaGeral> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(ArrayList<ProdutoVendaGeral> listaProduto) {
        this.listaProduto = listaProduto;
    }
    

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVendaPrazo() {
        return idVendaPrazo;
    }

    public void setIdVendaPrazo(int idVendaPrazo) {
        this.idVendaPrazo = idVendaPrazo;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public VendaGeral() {
    }
    
    public void setListVendaGeral(ArrayList<ProdutoVendaGeral> listVendaGeral) {
        this.listaProduto = listVendaGeral;
    }
    
}
