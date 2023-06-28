public class Productos {
    // Atributos
    private int codigo;
    private String nombre;
    private int precio;

    // Constructor
    public Productos(int codigo, String nombre, int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y Setters
    public int getCodigo() {
        return this.codigo;
    }

    public String getNombre_producto() {
        return this.nombre;
    }

    public int getPrecio() {
        return this.precio;
    }


}
