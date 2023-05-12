import java.util.Scanner;


public class Persona {
    
    //Atributos
    int cedula;
    String nombre;
    String apellido;
    Scanner entrada;
    Scanner cadenas;

    //Constructor
    public Persona(String nombre, String apellido, int cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        entrada = new Scanner(System.in);
        cadenas = new Scanner(System.in);

    }

    //Metodos
    public void imprimirPersona() {
        System.out.println("  => "+cedula+" - "+nombre+" "+apellido);
    }


    



    //Getters y Setters

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public int getCedula() {
        return this.cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

}
