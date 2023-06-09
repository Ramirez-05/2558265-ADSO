public class Persona {
    // Atributos
    private int cedula;
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;

    // Constructor
    public Persona(int cedula, String nombre, String apellido, int edad, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
    }

    // Getters y Setters
    public int getCedula() {
        return this.cedula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public int getEdad() {
        return this.edad;
    }

    public String getDireccion() {
        return this.direccion;
    }
    




}
