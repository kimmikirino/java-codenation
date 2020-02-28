package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    List<Carro> vagas = new ArrayList<>();

    public void estacionar(Carro carro) {

        if(!carro.temMotorista()){
            throw new EstacionamentoException("Carro sem motorista!");
        }

        if(carro.getMotorista().motoristaMenorIdade()) {
            throw new EstacionamentoException("Motorista menor de idade!");
        }

        if(carro.getMotorista().motoristaCarteiraSuspensa()) {
            throw new EstacionamentoException("Motorisca com carteira suspensa!");
        }

        if(this.vagas.size() == 10) {
            for (Carro temp : this.vagas) {
                if(temp.getMotorista().getIdade() < 55) {
                    this.vagas.remove(temp);
                    this.vagas.add(carro);
                    break;
                }
            }

            if(!carroEstacionado(carro)) {
                throw new EstacionamentoException("Estacionamento cheio");
            }
        } else {
            this.vagas.add(carro);
        }
    }
    public int carrosEstacionados() {
        return this.vagas.size();
    }
    public boolean carroEstacionado(Carro carro) {
        return this.vagas.contains(carro);
    }
}