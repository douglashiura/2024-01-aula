package calculadora;

public class OuveResultado {

	private Rodada rodada;

	public Rodada obterRodada() {
		return rodada;
	}

	public void fimDeJogo(Rodada rodada) {
		this.rodada = rodada;
	}

}
