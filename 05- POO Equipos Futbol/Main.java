import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Scanner cadenas = new Scanner(System.in);

        /* Realizar una aplicación en JAVA para administrar los procesos realizados 
        por una federación de futbol, donde se presentan las siguientes consideraciones:

	- Debe existir un menú principal para definir las funcionalidades 
	principales como:
    -> Crear Jugador de Futbol
    -> Crear Equipo de Futbol
    -> Cambiar Jugador de Equipo
    -> Ver Listado de Equipos de Futbol
    -> Ver detalle de Equipos de Futbol
    -> Registrar Partido
    -> Ver detalle de Partidos de Futbol
    -> Ver listado de Partidos de Futbol 
        realizados en un Estadio

	Las funcionales anteriores deben realizarse usando POO. El contenido de cada una 
	de las clases debe ser definida por el aprendiz. */

        int opcion = 0;

        // variables para crear jugadores 
        int index_player = 0;
        Jugadores arrayplayers[] = new Jugadores[500];
        boolean estado_cedula = true;

        //varibales para crear equipos 
        int index_teams = 0;
        Equipo arrayTeams[] = new Equipo[20];


        do {
            System.out.println("[=========================================]");
            System.out.println("[============ MENU  PRINCIPAL ============]");
            System.out.println("[=========================================]");
            System.out.println("[== 1.Crear jugador de Futbol           ==]");
            System.out.println("[== 2.Crear Equipo de Futbol            ==]");
            System.out.println("[== 3.Cambiar Jugador De Equipo         ==]");
            System.out.println("[== 4.Ver Listado de Equipos de futbol  ==]");
            System.out.println("[== 5.Ver detalle de Equipos de Futbol  ==]");
            System.out.println("[== 6.Registrar Partido                 ==]");
            System.out.println("[== 7.Ver detalle de Partidos de Futbol ==]");
            System.out.println("[== 8.Ver listado de Partidos de Futbol ==]");
            System.out.println("[==            realizados en un Estadio ==]");
            System.out.println("[== 9.Salir                             ==]");
            System.out.println("[=========================================]\n");

            System.out.println("Por favor ingrese una opcion");
            opcion = entrada.nextInt();

            if(opcion==1){
                System.out.println("[===============================]");
                System.out.println("[== CREANDO JUGADOR DE FUTBOL ==]");
                System.out.println("[===============================].\n");

                System.out.println("Ingrese su documento: ");
                int cedula = entrada.nextInt();

                estado_cedula = true;

                for(int i=0; i<index_player; i++){
					if(arrayplayers[i].getCedula() == cedula){
						System.out.println("La cedula ya existe");
						estado_cedula = false;
					}
				}
				if(estado_cedula==false){
					continue;
				}


                System.out.println();
                System.out.println("Ingrese su nombre: ");
                String nombre = cadenas.nextLine();

                System.out.println();
                System.out.println("Ingrese su edad : ");
                int edad = entrada.nextInt();

                System.out.println();
                System.out.println("Ingrese en la posicion que juega: ");
                String posicion = cadenas.nextLine();


                // creamos el objeto de tipo jugadores 
                Jugadores temp_player = new Jugadores(cedula, nombre, nombre, edad, posicion);

                // guardamos el objetos en el arreglo de jugadores
                arrayplayers[index_player] = temp_player;

                index_player++;

            }else if (opcion == 2){
                System.out.println("[==============================]");
                System.out.println("[== CREANDO EQUIPO DE FUTBOL ==]");
                System.out.println("[==============================].\n");

                System.out.println("Ingrese el nombre del equipo");
                String nombre = cadenas.nextLine();
                


            }
        } while (opcion != 9);





    }
}
