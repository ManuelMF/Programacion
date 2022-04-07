import java.util.Scanner;

public class EJ2pedir1num {
static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Introduce un numero");
		double num1=Double.parseDouble(sc.nextLine());
		
		System.out.println("Introduce otro numero");
		double num2=Double.parseDouble(sc.nextLine());
		
	
		double Sumcalculado=(num1+num2);
		double Restacalculado=(num1-num2);
		double Mulcalculado=(num1*num2);
		double Divcalculado=(num1/num2);
		
		System.out.println("Total Suma "+Sumcalculado);
		System.out.println("Total Resta "+Restacalculado);
		System.out.println("Total Multiplicacion "+Mulcalculado);
		System.out.println("Total Division "+Divcalculado);


	}

}
