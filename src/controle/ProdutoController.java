/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.Produto;
import java.util.ArrayList;
import persistencia.ConsultasProdutoMySQL;

/**
 *
 * @author Rafael
 */
public class ProdutoController {

    Produto produto = new Produto();
    ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

    public ProdutoController() {
    }

    public String cadastrar() {
        ConsultasProdutoMySQL consultaProdutoMySQL = new ConsultasProdutoMySQL();
        return consultaProdutoMySQL.cadastrarProduto(produto);
    }

    public String editar() {
        ConsultasProdutoMySQL consultaProdutoMySQL = new ConsultasProdutoMySQL();
        return consultaProdutoMySQL.editarProduto(produto);
    }

    public String excluirCliente() {
        ConsultasProdutoMySQL consultaProdutoMySQL = new ConsultasProdutoMySQL();
        return consultaProdutoMySQL.excluirProduto(produto);
    }

    public void buscarProdutos() {
        ConsultasProdutoMySQL consultaProdutoMySQL = new ConsultasProdutoMySQL();
        this.listaProdutos = consultaProdutoMySQL.buscarProduto();
    }

    public ArrayList<Produto> getListProdutos() {
        return listaProdutos;
    }

    public void setListProdutos(ArrayList<Produto> listProdutos) {
        this.listaProdutos = listProdutos;
    }

//    public Produto getProduto(int id) {
//        return produto;
//    }
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void getProduto(int id) {
        for (int i = 0; i < this.listaProdutos.size(); i++) {
            if (this.listaProdutos.get(i).getIdProduto() == id) {
                produto = listaProdutos.get(i);
            }
        }
    }
}
