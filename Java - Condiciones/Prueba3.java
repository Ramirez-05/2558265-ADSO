import java.util.Scanner;
public class Prueba3{
    public static void main(String[] arg){
        Scanner entrada = new Scanner(System.in);
        int altura;
        System.out.print("que altura desea: ");
        altura = entrada.nextInt();    
        for(int i=1; i <=altura; i++){
            for(int x=1; x<=altura-i; x++){
                System.out.print(" ");
            }
            for(int x=1; x<=2*i-1; x++){
                System.out.print("x");
            }
            System.out.print("\n");
        }
    }
} 