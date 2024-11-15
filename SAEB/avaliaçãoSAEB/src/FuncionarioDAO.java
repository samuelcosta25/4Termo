import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private Connection connection;

    // Construtor que recebe a conexão com o banco de dados
    public FuncionarioDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para adicionar um novo funcionário
    public void addFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (nome, cpf, setor, registro, cargo, contato) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getSetor());
            ps.setString(4, funcionario.getRegistro());
            ps.setString(5, funcionario.getCargo());
            ps.setString(6, funcionario.getContato());
            ps.executeUpdate();
        }
    }

    // Método para atualizar um funcionário existente
    public void updateFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, setor = ?, registro = ?, cargo = ?, contato = ? WHERE id_funcionario = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getSetor());
            ps.setString(4, funcionario.getRegistro());
            ps.setString(5, funcionario.getCargo());
            ps.setString(6, funcionario.getContato());
            ps.setInt(7, funcionario.getIdFuncionario());
            ps.executeUpdate();
        }
    }

    // Método para deletar um funcionário
    public void deleteFuncionario(int idFuncionario) throws SQLException {
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idFuncionario);
            ps.executeUpdate();
        }
    }

    // Método para listar todos os funcionários
    public List<Funcionario> getAllFuncionarios() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario(
                        rs.getInt("id_funcionario"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("setor"),
                        rs.getString("registro"),
                        rs.getString("cargo"),
                        rs.getString("contato")
                );
                funcionarios.add(funcionario);
            }
        }
        return funcionarios;
    }

    // Método para buscar um funcionário pelo ID
    public Funcionario getFuncionarioById(int idFuncionario) throws SQLException {
        String sql = "SELECT * FROM funcionario WHERE id_funcionario = ?";
        Funcionario funcionario = null;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idFuncionario);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    funcionario = new Funcionario(
                            rs.getInt("id_funcionario"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("setor"),
                            rs.getString("registro"),
                            rs.getString("cargo"),
                            rs.getString("contato")
                    );
                }
            }
        }
        return funcionario;
    }
}
