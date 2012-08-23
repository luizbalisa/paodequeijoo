/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

/**
 *
 * @author Rafael
 */
public class Produto {

    private int idProduto;
    private String nome;
    private String preco_venda;
    private String preco_custo;
    private int quantidade;
    private int categoria;

    public Boolean getVisivel() {
        return visivel;
    }

    public void setVisivel(Boolean visivel) {
        this.visivel = visivel;
    }
    private Boolean visivel;

    public Produto() {
    }

    public Produto(String nome, String preco_venda, String preco_custo, int quantidade, int categoria) {
        this.nome = nome;
        this.preco_venda = preco_venda;
        this.preco_custo = preco_custo;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
