import java.util.Scanner;

public class Prueba9 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int x = 0, numero, i;
        System.out.print("Ingrese numero: ");
        numero = entrada.nextInt();


        for (i = 1; i <= numero; i++) {
            if ((numero % i) == 0) {
                x++;
                System.out.println("vuelta " + x);
            }
        }

        if (numero == 0 || numero == 1) {
            System.out.println("--> No es primo");
        } else {
            if (x <= 2) {
                System.out.println("--> Es primo");
            } else {

                System.out.println("--> No es primo");
            }
        }
    }
}