package Temaa1;

import java.util.Scanner;

public class E4QueNosPida3NumYEnOrden {
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Introduce el primer numero");
		double a=Double.parseDouble(sc.nextLine());
		
		System.out.println("Introduce el segundo numero");
		double b=Double.parseDouble(sc.nextLine());
		
		System.out.println("Introduce el tercer numero");
		double c=Double.parseDouble(sc.nextLine());
		
		// sin numeros repetidos
		/*if (a==b || a==c || b==c) {
			System.out.println("Hay numeros repetidos");
		} 
		
		
		if (a<b && a<c) {
			if (b<c) {
				System.out.println(a+" "+b+" "+c);
			} if (c<b) {
				System.out.println(a+" "+c+" "+b);
			}
		}
		if (b<a && b<c) {
			if (a<c) {
				System.out.println(b+" "+a+" "+c);
			} if (c<a) {
				System.out.println(b+" "+c+" "+a);
			}
		}
		if (c<b || c<a) {
			if (b<a) {
				System.out.println(c+" "+b+" "+a);
			} if (a<b) {
				System.out.println(c+" "+a+" "+b);
			}
		}
		
	}*/
	
	
	// pudiendo meter numeros repetidos
	if (a<=b && a<=c) {
		if (b<=c) {
			System.out.println(a+" "+b+" "+c);
		} if (c<b) {
			System.out.println(a+" "+c+" "+b);
		}
	}
	if (b<a && b<c) {
		if (a<c) {
			System.out.println(b+" "+a+" "+c);
		} if (c<a) {
			System.out.println(b+" "+c+" "+a);
		}
	}
	if (c<b || c<a) {
		if (b<a) {
			System.out.println(c+" "+b+" "+a);
		} if (a<b) {
			System.out.println(c+" "+a+" "+b);
		}
	}
	
}

}
