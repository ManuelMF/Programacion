package Temaa1;

import java.util.Scanner;

public class E6NumeroAleatorio {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {

		int max=10;
		System.out.println("pulsa del 1 para facil al 2 para medio y 3 para dificil");
		int dificultad=Integer.parseInt(sc.nextLine());

		if (dificultad==2) {
			max=20;   
		}
		if (dificultad==3) {
			max=50;  
		}


		int min=1;
		int adivinar = (int) (Math.random() * (max-min+1) + min);

		System.out.println(adivinar);

		System.out.println("Introduce un número");
		int num=Integer.parseInt(sc.nextLine());


		if (num==adivinar) {
			System.out.println("has acertado!!!");
		} else {
			if (num<adivinar) {
				System.out.println("El número que tienes que acertar es mayor!!!");
			} else {
				System.out.println("El número que tienes que acertar es menor!!!");
			}

			System.out.println("Introduce otro número");
            num=Integer.parseInt(sc.nextLine());
           
           
            if (num==adivinar) {
                System.out.println("has acertado!!!");
            } else {
                if (num<adivinar) {
                    System.out.println("El número que tienes que acertar es mayor!!!");
                } else {
                    System.out.println("El número que tienes que acertar es menor!!!");
                }
               
                System.out.println("Introduce un número");
                num=Integer.parseInt(sc.nextLine());
               
               
                if (num==adivinar) {
                    System.out.println("has acertado!!!");
                } else {
                    System.out.println("Has perdido. El número era: "+adivinar);
                   
                }
    
            }

        }

    }
}