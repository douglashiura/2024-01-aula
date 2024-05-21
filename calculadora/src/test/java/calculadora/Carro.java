package calculadora;

public class Carro extends Veiculo {

	private String cor;

	public Carro(Integer rodas) {
		super(rodas);
	}

	public Carro(Integer rodas, String cor) {
		this(rodas);
		this.cor = cor;
	}

	public String obterCor() {
		return cor;
	}
}
