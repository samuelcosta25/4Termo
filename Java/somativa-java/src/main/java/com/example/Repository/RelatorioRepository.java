package com.example.Repository;

import com.example.Model.Relatorio;
import java.util.List;

public interface RelatorioRepository {
    
    void salvar(Relatorio relatorio);   // Salva um novo relatório
    
    List<Relatorio> buscarPorUsuario(Long idUsuario);   // Busca relatórios por ID do usuário
    
    Relatorio buscarPorId(Long idRelatorio);   // Busca relatório por ID do relatório
    
    void atualizar(Relatorio relatorio);   // Atualiza um relatório existente
    
    void deletar(Long idRelatorio);   // Deleta um relatório pelo ID
}

