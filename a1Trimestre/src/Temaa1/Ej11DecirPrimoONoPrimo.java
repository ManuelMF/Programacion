package Temaa1;

import java.util.Scanner;

public class Ej11DecirPrimoONoPrimo {
	
static Scanner sc=new Scanner(System.in);   
    
    public static void main(String[] args) {
       
        System.out.println("Introduce un número");
        int num=Integer.parseInt(sc.nextLine());
       
        boolean encontrado=false;
       
        for (int x=2; x<num; x++) {
           
            if (num%x==0) {
                encontrado=true;
            }
           
        }
       
        if (!encontrado) {
            System.out.println("Es primo");
        } else {
            System.out.println("No es primo");
        }
       
       

    }}