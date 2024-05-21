package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

public class TesteOJogoDeParEImpar {

	@Test
	void joaozinho() throws Exception {
		Pessoa joaozinho = new Jogador();
		assertEquals("Joaozinho", joaozinho.obterNome());
	}

	@Test
	void maria() throws Exception {
		Pessoa maria = new Jogadora();
		assertEquals("Maria", maria.obterNome());
	}

	@Test
	void jogadaDaMaria() throws Exception {
		Pessoa joaozinho = new Jogador();
		Jogada doJoaozinho = new Jogada(joaozinho, 2, TiposDeResultados.PAR);
		assertEquals(Integer.valueOf(2), doJoaozinho.obterValorApostado());
		assertEquals(TiposDeResultados.PAR, doJoaozinho.obterTipoDeResultado());
	}

	@Test
	void jogadaDoJoaozinho() throws Exception {
		Pessoa maria = new Jogadora();
		Jogada daMaria = new Jogada(maria, 1, TiposDeResultados.IMPAR);
		assertEquals(Integer.valueOf(1), daMaria.obterValorApostado());
		assertEquals(TiposDeResultados.IMPAR, daMaria.obterTipoDeResultado());
	}

	@Test
	void jogo() throws Exception {
		Jogo jogo = new JogoDeParEImpar();
		assertNotNull(jogo);
	}

	@Test
	void mariaVitoriosa() throws Exception {
		Pessoa joaozinho = new Jogador();
		Pessoa maria = new Jogadora();
		Jogada daMaria = new Jogada(maria, 1, TiposDeResultados.IMPAR);
		Jogada doJoaozinho = new Jogada(joaozinho, 2, TiposDeResultados.PAR);
		Jogo jogo = new JogoDeParEImpar();
		Rodada rodada = jogo.jogaram(daMaria, doJoaozinho);
		String vitoriosa = rodada.quemVenceu();
		assertEquals("Maria", vitoriosa);
	}

	@Test
	void joaozinhoVitorioso() throws Exception {
		Pessoa joaozinho = new Jogador();
		Pessoa maria = new Jogadora();
		Jogada daMaria = new Jogada(maria, 2, TiposDeResultados.IMPAR);
		Jogada doJoaozinho = new Jogada(joaozinho, 2, TiposDeResultados.PAR);
		Jogo jogo = new JogoDeParEImpar();
		OuveResultado ouvinteDoJoao = new OuveResultado();
		OuveResultado ouvinteDaMaria = new OuveResultado();
		jogo.adicionaOuvinteDeResultado(ouvinteDaMaria);
		jogo.adicionaOuvinteDeResultado(ouvinteDoJoao);
		jogo.joga(daMaria);
		jogo.joga(doJoaozinho);
		jogo.finalizaRodada();
		Rodada rodada = ouvinteDaMaria.obterRodada();
		List<Jogada> vitorioso = rodada.obterVencedoras();
		assertEquals("Joaozinho", vitorioso.get(0).obterJogador().obterNome());
		assertEquals(ouvinteDaMaria.obterRodada(), ouvinteDoJoao.obterRodada());
	}

	@Test
	void telaDoJogo() throws Exception {
		Jogo jogo = new JogoDeParEImpar();
		jogo.adicionaOuvinteDeResultado(new OuveResultado() {
			@Override
			public void fimDeJogo(Rodada rodada) {
				System.out.println(rodada.obterVencedoras());
			
			}
		});
		criaJanela(jogo);
		criaJanela(jogo);
		new Thread(new FinalizadorDeJogo(jogo)).start();
		Thread.sleep(1000000);
	}

	private void criaJanela(Jogo jogo) {
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.setTitle("Jogo de par e impar");
		JLabel etiquetaDoNomeDoJogador = new JLabel("Nome");
		etiquetaDoNomeDoJogador.setBounds(0, 25, 200, 25);
		frame.add(etiquetaDoNomeDoJogador);
		JTextField nome = new JTextField("Nome do Jogador");
		nome.setBounds(201, 25, 200, 25);
		frame.add(nome);
		JLabel etiquetaDoValorApostado = new JLabel("Valor apostado");
		etiquetaDoValorApostado.setBounds(0, 65, 200, 25);
		frame.add(etiquetaDoValorApostado);
		JTextField valorApostado = new JTextField("1");
		valorApostado.setBounds(201, 65, 200, 25);
		frame.add(valorApostado);
		JLabel etiquetaDoResultadoDaAposta = new JLabel("Resultado da aposta");
		etiquetaDoResultadoDaAposta.setBounds(0, 100, 200, 25);
		frame.add(etiquetaDoResultadoDaAposta);
		String[] items = { "PAR", "IMPAR" };
		JComboBox<String> parImpar = new JComboBox<String>(items);
		parImpar.setBounds(201, 100, 200, 25);
		frame.add(parImpar);
		JButton apostar = new JButton("Apostar");
		apostar.addActionListener(new RecebeAcaoAposta(jogo, nome, parImpar, valorApostado));
		apostar.setBounds(201, 140, 200, 25);
		frame.add(apostar);

		JLabel resultado = new JLabel();
		resultado.setBounds(10, 200, 360, 25);

		frame.add(resultado);
		frame.setSize(450, 450);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jogo.adicionaOuvinteDeResultado(new OuveResultado() {
			@Override
			public void fimDeJogo(Rodada rodada) {
				resultado.setText(String.format("O vencedor é %s",rodada.obterVencedoras()));
			}
		});
	}

}
