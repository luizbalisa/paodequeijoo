/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.Cliente;
import fachada.Fornecedor;
import java.text.Normalizer;
import java.util.ArrayList;
import persistencia.ConsultaClienteMySQL;
import persistencia.ConsultaFornecedorMySQL;

/**
 *
 * @author Rafael
 */
public class FornecedorController {

    Fornecedor cliente = new Fornecedor();
    ArrayList<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();

    public FornecedorController() {
    }

//    public String cadastrar() {
//        limparFormatacaoTelefone();
//        limparFormatacaoCPF();
//       // ConsultaClienteMySQL consultaMySQL = new ConsultaClienteMySQL();
//       // return consultaMySQL.cadastrarCliente(cliente);
//    }
//
//    public String editar() {
//      //  ConsultaClienteMySQL consultaMySQL = new ConsultaClienteMySQL();
//        return consultaMySQL.editarCliente(cliente);
//    }
    public void buscarClientes() {
        ConsultaFornecedorMySQL c = new ConsultaFornecedorMySQL();
        listaFornecedores = c.buscarFornecedores();
    }

//    public String excluirCliente() {
//        ConsultaClienteMySQL consulta = new ConsultaClienteMySQL();
//        return consulta.excluirCliente(cliente);
//    }
    public ArrayList<Fornecedor> buscaDinamicaClientes(String busca) {
        String desc2 = busca;
        desc2 = Normalizer.normalize(desc2, Normalizer.Form.NFD);
        desc2 = desc2.replaceAll("[^\\p{ASCII}]", "");
        desc2 = desc2.toUpperCase();
        ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        for (int i = 0; i < listaFornecedores.size(); i++) {
            String comp = listaFornecedores.get(i).getEmpresa();
            comp = Normalizer.normalize(comp, Normalizer.Form.NFD);
            comp = comp.replaceAll("[^\\p{ASCII}]", "");
            comp = comp.toUpperCase();
            if (comp.contains(desc2)) {
                fornecedores.add(listaFornecedores.get(i));
            }
        }
        return fornecedores;
    }

    public void limparFormatacaoTelefone() {
        String tel1 = cliente.getTelefone1().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
        cliente.setTelefone1(tel1);
        String tel2 = cliente.getTelefone2().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
        cliente.setTelefone2(tel2);
    }

    public void getCliente(int id) {
        for (int i = 0; i < this.listaFornecedores.size(); i++) {
            if (this.listaFornecedores.get(i).getIdFornecedor() == id) {
                cliente = listaFornecedores.get(i);
            }
        }
    }

    public Fornecedor getCliente() {
        return cliente;
    }

    public void setCliente(Fornecedor cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Fornecedor> getListaFornecedores() {
        return listaFornecedores;
    }

    public void setListaFornecedores(ArrayList<Fornecedor> listaFornecedores) {
        this.listaFornecedores = listaFornecedores;
    }
}
