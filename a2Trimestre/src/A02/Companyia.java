package A02;

import java.util.LinkedList;

public class Companyia {
	
	private LinkedList<Abonado> clientes;
	private String nombre;
	
	
	public Companyia(String nombre) {
		this.clientes=new LinkedList<Abonado>();
		this.nombre = nombre;
		
	}

	public boolean addAbonado (Abonado a) {
		if (this.clientes.contains(a)) {
			return false;
		} else
		this.clientes.add(a);
		return true;
	}
	
	public Abonado findByTel (String tel) {
		for (Abonado abo : this.clientes) {
			if (abo.getTel().equals(tel)) {
				return abo;
			} 
		} 
		return null;
	}
	
	public boolean delAbonado (Abonado baja) {
		if (this.clientes.contains(baja)) {
			this.clientes.remove(baja);
			return true;
		}
		return false;
	}
	public String getNombre() {
		return this.nombre;
	}
	
	public LinkedList<Abonado> ListaEnllamada() {
		LinkedList<Abonado> lista =new LinkedList<Abonado>();
		for (Abonado abo : this.clientes) {
			if (abo.estado()) {
				lista.add(abo); 
			}
		}
		
		return lista;
		
	}
}
