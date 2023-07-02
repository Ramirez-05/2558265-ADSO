import java.util.Scanner;

public class Prueba2{
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un numero de tres digitos");
        int num1 = entrada.nextInt();

        if(num1 % 2==0){
            System.out.println("********************");
            System.out.println("Su numero es par");
            System.out.println("*********************");
        }else{
            System.out.println("*******************");
            System.out.println("Su numero es par");
            System.out.println("********************");
        }
    }

}