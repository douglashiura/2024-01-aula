package calculadora;

public class Jogada {

	private Integer valorApostado;
	private TiposDeResultados tipo;
	private Pessoa pessoa;

	public Jogada(Pessoa pessoa, Integer valorApostado, TiposDeResultados tipo) {
		this.pessoa = pessoa;
		this.valorApostado = valorApostado;
		this.tipo = tipo;
	}

	public Integer obterValorApostado() {
		return valorApostado;
	}

	public TiposDeResultados obterTipoDeResultado() {
		return tipo;
	}

	public Pessoa obterJogador() {
		return pessoa;
	}

	@Override
	public String toString() {
		return pessoa.obterNome();
	}

}
