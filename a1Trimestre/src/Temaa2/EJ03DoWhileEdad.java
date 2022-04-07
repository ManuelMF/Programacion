package Temaa2;

import java.util.Scanner;

public class EJ03DoWhileEdad {
	static Scanner sc=new Scanner (System.in);
	public static void main(String[] args) {
		
		int edad=0;
		
		do {
			System.out.println("Introduce tu edad");
			edad=Integer.parseInt(sc.nextLine());
			if (edad<0 || edad>125) {
				System.out.println("Edad incorrecta");
			}
		}	while (edad>125);
		
	
		if (edad<=5) {
			System.out.println("Eres un bebé");
		} else if (edad<=10) {
			System.out.println("estas creciendo");
		} else if (edad<=18) {
			System.out.println("odias el colegio");
		} else if (edad<=25) {
			System.out.println("eres legal");
		} else if (edad<=40) {
			System.out.println("quieres matar a tu jefe");
		} else if (edad<=65) {
			System.out.println("preparate para la jubilación");
		} else if (edad>65) {
			System.out.println("disfruta de lo que te queda");
		}



	}

}
