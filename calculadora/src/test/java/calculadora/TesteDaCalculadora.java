package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TesteDaCalculadora {

	@Test
	void soma() {
		Integer primeiraParcela = 20;
		Integer segundaParcela = 2;
		Integer soma = new Calculadora().somador(primeiraParcela, segundaParcela);
		assertEquals(Integer.valueOf(22), soma);
	}

	@Test
	void divisao() throws Exception {
		Float divisao = new Calculadora().divisora(6, 3);
		assertEquals(Float.valueOf(2f), divisao);
	}

	@Test
	void divisaoFlutuante() throws Exception {
		Calculadora calculadora = new Calculadora();
		assertEquals(Float.valueOf(2.5f), calculadora.divisora(5, 2));
	}

	@Test
	void multiplicacao() throws Exception {
		Calculadora calculadora = new Calculadora();
		assertEquals(Integer.valueOf(12), calculadora.multiplique(3, 4));
	}

}
