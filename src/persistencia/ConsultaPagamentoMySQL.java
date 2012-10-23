/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import fachada.Pagamento;
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
public class ConsultaPagamentoMySQL {

    private static final String SQL_INCLUIR = "INSERT INTO pagamento (idVenda, valor, data) "
            + "VALUES (?, ?, ?)";
    private static final String SQL_BUSCAR = "SELECT * FROM pagamento WHERE idVenda = ?";

    public ConsultaPagamentoMySQL() {
    }

    public String cadastrarPagamento(Pagamento p) {
        Connection con;
        PreparedStatement stmt;
        con = ConexaoMySQL.conectar();
        try {
            stmt = con.prepareStatement(SQL_INCLUIR);
            stmt.setInt(1, p.getIdVenda());
            stmt.setString(2, p.getValor());
            stmt.setString(3, p.getData());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaPagamentoMySQL.class.getName()).log(Level.SEVERE, null, ex);
            return "Pagamento não registrado";
        }
        return "Pagamento registrado com sucesso!";
    }

    public ArrayList<Pagamento> bsucaPagamentos(int idVenda) {
        ArrayList<Pagamento> retorno = new ArrayList<Pagamento>();
        Connection con;
        PreparedStatement stmt;

        try {
            con = ConexaoMySQL.conectar();
            stmt = con.prepareStatement(SQL_BUSCAR);
            stmt.setInt(1, idVenda);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pagamento aux = new Pagamento();
                aux.setIdVenda(idVenda);
                aux.setData(rs.getString("data"));
                aux.setValor(rs.getString("valor"));
                retorno.add(aux);
            }
            con.close();
        } catch (SQLException ex) {
             Logger.getLogger(ConsultaPagamentoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
