package A07Static_Banco;

import java.io.Serializable;

public class Cliente implements Serializable  {
//	Propiedades: nombre, dni 
	
//	metodos: metodo constructor cliente que se le pasa el nombre y dni 
//	get nombre y get dni
	
	private static final long serialVersionUID = -1180274887982477582L;

	private String nombre;
	
	private String dni;
	
	public Cliente (String nombre, String dni) {
		this.nombre=nombre;
		this.dni=dni;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

}
