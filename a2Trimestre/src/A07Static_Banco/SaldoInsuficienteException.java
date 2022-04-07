package A07Static_Banco;

import java.math.BigDecimal;

public class SaldoInsuficienteException extends RuntimeException {

	public SaldoInsuficienteException() {
		super();
	}
	public SaldoInsuficienteException(String msg) {
		super(msg);
	}
}

