package A07Static_Banco;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Movimiento implements Serializable, Comparable<Movimiento>  {
//	Propiedades Fecha,concepto, importe puede ser positivo o negativo asi sabremos si en un ingreso o retirada,el saldo anterior
	
//	Metodos:
//	constuctor que se pasara el concepto , el importe que será BigDecimal y el saldo que sera BigDecimal
//	mas getters de fecha concepto importe y saldo anterior
	
	
	//private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY HH:mm");
	
	private static final long serialVersionUID = -4579715984792543481L;

	private String concepto;
	
	private BigDecimal importe;
	
	private BigDecimal saldoActual;
	
	private BigDecimal saldoAnterior;
	
	private Fecha fecha;
	
	
	
	public Movimiento (String concepto, BigDecimal importe, BigDecimal saldoAnterior) {
		
		this.concepto = concepto;
		this.importe = importe;
		this.saldoAnterior = saldoAnterior;
		this.saldoActual=saldoAnterior.add(importe);
		
//		this.fecha = formato.format(new Date());
		this.fecha = new Fecha();
	}

	public BigDecimal getSaldoActual() {
		return this.saldoActual;
	}

	public BigDecimal getImporte() {
		return this.importe;
	}

	public String getConcepto() {
		return this.concepto;
	}

	public Fecha getFecha() {
		return this.fecha;
	}

	public BigDecimal getSaldoAnterior() {
		return this.saldoAnterior;
	}

	@Override
	public int compareTo(Movimiento o) {

		return this.fecha.compareTo(o.fecha);
		
	}
	
	
	
	
	
	
	
}
