import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese una oración: ");
        String oracion = scanner.nextLine();

        char[] caracteres = oracion.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            if (Character.isUpperCase(caracteres[i])) {
                caracteres[i] = Character.toLowerCase(caracteres[i]);
            } else if (Character.isLowerCase(caracteres[i])) {
                caracteres[i] = Character.toUpperCase(caracteres[i]);
            }
        }
        String oracionInvertida = new String(caracteres);
        System.out.println("Oración invertida: " + oracionInvertida);
    }
}
