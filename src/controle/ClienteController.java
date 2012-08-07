/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.Cliente;
import java.util.ArrayList;
import persistencia.ConexaoMySQL;
import persistencia.ConsultasClienteMySQL;

/**
 *
 * @author Rafael
 */
public class ClienteController {

    Cliente cliente = new Cliente();
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    public ClienteController() {
    }

    public String cadastrar() {
        ConsultasClienteMySQL consultaMySQL = new ConsultasClienteMySQL();
        return consultaMySQL.cadastrarCliente(cliente);
    }

    public String editar() {
        return cliente.editar();
    }

    public void buscarClientes() {
        ConsultasClienteMySQL c = new ConsultasClienteMySQL();
        listaClientes = c.buscarClientes();
    }

    public void editarClientes(Cliente c) {
        ConsultasClienteMySQL consulta = new ConsultasClienteMySQL();
        consulta.editarCliente(c);
    }
    
    public String excluirCliente(){
        ConsultasClienteMySQL consulta = new ConsultasClienteMySQL();
        return consulta.excluirCliente(cliente);
    }

    public ArrayList<Cliente> getListaClisntes() {
        return listaClientes;
    }

    public void setListaClisntes(ArrayList<Cliente> listaClisntes) {
        this.listaClientes = listaClisntes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void getCliente(int id) {
        for (int i = 0; i < this.listaClientes.size(); i++) {
            if (this.listaClientes.get(i).getId() == id) {
                cliente = listaClientes.get(i);
            }
        }
    }
}
