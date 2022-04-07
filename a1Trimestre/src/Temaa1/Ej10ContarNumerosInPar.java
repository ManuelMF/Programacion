package Temaa1;

import java.util.Scanner;

public class Ej10ContarNumerosInPar {
	static Scanner  sc=new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Dime el primer numero");
		int n1=Integer.parseInt(sc.nextLine());
		
		System.out.println("Dime el segundo numero");
		int n2=Integer.parseInt(sc.nextLine());
		
		
		if (n1>n2) {
		int tmp;
		tmp=n1;
		n1=n2;
		n2=tmp;
		}
	
		for (int x=n1; x<=n2 ; x++) {
			
			if (x%2!=0) {

	       System.out.println(x);
	        }
	       
		}
		
	}

}

