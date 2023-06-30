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

    //setters

    public void setId_persona(int id_persona){
        this.id_persona = id_persona;
    }

    public void setCedula(String cedula){
        this.cedula = cedula;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    




}