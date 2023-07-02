import java.util.Scanner;

public class Prueba5{
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un numero");
        int num1 = entrada.nextInt();
        System.out.println("Ingrese un numero");
        int num2 = entrada.nextInt();
        System.out.println("Ingrese un numero");
        int num3 = entrada.nextInt();

        if(num1<num2 & num1<num3){
            System.out.println("Los numero se ingresaron de forma ascendente");
        }else if(num2>num1 & num2>num3){
            System.out.println("Los numero se ingresaron de forma no ascendente");
        }else if(num3>num1 & num3>num2){
            System.out.println("Los numero se ingresaron de forma no ascendente");
        }else if(num1>num2 & num1>num3){
            System.out.println("Los numero se ingresaron de forma no ascendente");
        }
    }
}