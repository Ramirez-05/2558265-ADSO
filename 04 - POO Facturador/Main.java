import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		Scanner cadenas = new Scanner(System.in);

        /*  Realizar una aplicacion en JAVA para generar faturas de venta de
	        productos, con las siguientes consideraciones:

			- Debe exister un menu principal para definir las funcionalidades 
				principales como:
				-> Creacion de cliente
				-> Creacion de Vendedor
				-> Creacion de Factura
				-> Ver lista de Clientes
				-> Ver lista de Vendedores
				-> Ver lista de Facturas
				-> Ver detalle de Factura

			- En la creacion de nueva Factura se debe seleccionar un cliente
				para la factura, seleccionar un vendedor e ingresar los productos
				a la factura con su respectiva cantidad de venta. 
				Al finalizar el ingreso de los productos se debe mostrar en pantalla
				el total facturado.
			
			- La lista de Facturas debe tener el siguiente formato:
				FECHA => ID_FACTURA => VENDEDOR => CLIENTE => TOTAL

			- El detalle de la Factura debe visualizarse con un formato definido
				por ustedes, donde se incluya toda la informacion necesaria.
		*/

	

		int opcion = 0;
		int clientIndex = 0;
		int sellerIndex = 0;
		int invoiceIndex = 0;
		Persona arrayClients[] = new Persona[100]; 
		Persona arraySellers[] = new Persona[100];
		Factura arrayInvoices[] = new Factura[100];
		Boolean estado_cedula = true;

		// Agregando prodcutos

		Producto p1 = new Producto(1, "Coca Cola", 2500);
		Producto p2 = new Producto(2, "Pepsi", 2800);
		Producto p3 = new Producto(3, "Fanta", 1500);
		Producto p4 = new Producto(4, "Sprite", 2000);
		Producto p5 = new Producto(5, "Agua", 1200);
		Producto p6 = new Producto(6, "Jugo", 3500);
		Producto p7 = new Producto(7, "Cerveza", 3500);
		Producto p8 = new Producto(8, "Ron", 15000);
		Producto p9 = new Producto(9, "Vodka", 25000);
		Producto p10 = new Producto(10, "Tequila", 35000);

		// Agregando productos a un array

		Producto arrayProducts[] = new Producto[10];

		arrayProducts[0] = p1;
		arrayProducts[1] = p2;
		arrayProducts[2] = p3;
		arrayProducts[3] = p4;
		arrayProducts[4] = p5;
		arrayProducts[5] = p6;
		arrayProducts[6] = p7;
		arrayProducts[7] = p8;
		arrayProducts[8] = p9;
		arrayProducts[9] = p10;

		do {
			
			System.out.println("==========================================");
			System.out.println("== Bienvenido al Sistema de Facturacion ==");
			System.out.println("=========== MENU  PRINCIPAL ==============");
			System.out.println("== 1. Crear Cliente                     ==");
			System.out.println("== 2. Crear Vendedor                    ==");
			System.out.println("== 3. Crear Factura                     ==");
			System.out.println("== 4. Ver lista de Clientes             ==");
			System.out.println("== 5. Ver lista de Vendedores           ==");
			System.out.println("== 6. Ver lista de Facturas             ==");
			System.out.println("== 7. Ver detalle de Factura            ==");
			System.out.println("== 8. Salir                             ==");	
			System.out.println("==========================================");
			System.out.println();

			System.out.print("Ingrese una opcion: ");
			opcion = entrada.nextInt();

			if(opcion==1){
				System.out.println("Clientes registrados: "+clientIndex);
				System.out.println();
				System.out.println("Ingrese su cedula ");
				int cedula = entrada.nextInt();

				estado_cedula = true;
				for(int i=0; i<clientIndex; i++){
					if(arrayClients[i].getCedula() == cedula){
						System.out.println("La cedula ya existe");
						estado_cedula = false;
					}
				}
				if(estado_cedula==false){
					continue;
				}

				System.out.println("Ingrese su nombre");
				String nombre = cadenas.nextLine();
				System.out.println("Ingrese su apellido");
				String apellido = cadenas.nextLine();

				Persona tempClients = new Persona(nombre, apellido, cedula);

				arrayClients[clientIndex] = tempClients;

				clientIndex++;
				


			}else if(opcion == 2 ){
				System.out.println("Vendedores Registrados: "+sellerIndex);
				System.out.println();

				System.out.println("Ingrese su cedula ");
				int cedula = entrada.nextInt();

				estado_cedula = true;
				for(int i=0; i<sellerIndex; i++){
					if(arraySellers[i].getCedula() == cedula){
						System.out.println("La cedula ya existe");
						estado_cedula = false;
					}
				}
				if(estado_cedula==false){
					continue;
				}

				System.out.println("Ingrese su nombre");
				String nombre = cadenas.nextLine();
				System.out.println("Ingrese su apellido");
				String apellido = cadenas.nextLine();

				Persona tempSellers = new Persona(nombre, apellido, cedula);

				arraySellers[sellerIndex] = tempSellers;

				sellerIndex++;
				
			}else if(opcion == 3 ){
				System.out.println("Ingrese la cedula del cliente: ");
				int cedula_cliente = entrada.nextInt();
				boolean encontrado = false;
				for(int i=0; i<clientIndex; i++){
					if(arrayClients[i] != null && arrayClients[i].getCedula()==cedula_cliente){
						System.out.println("Cliente encontrado: ");
						System.out.println("Nombre: " + arrayClients[i].getNombre() + " " + arrayClients[i].getApellido() + " Cedula: " + arrayClients[i].getCedula());
						encontrado = true;
						break;
					}
				}

				if(!encontrado){
					System.out.println("Cliente no encontrado");
				}


				System.out.println("Ingrese la cedula del vendedor: ");
				int cedula_vendedor = entrada.nextInt();


				encontrado = false;
				for(int i=0; i<sellerIndex; i++){
					if(arraySellers[i] != null && arraySellers[i].getCedula() == cedula_vendedor){
						System.out.println("Vendedor encontrado: ");
						System.out.println("Nombre: " + arraySellers[i].getNombre() + " " + arraySellers[i].getApellido() + " Cedula: " + arraySellers[i].getCedula());
						encontrado = true;
						break;
					}
				}

				if(!encontrado){
					System.out.println("Vendedor no encontrado");
				}

				// mostrar la lista de procductos

				System.out.println();
				System.out.println("== Lista De Productos ==");
				for(int i=0; i<arrayProducts.length; i++){
					System.out.println(arrayProducts[i].id+" "+arrayProducts[i].nombre+" "+arrayProducts[i].precio);
				}
				System.out.println("========================");

			



			}else if(opcion == 4 ){
				System.out.println();
				System.out.println("Esta es la lista de clientes: \n");
				for(int i=0; i<clientIndex; i++){
					System.out.println(arrayClients[i].getNombre()+" "+arrayClients[i].getApellido()+" Cedula: "+arrayClients[i].getCedula()+"\n");
				}

			}else if(opcion == 5 ){
				System.out.println();
				System.out.println("Esta es la lista de clientes: \n");
				for(int i=0; i<sellerIndex; i++){
					System.out.println(arraySellers[i].getNombre()+" "+arraySellers[i].getApellido()+" Cedula: "+arraySellers[i].getCedula()+"\n");
				}


			}else if(opcion == 6 ){
			}

		} while (opcion != 8);
    }
}