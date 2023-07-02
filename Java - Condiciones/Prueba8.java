import java.util.Scanner;

public class Prueba8 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        long n1, n2, n3, n4, n5, n6, N; 

        System.out.print("--> Ingresar un numero: ");
        N = entrada.nextLong();

        n1 = (N%10);
        n2 = (N%100)/10;
        n3 = (N%1000)/100;
        n4 = (N%10000)/1000;
        n5 = (N%100000)/10000;
        n6 = (N%1000000)/100000;

        if (N <=999999 ){
            System.out.println("-> El digito 01 es: " + n6);
            System.out.println("-> El digito 02 es: " + n5);
            System.out.println("-> El digito 03 es: " + n4);
            System.out.println("-> El digito 04 es: " + n3);
            System.out.println("-> El digito 05 es: " + n2);
            System.out.println("-> El digito 06 es: " + n1);    
        }else{
            System.out.println("El numero debe ser inferior a 6 digitos");
        }
    }
}