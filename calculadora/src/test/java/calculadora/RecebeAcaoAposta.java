package calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class RecebeAcaoAposta implements ActionListener {

	private Jogo jogo;
	private JTextField nome;
	private JComboBox<String> parImpar;
	private JTextField valorApostado;

	public RecebeAcaoAposta(Jogo jogo, JTextField nome, JComboBox<String> parImpar, JTextField valorApostado) {
		this.jogo = jogo;
		this.nome = nome;
		this.parImpar = parImpar;
		this.valorApostado = valorApostado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Pessoa pessoa = new JogadorPeloNome(nome.getText());
		TiposDeResultados tipoResultado = obterTipoDaAposta(parImpar);
		Integer valorApostadoInteiro = Integer.valueOf(valorApostado.getText());
		Jogada jogada = new Jogada(pessoa, valorApostadoInteiro, tipoResultado);
		jogo.joga(jogada);
	}

	private TiposDeResultados obterTipoDaAposta(JComboBox<String> parImpar) {
		return parImpar.getSelectedItem().equals("PAR") ? TiposDeResultados.PAR : TiposDeResultados.IMPAR;
	}

}
