package persistencia;

/*
 *
 * @author Mariane Moreira de Souza
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta classe tem os m�todos est�ticos para a conex�o e fechamento de conex�o
 * com o banco de dados em um sistema monousu�rio
 */
public class ConexaoMySQL {

    static java.sql.Statement st;

    /**
     * Construtor da classe DataBase
     */
    public ConexaoMySQL() {
    }

    /**
     * M�todo para abrir uma conex�o com o banco
     *
     * @return conexao Conex�o com o banco
     *
     */
    //a conex�o � criada uma �nica vez, no momento em que o objeto ConexaoMySQL � criado (no momento da realiza��o da primeira
    //consulta ou atualiza��o no banco;
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
            String username = "paode";        //nome de um usuário de seu BD        
            //String password = "paodequeijo";      //sua senha de acesso  
            String password = "queijo";      //sua senha de acesso  
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
