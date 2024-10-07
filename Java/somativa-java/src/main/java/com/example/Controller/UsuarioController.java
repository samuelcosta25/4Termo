package com.example.Controller;

import com.example.Model.Usuario;
import com.example.View.UsuarioView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioController {

    private UsuarioView view;

    public UsuarioController(UsuarioView view) {
        this.view = view;
        this.view.getSalvarButton().addActionListener(new SalvarUsuarioListener());
    }

    class SalvarUsuarioListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = view.getNome();
            String email = view.getEmail();
            String telefone = view.getTelefone();
            String senha = view.getSenha();
            String cpf = view.getCpf();
            
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setTelefone(telefone);
            usuario.setSenha(senha);
            usuario.setCpf(cpf);
            
            salvarUsuario(usuario);
        }
    }

    public void salvarUsuario(Usuario usuario) {
        // Lógica de salvar o usuário (pode ser usando um serviço ou DAO)
        System.out.println("Usuário salvo: " + usuario.getNome() + ", " + usuario.getEmail());
    }
}
