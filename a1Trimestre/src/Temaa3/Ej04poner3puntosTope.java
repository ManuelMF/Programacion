package Temaa3;

import java.util.Scanner;

public class Ej04poner3puntosTope {
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		
		
		System.out.println("Introduce el texto");
		String texto=sc.nextLine();
		
		System.out.println("¿Cuanto sera el maximo que quieres mostrar?");
		int max=Integer.parseInt(sc.nextLine());
		
		String letra=texto.substring(max-1, max);
	
		
			
		while (!letra.equals(" ")) {
			max--;
			letra=texto.substring(max-1,max);
		}
		max=max-2;
		
		System.out.print(texto.substring(0, max));
		
		System.out.print("...");
	}

}
