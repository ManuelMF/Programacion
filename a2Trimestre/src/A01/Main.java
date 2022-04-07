package A01;

import java.util.Scanner;

public class Main {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {

		String nombre;
		String apellidos;
		int edad;
		
		System.out.println("Nombre de la lista:");
		String nombreLista = sc.nextLine();
		
		System.out.println("¿Cuantos alumnos hay en la lista?");
		int num = Integer.parseInt(sc.nextLine());
		
		ListaAlumno list1=new ListaAlumno(num,nombreLista);
		
		for (int i = 0; i <num; i++) {
			System.out.println("Introduce el Nombre:");
			nombre = sc.nextLine();
			System.out.println("Introduce los Apellidos:");
			apellidos = sc.nextLine();
			
			System.out.println("Introduce la Edad:");
			edad = Integer.parseInt(sc.nextLine());
			Alumno a = new Alumno(nombre, apellidos, edad);
			list1.addAlumno(a);
		}
		
		//2 lista
		System.out.println("Nombre de la lista:");
		nombreLista = sc.nextLine();
		
		System.out.println("¿Cuantos alumnos hay en la nueva lista?");
		num = Integer.parseInt(sc.nextLine());
		
		ListaAlumno list2=new ListaAlumno(num,nombreLista);
		
		for (int i = 0; i <num; i++) {
			System.out.println("Introduce el Nombre:");
			nombre = sc.nextLine();
			System.out.println("Introduce los Apellidos:");
			apellidos = sc.nextLine();
			System.out.println("Introduce la Edad:");
			
			edad = Integer.parseInt(sc.nextLine());
			Alumno a = new Alumno(nombre, apellidos, edad);
			list2.addAlumno(a);
		}
		
		System.out.println("Selecciona Lista 1,2");
		int numLista = Integer.parseInt(sc.nextLine());
		
		ListaAlumno listaSel;
		
		if (numLista==1) {
			listaSel=list1;
		} else {
			listaSel=list2;
		}
		
		System.out.println("Indica la posicion del alumno (0-"+(listaSel.tamanyo()-1)+") en la lista: "+listaSel.getNombreLista());
		int pos = Integer.parseInt(sc.nextLine());
		Alumno al=listaSel.getAlumno(pos);
		System.out.println(al.getNombreYAp() + " " + al.getEdad());
	}
}
