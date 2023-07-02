import java.util.Scanner;

public class Prueba7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i = 1, n1, n2, n3;

        System.out.print("-> Ingrese el primer numero: ");
        n1 = input.nextInt();
        System.out.print("-> Ingrese el segundo numero: ");
        n2 = input.nextInt();
        System.out.print("-> Ingrese el tercer numero: ");
        n3 = input.nextInt();

        while ((i % n1 != 0) || (i % n2 != 0) || (i % n3 != 0)) {

            i += 1;
        }
        System.out.println("Este es el M.C.M: " + i);

    }
}