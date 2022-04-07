package Herencia;

import java.util.Date;
import java.util.LinkedList;

import FechaHerencia.Fecha;

public class Main {

	public static void main(String[] args) {

		LinkedList<SerVivo> lista = new LinkedList<SerVivo>();
		
		SerVivo sv=new SerVivo("Mono", new Dimension (200,150,30),10);
		lista.add(sv);
		
		Humano h1 = new Humano(new Dimension(180,50,30),85,'F',"Negro");
		
		
		lista.add(h1);
		
		sv.engordar(5);
		
		System.out.println(sv.dimension.ancho);
		
		h1.tenyirse("Azul");
		
		System.out.println(h1.colorPelo);
		
//		hago un ser vivo que es humano
//		podira usarlo para meterlo en una lista de seres vivos
		SerVivo h2=new Humano(new Dimension(180,50,25),80,'M',"rojo");
		lista.add(h2);
		
//		Mira si h2 es humano y si lo es te da un true
		if (h2 instanceof Humano) {
			System.out.println("es humano");
		}
		
		
//		casting 
//		el ser vivo lo usare como ser humano
//		sino no podría ver usar las variables especificas del humano
		Humano h3 = (Humano) h2;
		h3.tenyirse("rojo");
		lista.add(h3);
		
		for (SerVivo v:lista) {
			System.out.println(v.esperanzaVida);
			
//			si se creo siendo un humano entra
			if (v instanceof Humano) {
				System.out.println(((Humano) v).colorPelo);
			}
		}
		

		
	}

}
