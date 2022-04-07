package A03LinkedList;

public class queue<T> {
	
	private miLista<T> lista;
	
	public queue() {
		lista=new miLista<T>();
	}
	
	public T peek() {
		return this.lista.getFirst();
	}
	
	public T pol() {
		return this.lista.removeFirst();
	}
	
	public boolean add(T dato) {
		lista.addLast(dato);
		return true;
	}
}
