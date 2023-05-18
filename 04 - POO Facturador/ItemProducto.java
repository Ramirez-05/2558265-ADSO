
public class ItemProducto{

	Producto producto;
	int cantidad;
	double subtotal;

	public ItemProducto(Producto producto, int cantidad, double subtotal){
		this.producto = producto;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}

	public int getId(){
		return this.producto.getId();
	}

	public String getNombre(){
		return this.producto.getNombre();
	}

	public double getPrecio(){
		return this.producto.getPrecio();
	}

}