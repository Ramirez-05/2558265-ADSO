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
        Equipo crearEquipo[] = new Equipo[100];
        int index_equipo = 0;

        int index_contratar = 0;

        int index_detalle = 0;
        


        do {
            System.out.println("[=========================================]");
            System.out.println("[============ MENU  PRINCIPAL ============]");
            System.out.println("[=========================================]");
            System.out.println("[== 1.Crear jugador de Futbol           ==]");
            System.out.println("[== 2.Crear Equipo de Futbol            ==]");
            System.out.println("[== 3.Contratar Jugador de Futbol       ==]");
            System.out.println("[== 4.Cambiar Jugador De Equipo         ==]");
            System.out.println("[== 5.Ver Listado de Equipos de futbol  ==]");
            System.out.println("[== 6.Ver detalle de Equipos de Futbol  ==]");
            System.out.println("[== 7.Registrar Partido                 ==]");
            System.out.println("[== 8.Ver detalle de Partidos de Futbol ==]");
            System.out.println("[== 9.Ver listado de Partidos de Futbol ==]");
            System.out.println("[==            realizados en un Estadio ==]");
            System.out.println("[== 10.Salir                            ==]");
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
                System.out.println("Ingrese su apellido: ");
                String apellido = cadenas.nextLine();

                System.out.println();
                System.out.println("Ingrese su edad : ");
                int edad = entrada.nextInt();

                System.out.println();
                System.out.println("Ingrese en la posicion que juega: "); 
                String posicion = cadenas.nextLine();

                Boolean estado_jugador = true;


                // creamos el objeto de tipo jugadores 
                Jugadores temp_player = new Jugadores(cedula, nombre, apellido, edad, posicion, estado_jugador);

                // guardamos el objetos en el arreglo de jugadores
                arrayplayers[index_player] = temp_player;

                // aumentamos el indice de jugadores
                index_player++;

            }else if (opcion == 2){
                System.out.println("[==============================]");
                System.out.println("[== CREANDO EQUIPO DE FUTBOL ==]");
                System.out.println("[==============================].\n");

                System.out.println("Ingrese el nombre del equipo");
                String nombre = cadenas.nextLine();

                // creamos el objeto de tipo equipo
                Equipo temp_team = new Equipo(nombre);

                // guardamos el objeto en el arreglo de equipos
                arrayTeams[index_teams] = temp_team;

                // aumentamos el indice de equipos
                index_teams++;

            }else if(opcion == 3){

                System.out.println("[=================================]");
                System.out.println("[== CREANDO CONTRATO DE JUGADOR ==]");
                System.out.println("[=================================] \n");
        
                System.out.println("Ingrese el nombre del equipo que va a realizar la contratacion");
                String nombre = cadenas.nextLine();
        
                for(int i=0; i<arrayTeams.length; i++){
                    if(arrayTeams[i] != null &&  arrayTeams[i].getNombreEquipo().equals(nombre)){
                        System.out.println("Equipo encontrado");
                        index_detalle = i;
                        break;
                    }else{
                        System.out.println("Equipo no encontrado");
                        break;
                    }
                }
        
                Equipo temo_equipo = new Equipo(arrayTeams[index_detalle].getNombreEquipo());
                temo_equipo.crearContrato(arrayplayers, arrayTeams);

                crearEquipo[index_contratar] = temo_equipo;
                index_equipo++;

            }else if(opcion==4){

            }else if(opcion==5){
                System.out.println("[==================================]");
                System.out.println("[== LISTADO DE EQUIPOS DE FUTBOL ==]");
                System.out.println("[==================================] \n");

                for(int i=0; i<arrayTeams.length; i++){
                    if(arrayTeams[i] != null){
                        System.out.println("Nombre del equipo: " + arrayTeams[i].getNombreEquipo());
                    }
                }

            }else if(opcion==6){

                Equipo tempo_detalle = new Equipo(arrayTeams[index_detalle].getNombreEquipo());

                tempo_detalle.mostrarDetalle(crearEquipo, index_equipo);

            }

        } while (opcion != 10);


    


    }
}
