package Desafio_Gerenciador_Tarefas;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorTarefas {

    private ArrayList<Tarefa> tarefas;
    private Scanner entrada;

    public GerenciadorTarefas() {

        tarefas = new ArrayList<>();
        entrada = new Scanner(System.in);

    }

    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        gerenciador.exibirMenu();
    }

    public void exibirMenu() {
        int opcao = 0;

        do {
            System.out.println("Gerenciador de Tarefas");
            System.out.println("1.Adicionar Tarefas");
            System.out.println("2.Listar Tarefas");
            System.out.println("3.Marca Tarefa como concluída");
            System.out.println("4.Remover Tarefa");
            System.out.println("5.Sair");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    listarTarefa();
                    break;
                case 3:
                    marcarTarefaConcluida();
                    break;
                case 4:
                    removerTarefa();
                    break;
                case 5:
                    System.out.println("Saindo do Gerenciador de Tarefas");
                    break;
                default:
                    System.out.println("Opção inválida.Tente Novamente");
            }
        } while (opcao != 5);
    }

    public void adicionarTarefa() {
        System.out.println("Digite o nome da tarefa: ");
        String nome = entrada.nextLine();
        System.out.println("Digite a descrição da tarefa: ");
        String descricao = entrada.nextLine();
        tarefas.add(new Tarefa(nome, descricao));
    }

    public void listarTarefa() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa foi encontrada.");
        } else {
            System.out.println("Lista de Tarefas");
            for (int contagem = 0; contagem < tarefas.size(); contagem++) {
                Tarefa tarefa = tarefas.get(contagem);
                System.out.println((contagem + 1) + " . " + tarefa.getNome() + " - " + (tarefa.isConcluida() ? "Concluida" : "Pendente"));
            }
        }
    }

    public void marcarTarefaConcluida (){
        listarTarefa();
        if (!tarefas.isEmpty()){
            System.out.println("Escolha o numero da tarefa que deseja marcar como concluída: ");
        int indice = entrada.nextInt() -1;
        if (indice >= 0 && indice < tarefas.size()) {
            Tarefa tarefa = tarefas.get(indice);
            tarefa.setConcluida(true);
            System.out.println("Tarefa marcada como concluída");
        } else {
            System.out.println("Numero de tarefa inválido.");
        }
    }
}
    public void removerTarefa () {
        listarTarefa();
        if (!tarefas.isEmpty()) {
            System.out.println("Escolha o numero da tarefa  que deseja remover: ");
            int indice = entrada.nextInt() - 1;
            if (indice >= 0 && indice < tarefas.size()) {
                tarefas.remove(indice);
                System.out.println("Tarefa removida com sucesso");
            } else {
                System.out.println("Numero de tarefa inválido.");
            }
        }
    }
}