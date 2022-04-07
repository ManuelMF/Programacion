package A04Excepciones;

public class RellenarUnArrayConTRYyERRORES {

	public static void main(String[] args) {

		int[] nums = new int[10];
		boolean error = false;
		int x=0;
		do {
 
			try {
				nums[x]=5;
				x++;
				
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Listo");
				error = true;
			}
		} while (!error);
	}

}
