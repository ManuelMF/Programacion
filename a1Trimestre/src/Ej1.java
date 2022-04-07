import java.util.Scanner;

public class Ej1 {
static Scanner sc=new Scanner(System.in);

public static void main(String[] args) {
    
    final double porIva;
    final String moneda;
    
    //pedimos el nombre y el precio de 4 Productos
    System.out.println("Nombre del primer Producto?");
    String n1=sc.nextLine();
    
    System.out.println("Precio del primer Producto?");
    double p1=Double.parseDouble(sc.nextLine());
    
    System.out.println("Nombre del segundo Producto?");
    String n2=sc.nextLine();
    
    System.out.println("Precio del segundo Producto?");
    double p2=Double.parseDouble(sc.nextLine());
    
    System.out.println("Nombre del tercer Producto?");
    String n3=sc.nextLine();
    
    System.out.println("Precio del tercer Producto?");
    double p3=Double.parseDouble(sc.nextLine());
    
    System.out.println("Nombre del cuarto Producto?");
    String n4=sc.nextLine();
    
    System.out.println("Precio del cuarto Producto?");
    double p4=Double.parseDouble(sc.nextLine());
    
    
    //pido el porcentaje de IVA
    System.out.println("% IVA? ");
    porIva=Double.parseDouble(sc.nextLine());
   
    //pido el símbolo de la moneda
    System.out.println("Moneda? ");
    moneda=sc.nextLine();
   
    //calculamos el divisor dependiendo del iva
    double divisor=(porIva/100)+1;
    
    double total=p1+p2+p3+p4;
   
    double baseImponible=total/divisor;
   
    double iva=total-baseImponible;
   
    System.out.println(n1+": "+p1+moneda);
    System.out.println(n2+": "+p2+moneda);
    System.out.println(n3+": "+p3+moneda);
    System.out.println(n4+": "+p4+moneda);
    System.out.println("-------------------------------");
    System.out.println("Total: "+total+moneda);
    System.out.println("base Imponible: "+ baseImponible+moneda);
    System.out.println("IVA: "+iva+moneda);
   
  
}
}