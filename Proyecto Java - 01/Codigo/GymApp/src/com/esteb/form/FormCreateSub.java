
package com.esteb.form;

import Clases.DataBase;
import com.esteb.component.AlertConfirmarSUB;
import java.awt.Color;
import raven.glasspanepopup.GlassPanePopup;


public class FormCreateSub extends javax.swing.JPanel {

    DataBase basedatos;
    
    public FormCreateSub(DataBase basedatos) {
        this.basedatos = basedatos;
        initComponents();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new com.esteb.swing.RoundPanel(new Color(25,28,36), new Color(25,28,36));
        input_descrip = new textfield.TextFieldv2();
        input_precio = new textfield.TextFieldv2();
        input_nombre = new textfield.TextFieldv2();
        label_documento = new javax.swing.JLabel();
        label_documento1 = new javax.swing.JLabel();
        label_documento2 = new javax.swing.JLabel();
        btn_crearNueva = new com.esteb.swing.ButtonCudrado();
        label_documento3 = new javax.swing.JLabel();
        input_dias = new textfield.TextFieldv2();

        input_descrip.setFont(new java.awt.Font("Roboto Mono", 0, 14)); // NOI18N

        input_precio.setFont(new java.awt.Font("Roboto Mono", 0, 14)); // NOI18N

        input_nombre.setFont(new java.awt.Font("Roboto Mono", 0, 14)); // NOI18N

        label_documento.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_documento.setForeground(new java.awt.Color(255, 255, 255));
        label_documento.setText("Nombre de la Suscripcion:");

        label_documento1.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_documento1.setForeground(new java.awt.Color(255, 255, 255));
        label_documento1.setText("Descripcion:");

        label_documento2.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_documento2.setForeground(new java.awt.Color(255, 255, 255));
        label_documento2.setText("Precio");

        btn_crearNueva.setBackground(new java.awt.Color(0, 119, 228));
        btn_crearNueva.setForeground(new java.awt.Color(255, 255, 255));
        btn_crearNueva.setText("CREAR SUSCRIPCION");
        btn_crearNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearNuevaActionPerformed(evt);
            }
        });

        label_documento3.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_documento3.setForeground(new java.awt.Color(255, 255, 255));
        label_documento3.setText("Dias");

        input_dias.setFont(new java.awt.Font("Roboto Mono", 0, 14)); // NOI18N

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(input_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(input_descrip, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(bgLayout.createSequentialGroup()
                                    .addComponent(label_documento2)
                                    .addGap(255, 255, 255)
                                    .addComponent(label_documento3)
                                    .addGap(221, 221, 221))
                                .addGroup(bgLayout.createSequentialGroup()
                                    .addComponent(input_precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(38, 38, 38)
                                    .addComponent(input_dias, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_documento)
                                    .addComponent(label_documento1)))))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(btn_crearNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(label_documento)
                .addGap(0, 0, 0)
                .addComponent(input_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_documento1)
                .addGap(0, 0, 0)
                .addComponent(input_descrip, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(label_documento2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btn_crearNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(label_documento3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_dias, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crearNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearNuevaActionPerformed
        AlertConfirmarSUB obj = new AlertConfirmarSUB();
        String nombre = input_nombre.getText();
        String descripcion = input_descrip.getText();
        String precio = input_precio.getText();
        String dias = input_dias.getText();
        
        int valor = Integer.parseInt(precio);
        int dia = Integer.parseInt(dias);
        boolean crearSub = this.basedatos.crearSub(nombre,descripcion,valor,dia);
        if(crearSub){
            input_nombre.setText("");
            input_descrip.setText("");
            input_precio.setText("");
            input_dias.setText("");
            input_nombre.requestFocus();
            GlassPanePopup.showPopup(obj);
        }else{
            System.out.println("ALGO SE PUTIO");
        }
    }//GEN-LAST:event_btn_crearNuevaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.esteb.swing.RoundPanel bg;
    private com.esteb.swing.ButtonCudrado btn_crearNueva;
    private textfield.TextFieldv2 input_descrip;
    private textfield.TextFieldv2 input_dias;
    private textfield.TextFieldv2 input_nombre;
    private textfield.TextFieldv2 input_precio;
    private javax.swing.JLabel label_documento;
    private javax.swing.JLabel label_documento1;
    private javax.swing.JLabel label_documento2;
    private javax.swing.JLabel label_documento3;
    // End of variables declaration//GEN-END:variables
}
