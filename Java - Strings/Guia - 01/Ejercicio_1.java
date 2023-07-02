import java.util.Scanner;

public class Ejercicio_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese una oración: ");
        String oracion = scanner.nextLine();

        oracion = oracion.toLowerCase();

        int contadorVocales = 0;
        for (int i = 0; i < oracion.length(); i++) {
            char c = oracion.charAt(i);
            if (esVocal(c)) {
                contadorVocales++;
            }
        }

        System.out.println("La cantidad de vocales es: " + contadorVocales);
    }

    // Función para verificar si un caracter es una vocal
    public static boolean esVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
