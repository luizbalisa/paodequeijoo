/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.Produto;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class ProdutoController {

    Produto produto = new Produto();
    ArrayList<Produto> listProdutos = new ArrayList<Produto>();

    public ProdutoController() {
    }

    public ArrayList<Produto> getListProdutos() {
        return listProdutos;
    }

    public void setListProdutos(ArrayList<Produto> listProdutos) {
        this.listProdutos = listProdutos;
    }

    public Produto getProduto(int id) {
        return produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
