package br.com.curso.coordenador;

import br.com.curso.alunos.ValidacaoException;
import br.com.curso.usuarios.Usuario;
import br.com.curso.usuarios.UsuarioAutorizavel;

import java.util.Arrays;
import java.util.List;

public class Coordenador extends UsuarioAutorizavel {
    private Long matricula;
    public Coordenador(String login, String cpf, String nome) throws ValidacaoException {
        super(login, cpf, nome);
    }

    @Override
    protected List<String> getAutorizacoes() {
        return Arrays.asList("COORD");
    }

    @Override
    protected boolean verificarAutorizacaoLogin() {
        return false;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }
}
