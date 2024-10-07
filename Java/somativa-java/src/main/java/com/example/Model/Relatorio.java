package com.example.Model;

public class Relatorio {
    private Long idRelatorio;
    private String titulo;
    private String conteudo;  // Conteúdo do relatório (o texto principal)
    private String categoria; // Categoria ou tema do relatório
    private String link;      // Link relacionado (se houver)
    private String resumo;    // Resumo do relatório

    // Relacionamento com o Usuário
    private Long idUsuario;   // Foreign Key para usuário

    // Getters e Setters
    public Long getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(Long idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
