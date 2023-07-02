import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese una frase: ");
        String frase = scanner.nextLine();

        System.out.print("Ingrese un número: ");
        int numero = scanner.nextInt();

        char[] caracteres = frase.toCharArray();

        char[] resultado = new char[caracteres.length];
        for (int i = 0; i < caracteres.length; i++) {
            int nuevaPosicion = (i - numero) % caracteres.length;
            if (nuevaPosicion < 0) {
                nuevaPosicion += caracteres.length;
            }
            resultado[nuevaPosicion] = caracteres[i];
        }

        System.out.print("Resultado: ");
        for (char c : resultado) {
            System.out.print(c);
        }
        System.out.println();
    }
}

