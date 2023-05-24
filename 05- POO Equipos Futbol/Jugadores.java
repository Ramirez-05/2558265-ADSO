public class Jugadores {

    //Atributos
    int cedula;
    String nombre_jugadores;
    String apellido_jugadores;
    int edad;
    String posicion_juego;
    int dorsales;


    //Metodo constructor 

    public Jugadores(int cedula, String nombre_jugadores, String apellido_jugadores, int edad, String posicion_juego){

        this.cedula = cedula;
        this.nombre_jugadores = nombre_jugadores;
        this.apellido_jugadores = apellido_jugadores;
        this.edad = edad;
        this.posicion_juego = posicion_juego;

    }

    //metodo set y get

    public int getCedula(){
        return this.cedula;
    }

    public String getNombreJugador(){
        return this.nombre_jugadores;
    }

    public String getApellidoJugador(){
        return this.apellido_jugadores;
    }

    public int getEdad(){
        return this.edad;
    }

    public String getPosicionJuego(){
        return this.posicion_juego;
    }

}
