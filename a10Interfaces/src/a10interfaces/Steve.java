package a10interfaces;

import java.util.LinkedList;

public class Steve implements Golpeable,Golpeador, Movible, Agarrador  {

	public String nombre;
	
	public Posicion pos;
	
	public int vida;

	public int comida;
	
	public int potencia;
	
	public LinkedList<Agarrable>inventario;
	
	public Steve (String n, Posicion pos) {
		this.nombre=n;
		this.pos=pos;
		this.vida=20;
		this.comida=20;
		this.potencia=1;
		this.pos=pos;
		this.inventario=new LinkedList<Agarrable>();
	}
	
	public void golpear(Golpeable g) {
		
		g.encajar(this);
	}
	

	
	public void encajar (Golpeador g) {
//		al reves porque te lo hacen a ti
		this.vida-=g.getPotencia();
	}

	@Override
	public int getPotencia() {
		return this.potencia;
	}

	@Override
	public void move(Posicion p) {
		this.pos=p;
		
	}

	@Override
	public void agarrar(Agarrable a) {
		this.inventario.add(a);
	}
}
