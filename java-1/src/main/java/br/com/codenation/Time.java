package br.com.codenation;

import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Time {
    Long id;
    String nome;
    LocalDate dataCriacao;
    String corUniformePrincipal;
    String corUniformeSecundario;
    Long idJogadorCapitao;
    List<Jogador> jogadores = new ArrayList<>();


    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincial, String corUniformeSecundario ) {
        this.setId(id);
        this.setNome(nome);
        this.setCorUniformePrincial(corUniformePrincial);
        this.setCorUniformeSecundario(corUniformeSecundario);
        this.setDataCriacao(dataCriacao);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCorUniformePrincial(String corUniformePrincipal) {
        this.corUniformePrincipal = corUniformePrincipal;
    }

    public void setCorUniformeSecundario(String corUniformeSecundario) {
        this.corUniformeSecundario = corUniformeSecundario;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void addJogador(Jogador jogador) {
        if (jogadores.contains(jogador)) {
            throw new IdentificadorUtilizadoException("Jogador ja foi adicionado no time");
        } else {
            jogadores.add(jogador);
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public void setIdJogadorCapitao(Long idJogadorCapitao) {
        this.idJogadorCapitao = idJogadorCapitao;
    }

    public Long getIdJogadorCapitao() {
        return idJogadorCapitao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time)) return false;
        Time time = (Time) o;
        return getId().equals(time.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
