import java.util.Scanner;
public class Ejercicio_5 {
    public static void main(String[] args){
        int numero,i,resultado=1;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese un numero: ");
        numero = entrada.nextInt();
        System.out.println("Factorial: ");
        for( i=1; i<=numero;i++){
            System.out.print(" "+i+" x");
            resultado=resultado*i;
        }
        System.out.print(" = "+resultado);
    }
}
