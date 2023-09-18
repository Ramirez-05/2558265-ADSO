package principal;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonSyntaxException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javax.swing.table.DefaultTableModel;


public class PanelListar extends javax.swing.JPanel {
    
    DefaultTableModel modelo;
    
    public PanelListar() {
        initComponents();
        initAlternComponents();
        cargarListapersonas();
    }
    
     public void initAlternComponents(){
        modelo = (DefaultTableModel) tablaPersonas.getModel();
    }
     
    public void cargarListapersonas() {

        ConsumoAPI ejemplo = new ConsumoAPI();

        String jsonResponse = ejemplo.consumoGET("http://localhost/APIenPHP/Obtener.php");

        if (jsonResponse != null) {
            try {
                Gson gson = new Gson();

                JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);

                JsonArray registros = jsonObject.getAsJsonArray("registros");

                modelo.setRowCount(0);

                for (int i = 0; i < registros.size(); i++) {
                    JsonObject usuario = registros.get(i).getAsJsonObject();
                    String cedula = String.valueOf(usuario.get("cedula").getAsInt());
                    String nombres = usuario.get("nombres").getAsString();
                    String apellidos = usuario.get("apellidos").getAsString();
                    String correo = usuario.get("email").getAsString();

                    Object[] fila = new Object[]{cedula, nombres, apellidos, correo};

                    modelo.addRow(fila);
                }
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPersonas = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTA DE USUARIOS");

        tablaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Correo"
            }
        ));
        jScrollPane1.setViewportView(tablaPersonas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPersonas;
    // End of variables declaration//GEN-END:variables
}
