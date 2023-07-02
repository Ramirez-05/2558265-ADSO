import java.util.Scanner;

public class Ejercicio_1 {

    public static void main(String[] args){

        int aleatorio = 0;
        int numero ;
        int producto;
        String numero_aleatorios = "";

        Scanner entrada = new Scanner (System.in);

        System.out.println("Ingrese un numero del 1 al 6");

        numero = entrada.nextInt();

        if(numero >= 1 && numero <=6){

            for(int i=1; i<=numero; i++){

            aleatorio  = (int) (Math.random()*9+1);

            numero_aleatorios += aleatorio;

        }
        int numero_entero = Integer.parseInt(numero_aleatorios);

        numero_entero=2;

        System.out.println(numero_aleatorios);
        System.out.println(numero_entero);


        }else{
            System.out.print("Datos Invalidos");
        }

    }
}
