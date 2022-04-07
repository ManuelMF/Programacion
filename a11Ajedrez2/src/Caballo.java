import java.util.LinkedList;

public class Caballo extends Ficha {

	private static final long serialVersionUID = 6722561948483842243L;

	public Caballo(int x, int y, char c) {
		super(x, y, c, (c=='B' || c=='b')? "\u265E":"\u2658");
	}

	@Override
	public LinkedList<Posicion> posiblesPosiciones(Tablero tab) {
		
		LinkedList<Posicion> posibles=new LinkedList<Posicion>();
		Ficha[][] casillas=tab.casillas;
		int x=this.posicion.x, y=this.posicion.y;
		
		posibles.clear();
		int posx[]={x+1,x+1,x+2,x+2,x-1,x-1,x-2,x-2};
		int posy[]={y-2,y+2,y-1,y+1,y-2,y+2,y-1,y+1};
		for(int i=0;i<8;i++) {
//			mira que este dentro del tablero                      mira que no haya fichas              mira que no haya una ficha de otro color      si esto se cumple lo añado    
			if ((posx[i]>=0&&posx[i]<8&&posy[i]>=0&&posy[i]<8) && (casillas[posx[i]][posy[i]]==null || casillas[posx[i]][posy[i]].color!=this.color)) posibles.add(new Posicion(posx[i],posy[i]));
		}

		return posibles;
	}

}
