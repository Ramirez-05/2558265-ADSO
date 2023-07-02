import java.util.Scanner;

public class Ejercicio_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese palabra 1: ");
        String palabra1 = scanner.nextLine();

        System.out.print("Ingrese palabra 2: ");
        String palabra2 = scanner.nextLine();

        int longitud1 = palabra1.length();
        int longitud2 = palabra2.length();

        int longitudMinima = Math.min(longitud1, longitud2);

        String resultado = "";
        for (int i = 0; i < longitudMinima; i++) {
            resultado += palabra1.charAt(i) + "" + palabra2.charAt(i);
        }

        if (longitud1 > longitud2) {
            resultado += palabra1.substring(longitudMinima);
        } else if (longitud2 > longitud1) {
            resultado += palabra2.substring(longitudMinima);
        }

        System.out.println("Resultado: " + resultado);
    }
}
