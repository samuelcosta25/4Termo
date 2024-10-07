package com.example.Controller;

import com.example.Model.Preencher;

public class PreencherController {

    public void associarRelatorioUsuario(Long idRelatorio, Long idUsuario) {
        Preencher preencher = new Preencher();
        preencher.setIdRelatorio(idRelatorio);
        preencher.setIdUsuario(idUsuario);
        salvarPreencher(preencher);
    }

    public void salvarPreencher(Preencher preencher) {
        // Lógica para salvar o registro na tabela Preencher
        System.out.println("Relatório " + preencher.getIdRelatorio() + " associado ao Usuário " + preencher.getIdUsuario());
    }
}

