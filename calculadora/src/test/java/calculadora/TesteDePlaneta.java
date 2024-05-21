package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TesteDePlaneta {

	@Test
	void terra() throws Exception {
		Planeta terra = new Terra();
		assertEquals(Float.valueOf(9.8f), terra.obterGravidade());
	}

	@Test
	void marte() throws Exception {
		Planeta marte = new Marte();
		assertEquals(Float.valueOf(3.71f), marte.obterGravidade());
	}

}
