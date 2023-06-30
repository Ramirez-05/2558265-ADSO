public class Main{
	public static void main(String[] args) {

        int indicePerosnasRegistradas = 6;

        Persona arrayPersonas[] = new Persona[100];

        arrayPersonas[0] = new Persona(0, "0", "Juan", "Perez", " 11", "Calle 42", "juan@gmial.com");
        arrayPersonas[1] = new Persona(1, "1", "Camilo", "Bedoya", " 12", "Calle 49", "pedro@gmail.com");
        arrayPersonas[2] = new Persona(2, "2", "Esteban", "Mesa", " 13", "Calle 71", "maria@gmail.com");
        arrayPersonas[3] = new Persona(3, "3", "Jaider", "Espinoza", " 14", "Calle 05", "luis@gmail.com");
        arrayPersonas[4] = new Persona(4, "4", "Julian", "Vasquez", " 15", "Calle 31", "carlos@gmail.com");
        arrayPersonas[5] = new Persona(5, "5", "Mateo", "herrera", " 16", "Calle 5", "andres@gmail.com");

        Crud ventana = new Crud(arrayPersonas, indicePerosnasRegistradas);
    }
}
