package model;

public class Turma {
    private Aluno[] alunos;
    private int quantidadeAlunos;

    public Turma(int capacidade) {
        this.alunos = new Aluno[capacidade];
        this.quantidadeAlunos = 0;
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (quantidadeAlunos >= alunos.length) {
            System.out.println("Erro: a turma já está cheia.");
            return false;
        }
        alunos[quantidadeAlunos] = aluno;
        quantidadeAlunos++;
        return true;
    }

    public void listarAprovados() {
        System.out.println("=== Alunos aprovados ===");
        boolean encontrou = false;
        for (int i = 0; i < quantidadeAlunos; i++) {
            if (alunos[i].estaAprovado()) {
                System.out.printf("%s (matrícula %s) - média %.2f%n",
                        alunos[i].getNome(), alunos[i].getMatricula(), alunos[i].calcularMedia());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum aluno aprovado.");
        }
    }

    public void listarReprovados() {
        System.out.println("=== Alunos reprovados ===");
        boolean encontrou = false;
        for (int i = 0; i < quantidadeAlunos; i++) {
            if (!alunos[i].estaAprovado()) {
                System.out.printf("%s (matrícula %s) - média %.2f%n",
                        alunos[i].getNome(), alunos[i].getMatricula(), alunos[i].calcularMedia());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum aluno reprovado.");
        }
    }
}
