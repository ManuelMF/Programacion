package A05Fechas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {

	public static void main(String[] args) {

//		meter dormato fecha
		SimpleDateFormat formato1 = new SimpleDateFormat ("dd/MM/yyyy HH:mm");
		SimpleDateFormat formato2 = new SimpleDateFormat ("dd/MM/yyyy");
		
//		meter fecha
		Date miFecha=new Date();
		
//		para poner el fomato = format
		System.out.println(formato1.format(miFecha));
		
//		para poner una fecha especifica parse
//		si osi tiene que ir un try catch
		Date miFecha2=null;
		try {
			miFecha2=formato2.parse("25/12/2021");
		} catch (ParseException e) {
			System.out.println("Formato incorrecto");
		}
		System.out.println(formato2.format(miFecha2));
	}

}
