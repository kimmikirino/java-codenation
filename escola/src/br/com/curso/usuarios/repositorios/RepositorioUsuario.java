package br.com.curso.usuarios.repositorios;

import br.com.curso.usuarios.Usuario;

import java.util.*;

public class RepositorioUsuario {

    private List<Usuario> usuarios = new ArrayList<>();

    public void add(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void delete(Usuario usuario) {
        this.usuarios.remove(usuario);
    }

    public Usuario budca(String cpf) {
        for(Usuario usuario: usuarios) {
            if(usuario.getCpf().equals((cpf))){
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> todosUsuarios() {
        return this.usuarios;
    }
}
