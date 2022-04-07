package A07Static_Banco;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import a14ListaBD.Conexion;
import a14ListaBD.Producto;
// implements Serializable para guardar la info de los objetos
public class Banco implements Serializable {
	
//	propiedades nombre, lista de cuentas LinkedLikst<Cuenta> que crea muchas cunetas
//	metodos: 
//	constructor que le pasaremos el nombre Banco(String n)
//	Crear una cuenta donde le pasaremos un objeto cliente esto devolvera una cuenta
//	Eliminar cuenta y necesitara una cuenta  
//	Dinero total en el banco devolvera el n total BIGDecimal 
//	Buscar cuenta se le pasa en numero de cuenta si no la encuentra null
//	buscar cuenta pero por dni que devolvera una linkedlist de tipo cuenta donde podra elegir entre cuentas y entrar en esas cuentas

	private static final long serialVersionUID = -325800570260286560L;
	private String nombre;
	private LinkedList<Cuenta> ListaCuentas;
	static Scanner sc=new Scanner(System.in);

	public Banco(String nombre) {
		this.nombre=nombre;
		ListaCuentas = new LinkedList<Cuenta>();
	}
	
	public Cuenta CrearCuenta(Cliente cliente,int nivelCuenta) {
		
		Cuenta cuenta= new Cuenta(cliente,nivelCuenta);
		this.ListaCuentas.add(cuenta);
		return cuenta;
	}
	
	public void EliminarCuenta(Cuenta cuenta) {
		if (this.ListaCuentas.contains(cuenta)) {
		this.ListaCuentas.remove(cuenta);
		} else System.out.println("No existe esta cuenta");
	}
	
	public BigDecimal SaldoTotal() {
		
		BigDecimal total = new BigDecimal(0);
		
		for (Cuenta c: this.ListaCuentas) {
			total = total.add(c.getSaldo());
		}
		
		return total;
	}
	
	public Cuenta BuscarCuenta(int numeroCuenta) {
		for (Cuenta c : this.ListaCuentas) if (c.getNumeroCuenta()==numeroCuenta) return c;
		
		return null;
	}
	
	public Cuenta BuscarCuenta(String DNI, int añadirMuchasCuentas) {
		LinkedList<Cuenta> CuentasPorDNI = new LinkedList<Cuenta>();
		
		for (Cuenta c:this.ListaCuentas) if (c.getCli().getDni().equalsIgnoreCase(DNI)) CuentasPorDNI.add(c);
		
		// esto no va aqui tiene que ir en el main
		if (añadirMuchasCuentas==1) {
			
			return CuentasPorDNI.getFirst();
			
		}	else if (CuentasPorDNI.isEmpty() && añadirMuchasCuentas==0) {
				
				return null;
				
			}	else if (CuentasPorDNI.size()==1) {
				
				return CuentasPorDNI.getFirst(); 
				
				}	else {
					
						if (añadirMuchasCuentas==0) {
							
							int x=1;
							System.out.println("A que cuenta quieres entrar");
							
							// ordenar las cuentas 
							Collections.sort(CuentasPorDNI,Collections.reverseOrder());							
							
							for (Cuenta c:CuentasPorDNI) {
								System.out.println(x+": "+c.getNumeroCuenta()+" con un total de "+c.getSaldo()+"€");
								x++;
							}
							
							int num=0;
							boolean error=true;
							
							do {
								try {
									num= Integer.parseInt(sc.nextLine()); 
									
									if (num==0) throw new RuntimeException();
									
									error=false;
									
								} catch (RuntimeException e) {
									System.out.println("Caracter invalido");
								}
							} while (error);
							
							return CuentasPorDNI.get(num-1);
						} else {return CuentasPorDNI.getFirst();}
					}
	}

	/*public LinkedList<Cuenta> getCuenta() {
		
		
		return (LinkedList<Cuenta>) ListaCuentas.clone();
	}*/
	
	public void guardarDatos() {
		//para guardar los datos usamos FileOutPutStream
		// try por si hay fallos
		try {
			FileOutputStream fos = new FileOutputStream("Datos.dat");
//			el encargado de enviar a guardar objetos
			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			el objeto que vamos a guardar
			// this hace referencia al objeto de la paj (banco)
			oos.writeObject(this);
			
			oos.writeObject(Cuenta.numSig);
			oos.close();
			
		} catch (Exception e) {
			System.out.println("Error guardando datos");
		}
	}
}
