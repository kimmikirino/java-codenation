package br.com.curso.credito.externo;

public class Pessoa {

    private String cpf;
    private String nome;
    private long scoreSerasa;
    private long sccoreSPC;
    private long qtdChequeDevolvido;
    private long valorDivida;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getScoreSerasa() {
        return scoreSerasa;
    }

    public void setScoreSerasa(long scoreSerasa) {
        this.scoreSerasa = scoreSerasa;
    }

    public long getSccoreSPC() {
        return sccoreSPC;
    }

    public void setSccoreSPC(long sccoreSPC) {
        this.sccoreSPC = sccoreSPC;
    }

    public long getQtdChequeDevolvido() {
        return qtdChequeDevolvido;
    }

    public void setQtdChequeDevolvido(long qtdChequeDevolvido) {
        this.qtdChequeDevolvido = qtdChequeDevolvido;
    }

    public long getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(long valorDivida) {
        this.valorDivida = valorDivida;
    }
}
