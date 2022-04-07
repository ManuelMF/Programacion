import java.util.LinkedList;

public class Rey extends Ficha {

	private static final long serialVersionUID = 6268941617942191637L;

	public Rey(int x, int y, char c) {
		super(x, y, c, (c=='B' || c=='b')? "\u265A":"\u2654");

	}

	@Override
	public LinkedList<Posicion> posiblesPosiciones(Tablero tab) {

		LinkedList<Posicion> posibles=new LinkedList<Posicion>();
		Ficha[][] casillas=tab.casillas;
		int x=this.posicion.x, y=this.posicion.y;
		
		int posx[] = {x,  x+1,x+1,x+1,x  ,x-1,x-1,x-1};
		int posy[] = {y-1,y-1,y  ,y+1,y+1,y-1,y  ,y+1};
		
		for(int i=0;i<8;i++) {
		if ((posx[i]>=0&&posx[i]<8&&posy[i]>=0&&posy[i]<8) && (casillas[posx[i]][posy[i]]==null || casillas[posx[i]][posy[i]].color!=this.color)) posibles.add(new Posicion(posx[i],posy[i]));
		}
		 
		return posibles;
	}

}
