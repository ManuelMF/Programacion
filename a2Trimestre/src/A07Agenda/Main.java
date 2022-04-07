package A07Agenda;


import java.util.LinkedList;
import java.util.Scanner;

import A03LinkedList.queue;


public class Main {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
//		Creamos agenda con la lista de contactos
		Agenda Agen= new Agenda("Contactos");
		
		boolean salir=false;
		do {
//			Menu de la agenda
			System.out.println("┌─────────────────────────┐");
			System.out.println("│   Agenda de contactos   │");
			System.out.println("└─────────────────────────┘");
			System.out.println("┌─────────────────────────┐");
			System.out.println("│  1) Añadir contacto     │");
			System.out.println("│  2) Buscar Contactos    │");
			System.out.println("│  3) Lista contactos     │");
			System.out.println("│  4) Salir               │");
			System.out.println("└─────────────────────────┘");
			int num =Integer.parseInt(sc.nextLine());
			
	//		Añadir contacto
			if(num==1) {
				
				System.out.println("Nombre del nuevo contacto");
				String nn=sc.nextLine();
				Agen.addcontacto(new Contacto(nn));
				Agen.ContactoInfo(nn);
			}
	
	//		Buscar contacto		
			if(num==2) {
				System.out.println("Buscar");
				String contacto = sc.nextLine();

				LinkedList<Contacto> encontrados=Agen.findcontacto(contacto);
				if (encontrados.isEmpty()) {
					System.out.println("no se encontro a nadie");
				} else if (encontrados.size()==1) {
					Agen.ContactoInfo(encontrados.getFirst().getNombre());
				} else {
					int x=1;
					for (Contacto e : encontrados) {
						System.out.println(x+") "+e.getNombre());
					x++;
					}
					
					int n=0;
					boolean error=true;
					do {
						try {
							System.out.println("N del contacto");
							n=Integer.parseInt(sc.nextLine());
							if (n>0 && n<=encontrados.size()) {
								error = false;
							}
						} catch (NumberFormatException e) {
							System.out.println("Numero incorrecto");
						}
					} while (error);
					
					contacto=encontrados.get(n-1).getNombre();
					Agen.ContactoInfo(contacto);
					
				}
			
			}
			
	//		Listar
			if (num==3) {
				System.out.println("Lista de contactos");
				Agen.ListaContacto();
			}
				
	//		Salir
			if (num==4) {
				salir=true;
			}
		} while(salir == false);
	}
	
	
	
}
