import java.util.Scanner;

public class Ejercicio_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario ingresar un nombre completo
        System.out.print("Ingrese un nombre: ");
        String nombreCompleto = scanner.nextLine();

        // Invertir el nombre completo
        String nombreInvertido = "";
        for (int i = nombreCompleto.length() - 1; i >= 0; i--) {
            nombreInvertido += nombreCompleto.charAt(i);
        }

        // Mostrar el nombre invertido en pantalla
        System.out.println("Nombre invertido: " + nombreInvertido);
    }
}
