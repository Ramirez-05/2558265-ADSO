
public class Main{
	public static void main(String[] args) {

        Persona arrayClient[] = new Persona[10];
        arrayClient[0] = new Persona(1, "Juan", "Perez", 20, "Calle 1");
        arrayClient[1] = new Persona(2, "Maria", "Gomez", 30, "Calle 2");
        arrayClient[2] = new Persona(3, "Paco", "Suarez", 20, "Calle 3");
        arrayClient[3] = new Persona(4, "Luis", "Gonzalez", 20, "Calle 4");    
        arrayClient[4] = new Persona(5, "Pedro", "Garcia", 20, "Calle 5");
        arrayClient[5] = new Persona(6, "Ana", "Gutierrez", 20, "Calle 6");
        arrayClient[6] = new Persona(7, "Luisa", "Garcia", 20, "Calle 7");
        arrayClient[7] = new Persona(8, "Pablo", "Gomez", 20, "Calle 8");
        arrayClient[8] = new Persona(9, "Paco", "Gutierrez", 20, "Calle 9");
        arrayClient[9] = new Persona(10, "Luis", "Garcia", 20, "Calle 10");

        Persona arraySeller[] = new Persona[10];
        arraySeller[0] = new Persona(11, "Lucas", "Martin", 20, "Calle 70");
        arraySeller[1] = new Persona(22, "Sandra", "Gomez", 30, "Calle 71");
        arraySeller[2] = new Persona(33, "Luna", "Martinez", 20, "Calle 72");
        arraySeller[3] = new Persona(44, "Luis", "Diaz", 20, "Calle 73");
        arraySeller[4] = new Persona(55, "Leo", "Messi", 20, "Calle 74"); 
        arraySeller[5] = new Persona(66, "Cristiano", "Ronaldo", 20, "Calle 75");
        arraySeller[6] = new Persona(77, "Luis", "Suarez", 20, "Calle 76");
        arraySeller[7] = new Persona(88, "Andrea", "Pirlo", 20, "Calle 77");
        arraySeller[8] = new Persona(99, "Paco", "Gutierrez", 20, "Calle 78");

        Productos arrayProducts[] = new Productos[10];
        arrayProducts[0] = new Productos(1, "Arroz", 1000);
        arrayProducts[1] = new Productos(2, "Frijoles", 2000);
        arrayProducts[2] = new Productos(3, "Papa", 3000);
        arrayProducts[3] = new Productos(4, "Carne", 4000);
        arrayProducts[4] = new Productos(5, "Pollo", 5000);
        arrayProducts[5] = new Productos(6, "Pescado", 6000);
        arrayProducts[6] = new Productos(7, "Huevos", 7000);
        arrayProducts[7] = new Productos(8, "Leche", 8000);
        arrayProducts[8] = new Productos(9, "Pan", 9000);
        arrayProducts[9] = new Productos(10, "Sal", 10000);




        Factura ventana = new Factura(arrayClient, arraySeller, arrayProducts);

    }

}