/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import controle.ProdutoController;

/**
 *
 * @author miserani
 */
public class HistoricoSaidaProduto {
    
    private int idHistoricoSaidaProcuto;
    private int idProduto;
    private String data;
    private int quantidade;
    private String preco_custo;
    private String preco_venda;
    private int idCategoria;

    public int getIdHistoricoSaidaProcuto() {
        return idHistoricoSaidaProcuto;
    }

    public void setIdHistoricoSaidaProcuto(int idHistoricoSaidaProcuto) {
        this.idHistoricoSaidaProcuto = idHistoricoSaidaProcuto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(String preco_custo) {
        this.preco_custo = preco_custo;
    }

    public String getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(String preco_venda) {
        this.preco_venda = preco_venda;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public void setIdCategoria(){
        ProdutoController p = new ProdutoController();
        p.buscarProdutos();
        p.getProduto(idProduto);
        idCategoria = p.getProduto().getCategoria();
    }
    
    
}
