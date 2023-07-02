import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del arreglo: ");
        int tamaño = scanner.nextInt();

        int[] arreglo = new int[tamaño];

        for (int i = 0; i < tamaño; i++) {
            System.out.print("Ingrese el elemento en la posición " + (i + 1) + ": ");
            arreglo[i] = scanner.nextInt();
        }

        System.out.print("Arreglo Original: { ");
        for (int i = 0; i < tamaño; i++) {
            System.out.print(arreglo[i]);
            if (i < tamaño - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");

        List<Integer> listaPrimos = new ArrayList<>();
        List<Integer> listaNoPrimos = new ArrayList<>();

        for (int i = 0; i < tamaño; i++) {
            if (esPrimo(arreglo[i])) {
                listaPrimos.add(arreglo[i]);
            } else {
                listaNoPrimos.add(arreglo[i]);
            }
        }

        int[] arregloPrimos = listToArray(listaPrimos);
        int[] arregloNoPrimos = listToArray(listaNoPrimos);

        System.out.print("Arreglo Primos: { ");
        for (int i = 0; i < arregloPrimos.length; i++) {
            System.out.print(arregloPrimos[i]);
            if (i < arregloPrimos.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");

        System.out.print("Arreglo No Primos: { ");
        for (int i = 0; i < arregloNoPrimos.length; i++) {
            System.out.print(arregloNoPrimos[i]);
            if (i < arregloNoPrimos.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");

        System.out.println("Longitud Arreglo Original: " + arreglo.length);
        System.out.println("Longitud Arreglo Primos: " + arregloPrimos.length);
        System.out.println("Longitud Arreglo No Primos: " + arregloNoPrimos.length);
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

    public static int[] listToArray(List<Integer> lista) {
        int[] arreglo = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            arreglo[i] = lista.get(i);
        }
        return arreglo;
    }
}
