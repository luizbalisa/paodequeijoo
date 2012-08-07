/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.Cliente;
import fachada.Produto;
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
public class ConsultasProdutoMySQL {

    private static final String SQL_EXCLUIR_PRODUTO = " DELETE FROM produto_venda WHERE codigo_produto=?";
    private static final String SQL_BUSCA_PRODUTO = "SELECT * FROM produto_venda ORDER BY nome";
    private static final String SQL_INCLUIR_PRODUTO = "INSERT INTO produto_venda (nome, preco) "
            + "VALUES (?, ?)";
    private static final String SQL_EDITAR_PRODUTO = "UPDATE produto_venda SET nome=?, preco=? WHERE codigo_produto=? ";

    public ConsultasProdutoMySQL() {
    }

    public String excluirProduto(Produto prod) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_EXCLUIR_PRODUTO);
            stmt.setInt(1, prod.getIdProduto());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            StringBuilder msg = new StringBuilder("Exclusão não Efetuada");
            msg.append("\nMotivo: ").append(ex.getMessage());;
            return "Exclusão não efetuada";
        }
        return "Exclusão efetuada com sucesso!";
    }

    public String cadastrarProduto(Produto prod) {
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_INCLUIR_PRODUTO);
            stmt.setString(1, prod.getNome());
            stmt.setString(2, prod.getPreco());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            StringBuilder msg = new StringBuilder("Inclusao nao feita");
            msg.append("\nMotivo: ").append(ex.getMessage());
            return "Cadastro não efetuada";
        }
        return "Cadastro efetuado com sucesso!";
    }

    public String editarProduto(Produto prod) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_EDITAR_PRODUTO);
            stmt.setString(1, prod.getNome());
            stmt.setString(2, prod.getPreco());
            stmt.setInt(3, prod.getIdProduto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            return "Erro na alteração do Cliente";
        }
        return "Cliente alterado com sucesso ";
    }

    public ArrayList<Produto> buscarProduto() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        String query = SQL_BUSCA_PRODUTO;
        try {
            ResultSet rs = ConexaoMySQL.getInstance().executeQuery(query);
            while (rs.next()) {
                Produto prod = new Produto();
                prod.setIdProduto(rs.getInt("codigo_produto"));
                prod.setNome(rs.getString("nome"));
                prod.setPreco(rs.getString("preco"));
                produtos.add(prod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasClienteMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }
}
