import java.util.Date;
import java.util.Scanner;
public class Factura{

    //Atributos
    int id;
    Date fecha;
    Persona cliente;
    Persona vendedor;
    ItemProducto listaProductos [];
    double total;
    Scanner facturas;
    int opc;
    int contador_items;


    
    //Constructor
    public Factura(int id, Persona cliente, Persona vendedor) {
        this.id = id;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.fecha = new Date();
        ItemProducto temp [] = new ItemProducto[100];
        listaProductos = temp;
        this.total = 0;
        facturas = new Scanner(System.in);
        this.opc = 0;
        this.contador_items = 0;
    }


    public void crearItems(Producto []arrayProducts){

        do {
            System.out.println("== Lista De Productos ==");
            for(int i=0; i<listaProductos.length; i++){
                if(listaProductos[i] != null){
                    System.out.println(listaProductos[i]+" "+listaProductos[i].getNombre()+" "+listaProductos[i].getPrecio());
                }
            }

            System.out.println("========================");
            
            System.out.println("Deseas realizar alguna compra ? 1. Si 2. No");
            opc = facturas.nextInt();

            if(opc==1){
                System.out.println("Ingrese el id del producto a comprar: ");
                int temp_id = facturas.nextInt();

                System.out.println();
                System.out.println("Ingrese la cantidad que desea comprar: ");
                int temp_cantidad = facturas.nextInt();


                ItemProducto temo_item = new ItemProducto(arrayProducts[temp_id-1], temp_cantidad, arrayProducts[temp_id].getPrecio()*temp_cantidad);
                
                listaProductos[contador_items] = temo_item;

                this.total += temo_item.subtotal;

                

                contador_items++;


            }
            
        } while (opc!=1);

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


    public double getTotal(){
        return this.total;
    }

    public void imprimirCliente(){
        this.cliente.imprimirPersona();
    }

}