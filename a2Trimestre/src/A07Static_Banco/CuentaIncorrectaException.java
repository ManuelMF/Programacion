package A07Static_Banco;

public class CuentaIncorrectaException extends RuntimeException {
	public CuentaIncorrectaException() {
		super();
	}
	public CuentaIncorrectaException(String msg) {
		super(msg);
	}
}
