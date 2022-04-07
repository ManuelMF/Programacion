package Temaa3;

import java.util.Scanner;

public class Ej5Coordenadas {
	static Scanner sc=new Scanner(System.in);
	static int posiciony=0,posicionx=0,posicionyC=0,posicionxC=0,x,y;
	static int contadorU,contadorbombas=10, contadorCBOMBAS=0,contadorUBOMBAS;
	static boolean acabar = false; 
	static String volverajugar;
	
	public static void main(String[] args) {

		String[][] tablero = new String[10][10];
		do {
		iniciatablero(tablero);
		
		meterbombas(tablero);
		
		meterU(tablero);
		
		meterC(tablero);
		
		montartablero(tablero);
		
		moverU(tablero);
		
		moverC(tablero);
		
		mostrarmovimientos(tablero);
		
		acabarprograma(tablero);
		
		volveraJugar(tablero);
		} while (volverajugar.equals("s")); 	
	} 

	public static void iniciatablero(String[][] tablero) {
	
		volverajugar = "no";
		acabar = false;
		
		for (int y=0 ; y<10 ; y++) {
			for (int x=0 ; x<10 ; x++) {
			tablero[x][y]=("-");
			}
		}
	}
	
	public static void meterbombas(String[][] tablero) {
	int max = 9, min = 0 ;
	int posicionbombaY=0, posicionbombaX=0;
	
		for (int posiciones=0 ; posiciones<10 ; posiciones++) {
	
			do {
			posicionbombaY = (int) (Math.random() * (max - min + 1) + min);
			posicionbombaX = (int) (Math.random() * (max - min + 1) + min);
			tablero[posicionbombaY][posicionbombaX] = "*";
			} while (!tablero[posicionbombaY][posicionbombaX].equals("*"));
			
		}
	}
	
	public static void meterU(String[][] tablero) {
	
		int max = 9, min = 0;
		posiciony=0;
		posicionx=0;
		
		do {
		posiciony = (int) (Math.random () * (max - min + 1) + min);
		posicionx = (int) (Math.random () * (max - min + 1) + min);
		} while (tablero[posicionx][posiciony].equals("*"));
		tablero[posicionx][posiciony] = ("U");
	}
	
	public static void meterC(String[][] tablero) {
		
		int max = 9, min = 0;
		posicionyC=0;
		posicionxC=0;
		
		do {
		posicionyC = (int) (Math.random () * (max - min + 1) + min);
		posicionxC = (int) (Math.random () * (max - min + 1) + min);
		} while (tablero[posicionxC][posicionyC].equals("*"));
		tablero[posicionxC][posicionyC] = ("C");
	}
	
	public static void montartablero(String[][] tablero) {
	
		System.out.println("    0 1 2 3 4 5 6 7 8 9 ");
		System.out.println("  +---------------------+");
		
		for (int y=0 ; y<10 ; y++) {
			System.out.print(y+" | ");
			
			for (int x=0 ; x<10 ; x++) {
				System.out.print(tablero[x][y]+" ");
			}
			System.out.println("| "+y);
		}
		System.out.println("  +---------------------+");
		System.out.println("    0 1 2 3 4 5 6 7 8 9 ");
	}
	
	public static void moverU(String[][] tablero) {
	
		contadorU++;
		
		String movimiento=sc.nextLine();
		
		if (movimiento.equals("w") && posiciony!= 0) {
			tablero[posicionx][posiciony] = ("-");
			
			if (tablero[posicionx][posiciony=posiciony-1].equals("*")) {//METER CONTADOR BOMBAS COMIDAS
				contadorUBOMBAS++;
			}
			
			tablero[posicionx][posiciony]=("U");
		}
		
		
		if (movimiento.equals("s") && posiciony!= 9) {
			tablero[posicionx][posiciony] = ("-");
			
			if (tablero[posicionx][posiciony=posiciony+1].equals("*")) {
			contadorUBOMBAS++;
			}
			
			tablero[posicionx][posiciony]=("U");
		}
		
		
		if (movimiento.equals("a") && posicionx!= 0) {
			tablero[posicionx][posiciony] = ("-");
			
			if (tablero[posicionx=posicionx-1][posiciony].equals("*")) {
			contadorUBOMBAS++;
			}
			
			tablero[posicionx][posiciony]=("U");
		}
		
		
		if (movimiento.equals("d") &&  posicionx!= 9) {
			tablero[posicionx][posiciony] = ("-");
			
			if (tablero[posicionx=posicionx+1][posiciony].equals("*")) {
			contadorUBOMBAS++;
			}
			
			tablero[posicionx][posiciony]=("U");
		}
		
		
		
	}

	public static void moverC(String[][] tablero) {
		
		String asterisco="*"; int movimientox, movimientoy,movimientoGeneral; 
		
		int distancia=1000;
		int posxAsterisco=0;
		int posyAsterisco=0;
		//MIRAR DISTANCIA
		
		tablero[posicionxC][posicionyC] = ("-");
		for (int y=0 ; y<10 ; y++) {
			for (int x=0 ; x<10 ; x++) {
				if (asterisco.equals(tablero[x][y])) {
					movimientox = Math.abs(x - posicionxC);
					movimientoy = Math.abs(y - posicionyC);
					movimientoGeneral = movimientox + movimientoy;
					if (distancia>movimientoGeneral) {
						distancia=movimientoGeneral;
						posxAsterisco=x;
						posyAsterisco=y;
					}	
				}
			}
		}
		//CUAL MOVER ANTES
		int x=posxAsterisco, y=posyAsterisco, xc=posicionxC, yc=posicionyC;
		int totalx=10,totaly=10;

		if (xc<x) {
			totalx=x-xc;
		} 
		if (x<xc) {
			totalx=xc-x;
		}
		
		
		if (yc<=y) {
			totaly=yc-y;
		} 
		if (y<yc) {
			totaly=y-yc;
		}

		
		if (totalx<=totaly || totaly==0) {
			if (posicionxC>x) {
				posicionxC--;
			}
			else if (posicionxC<x) {
				posicionxC++;
			}
		}
		else if (totalx>totaly || totalx==0) {
			if (posicionyC>y) {
				posicionyC--;
			} 
			else if (posicionyC<y) {
				posicionyC++;
			}
		}
		if (tablero[posicionxC][posicionyC].equals("*")) {
			contadorCBOMBAS++;
		}
		tablero[posicionxC][posicionyC] = ("C");
		
	}
	
	public static void mostrarmovimientos(String[][] tablero) {
		
		if (contadorbombas>1) {
		System.out.println("Bombas = "+contadorbombas);
		System.out.println("Movimientos = "+contadorU);
		}
	}

	public static void acabarprograma(String[][] tablero) {
						
		do {System.out.println("entro");
			montartablero(tablero);
			
			moverU(tablero);
				
			moverC(tablero);
			
			mostrarmovimientos(tablero);
			
				
				
			String asterisco="*",resultado=""; contadorbombas=0;
			
			for (int y=0 ; y<10 ; y++) {
				for (int x=0 ; x<10 ; x++) {
					if (asterisco.equals(tablero[x][y])) {
					contadorbombas++;		
					}
				}
			}
			
			if (contadorUBOMBAS>contadorCBOMBAS) {
				resultado=(" Has ganado");
			}   else if (contadorUBOMBAS<contadorCBOMBAS){
				resultado=("Has perdido");
				} 	else {
					resultado=("   Empate  ");
					}
			
			if (contadorbombas==0) {
				acabar= true;
				System.out.println("+----------------------------------+");
				System.out.println("|                Fin               |");
				System.out.println("|    Numero de movimientos = "+contadorU+"    |");
				System.out.println("|   Numero de bombas comidas = "+contadorUBOMBAS+"   |");
				System.out.println("| Numero de bombas comidas IA = "+contadorCBOMBAS+"  |");
				System.out.println("|           "+resultado+"            |");
				System.out.println("+----------------------------------+");
			}			
		} while (!acabar);		
	}

	public static void volveraJugar(String[][] tablero) {
		
		System.out.println("Volver a Jugar s/n");
		volverajugar = sc.nextLine();
	}

}