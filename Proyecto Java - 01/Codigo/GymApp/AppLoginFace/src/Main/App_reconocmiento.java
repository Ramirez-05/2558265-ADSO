package Main;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.Base64;
import javax.swing.*;


public class App_reconocmiento {
    private static Webcam webcam;
    private static WebcamPanel webcamPanel;
    private static JTextField inputCedula;
    
    public static void main(String[] args) throws IOException{
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
    
    private static void createAndShowGUI(){
        JFrame ventana = new JFrame("WEB CAM");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        webcam = Webcam.getDefault();
        WebcamResolution resolucio = WebcamResolution.VGA;
        webcam.setViewSize(resolucio.getSize());
        
        webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setFPSDisplayed(true);
        webcamPanel.setImageSizeDisplayed(true);
        
        JButton btnCapture = new JButton("Validar USUARIO");
        inputCedula = new JTextField();
        JLabel texto = new JLabel("INGRESE SU DOCUMENTO DE IDENTIDAD:");
        btnCapture.addActionListener((ActionEvent e) -> {
            capturarImg();
        });
        
        JPanel contntPane = new JPanel(new BorderLayout());
        
        contntPane.add(texto, BorderLayout.NORTH);
        contntPane.add(inputCedula, BorderLayout.NORTH);
        contntPane.add(webcamPanel, BorderLayout.CENTER);
        contntPane.add(btnCapture, BorderLayout.SOUTH);
        
        ventana.setContentPane(contntPane);
        ventana.setPreferredSize(new Dimension(640, 480));
        ventana.pack();
        ventana.setResizable(true);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true); 
    }
    
    private static void capturarImg(){
        BufferedImage img = webcam.getImage();
        
        //ENVIAR IMAGEN BASE64
        String base64Image = convertirImg64(img);
        System.out.println("Imagen en formato 64: \n" + base64Image);
    
        String msj = validar(base64Image);
        
        System.out.println(msj);
        JOptionPane.showMessageDialog(null, msj);
        
        
        /*// Guardar la imagen en el disco
        File outputFile = new File("captured_image.jpg");
        try {
            ImageIO.write(img, "JPEG", outputFile);
            System.out.println("Imagen capturada y almacenada en: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    
    private static String convertirImg64(BufferedImage imagen){
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            ImageIO.write(imagen, "JPEG", baos);
            byte[] bytes = baos.toByteArray();
            return Base64.getEncoder().encodeToString(bytes);
        } catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
    
    private static String validar(String img64){
        String respuestaServer = "Error algo falla D:";
        String imagen64 = img64;
        String imageBase64 = "data:image/jpeg;base64,"+imagen64;
        String userid = inputCedula.getText();
        //System.out.println("Nombre: "+userid);
        String url = "http://127.0.0.1:8000/validar_rostro";
        if(!userid.equalsIgnoreCase("")){
            try {
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            // Configurar la conexión
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Crear el cuerpo de la solicitud
            String json = "{\"image_data\": \"" + imageBase64 + "\", \"username\": \"" + userid + "\"}";
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
                //System.out.println(response.toString()); //Respuesta del servidor
                respuestaServer = response.toString();
            }
            connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace(); 
            }  
        }else{
            System.out.println("EL CAMPO NOMBRE ESTA VACIO");
        }
        return respuestaServer;
    }

}
