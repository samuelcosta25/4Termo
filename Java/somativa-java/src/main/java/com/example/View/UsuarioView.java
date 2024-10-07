package com.example.View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UsuarioView extends JFrame {

    private JTextField nomeField;
    private JTextField emailField;
    private JTextField telefoneField;
    private JTextField cpfField;
    private JPasswordField senhaField;
    private JButton salvarButton;

    public UsuarioView() {
        setTitle("Cadastro de Usuário");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(5, 2));

        formPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        formPanel.add(nomeField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Telefone:"));
        telefoneField = new JTextField();
        formPanel.add(telefoneField);

        formPanel.add(new JLabel("CPF:"));
        cpfField = new JTextField();
        formPanel.add(cpfField);

        formPanel.add(new JLabel("Senha:"));
        senhaField = new JPasswordField();
        formPanel.add(senhaField);

        salvarButton = new JButton("Salvar");

        add(formPanel, BorderLayout.CENTER);
        add(salvarButton, BorderLayout.SOUTH);
    }

    public String getNome() {
        return nomeField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getTelefone() {
        return telefoneField.getText();
    }

    public String getCpf() {
        return cpfField.getText();
    }

    public String getSenha() {
        return new String(senhaField.getPassword());
    }

    public JButton getSalvarButton() {
        return salvarButton;
    }
}
