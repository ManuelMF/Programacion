package Temaa1;

import java.util.Scanner;

public class Ej12NumeroPrimodel1al100 {
static Scanner sc=new Scanner(System.in);   
    
    public static void main(String[] args) {
       
        System.out.println("Numeros Primos");
     
       for (int y=2; y<=100 ;y++ ) {
        
    	    boolean encontrado=false;
       
	        for (int x=2; x<y; x++) {
	           
	            if (y%x==0) {
	                encontrado=true;
	            }
           
	        }
       
	        if (!encontrado) {
	        	
	        	System.out.println(y);
	        } 
       
       }

    }
}
	
		