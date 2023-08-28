
package Main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class testv2 {
    public static void main(String[] args) {
        String imagen64 = "";
        String imageBase64 = "data:image/jpeg;base64,"+imagen64; // Coloca aquí tu cadena de imagen en formato base64
        String url = "http://127.0.0.1:8000/validar_rostro"; // Reemplaza con la URL adecuada

        try {
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            // Configurar la conexión
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Crear el cuerpo de la solicitud
            String json = "{\"image_data\": \"" + imageBase64 + "\"}";
            try (DataOutputStream outStream = new DataOutputStream(connection.getOutputStream())) {
                outStream.writeBytes(json);
                outStream.flush();
            }

            // Leer la respuesta del servidor
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                System.out.println(response.toString()); // Imprimir la respuesta del servidor
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
