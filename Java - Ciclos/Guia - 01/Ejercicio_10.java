import java.util.Scanner;
public class Ejercicio_10{
    public static void main(String[] arg){
        Scanner entrada = new Scanner(System.in);
        
        int numero,j,i,k,l,p;
        
        k=numero;
        p=0;
        
    

        System.out.print("Por favor ingrese un numero: ");

        numero = entrada.nextInt();

        for( i=1;i<=numero;i++){

            if( i==1 ){
                for(j=1;j<=numero;j++){
                    System.out.println(j);
                }
            }else{
                for(j = k-1; j<=numero; j++){
                    System.out.println(j);
                }
                for(l=1; l<=numero-p; l++){
                    System.out.println(l);
                }
            }

            k=k-1;
            p=p+1;
        }   

    }
} 