import java.util.Scanner;

import java.util.Random;

public class Ejercicio_3 {
    public static void main(String[] arg){
        Random ran= new Random();
        Scanner  entrada = new Scanner(System.in);
        int num, i, aleatorio=0;

        System.out.print("Ingrese el numero entero: ");
        num = entrada.nextInt();

        for(i=1; i<=num; i++){
            aleatorio  = (int) (Math.random()*100+1);

            if(aleatorio==1 ||  aleatorio==0  || aleatorio==4){
                i++;
            }else{

                if(aleatorio%i==0){
                    i++;
                }else{
    
                    System.out.println("primos "+i+" generado: "+aleatorio);
                    
                }
            }
        }

    }
}
