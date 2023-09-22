package principal;

import com.google.gson.JsonSyntaxException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;



public class MostrarPokemones extends javax.swing.JPanel {

    private ConsumoAPI consumption;
    private Gson gson;
    DefaultTableModel modelo;
    
    public MostrarPokemones(String url) {
        
        consumption = new ConsumoAPI();
        gson = new Gson();
        initComponents();
        initAlternComponets();
        mostrarInformacion(url);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHabilidades = new javax.swing.JTable();
        imgPokemon = new javax.swing.JLabel();

        tablaHabilidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Habilidades", "Url"
            }
        ));
        jScrollPane2.setViewportView(tablaHabilidades);

        imgPokemon.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(imgPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgPokemon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 51, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void initAlternComponets(){
       modelo = (DefaultTableModel) tablaHabilidades.getModel();
    }
    
    public void mostrarInformacion(String url){
        String responseJson  = consumption.consumoGET(url);
        
        if (responseJson != null) {
            try {
                JsonObject tempJson = gson.fromJson(responseJson, JsonObject.class);

                JsonObject spritesObject = tempJson.getAsJsonObject("sprites");

                if (spritesObject != null) {
                    // Acceder a la URL "front_default" dentro de 'spritesObject'
                    String dreamWorldFrontDefaultImageUrl = spritesObject.getAsJsonObject("other")
                        .getAsJsonObject("home")
                        .get("front_default")
                        .getAsString();

                    // Tamaño deseado para la imagen
                    int width = 200;
                    int height = 200;

                    ImageIcon imageIcon;

                    try {
                        // Cargar la imagen desde la URL
                        BufferedImage originalImage = ImageIO.read(new URL(dreamWorldFrontDefaultImageUrl));

                        if (originalImage != null) {
                            // Redimensionar la imagen al tamaño deseado
                            Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                            imageIcon = new ImageIcon(resizedImage);

                            imgPokemon.setIcon(imageIcon);
                            
                            mostrarHabilidades(url);
                            
                            
                            
                            
                            
                        } else {
                            System.err.println("No se pudo cargar la imagen desde la URL: " + dreamWorldFrontDefaultImageUrl);
                        }
                    } catch (IOException e) {  
                        e.printStackTrace();
                    }
                }
            } catch (JsonSyntaxException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void mostrarHabilidades(String url){
        String responseJson = consumption.consumoGET(url);

        if (responseJson != null) {
            try {
                JsonObject jsonObject = gson.fromJson(responseJson, JsonObject.class);

                JsonArray abilities = jsonObject.getAsJsonArray("abilities");

                modelo.setRowCount(0);

                for (int i = 0; i < abilities.size(); i++) {
                    JsonObject abilityObject = abilities.get(i).getAsJsonObject();
                    JsonObject ability = abilityObject.getAsJsonObject("ability");
                    String habilidadNombre = ability.get("name").getAsString();
                    String habilidadUrl = ability.get("url").getAsString();
                    System.out.println(habilidadUrl);

                    Object[] fila = new Object[]{habilidadNombre, habilidadUrl };

                    modelo.addRow(fila);
                }
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgPokemon;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaHabilidades;
    // End of variables declaration//GEN-END:variables
}
