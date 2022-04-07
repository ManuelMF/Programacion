import java.io.Serializable;

public class Posicion implements Serializable {

	private static final long serialVersionUID = 5072946687817529241L;
	public int x;
	public int y;
	
	public Posicion (int x, int y) {
		this.x=x;
		this.y=y;
	}

}
