package calculadora;

public class JogadorPeloNome extends Pessoa {

	private String nome;

	public JogadorPeloNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String obterNome() {
		return nome;
	}

}
