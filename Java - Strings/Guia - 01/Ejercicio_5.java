import java.util.Scanner;
public class Ejercicio_5{
    public static void main (String[]args){
        Scanner cadenas = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);
        int acum=0;
        System.out.println("********************************");
        System.out.println("Bienvenido al juego del ahorcado");
        System.out.println("******************************** \n");

        System.out.println("Ingrese su nombre");
        String nombre = cadenas.nextLine();

        System.out.println("Bienvenido "+nombre+" que desea hacer?");
        System.out.println("1.Iniciar Juego");
        System.out.println("2.Salir");
        int ele = entrada.nextInt();

        if(ele == 1){
            String palabra_secreta = "analisis";
            char [] letra_adivinada = new char[palabra_secreta.length()];
            for (int i = 0; i < letra_adivinada.length; i++) {
                letra_adivinada[i] = '-';
            }
            int intentos=8;
            while(intentos>0){
                
                System.out.println("***********************");
                System.out.println("Palabra secreta : \n");
                for (int i = 0; i < letra_adivinada.length; i++) {
                    System.out.print(letra_adivinada[i]+" ");
                }
                System.out.println("");
                System.out.println("Tiene un total de "+intentos+" de intentos \n");

                System.out.println("Ingrese un letra");
                char letra_ingresada = cadenas.nextLine().charAt(0);

                boolean adivino = false;

                for (int i = 0; i < palabra_secreta.length(); i++) {
                    if (palabra_secreta.charAt(i) == letra_ingresada) {
                        letra_adivinada[i] = letra_ingresada;
                        adivino = true;
                    }
                }

                if(adivino == true){
                    System.out.println("Le atino");
                    acum+=1;
                }else{
                    System.out.println("sos un pato");
                    intentos--;
                }

                

            }


        }else if(ele == 2){
            System.out.println("no volvas pato");
        }else{
            System.out.println("Ingrese un dato no valido");
        }
        



        


    }
}