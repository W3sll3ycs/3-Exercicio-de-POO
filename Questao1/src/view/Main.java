import model.Aluno;
import model.Turma;

void main (String[] args) {
    Turma turma = new Turma(3);

    Aluno a1 = new Aluno("Maria", "20261001");
    a1.cadastrarNota(8.0);
    a1.cadastrarNota(7.5);
    a1.cadastrarNota(9.0);
    a1.cadastrarNota(8.5);

    Aluno a2 = new Aluno("João", "20261002");
    a2.cadastrarNota(5.0);
    a2.cadastrarNota(6.0);
    a2.cadastrarNota(4.5);
    a2.cadastrarNota(7.0);

    Aluno a3 = new Aluno("Ana", "20261003");
    a3.cadastrarNota(7.0);
    a3.cadastrarNota(7.0);
    a3.cadastrarNota(7.0);
    a3.cadastrarNota(7.0);

    turma.adicionarAluno(a1);
    turma.adicionarAluno(a2);
    turma.adicionarAluno(a3);

    turma.listarAprovados();
    turma.listarReprovados();
}


