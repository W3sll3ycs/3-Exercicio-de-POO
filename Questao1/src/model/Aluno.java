package model;
public class Aluno {
    private static final int MAX_NOTAS = 4;
    private static final double MEDIA_APROVACAO = 7.0;

    private String nome;
    private String matricula;
    private double[] notas;
    private int quantidadeNotas;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = new double[MAX_NOTAS];
        this.quantidadeNotas = 0;
    }

    public boolean cadastrarNota(double nota) {
        if (quantidadeNotas >= MAX_NOTAS) {
            System.out.println("Erro: o aluno já possui " + MAX_NOTAS + " notas cadastradas.");
            return false;
        }
        if (nota < 0 || nota > 10) {
            System.out.println("Erro: a nota deve estar entre 0 e 10.");
            return false;
        }
        notas[quantidadeNotas] = nota;
        quantidadeNotas++;
        return true;
    }

    public double calcularMedia() {
        if (quantidadeNotas == 0) {
            return 0.0;
        }
        double soma = 0;
        for (int i = 0; i < quantidadeNotas; i++) {
            soma += notas[i];
        }
        return soma / quantidadeNotas;
    }

    public boolean estaAprovado() {
        return calcularMedia() >= MEDIA_APROVACAO;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }
}
