package principal;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Principal {
    public static void main(String[] args) {
        
        ConsumoAPI ejemplo = new ConsumoAPI();
        
        // GET sin datos
        System.out.println("Consumo GET: " + ejemplo.consumoGET("http://localhost/APIenPHP/Obtener.php"));
        System.out.println("");
        String jsonResponse = ejemplo.consumoGET("http://localhost/APIenPHP/Obtener.php");
        
        if (jsonResponse != null) {
            // Crear una instancia de Gson
            Gson gson = new Gson();

            // Analizar el JSON en un objeto JSON
            JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);

            // Obtener el arreglo de registros
            JsonArray registros = jsonObject.getAsJsonArray("registros");

            // Iterar sobre los registros
            for (int i = 0; i < registros.size(); i++) {
                JsonObject registro = registros.get(i).getAsJsonObject();
                String nombres = registro.get("nombres").getAsString();
                System.out.println("Nombres: " + nombres);
            }
        } else {
            System.out.println("La respuesta de la API es nula o no válida.");
        }
        
        System.out.println("");
        
        // GET con Datos
        Map<String, String> getData = new HashMap<>();
        getData.put("cedula", "108805");
        System.out.println("Consumo SELECT: " + ejemplo.consumoGET("http://localhost/APIenPHP/getPersona.php", getData));
        
        // POST con Datos
        Map<String, String> insertData = new HashMap<>();
        insertData.put("cedula", "102200");
        insertData.put("nombres", "Oscar JAVA");
        insertData.put("apellidos", "Loaiza JAVA");
        insertData.put("telefono", "333333333");
        insertData.put("direccion", "Calle 20");
        insertData.put("email", "oscar@mail.com");
        System.out.println("Consumo INSERT: " + ejemplo.consumoPOST("http://localhost/APIenPHP/Insert.php", insertData));
        
        // POST con Datos
        Map<String, String> updateData = new HashMap<>();
        updateData.put("cedula", "102200");
        updateData.put("nombres", "Oscar JAVA UPDATE");
        updateData.put("apellidos", "Loaiza JAVA UPDATE");
        updateData.put("telefono", "333333");
        updateData.put("direccion", "Calle 20");
        updateData.put("email", "oscar@mail.com");
        System.out.println("Consumo UPDATE: " + ejemplo.consumoPOST("http://localhost/APIenPHP/Update.php", updateData));
        
        // POST con Datos
        Map<String, String> deleteData = new HashMap<>();
        deleteData.put("cedula", "102200");
        System.out.println("Consumo DELETE: " + ejemplo.consumoPOST("http://localhost/APIenPHP/Delete.php", deleteData));
        
    }    
}
