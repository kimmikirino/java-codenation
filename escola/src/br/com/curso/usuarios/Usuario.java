package br.com.curso.usuarios;

import br.com.curso.alunos.ValidacaoException;
import br.com.curso.relatorios.Coluna;

public class Usuario {
    private String login;
    private String cpf;
    private String nome;

    public Usuario(String login, String cpf, String nome) throws ValidacaoException{
        setLogin(login);
        setCpf(cpf);
        setNome(nome);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws ValidacaoException {
        if (validaLogin(login)) {
            this.login = login;
        } else throw new ValidacaoException("Login invalido");

    }

    @Coluna(posicao = 2, titulo = "CPF")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws ValidacaoException{
        if (validaCPF(cpf)) {
            this.cpf = cpf;
        } else throw new ValidacaoException("CPF invalido");
    }

    @Coluna(posicao = 1, titulo = "NOME")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean validaLogin(String login) {
        return login != null && !login.isEmpty() && login.length() > 3 && login.length() < 20;
    }

    public boolean validaCPF(String cpf) {
        return cpf != null && !cpf.isEmpty();
    }

    @Override
    public String toString() {
        return  this.getNome();
    }
}
