import java.util.Date;

public class Factura{

    //Atributos
    int id;
    Date fecha;
    Persona cliente;
    Persona vendedor;
    ItemProducto listaProductos [];
    double total;
    
    //Constructor
    public Factura(int id, Persona cliente, Persona vendedor) {
        this.id = id;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.fecha = new Date();
        ItemProducto temp [] = new ItemProducto[100];
        listaProductos = temp;
        this.total = 0;
    }

    //Getters y Setters
    public int getId(){
        return this.id;
    }
    public Date getFecha(){
        return this.fecha;
    }
    public Persona getCliente(){
        return this.cliente;
    }
    public Persona getVendedor(){
        return this.vendedor;
    }
    public Producto getListaProductos(){
        return this.listaProductos;
    }
    public double getTotal(){
        return this.total;
    }

    public void imprimirCliente(){
        this.cliente.imprimirPersona();
    }

}