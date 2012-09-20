/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.Cliente;
import fachada.Fornecedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class ConsultaFornecedorMySQL {

    private static final String SQL_BUSCA_FORNECEDOR = "SELECT * FROM fornecedor ORDER BY nome";

    public ConsultaFornecedorMySQL() {
    }

    public ArrayList<Fornecedor> buscarFornecedores () {
        ArrayList<Fornecedor> fornecedor = new ArrayList<Fornecedor>();
        String query = SQL_BUSCA_FORNECEDOR;
        try {
            ResultSet rs = ConexaoMySQL.getInstance().executeQuery(query);
            while (rs.next()) {
                Fornecedor c = new Fornecedor();
                c.setIdFornecedor(rs.getInt("idfornecedor"));
                c.setEmpresa(rs.getString("empresa"));
                c.setEndereco(rs.getString("endereco"));
                c.setCnpj(rs.getString("cnpj"));
                c.setIe(rs.getString("ie"));
                c.setEmail(rs.getString("email"));
                c.setTelefone1(rs.getString("telefone1"));
                c.setTelefone2(rs.getString("telefone2"));
                c.setVendedor(rs.getString("vendedor"));
                fornecedor.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return fornecedor;
    }
}
