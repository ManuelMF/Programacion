import java.util.Scanner;

public class iva {

static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		final double porIva;
		final String moneda;
		
		// pido el total
		System.out.println("Introduce un importe");
		String teclado=sc.nextLine();
		double total=Double.parseDouble(teclado);
		
		// pido el porcentaje del IVA
		System.out.println("IVA?");
		teclado=sc.nextLine();
		porIva=Double.parseDouble(teclado);
		
		// pido el simbolo de la moneda
		System.out.println("moneda");
		moneda=sc.nextLine();
		
		//calculamos el divisor dependiendo el IVA
				double divisor=(porIva/100)+1;
				
				double baseImponible=total/divisor;
				
				double iva=total-baseImponible;
				
				
		
       
        System.out.println("Total: "+total+moneda);
        System.out.println("base Imponible: "+ baseImponible+moneda);
        System.out.println("IVA: "+iva+moneda);
       
       

	}

}