package challenge;

import java.util.Objects;

public class Motorista {

    private final String nome;

    private final int idade;

    private final int pontos;

    private final String habilitacao;

    private Motorista(String nome, int idade, int pontos, String habilitacao) {
        this.nome = nome;
        this.idade = idade;
        this.pontos = pontos;
        this.habilitacao = habilitacao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public boolean motoristaMenorIdade() {
        return this.getIdade() < 18;
    }

    public boolean motoristaCarteiraSuspensa() {
        return this.getPontos() > 20;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(habilitacao);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }

        public MotoristaBuilder withNome(String nome) {
            if(validaNome(nome)){
                throw new NullPointerException("O motorista deve ter um nome informado");
            }
            this.nome = nome;
            return this;
        }

        public MotoristaBuilder withIdade(int idade) {
            if(validaIdade(idade)){
                throw  new IllegalArgumentException ("O motorista tem que ter idade maior ou igual a 18 anos");
            }
            this.idade = idade;
            return this;
        }

        public MotoristaBuilder withPontos(int pontos) {
            if(validaPontos(pontos)) {
                throw new IllegalArgumentException("O motorista tem deve informar a pontução de sua carteira");
            }
            this.pontos = pontos;
            return this;
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) {
            if(validaNome(habilitacao)) {
                throw  new  NullPointerException ("O motorista deve ter habilitação informada");
            }
            this.habilitacao = habilitacao;
            return this;
        }

        private boolean validaNome(String nome){
            return nome.trim().isEmpty();
        }

        private boolean validaIdade(int idade){
            return idade < 0;
        }

        private  boolean validaPontos(int pontos) {
            return pontos < 0;
        }

        public Motorista build() {
            validaNome(nome);
            withHabilitacao(habilitacao);
            return new Motorista(nome, idade, pontos, habilitacao);
        }
    }
}
