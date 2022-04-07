package A03LinkedList;

public class Nodo<comodin> {

	private comodin dato;
	private Nodo<comodin> ant;
	private Nodo<comodin> sig;
	
	public Nodo(comodin dato) {
		this.setDato(dato);
		this.setAnt(null);
		this.setSig(null);
	}

	public comodin getDato() {
		return dato;
	}
	public void setDato(comodin dato) {
		this.dato = dato;
	}

	public Nodo<comodin> getAnt() {
		return ant;
	}
	public void setAnt(Nodo<comodin> ant) {
		this.ant = ant;
	}

	public Nodo<comodin> getSig() {
		return sig;
	}
	public void setSig(Nodo<comodin> sig) {
		this.sig = sig;
	}
	
}
