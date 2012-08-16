/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

/**
 *
 * @author Guil
 */
public class MovimentoCaixa {
    private int idMovimentoCaixa;
    private String Data;
    private int tipoPagamento;
    private String valor;

    public MovimentoCaixa() {
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public int getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(int tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public int getIdMovimentoCaixa() {
        return idMovimentoCaixa;
    }

    public void setIdMovimentoCaixa(int idMovimentoCaixa) {
        this.idMovimentoCaixa = idMovimentoCaixa;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
