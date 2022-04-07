import java.util.Scanner;

public class practica1Recojernombreyedad {

	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Introduce tu nombre: ");
		
		String nombre= new String();
		//Lo que viene por teclado lo guardo en la variable nombre
		
		nombre=sc.nextLine();
		System.out.println("Hola "+nombre+", buenos días!!");
		
		//recojer edad
		System.out.println("introduce tu edad ");
		String edad=new String();
		edad=sc.nextLine();
		
		//transformo la variable edad de tipo String a int y lo guardo en la variable edad 2
		int edad2;
		edad2=Integer.parseInt(edad);
		System.out.println("Hola "+nombre+",buenos días!! tiene usted"+edad2+" años.");
		
		

	}

}
