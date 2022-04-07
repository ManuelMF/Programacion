package Temaa1;

import java.util.Scanner;

public class E1CalculadoraPedirNum {
	
static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		double suma, resta, multi, divi; 
		
		System.out.println("Introduce un número: ");
	        double num1=Double.parseDouble(sc.nextLine());
	       
	        System.out.println("Introduce otro número: ");
	        double num2=Double.parseDouble(sc.nextLine());
	       
	       
	        System.out.println("operación: (+, -, *, /) ");
	        String signo = sc.nextLine();
	       
	        if (signo.equals("+")) {
	        	 suma=num1+num2;
	            System.out.println("La suma de "+num1+" + "+num2+" es: "+suma);
	       
	        }	
	        if (signo.equals("-")) {
	        	resta=num1-num2;
	            System.out.println("La resta de "+num1+" - "+num2+" es: "+resta);
	       
	        }	
	        if (signo.equals("*")) {
	        	multi=num1*num2;
	            System.out.println("La multiplicacion de "+num1+" * "+num2+" es: "+multi);
	       
	        }	
	        if (signo.equals("/")) {
	        	divi=num1/num2;
	            System.out.println("La division de "+num1+" / "+num2+" es: "+divi);
	       
	        }	

	}

}
