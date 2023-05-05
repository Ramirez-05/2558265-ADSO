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



	int contador_clientes = 0;

	int contador_venderores = 0;

	boolean estado_cedula = true;

	boolean estado_cedula_2 = true;

	boolean estado_definitivo = true;

	Persona arreglo[] = new Persona[100];

	Persona arreglo_2[] = new Persona[100];

	Persona arreglo_x[] = new Persona[100];

	Persona arreglo_y[] = new Persona[100];

	String fechas [] = new String [100];

	int contador_facturas = 0;

	int arreglo_total [] = new int [100];


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

			System.out.println("CLientes registrados: " + contador_clientes);
			

			System.out.print("Ingrese la cedula del cliente: ");
			int cedula = entrada.nextInt();

			estado_cedula = true;

			for(int i=0; i<contador_clientes; i++){

				if(arreglo[i].getCedula() == cedula){
					System.out.println("La cedula ya existe");
					estado_cedula = false;
				}
			}

			if(estado_cedula==false){
				continue;
			}

			System.out.print("Ingrese el nombre del cliente: ");
			String nombre = cadenas.nextLine();

			System.out.print("Ingrese el apellido del cliente: ");
			String apellido = cadenas.nextLine();

			// Crear un objeto cliente
			Persona cliente_regis = new Persona(nombre, apellido, cedula);

			// Guardar el objeto en el Arreglo
			arreglo[contador_clientes] = cliente_regis;

			contador_clientes++;


		}else if(opcion == 2 ){
			System.out.println("Vendedores registrados: " + contador_venderores);

			System.out.print("Ingrese la cedula del vendedor: ");
			int cedula_2 = entrada.nextInt();

			estado_cedula_2 = true;

			for(int i=0; i<contador_clientes; i++){

				if(arreglo[i].getCedula() == cedula_2){
					System.out.println("");
					System.out.println("La cedula que ingresaste le pertenece a un cliente");
					System.out.println("");
					estado_cedula_2 = false;
				}
			}

			if(estado_cedula_2==false){
				continue;
			}else if(estado_cedula_2==true){

				estado_definitivo = true;

				for(int i=0; i<contador_venderores; i++){

					if(arreglo_2[i].getCedula() == cedula_2){
						System.out.println("La cedula ya existe");
						estado_definitivo = false;
					}
				}

				if(estado_definitivo==false){
					continue;
				}

			}

			System.out.print("Ingrese el nombre del vendedor: ");
			String nombre_2 = cadenas.nextLine();

			System.out.print("Ingrese el apellido del vendedor: ");
			String apellido_2 = cadenas.nextLine();

			// Crear un objeto cliente

			Persona vendedor_regis = new Persona(nombre_2, apellido_2, cedula_2);

			// Guardar el objeto en el Arreglo

			arreglo_2[contador_venderores] = vendedor_regis;

			contador_venderores++;

		}else if(opcion == 3 ){


			System.out.println("Ingrese la cedula del cliente: ");
			int cedula_cliente = entrada.nextInt();

			for(int i=0; i<contador_clientes; i++){

				if(arreglo[i].getCedula() == cedula_cliente){
					System.out.println("Cliente encontrado: ");
					System.out.println("Nombre: " + arreglo[i].getNombre() + " " + arreglo[i].getApellido() + " Cedula: " + arreglo[i].getCedula());

					Persona vendedor_cliente = new Persona(arreglo[i].getNombre(), arreglo[i].getApellido(), arreglo[i].getCedula());

					arreglo_y[contador_clientes] = vendedor_cliente;


				}else{
					System.out.println("Cliente no encontrado");
				}

			}

			System.out.println("Ingrese la cedula del vendedor: ");
			int cedula_vendedor = entrada.nextInt();



			for(int i=0; i<contador_venderores; i++){

				if(arreglo_2[i].getCedula() == cedula_vendedor){
					System.out.println("Vendedor encontrado: ");
					System.out.println("Nombre: " + arreglo_2[i].getNombre() + " " + arreglo_2[i].getApellido() + " Cedula: " + arreglo_2[i].getCedula());

					Persona vendedor_factura = new Persona(arreglo_2[i].getNombre(), arreglo_2[i].getApellido(), arreglo_2[i].getCedula());

					arreglo_x[contador_clientes] = vendedor_factura;



				}else{
					System.out.println("Vendedor no encontrado");
				}
			}

			System.out.println("Ingrese la fecha de la factura: ");
			String fecha = cadenas.nextLine();

			fechas[contador_facturas] = fecha; 

			int opcion_productos = 0;

			int acum_productos = 0;

			int acum_total = 0;

			do {
				System.out.println("Que producto se van a comprar: ");
				System.out.println("1. Televisor");
				System.out.println("2. Nevera");
				System.out.println("3. Lavadora");
				System.out.println("4. Equipo de sonido");
				System.out.println("5. Salir");

				System.out.print("Ingrese una opcion: ");
				opcion_productos = entrada.nextInt();

				if(opcion_productos==1){
					System.out.println("Ingrese la cantidad de televisores que desea comprar: ");
					int cantidad_televisores = entrada.nextInt();

					acum_productos += cantidad_televisores;

					System.out.println("Ingrese el precio del televisor: ");
					int precio_televisor = entrada.nextInt();

					int total = cantidad_televisores * precio_televisor;

					acum_total += total;

					arreglo_total[contador_facturas] = acum_total;

					acum_total = 0;

					
				}else if(opcion_productos==2){
					System.out.println("Ingrese la cantidad de neveras que desea comprar: ");
					int cantidad_neveras = entrada.nextInt();

					acum_productos += cantidad_neveras;

					System.out.println("Ingrese el precio de la nevera: ");
					int precio_nevera = entrada.nextInt();

					int total = cantidad_neveras * precio_nevera;

					acum_total += total;

					arreglo_total[contador_facturas] = acum_total;

					


				}else if(opcion_productos==3){
					System.out.println("Ingrese la cantidad de lavadoras que desea comprar: ");
					int cantidad_lavadoras = entrada.nextInt();

					acum_productos += cantidad_lavadoras;

					System.out.println("Ingrese el precio de la lavadora: ");
					int precio_lavadora = entrada.nextInt();

					int total = cantidad_lavadoras * precio_lavadora;


					acum_total += total;

					arreglo_total[contador_facturas] = acum_total;

					

				}else if(opcion_productos==4){
					System.out.println("Ingrese la cantidad de equipos de sonido que desea comprar: ");
					int cantidad_equipos = entrada.nextInt();

					acum_productos += cantidad_equipos;

					System.out.println("Ingrese el precio del equipo de sonido: ");
					int precio_equipo = entrada.nextInt();

					int total = cantidad_equipos * precio_equipo;

					acum_total += total;

					arreglo_total[contador_facturas] = acum_total;

					

				}else if(opcion_productos==5){
					acum_total = 0;
					System.out.println("Gracias por su compra");
					System.out.println("");
					System.out.println(" ID FACTURA: " + contador_facturas);
					System.out.println(" Cantidad de productos: " + acum_productos);
					System.out.println(" Fecha: " + fecha);
					System.out.println(" Total a pagar: " + acum_total);
					
					contador_facturas++;


				}else{
					System.out.println("Opcion invalida");
				}
	
			} while (opcion_productos != 5);
			
		}else if( opcion == 4){
			System.out.println("Lista de los clientes: ");
			for(int i=0; i<contador_clientes; i++){
				System.out.println(i+"Nombre: " + arreglo[i].getNombre() + " " + arreglo[i].getApellido() + " --- Cedula: " + arreglo[i].getCedula());
			}
		}else if(opcion == 5){
			System.out.println("Lista de los vendedores: ");
			for(int i=0; i<contador_venderores; i++){
				System.out.println(i+"Nombre: " + arreglo_2[i].getNombre() + " " + arreglo_2[i].getApellido() + " --- Cedula: " + arreglo_2[i].getCedula());
			}
		}else if(opcion == 6){
			System.out.println("Lista de las facturas: ");
			System.out.println("");
			for(int i=0; i<contador_facturas; i++){
				System.out.println("Fecha: "+fechas[i]+" ---- ID FACTURA: "+contador_facturas+" --- Vendedor: "+arreglo_x[i].getNombre()+" --- Cliente: "+arreglo_y[i].getNombre()+" --- Total"+arreglo_total[i]);
			}
		}


	} while (opcion != 8);


    }
}