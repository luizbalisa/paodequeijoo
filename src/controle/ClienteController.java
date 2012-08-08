/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.Cliente;
import java.text.Normalizer;
import java.util.ArrayList;
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
        ConsultasClienteMySQL consultaMySQL = new ConsultasClienteMySQL();
        return consultaMySQL.editarCliente(cliente);
    }

    public void buscarClientes() {
        ConsultasClienteMySQL c = new ConsultasClienteMySQL();
        listaClientes = c.buscarClientes();
    }
    
    public String excluirCliente(){
        ConsultasClienteMySQL consulta = new ConsultasClienteMySQL();
        return consulta.excluirCliente(cliente);
    }
    
    public ArrayList<Cliente> buscaDinamicaClientes(String busca) {
        String desc2 = busca;
        desc2 = Normalizer.normalize(desc2, Normalizer.Form.NFD);
        desc2 = desc2.replaceAll("[^\\p{ASCII}]", "");
        desc2 = desc2.toUpperCase();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        for (int i = 0; i < listaClientes.size(); i++) {
            String comp = listaClientes.get(i).getNome();
            comp = Normalizer.normalize(comp, Normalizer.Form.NFD);
            comp = comp.replaceAll("[^\\p{ASCII}]", "");
            comp = comp.toUpperCase();
            if (comp.contains(desc2)) {
                clientes.add(listaClientes.get(i));
            }
        }
        return clientes;
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
