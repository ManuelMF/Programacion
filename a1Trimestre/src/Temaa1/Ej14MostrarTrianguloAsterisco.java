package Temaa1;

import java.util.Scanner;

public class Ej14MostrarTrianguloAsterisco {
	static Scanner sc=new Scanner(System.in);   

	public static void main(String[] args) {
		System.out.println("Numero de asteriscos");
		int n=Integer.parseInt(sc.nextLine());	
		
		for (int y=0; y<n ;y++) {

			for (int x=0; x<y+1 ;x++) {
				if (x==0 || y==n-1 || x==y){
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}	
			System.out.println();
		}
	}
}
