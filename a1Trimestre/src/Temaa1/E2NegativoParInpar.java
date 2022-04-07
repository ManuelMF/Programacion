package Temaa1;

import java.util.Scanner;

public class E2NegativoParInpar {
	static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
       
        System.out.println("introduce un número:");
        double num=Double.parseDouble(sc.nextLine());
       
       
        if (num>=0) {
            System.out.println("Es positivo!!!");
        } else {
            System.out.println("Es negativo!!!");
        }
       
       
        if ((num%2)==0) {
            System.out.println("Es par");
        } else {
            System.out.println("Es impar!!!");
        }
       

    }}