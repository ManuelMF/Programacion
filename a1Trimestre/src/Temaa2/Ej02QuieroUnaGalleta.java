package Temaa2;

import java.util.Scanner;

public class Ej02QuieroUnaGalleta {
	static Scanner sc=new Scanner (System.in);
	public static void main(String[] args) {
		String decir=null;

		int nveces=0;

		do {
			nveces++;
			if (nveces<4) {
				System.out.println("Quiero una galleta");
				decir=sc.nextLine();
			}
			if (nveces>=4 && nveces<=6) {
				System.out.println("Que quiero una galleta te he dicho");
				decir=sc.nextLine();
			}
			if (nveces>=7 && nveces<=9) {
				System.out.println("Me estoy empezando a cabrear. Quiero galleta!!!");
				decir=sc.nextLine();
			}
			if (nveces>=10 && nveces<=14) {
				System.out.println("Que tengo hambre, me voy a morir si no me das la galleta");
				decir=sc.nextLine();
			}
			if (nveces>=15) {
				System.out.println("No voy a parar hasta que me des la galleta!!!");
				decir=sc.nextLine();
			}

		} while (!decir.equals("Toma la galleta"));

		System.out.println("Gracias");
	} 

}
