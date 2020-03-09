package br.com.curso.usuarios;

import br.com.curso.alunos.ValidacaoException;

import java.util.List;

// conceitos de classes abstratas
// modelo que as classes que herdam deveriam seguir
// nao precisa ser instaciada
public abstract class UsuarioAutorizavel extends Usuario{

    public UsuarioAutorizavel(String login, String cpf, String nome) throws ValidacaoException {
        super(login, cpf, nome);
    }

    public boolean temAutorizacao() {
        List<String> autorizacoes = getAutorizacoes();
        return autorizacoes.contains("ADMIN") || verificarAutorizacaoLogin();
    } // hook, template

    //apenas as filhas e ela tem acesso
    protected abstract List<String> getAutorizacoes();

    protected abstract boolean verificarAutorizacaoLogin();
}
