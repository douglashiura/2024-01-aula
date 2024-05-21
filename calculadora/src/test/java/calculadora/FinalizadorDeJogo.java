package calculadora;

public class FinalizadorDeJogo implements Runnable {

	private Jogo jogo;

	public FinalizadorDeJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
			}
			jogo.finalizaRodada();
		}
	}

}
