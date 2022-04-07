package A04Excepciones;

public class EdadFueraDeRangoExcepcion extends RuntimeException{
	public EdadFueraDeRangoExcepcion() {
		super();
	}
	
	public EdadFueraDeRangoExcepcion(String msg) {
		super(msg);
	}
	
}
