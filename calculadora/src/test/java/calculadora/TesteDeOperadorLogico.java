package calculadora;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TesteDeOperadorLogico {

	@Test
	void joaozinhoAltoEMagro() throws Exception {
		Integer altura = 185;
		Integer peso = 75;
		Boolean ehMagro = altura > 180 && peso <= 85;
		assertTrue(ehMagro);
	}

	@Test
	void ehMagroComIf() throws Exception {
		Integer altura = 185;
		Integer peso = 75;
		Boolean ehMagro = false;
		if (altura > 180 && peso <= 85) {
			ehMagro = true;
		}else {
			ehMagro=false;
		}
		assertTrue(ehMagro);
	}

}
