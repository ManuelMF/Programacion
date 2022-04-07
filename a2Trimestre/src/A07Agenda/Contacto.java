package A07Agenda;

import java.util.LinkedList;

public class Contacto {

	private String nombre;
	
	LinkedList <Informacion> info;
	
	public Contacto(String n) {
		info = new LinkedList <Informacion>();
		
		this.setNombre(n);
	}
	
	public void addInfo (Informacion i) {
		this.info.add(i);
	}
	
	public void delInfo (Informacion i) {
		this.info.remove(i);
	}
	
	public void update (String n) {
		this.setNombre(n);
	}
	
	public String FintInfo (String n) {
		for (int x=0 ; x < info.size() ; x++) {
			
			Informacion info=this.info.get(x);
			if (info.getNombre().equals(n)) {
				return info.getValor();
			}
	}
		return "No hay datos";
	}
	


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
