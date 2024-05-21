package calculadora;

public class Calculadora {
	public Integer somador(Integer primeiraParcela, Integer segundaParcela) {
		Integer soma = primeiraParcela + segundaParcela;
		return soma;
	}

	public Float divisora(Integer dividendo, Integer divisor) {
		return (float) dividendo / divisor;
	}

	public Integer multiplique(Integer fatorUm, Integer fatorDois) {
		return fatorUm * fatorDois;
	}

}
