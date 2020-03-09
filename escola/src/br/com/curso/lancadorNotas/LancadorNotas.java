package br.com.curso.lancadorNotas;

import br.com.curso.usuarios.Usuario;
import br.com.curso.usuarios.UsuarioAutorizavel;

public class LancadorNotas {

    public void login(UsuarioAutorizavel usuario) { //pelo polimorfismo vc pode passar o usuario professor ou coordenador
        boolean temAutorizacao = usuario.temAutorizacao();
        if(temAutorizacao) {
            System.out.println("Usuario tem autorizaçao");
        } else {
            System.out.println("Nao tem autorizaçao");
        }
    }
}
