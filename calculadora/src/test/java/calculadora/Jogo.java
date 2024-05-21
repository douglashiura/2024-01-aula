package calculadora;

import java.util.ArrayList;
import java.util.List;

public class Jogo {

	private List<Jogada> jogadas;
	private List<OuveResultado> ouvintes;

	public Jogo() {
		ouvintes = new ArrayList<>();
		jogadas = new ArrayList<Jogada>();
	}

	public Rodada jogaram(Jogada daMaria, Jogada doJoaozinho) {
		return new Rodada(daMaria, doJoaozinho);
	}

	public void joga(Jogada jogada) {
		jogadas.add(jogada);
	}
	
	

	public void adicionaOuvinteDeResultado(OuveResultado ouvinte) {
		this.ouvintes.add(ouvinte);

	}

	public void finalizaRodada() {
		Rodada rodada = new Rodada(jogadas);
		for (OuveResultado ouvinte : ouvintes) {
			ouvinte.fimDeJogo(rodada);
		}
		jogadas= new ArrayList<Jogada>();
	}

}
