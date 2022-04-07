package Temaa1;

import java.util.Scanner;

public class E3MostrarNotasEnLetras {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Introduce tu nota: ");
        double num1=Double.parseDouble(sc.nextLine());
        
       /* if (num1<=10);{
        
        if (num1<5);{
        	System.out.println("Tu nota es: insuficiente ");
        
        } if (num1==5);{
        	System.out.println("Tu nota es: suficiente ");
        }
        } if (num1==6);{
        	System.out.println("Tu nota es: bien ");
        } if (num1==7);{
        	System.out.println("Tu nota es: notable ");
        }
	  if (num1>7);{
     	System.out.println("Tu nota es: excelente ");
     }
        
        }

	}*/
        if (num1<0 || num1>10) {
        	System.out.println("Nota Incorrecta");
        }
        if (num1>=0 && num1<5) {
        	System.out.println("Insuficiente");
        }
        if (num1>=5 && num1<6) {
        	System.out.println("Suficiente");
        }
        if (num1>=6 && num1<8) {
        	System.out.println("Notable");
        }
        if (num1>=8 && num1<10) {
        	System.out.println("Excelente");
        }
        }
	}
