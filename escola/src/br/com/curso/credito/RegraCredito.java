package br.com.curso.credito;

public class RegraCredito {

    private String nome;
    private String referencia;
    private long valorReferencia;
    private RegraValor regra;

    public enum RegraValor {
        MAX, MIN
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public long getValorReferencia() {
        return valorReferencia;
    }

    public void setValorReferencia(long valorReferencia) {
        this.valorReferencia = valorReferencia;
    }

    public RegraValor getRegra() {
        return regra;
    }

    public void setRegra(RegraValor regra) {
        this.regra = regra;
    }
}
