/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

/**
 *
 * @author Rafael
 */
public class Categorias {

    private int id;
    private String descricao;

    public Categorias() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
