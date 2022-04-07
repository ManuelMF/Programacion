package ManuelMuñozFelixExamen;

public class P1 {

	public static void main(String[] args) {

		//1)
		int [] entrada = new int [10];
		int [] salida = new int [10];
		int numero;
		
		for (int x = 0 ; x < entrada.length ; x++ ) {
			numero=(int) (Math.random() * 1000);
			entrada[x] = numero;
			System.out.print(entrada[x]+" ");
		}System.out.println("");
		
		for (int x = 9 ; x >= 0 ; x--) {
			salida[x] = entrada[x];
			System.out.print(salida[x]+" ");
		}
		
	}

}