package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TesteDeInterface {

	@Test
	void ave() throws Exception {
		Voavel tucano = new Ave();
		assertEquals(Integer.valueOf(15), tucano.obterAlturaDoVoo());
	}

	@Test
	void aeronave() throws Exception {
		Voavel aviaoMonoMotor = new Aeronave();
		assertEquals(Integer.valueOf(10000), aviaoMonoMotor.obterAlturaDoVoo());

	}

}
