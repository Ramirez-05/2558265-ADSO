public class Factura{

    //Atributos
    int total;
    int cantidad;
    int precio;
    int fecha;

    //Constructor

    public Factura(int total, int cantidad, int precio, int fecha) {
        this.total = total;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
    }

    //Getters y Setters

    public int getTotal() {
        return this.total;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public int getPrecio() {
        return this.precio;
    }

    public int getFecha() {
        return this.fecha;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }







}