package Temaa3;

import java.util.Scanner;

public class Ej03PedirLetraVecesRepite {
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		int contador=0;
		
		System.out.println("Introduce una frase");
		String frase=sc.nextLine();
		
		System.out.println("Que letra quieres contar");
		String palabra=sc.nextLine();
		
		for (int x=0 ; x<frase.length() ; x++) {
			if (palabra.equals(frase.charAt(x)+"")) {
				contador=contador+1;
			}
		}
		System.out.println("Tiene un total de "+contador+" letras.");
	}

}
