package br.com.curso.professor;

import br.com.curso.alunos.ValidacaoException;
import br.com.curso.usuarios.Usuario;
import br.com.curso.usuarios.UsuarioAutorizavel;

import java.util.Arrays;
import java.util.List;

public class Professor extends UsuarioAutorizavel {

    public Professor(String login, String cpf, String nome) throws ValidacaoException {
        super(login, cpf, nome);
    }

    // da pra sobrescrever
    @Override
    public boolean temAutorizacao() {
        return super.temAutorizacao();
    }

    @Override
    protected List<String> getAutorizacoes() {
        return Arrays.asList("PROF");
    }

    @Override
    protected boolean verificarAutorizacaoLogin() {
        return true;
    }
}
