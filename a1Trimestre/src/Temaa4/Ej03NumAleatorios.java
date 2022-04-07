package Temaa4;

public class Ej03NumAleatorios {

	public static void main(String[] args) {
		
		int [][] tablero = new int [10][10];
		int rep=10;
		int numero;
		
		for (int y=0 ; y<10 ; y++) {
			for (int x=0 ; x<10 ; x++) {
				do {
					rep=1;
					numero=(int) (Math.random() * 1000);
					for (int yy=0 ; yy<y ; yy++){
						for (int xx=0 ; xx<x ; xx++) {
							if (tablero[yy][xx]==numero) {rep=0;}
						}
					}
				} while (rep==0);
					
				tablero[y][x] = numero;
					
				System.out.print(tablero[y][x]+" ");
				if (tablero[y][x]<10) {
					System.out.print("  ");
				} else if (tablero[y][x]<100) {
					System.out.print(" ");
				}
			}System.out.println("");
		}
	}

}
