package A02;

public class Abonado {
	private String nombre;
	private String tel;
	private Abonado interlocutor;
	
	public Abonado(String nombre, String tel) {
		this.nombre = nombre;
		this.tel = tel;
		interlocutor = null;	
	}
	
	public boolean llamar(Abonado a) {
		if (a.interlocutor == null && this.interlocutor == null) {
			interlocutor = a;
			a.interlocutor = this;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean colgar() {
		if (interlocutor!=null) {
			interlocutor.interlocutor = null;
			interlocutor = null;
			return true;
		} else {return false;}
	}
	
	public boolean estado() {
		if (interlocutor==null) {
			return false;
		} else {
			return true;
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getTel() {
		return tel;
	}
}
