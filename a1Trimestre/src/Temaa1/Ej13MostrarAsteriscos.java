package Temaa1;

import java.util.Scanner;

public class Ej13MostrarAsteriscos {
	static Scanner sc=new Scanner(System.in);   

	public static void main(String[] args) {
		
		System.out.println("Numero de asteriscos");
		int n=Integer.parseInt(sc.nextLine());
		
		for (int y=0; y<n ;y++) {
			
			System.out.println();
			for (int x=0; x<n ;x++) {
				
				if (x==0 || x==(n-1) || y==0 || y==(n-1)) {
					System.out.print("* ");
					}	else {
						System.out.print("  ");
				}
			}
		}	
		
	}
}
