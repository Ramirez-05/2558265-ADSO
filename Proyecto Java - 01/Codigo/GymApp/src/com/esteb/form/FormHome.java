
package com.esteb.form;
import Clases.DataBase;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;



public class FormHome extends javax.swing.JPanel {
    
    DataBase basedatos;
    DefaultTableModel modelo;
    
    
    public FormHome( DataBase basedatos) {
        this.basedatos = basedatos;
        initComponents();
        initAlternComponents();
        contarSuscripcionesActivas();
        mostrarMontosTotales();
        cargarListapersonas();
        setOpaque(false);
    }
    
    public void initAlternComponents(){
        modelo = (DefaultTableModel) tablaPersonas.getModel();
        tablaPersonas.setModel(modelo);

        modelo.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int tipoEvento = e.getType();
                int fila = e.getFirstRow();
                int columna = e.getColumn();

                // Verificar si se modificó una celda específica
                if (fila != TableModelEvent.HEADER_ROW && columna != TableModelEvent.ALL_COLUMNS) {
                    String valorAntes = (String) modelo.getValueAt(fila, columna); // Valor antes del cambio
                    String valorDespues = (String) modelo.getValueAt(fila, columna); // Valor después del cambio

                    System.out.println("Tipo de evento: " + tipoEvento);
                    System.out.println("Fila: " + fila);
                    System.out.println("Columna: " + columna);
                    System.out.println("Valor antes del cambio: " + valorAntes);
                    System.out.println("Valor después del cambio: " + valorDespues);
                }
            }
        });
    }


     
      public void cargarListapersonas() {
        ResultSet listado = this.basedatos.listaPersonas();

        if (listado != null) {
            try {
                modelo.setRowCount(0);
                while (listado.next()) {
                    String nombres = listado.getString("nombre");
                    String apellidos = listado.getString("apellido");
                    String fecha_inicio = listado.getString("fecha_inicio");
                    String fin_sub = listado.getString("fecha_fin");

                    Object[] fila = new Object[]{nombres, apellidos, fecha_inicio, fin_sub};
                    modelo.addRow(fila);
                }
            } catch (SQLException ex) {
                System.out.println("Error al extraer datos: " + ex.getMessage());
            }
        } else {
            System.out.println("LISTA VACIA");
        }
    }
      
     public void contarSuscripcionesActivas() {
        int contadorSub = this.basedatos.contarSuscripciones();

        // Convertir el valor entero a una cadena de texto
        String textoContador = String.valueOf(contadorSub);

        // Establecer el texto en el componente suscriptores_info
        suscriptores_info.setText(textoContador);
    }
     
    
    public void mostrarMontosTotales() {
        ResultSet precios = this.basedatos.buscarPrecios();

        if (precios != null) {
            try {
                int montoTotal = 0;

                while (precios.next()) {
                    int precio = (int) precios.getDouble("precio");
                    montoTotal += precio;
                }
                
                // Convertir el valor entero a una cadena de texto
                String textoContador = String.valueOf("$ "+montoTotal);
                

                Valor_Ganancias.setText(textoContador);
                
                
            } catch (SQLException ex) {
                System.out.println("Error al extraer datos: " + ex.getMessage());
            }
        } else {
            System.out.println("No se encontraron precios de suscripciones");
        }
    }
 
      
    
  

     
      
      
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel2 = new com.esteb.swing.RoundPanel(new Color(14,169,224), new Color(2,97,231));
        labelinfoGanancias = new javax.swing.JLabel();
        Valor_Ganancias = new javax.swing.JLabel();
        Descipcion_Ganancias = new javax.swing.JLabel();
        roundPanel3 = new com.esteb.swing.RoundPanel(new Color(246,107,48), new Color(244,153,85));
        label_suscriptores = new javax.swing.JLabel();
        suscriptores_info = new javax.swing.JLabel();
        roundPanel1 = new com.esteb.swing.RoundPanel(Color.WHITE, Color.WHITE);
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPersonas = new com.esteb.swing.table.Table();

        roundPanel2.setBackground(new java.awt.Color(0, 0, 0));

        labelinfoGanancias.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        labelinfoGanancias.setForeground(new java.awt.Color(255, 255, 255));
        labelinfoGanancias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelinfoGanancias.setText("GANANCIAS MENSUALES");

        Valor_Ganancias.setFont(new java.awt.Font("Bahnschrift", 0, 70)); // NOI18N
        Valor_Ganancias.setForeground(new java.awt.Color(255, 255, 255));
        Valor_Ganancias.setText("$9.000.000");
        Valor_Ganancias.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Descipcion_Ganancias.setBackground(new java.awt.Color(204, 204, 204));
        Descipcion_Ganancias.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Descipcion_Ganancias.setForeground(new java.awt.Color(204, 204, 204));
        Descipcion_Ganancias.setText("Esto representa ganancias estimadas");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Valor_Ganancias, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelinfoGanancias)
                            .addComponent(Descipcion_Ganancias))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(labelinfoGanancias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Valor_Ganancias, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descipcion_Ganancias)
                .addGap(22, 22, 22))
        );

        roundPanel3.setBackground(new java.awt.Color(60, 60, 60));

        label_suscriptores.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label_suscriptores.setForeground(new java.awt.Color(255, 255, 255));
        label_suscriptores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_suscriptores.setText("SUSCRIPTORES ACTIVOS");

        suscriptores_info.setFont(new java.awt.Font("Bahnschrift", 0, 90)); // NOI18N
        suscriptores_info.setForeground(new java.awt.Color(255, 255, 255));
        suscriptores_info.setText("100");
        suscriptores_info.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(suscriptores_info)
                    .addComponent(label_suscriptores))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(label_suscriptores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(suscriptores_info, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Suscripcion", "Fin Suscripcion"
            }
        ));
        tablaPersonas.setEnabled(false);
        jScrollPane1.setViewportView(tablaPersonas);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Descipcion_Ganancias;
    private javax.swing.JLabel Valor_Ganancias;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_suscriptores;
    private javax.swing.JLabel labelinfoGanancias;
    private com.esteb.swing.RoundPanel roundPanel1;
    private com.esteb.swing.RoundPanel roundPanel2;
    private com.esteb.swing.RoundPanel roundPanel3;
    private javax.swing.JLabel suscriptores_info;
    private com.esteb.swing.table.Table tablaPersonas;
    // End of variables declaration//GEN-END:variables
}
