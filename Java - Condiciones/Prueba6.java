import java.util.Scanner;

public class Prueba6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1 = 0 , n2 = 1, k, n, i;

        System.out.print("--> Ingresar la posicion del n-esimo Fibonacci: ");
        n = input.nextInt();


        for (i = 1; i < n; i++) {
            k = n1 +n2;
            n1 = n2;
            n2 = k;
        }
        System.out.print("--> El n-esimo numero Fibonacci es: " + n1);
    }

}
