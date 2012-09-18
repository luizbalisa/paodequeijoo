/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.Categorias;
import fachada.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class ConsultaCategoriasMySQL {

    private static final String SQL_BUSCA_CATEGORIAS = "SELECT * FROM categorias ORDER BY idCategoria";

    public ConsultaCategoriasMySQL() {
    }
    
     public ArrayList<Categorias> buscarCategorias() {
        ArrayList<Categorias> categorias = new ArrayList<Categorias>();
        String query = SQL_BUSCA_CATEGORIAS;
        try {
            ResultSet rs = ConexaoMySQL.getInstance().executeQuery(query);
            while (rs.next()) {
                Categorias c = new Categorias();
                c.setId(rs.getInt("idCategoria"));
                c.setDescricao(rs.getString("descricao"));
                categorias.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return categorias;
    }
    
}
