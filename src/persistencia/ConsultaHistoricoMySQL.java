/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.HistoricoSaidaProduto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Guil
 */
public class ConsultaHistoricoMySQL {

    private static final String BUSCA_PRODUTO = "SELECT * FROM historico_saida_produto";

    public ConsultaHistoricoMySQL() {
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
