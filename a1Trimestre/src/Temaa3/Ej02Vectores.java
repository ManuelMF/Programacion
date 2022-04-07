package Temaa3;

import java.util.Scanner;

public class Ej02Vectores {
	static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
               
       
        String[] asignaturas=new String[5];
        int[] notas=new int[5];
        String entrada;
        boolean encontrado;
       
        for (int x=0; x<5; x++) {
           
            do {
                System.out.println("Nombre de la asignatura?");
                entrada=sc.nextLine();
           
                encontrado=false;
                for (int y=0; y<x; y++) {
                    if (asignaturas[y].equalsIgnoreCase(entrada)) {
                        System.out.println("Asignatura repetida");
                        encontrado=true;
                    }
                   
                }
               
            } while (encontrado);
           
            asignaturas[x]=entrada;
           
            System.out.println("Nota de "+asignaturas[x]);
            notas[x]=Integer.parseInt(sc.nextLine());
        }
       
        System.out.println("---------------------------------");
       
        for (int x=0; x<5; x++) {
            if (notas[x]>=5) {
                System.out.println(asignaturas[x]+" - "+notas[x]);
            }
        }
       
    }
       
       
       
       

    }