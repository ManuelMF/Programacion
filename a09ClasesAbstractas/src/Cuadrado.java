import java.io.Serializable;

public class Cuadrado extends PoligonoRegular implements Serializable {

	private static final long serialVersionUID = -715039059113932974L;

	public Cuadrado(double l) {
		super(4, l);
		
	}

	public double getArea() {
		return this.longitud*this.longitud;
	}

	
}
