package calculadora;

public class Terra extends Planeta {

	@Override
	public Float obterGravidade() {
		return Float.valueOf(9.8f);
	}

}
