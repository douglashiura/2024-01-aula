package calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AnimalTest {
	
	@Test
	void tucano() throws Exception {
		Animal tucano = new Ave();
		assertEquals("Voa", tucano.obterHabilidade());
	}
	
	@Test
	void peixe() throws Exception {
		Animal nemo = new Peixe();
		assertEquals("Nada", nemo.obterHabilidade());
	}
	
}
