package br.com.curso.disciplinas;

import br.com.curso.alunos.Aluno;
import br.com.curso.professor.Professor;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {

    private String nome;
    private List<Aluno> alunos = new ArrayList<>();
    private static final byte LIMITE = 10;


    public Disciplina(String nome,Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }


    private Professor professor;

    public void matricular(Aluno aluno) throws LimiteAlunoAlcancadoException{
        if(this.alunos.size() < LIMITE) {
            this.alunos.add(aluno);
        } else {
            throw new LimiteAlunoAlcancadoException("Limite de alunos alcançado.");
        }
    }

    public void mostrarAlunos() {
        this.alunos.stream().forEach(aluno -> System.out.println(aluno.getNome()));
    }
}
