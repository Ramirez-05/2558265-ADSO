import java.util.Scanner;
public class Ejercicio_2 {
    public static void main(String[] args){
        int aleatorio=0,aleatorio_1=0,aleatorio_2=0,i=1;
        Scanner entrada = new Scanner (System.in);
        while(i<=1){
            aleatorio  = (int) (Math.random()*30+1);
            aleatorio_1  = (int) (Math.random()*12+1);
            aleatorio_2  = (int) (Math.random()*1000+1022);
            System.out.print(""+aleatorio+"-"+aleatorio_1+"-"+aleatorio_2);
            i++;
        }
    }
}