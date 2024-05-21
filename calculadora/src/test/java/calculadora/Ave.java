package calculadora;

public class Ave extends Animal implements Voavel {

	@Override
	public String obterHabilidade() {
		return "Voa";
	}

	@Override
	public Integer obterAlturaDoVoo() {
		return 15;
	}

}
