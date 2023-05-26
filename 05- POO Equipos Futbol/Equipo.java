import java.util.Scanner;

public class Equipo {
    
    String nombre_equipo;

    Jugadores listJugadores[];

    int indice;

    int auxiliar;

    Scanner entrada;
    Scanner cadenas;    

    //metodo constructor

    public Equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
        listJugadores = new Jugadores[22];
        this.indice = 0;
        this.auxiliar = 0;

        entrada = new Scanner(System.in);
        cadenas = new Scanner(System.in);
    }

    //metodo set y get

    public String getNombreEquipo(){
        return this.nombre_equipo;
    }

    public void crearContrato(Jugadores[] arrayplayers, Equipo[] arrayTeams){


        System.out.println();
        System.out.println("jugadores disponibles para contratar");

        for(int i=0; i<arrayplayers.length; i++){
            if(arrayplayers[i] != null && arrayplayers[i].getEstado() == true){
                System.out.println();
                System.out.println("Nombre del jugador: " + arrayplayers[i].getNombreJugador());
                System.out.println("Posicion del jugador: " + arrayplayers[i].getPosicionJuego());
                System.out.println("Cedula del jugador: " + arrayplayers[i].getCedula());
                System.out.println();
            }
        }

        System.out.println();
        System.out.println("Ingrese el documento del jugador que va a contratar");
        int cedula = entrada.nextInt();


        for(int i=0; i<arrayplayers.length; i++){
            if(arrayplayers[i] != null &&  arrayplayers[i].getCedula() == cedula && arrayplayers[i].getEstado() == true){
                System.out.println("Jugador encontrado");
                indice = i;
                break;
            }else{
                System.out.println("Jugador no encontrado");
                break;
            }
        }

      

        System.out.println();
        System.out.println("Desea confirmar el contrato de este equipo?");
        System.out.println("1. Si");
        System.out.println("2. No");

        int eleccion = entrada.nextInt();

        if(eleccion == 1){
            System.out.println("Contrato realizado con exito"); 

            Jugadores temp_jogo = new Jugadores(arrayplayers[indice].getCedula(), arrayplayers[indice].getNombreJugador(), arrayplayers[indice].getApellidoJugador(), arrayplayers[indice].getEdad(), arrayplayers[indice].getPosicionJuego(), arrayplayers[indice].getEstado());
            listJugadores[auxiliar] = temp_jogo;
            auxiliar++;


            arrayplayers[indice].setEstado(false);


        }

    }

    public void mostrarDetalle( Equipo[] crearEquipo, int index_equipo){
        System.out.println("Ingrese el nombre del equipo el cual desea ver el detalle");
        String nombre = cadenas.nextLine();

        boolean encontrado = false;


        for(int i=0; i<index_equipo;i++ ){
            if(crearEquipo[i] != null && crearEquipo[i].getNombreEquipo().equals(nombre)){
                System.out.println();
                System.out.println("Nombre del equipo: " + crearEquipo[i].getNombreEquipo());

                encontrado = true;

                for(int j=0; j<crearEquipo[i].listJugadores.length; j++){
                    if(crearEquipo[i].listJugadores[j] != null){
                        System.out.println();
                        System.out.println("Nombre del jugador: " + crearEquipo[i].listJugadores[j].getNombreJugador());
                        System.out.println("Posicion del jugador: " + crearEquipo[i].listJugadores[j].getPosicionJuego());
                        System.out.println();


                    }
                }

            }
        }


        if(!encontrado){
            System.out.println("Equipo no encontrado");
        }
    }



}
