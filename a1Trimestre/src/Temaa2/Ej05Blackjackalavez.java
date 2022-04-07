package Temaa2;

import java.util.Scanner;

public class Ej05Blackjackalavez {
	static Scanner sc=new Scanner (System.in);
	public static void main(String[] args) throws InterruptedException {
		
		//variables
		int max=13,total=0,naltcrupier,totalc=0,totalapuesta,apuesta=0,monedero=0;;
		String repetircarta="si";
		
		//JUEGO
		System.out.println("********************************************");
		System.out.println("*            Blackjack Mallorca            *");
		System.out.println("********************************************");
		System.out.println("Introduce el dinero");
		int monederoinicial=Integer.parseInt(sc.nextLine());
	
		monedero = monederoinicial;
		do {
			
			total = 0;totalc = 0;repetircarta="si";totalapuesta=0;
			
			//TU TURNO
			do {             
				if (repetircarta.equals("si")) {
					Thread.sleep(1500);
					System.out.println("------------------Tu turno------------------");
					
					//APUESTAS
					
					do {
						System.out.println("Quieres apostar");
						String snapuesta = sc.nextLine();
						apuesta = 0;
						if (snapuesta.equals("si")) {
							System.out.println("Cantidad");
							apuesta = Integer.parseInt(sc.nextLine());
						}
						if (apuesta > monedero) {
							System.out.println("No tienes tanto dinero, ¿quieres meter mas? (si/no)");
							if (sc.nextLine().equals("si")) {
								System.out.println("Cantidad");
								int cantidadpelado = Integer.parseInt(sc.nextLine());
								monedero = monedero + cantidadpelado;
							}
						} 
					} while (apuesta > monedero);
					
					int nalt = (int) (Math.random() * max + 1);
	
					//J Q K
					if (nalt == 11) {
						String letra = "J";
						System.out.print("Tu carta es " + letra);
					}
					if (nalt == 12) {
						String letra = "Q";
						System.out.print("Tu carta es " + letra);
					}
					if (nalt == 13) {
						String letra = "K";
						System.out.print("Tu carta es " + letra);
					}
					if (nalt == 1) {
						String letra = "A";
						System.out.print("Tu carta es " + letra);
					}
					//UNO AL 10
					if (nalt > 1 && nalt <= 10) {
						System.out.print("Tu carta es " + nalt);
					}
					//NUMEROS SUP A 10 QUE SEAN 10
					if (nalt == 11 || nalt == 12 || nalt == 13) {
						nalt = 10;
					}
					if (nalt == 1) {
						if (total < 10) {
							nalt = 11;
						}
					}
					//TOTAL APUESTA
					totalapuesta = totalapuesta + apuesta;
					monedero=monedero-apuesta;
					//TOTAL
					total = total + nalt;
					System.out.println(" y tienes un total de " + total + " puntos.");
				
					
					if (total > 21) {
						System.out.println("Perdiste te pasaste de 21");
					} else {
						System.out.println("Quieres otra carta");
						repetircarta=sc.nextLine();	
					}
				
				}
				if (totalc < total && total<22) {
					//TURNO DEL CRUPIER
					System.out.println("---------------Turno del crupier---------------");
					Thread.sleep(1000);
					naltcrupier = (int) (Math.random() * max + 1);
					//J Q K
					if (naltcrupier == 11) {
						String letra = "J";
						System.out.print("La carta del crupier es " + letra);
					}
					if (naltcrupier == 12) {
						String letra = "Q";
						System.out.print("La carta del crupier es " + letra);
					}
					if (naltcrupier == 13) {
						String letra = "K";
						System.out.print("La carta del crupier es " + letra);
					}
					if (naltcrupier == 1) {
						String letra = "A";
						System.out.print("La carta del crupier es " + letra);
					}
					// NUMEROS SUP A 10 QUE SEAN 10
					if (naltcrupier > 1 && naltcrupier <= 10) {
						System.out.print("La carta del crupier es " + naltcrupier);
					}
					if (naltcrupier == 11 || naltcrupier == 12 || naltcrupier == 13) {
						naltcrupier = 10;
					}
					if (naltcrupier == 1) {
						if (totalc < 10) {
							naltcrupier = 11;
						}
					}
					//TOTAL
					totalc = totalc + naltcrupier;
					System.out.println(" y tiene un total de " + totalc + " puntos.");
				
					if (totalc > 21) {
						System.out.println("ganaste el grupier se paso de 21\n mierda me pase!!");
					} if (totalc < 21) {
						System.out.println("¿El crupier quiere otra carta?");
					}
					if (totalc < total || totalc < 15) {
						System.out.println("si");
					} else if (totalc >= total && totalc <= 21 && repetircarta.equals("no")) {
						System.out.println("me planto");
					}
				}
				
			} while ((repetircarta.equals("si") && total < 21 && totalc < 22) || ((totalc < total) && total < 21));
			
			//resultado
			if ((totalc >= total && totalc <= 21) || total > 21) {
				System.out.println("Perdiste el crupier tiene " + totalc + " y tu tienes " + total);
				System.out.println("Perdiste una apuesta de "+totalapuesta+"\n Tu monedero actual es de "+monedero);
				
			} else if (total > totalc || totalc > 21){
				monedero=monedero+(totalapuesta*2);
				System.out.println("tienes una ganancia de "+totalapuesta+" \n Tu monedero actual es de "+monedero);
			}
			//meter dinero
			if (monedero==0) {
				System.out.println("Quieres meter mas dinero");
				if (sc.nextLine().equals("si")) {
					System.out.println("Cantidad");
					int sumamonedero=Integer.parseInt(sc.nextLine());
					monedero=sumamonedero;
				}
			}
			
			System.out.println("¿Quieres volver a jugar? s/n");		
			System.out.println("------------------------------------------------------------------");

		} while (sc.nextLine().equals("s"));
		System.out.println("Tu monedero actual es de "+monedero);
		if (monederoinicial<monedero) {
			System.out.println("Tienes una ganancia de: "+(monedero-monederoinicial));
		}	
			else if (monederoinicial>monedero) {
				System.out.println("Tienes una perdida de: "+(monedero-monederoinicial));
			}
			else {
				System.out.println("no tienes ganacias");
			}
		
	}

}