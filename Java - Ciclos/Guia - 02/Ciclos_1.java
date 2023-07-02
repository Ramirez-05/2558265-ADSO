import java.util.Scanner;


public class Ciclos_1{
    public static void main(String[] arg){
        Scanner entrada = new Scanner(System.in);
        int sueldo_total,cant_pagos,forma_pago,i,forma_1;

        System.out.print("Ingrese un suelto total: ");
        sueldo_total = entrada.nextInt();

        System.out.print("¿Cantidad de pagos? ");
        cant_pagos= entrada.nextInt();


        System.out.println("------------ FORMAS DE PAGO ------------");
        System.out.println("1. Pagos de igual valor                 ");
        System.out.println("2. Primer pago diferente                ");
        System.out.println("3. Ultimo pago diferente                ");
        System.out.println("4. Primer y Ultimo pago diferente       ");
        System.out.println("----------------------------------------");

        System.out.print("Ingrese la forma de pago: ");
        forma_pago = entrada.nextInt();

        if(forma_pago == 1 ){
            System.out.println("--------- SUS PAGOS SERAN ---------");

            forma_1 = sueldo_total/cant_pagos;

            for(i=1;i<=cant_pagos;i++){
                System.out.println("Mes 0"+i+" $ "+forma_1);
            }
        }else if(forma_pago == 2){
            System.out.println("--------- SUS PAGOS SERAN ---------");

            int forma_2 = sueldo_total/2;
            
            System.out.println("Mes 01: $ "+forma_2);

            int metodo_2 = cant_pagos-1;

            int proceso_2 = forma_2/metodo_2;

            for(i=2; i<=cant_pagos;i++){
                System.out.println("Mes 0"+i+": $"+proceso_2);
            }
        }else if(forma_pago == 3){
            System.out.println("--------- SUS PAGOS SERAN ---------");

            int forma_3 = sueldo_total/2;

            int metodo_3 = cant_pagos-1;

            int proceso_3 = forma_3/metodo_3;

            for(i=1;i<=cant_pagos-1;i++){
                System.out.println("Mes 0"+i+": $"+proceso_3);

            }

            System.out.println("Mes 0"+cant_pagos+": $"+forma_3);
        }else{
        
            System.out.println("--------- SUS PAGOS SERAN ---------");

            //Para sacar el primero diferente
            Double prforma = sueldo_total*0.10;

            System.out.println("Mes 01: $"+prforma);

            // Lo que quedo ya decontando lo primero
            Double total_prt = sueldo_total-prforma;

            //Para sacar el ultimo diferente
            double sgforma = total_prt*0.20;

            //Lo que quedo ya descontando lo ultimo
            Double total_sgt = total_prt-sgforma;

            // aca quitamos dos pagos porque el primero y ultimo son diferentes
            int metodo_4 = cant_pagos-2;

            // Aca dividimos lo que quedo de lo desctando del ultimo y se dividio por el resultado de metodo 4
            Double proceso_4 = total_sgt/metodo_4;

            for(i=2; i<=cant_pagos-1;i++){
                System.out.println("Mes 0"+i+": $"+proceso_4);
            }
            System.out.println("Mes 0"+cant_pagos+": $"+sgforma);
        }

    }
} 