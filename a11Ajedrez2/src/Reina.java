import java.util.LinkedList;

public class Reina extends Ficha {

	private static final long serialVersionUID = 7133757405818241834L;

	public Reina(int x, int y, char c) {
		super(x, y, c, (c=='B' || c=='b')? "\u265B":"\u2655");
	}

	@Override 
	public LinkedList<Posicion> posiblesPosiciones(Tablero tab) {
		
		
		LinkedList<Posicion> posibles=new LinkedList<Posicion>();
		Ficha[][] casillas=tab.casillas;
		int x=this.posicion.x, y=this.posicion.y;
		int tempx, tempy;
		
		//horizontal izquierda.
		tempx=x-1;
		while(tempx>=0)
		{
			if(casillas[tempx][y]==null) posibles.add(new Posicion(tempx,y));
			else if(casillas[tempx][y].color==this.color) break;
			else {
				posibles.add(new Posicion(tempx,y));
				break;
			}
			tempx--;
		}
		//horizontal derecha
		tempx=x+1;
		while(tempx<8)
		{
			if(casillas[tempx][y]==null) posibles.add(new Posicion(tempx,y));
			else if(casillas[tempx][y].color==this.color) break;
			else {
				posibles.add(new Posicion(tempx,y));
				break;
			}
			tempx++;
		}
		
		//vertical arriba
		tempy=y-1;
		while(tempy>=0)
		{
			if(casillas[x][tempy]==null) posibles.add(new Posicion(x,tempy));
			else if(casillas[x][tempy].color==this.color) break;
			else {
				posibles.add(new Posicion(x,tempy));
				break;
			}
			tempy--;
		}
		
		//vertival abajo
		tempy=y+1;
		while(tempy<8)
		{
			if(casillas[x][tempy]==null) posibles.add(new Posicion(x,tempy));
			else if(casillas[x][tempy].color==this.color) break;
			else {
				posibles.add(new Posicion(x,tempy));
				break;
			}
			tempy++;
		}
		
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
		
		//derecha abajo
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
