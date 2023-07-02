import java.util.Scanner;

public class Ejercicio_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese una contraseña: ");
        String contrasena = scanner.nextLine();

        boolean esValida = true;

        if (contrasena.length() < 8) {
            esValida = false;
        }

        boolean tieneMayuscula = false;
        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
                break;
            }
        }
        if (!tieneMayuscula) {
            esValida = false;
        }

        boolean tieneMinuscula = false;
        for (char c : contrasena.toCharArray()) {
            if (Character.isLowerCase(c)) {
                tieneMinuscula = true;
                break;
            }
        }
        if (!tieneMinuscula) {
            esValida = false;
        }

        boolean tieneDigito = false;
        for (char c : contrasena.toCharArray()) {
            if (Character.isDigit(c)) {
                tieneDigito = true;
                break;
            }
        }
        if (!tieneDigito) {
            esValida = false;
        }

        boolean tieneCaracterEspecial = false;
        for (char c : contrasena.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                tieneCaracterEspecial = true;
                break;
            }
        }
        if (!tieneCaracterEspecial) {
            esValida = false;
        }

        if (contrasena.contains(" ")) {
            esValida = false;
        }

        if (esValida) {
            System.out.println("La contraseña es válida.");
        } else {
            System.out.println("La contraseña no es válida.");
        }
    }
}
