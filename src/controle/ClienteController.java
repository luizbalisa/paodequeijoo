/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.Cliente;
import java.util.ArrayList;
import persistencia.ConsultasMySQL;

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
        return cliente.cadastrar();
    }
    public String editar(){
        return cliente.editar();
    }

    public void buscarClientes() {
        ConsultasMySQL c = new ConsultasMySQL();
        listaClientes = c.buscarClientes();
    }
    public void editarClientes(Cliente c){
        ConsultasMySQL consulta = new ConsultasMySQL();
        consulta.editarCliente(c);
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
    
    public Cliente getCliente(int id){
        for (int i = 0; i < this.listaClientes.size(); i++) {
            if(this.listaClientes.get(i).getId() == id)
                return this.listaClientes.get(i);
        }
        return null;
    }
}
