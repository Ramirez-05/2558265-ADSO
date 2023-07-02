import java.util.Scanner;
public class Ejercicio_9{
    public static void main(String[] arg){
        Scanner entrada = new Scanner(System.in);

        int numero_ingresado,digitos=0;

        System.out.println("Por favor ingrese un numero");

        numero_ingresado = entrada.nextInt();


        while(numero_ingresado>0){

            digitos = digitos+numero_ingresado%10;

            numero_ingresado = numero_ingresado/10;
        }

        numero_ingresado=digitos;

        digitos = 0;

        if(numero_ingresado>=10){
            while(numero_ingresado>0){

                digitos = digitos+numero_ingresado%10;
    
                numero_ingresado = numero_ingresado/10;
    
        
            }

            numero_ingresado=digitos;

            digitos = 0;
        }

        System.out.println("La raiz digital es: "+numero_ingresado);

        
        



    }
} 
