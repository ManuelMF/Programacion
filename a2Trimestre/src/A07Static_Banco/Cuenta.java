package A07Static_Banco;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;

public class Cuenta implements Serializable, Comparable<Cuenta> {
//	propiedades BIGDecimal saldo,  int numero cuenta,  Cliente cli , movimientos que será una linkedList de movimientos que sera otro objeot / hay que crear una variable static int num sig 
	
//	Metodos:
//	constructor cuenta(cliente c)
//	ingresar dinero con una variable BigDecimal y tambien le pasamos el concepto que sera un string
//	retirar dinero que le pasaremos el importeque y el concepto (hay que hacer comprovaciones si hay dindero y tiene que salir una excepcion que diga saldo insuficiente
//	tendremos que hacer gets de saldo, num cuenta , cliente y movimiendos donde le tendremos que pasar la fecha de inicio y la de fin (nos dara una linkedlist<Movimientos>
	
	private static final long serialVersionUID = 451672592654494688L;
	private BigDecimal saldo;
	private int numeroCuenta;
	private Cliente cli;
	private LinkedList<Movimiento> movimientos;
	public static int numSig=1000;
	private BigDecimal descubierto;
	private int nivelCuenta;
	
	
	public Cuenta(Cliente cliente, int nivelCuenta) {
		this.saldo = new BigDecimal(0);
		this.numeroCuenta=Cuenta.numSig++;
		this.cli=cliente;
		this.movimientos = new LinkedList<Movimiento>();
		this.nivelCuenta = nivelCuenta;
		
		switch (nivelCuenta) {
			case 1:
				this.descubierto=new BigDecimal(20000);
				
				break;
			case 2:
				this.descubierto=new BigDecimal(10000);
				break;
			case 3:
				this.descubierto=new BigDecimal(3000);
				break;
			case 4:
				this.descubierto=new BigDecimal(1000);
				break;	
			case 5:
				this.descubierto=new BigDecimal(400);
				break;
			
			case 6:
				this.descubierto=new BigDecimal(200);
				break;
			}

		
		
		}
	
	public BigDecimal ingresarDinero(BigDecimal dineroIng, String concepto) {
		
//		Movimiento mov=new Movimiento(concepto, dineroIng, this.saldo);
//		this.movimientos.add(mov);
		this.movimientos.addFirst(new Movimiento(concepto, dineroIng, this.saldo));
		
		this.saldo = this.saldo.add(dineroIng);
		
		return this.saldo;
	}
	
	public BigDecimal retirarDinero(BigDecimal dineroRet) {
		
		//MIRAMOS QUE SEA -1 QUE SERIA QUE EL TOTAL ES NEGATIVO (NO HAY DINERO)
		if (-1==saldo.add(descubierto).compareTo(dineroRet)) {
			
			throw new SaldoInsuficienteException("Saldo actual:"+this.saldo+" y quieres sacar "+dineroRet);
		}
		
		this.movimientos.addFirst(new Movimiento("Retirada en efectivo",dineroRet.negate(),this.saldo));
		this.saldo=this.saldo.subtract(dineroRet);
		
		return this.saldo;
	}
	
	public LinkedList<Movimiento> bucarMovimientos(Date fechaIni, Date fechaFin){
		
		LinkedList<Movimiento> lista = new LinkedList<Movimiento>();
		
		for (Movimiento m:this.movimientos) {
			if (m.getFecha().compareTo(fechaIni)>=0 && m.getFecha().compareTo(fechaFin)<=0){
				lista.add(m);
				
			}
		}
		return lista;
	}
	
	public BigDecimal getSaldo() {
		return saldo;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public Cliente getCli() {
		return cli;
	}
	public LinkedList<Movimiento> getMovimientos() {
		return movimientos;
	}

	public int getNivelCuenta() {
		return nivelCuenta;
	}

	@Override
	public int compareTo(Cuenta o) {
		return this.saldo.compareTo(o.saldo);
	}

	
}
