import java.util.Scanner;

public class Ciclos_2 {
  public static void main(String[] args) {
    double t_f, c_p, v_c, i_t;

    Scanner scanner = new Scanner(System.in);

    System.out.println("Ingrese la cantidad financiada:");
    t_f = scanner.nextDouble();

    while (t_f <= 0) {
        System.out.println("La cantidad ingresada esta mal, repita proceso:");
        t_f = scanner.nextDouble();
    }

    System.out.println("Ingrese la cantidad de cuotas pagadas:");
    c_p = scanner.nextDouble();

    while (c_p < 0) {
        System.out.println("La cantidad ingresada esta mal, repita proceso:");
        c_p = scanner.nextDouble();
    }

    System.out.println("Ingrese el valor de cada cuota:");
    v_c = scanner.nextDouble();

    while (v_c <= 0) {
        System.out.println("La cantidad ingresada esta mal, repita proceso:");
        v_c = scanner.nextDouble();
    }

    i_t = (t_f - (v_c * c_p)) / t_f;

    System.out.println("El interés total es: " + i_t + "%");
    }
}
