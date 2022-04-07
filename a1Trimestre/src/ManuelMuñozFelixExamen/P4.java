package ManuelMuñozFelixExamen;

import java.util.Scanner;

public class P4 {
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		
		int numero;
		do {
		System.out.println("Dime un numero mayor que 10 y menor que 20");
		numero = Integer.parseInt(sc.nextLine());
		} while (numero>20 || numero<10);
		
		String [][] patatas = new String [numero][numero];
		
		for (int y=0 ; y < patatas[0].length ; y++) {
			for (int x=0 ; x < patatas.length ; x++) {
				patatas[x][y] = "------";
			}	
		}
		
		for (int i = 0, j = 0; i < patatas.length; i++, j++) {
			patatas[i][j] = "patata";
		}
		
		for (int i = patatas.length-1 , j = 0; i > -1; i--, j++) {
			patatas[i][j] = "patata";
		}
		
		for (int y=0 ; y < patatas[0].length ; y++) {
			for (int x=0 ; x < patatas.length ; x++) {
				System.out.print(patatas[x][y]);
			}	System.out.println();
		}
	}

}
