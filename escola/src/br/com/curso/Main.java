package br.com.curso;

import br.com.curso.alunos.Aluno;
import br.com.curso.alunos.ValidacaoException;
import br.com.curso.coordenador.Coordenador;
import br.com.curso.diretor.Diretor;
import br.com.curso.disciplinas.Disciplina;
import br.com.curso.disciplinas.LimiteAlunoAlcancadoException;
import br.com.curso.lancadorNotas.LancadorNotas;
import br.com.curso.professor.Professor;
import br.com.curso.relatorios.GerarRelatorio;
import br.com.curso.usuarios.Usuario;
import br.com.curso.usuarios.UsuarioAutorizavel;
import br.com.curso.usuarios.repositorios.RepositorioUsuario;

import java.util.ArrayList;
import java.util.List;
import java.util.PropertyPermission;

public class Main {

    public static void main(String[] args) throws ValidacaoException {
//        Professor professorMatematica = null;
//        RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
//        try {
//            professorMatematica = new Professor("prof1", "33455566699", "Joao da Silva");
//            Aluno aluno = new Aluno("aluno1", "000111555", "aluno 1 teste");
//            Disciplina disciplina = new Disciplina("Matematica", professorMatematica);
//            disciplina.matricular(aluno);
//            disciplina.matricular(new Aluno("aluno2", "000111555", "aluna emili"));
//
////            for (int i =0; i < 15 ; i++) {
////                disciplina.matricular(new Aluno("aluno2", "000111555", "aluna emili"));
////            }
//
////            disciplina.mostrarAlunos();
//            repositorioUsuario.add(professorMatematica);
//            repositorioUsuario.add(aluno);
//            repositorioUsuario.todosUsuarios().stream().forEach(System.out::println);
//
//        } catch (ValidacaoException | LimiteAlunoAlcancadoException e) {
//            System.out.println(e.getMessage());
//        }
//
//        UsuarioAutorizavel usuarioProfessor = new Professor("prof1", "33455566699", "Joao da Silva");
//        UsuarioAutorizavel usuarioCoordenacao = new Coordenador("prof1", "33455566699", "Joao da Silva");
//        UsuarioAutorizavel usuarioDiretor = new Diretor("diretor", "33455566699", "Diretor da Silva");
//        Usuario aluno = new Aluno("Aluno1", "33455566699", "Aluninho da Silva");


//        verificarAutorizacao(usuarioProfessor);
//        verificarAutorizacao(usuarioDiretor);
//        verificarAutorizacao((UsuarioAutorizavel) aluno);

//        LancadorNotas lancadorNotas = new LancadorNotas();
//        lancadorNotas.login(usuarioCoordenacao);
//        lancadorNotas.login(usuarioProfessor);

        //Testes de annotation

        GerarRelatorio gerar = new GerarRelatorio();
        Diretor diretor = new Diretor("diretor", "33455566699", "Diretor da Silva");
        Usuario usuario = new Aluno("Aluno1", "33455566699", "Aluninho da Silva");
        List<Object> usuarios = new ArrayList<>();

        diretor.setDataCargo("2020/01/01");
        Usuario usuario2 = new Aluno("Aluno2", "33455566699", "Aluninho da Silva");

        usuarios.add(usuario);
//        usuarios.add(diretor);
        usuarios.add(usuario2);

        gerar.gerarRelatorio(usuarios, 2);
    }

    public static void verificarAutorizacao(UsuarioAutorizavel usuario) {
        if(usuario.temAutorizacao()){
            System.out.println("Tem autorizaçao");
        }
    }
}
