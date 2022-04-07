package ManuelMuñozFelixExamen;

public class P2 {

	public static void main(String[] args) {
		
		//2)
		int [][][] tablero = new int [3][3][3];
		int rep=10;
		int numero;
		
		for (int y=0 ; y<3 ; y++) {
			for (int x=0 ; x<3 ; x++) {
				for (int z=0 ; z<3 ; z++) {
					do {
						rep=1;
						numero=(int) (Math.random() * 1000);
						
						//NO REPETIR
						for (int yy=0 ; yy<y ; yy++){
							for (int xx=0 ; xx<x ; xx++) {
								for (int zz=0 ; zz<3 ; zz++) {
								if (tablero[yy][xx][zz]==numero) {rep=0;}
								}
							}
						}
					} while (rep==0);
						
					tablero[y][x][z] = numero;
					
					System.out.print(tablero[y][x][z]+" ");
					if (tablero[y][x][z]<10) {
						System.out.print("  ");
					} else if (tablero[y][x][z]<100) {
						System.out.print(" ");
					}
				}
			}System.out.println("");
		}
	}
}
