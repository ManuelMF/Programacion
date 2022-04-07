import java.io.Serializable;
import java.util.LinkedList;


public abstract class Ficha implements Serializable {

	private static final long serialVersionUID = 700349817792229420L;
	public Posicion posicion;
	public char color;
	public String forma;
	
	
	public Ficha (int x,int y,char c, String forma) {
		this.color=(c=='B' || c=='b')? 'B':'N';
		this.forma=forma;
		this.posicion=new Posicion(x, y);
	}
	
	public abstract LinkedList<Posicion> posiblesPosiciones(Tablero tab);
	

}
