package A01;

public class Alumno {

	//declaramos variables
	private String nombre;
	private String apellidos;
	private int edad;

	
	
	//metodo contructor
	public Alumno(String n, String a, int e) {
		nombre = n;
		
		apellidos = a;
				
		edad = e;
		

	}
	
	//getter
	public int getEdad() {
		return edad;
	}
	public String getNombreYAp() {
		return nombre + " " + apellidos;
	}

	//setter
	public void setEdad(int cambioEdad) {
		if (cambioEdad>0 && cambioEdad<120) {
		edad=cambioEdad;	
		} else { System.out.println("Edad incorrecta");}
	
	}
}
