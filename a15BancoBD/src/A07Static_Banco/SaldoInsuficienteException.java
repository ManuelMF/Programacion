package A07Static_Banco;

public class SaldoInsuficienteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SaldoInsuficienteException() {
		super();
	}
	public SaldoInsuficienteException(String msg) {
		super(msg);
	}
}

