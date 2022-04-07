import java.util.Scanner;

public class Tablero  {
	static Scanner sc=new Scanner(System.in);

	public Ficha[][] casillas;
	public char tirada;
	
	public Tablero() {
		this.tirada='B';
		casillas=new Ficha[8][8];
		
		for (int x=0;x<8;x++) casillas[x][1]=new Peon(x, 1, 'N');
		for (int x=0;x<8;x++) casillas[x][6]=new Peon(x, 6, 'B');
		
		casillas[2][4]=new Peon(2, 4, 'N');
		casillas[4][4]=new Peon(4, 4, 'B');
		
		casillas[0][0]=new Torre(0, 0, 'N');
		casillas[7][0]=new Torre(7, 0, 'N');
		casillas[0][7]=new Torre(0, 7, 'B');
		casillas[7][7]=new Torre(7, 7, 'B');
		
		casillas[1][0]=new Caballo(1, 0, 'N');
		casillas[6][0]=new Caballo(6, 0, 'N');
		casillas[1][7]=new Caballo(1, 7, 'B');
		casillas[6][7]=new Caballo(6, 7, 'B');
		
		casillas[2][0]=new Alfil(2, 0, 'N');
		casillas[5][0]=new Alfil(5, 0, 'N');
		casillas[2][7]=new Alfil(2, 7, 'B');
		casillas[5][7]=new Alfil(5, 7, 'B');
		
		casillas[3][0]=new Reina(3, 0, 'N');
		casillas[3][7]=new Reina(3, 7, 'B');
		
		casillas[4][0]=new Rey(4, 0, 'N');
		casillas[4][7]=new Rey(4, 7, 'B');

	}
	public void pintar() {
		System.out.println("     A   B   C   D   E   F   G   H");
		System.out.println("   ┌───┬───┬───┬───┬───┬───┬───┬───┐");
		for (int y=0;y<8;y++) {
			System.out.print  (" "+y+" │");
			for (int x=0;x<8;x++) {
				if (casillas[x][y]==null) {
					System.out.print(((x+y)%2==0)? "░░░":"   ");
					//System.out.print("   ");
				} else {
					//System.out.print(((x+y)%2==0)? "░"+casillas[x][y].forma+"░":" "+casillas[x][y].forma+" ");
					System.out.print(" "+casillas[x][y].forma+" ");
					
				}
				System.out.print("│");
			}
			System.out.println(" "+y);
			if (y<7)System.out.println("   ├───┼───┼───┼───┼───┼───┼───┼───┤");
			else System.out.println("   └───┴───┴───┴───┴───┴───┴───┴───┘");
		}
		System.out.println("     A   B   C   D   E   F   G   H\n");
	}
	
	
	public int mover(Posicion posIni, Posicion posFin) {
		
//		mirar que haya una ficha
		if(casillas[posIni.x][posIni.y]==null) return 2;
		
//		mirar que sea del mismo color
		else if (casillas[posIni.x][posIni.y].color!=this.tirada) return 1;
		
		for (Posicion p :  casillas[posIni.x][posIni.y].posiblesPosiciones(this)) {
			
//			mueve
			if (p.x == posFin.x && p.y == posFin.y ) {
				
				casillas[posFin.x][posFin.y]=casillas[posIni.x][posIni.y];  
				casillas[posIni.x][posIni.y]=null; 
				
				casillas[posFin.x][posFin.y].posicion=new Posicion(posFin.x,posFin.y);
				
				return 0;
			}
			
		}
//		no puede mover
		return 3;
	}

	public String terminar (Tablero T) {
		int contadorBlancas=0 , contadorNegras=0;
		for (int mx = 0 ; mx<7 ; mx++) {
			for (int my = 0 ; my<7 ; my++) {
				if (T.casillas[mx][my]!=null) {
					if (T.casillas[mx][my].color=='B') contadorBlancas++;
					if (T.casillas[mx][my].color=='N') contadorNegras++;
				}
			}
		}
		if (contadorBlancas==0) return "Blancas";
		if (contadorNegras==0) return "Negras";
		return null;
	}
	
	public int Letranum(String letra,int numX) {

		switch (letra) {
			case "a": numX=0; break;
			case "b": numX=1; break;
			case "c": numX=2; break;
			case "d": numX=3; break;
			case "e": numX=4; break;
			case "f": numX=5; break;
			case "g": numX=6; break;
			case "h": numX=7; break;
		}
		return numX;
	}
	
	public int jaqueNosotros(Tablero T) {
		
//		buscar el rey
		int xRey=0, yRey=0;
		for (int rx = 0 ; rx < 8 ; rx++) {
			for (int ry = 0 ; ry < 8 ; ry++) {
//				color distinto
				if (T.casillas[rx][ry]!=null && T.casillas[rx][ry].color != T.tirada) {
//					miramos forma
					if (T.casillas[rx][ry].forma  ==  ((T.casillas[rx][ry].color == 'B')? "\u265A":"\u2654")) {
						xRey=rx; yRey=ry;
					}
				}
			}
		}
//		buscamos las fichas
		for (int x = 0 ; x < 8 ; x++) {
			for (int y = 0 ; y < 8 ; y++) {				
//				dentro de cada ficha mirar las posiciones y si coincide con la posicion del rey devolvemos 1
				if (casillas[x][y] != null && casillas[x][y].color==T.tirada) {
					for (Posicion posficha : T.casillas[x][y].posiblesPosiciones(T)) {		
						if (posficha.x==xRey && posficha.y==yRey) return 1; 
					}
				}
			}
		}
		return 0;
	}
	
	public int jaqueANosotrosAlMover(Tablero T) {
	
//		buscar mi rey
		int xRey=0, yRey=0;
		for (int rx = 0 ; rx < 8 ; rx++) {
			for (int ry = 0 ; ry < 8 ; ry++) {
//				color 
				
				if (T.casillas[rx][ry]!=null && T.casillas[rx][ry].color == T.tirada) {
					if (T.casillas[rx][ry].forma  ==  ((T.casillas[rx][ry].color == 'B')? "\u265A":"\u2654")) {
						xRey=rx; yRey=ry;
					}
				}
			}
		}
		for (int x = 0 ; x < 8 ; x++) {
			for (int y = 0 ; y < 8 ; y++) {				

				if (casillas[x][y] != null && casillas[x][y].color!=T.tirada) {
					for (Posicion posficha : T.casillas[x][y].posiblesPosiciones(T)) {		
						
							if (posficha.x==xRey && posficha.y==yRey) return 1; 
						
					}
				}
			}
		}
		return 0;
	}
	
	public int jaquemate(Tablero T) {

		// buscar el rey
		int mirarJaqueMate=0;
		int JaqueMate=0;
		int xRey=0, yRey=0;
		for (int rx = 0 ; rx < 8 ; rx++) {
			for (int ry = 0 ; ry < 8 ; ry++) {
				// color distinto
				if (T.casillas[rx][ry]!=null && T.casillas[rx][ry].color != T.tirada) {
					// miramos forma
					if (T.casillas[rx][ry].forma  ==  ((T.casillas[rx][ry].color == 'B')? "\u265A":"\u2654")) {
						xRey=rx; yRey=ry;
					}
				}
					
			}
		}

		// buscamos las fichas
		for (int x = 0 ; x < 8 ; x++) {
			for (int y = 0 ; y < 8 ; y++) {
				// dentro de cada ficha mirar las posiciones y si coincide con la posicion del rey devolvemos 1
				if (casillas[x][y] != null && casillas[x][y].color==T.tirada) {
					for (Posicion posficha : T.casillas[x][y].posiblesPosiciones(T)) {
						if (posficha.x==xRey && posficha.y==yRey) mirarJaqueMate = 1;
					}
				}
			}
		}
		
		if (mirarJaqueMate==1) {

			boolean mate=true;

			for (int x = 0 ; x < 8 ; x++) {
				for (int y = 0 ; y < 8 ; y++) {

					// miro las casillas de otro color
					if (casillas[x][y] != null && casillas[x][y].color!=T.tirada) {
						// miramos las posibles posiciones de cada ficha para moverlas y mirar si se hace jaque aun
						for (Posicion posficha : T.casillas[x][y].posiblesPosiciones(T)) {
							// guardamos la pos anterior
							Ficha f=T.casillas[posficha.x][posficha.y];
							// movemos
//							T.mover(new Posicion(x,y), posficha);
							
							casillas[posficha.x][posficha.y]=casillas[x][y];
							casillas[posficha.x][posficha.y].posicion=new Posicion(posficha.x,posficha.y);
							casillas[x][y]=null;
							
							boolean jaque=false;
							// miramos en el tablero si hay algun jaque
							for (int xx = 0 ; xx < 8 ; xx++) {
								for (int yy = 0 ; yy < 8 ; yy++) {
									// miramos un ficha nuestra y miramos si hace jaque algun posible movimiento
									if (casillas[xx][yy] != null && casillas[xx][yy].color==T.tirada) {
										for (Posicion possficha : T.casillas[xx][yy].posiblesPosiciones(T)) {
											if (possficha.x==xRey && possficha.y==yRey) jaque=true;
										}
									}
								}
							}

							// volver detras el posible movimiento
							casillas[x][y]=casillas[posficha.x][posficha.y];
							casillas[x][y].posicion=new Posicion(x,y);
							casillas[posficha.x][posficha.y]=f;
							
							
							
							
							// si en todas en los posibles movimientos no se hizo ningun jaque será que le mate es false
							if (jaque==false) {
								mate=false; 
							}
						}
						
					}


				}
			}
			if (mate=false) return 1;
			if (mate) return 0;

		}
		return 2;
	}
	
		

}
