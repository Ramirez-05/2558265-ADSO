package principal;

import com.google.gson.JsonSyntaxException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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
    private String urlGlobal;
    private String[] nombres = {
            "back_default",
            "back_female",
            "back_shiny",
            "back_shiny_female",
            "front_default",
            "front_female",
            "front_shiny",
            "front_shiny_female"
        };
    private int currentIndex = 0;
    DefaultTableModel modelo;
    
    public MostrarPokemones(String url) {
        
        consumption = new ConsumoAPI();
        gson = new Gson();
        this.urlGlobal = url;
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
        btnSeguir = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setOpaque(false);

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

        imgPokemon.setBackground(new java.awt.Color(255, 255, 204));

        btnSeguir.setBackground(new java.awt.Color(255, 0, 0));
        btnSeguir.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnSeguir.setForeground(new java.awt.Color(0, 0, 0));
        btnSeguir.setText(">>");
        btnSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeguirActionPerformed(evt);
            }
        });

        btnAtras.setBackground(new java.awt.Color(51, 204, 0));
        btnAtras.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(0, 0, 0));
        btnAtras.setText("<<");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSeguir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgPokemon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnAtras)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(btnSeguir)
                .addContainerGap(106, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeguirActionPerformed
        avanzarImagenes();
    }//GEN-LAST:event_btnSeguirActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        retrocederImagenes();
    }//GEN-LAST:event_btnAtrasActionPerformed

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
                System.out.println("");
                System.out.println("URL DE HABILIDADES");
                for (int i = 0; i < abilities.size(); i++) {
                    JsonObject abilityObject = abilities.get(i).getAsJsonObject();
                    JsonObject ability = abilityObject.getAsJsonObject("ability");
                    String habilidadNombre = ability.get("name").getAsString();
                    String habilidadUrl = ability.get("url").getAsString();
                    System.out.println(habilidadUrl);

                    Object[] fila = new Object[]{habilidadNombre, habilidadUrl };

                    modelo.addRow(fila);
                }
                System.out.println("");
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void avanzarImagenes() {
         String responseJson = consumption.consumoGET(urlGlobal);

         if (responseJson != null) {
             try {
                 JsonObject tempJson = gson.fromJson(responseJson, JsonObject.class);
                 JsonObject spritesObject = tempJson.getAsJsonObject("sprites");
                 System.out.println("INDEX NEXT = " + currentIndex);

                 for (int i = currentIndex; i < nombres.length; i++) {
                     JsonElement element = spritesObject.get(nombres[i]);

                     if (element != null && !element.isJsonNull()) {
                         String imgCollected = element.getAsString();
                         System.out.println("Img Obtenida = " + imgCollected);
                         mostrarImagen(imgCollected);
                         currentIndex++;
                         break;
                     } else {
                         currentIndex++;
                     }
                 }

                 if (currentIndex >= nombres.length) {
                    AlertAvanzar alert = new AlertAvanzar();
                    alert.setVisible(true);

                    btnSeguir.setEnabled(false);
                    currentIndex = 7;
                }
                 btnAtras.setEnabled(true);

             } catch (JsonSyntaxException ex) {
                 ex.printStackTrace();
             }
         }
     }

      public void retrocederImagenes() {
        String responseJson = consumption.consumoGET(urlGlobal);

        if (responseJson != null) {
            try {
                JsonObject tempJson = gson.fromJson(responseJson, JsonObject.class);
                JsonObject spritesObject = tempJson.getAsJsonObject("sprites");
                System.out.println("INDEX PREV = " + currentIndex);

                for (int i = currentIndex; i >= 0; i--) {
                    JsonElement element = spritesObject.get(nombres[i]);

                    if (element != null && !element.isJsonNull()) {
                        String imgCollected = element.getAsString();
                        System.out.println("Img Obtenida = " + imgCollected);
                        mostrarImagen(imgCollected);
                        currentIndex--;
                        break;
                    } else {
                        currentIndex--;
                    }
                }

                if (currentIndex < 0) {
                    
                    AlertRetroceder alert = new AlertRetroceder();
                    alert.setVisible(true);
      
                    btnAtras.setEnabled(false);
                    currentIndex = 0;
                }
                
                btnSeguir.setEnabled(true);

            } catch (JsonSyntaxException ex) {
                ex.printStackTrace();
            }
        }
    }


    private void mostrarImagen(String imgUrl) {
         int width = 200;
         int height = 200;

         try {
             BufferedImage originalImage = ImageIO.read(new URL(imgUrl));

             if (originalImage != null) {
                 Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                 ImageIcon imageIcon = new ImageIcon(resizedImage);

                 // Actualiza la etiqueta imgPokemon con la nueva imagen
                 imgPokemon.setIcon(imageIcon);
             } else {
                 System.err.println("No se pudo cargar la imagen desde la URL: " + imgUrl);
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

     
    


    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnSeguir;
    private javax.swing.JLabel imgPokemon;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaHabilidades;
    // End of variables declaration//GEN-END:variables
}
