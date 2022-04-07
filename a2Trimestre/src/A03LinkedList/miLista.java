package A03LinkedList;

import java.util.NoSuchElementException;

public class miLista<T> {

	private Nodo<T> primero;
	private Nodo<T> ultimo;
	private int cantidad;
	
	public miLista() {
		// llamo al metodo para dejarlo a 0 todo
		this.primero=null;
		this.ultimo=null;
		this.cantidad=0;  
	}
	
	public boolean IsEmpty() {
		
		return this.cantidad==0;
	}
	
	public int size() {
		return this.cantidad;
	}
	
	public void clear() {
		this.primero=null;
		this.ultimo=null;
		this.cantidad=0;
	}
	
	public boolean add(T dato) {
		
		Nodo<T> n=new Nodo<T>(dato);
		
		if (cantidad==0) {
			this.primero=n;
		} else {
			this.ultimo.setSig(n);
		}
		n.setAnt(this.ultimo);
		
		this.ultimo=n;
		this.cantidad++;
		return true;
	}
	
	public boolean addLast(T dato) {
		
		return this.add(dato);
	}
	
	public boolean addFirst (T dato) {
		Nodo<T> n=new Nodo<T>(dato);
//		esta vacio
		if (this.cantidad==0) {
			this.ultimo=n;
			this.primero=n;
		} 
//		si tiene algun elemento
		else {
			n.setSig(this.primero);
			this.primero.setAnt(n);
		}
		this.primero=n;
		this.cantidad++;
		return true;
	}
	
	public T remove() {
		if (this.cantidad==0) {
			return null;
		} else if (this.cantidad==1) {
			Nodo<T> i=this.primero;
			this.clear(); 
			return i.getDato();
		} else {
			Nodo<T> i=this.primero;
			this.primero=this.primero.getSig();
			this.primero.setAnt(null);
			this.cantidad--;
			
			return i.getDato();
		}
	}
	public T removeFirst() {
		return remove();
	}
	public T removeLast() {
		if (this.cantidad==0) {
			return null;
		} else if (this.cantidad==1) {
			return remove();
		} else {
			Nodo<T> i=this.ultimo;
			this.ultimo=this.ultimo.getAnt();
			this.ultimo.setSig(null);
			this.cantidad--;
			
			return i.getDato();
		}
	}
	
	public T getFirst() {
		if (this.IsEmpty()) {
			throw new NoSuchElementException("La lista està vacia");
		} else {
			return this.primero.getDato();
		}
	}
	
	public T getLast() {
		if (this.IsEmpty()) {
			throw new NoSuchElementException("La lista està vacia");
		} else {
			return this.ultimo.getDato();
		}
	}
	
	public T get(int pos) {
		if (size()<=pos || pos<0) {
			throw new IndexOutOfBoundsException("O te pasa o no llegas");
		} else {
			if (pos==0) return this.getFirst();
			if (pos==size()-1) return this.getLast();
			
			Nodo<T> n = this.primero;
			if (pos<size()/2) {
				for (int i=0 ; i<pos ; i++) { n = n.getSig();}
				return n.getDato();
			} else {
				for (int i=this.cantidad ; i>pos ; i--) { n = n.getAnt();}
				return n.getDato();
			}
		}
	}
	
	public T remove (int pos) {
		
		if (size()<=pos || pos<0) {
			throw new IndexOutOfBoundsException("O te pasa o no llegas");
		}
		if (pos==0) {return remove();}
		if (pos==size()-1) {return removeLast();}
		
		Nodo<T> n = this.primero;
		//contar desde 0
		if (pos<size()/2) {
			//voy hasta la pos
			for (int i=0 ; i<pos ; i++) { n = n.getSig();}
			//lo elimino
			n.getAnt().setSig(n.getSig());
			n.getSig().setAnt(n.getAnt());
			cantidad--;
			return n.getDato();
		} else {// contar desde cantidad
//			voy hasta la pos
			for (int i=this.cantidad ; i>pos ; i--) { n = n.getSig();}
//			lo elimino
			n.getAnt().setSig(n.getSig());
			n.getSig().setAnt(n.getAnt());
			cantidad--;
			return n.getDato();
		}
		
	}

	public boolean add(int pos, T dato) {
		if (size()<=pos || pos<0) {
			throw new IndexOutOfBoundsException("O te pasa o no llegas");
		}
		if (pos==0) {this.addFirst(dato);}
		if (pos==size()-1) {this.addLast(dato);}
		
		Nodo<T> newn=new Nodo<T>(dato);
		Nodo<T> n=this.primero;
		
		for (int i=0 ; i<pos ; i++) { n = n.getSig();}
		n.getAnt().setSig(newn);
		n.setAnt(newn);
		newn.setAnt(n.getAnt());
		newn.setSig(n);
		cantidad++;
		return true;
		
	}
	
	public int indexOf (T dato) {
		Nodo<T> n=this.primero;
		
		for (int x=0; x<this.cantidad ;x++) {
			if (n.getDato()==dato) return x;
			
			n = n.getSig();
			
		}
		return -1;
	}
	public boolean contains(T dato) {
		
		if (this.indexOf(dato)==-1) { return false;}
		return true;
	}
}