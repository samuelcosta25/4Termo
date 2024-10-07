package com.example.View;

import com.example.Controller.RelatorioController;
import com.example.Model.Relatorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RelatorioView extends JFrame {

    private RelatorioController relatorioController;
    private JTextField tituloField, categoriaField;
    private JTextArea displayArea;
    private JButton salvarButton, atualizarButton, deletarButton, buscarButton;

    public RelatorioView(RelatorioController controller) {
        this.relatorioController = controller;
        initUI();
    }

    private void initUI() {
        // Configurações da janela
        setTitle("Gerenciamento de Relatórios");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        // Campos de entrada
        JLabel tituloLabel = new JLabel("Título:");
        tituloField = new JTextField();

        JLabel categoriaLabel = new JLabel("Categoria:");
        categoriaField = new JTextField();

        // Botões de ação
        salvarButton = new JButton("Salvar Relatório");
        atualizarButton = new JButton("Atualizar Relatório");
        deletarButton = new JButton("Deletar Relatório");
        buscarButton = new JButton("Buscar Relatórios");

        // Área de exibição de relatórios
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Adiciona componentes ao painel
        panel.add(tituloLabel);
        panel.add(tituloField);
        panel.add(categoriaLabel);
        panel.add(categoriaField);
        panel.add(salvarButton);
        panel.add(atualizarButton);
        panel.add(deletarButton);
        panel.add(buscarButton);

        // Adiciona ações aos botões
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarRelatorio();
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarRelatorio();
            }
        });

        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarRelatorio();
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarRelatorios();
            }
        });

        // Adiciona o painel principal e a área de exibição à janela
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    // Função para salvar um novo relatório
    private void salvarRelatorio() {
        String titulo = tituloField.getText();
        String categoria = categoriaField.getText();

        if (titulo.isEmpty() || categoria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Relatorio relatorio = new Relatorio();
        relatorio.setTitulo(titulo);
        relatorio.setCategoria(categoria);

        relatorioController.salvarRelatorio(relatorio);
        JOptionPane.showMessageDialog(this, "Relatório salvo com sucesso!");
        limparCampos();
    }

    // Função para atualizar um relatório existente
    private void atualizarRelatorio() {
        String titulo = tituloField.getText();
        String categoria = categoriaField.getText();

        if (titulo.isEmpty() || categoria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Long id = Long.parseLong(JOptionPane.showInputDialog(this, "Informe o ID do relatório para atualizar:"));

        Relatorio relatorio = new Relatorio();
        relatorio.setIdRelatorio(id);
        relatorio.setTitulo(titulo);
        relatorio.setCategoria(categoria);

        relatorioController.atualizarRelatorio(relatorio);
        JOptionPane.showMessageDialog(this, "Relatório atualizado com sucesso!");
        limparCampos();
    }

    // Função para deletar um relatório
    private void deletarRelatorio() {
        Long id = Long.parseLong(JOptionPane.showInputDialog(this, "Informe o ID do relatório para deletar:"));

        relatorioController.deletarRelatorio(id);
        JOptionPane.showMessageDialog(this, "Relatório deletado com sucesso!");
    }

    // Função para buscar relatórios e exibir na interface
    private void buscarRelatorios() {
        List<Relatorio> relatorios = relatorioController.buscarRelatorios();

        displayArea.setText(""); // Limpar área de exibição

        if (relatorios.isEmpty()) {
            displayArea.append("Nenhum relatório encontrado.\n");
        } else {
            for (Relatorio rel : relatorios) {
                displayArea.append("ID: " + rel.getIdRelatorio() + ", Título: " + rel.getTitulo() + ", Categoria: " + rel.getCategoria() + "\n");
            }
        }
    }

    // Função para limpar os campos de entrada
    private void limparCampos() {
        tituloField.setText("");
        categoriaField.setText("");
    }

    public static void main(String[] args) {
        RelatorioController controller = new RelatorioController();  // Exemplo de instância do controller
        new RelatorioView(controller);
    }
}
