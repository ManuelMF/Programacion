package Temaa3;

import java.util.Scanner;

public class Ej01VectoresMatricesArrays {
	static Scanner sc=new Scanner (System.in);

	public static void main(String[] args) {

System.out.println("¿Cuantos coches?");
int n=Integer.parseInt(sc.nextLine());
	
	String[] nombres=new String[5];
	for (int x=0 ; x<5 ; x++) {
		System.out.println("Introduce un coche");
		nombres[x]=sc.nextLine();
	}
	for (int x=0; x<n ; x++) {
		System.out.println(nombres[x]);
	}
}
}
