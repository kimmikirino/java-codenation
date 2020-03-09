package br.com.curso.diretor;

import br.com.curso.alunos.ValidacaoException;
import br.com.curso.relatorios.Coluna;
import br.com.curso.usuarios.Usuario;
import br.com.curso.usuarios.UsuarioAutorizavel;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Diretor extends UsuarioAutorizavel {
    private String dataCargo;
    public Diretor(String login, String cpf, String nome) throws ValidacaoException {
        super(login, cpf, nome);
    }

    @Coluna(posicao = 3, titulo = "Data do cargo")
    public String getDataCargo() {
        return dataCargo;
    }

    public void setDataCargo(String dataCargo) {
        this.dataCargo = dataCargo;
    }

    @Override
    protected List<String> getAutorizacoes() {
        return Arrays.asList("ADMIN");
    }

    @Override
    protected boolean verificarAutorizacaoLogin() {
        return true;
    }
}
