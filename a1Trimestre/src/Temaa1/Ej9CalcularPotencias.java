package Temaa1;

import java.util.Scanner;

public class Ej9CalcularPotencias {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {

		System.out.println("Calculadora de Potencias");
		System.out.println("Introduce la base que quieres calcular");
		int B=Integer.parseInt(sc.nextLine());
		System.out.println("Introduce el exponente que quieres calcular");
		int E=Integer.parseInt(sc.nextLine());

		int T=B;	

		for (int x=1; x<E ; x++) {

			T=(T*B);
		}
		System.out.println("La potencia de base: "+B+" + Exponente: "+E+" = "+T);	
	}

}
