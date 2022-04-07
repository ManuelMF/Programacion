package A03LinkedList;

public class Pila<T> {
	private miLista<T> lista;
	
	public Pila() {
		lista=new miLista<T>();
	}
	
	public T push(T dato) {
		lista.addFirst(dato);
		return dato;
	}
	
	public T pop() {
		return this.lista.removeFirst();
	}
	
	public T peek() {
		return this.lista.getFirst();
	}
	
	public boolean empty() {
		return this.lista.IsEmpty();
	}
	
	public int search(T dato) {
		
		if (lista.indexOf(dato)==-1) return -1;
		return lista.indexOf(dato)+1;
	}
}
