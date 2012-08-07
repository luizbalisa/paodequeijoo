/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class ConsultasClienteMySQL {

    private static final String SQL_EXCLUIR_CLIENTE = " DELETE FROM cliente WHERE idCliente=?";
    private static final String SQL_BUSCA_CLIENTE = "SELECT * FROM cliente ORDER BY nome";
    private static final String SQL_INCLUIR_CLIENTE = "INSERT INTO cliente (nome, endereco, cpf, rg, telefone1, telefone2, email, local_trabalho, telefone_comercial, observacoes) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_EDITAR_CLIENTE = "UPDATE cliente SET nome=?, endereco=?, cpf=?, rg=?, telefone1=?, telefone2=?, email=?, local_trabalho=?, telefone_comercial=?, observacoes=? WHERE idcliente=? ";

    public ConsultasClienteMySQL() {
    }

    public String excluirCliente(Cliente cliente) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_EXCLUIR_CLIENTE);
            stmt.setInt(1, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            StringBuilder msg = new StringBuilder("Exclusão não Efetuada");
            msg.append("\nMotivo: ").append(ex.getMessage());;
            return "Exclusão não efetuada";
        }
        return "Exclusão efetuada com sucesso!";
    }

    public String cadastrarCliente(Cliente cliente) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_INCLUIR_CLIENTE);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getRg());
            stmt.setString(5, cliente.getTelefone1());
            stmt.setString(6, cliente.getTelefone2());
            stmt.setString(7, cliente.getEmail());
            stmt.setString(8, cliente.getLocalDeTrabalho());
            stmt.setString(9, cliente.getTelefoneComercial());
            stmt.setString(10, cliente.getObservacoes());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            StringBuilder msg = new StringBuilder("Inclusao nao feita");
            msg.append("\nMotivo: ").append(ex.getMessage());
            return "Cadastro não efetuada";
        }
        return "Cadastro efetuado com sucesso!";
    }

    public String editarCliente(Cliente cliente) {
        Connection con;
        PreparedStatement stmt;
//        String query = "UPDATE cliente SET nome ='" + c.getNome() + "', endereco='" + c.getEndereco() + "', cpf='" + c.getCpf()
//                + "', rg= '" + c.getRg() + "', telefone1 ='" + c.getTelefone1() + "', telefone2 = '" + c.getTelefone2() + "', email='"
//                + c.getEmail() + "', local_trabalho = '" + c.getLocalDeTrabalho() + "', telefone_comercial = '" + c.getTelefoneComercial()
//                + "', observacoes = '" + c.getObservacoes() + "'" + "WHERE idcliente=" + c.getId();
        try {
//            ConexaoMySQL.getInstance().execute(query);
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_EDITAR_CLIENTE);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getRg());
            stmt.setString(5, cliente.getTelefone1());
            stmt.setString(6, cliente.getTelefone2());
            stmt.setString(7, cliente.getEmail());
            stmt.setString(8, cliente.getLocalDeTrabalho());
            stmt.setString(9, cliente.getTelefoneComercial());
            stmt.setString(10, cliente.getObservacoes());
            stmt.setInt(11, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            return "Erro na alteração do Cliente";
        }
        return "Cliente alterado com sucesso ";
    }

    public ArrayList<Cliente> buscarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        String query = SQL_BUSCA_CLIENTE;
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
            Logger.getLogger(ConsultasClienteMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
}
