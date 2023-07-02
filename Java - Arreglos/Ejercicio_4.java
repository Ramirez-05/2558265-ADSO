import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del arreglo: ");
        int tamaño = scanner.nextInt();

        int[] arreglo = new int[tamaño];

        for (int i = 0; i < tamaño; i++) {
            System.out.print("Ingrese el elemento en la posición " + (i + 1) + ": ");
            arreglo[i] = scanner.nextInt();
        }

        System.out.println("Arreglo original: " + Arrays.toString(arreglo));

        Arrays.sort(arreglo);
        int[] arregloDescendente = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arregloDescendente[i] = arreglo[tamaño - 1 - i];
        }

        System.out.println("Arreglo descendente: " + Arrays.toString(arregloDescendente));
    }
}
