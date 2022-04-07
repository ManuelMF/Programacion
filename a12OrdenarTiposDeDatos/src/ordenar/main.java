package ordenar;

import java.text.ParseException;
import java.util.Collections;
import java.util.LinkedList;

public class main {

	public static void main(String[] args) {
/*		ordenar int
		LinkedList<Integer> lista = new LinkedList<Integer>();
		
		lista.add(5);
		lista.add(15);
		lista.add(2);
		lista.add(4);
		lista.add(8);
		lista.add(1);
		
//		Ordena la lista
		Collections.sort(lista);
		
		for (int i:lista) System.out.println(i);
*/		
//		ordenar objetos
		LinkedList<Vehiculo> lista = new LinkedList<Vehiculo>();
		
		try {
			lista.add(new Vehiculo ("Ford Fiesta",160,97,new Fecha("10/12/1996")));
			lista.add(new Vehiculo ("206",250,120,new Fecha("10/12/2017")));
			lista.add(new Vehiculo ("Clio",220,170,new Fecha("10/12/2015")));
			lista.add(new Vehiculo ("Supra",350,1200,new Fecha("10/12/2012")));
			lista.add(new Vehiculo ("Panda",120,35,new Fecha("10/12/1976")));
			lista.add(new Vehiculo ("Mustang",219,400,new Fecha("10/12/2021")));
		} catch (ParseException e) {
		}
		
//		sors te pide un objeto con una interfaz para que lo pueda ordenar
//		Collections.sort(lista, Collections.reverseOrder());
//								ordena al reves
		
//		asi al ser un objeto tenemos que implementarle el comparable de vehiculos donde definimos como va a compara lo que siempre sera igual por eso creamos otros comparadores
		Collections.sort(lista);
//		            sort siempre usara el metodo compareto
//		son interfaces distintas comparable -> compareTo y comparator -> compare
		Collections.sort(lista,new comparadorFecha());
		for (Vehiculo i:lista) System.out.println(i.modelo);
	}

}
// en banco tambiaen hay hicimos un ej de comparableordenar metodos  esta en main linea 291