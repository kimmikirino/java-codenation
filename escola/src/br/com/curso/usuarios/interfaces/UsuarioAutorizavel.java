package br.com.curso.usuarios.interfaces;

public interface UsuarioAutorizavel {
    default boolean temAutorizacao() {
        return true;
    }
}
