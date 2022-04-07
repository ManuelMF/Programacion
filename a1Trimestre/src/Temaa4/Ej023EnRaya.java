package Temaa4;

import java.util.Scanner;

public class Ej023EnRaya {
	static Scanner sc=new Scanner(System.in);
	static boolean fin=false;
	public static void main(String[] args) {

		String [][] tablero = new String [3][3];
		boolean [][] abiertos = new boolean [3][3];
		
		presentacion();
		
		valores(tablero,abiertos);
		do {
		montar1(tablero,abiertos);
		
		jugar1(tablero,abiertos);
		
		montar2(tablero,abiertos);
		
		fin(tablero,abiertos);
		if (fin==false) {
			
		jugar2(tablero,abiertos);
		
		montar1(tablero,abiertos);
		
		fin(tablero,abiertos);
		}
		} while (fin==false);
	}

	public static void presentacion() {
		System.out.println("┌───────────────┐");
		System.out.println("│   3 EN RAYA   │");
		System.out.println("└───────────────┘");
	}
	
	public static void valores(String[][] tablero, boolean[][] abiertos) {

		for (int y=0 ; y<3 ; y++) {
			for (int x=0 ; x<3 ; x++) {
				abiertos[y][x]=false;
			}
		}
	}

	public static void jugar1(String[][] tablero, boolean[][] abiertos) {

		System.out.println("Movimiento jugador 1 \nx:");
		int x1 = Integer.parseInt(sc.nextLine());
		System.out.println("y:");
		int y1 = Integer.parseInt(sc.nextLine());
		if (abiertos[x1][y1]==true){
			jugar1(tablero,abiertos);
		} else {
		tablero[y1][x1]="x";
		abiertos[y1][x1]=true;
		}
	}
	
	public static void montar1(String[][] tablero, boolean[][] abiertos) {

		System.out.println("    0   1   2");
		System.out.println("  ┌───┬───┬───┐");
		for (int y=0 ; y<3 ; y++) {
			System.out.print(y+" ");
			for (int x=0 ; x<3 ; x++) {
				if (abiertos[y][x]==true) {
					System.out.print("│ "+tablero[y][x]+" ");
				} else {
					System.out.print("│   ");
				}
			}	
			System.out.println("│");
			
			if (y==2) {
				System.out.println("  └───┴───┴───┘");
			} else {
				System.out.println("  ├───┼───┼───┤");
			}
		}
	}	
	
	public static void jugar2(String[][] tablero, boolean[][] abiertos) {

		System.out.println("Movimiento jugador 2 \nx:");
		int x1 = Integer.parseInt(sc.nextLine());
		System.out.println("y:");
		int y1 = Integer.parseInt(sc.nextLine());
		if (abiertos[y1][x1]==true){
			jugar2(tablero,abiertos);
		} else {
		tablero[y1][x1]="o";
		abiertos[y1][x1]=true;
		}
	}
		
	public static void montar2(String[][] tablero, boolean[][] abiertos) {

		System.out.println("    0   1   2");
		System.out.println("  ┌───┬───┬───┐");
		for (int y=0 ; y<3 ; y++) {
			System.out.print(y+" ");
			for (int x=0 ; x<3 ; x++) {
				if (abiertos[y][x]==true) {
					System.out.print("│ "+tablero[y][x]+" ");
				} else {
					System.out.print("│   ");
				}
			}	
			System.out.println("│");
			
			if (y==2) {
				System.out.println("  └───┴───┴───┘");
			} else {
				System.out.println("  ├───┼───┼───┤");
			}
		}
	}
	
	public static void fin(String[][] tablero, boolean[][] abiertos) {
		int contadorganar=0;
		int contadorganarh=0;
		for (int y=0 ; y<3 ; y++) {
			contadorganar=0;
			contadorganarh=0;
			//mirar horizontal
			for (int x=0 ; x<3 ; x++) {
				if (abiertos[y][x]==true) {
					if (tablero[y][x].equals("o")) {
						contadorganar++;
						if (contadorganar==3) {
							fin=true;
							System.out.println("fin");
						}
					}
				}	
				if (abiertos[y][x]==true) {
					if (tablero[y][x].equals("x")) {
						contadorganar++;
						if (contadorganar==3) {
							fin=true;
							System.out.println("fin");
						}
					}
				}	
				//mirar vertical
				if (abiertos[y][x]==true) {
					if (tablero[y][x].equals("o")) {
						contadorganarh++;
						if (contadorganarh==3) {
							fin=true;
							System.out.println("fin");
						}
					}
				}
				if (abiertos[x][y]==true) {
					if (tablero[x][y].equals("x")) {
						contadorganarh++;
						if (contadorganarh==3) {
							fin=true;
							System.out.println("fin");
						}
					}
				}
			}
		}
		
	}

}
