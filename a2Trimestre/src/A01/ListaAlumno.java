package A01;

import java.util.LinkedList;

public class ListaAlumno {

	private LinkedList<Alumno> lista;
	
	
	private String NombreLista;

	//constructor, mismo nombre que la clase
	public ListaAlumno(int n, String nn) {
		lista = new LinkedList<Alumno>();
		
		NombreLista=nn;
	}
	
	public void addAlumno (Alumno al) {
		lista.add(al);
	}	
	
	public Alumno getAlumno(int pos) {
		if (pos<0 || pos>=lista.size()) {
		 return null;
		} else {return lista.get(pos);}
	}

	public String getNombreLista() {
		return NombreLista;
	}
	public int tamanyo() {
		return lista.size();
	}
}
