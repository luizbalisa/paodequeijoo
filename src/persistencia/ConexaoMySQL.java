package persistencia;

/*
 *
 * @author Mariane Moreira de Souza
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoMySQL {

    static java.sql.Statement st;

    /**
     * Construtor da classe DataBase
     */
    public ConexaoMySQL() {
    }

    public static java.sql.Statement getInstance() throws SQLException {
        if (st == null) {
            Connection con = conectar();
            st = con.createStatement();
        }
        return st;
    }

    public static Connection conectar() {
        try {
            // Carregando o JDBC Driver padrão  
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            // Configurando a nossa conexão com um banco de dados//    
            String url = "jdbc:mysql://192.168.2.183:3306/paodequeijo";
            //      String url = "jdbc:mysql://50.31.138.79:3306/dietsmar_pqdb";
//            String url = "jdbc:mysql://172.16.199.117:3306/paodequeijodb";
            //  String username = "dietsmar_pq";        //nome de um usuário de seu BD        
            String username = "root";        //nome de um usuário de seu BD        
            //String password = "paodequeijo";      //sua senha de acesso  
            String password = "root";      //sua senha de acesso  
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException e) {  //Driver não encontrado  
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {

            System.out.println("Nao foi possivel conectar ao Banco de Dados.  " + e);
            return null;
        }
    }
}
