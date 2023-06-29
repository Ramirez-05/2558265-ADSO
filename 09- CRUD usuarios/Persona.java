public class Persona{
    
    //atributos
    int id_persona;
    String cedula;
    String nombre;
    String apellido;
    String telefono;
    String direccion;
    String correo;


    //constructor
    public Persona(int id_persona, String cedula, String nombre, String apellido, String telefono, String direccion, String correo){
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
        return this.id_persona;
    }

    public String getCedula(){
        return this.cedula;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public String getDireccion(){
        return this.direccion;
    }

    public String getCorreo(){
        return this.correo;
    }




}