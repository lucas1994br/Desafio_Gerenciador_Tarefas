package Desafio_Gerenciador_Tarefas;

public class Tarefa {
    private String nome;
    private String descricao;
    private Boolean concluida;

public Tarefa(String nome, String descricao) {
        this.nome =nome;
        this.descricao = descricao;
        this.concluida = false;

}

public String getNome() {
    return nome;

}

public String getDescricao(){
    return descricao;

}

public boolean isConcluida(){
    return concluida;

}

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}