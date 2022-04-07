package A04Excepciones;

import java.util.Scanner;

public class Main {
	
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		boolean error=true; int v = 0, v2 = 0;
		Edad edad=null;
		
		do {
			try {
				System.out.println("Intruduce los rangos de edad");
				v=Integer.parseInt(sc.nextLine());
				v2=Integer.parseInt(sc.nextLine());
				edad=new Edad (v,v2);
				
				error = false;
			} catch (RangoIncorrectoException e) {
				System.out.println("Rangos invalidos");
			} catch (NumberFormatException e) {
				System.out.println("La edad debe ser un número");
			}
		} while (error);	
		
		error=true;
		do {
			try {
				System.out.println("Introduce edad");
				edad.setEdad(Integer.parseInt(sc.nextLine()));
				
				error=false;
			} catch (NumberFormatException e) {
				System.out.println("Edad incorrecta");
			}  catch (EdadFueraDeRangoExcepcion e) {
				System.out.println("La edad debe estar entre "+edad.getMin()+" y "+edad.getMax());
			}
		} while (error);
	}
}
