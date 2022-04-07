package a14ListaBD;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		boolean correcto=false;
		String opcion,n;
		LinkedList<Producto> l;
		int cantidad=0;
		
		do {
			System.out.println("LISTA DE LA COMPRA:");
			System.out.println("---------------------------------------------");
			LinkedList<Producto> lista=Producto.find(null, null);
			for (Producto p:lista) {
				System.out.println(p.getId()+") "+p.getProducto()+" - "+p.getCantidad());
			}
			System.out.println("---------------------------------------------");
			System.out.println("1) Añadir Producto a la lista");
			System.out.println("2) Eliminar Producto de la lista");
			System.out.println("3) Modificar la Cantidad de un producto");
			System.out.println("S) Salir");
			System.out.println("-------------------------------------------");
			opcion = sc.nextLine();
			switch (opcion) {
			case "1":
				System.out.println("Nombre del Producto:");
				String nombre = sc.nextLine();
				do {
					try {
						System.out.println("Cantidad:");
						cantidad = Integer.parseInt(sc.nextLine());
						correcto = true;
					} catch (Exception e) {
						System.out.println("Cantidad incorrecta!!!");
					}
				} while (!correcto);

				Producto p1 = Producto.create(nombre, cantidad);

				if (p1 != null) {
					System.out.println("Producto añadido!!!");
				}

				break;
			case "2":
				System.out.println("Nombre del producto a eliminar");
				n=sc.nextLine();
				
				l=Producto.find(n, null);
				if (l.isEmpty()) {
					System.out.println("No se encuentra ese producto!!!");
				} else {
					Producto p=l.getFirst();
					p.delete();
					
				}

				break;
				
			case "3":
				System.out.println("Nombre del producto a modificar");
				n=sc.nextLine();
				
				l=Producto.find(n, null);
				if (l.isEmpty()) {
					System.out.println("No se encuentra ese producto!!!");
				} else {
					Producto p=l.getFirst();
					correcto=false;
					do {
						try {
							System.out.println("Nueva Cantidad:");
							cantidad = Integer.parseInt(sc.nextLine());
							correcto = true;
						} catch (Exception e) {
							System.out.println("Cantidad incorrecta!!!");
						}
					} while (!correcto);
					
					p.setCantidad(cantidad);
					
					p.update();
					
					
				}

				break;

			}
		} while (!opcion.equalsIgnoreCase("S"));
		
		
		

	}

}