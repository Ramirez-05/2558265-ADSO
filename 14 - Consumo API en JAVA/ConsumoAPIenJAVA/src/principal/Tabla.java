
package principal;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Tabla extends javax.swing.JPanel {
    
    JsonObject jsonObject;
    DefaultTableModel modelo;
    
    public Tabla(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
        initComponents();
        initAlternComponents();
        cargarListaPersonas(jsonObject);
    }
    
    
    public void initAlternComponents(){
        modelo = (DefaultTableModel) Tabla_usuarios.getModel();
    }
    
    public void cargarListaPersonas(JsonObject jsonObject){
        
        if (jsonObject != null){
            
            JsonArray registros = jsonObject.getAsJsonArray("registros");
            
            if(registros != null){
                
                 modelo.setRowCount(0);

                for (int i = 0; i < registros.size(); i++) {
                    JsonObject registro = registros.get(i).getAsJsonObject();
                    String cedula = registro.get("Cedula").getAsString();
                    String nombre = registro.get("Nombre").getAsString();
                    String apellido = registro.get("Apellido").getAsString();
                    String email = registro.get("Email").getAsString();

                    modelo.addRow(new Object[]{cedula, nombre, apellido, email});
                }
            } 
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_usuarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        Tabla_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Email"
            }
        ));
        jScrollPane1.setViewportView(Tabla_usuarios);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Email"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_usuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
