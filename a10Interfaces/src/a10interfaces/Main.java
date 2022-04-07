package a10interfaces;

public class Main {

	public static void main(String[] args) {

		Steve s1=new Steve("Manolo", new Posicion(10,12,22));
		Steve s2=new Steve("PericoPimPim", new Posicion(12,14,20));
		Steve s3=new Steve("Benito", new Posicion(15,12,23));
		Espada e=new Espada();
		
		
		s1.agarrar(e);
//		falta equiparlo para que use la espada
		s1.golpear(s2);
		System.out.println(s2.vida);
	}

}
