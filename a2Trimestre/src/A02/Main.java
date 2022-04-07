package A02;

//import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		/*//creacion de abonados
		Abonado a1=new Abonado("Manolo","666");
		Abonado a2=new Abonado("Pepe","667");
		Abonado a3=new Abonado("Ruski","668");
		Abonado a4=new Abonado("peter","669");
		Abonado a5=new Abonado("Paco","676");
		
		if (a1.llamar(a5)) {
			System.out.println("Llamada correcta");
		} else {
			System.out.println("Comunicando");
		}
		
		if (a2.llamar(a5)) {
			System.out.println("Llamada correcta");
		} else {
			System.out.println("Comunicando");
		}
		
		
		a1.estado();
		a2.estado();
		a3.estado();
		a4.estado();
		a5.estado();*/
		
		String opcion;
		
		System.out.println("Nombre de la compañía:");
		String nc=sc.nextLine();
		
		Companyia com = new Companyia(nc);
		
		do {
			System.out.println("1) Añadir abonado \n2) Dar de baja abonado \n3) Realizar llamada \n4) Colgar \n5) Listar abonados que estan en llamada \nS) Salir");
			opcion = sc.nextLine();
			
			if (opcion.equals("1")) {
				System.out.println("Nombre del abonado?");
				String nombre=sc.nextLine();
				
				System.out.println("Teléfono del abonado?");
				String tel=sc.nextLine();
				
				Abonado abo = new Abonado(nombre, tel);
				
				if (com.addAbonado(abo)) {
					System.out.println("Abonado añadido");
				} else {
					System.out.println("Ya existe ese abonado");
				}
			}
			
			if (opcion.equals("2")) {
				System.out.println("Número del abonado que se quiere dar de baja?");
				String tel = sc.nextLine();
				Abonado abo=com.findByTel(tel);
				
				if (abo==null) {
					System.out.println("No existe este abonado");
				} else {
					if (com.delAbonado(abo)) {
						System.out.println("Abonado dado de baja");
					} else {
						System.out.println("no existe este abonado");
					}
				}
			}
//			Llamar
			if (opcion.equals("3")) {
				System.out.println("Teléfono del que llama");
				String tel1=sc.nextLine();
				
				
				Abonado abo1 = com.findByTel(tel1);
				if (abo1==null) {
					System.out.println("No existe Abonado con este teléfono");
				} else {
					System.out.println("Teléfono al que llama");
					String tel2=sc.nextLine();
					Abonado abo2 = com.findByTel(tel2);
					
					if (abo2 == null) {
						System.out.println("No existe Abonado con este teléfono");
					} else {
						if (abo1.llamar(abo2)) {
							System.out.println(abo1.getNombre()+" está llamando a "+abo2.getNombre());
						} else {
							System.out.println("No se puede realizar la llamada");
						}
					}
				}
			}
//			Colgar
			if (opcion.equals("4")) {
				System.out.println("Teléfono del que cuelga");
				String tel1=sc.nextLine();
				Abonado abo1 = com.findByTel(tel1);
				if (abo1.colgar()) {
					System.out.println(abo1.getNombre()+" colgo la llamada.");
				} else {
					System.out.println("No esta en llamada");
				}
				
			}
			
//			listar abonados que estan en llamada
			if (opcion.equals("5")) {
				System.out.println("Lista de gente que esta en llamada");

				for (int i=0 ; i < com.ListaEnllamada().size() ; i++) {
					
					System.out.println(com.ListaEnllamada().get(i).getNombre()+" - "+com.ListaEnllamada().get(i).getTel());
				}			
			}
		} while(!opcion.equalsIgnoreCase("S"));
		
	}

}
