package br.com.curso.alunos;

import br.com.curso.usuarios.Usuario;

public class Aluno extends Usuario {

    private Integer numeroMatricula;

    public Aluno(String login, String cpf, String nome) throws ValidacaoException{
        super(login, cpf, nome);
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
