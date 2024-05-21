package calculadora;

import java.util.ArrayList;
import java.util.List;

public class Rodada {

	private String quemVenceu;
	private List<Jogada> vencedoras;

	public Rodada(Jogada daMaria, Jogada doJoaozinho) {
		Integer valorApostadoDaMaria = daMaria.obterValorApostado();
		Integer valorApostadoDoJoaozinho = doJoaozinho.obterValorApostado();
		Calculadora calculadora = new Calculadora();
		Integer soma = calculadora.somador(valorApostadoDaMaria, valorApostadoDoJoaozinho);
		boolean ehParValoresApostados = soma % 2 == 0;
		TiposDeResultados obterTipoDeResultado = daMaria.obterTipoDeResultado();
		boolean ehParMaria = obterTipoDeResultado.equals(TiposDeResultados.PAR);
		Jogada vencedora = doJoaozinho;
		if (ehParValoresApostados == ehParMaria) {
			vencedora = daMaria;
		}
		Pessoa jogador = vencedora.obterJogador();
		quemVenceu = jogador.obterNome();
	}

	public Rodada(List<Jogada> jogadas) {
		Integer soma = 0;
		for (Jogada jogada : jogadas) {
			soma += jogada.obterValorApostado();
		}
		boolean ehParValoresApostados = soma % 2 == 0;
		if (ehParValoresApostados) {
			vencedoras = todasAsJogadasPeloFiltro(jogadas, TiposDeResultados.PAR);
		} else {
			vencedoras = todasAsJogadasPeloFiltro(jogadas, TiposDeResultados.IMPAR);
		}
	}

	private List<Jogada> todasAsJogadasPeloFiltro(List<Jogada> jogadas, TiposDeResultados filtro) {
		List<Jogada> apostasFiltradas = new ArrayList<Jogada>();
		for (Jogada jogada : jogadas) {
			TiposDeResultados obterTipoDeResultado = jogada.obterTipoDeResultado();
			boolean ehApostaDoFiltro = obterTipoDeResultado.equals(filtro);
			if (ehApostaDoFiltro) {
				apostasFiltradas.add(jogada);
			}
		}
		return apostasFiltradas;
	}

	public String quemVenceu() {
		return quemVenceu;
	}

	public List<Jogada> obterVencedoras() {
		return vencedoras;
	}
}
