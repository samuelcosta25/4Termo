package com.example.Controller;

import java.util.List;

import com.example.Model.Relatorio;
import com.example.Repository.Impl.RelatorioRepositoryImpl;
import com.example.Repository.RelatorioRepository;

public class RelatorioController {

    private RelatorioRepository relatorioRepository;

    public RelatorioController() {
        // Instancia o repositório (implementação)
        this.relatorioRepository = new RelatorioRepositoryImpl();
    }

    // Método para salvar um novo relatório
    public void salvarRelatorio(Relatorio relatorio) {
        if (relatorio.getTitulo() == null || relatorio.getTitulo().isEmpty() ||
            relatorio.getCategoria() == null || relatorio.getCategoria().isEmpty()) {
            throw new IllegalArgumentException("Título e categoria são obrigatórios.");
        }
        relatorioRepository.salvar(relatorio);
    }

    // Método para buscar todos os relatórios de um usuário (exemplo: busca geral)
    public List<Relatorio> buscarRelatorios() {
        // Para este exemplo, não estamos filtrando por usuário, mas poderia ser adicionado
        // um parâmetro de usuário aqui para filtragem.
        Long idUsuario = 1L;  // Exemplo de ID de usuário, poderia ser dinâmico conforme o contexto
        return relatorioRepository.buscarPorUsuario(idUsuario);
    }

    // Método para buscar um relatório pelo ID
    public Relatorio buscarRelatorioPorId(Long idRelatorio) {
        if (idRelatorio == null || idRelatorio <= 0) {
            throw new IllegalArgumentException("ID do relatório inválido.");
        }
        return relatorioRepository.buscarPorId(idRelatorio);
    }

    // Método para atualizar um relatório existente
    public void atualizarRelatorio(Relatorio relatorio) {
        if (relatorio.getIdRelatorio() == null || relatorio.getIdRelatorio() <= 0) {
            throw new IllegalArgumentException("ID do relatório é obrigatório para atualização.");
        }
        if (relatorio.getTitulo() == null || relatorio.getTitulo().isEmpty() ||
            relatorio.getCategoria() == null || relatorio.getCategoria().isEmpty()) {
            throw new IllegalArgumentException("Título e categoria são obrigatórios.");
        }
        relatorioRepository.atualizar(relatorio);
    }

    // Método para deletar um relatório pelo ID
    public void deletarRelatorio(Long idRelatorio) {
        if (idRelatorio == null || idRelatorio <= 0) {
            throw new IllegalArgumentException("ID do relatório inválido.");
        }
        relatorioRepository.deletar(idRelatorio);
    }
}
