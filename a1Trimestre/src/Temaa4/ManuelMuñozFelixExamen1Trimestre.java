package Temaa4;

import java.util.Scanner;

public class ManuelMuñozFelixExamen1Trimestre {
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {

		//1)
		int [] entrada = new int [10];
		int numero;
		
		for (int x = 0 ; x < entrada.length ; x++ ) {
			numero=(int) (Math.random() * 1000);
			entrada[x] = numero;
			System.out.print(entrada[x]+" ");
		}System.out.println("");
		
		for (int x = 9 ; x >= 0 ; x--) {
			System.out.print(entrada[x]+" ");
		}
		
	}

}
