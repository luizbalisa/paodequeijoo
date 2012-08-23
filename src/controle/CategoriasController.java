/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.Categorias;
import java.util.ArrayList;
import persistencia.ConexaoMySQL;
import persistencia.ConsultasCategoriasMySQL;

/**
 *
 * @author Rafael
 */
public class CategoriasController {

    private Categorias categoria = new Categorias();
    private ArrayList<Categorias> listaCategorias = new ArrayList<Categorias>();

    public CategoriasController() {
    }

    public void buscaCategorias(){
        ConsultasCategoriasMySQL c = new ConsultasCategoriasMySQL();
        listaCategorias = c.buscarCategorias();
    }
    
    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Categorias> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(ArrayList<Categorias> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }
}
