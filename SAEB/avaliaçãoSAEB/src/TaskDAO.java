import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private Connection connection;

    // Construtor que recebe a conexão com o banco de dados
    public TaskDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para adicionar uma nova tarefa
    public void addTask(Task task) throws SQLException {
        String sql = "INSERT INTO tarefa (nome, status, data_previsao, id_funcionario) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, task.getNome());
            ps.setString(2, task.getStatus());
            ps.setString(3, task.getDataPrevisao());
            ps.setInt(4, task.getIdFuncionario());
            ps.executeUpdate();
        }
    }

    // Método para atualizar uma tarefa existente
    public void updateTask(Task task) throws SQLException {
        String sql = "UPDATE tarefa SET nome = ?, status = ?, data_previsao = ?, id_funcionario = ? WHERE id_tarefa = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, task.getNome());
            ps.setString(2, task.getStatus());
            ps.setString(3, task.getDataPrevisao());
            ps.setInt(4, task.getIdFuncionario());
            ps.setInt(5, task.getIdTarefa());
            ps.executeUpdate();
        }
    }

    // Método para deletar uma tarefa
    public void deleteTask(int idTarefa) throws SQLException {
        String sql = "DELETE FROM tarefa WHERE id_tarefa = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idTarefa);
            ps.executeUpdate();
        }
    }

    // Método para listar todas as tarefas
    public List<Task> getAllTasks() throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tarefa";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Task task = new Task(
                        rs.getInt("id_tarefa"),
                        rs.getString("nome"),
                        rs.getString("status"),
                        rs.getString("data_previsao"),
                        rs.getInt("id_funcionario")
                );
                tasks.add(task);
            }
        }
        return tasks;
    }

    // Método para buscar uma tarefa pelo ID
    public Task getTaskById(int idTarefa) throws SQLException {
        String sql = "SELECT * FROM tarefa WHERE id_tarefa = ?";
        Task task = null;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idTarefa);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    task = new Task(
                            rs.getInt("id_tarefa"),
                            rs.getString("nome"),
                            rs.getString("status"),
                            rs.getString("data_previsao"),
                            rs.getInt("id_funcionario")
                    );
                }
            }
        }
        return task;
    }
}
