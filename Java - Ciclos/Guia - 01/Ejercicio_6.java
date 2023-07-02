import java.util.Scanner;
public class Ejercicio_6 {
    public static void main(String[] args){
        int rango_1,rango_2,i,j,resultado=1;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el primer rango: ");
        rango_1 = entrada.nextInt();
        System.out.print("Ingrese el segundo rango: ");
        rango_2 = entrada.nextInt();
        if(rango_1>rango_2){
            System.out.println("Los datos ingresados no son correctos");
        }else{
            for(i=rango_1;i<=rango_2;i++){
                System.out.println("Factorial de "+i);
                for(j=1;j<=i;j++){
                    System.out.print(" "+j+" x");
                    resultado=resultado*j;  
                }
                System.out.println(" = "+resultado);
                resultado=1;
            }
            
            
        }
    }
}
