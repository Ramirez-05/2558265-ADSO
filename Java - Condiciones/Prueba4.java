import java.util.Scanner;

public class Prueba4{
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un numero");
        int num1 = entrada.nextInt();
         System.out.println("Ingrese un numero");
        int num2 = entrada.nextInt();
         System.out.println("Ingrese un numero");
        int num3 = entrada.nextInt();

        if(num1>num2 & num1>num3){
            System.out.println("Este es el numero mayor "+num1);
        }else if(num2>num1 & num2>num3){
            System.out.println("Este es el numero mayor "+num2);
        }else{
            System.out.println("Este es el numero mayor "+num3);
        }

        if(num1<num2 & num1<num3){
            System.out.println("Este es el numero menor "+num1);
        }else if(num2<num1 & num2<num3){
            System.out.println("Este es el numero menor "+num2);
        }else{
            System.out.println("Este es el numero menor "+num3);
        }
    }
}