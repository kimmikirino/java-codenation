package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Jogador {
    Long id;
    Long idTime;
    String nome;
    LocalDate dataNascimento;
    Integer nivelHabilidade;
    BigDecimal salario;

    public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        this.setId(id);
        this.setNome(nome);
        this.setIdTime(idTime);
        this.setDataNascimento(dataNascimento);
        this.setNivelHabilidade(nivelHabilidade);
        this.setSalario(salario);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setIdTime(Long idTime) {
        this.idTime = idTime;
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {
        this.nivelHabilidade = nivelHabilidade;
    }

    public void setNome(String nome) {
        if(validaNome(nome)){
            this.nome = nome;
        }else{
            new NullPointerException("Nome é obrigatório");
        }
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public Long getIdTime() {
        return idTime;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    private boolean validaNome(String nome){
        return nome != null && !nome.isEmpty() && nome.length() > 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return id.equals(jogador.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", idTime=" + idTime +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nivelHabilidade=" + nivelHabilidade +
                ", salario=" + salario +
                '}';
    }
}
