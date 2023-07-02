import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número: ");
        int numero = scanner.nextInt();

        int[] arreglo = new int[numero];

        int contador = 0;
        int candidato = 2;

        while (contador < numero) {
            if (esPrimo(candidato)) {
                arreglo[contador] = candidato;
                contador++;
            }
            candidato++;
        }

        System.out.println("El arreglo de números primos es:");
        for (int i = 0; i < numero; i++) {
            System.out.print(arreglo[i] + " ");
        }
    }

    public static boolean esPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}

