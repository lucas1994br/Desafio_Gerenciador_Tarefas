package Desafio_Gerenciador_Tarefas;

import java.util.ArrayList;
import java.util.Scanner;

public class Gerenciador_Tarefas_Simples {
    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<>();
        ArrayList<Boolean> tarefasConcluidas = new ArrayList<>();

        Scanner inicio = new Scanner(System.in);
        boolean avançar = true;

        while (avançar) {
            System.out.println("--- Gerenciador de Tarefas ---");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Marcar Tarefas como Concluídas");
            System.out.println("3. Listar Todas as Tarefas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = inicio.nextInt();
            inicio.nextLine(); // Consumir o '\n'

            // Controle de fluxo com base na escolha do usuário
            switch (opcao) {
                case 1:
                    // Adicionar tarefa
                    System.out.print("Digite a nova tarefa: ");
                    String novaTarefa = inicio.nextLine();
                    tarefas.add(novaTarefa);
                    tarefasConcluidas.add(false); // Inicialmente, tarefa não está concluída
                    System.out.println("Tarefa adicionada com sucesso!");
                    break;
                case 2:
                    // Marcar Tarefas como Concluídas
                    System.out.print("Digite o número da tarefa que deseja marcar como concluída: ");
                    int numeroTarefa = inicio.nextInt();
                    if (numeroTarefa > 0 && numeroTarefa <= tarefas.size()) {
                        tarefasConcluidas.set(numeroTarefa - 1, true); // Marca como concluída
                        System.out.println("Tarefa marcada como concluída!");
                    } else {
                        System.out.println("Número de tarefa inválido.");
                    }
                    break;

                case 3:
                    // Listar Todas as Tarefas
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        for (int i = 0; i < tarefas.size(); i++) {
                            String status = tarefasConcluidas.get(i) ? "[Concluída]" : "[Não concluída]";
                            System.out.println((i + 1) + ". " + tarefas.get(i) + " - " + status);
                        }
                    }
                    break;

                case 4:
                    // Sair do programa
                    avançar = false;
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        inicio.close();
    }
}