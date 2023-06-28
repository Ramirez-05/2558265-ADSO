public class Persona{
    
    //atributos
    int id_persona;
    int cedula;
    String nombre;
    String apellido;
    int telefono;
    String direccion;
    String correo;


    //constructor
    public Persona(int id_persona, int cedula, String nombre, String apellido, int telefono, String direccion, String correo){
        this.id_persona = id_persona;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    //metodos
    //getters
    public int getId_persona(){
        return id_persona;
    }

    public int getCedula(){
        return cedula;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public int getTelefono(){
        return telefono;
    }

    public String getDireccion(){
        return direccion;
    }

    public String getCorreo(){
        return correo;
    }




}