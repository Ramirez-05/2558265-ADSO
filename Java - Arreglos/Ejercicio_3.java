import java.util.Scanner;

public class Ejercicio_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del arreglo: ");
        int tamaño = scanner.nextInt();

        int[] arreglo = new int[tamaño];

        // Solicitar al usuario los elementos del arreglo
        for (int i = 0; i < tamaño; i++) {
            System.out.print("Ingrese el elemento en la posición " + (i + 1) + ": ");
            arreglo[i] = scanner.nextInt();
        }

        System.out.print("Ingrese la posición desde donde se imprimirá el arreglo en sentido antihorario: ");
        int posicion = scanner.nextInt();

        // Imprimir el arreglo original
        System.out.print("Arreglo: [");
        for (int i = 0; i < tamaño; i++) {
            System.out.print(arreglo[i]);
            if (i < tamaño - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        System.out.print("Anti horario: ");
        for (int i = posicion; i >= 0; i--) {
            System.out.print(arreglo[i]);
            if (i > 0) {
                System.out.print(" - ");
            }
        }
        for (int i = tamaño - 1; i > posicion; i--) {
            System.out.print(" - " + arreglo[i]);
        }
        System.out.println();
    }
}

