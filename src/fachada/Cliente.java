/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import persistencia.ConsultasClienteMySQL;

/**
 *
 * @author Rafael
 */
public class Cliente {

    private int id;
    private String nome;
    private String endereco;
    private String cpf, rg;
    private String telefone1, telefone2, telefoneComercial;
    private String localDeTrabalho;
    private String email;
    private String observacoes;

    public Cliente(String nome, String endereco, String cpf, String rg, String telefone1, String telefone2, String telefoneComercial, String localDeTrabalho, String email, String observacoes) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefoneComercial = telefoneComercial;
        this.localDeTrabalho = localDeTrabalho;
        this.email = email;
        this.observacoes = observacoes;
    }

    public Cliente() {
    }

    public String getTelefoneValido() {
        if (telefone1 != null && !telefone1.equals("")) {
            return telefone1;
        } else if (telefone2 != null && !telefone2.equals("")) {
            return telefone2;
        } else if (telefoneComercial != null && !telefoneComercial.equals("")) {
            return telefoneComercial;
        } else {
            return "";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String editar(){
//        ConsultasClienteMySQL c = new ConsultasClienteMySQL();
//        return c.editarCliente(this);
//    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLocalDeTrabalho() {
        return localDeTrabalho;
    }

    public void setLocalDeTrabalho(String localDeTrabalho) {
        this.localDeTrabalho = localDeTrabalho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }
}
