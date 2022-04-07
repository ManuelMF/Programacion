package A07Static_Banco;

public class CuentaIncorrectaException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CuentaIncorrectaException() {
		super();
	}
	public CuentaIncorrectaException(String msg) {
		super(msg);
	}
}
