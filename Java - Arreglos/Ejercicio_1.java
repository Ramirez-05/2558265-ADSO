import java.util.Scanner;

public class Ejercicio_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese un número: ");
        int numero = scanner.nextInt();
        
        int[] arreglo = new int[numero];
        
        for (int i = 0; i < numero; i++) {
            arreglo[i] = 2 * i + 1;
        }
    
        System.out.println("El arreglo de números impares es:");
        for (int i = 0; i < numero; i++) {
            System.out.print(arreglo[i] + " ");
        }
    }
}
