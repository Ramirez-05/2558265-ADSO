import java.util.Scanner;

public class Ejercicio_4 {

    public static void main(String[] args){
        int numero,n1,n2,n3,n4,n5,n6,i=1;
        Scanner entrada = new Scanner (System.in);
        System.out.print("Ingrese un numero N de maximo de 6 digitos: ");
        numero = entrada.nextInt();


        n1 = (numero%10);
        n2 = (numero%100)/10;
        n3 = (numero%1000)/100;
        n4 = (numero%10000)/1000;
        n5 = (numero%100000)/10000;
        n6 = (numero%1000000)/100000;

        while(i<=1){

            if(numero>999999){
                System.out.println("Ingresaste un numero mayor a 6 digitos");
            }else{
                if(n1==n2){
                    System.out.println("El numero si es palindromo");
                }else if(n1==n3){
                    System.out.println("El numero si es palindromo");
                }else if(n1==n4 && n2 == n3){
                    System.out.println("El numero si es palindromo");
                }else if(n1==n5 && n2==n4){
                    System.out.println("El numero si es palindromo");
                }else if(n1==n6 && n2 == n5 && n3 == n4){
                    System.out.println("El numero si es palindromo");
                }else{
                    System.out.println("El numero No es palindromo");
                }
            }
            i++;
        }
    }

}
    

