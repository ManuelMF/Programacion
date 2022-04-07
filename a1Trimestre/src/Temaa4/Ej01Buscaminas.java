package Temaa4;

import java.util.Scanner;


public class Ej01Buscaminas {
	static Scanner sc=new Scanner(System.in);
	static int bomba=9,X,Y,XX,YY,ancho,alto,contadorbombas,contadordefalse,PERDEMOS=0,ayuda=0,contadorAyuda=0,contadorAyuda2=0,entra=0;
	static String Marcar;
	public static void main(String[] args) {
		
		dificultad();
		
		int [][] tablero = new int [ancho][alto];
		boolean [][] abiertos = new boolean [ancho][alto];
		boolean [][] marcar = new boolean [ancho][alto];
		
		pedirayuda(abiertos,tablero);
		
		boolean [][] abiertosayuda = new boolean [ancho][alto];
		boolean [][] abiertosayuda2 = new boolean [ancho][alto];
		
		inializaAbierto(abiertos,abiertosayuda,abiertosayuda2);
		
		meterbombas(tablero);
		
		contornodebombas(tablero);
		
		estadoTablero(abiertos, tablero,abiertosayuda,marcar,abiertosayuda2);
		
		do {
		posicion(tablero);
		if (!Marcar.equals("s")) {
		destapar(tablero, abiertos ,X,Y);
		}
		if (ayuda==1) {
			meterayuda(abiertos, tablero,abiertosayuda);
			meterayuda2(abiertos, tablero,abiertosayuda,abiertosayuda2);
			meterayuda(abiertos, tablero,abiertosayuda);
			meterayuda2(abiertos, tablero,abiertosayuda,abiertosayuda2);
		}
		
		marcar(marcar);
		
		estadoTablero(abiertos, tablero,abiertosayuda,marcar,abiertosayuda2);
		} while (contadorbombas!=contadordefalse && PERDEMOS!=1);
		
		fin(abiertos, tablero);
	}

	public static void dificultad() {
		
		alto=10;
		ancho=10;
		System.out.println("┌────────────────┐");
		System.out.println("│   Buscaminas   │");
		System.out.println("└────────────────┘");
		System.out.println("┌─────────────────┐");
		System.out.println("│   Dificultad?   │");
		System.out.println("└─────────────────┘");
		System.out.println("┌────────────┐");
		System.out.println("│ 1) Fácil   │");
		System.out.println("│ 2) Media   │");
		System.out.println("│ 3) Difícil │");
		System.out.println("└────────────┘");
		String dif =sc.nextLine();

		if (dif.equals("2")) {
			ancho=20;
		}
		if (dif.equals("3")) {
			ancho=30;
			alto=20;
		}
	}

	public static void pedirayuda(boolean[][] abiertos, int[][] tablero) {
		System.out.println("┌─────────────────┐");
		System.out.println("│ ¿Quieres ayuda? │");
		System.out.println("└─────────────────┘");
		String respuestaAyuda = sc.nextLine();
		
		if (respuestaAyuda.equals("si")) {
			ayuda=1;
		}
	}
	
	public static void inializaAbierto(boolean[][] abiertos,boolean[][] abiertosayuda,boolean[][] abiertosayuda2) {
		//PONE FALSE A LA LONGITUD DE EL MAPA QUE QUERAMOS
		for (int y=0 ; y < abiertos[0].length ; y++) {
			for (int x=0 ; x < abiertos.length ; x++) {
				abiertos[x][y] = false;
				abiertosayuda[x][y] = false;
				abiertosayuda2[x][y] = false;
				
			}
		}
	}

	public static void meterbombas(int[][] tablero) {
		//10%	BOMBAS
		int x,y;
		//10% DE LA LONGITUD QUE LE DIGAMOS
		for (int i=0 ; i<(tablero.length*tablero[0].length*0.1) ; i++) {
	        do {
	            y=(int) (Math.random() * tablero[0].length);
	            x=(int) (Math.random() * tablero.length);
	         } while (tablero[x][y]==9);
	            contadorbombas++;
	        tablero[x][y]=9;//POSICIONAMOS BOMBA Y VOLVEMOS 
		}
	}

	public static void contornodebombas(int[][] tablero) {

		//PASAMOS POR TODO EL TABLERO
		for (int y=0 ; y < tablero[0].length ; y++) {
			for (int x=0 ; x < tablero.length ; x++) {
				//SI ES DISTINTO A BOMBA CONTAMOS 
				if (tablero[x][y]!=9) {
					int numbombas=0;
					for (int yy=y-1 ; yy<=y+1 ; yy++) {    //CONTAMOS CON UN FOR EL ALREDEDOR PREGUNTANDOLE SI LA POSICION ES CORRECTA Y SI ES UN 9
						for (int xx=x-1 ; xx<=x+1 ; xx++) {
							if (posicioncorrecta(xx,yy, tablero) && tablero[xx][yy]==9) {
								numbombas++;
							}
							
						}
					}	
					tablero[x][y]=numbombas;
				}
			}
		}			
	}
	
	public static boolean posicioncorrecta (int x,int y, int [][] tablero) {
		//MIRAMOS SI ESTA DENTRO DEL CUADRO A LA HORA DE SUMAR BOMBAS
		if (x>=0 && x<tablero.length && y>=0 && y<tablero[0].length) {
			return true;//SI ESTA DENTRO DEVOLVEMOS TRUE CUANDO SE LO PIDAMOS
		}
		return false;
	}

	public static void estadoTablero(boolean[][] abiertos, int[][] tablero,boolean[][] abiertosayuda,boolean[][] marcar,boolean[][] abiertosayuda2) {
		
		//TABLERO
		System.out.print("     ");
		for (int x=0; x<abiertos.length ;x++) {
			System.out.print(x+" ");
			if (x<10) {System.out.print(" ");}
		}
		System.out.println();
		System.out.print("   ┌");
		for (int x=0 ; x<abiertos.length;x++) {
			System.out.print("───");
		}
		System.out.println("┐");

		for (int y=0 ; y < abiertos[0].length ; y++) {
			
			System.out.print(y);
			if (y < 10) {System.out.print(" ");}
			System.out.print(" │");
			
			for (int x=0 ; x<abiertos.length ; x++) {
				if (marcar[x][y]==true) {
					System.out.print(" © ");
				}
				if (abiertos[x][y]==false ) {
					
					if ((abiertosayuda[x][y] == true)) {
						System.out.print("▒▒▒");
					}
					//if ((abiertosayuda2[x][y] == true)) {
					else if ((abiertosayuda2[x][y] == true)) {
					//else {
						System.out.print("░░░");
					} 
					// if (abiertosayuda[x][y] == false && abiertosayuda2[x][y] == false) {
					else {
						 System.out.print("▓▓▓");
					}  
				} 
				else {
					if (tablero[x][y]==0) {
						System.out.print("   ");
					} else if (tablero[x][y]==9) {
						System.out.print(" ☼ ");
						} else {
					
						System.out.print(" "+tablero[x][y]+" ");
					}
				}

			}
			System.out.println("│ "+y);
		}
		System.out.print("   └");
		for (int x=0 ; x<abiertos.length;x++) {
			System.out.print("───");
		}
		
		System.out.println("┘");
	
		System.out.print("     ");
		for (int x=0; x<abiertos.length ;x++) {
			System.out.print(x+" ");
			if (x<10) {
				System.out.print(" ");
			}
		}
		System.out.println();
		//cuente falsos para el while 
		contadordefalse=0;
		for (int y=0 ; y < abiertos[0].length ; y++) {
			for (int x=0 ; x < abiertos.length ; x++) {
					if (abiertos[x][y]==false || abiertosayuda[x][y]==true || marcar[x][y]==true ) {
						contadordefalse++;
					}
			}
		}	
	}

	public static void posicion(int[][] tablero) {
		//SE USARA UNA VEZ LAS VARIABLES X,Y GLOBALES ENTRANDO POR SEQUENCIA LUEGO PARA SEGUIR JUGANDO SE USARA LAS VARIABLES DE DESTAPAR INT x INT y
		System.out.println("Pulsa s para marcar");
		Marcar = sc.nextLine();
		if (Marcar.equals("s")) {
			System.out.println("Posicion \nX:");
			XX = Integer.parseInt(sc.nextLine());
			System.out.println("Y:");
			YY = Integer.parseInt(sc.nextLine());
		} else {
		System.out.println("Posicion \nX:");
		X = Integer.parseInt(sc.nextLine());
		System.out.println("Y:");
		Y = Integer.parseInt(sc.nextLine());
		}
	}
	
	public static void destapar(int [][] tablero ,boolean[][] abiertos,int x,int y) {
		//ESTÁ USANDO LA VARIABLE X,Y QUE VAN EN ORDEN LUEGO USARA PARA DESTAPAR LAS VARIABLES xx,yy
		//DESTAPA
		abiertos[x][y]=true;
		//SI ES 0 DESTAPA EL CONTORNO HACIENDO UN BUCLE QUE DESTAPE TODOS LOS 0
		if (tablero[x][y]==0) {
			
			for (int yy=y-1 ; yy<=y+1 ; yy++) {
				for (int xx=x-1 ; xx<=x+1 ; xx++) {
					if (posicioncorrecta(xx,yy, tablero) && abiertos[xx][yy]==false) {
						destapar (tablero,abiertos,xx,yy);
					}
				}
			}	
		}	
		//MIRAR SI ES 9 PARA DECIR SI PERDEMOS
		if (tablero[x][y]==9) {
			PERDEMOS=1;
			
		}
	}

	public static void meterayuda(boolean[][] abiertos, int[][] tablero, boolean[][] abiertosayuda) {
		
		//METEMOS AYUDA
		for (int y=0 ; y < abiertos[0].length ; y++) {
			for (int x=0 ; x<abiertos.length ; x++) {
		
				if (abiertos[x][y]==true && tablero[x][y]!=0) {
				contadorAyuda=0;	
					for (int yy=y-1 ; yy<=y+1 ; yy++) {    //MIRAR CONTORNO PARA MIRAR LOS FALSE
						for (int xx=x-1 ; xx<=x+1 ; xx++) {
							if (posicioncorrecta(xx,yy, tablero) && abiertos[xx][yy]==false ) {
								contadorAyuda++;//CONTAMOS FALSE
							}
						}
					}	
					
					if (contadorAyuda==tablero[x][y]) {//SI AYUDA ES IGUAL AL NUMERO DEL TABLERO ES SEGURO QUE HAY BOMBA
						for (int yyy=y-1 ; yyy<=y+1 ; yyy++) {    //MIRAR CONTORNO
							for (int xxx=x-1 ; xxx<=x+1 ; xxx++) {
								if (posicioncorrecta(xxx,yyy, tablero) && abiertos[xxx][yyy]==false) {
									
									abiertosayuda[xxx][yyy] = true;
									
								}
							}
						}	
					}	
				}
			}
		}
	}
	
	public static void meterayuda2(boolean[][] abiertos, int[][] tablero, boolean[][] abiertosayuda,boolean[][] abiertosayuda2) {
		
		for (int y=0 ; y < abiertos[0].length ; y++) {
			for (int x=0 ; x<abiertos.length ; x++) {
				
				if (abiertos[x][y]==true && tablero[x][y]!=0) {
					contadorAyuda2=0;
					for (int yy=y-1 ; yy<=y+1 ; yy++) {    //MIRAR CONTORNO PARA MIRAR LOS FALSE
						for (int xx=x-1 ; xx<=x+1 ; xx++) {
							
							if (posicioncorrecta(xx,yy, tablero) && abiertos[xx][yy]==false && abiertosayuda[xx][yy]==true) {
								contadorAyuda2++;//CONTAMOS FALSE SEGURO BOMBA
							}
							
							
						}
					}
					
					if (contadorAyuda2>=tablero[x][y]) {
						
						for (int yy=y-1 ; yy<=y+1 ; yy++) {    
							for (int xx=x-1 ; xx<=x+1 ; xx++) {
								if (posicioncorrecta(xx,yy, tablero) && abiertos[xx][yy]==false && abiertosayuda[xx][yy]==false) {
									abiertosayuda2[xx][yy]=true;
								}
							}
						}
					}
				}	
			}
		}	
	}
	
	public static void marcar(boolean[][] marcar) {
		
		if (Marcar.equals("s")) {
			marcar[XX][YY]=true;
		}
	}
	
	public static void fin(boolean[][] abiertos, int[][] tablero) {
		
		if (contadorbombas==contadordefalse) {
			System.out.println("Has ganado!!!");
		} else {
			System.out.println("Has perdido noob!!!");
		}
	}
}

