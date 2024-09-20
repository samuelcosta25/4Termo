package ex5.src.main.java.com.example;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica(5);
        int operador=0;

        try {
            
        do {
            System.out.println("\n---Agenda Telefonica---");
            System.out.println("\n 1- Adicionar Contato:");
            System.out.println("\n 2- Listar Contato:");
            System.out.println("\n 3- Buscar Contato:");
            System.out.println("\n 4- Remover Contato:");
            System.out.println("\n 5- Sair...");
            operador = Integer.parseInt(JOptionPane.showInputDialog("Digite a operação desejada:", null));

            switch (operador) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Digite o nome:");
                    String telefone = JOptionPane.showInputDialog("Digite o telefone:");
                    String email = JOptionPane.showInputDialog("Digite o email:");
                    Contato contato = new Contato(nome, telefone, email);
                    agenda.addContato(contato);
                    break;

                case 2:
                    agenda.listarContatos();
                    break;
                case 3:
                try {
                    String nomeBusca = JOptionPane.showInputDialog("Digite o nome do contato a ser buscado: ");
                    agenda.buscarContato(nomeBusca);
                } catch (Exception e) {
                    System.err.println(e);
                }
               break;
                case 4:
                    try{
                        String nomeRemove = JOptionPane.showInputDialog("Digite o nome do contato a ser removido:");
                        agenda.removerContato(nomeRemove);
                    } catch (Exception e) {
                        System.err.println(e);
                    }            
                    break;
                case 5:
                    break;
            
                default:
                    break;
            }

        } while (operador!=5);
    }
    catch (Exception e) {
       System.err.println(e);
    }
    }
}