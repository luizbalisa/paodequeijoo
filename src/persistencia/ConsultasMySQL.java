/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class ConsultasMySQL {


    public ConsultasMySQL() {
    }

    public String cadastrarCliente(Cliente c) {
        String query = "INSERT INTO cliente (nome, endereco, cpf, rg, telefone1, telefone2, email, local_trabalho, telefone_comercial, observacoes) "
                + "VALUES ('" + c.getNome() + "','" + c.getEndereco() + "', '" + c.getCpf() + "','" + c.getRg() + "','" + c.getTelefone1()
                + "','" + c.getTelefone2() + "','" + c.getEmail() + "','" + c.getLocalDeTrabalho() + "','" + c.getTelefoneComercial() + "','" + c.getObservacoes() + "')";
        try {
            ConexaoMySQL.getInstance().execute(query);
        } catch (SQLException ex) {
            return "Erro ao cadastrar cliente.";
        }
        return "Cliente cadastrado com sucesso.";
    }

    public String editarCliente(Cliente c) {
        String query = "UPDATE cliente SET (nome ='" + c.getNome() + "', endereco='" + c.getEndereco() + "', cpf='" + c.getCpf()
                + "',rg= '" + c.getRg() + "',telefone1 ='" + c.getTelefone1() + "',telefone2 = '" + c.getTelefone2() + "',email='"
                + c.getEmail() + "',local_trabalho = '" + c.getLocalDeTrabalho() + "',telefone_comercial = '" + c.getTelefoneComercial()
                + "',observacoes = '" + c.getObservacoes() + "')" + "WHERE idcliente=" + c.getId();
        try {
            ConexaoMySQL.getInstance().execute(query);
        } catch (SQLException e) {
            return "Erro na alteração do Cliente";
        }
        return "Cliente alterado com sucesso ";
    }

    public ArrayList<Cliente> buscarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        String query = "SELECT * FROM cliente";
        try {
            ResultSet rs = ConexaoMySQL.getInstance().executeQuery(query);
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("idcliente"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                c.setTelefone1(rs.getString("telefone1"));
                c.setTelefone2(rs.getString("telefone2"));
                c.setEmail(rs.getString("email"));
                c.setLocalDeTrabalho(rs.getString("local_trabalho"));
                c.setTelefoneComercial(rs.getString("telefone_comercial"));
                c.setObservacoes(rs.getString("observacoes"));
                clientes.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
}
