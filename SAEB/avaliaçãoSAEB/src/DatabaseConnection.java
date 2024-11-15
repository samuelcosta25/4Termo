import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Variáveis para armazenar dados da conexão
    private static final String URL = "jdbc:postgresql://localhost:5432/SAEP";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    // Método para obter a conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        try {
            // Carrega o driver JDBC
            Class.forName("org.postgresql.Driver");

            // Retorna a conexão com o banco de dados
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            // Se o driver não for encontrado
            throw new SQLException("Driver do PostgreSQL não encontrado", e);
        } catch (SQLException e) {
            // Se houver algum erro na conexão
            throw new SQLException("Erro ao conectar ao banco de dados", e);
        }
    }

    // Método para fechar a conexão com o banco de dados
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
