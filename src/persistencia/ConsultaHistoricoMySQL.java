/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import fachada.HistoricoSaidaProduto;
import fachada.MovimentoCaixa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Guil
 */
public class ConsultaHistoricoMySQL {

    private static final String BUSCA_PRODUTO = "SELECT * FROM historico_saida_produto";
    private static final String UPDATE_ESTORNO = "UPDATE historico_saida_produto SET quantidade=? WHERE idProduto=? and data=?";
    private static final String BUSCA_QUANTIDADE = "SELECT quantidade FROM historico_saida_produto WHERE idProduto=? and data=?";

    public ConsultaHistoricoMySQL() {
    }

    public void estornar(String quantidade, int prod, String data) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = (Connection) ConexaoMySQL.conectar();
            String qtd = buscarQuantidade(prod, data);
            double qnt = Double.parseDouble(qtd.replace(",", ".")) - Double.parseDouble(quantidade.replace(",", "."));
            stmt = (PreparedStatement) con.prepareStatement(UPDATE_ESTORNO);
            stmt.setString(1, String.valueOf(qnt));
            stmt.setInt(2, prod);
            stmt.setString(3, data);
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String buscarQuantidade(int prod, String data) {
        Connection con;
        PreparedStatement stmt;
        try {
            con = (Connection) ConexaoMySQL.conectar();
            stmt = (PreparedStatement) con.prepareStatement(BUSCA_QUANTIDADE);
            stmt.setInt(1, prod);
            stmt.setString(2, data);
            ResultSet rs = stmt.executeQuery();
            String qtd = rs.getString("quantidade");
            con.close();
            return qtd;
        } catch (SQLException ex) {
        }
        return null;
    }

    public ArrayList<HistoricoSaidaProduto> buscarHistoricos() {
        ArrayList<HistoricoSaidaProduto> hist = new ArrayList<HistoricoSaidaProduto>();
        String query = BUSCA_PRODUTO;
        try {
            ResultSet rs = ConexaoMySQL.getInstance().executeQuery(query);
            while (rs.next()) {
                HistoricoSaidaProduto h = new HistoricoSaidaProduto();
                h.setIdHistoricoSaidaProcuto(rs.getInt("idhistorico_saida_produto"));
                h.setIdProduto(rs.getInt("idProduto"));
                h.setData(rs.getString("data"));
                h.setQuantidade(rs.getInt("quantidade"));
                h.setPreco_custo(rs.getString("preco_custo"));
                h.setPreco_venda(rs.getString("preco_venda"));
                h.setIdCategoria();
                hist.add(h);
            }
        } catch (SQLException ex) {
        }
        return hist;
    }
}
