package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		double inss = calcularInss(salarioBase);
		double novoSalario = salarioBase - inss;
		double salarioLiquido = Math.round(novoSalario - calcularIrrf(novoSalario));

		return salarioLiquido <= 1039 ? 0 : (long) salarioLiquido;
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		if ( salarioBase <= 1500) {
			return salarioBase*0.08;
		}
		if (salarioBase <= 4000) {
			return salarioBase*0.09;
		}
		return salarioBase*0.11;
	}

	private double calcularIrrf(double salarioBase) {
		if ( salarioBase <= 3000) {
			return 0;
		}
		if (salarioBase <= 6000) {
			return salarioBase*0.075;
		}
		return salarioBase*0.15;
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/