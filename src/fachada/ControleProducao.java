/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

/**
 *
 * @author Rafael
 */
public class ControleProducao {

    private int id, idProd, idOrigem, qnt;
    private String data, valor;

    public ControleProducao() {
    }

    public ControleProducao(int idProd, int idOrigem, int qnt, String data, String valor) {
        this.idProd = idProd;
        this.idOrigem = idOrigem;
        this.qnt = qnt;
        this.data = data;
        this.valor = valor;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDest() {
        return idOrigem;
    }

    public void setIdDest(int idDest) {
        this.idOrigem = idDest;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }
}
