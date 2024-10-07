package com.example;

import com.example.View.UsuarioView;
import com.example.View.RelatorioView;
import com.example.Controller.UsuarioController;
import com.example.Controller.RelatorioController;

public class MainApp {

    public static void main(String[] args) {
        // Inicializa a View (interface gráfica) do Usuário
        UsuarioView usuarioView = new UsuarioView();
        UsuarioController usuarioController = new UsuarioController(usuarioView);
        
        // Inicializa a View (interface gráfica) do Relatório
        RelatorioView relatorioView = new RelatorioView();
        RelatorioController relatorioController = new RelatorioController(relatorioView);
        
        // Exibe as interfaces gráficas
        usuarioView.setVisible(true);
        relatorioView.setVisible(true);
    }
}
