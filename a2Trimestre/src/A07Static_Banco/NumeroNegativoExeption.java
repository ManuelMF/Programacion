package A07Static_Banco;

public class NumeroNegativoExeption extends RuntimeException {
	public NumeroNegativoExeption() {
		super();
	}
	public NumeroNegativoExeption(String msg) {
		super("Numero negativo");
	}
}
