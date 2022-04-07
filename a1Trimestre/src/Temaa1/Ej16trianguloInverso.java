package Temaa1;

import java.util.Scanner;

public class Ej16trianguloInverso {
	static Scanner sc=new Scanner(System.in);   
	public static void main(String[] args) {
		System.out.println("Numero de asteriscos");
		int numFilas=Integer.parseInt(sc.nextLine());	
		
		for (int altura=1; altura<=numFilas ;altura++) {
			
			for (int blancos=1; blancos>=numFilas-altura ;blancos++) {
				System.out.print("  ");
			}	
			for (int asteriscos=1; asteriscos<=(altura*2)-1 ;asteriscos++) {
				System.out.print("* ");
			}
			System.out.println();
			
		
		}
	}

}
