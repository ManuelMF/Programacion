package ordenar;

import java.util.Comparator;

public class comparadorFecha implements Comparator<Vehiculo>  {

	@Override
	public int compare(Vehiculo o1, Vehiculo o2) {

		return o1.fecha.compareTo(o2.fecha);	
	}
}
