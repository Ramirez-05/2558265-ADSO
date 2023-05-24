import java.util.Date;
import java.util.Scanner;
public class Factura{

    //Atributos
    int id;
    Date fecha;
    Persona     ;
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
            for(int i=0; i<arrayProducts.length; i++){
                System.out.println(arrayProducts[i].getId()+" "+arrayProducts[i].getNombre()+" "+arrayProducts[i].getPrecio());
                
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

                ItemProducto temo_item = new ItemProducto(arrayProducts[(temp_id-1)], temp_cantidad, arrayProducts[(temp_id-1)].getPrecio()*temp_cantidad);
                
                listaProductos[contador_items] = temo_item;

                this.total += temo_item.getSubtotal();

                contador_items++;


            }else{
                System.out.println("Gracias por su compra");
            }
            
        } while (opc!=2);

    }

    public void imprimirDetalle(Factura[] arrayInvoices, int invoiceIndex){
        
        System.out.println();
        System.out.println("Ingrese el numero de factura: ");
        int numero_factura = facturas.nextInt();
        boolean encontrado = false;

        for(int i=0; i<invoiceIndex; i++){
            if(arrayInvoices[i] != null && arrayInvoices[i].getId()==numero_factura){
                System.out.println("Factura encontrada: \n");
                System.out.println("Fecha: "+arrayInvoices[i].getFecha());
                System.out.println(" Numero de factura: "+ arrayInvoices[i].getId());
                System.out.println(" Cliente: "+arrayInvoices[i].getCliente().getNombre());
                System.out.println(" Vendedor: "+arrayInvoices[i].getVendedor().getNombre());
                System.out.println("Con un total de: "+arrayInvoices[i].getTotal());
                encontrado = true;
                System.out.println();
                System.out.println("Productos comprados: \n");

                for(int j=0; j<arrayInvoices[i].listaProductos.length; j++){
                    if(arrayInvoices[i].listaProductos[j] != null){
                        System.out.println("Producto: "+arrayInvoices[i].listaProductos[j].getNombre());
                        System.out.println("Cantidad: "+arrayInvoices[i].listaProductos[j].getCantidad());
                        System.out.println("Subtotal: "+arrayInvoices[i].listaProductos[j].getSubtotal());
                        System.out.println();
                    }
                }

                break;
            }
        }

        if(!encontrado){
            System.out.println("Factura no encontrada");
        }




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