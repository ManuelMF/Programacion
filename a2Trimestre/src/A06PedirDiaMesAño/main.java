package A06PedirDiaMesAño;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
//		formato
		SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatoaño = new SimpleDateFormat("yyyy");
		SimpleDateFormat formatomes = new SimpleDateFormat("MM");
		SimpleDateFormat formatodia = new SimpleDateFormat("dd");
		
//		fecha
		Date miFecha = null;
		Date Fecha18 = new Date();
		boolean error=true;
		
		int dia=0,mes=0,año=0;
		int diamin=1,diamax=31,mesmin=1,mesmax=12, añomin=Integer.parseInt(formatoaño.format(Fecha18)),añomax=1900;
		
		do {
			
			System.out.println("Introduce tu decha de nacimiento");
				System.out.println("Día en que naciste");
				dia=Integer.parseInt(sc.nextLine());
				
				System.out.println("Mes en que naciste");
				mes=Integer.parseInt(sc.nextLine());
				
				System.out.println("Año en que naciste");
				año=Integer.parseInt(sc.nextLine());
				
				if (dia<diamin||diamax<dia||mesmin>mes||mesmax<mes||añomin<año||añomax>año) {
					error = false;
					System.out.println("Edad erronea");
				}
				
			
		} while (!error);	

		
//		metemos fecha especifica
		try {
			miFecha=formato1.parse(dia+"/"+mes+"/"+año);
		} catch (ParseException e) {
			System.out.println("Formato incorrecto");
		}
				
//		modificar variables para poner la fecha de mayor de edad
		int a = Integer.parseInt(formatoaño.format(Fecha18));
		int b = Integer.parseInt(formatomes.format(Fecha18));
	
		a = a - 18;
		String m1 = a+"";
		String m2 = b+"";
		
//		metemos fecha
		try {
			Fecha18=formato1.parse(formatodia.format(Fecha18)+"/"+m2+"/"+m1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(formato1.format(miFecha));
		System.out.println(formato1.format(Fecha18));

		if (miFecha.compareTo(Fecha18)==-1 || miFecha.compareTo(Fecha18)==0) System.out.println("Eres mayor de edad"); 
		if (miFecha.compareTo(Fecha18)==1) System.out.println("Eres menor de edad");
		
	}
}
