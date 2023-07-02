import java.util.Scanner;

public class Ciclos_3{
    public static void main (String[]args){
        
        int interes1 = 5;
        int interes2 = 10;
        int interes3 = 20;

        Scanner inicio=new Scanner (System.in);
        System.out.println("INGRESE LA CANTIDAD DE CLIENTES QUE VAN A FINANCIAR");
        int clientes = inicio.nextInt();

        for (int i=1; i<=clientes; i++){
            Scanner entrada = new Scanner(System.in);
            System.out.println("SENOR USUARIO, INGRESE EL VALOR DE LA COMPRA");
            int compra = entrada.nextInt();

            int valorcompra=compra;

            System.out.println("SENOR USUARIO, INGRESE EL VALOR QUE DESEA FINANCIAR");
            int financiar = entrada.nextInt();

            int mitadcompra = compra/2;
            int comparacion = compra-financiar;

            if (comparacion>mitadcompra){
                int cuotas_mensuales = 5;
                System.out.println("EL VALOR DE LA FINANCIACION ES MENOR AL VALOR MEDIO DE LA COMPRA");
                int cuotaneta=valorcompra*5;
                int cuota=cuotaneta+compra;
                System.out.println("INGRESE EL VALOR DEL ABONO");
                int abono = entrada.nextInt();
                for (int j=1; j<=cuotas_mensuales; j++){
                    System.out.println("ESTE ES EL VALOR DE LA CUOTA "+j+" "+cuota/10);
                }
                System.out.println("ESTE ES EL VALOR DEL INTERES: "+cuotaneta/10);
                int resultado=cuota-abono;
                for (int j=1; j<=cuotas_mensuales; j++){
                    System.out.println("ESTE ES EL VALOR DE LA CUOTA CON LOS ABONOS "+j+" "+resultado);
                }
            }

            if (comparacion==mitadcompra){
                int cuotas_mensuales = 8;
                System.out.println("EL VALOR DE LA FINANCIACION ES IGUAL AL VALOR MEDIO DE LA COMPRA");
                System.out.println("TENDRA UN INTERES DEL 10% POR EL VALOR DE LA COMPRA, A 8 CUOTAS MENSUALES");
                int cuotaneta=valorcompra*10;
                int cuota=cuotaneta+compra;
                System.out.println("INGRESE EL VALOR DEL ABONO");
                int abono = entrada.nextInt();
                for (int j=1; j<=cuotas_mensuales; j++){
                    System.out.println("ESTE ES EL VALOR DE LA CUOTA "+j+" "+cuota/10);
                }
                System.out.println("ESTE ES EL VALOR DEL INTERES: "+cuotaneta/10);
                int resultado=cuota-abono;
                for (int j=1; j<=cuotas_mensuales; j++){
                    System.out.println("ESTE ES EL VALOR DE LA CUOTA CON LOS ABONOS "+j+" "+resultado);
                }
            }

            if (comparacion<mitadcompra){
                int cuotas_mensuales = 10;
                System.out.println("EL VALOR DE LA FINANCIACION ES MAYOR AL VALOR MEDIO DE LA COMPRA");
                System.out.println("TENDRA UN INTERES DEL 20% POR EL VALOR DE LA COMPRA, A 10 CUOTAS MENSUALES");;
                int cuotaneta=valorcompra*20;
                int cuota=cuotaneta+compra;
                System.out.println("INGRESE EL VALOR DEL ABONO");
                int abono = entrada.nextInt();
                for (int j=1; j<=cuotas_mensuales; j++){
                    System.out.println("ESTE ES EL VALOR DE LA CUOTA "+j+" "+cuota/10);
                }
                System.out.println("ESTE ES EL VALOR DEL INTERES: "+cuotaneta/10);
                int resultado=cuota-abono;
                for (int j=1; j<=cuotas_mensuales; j++){
                    System.out.println("ESTE ES EL VALOR DE LA CUOTA CON LOS ABONOS "+j+" "+resultado);
                }
            }
        }
    }
}