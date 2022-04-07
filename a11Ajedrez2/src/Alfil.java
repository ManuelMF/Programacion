import java.util.LinkedList;

public class Alfil extends Ficha {

	private static final long serialVersionUID = 1639103150087105286L;

	public Alfil(int x, int y, char c) {
		super(x, y, c, (c=='B' || c=='b')? "\u265D":"\u2657");

	}

	@Override
public LinkedList<Posicion> posiblesPosiciones(Tablero tab) {
		
		
		LinkedList<Posicion> posibles=new LinkedList<Posicion>();
		Ficha[][] casillas=tab.casillas;
		int x=this.posicion.x, y=this.posicion.y;
		int tempx, tempy;
		 
		
		//derecha, arriba
		tempx=x+1; 
		tempy=y-1;
		while(tempx<8&&tempy>=0)
		{
			if(casillas[tempx][tempy]==null)posibles.add(new Posicion(tempx,tempy));
			else if(casillas[tempx][tempy].color==this.color) break;
			else {
				posibles.add(new Posicion(tempx,tempy));
				break;
			}
			tempx++;
			tempy--;
		}
				
		//izquierda abajo
		tempx=x-1;
		tempy=y+1;
		while(tempx>=0&&tempy<8)
		{
			if(casillas[tempx][tempy]==null) posibles.add(new Posicion(tempx,tempy));
			else if(casillas[tempx][tempy].color==this.color) break;
			else {
				posibles.add(new Posicion(tempx,tempy));
				break;
			}
			tempx--;
			tempy++;
		}
		
		//izquierda arriba
		tempx=x-1;
		tempy=y-1;
		while(tempx>=0&&tempy>=0)
		{
			if(casillas[tempx][tempy]==null) posibles.add(new Posicion(tempx,tempy));
			else if(casillas[tempx][tempy].color==this.color) break;
			else {
				posibles.add(new Posicion(tempx,tempy));
				break;
			}
			tempx--;
			tempy--;
		}
		
		//derecha abajo
		tempx=x+1;
		tempy=y+1;
		while(tempx<8&&tempy<8)
		{
			if(casillas[tempx][tempy]==null) posibles.add(new Posicion(tempx,tempy));
			else if(casillas[tempx][tempy].color==this.color) break;
			else {
				posibles.add(new Posicion(tempx,tempy));
				break;
			}
			tempx++;
			tempy++;
		}
		return posibles;
	}

}
