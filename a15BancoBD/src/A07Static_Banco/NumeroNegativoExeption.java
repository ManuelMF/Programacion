package A07Static_Banco;

public class NumeroNegativoExeption extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NumeroNegativoExeption() {
		super();
	}
	public NumeroNegativoExeption(String msg) {
		super("Numero negativo");
	}
}
