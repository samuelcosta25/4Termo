import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.List;

public class ToDoListAppGUI {
    private JFrame frame;
    private JTextField taskNameField;
    private JTextField taskStatusField;
    private JTextField taskDateField;
    private JTextField taskEmployeeIdField;
    private JTable taskTable;
    private TaskDAO taskDAO;

    public ToDoListAppGUI() throws SQLException {
        taskDAO = new TaskDAO(DatabaseConnection.getConnection());
        initialize();
    }

    // Método para inicializar a interface gráfica
    private void initialize() {
        frame = new JFrame("To-Do List App");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(0, 2));

        JLabel lblTaskName = new JLabel("Nome da Tarefa:");
        panel.add(lblTaskName);

        taskNameField = new JTextField();
        panel.add(taskNameField);
        taskNameField.setColumns(10);

        JLabel lblTaskStatus = new JLabel("Status da Tarefa:");
        panel.add(lblTaskStatus);

        taskStatusField = new JTextField();
        panel.add(taskStatusField);
        taskStatusField.setColumns(10);

        JLabel lblTaskDate = new JLabel("Data de Previsão:");
        panel.add(lblTaskDate);

        taskDateField = new JTextField();
        panel.add(taskDateField);
        taskDateField.setColumns(10);

        JLabel lblTaskEmployeeId = new JLabel("ID do Funcionário:");
        panel.add(lblTaskEmployeeId);

        taskEmployeeIdField = new JTextField();
        panel.add(taskEmployeeIdField);
        taskEmployeeIdField.setColumns(10);

        // Botões para adicionar, listar, atualizar e deletar tarefas
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        JButton btnAddTask = new JButton("Adicionar Tarefa");
        btnAddTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });
        buttonPanel.add(btnAddTask);

        JButton btnUpdateTask = new JButton("Atualizar Tarefa");
        btnUpdateTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTask();
            }
        });
        buttonPanel.add(btnUpdateTask);

        JButton btnDeleteTask = new JButton("Deletar Tarefa");
        btnDeleteTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });
        buttonPanel.add(btnDeleteTask);

        JButton btnListTasks = new JButton("Listar Tarefas");
        btnListTasks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listTasks();
            }
        });
        buttonPanel.add(btnListTasks);

        // Tabela para mostrar as tarefas
        taskTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(taskTable);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    // Método para adicionar uma nova tarefa
    private void addTask() {
        String nome = taskNameField.getText();
        String status = taskStatusField.getText();
        String dataPrevisao = taskDateField.getText();
        int idFuncionario = Integer.parseInt(taskEmployeeIdField.getText());

        Task task = new Task(nome, status, dataPrevisao, idFuncionario);
        try {
            taskDAO.addTask(task);
            JOptionPane.showMessageDialog(frame, "Tarefa adicionada com sucesso!");
            clearFields();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Erro ao adicionar tarefa: " + e.getMessage());
        }
    }

    // Método para atualizar uma tarefa existente
    private void updateTask() {
        int idTarefa = Integer.parseInt(JOptionPane.showInputDialog(frame, "Digite o ID da tarefa a ser atualizada:"));
        String nome = taskNameField.getText();
        String status = taskStatusField.getText();
        String dataPrevisao = taskDateField.getText();
        int idFuncionario = Integer.parseInt(taskEmployeeIdField.getText());

        Task updatedTask = new Task(idTarefa, nome, status, dataPrevisao, idFuncionario);
        try {
            taskDAO.updateTask(updatedTask);
            JOptionPane.showMessageDialog(frame, "Tarefa atualizada com sucesso!");
            clearFields();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Erro ao atualizar tarefa: " + e.getMessage());
        }
    }

    // Método para deletar uma tarefa
    private void deleteTask() {
        int idTarefa = Integer.parseInt(JOptionPane.showInputDialog(frame, "Digite o ID da tarefa a ser deletada:"));
        try {
            taskDAO.deleteTask(idTarefa);
            JOptionPane.showMessageDialog(frame, "Tarefa deletada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Erro ao deletar tarefa: " + e.getMessage());
        }
    }

    // Método para listar todas as tarefas
    private void listTasks() {
        try {
            List<Task> tasks = taskDAO.getAllTasks();
            String[] columnNames = {"ID", "Nome", "Status", "Data de Previsão", "ID Funcionário"};
            Object[][] data = new Object[tasks.size()][5];
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                data[i][0] = task.getIdTarefa();
                data[i][1] = task.getNome();
                data[i][2] = task.getStatus();
                data[i][3] = task.getDataPrevisao();
                data[i][4] = task.getIdFuncionario();
            }

            taskTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Erro ao listar tarefas: " + e.getMessage());
        }
    }

    // Método para limpar os campos de entrada
    private void clearFields() {
        taskNameField.setText("");
        taskStatusField.setText("");
        taskDateField.setText("");
        taskEmployeeIdField.setText("");
    }

    // Método principal para rodar o aplicativo
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    ToDoListAppGUI window = new ToDoListAppGUI();
                    window.frame.setVisible(true);
                } catch (SQLException ex) {
                }
            }
        });
    }
}
