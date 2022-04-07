package A04Excepciones;

public class Edad {
	private int edad;
	private int min;
	private int max;
	
	public Edad(int min,int max) {
		this.min=min;
		this.max=max;
		
		if (min>max || min<0 || max<0) {
			throw new RangoIncorrectoException();
		}
	}

	public int getEdad() {
		return edad;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}
	
	public void setEdad(int edad) {
		if (edad>=this.min && edad<=this.max) {
			this.edad=edad;
		} else {
			throw new EdadFueraDeRangoExcepcion("Mínimo: "+this.min+", Máximo: "+this.max);	
		}
	}
	
	public int compareTo(Edad e) {
		if (this.edad==e.edad) return 0;
		if (this.edad<e.edad) return -1;
		return 1;
		
	}
	
	
}
