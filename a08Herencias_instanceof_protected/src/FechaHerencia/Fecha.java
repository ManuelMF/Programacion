package FechaHerencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
// fecha hereda date y coje todos sun metodos
public class Fecha extends Date {
	
	private static SimpleDateFormat dma=new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat dmahm=new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private static SimpleDateFormat dmahms=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public Fecha() {
		super();
	}
	
//	creamos otro contructor donde podamos crear una fecha con un string
	public Fecha(String f) throws ParseException {
		super();
//		hacemos que coga muchos formatos
		
//		con lenght poco practico ya que si ponen 5:03 ya va mal
//		if (f.length()==10) {
//			this.setDMA(f);
//		} else if (f.length()==16) {
//			this.setDMAHM(f);
//		} else if (f.length()==19) {
//			this.setDMAHMS(f);
//		} else System.out.println("Fecha incorrecta");
		
//		con contains y index of
		if (f.indexOf(":")==-1) this.setDMA(f);
		else {
			if (f.indexOf(":")==f.lastIndexOf(":")) this.setDMAHM(f); 
			
			else this.setDMAHMS(f);
			
		}	
	}
	
	public String getDMA () {
//		             podría llamar a dma sin el Fecha. 
		return Fecha.dma.format(this);
	}
	
	public String getDMAHM () {
		return Fecha.dmahm.format(this);
	}
	public String getDMAHMS () {
		return Fecha.dmahms.format(this);
	}
//										 throws devolverta esta excepcion y hay que cogerla en el main
	public void setDMA (String n) throws ParseException {
		
//		hacemos un parse para meter la fecha que irá junto a dma que tiene el formato y lo guardamos en una variable date
		Date d = Fecha.dma.parse(n);
		
//		this hace ref al objeto que llama
//			 set time es una funcion que pone el tiempo directamenta ya que nosotros no podemos poner this = ... por eso buscamos  this. funciones
//		            hay que pasarla en formato long por eso el get time que devuelve un long
		this.setTime(d.getTime());

	}
	
	public void setDMAHM (String n) throws ParseException {
		this.setTime(Fecha.dmahm.parse(n).getTime());
	}
	
	public void setDMAHMS (String n) throws ParseException {
		this.setTime(Fecha.dmahms.parse(n).getTime());
	}
}
