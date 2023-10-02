
package principal;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;

import com.google.gson.JsonSyntaxException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.GridLayout;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Menu extends javax.swing.JFrame {

    private ConsumoAPI consumption;
    private Gson gson;
    private int currentPage = 1;
    
    public Menu() {
        consumption = new ConsumoAPI();
        gson = new Gson();
        initComponents();
        initAlternComponets();  
        
        // Centrar la ventana en la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        int frameWidth = getWidth();
        int frameHeight = getHeight();
        setLocation((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2);

        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        MostrarInformacion = new javax.swing.JPanel();
        MostrarBotones = new javax.swing.JPanel();
        Buttons = new javax.swing.JPanel();
        pagination = new javax.swing.JPanel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        MostrarInformacion.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout MostrarInformacionLayout = new javax.swing.GroupLayout(MostrarInformacion);
        MostrarInformacion.setLayout(MostrarInformacionLayout);
        MostrarInformacionLayout.setHorizontalGroup(
            MostrarInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        MostrarInformacionLayout.setVerticalGroup(
            MostrarInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );

        MostrarBotones.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout MostrarBotonesLayout = new javax.swing.GroupLayout(MostrarBotones);
        MostrarBotones.setLayout(MostrarBotonesLayout);
        MostrarBotonesLayout.setHorizontalGroup(
            MostrarBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        MostrarBotonesLayout.setVerticalGroup(
            MostrarBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        Buttons.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout ButtonsLayout = new javax.swing.GroupLayout(Buttons);
        Buttons.setLayout(ButtonsLayout);
        ButtonsLayout.setHorizontalGroup(
            ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ButtonsLayout.setVerticalGroup(
            ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

        pagination.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout paginationLayout = new javax.swing.GroupLayout(pagination);
        pagination.setLayout(paginationLayout);
        paginationLayout.setHorizontalGroup(
            paginationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        paginationLayout.setVerticalGroup(
            paginationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MostrarBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MostrarInformacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Buttons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pagination, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MostrarInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MostrarBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pagination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public void initAlternComponets() {
        
        String consumingApi = consumption.consumoGET("https://pokeapi.co/api/v2/pokemon");
        if (consumingApi != null) {
            try {
                JsonObject jsonObject = gson.fromJson(consumingApi, JsonObject.class);

                JsonArray results = jsonObject.getAsJsonArray("results");
                
                
                JsonElement nextElement = jsonObject.get("next");
                String siguiente = (nextElement != null && !nextElement.isJsonNull()) ? nextElement.getAsString() : null;

                JsonElement previousElement = jsonObject.get("previous");
                String atras = (previousElement != null && !previousElement.isJsonNull()) ? previousElement.getAsString() : null;
                
               
                crearBotones(results);
                pagination(siguiente,atras);

            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        }  
    }

    public void crearBotones(JsonArray results ) {
        
        MostrarBotones.removeAll();

        MostrarBotones.setLayout(new GridLayout(0, 4)); // 4 columnas, filas automáticas
        
        Font font = new Font("Arial", Font.BOLD, 14);

        for (int i = 0; i < results.size(); i++) {
            JsonObject pokemonData = results.get(i).getAsJsonObject();
            String nombre = pokemonData.get("name").getAsString();
            String url = pokemonData.get("url").getAsString();

            JButton boton = new JButton(nombre);

            // Configura la URL del Pokémon como el ActionCommand del botón
            boton.setActionCommand(url);
            
            boton.setFont(font);

            
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
 
                    String urlPokemonInfo = e.getActionCommand();
                    System.out.println("URL del Pokémon: " + urlPokemonInfo);
                    
                    MostrarInformacion.removeAll();
                    
                    MostrarPokemones mostrarPokemones = new MostrarPokemones(urlPokemonInfo);
                    mostrarPokemones.setSize(MostrarInformacion.getSize() );
                    MostrarInformacion.add( mostrarPokemones );

                    repaint();
                    revalidate();
                }
            });

            MostrarBotones.add(boton); 
        }
        MostrarBotones.revalidate();
        
    }
   
     public void pagination(String siguiente, String atras) {
        
        pagination.removeAll();
        
        JButton botonAtras = new JButton("Atrás");
        botonAtras.setBackground(Color.GREEN);
        
        JButton botonSiguiente = new JButton("Siguiente");
        botonSiguiente.setBackground(Color.RED); 
        
        if (atras != null) {
            botonAtras.setActionCommand(atras);
            botonAtras.setEnabled(true); 
        } else {
            botonAtras.setEnabled(false); 
        }
     
         if (siguiente != null) {
            botonSiguiente.setActionCommand(siguiente);
            botonSiguiente.setEnabled(true); 
        } else {
            botonSiguiente.setEnabled(false); 
        }

        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("URL del siguinete: " + siguiente);
                
                actualizarContenido(siguiente);
            }
        });
        
        botonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("URL atras: " + atras);
                actualizarContenido(atras);
 
            }
        });
        
        botonAtras.setPreferredSize(new Dimension(100, 40));
        botonSiguiente.setPreferredSize(new Dimension(100, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0; 
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre botones

        pagination.setLayout(new GridBagLayout()); 
        pagination.add(botonAtras, gbc);

        gbc.gridx = 1;
        pagination.add(botonSiguiente, gbc);

        pagination.revalidate();
    }
    
    public void buttons(String siguiente, String atras) {

        Buttons.removeAll();
        
        Font font = new Font("Arial", Font.BOLD, 14);
        
        JButton botonAtras = new JButton("Atrás");
        botonAtras.setBackground(Color.GREEN);
        botonAtras.setForeground(Color.BLACK);
        botonAtras.setFont(font);

        JButton botonSiguiente = new JButton("Siguiente");
        botonSiguiente.setBackground(Color.RED); 
        botonSiguiente.setForeground(Color.BLACK);
        botonSiguiente.setFont(font);

        // -----  verificar si no llego nulo para no deshabilitar
        botonAtras.setActionCommand(atras);
        botonAtras.setEnabled(atras != null);

        botonSiguiente.setActionCommand(siguiente);
        botonSiguiente.setEnabled(siguiente != null);
        // -----    
        
        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("URL del siguinete: " + siguiente);

                actualizarContenido(siguiente);
            }
        });

        botonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("URL atras: " + atras);
                actualizarContenido(atras);

            }
        });

        botonAtras.setPreferredSize(new Dimension(100, 40));
        botonSiguiente.setPreferredSize(new Dimension(100, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0; 
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre botones

        Buttons.setLayout(new GridBagLayout()); 
        Buttons.add(botonAtras, gbc);

        gbc.gridx = 1;
        Buttons.add(botonSiguiente, gbc);

        Buttons.revalidate();
    }

    public void actualizarContenido(String urlPokemon){
        
        String responseJson  = consumption.consumoGET(urlPokemon);
        
        if (responseJson  != null){
            try {
                JsonObject tempJson = gson.fromJson(responseJson , JsonObject.class);

                JsonArray results = tempJson.getAsJsonArray("results");

                JsonElement nextElement = tempJson.get("next");
                String siguiente = (nextElement != null && !nextElement.isJsonNull()) ? nextElement.getAsString() : null;

                JsonElement previousElement = tempJson.get("previous");
                String atras = (previousElement != null && !previousElement.isJsonNull()) ? previousElement.getAsString() : null;

                crearBotones(results);

                pagination(siguiente, atras);

            } catch (JsonSyntaxException ex) {
                ex.printStackTrace();
            }
        }
        
        
    }
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
                
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Buttons;
    private javax.swing.JPanel MostrarBotones;
    private javax.swing.JPanel MostrarInformacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pagination;
    // End of variables declaration//GEN-END:variables
}
