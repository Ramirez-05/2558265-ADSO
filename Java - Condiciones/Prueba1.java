import java.util.Scanner;

public class Prueba1{
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Bienvenido señor/a usuario");
        System.out.println("Señor/a ingrese su edad");
        int edad = entrada.nextInt();

        if(edad>=18 & edad<150){
            System.out.println("Usted debe de pagar un impuesto de: $200.000");
        }else if(edad>0 & edad<18){
            System.out.println("Usted recibira un auxilio de: $800.000");
        }else if(edad<=0){
            System.out.println("Datos Invalidos");
        }else if(edad>150){
            System.out.println("Datos invalidos");
        }
    }
}