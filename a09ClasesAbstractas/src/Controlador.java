import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class Controlador {
public LinkedList<PoligonoRegular> lista;
	
	
	public Controlador() {
		
		try {
			FileInputStream fis=new FileInputStream("Lista.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			this.lista=(LinkedList<PoligonoRegular>) ois.readObject();
			ois.close();
		} catch (Exception e1) {
			this.lista=new LinkedList<PoligonoRegular>();
	
		}
	}
	
	public void addCuadrado(Cuadrado c) {
		lista.add(c);
		
	}
	
	public void addTriangulo(Triangulo t) {
		lista.add(t);
		
	}
	
	public PoligonoRegular getMayor() {
		if (this.lista.isEmpty()) return null;
		else {
			PoligonoRegular elMayor=this.lista.getFirst();
			
			for (PoligonoRegular p:this.lista) {
				if (p.getArea()>elMayor.getArea()) elMayor=p;
			}
			
			return elMayor; 
			
		}	
	}
	
	public void guardardatos() {
		try {
			FileOutputStream fos=new FileOutputStream("Lista.dat");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(this.lista);
			oos.close();
			
		} catch (Exception e) {

		}
	}
}
