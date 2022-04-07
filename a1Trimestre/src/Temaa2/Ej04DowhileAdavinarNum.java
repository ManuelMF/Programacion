package Temaa2;

import java.util.Scanner;

public class Ej04DowhileAdavinarNum {
	static Scanner sc=new Scanner (System.in);
	public static void main(String[] args) {

		//variables
		int intento=0,max,nIntentos=0;
		String volverajugar;

		do {
			//introducción
			System.out.println("Adivina el numero");
			System.out.println("Introduce el nivel de dificultad");
			System.out.println("1) Facil\n2) Medio\n3) Dificil");
			int dificultad=Integer.parseInt(sc.nextLine());

			//dificultades
			if (dificultad==1) {
				max=10;
			} else if (dificultad==2) {
				max=100;
			} else {
				max=1000;
			}

			//número aleatorio
			int num=(int) (Math.random()*max+1);

			//juego
			do {
				nIntentos++;
				System.out.println("Introduce un numero");	
				intento=Integer.parseInt(sc.nextLine());

				if (intento<num) {
					System.out.println("Es mayor");
				} else if (intento>num) {
					System.out.println("Es menor");
				}
			} while (intento!=num);

			System.out.println("Es correcto");
			System.out.println("tu numero de intentos a sido de: "+nIntentos);
			
			//volover a jugar 
			System.out.println("¿Quieres volver a jugar (s/n)?");
			volverajugar=sc.nextLine();
			
		} while (volverajugar.equals("s"));
	}
}