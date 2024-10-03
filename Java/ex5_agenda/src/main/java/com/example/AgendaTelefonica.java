
package com.example;

public class AgendaTelefonica {
    // atributos

    private Contato[] contatos;
    private int contador;

    // construtor
    public AgendaTelefonica(int maxContato) {
        contatos = new Contato[maxContato];
        contador = 0;
    }

    // metodos

    // add
    public void addContato(Contato contato) throws AgendaCheiaException {
        if (contador >= contatos.length) {
            try {
                throw new AgendaCheiaException("Agenda Cheia");
            } catch (AgendaCheiaException e) {
                contatos[contador] = contato;
                contador++;
                System.out.println("Contato Adicionado com sucesso");
                e.printStackTrace();
            }
        }
    }

    // listar
    public void listarContatos() {
        if (contador == 0) {
            System.out.println("Agenda vazia");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(contatos[i]);
            }
        }
    }

    // buscar
    public Contato buscarContato(String nome) throws ContatoNaoEncontradoException {
        for (int i = 0; i < contador; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];
            }
        }
        throw new ContatoNaoEncontradoException("Contato Não Encontrado!");
    }
    // remover

    public void removerContato(String nome) throws ContatoNaoEncontradoException {
        boolean encontrado = false;
        for (int i = 0; i < contador; i++) {

            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                encontrado = true;
                contatos[i] = contatos[contador - 1];
                contatos[contador - 1] = null;
                contador--;
                System.out.println("Contato removido com sucesso!");
            }
        }
        if (!encontrado) {
            throw new ContatoNaoEncontradoException("Contato Não Encontrado!");
        }
    }
}
