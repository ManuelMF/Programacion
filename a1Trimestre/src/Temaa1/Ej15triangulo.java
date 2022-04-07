package Temaa1;

import java.util.Scanner;

public class Ej15triangulo {
	static Scanner sc=new Scanner(System.in);   

	public static void main(String[] args) {
		System.out.println("Numero de asteriscos");
		int lado=Integer.parseInt(sc.nextLine());	
		
	     for (int y=0; y<lado; y++) {
	            for (int x=0; x<y+lado; x++) {
	            	 if (x<lado-y-1) {
		                    System.out.print("  ");
		                } else {
		                    System.out.print("* ");
		                }	            }
	            System.out.println();
	        }

	    }
		
		
	}

