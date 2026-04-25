package src;

public class Tarefa {
    private String nome;
    private boolean concluida;

    public Tarefa(String nome) {
        this.nome = nome;
        this.concluida = false;

    }

    public String getnome() {
        return nome;
    }

    public boolean isConcluida() {
        return concluida;
    }
}
