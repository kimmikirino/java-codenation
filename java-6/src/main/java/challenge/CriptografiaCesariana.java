package challenge;

public class CriptografiaCesariana implements Criptografia {

    byte quantidade = 3;
    @Override
    public String criptografar(String texto) {

        if(texto == ""){
            throw new IllegalArgumentException("String vazia");
        }
        String novoTexto = texto.toLowerCase();
        String resultado = new String("");
        for (int i = 0; i < novoTexto.length(); i++) {
            if ((int)novoTexto.charAt(i) > 96 & (int)novoTexto.charAt(i) < 123 ) {
                resultado += (char) (((int) novoTexto.charAt(i) +
                        quantidade - 97) % 26 + 97);
            } else {
                resultado += novoTexto.charAt(i);
            }
        }

        return resultado;
    }

    @Override
    public String descriptografar(String texto) {

        if(texto == ""){
            throw new IllegalArgumentException("String vazia");
        }
        String novoTexto = texto.toLowerCase();
        String resultado = new String("");

        for (int i = 0; i < novoTexto.length(); i++) {
            if ((int)novoTexto.charAt(i) > 96 & (int)novoTexto.charAt(i) < 123 ) {
                resultado += (char)(((int)novoTexto.charAt(i) +
                        23 - 97) % 26 + 97);
            } else {
                resultado += novoTexto.charAt(i);
            }

        }

        return resultado;
    }
}
