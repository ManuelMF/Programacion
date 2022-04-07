import java.util.Scanner;

public class Main {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {

		Tablero t=new Tablero();
//		hacer todos los ejercicios que dice pache y enrroque y tranformar ficha al llegar
		
		
		t.pintar();
		
		boolean error=true;
		char tirada='N';
		boolean movjaque=false;
		
		System.out.println("Empiezan blancas o negras (b/n)");
		do {
			try {
				tirada = sc.nextLine().toUpperCase().charAt(0);
				if (tirada=='b' || tirada=='n' || tirada=='B' || tirada=='N') error = false;
				else throw new Exception();
			}catch (Exception e) {
				System.out.println("Blancas o Negras!!");
			}
		} while(error);
		
		t.tirada=tirada;
		
		String fin;
		
		do {
			boolean movimientocorrecto=false;
			int x = 0 , y = 0;
			boolean jaquemate=false;
			do {
				movjaque=false;
				jaquemate=false;
				
				do {
					System.out.println(t.tirada+": Que ficha quieres mover \n x:");
					String xlet = sc.nextLine();
					
					x = t.Letranum(xlet,x);
					
					System.out.println("x:"+xlet);
					System.out.println("y:");
					
					int lol=0;
					do {
						try {
							y = Integer.parseInt(sc.nextLine());
							lol=1;
						} catch (NumberFormatException ee) {
							System.out.println("Tiene que ser un numero");
						}
					} while(lol==0);
					
					if (t.casillas[x][y]!=null && t.casillas[x][y].color==t.tirada) movimientocorrecto=true;
					else System.out.println("Pieza no valida");
					
					
				} while (movimientocorrecto==false);
				
				int xx=0,yy;
				do {
					movimientocorrecto=false;
					
					System.out.println(t.tirada+": Donde quieres mover \n x:");
					String xxlet = sc.nextLine();
					
					xx=t.Letranum(xxlet,xx);
					
					System.out.println("x:"+xxlet);
					System.out.println("y:");
					yy=0;
					int lol=0;
					do {
						try {
							yy = Integer.parseInt(sc.nextLine());
							lol=1;
						} catch (NumberFormatException ee) {
							System.out.println("Tiene que ser un numero");
						}
					} while(lol==0);
						
					// MIRAR SI ENRROCA parte 1 
					int enro=0;
					if (t.casillas[x][y].forma.equals((t.casillas[x][y].color=='B' || t.casillas[x][y].color=='b')? "\u265A":"\u2654") && t.casillas[xx][yy].forma.equals((t.casillas[x][y].color=='B' || t.casillas[x][y].color=='b')? "\u265C":"\u2656")) {
						enro=1;
					}
					
					if (t.mover(new Posicion(x, y),new Posicion (xx,yy))==0) movimientocorrecto=true;
					else System.out.println("No es un movimiento valido");
						
					// MIRAR SI ENRROCA parte 2
					if (enro==1) t.casillas[x][y]=new Torre(x, y, (t.casillas[xx][yy].color=='B')? 'B':'N');
				} while (movimientocorrecto==false);
				
//				jaque cuando mueves
				
				 if(t.jaqueANosotrosAlMover(t)==1) {
					System.out.println("Si mueves ahi se hace Jaque mate, mueve en otro sitio");
					jaquemate=true;
					//ECHAR A DETRAS LA FICHA
					t.casillas[x][y]=t.casillas[xx][yy];  
					t.casillas[xx][yy]=null; 
					
					t.casillas[x][y].posicion=new Posicion(x,y);
					
				}	
				
			}while (jaquemate==true);
				
			t.convertirReina(t);
			t.pintar();
			
//			jaque
//			hará un if y si es jaque le avisara y le obligara a mover rey 
			if (t.jaquemate(t)==0) {
				System.out.println("Jaque mate") ;
				if (t.tirada=='B') fin="Blancas"; 
				else fin="Negras";}
			else if (t.jaqueNosotros(t)==1) { movjaque=true; System.out.println("Jaque");}
			
			
			if (t.tirada=='N') t.tirada='B';
			else t.tirada='N';
			
			
			fin = t.terminar(t);
			
		}while (fin==null);
		
		System.out.println("Fin de la partida");
		System.out.println("Ha ganado "+fin);
	}
	
	
}

