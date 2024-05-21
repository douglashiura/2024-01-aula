package calculadora;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class TesteDeConstrutor {

	@Test
	void implicito() throws Exception {
		Veiculo veiculo = new Bicicleta();
		assertNotNull(veiculo);
	}

	@Test
	void comArgumentoChamandoOSuper() throws Exception {
		Integer rodas = 4;
		Veiculo veiculo = new Carro(rodas);
		assertNotNull(veiculo);
	}

	@Test
	void sobrecarregado() throws Exception {
		Integer rodas = 4;
		Veiculo veiculo = new Carro(rodas);
		Veiculo veiculoBanco = new Carro(rodas, "Branco");
		assertNotNull(veiculo);
		assertNotNull(veiculoBanco);
	}

}
