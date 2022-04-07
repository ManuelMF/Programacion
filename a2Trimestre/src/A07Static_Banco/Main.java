package A07Static_Banco;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;



public class Main {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws NumeroNegativoExeption {
		
		Banco banco;
		//		cargar datos FileOutputStream 
		try {
			FileInputStream fis=new FileInputStream("Datos.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			
			// le volvemos a dar valor
			banco=(Banco)ois.readObject();
			// lo mismo
			Cuenta.numSig=(int)ois.readObject();
			
			ois.close();
		} catch (Exception e1) {
			// si hay error lo creas
			banco = new Banco("Santander");
		}
		
		boolean salir=false;
		
		
		do {
			System.out.println("Banco Santander");
			System.out.println("--------------------------------------");
			System.out.println("Que operacion quieres hacer");
			System.out.println("1) Añadir una cuenta");
			System.out.println("2) Eliminar una cuenta");
			System.out.println("3) Saldo total del banco");
			System.out.println("4) Buscar cuenta");
			System.out.println("5) Apagar");
			
			Cuenta cuenta=null;
			
			switch (sc.nextLine()) {
			
				case "1":
					String DNICliente="";
					boolean error=true;
					String nombreCliente="";
					int nivelCuenta=4;
					
					do {
						try {
							System.out.println("DNI del cliente");
							DNICliente = sc.nextLine();
						
							if (DNICliente.length()!=9)  throw new RuntimeException();
							error=false;
						} catch (RuntimeException e) {
							System.out.println("DNI erroneo");
						}
					} while(error);
					
//				mirar
					if (banco.BuscarCuenta(DNICliente,0)==null) {
						error=true;
						
						do {
							try {
								System.out.println("Nombre del cliente");
								nombreCliente = sc.nextLine();
								
								if (nombreCliente.length() < 3) throw new RuntimeException();
								
								error=false;
							} catch (RuntimeException e) {
								System.out.println("Introduce un nombre valido por favor");
							} 
						} while (error);
						
						
						Cliente cliente = new Cliente(nombreCliente,DNICliente);
						
						System.out.println("Nivel de cuenta del usuario");
						nivelCuenta = Integer.parseInt(sc.nextLine());
						cuenta=banco.CrearCuenta(cliente,nivelCuenta);
						
					} else {
						nombreCliente=banco.BuscarCuenta(DNICliente,1).getCli().getNombre();
						Cliente cliente = new Cliente(nombreCliente,DNICliente);
						
						
						nivelCuenta = banco.BuscarCuenta(DNICliente,1).getNivelCuenta();
						cuenta=banco.CrearCuenta(cliente,nivelCuenta);
					}
					break;
				case "2":
					error=true;
					String resp="";
					
					do {
						try {
							System.out.println("Eliminar cuenta por\n1) Numero de cuenta \n2) DNI ");
							resp = sc.nextLine();
						
							if (resp.equals("1")||resp.equals("2")) throw new RuntimeException();
							
							error=false;
						} catch (RuntimeException e) {
							System.out.println("Numero invalido");
						}
					} while (error);
			
					switch (resp) {
						case "1":
							System.out.println("Introduce el número de cuenta");
							banco.EliminarCuenta(banco.BuscarCuenta(Integer.parseInt(sc.nextLine())));
							break;	
					
						case "2":
							System.out.println("Introduce el DNI");
							banco.EliminarCuenta(banco.BuscarCuenta(sc.nextLine(),0));
							break;	
					}
					break;
			
				case "3":
					BigDecimal total = banco.SaldoTotal();
					System.out.println("Total: "+total);
					break;
				
				case "4":
					resp=""; 
					error=true;
					
					do {
						System.out.println("Buscar cuenta \n1) Numero de cuenta \n2) DNI ");
						resp = sc.nextLine();
						
						if (resp.equals("1")||resp.equals("2")) error=false;
					} while (error);
					
					switch (resp) {
						case "1":
							
							error=true;
							do {
								try {
									System.out.println("Introduce el número de cuenta");
									cuenta = banco.BuscarCuenta(Integer.parseInt(sc.nextLine()));
									
									error=false;
								} catch (RuntimeException s) {
									System.out.println("Tiene que ser un numero");
								} 
							} while (error);
							break;	
							
						case "2":
							error=true;
							String Dni;
							
							do {
								System.out.println("Introduce el DNI");
								Dni = sc.nextLine();
								
								if (Dni.length()==9) {error=false;} else {System.out.println("DNI erroneo");}
							} while(error);
							
							cuenta=banco.BuscarCuenta(Dni,0);
							
							break;	
					}	
					break;
					
				case "5":
					
					salir=true;
					
					break;
			}
			while (cuenta!=null) {
				System.out.println("--------------------------------------");
				System.out.println("N cliente: "+cuenta.getNumeroCuenta());
				System.out.println("Cuenta de "+cuenta.getCli().getNombre()+" con DNI: "+cuenta.getCli().getDni());
				System.out.println("Saldo: "+cuenta.getSaldo());
				System.out.println("--------------------------------------");
				System.out.println("Que quieres hacer");
				System.out.println("1) Ingreso");
				System.out.println("2) Retirar dinero");
				System.out.println("3) Eliminar cuenta");
				System.out.println("4) Buscar movimientos");
				System.out.println("5) Salir");
				System.out.println("--------------------------------------");
				String resp = sc.nextLine();
				
				switch (resp) {
				
					case "1":
						boolean error = true;
						
						do {
							try {
								System.out.println("Cuanto dinero quieres ingresar");
								BigDecimal ing = new BigDecimal(Integer.parseInt(sc.nextLine()));
								
//								mirar negativo
								BigDecimal n0 = new BigDecimal(0);
								if (ing.compareTo(n0)==-1) throw new NumeroNegativoExeption();
								
								System.out.println("Concepto");
								cuenta.ingresarDinero(ing, sc.nextLine());
								error=false;
								
							} catch (NumberFormatException f) {
							System.out.println("Tienes que introducir un numero");
							} catch (NumeroNegativoExeption f) {
								System.out.println("No puedes meter numeros negativos");
							}
							
						}while (error);
						
						break;
					
					case "2":
						error=true;
						
						do { 
							try {
								System.out.println("Cuanto dinero quieres retirar");
								BigDecimal ret = new BigDecimal(Integer.parseInt(sc.nextLine()));
								cuenta.retirarDinero(ret);
								
								error = false;
							} catch(SaldoInsuficienteException e) {
								System.out.println("No tienes suficiente saldo");
							} catch (NumberFormatException f) {
								System.out.println("Tienes que introducir un numero");
							}
							
						} while (error);
						break;
					
					case "3":
						banco.EliminarCuenta(cuenta);
						cuenta=null;
						break;	
					
					case "4":
						SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
						
						error = true;
						Fecha fechaini = null, fechafin = null;
						
						do {
							try {
								System.out.println("Fecha de inicio dd/MM/yyyy");
								fechaini = new Fecha(sc.nextLine());
								
								error = false;
							} catch (ParseException e) {
								System.out.println("Fecha incorrecta");
							} 
							
						}while (error);
						
						
						error = true;
						do {
							try {
								System.out.println("Fecha de fin dd/mm/yyyy");
								fechafin = new Fecha(sc.nextLine()+" 23:59");
								
								error = false;
							} catch (ParseException e) {
								System.out.println("Fecha incorrecta");
							} 
						} while (error);
						
						LinkedList<Movimiento> listamov = cuenta.bucarMovimientos(fechaini, fechafin);
					
//						ordenamos lista  
//						Tengo que ir a movimientos y añadir el implement Comparable<Movimiento> y hacer el compareTo
						
						System.out.println("Quieres ordenar los movimientos (si/no)");
						if (sc.nextLine().equals("si")) {
							
							System.out.println("Quieres ordenar for fecha o por importe (f/i)");
							
							if (sc.nextLine().equals("f")) {
//							compara por fecha
							Collections.sort(listamov);
							} else {
	//						compara por importe
							Collections.sort(listamov, new comparadorImporte().reversed());
							}
						}
						if (listamov.isEmpty()) {
							System.out.println("No hay movimientos");
						} else {
							for(Movimiento m : listamov) { 
								System.out.println(m.getFecha().getDMAHM()+"  "+m.getConcepto()+" Importe: "+m.getImporte()+"€ Total:"+m.getSaldoActual()+"€");
							}
						}
						System.out.println("--------------------------------------");
						System.out.println("Pulsa cualquier techa para continuar");
						sc.nextLine();
					break;	
						
					case "5":
						
						cuenta=null;
						
						break;
				}
			}
		} while(!salir);
//		guardamos
		banco.guardarDatos();
	}

}
