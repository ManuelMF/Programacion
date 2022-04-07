import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//     hay que poner asi el public cuando usemos clases abstractas
public abstract class PoligonoRegular implements Serializable {
	
	private static final long serialVersionUID = -8492050923615966410L;
	public int lados;
	public double longitud;
	
	public PoligonoRegular(int la, double lo) {
		this.lados=la;
		this.longitud=lo;
	}
	
	public double getPerimetro() {
		return this.lados*this.longitud;
	}
	
	public abstract double getArea();

	
}
