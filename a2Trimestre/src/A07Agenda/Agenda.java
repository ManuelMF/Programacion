package A07Agenda;

import java.util.LinkedList;
import java.util.Scanner;

public class Agenda {
	static Scanner sc=new Scanner(System.in);

	private String nombre;
	
	LinkedList<Contacto> contactos;
	
	public Agenda (String n) {
		this.nombre=n;
		this.contactos= new LinkedList <Contacto>();	
	}
	
	public void addcontacto(Contacto c) {
		this.contactos.add(c);
	}
	
	public void delcontacto(Contacto c) {
		this.contactos.remove(c);
	}
	
	public LinkedList<Contacto> findcontacto (String n) {
		
		LinkedList<Contacto> encontrados= new LinkedList<Contacto>();
		
		for (Contacto c:this.contactos) {
			if (c.getNombre().toLowerCase().startsWith(n.toLowerCase())) {
				encontrados.add(c);
			}
		}
		return encontrados;
		
	}
	
	public void ListaContacto () {
		for (Contacto c: this.contactos) System.out.println(c.getNombre());
	}
	
	public LinkedList<Contacto> GetContacto (){
		return contactos;
	}
	
	public void ContactoInfo(String n) {
		boolean volver=false;
		
		Contacto con=null;
		
		for (Contacto c:this.contactos) {
			if (c.getNombre().equals(n)) {
				con=c;
			}
		}
		do {
		System.out.println("Nombre: "+con.getNombre());
		System.out.println("Informacion:");
		for(Informacion i : con.info) {
			System.out.println(i.getNombre()+": "+i.getValor());
		}
		System.out.println("┌─────────────────────┐");
		System.out.println("│ 1) Cambia nombre    │");
		System.out.println("│ 2) Modifica info    │");
		System.out.println("│ 3) Añadir info      │");
		System.out.println("│ 4) Eliminar info    │");
		System.out.println("│ 5) Elimina contacto │");
		System.out.println("│ 6) volver           │");
		System.out.println("└─────────────────────┘");
		
		int accion = Integer.parseInt(sc.nextLine());
		
		if (accion==1) {
			System.out.println("Nuevo nombre");
			con.setNombre(sc.nextLine());
		}
		
		if (accion==2) {
			System.out.println("Que informacion quieres editar");
			for(Informacion i : con.info) {
				System.out.println(i.getNombre());
			}
			
			for(Informacion i : con.info) {
				if(i.getNombre().equals(sc.nextLine())) {
					System.out.println("Nuevo "+i.getNombre());
					i.setValor(sc.nextLine());
				}
			}	
		}
		
		if (accion==3) {
			System.out.println("Que quieres añadir");
			String nombre=sc.nextLine();
			
			System.out.println("Informacion del "+nombre);
			String valor=sc.nextLine();
			Informacion i = new Informacion(nombre,valor);
			con.info.add(i);
		}
		
		if (accion==4) {
			System.out.println("Que informacion quieres eliminar");
			for(Informacion i : con.info) {
				System.out.println(i.getNombre());
			}
			String eliminar=sc.nextLine();
			for(Informacion i : con.info) {
				if(i.getNombre().equals(eliminar)) {
					System.out.println("Eliminado");
					con.info.remove(i);
					
				}
			}	
		}
		
		if (accion==5) {
			
			for (Contacto c: contactos) {
				if (c.getNombre().equals(con.getNombre())) {
					delcontacto(c);
				}
				volver=true;
			}
		}
		
		if (accion==6) {
			volver=true;
		}
		} while (volver==false); 
	}
	
}
