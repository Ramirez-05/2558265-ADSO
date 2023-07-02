import java.util.Scanner;

public class Ejercicio_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del arreglo: ");
        int tamaño = scanner.nextInt();

        int[] arreglo = new int[tamaño];

        for (int i = 0; i < tamaño; i++) {
            System.out.print("Ingrese el elemento en la posición " + (i + 1) + ": ");
            arreglo[i] = scanner.nextInt();
        }

        System.out.print("Arreglo original: { ");
        for (int i = 0; i < tamaño; i++) {
            System.out.print(arreglo[i]);
            if (i < tamaño - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");

        System.out.print("Ingrese el número de movimientos: ");
        int numMovimientos = scanner.nextInt();

        for (int i = 1; i <= numMovimientos; i++) {
            int temp = arreglo[0];
            for (int j = 1; j < tamaño; j++) {
                arreglo[j - 1] = arreglo[j];
            }
            arreglo[tamaño - 1] = temp;

            System.out.print("Movimiento " + String.format("%02d", i) + ": { ");
            for (int j = 0; j < tamaño; j++) {
                System.out.print(arreglo[j]);
                if (j < tamaño - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" }");
        }
    }
}
