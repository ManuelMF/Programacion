package A07Static_Banco;

import java.util.Comparator;

public class comparadorImporte implements Comparator<Movimiento>{

	@Override
	public int compare(Movimiento o1, Movimiento o2) {
		return o1.getImporte().compareTo(o2.getImporte());
		
	}

}
