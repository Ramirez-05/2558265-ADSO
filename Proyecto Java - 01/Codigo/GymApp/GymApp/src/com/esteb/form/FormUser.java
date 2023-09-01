
package com.esteb.form;

import Clases.DataBase;
import com.esteb.component.AlertEditar;
import com.esteb.component.AlertEspere;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.Notification;
import javax.swing.SwingUtilities;
import raven.glasspanepopup.GlassPanePopup;


public class FormUser extends javax.swing.JPanel {

    DataBase basedatos;
    
    public FormUser(DataBase basedatos) {
        this.basedatos = basedatos;
        initComponents();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new com.raven.datechoosernormal.DateChoosernormal();
        Panel_UserData = new com.esteb.swing.RoundPanel(new Color(25,28,36), new Color(25,28,36));
        label_direccion = new javax.swing.JLabel();
        label_telefono = new javax.swing.JLabel();
        label_emergenci = new javax.swing.JLabel();
        input_nombre = new textfield.TextFieldv2();
        label_rh = new javax.swing.JLabel();
        input_documento = new textfield.TextFieldv2();
        label_nombre = new javax.swing.JLabel();
        input_nacimiento = new textfield.TextFieldv2();
        input_apellido = new textfield.TextFieldv2();
        input_RH = new textfield.TextFieldv2();
        label_apellido = new javax.swing.JLabel();
        label_documento = new javax.swing.JLabel();
        label_sexo1 = new javax.swing.JLabel();
        input_discapcidad = new textfield.TextFieldv2();
        label_nacimiento = new javax.swing.JLabel();
        input_email = new textfield.TextFieldv2();
        input_emergencia = new textfield.TextFieldv2();
        input_telefono = new textfield.TextFieldv2();
        label_email = new javax.swing.JLabel();
        input_direccion = new textfield.TextFieldv2();
        select_sexo = new com.esteb.swing.MyCombobox();
        input_documentoBuscar = new textfield.TextFieldv2();
        label_documento1 = new javax.swing.JLabel();
        btn_buscarUsuario = new com.esteb.swing.ButtonOutLineCuadraro();
        Panel_PayData = new com.esteb.swing.RoundPanel(new Color(25,28,36), new Color(25,28,36));
        Select_Suscripcion = new com.esteb.swing.MyCombobox();
        Select_TipoPago = new com.esteb.swing.MyCombobox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonOutLineCuadraro1 = new com.esteb.swing.ButtonOutLineCuadraro();
        btnEditar = new com.esteb.swing.ButtonOutLineCuadraro();

        date.setForeground(new java.awt.Color(21, 23, 29));
        date.setDateFormat("dd/MM/yyyy");
        date.setTextRefernce(input_nacimiento);

        label_direccion.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_direccion.setForeground(new java.awt.Color(255, 255, 255));
        label_direccion.setText("Direccion:");
        label_direccion.setEnabled(false);

        label_telefono.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_telefono.setForeground(new java.awt.Color(255, 255, 255));
        label_telefono.setText("Telefono:");
        label_telefono.setEnabled(false);

        label_emergenci.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_emergenci.setForeground(new java.awt.Color(255, 255, 255));
        label_emergenci.setText("Numero Emergencia:");
        label_emergenci.setEnabled(false);

        input_nombre.setEnabled(false);
        input_nombre.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        label_rh.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_rh.setForeground(new java.awt.Color(255, 255, 255));
        label_rh.setText("RH:");
        label_rh.setEnabled(false);

        input_documento.setEnabled(false);
        input_documento.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        label_nombre.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_nombre.setForeground(new java.awt.Color(255, 255, 255));
        label_nombre.setText("Nombre:");
        label_nombre.setEnabled(false);

        input_nacimiento.setEnabled(false);
        input_nacimiento.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        input_apellido.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        input_RH.setEnabled(false);
        input_RH.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        label_apellido.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_apellido.setForeground(new java.awt.Color(255, 255, 255));
        label_apellido.setText("Apellido:");
        label_apellido.setEnabled(false);

        label_documento.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_documento.setForeground(new java.awt.Color(255, 255, 255));
        label_documento.setText("Documento:");
        label_documento.setEnabled(false);

        label_sexo1.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_sexo1.setForeground(new java.awt.Color(255, 255, 255));
        label_sexo1.setText("Discapacidad Fisica:");
        label_sexo1.setEnabled(false);

        input_discapcidad.setEnabled(false);
        input_discapcidad.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        label_nacimiento.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_nacimiento.setForeground(new java.awt.Color(255, 255, 255));
        label_nacimiento.setText("Fecha Nacimiento:");
        label_nacimiento.setEnabled(false);

        input_email.setEnabled(false);
        input_email.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        input_emergencia.setEnabled(false);
        input_emergencia.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        input_telefono.setEnabled(false);
        input_telefono.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        label_email.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_email.setForeground(new java.awt.Color(255, 255, 255));
        label_email.setText("Correo:");
        label_email.setEnabled(false);

        input_direccion.setEnabled(false);
        input_direccion.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        select_sexo.setBackground(new java.awt.Color(25, 28, 36));
        select_sexo.setForeground(new java.awt.Color(255, 255, 255));
        select_sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MASCULINO", "FEMENINO" }));
        select_sexo.setSelectedIndex(-1);
        select_sexo.setEnabled(false);
        select_sexo.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N
        select_sexo.setLabeText("Sexo:");
        select_sexo.setLineColor(new java.awt.Color(13, 13, 13));

        input_documentoBuscar.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        label_documento1.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_documento1.setForeground(new java.awt.Color(255, 255, 255));
        label_documento1.setText("Documento:");

        btn_buscarUsuario.setForeground(new java.awt.Color(143, 95, 232));
        btn_buscarUsuario.setText("BUSCAR");
        btn_buscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_UserDataLayout = new javax.swing.GroupLayout(Panel_UserData);
        Panel_UserData.setLayout(Panel_UserDataLayout);
        Panel_UserDataLayout.setHorizontalGroup(
            Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_UserDataLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_UserDataLayout.createSequentialGroup()
                        .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel_UserDataLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(label_telefono)))
                        .addGap(10, 10, 10)
                        .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_email, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel_UserDataLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(label_email)))
                        .addGap(10, 10, 10)
                        .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel_UserDataLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(label_direccion))))
                    .addGroup(Panel_UserDataLayout.createSequentialGroup()
                        .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel_UserDataLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(label_documento)))
                        .addGap(10, 10, 10)
                        .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel_UserDataLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(label_nombre)))
                        .addGap(10, 10, 10)
                        .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel_UserDataLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(label_apellido))))
                    .addGroup(Panel_UserDataLayout.createSequentialGroup()
                        .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(input_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_UserDataLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(label_rh))
                            .addComponent(select_sexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_UserDataLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel_UserDataLayout.createSequentialGroup()
                                        .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(input_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(Panel_UserDataLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(label_nacimiento)))
                                        .addGap(10, 10, 10)
                                        .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(input_emergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(Panel_UserDataLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(label_emergenci))))
                                    .addComponent(input_discapcidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Panel_UserDataLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(label_sexo1))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_UserDataLayout.createSequentialGroup()
                        .addComponent(label_documento1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_documentoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_buscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        Panel_UserDataLayout.setVerticalGroup(
            Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_UserDataLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_documentoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_documento1)
                    .addComponent(btn_buscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel_UserDataLayout.createSequentialGroup()
                        .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_nombre)
                            .addComponent(label_apellido))
                        .addGap(0, 0, 0)
                        .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(input_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Panel_UserDataLayout.createSequentialGroup()
                        .addComponent(label_documento)
                        .addGap(0, 0, 0)
                        .addComponent(input_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel_UserDataLayout.createSequentialGroup()
                        .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_email)
                            .addComponent(label_direccion))
                        .addGap(0, 0, 0)
                        .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(input_email, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Panel_UserDataLayout.createSequentialGroup()
                        .addComponent(label_telefono)
                        .addGap(0, 0, 0)
                        .addComponent(input_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel_UserDataLayout.createSequentialGroup()
                        .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_nacimiento)
                            .addComponent(label_emergenci))
                        .addGap(0, 0, 0)
                        .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(input_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_emergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Panel_UserDataLayout.createSequentialGroup()
                        .addComponent(label_rh)
                        .addGap(0, 0, 0)
                        .addComponent(input_RH, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Panel_UserDataLayout.createSequentialGroup()
                        .addComponent(label_sexo1)
                        .addGap(0, 0, 0)
                        .addComponent(input_discapcidad, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_UserDataLayout.createSequentialGroup()
                        .addComponent(select_sexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );

        Select_Suscripcion.setBackground(new java.awt.Color(25, 28, 36));
        Select_Suscripcion.setForeground(new java.awt.Color(255, 255, 255));
        Select_Suscripcion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EASY - Recurrente Mensual", "VIP - Recurrente Mensual", "VIP ANUAL - Pago Ùnico" }));
        Select_Suscripcion.setSelectedIndex(-1);
        Select_Suscripcion.setEnabled(false);
        Select_Suscripcion.setFont(new java.awt.Font("Roboto Mono", 0, 14)); // NOI18N
        Select_Suscripcion.setLabeText("TIPO SUSCRIPCION:");
        Select_Suscripcion.setLineColor(new java.awt.Color(13, 13, 13));
        Select_Suscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select_SuscripcionActionPerformed(evt);
            }
        });

        Select_TipoPago.setBackground(new java.awt.Color(25, 28, 36));
        Select_TipoPago.setForeground(new java.awt.Color(255, 255, 255));
        Select_TipoPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EFECTIVO", "NEQUI", "DAVIPLATA", "BANCOLOMBIA", "DEBIT-CARD" }));
        Select_TipoPago.setSelectedIndex(-1);
        Select_TipoPago.setEnabled(false);
        Select_TipoPago.setFont(new java.awt.Font("Roboto Mono", 0, 14)); // NOI18N
        Select_TipoPago.setLabeText("MEDIO DE PAGO:");
        Select_TipoPago.setLineColor(new java.awt.Color(13, 13, 13));

        jLabel1.setFont(new java.awt.Font("Roboto Mono", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("0");

        jLabel2.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TOTAL PAGO:");

        buttonOutLineCuadraro1.setForeground(new java.awt.Color(0, 210, 91));
        buttonOutLineCuadraro1.setText("RENOVAR-SUSCRIPCION");
        buttonOutLineCuadraro1.setEnabled(false);

        btnEditar.setForeground(new java.awt.Color(255, 171, 0));
        btnEditar.setText("EDITAR-SUSCRIPCION");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_PayDataLayout = new javax.swing.GroupLayout(Panel_PayData);
        Panel_PayData.setLayout(Panel_PayDataLayout);
        Panel_PayDataLayout.setHorizontalGroup(
            Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PayDataLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_PayDataLayout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(buttonOutLineCuadraro1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_PayDataLayout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addGroup(Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(Panel_PayDataLayout.createSequentialGroup()
                        .addComponent(Select_Suscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(Select_TipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_PayDataLayout.setVerticalGroup(
            Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PayDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Select_Suscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Select_TipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOutLineCuadraro1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Panel_UserData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_PayData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Panel_UserData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Panel_PayData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        FormUser form = this;
        AlertEditar obj = new AlertEditar();
        if(!input_documentoBuscar.getText().isEmpty()){
            obj.eventOK(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Se dio click en aceptar de la alerta");  
                    String cedulaBuscar = input_documentoBuscar.getText();
                    String cedula = input_documento.getText();
                    String nombre = input_nombre.getText();
                    String apellido = input_apellido.getText();
                    String telefono = input_telefono.getText();
                    String correo = input_email.getText();
                    String direccion = input_direccion.getText();
                    String rh = input_RH .getText();
                    String fechaNacimiento = input_nacimiento.getText();
                    String numeroEmergencia = input_emergencia.getText();
                    String sexo = (String) select_sexo.getSelectedItem(); 
                    String discapacidad = input_discapcidad.getText();

                    int opc = 0;
                    switch (Select_Suscripcion.getSelectedIndex()) {
                        case 0 -> opc = 1;
                        case 1 -> opc = 2;
                        case 2 -> opc = 3;
                        default -> System.out.println("Algo Esta Mal");
                    }

                    int opcMedioPago = 0;
                    switch (Select_TipoPago.getSelectedIndex()) {
                        case 0 -> opcMedioPago = 1;
                        case 1 -> opcMedioPago = 2;
                        case 2 -> opcMedioPago = 3;
                        case 3 -> opcMedioPago = 4;
                        case 4 -> opcMedioPago = 5;
                    }


                    boolean respuesta = FormUser.this.basedatos.modificarPersona(cedulaBuscar,cedula, nombre, apellido, telefono,correo, direccion, rh, fechaNacimiento,numeroEmergencia,sexo,discapacidad,opc,opcMedioPago);
                    if(!respuesta){
                        input_documento.setText("");
                        input_nombre.setText("");
                        input_apellido.setText("");
                        input_telefono.setText("");
                        input_email.setText("");
                        input_direccion.setText("");
                        input_RH.setText("");
                        input_nacimiento.setText("");
                        input_discapcidad.setText("");

                        input_documento.requestFocus();

                        System.out.println("No Se Encontro El Usuario");
                    }else{
                        Frame frame = (Frame) SwingUtilities.getWindowAncestor(form); // Obtener el Frame
                        Notification noti = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Se ha actualizado la informacion de "+nombre);
                        noti.showNotification();
                    }
                    GlassPanePopup.closePopupLast();
                }
            });
            GlassPanePopup.showPopup(obj);
        }else{
            System.out.println("Esta Vacio");
            
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btn_buscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarUsuarioActionPerformed
        FormUser form = this;
        String cedula = input_documentoBuscar.getText();
        AlertEspere obj = new AlertEspere();
        GlassPanePopup.showPopup(obj);
        Thread verificacionThread = new Thread(() ->{
            ResultSet usuario = this.basedatos.buscarPersona(cedula);
            try {
                if(usuario != null && usuario.next()){
                    try {
                        input_nombre.setEnabled(true);
                        input_apellido.setEnabled(true);
                        input_telefono.setEnabled(true);
                        input_email.setEnabled(true);
                        input_direccion.setEnabled(true);
                        input_RH.setEnabled(true);
                        input_nacimiento.setEnabled(true);
                        input_emergencia.setEnabled(true);
                        select_sexo.setEnabled(true);
                        input_discapcidad.setEnabled(true);
                        Select_Suscripcion.setEnabled(true);
                        Select_TipoPago.setEnabled(true);
                        btnEditar.setEnabled(true);

                        input_documento.setText(usuario.getString("documento"));
                        input_nombre.setText(usuario.getString("nombre"));
                        input_apellido.setText(usuario.getString("apellido"));
                        input_telefono.setText(usuario.getString("telefono"));
                        input_email.setText(usuario.getString("correo"));
                        input_direccion.setText(usuario.getString("direccion"));
                        input_RH.setText(usuario.getString("rh"));
                        input_nacimiento.setText(usuario.getString("fechaNacimiento"));
                        input_emergencia.setText(usuario.getString("numero_emergencia"));

                        String sexo = usuario.getString("sexo");  // Obtener el valor de sexo desde el ResultSet

                        if (sexo.equals("MASCULINO")) {
                            select_sexo.setSelectedIndex(0);  // Establecer el índice del combo a 0 (Masculino)
                        } else if (sexo.equals("FEMENINO")) {
                            select_sexo.setSelectedIndex(1);  // Establecer el índice del combo a 1 (Femenino)
                        } else {
                            select_sexo.setSelectedIndex(-1);  // Si no es ni Masculino ni Femenino, deseleccionar el combo
                        }

                        input_discapcidad.setText(usuario.getString("discapacidad"));

                        int tipoSub = usuario.getInt("id_tipo");

                        if(tipoSub == 1){
                            Select_Suscripcion.setSelectedIndex(0);
                        }else if(tipoSub == 2){
                            Select_Suscripcion.setSelectedIndex(1);
                        }else{
                            Select_Suscripcion.setSelectedIndex(2);
                        }

                        int idPago = usuario.getInt("id_metodo");

                        if(idPago == 1){
                            Select_TipoPago.setSelectedIndex(0);
                        }else if(idPago == 2){
                            Select_TipoPago.setSelectedIndex(1);
                        }else if(idPago == 3){
                            Select_TipoPago.setSelectedIndex(2);
                        }else if(idPago == 4){
                            Select_TipoPago.setSelectedIndex(3);
                        }else{
                            Select_TipoPago.setSelectedIndex(4);
                        }
                        GlassPanePopup.closePopupLast();

                    }  catch (SQLException ex) {
                        System.out.println("Error en btn_buscarUsuarioActionPerformed: " + ex.getMessage());
                        ex.printStackTrace();  // Imprime el seguimiento de la pila para obtener más información
                    }
                }else{
                     GlassPanePopup.closePopupLast();
                    System.out.println("El usuario no esta");
                    Frame frame = (Frame) SwingUtilities.getWindowAncestor(form); // Obtener el Frame
                    Notification noti = new Notification(frame, Notification.Type.INFO, Notification.Location.TOP_CENTER, "EL USUARIO NO EXISTE!");
                    noti.showNotification();            }
            } catch (SQLException ex) {            
                Logger.getLogger(FormUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        verificacionThread.start();
    }//GEN-LAST:event_btn_buscarUsuarioActionPerformed

    private void Select_SuscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select_SuscripcionActionPerformed
        int selectedIndex = Select_Suscripcion.getSelectedIndex();
    
        if (selectedIndex == 0) {
            jLabel1.setText("90.000");
        } else if (selectedIndex == 1) {
            jLabel1.setText("390.000");
        } else if (selectedIndex == 2) {
            jLabel1.setText("590.000");
        }
    }//GEN-LAST:event_Select_SuscripcionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.esteb.swing.RoundPanel Panel_PayData;
    private com.esteb.swing.RoundPanel Panel_UserData;
    private com.esteb.swing.MyCombobox Select_Suscripcion;
    private com.esteb.swing.MyCombobox Select_TipoPago;
    private com.esteb.swing.ButtonOutLineCuadraro btnEditar;
    private com.esteb.swing.ButtonOutLineCuadraro btn_buscarUsuario;
    private com.esteb.swing.ButtonOutLineCuadraro buttonOutLineCuadraro1;
    private com.raven.datechoosernormal.DateChoosernormal date;
    private textfield.TextFieldv2 input_RH;
    private textfield.TextFieldv2 input_apellido;
    private textfield.TextFieldv2 input_direccion;
    private textfield.TextFieldv2 input_discapcidad;
    private textfield.TextFieldv2 input_documento;
    private textfield.TextFieldv2 input_documentoBuscar;
    private textfield.TextFieldv2 input_email;
    private textfield.TextFieldv2 input_emergencia;
    private textfield.TextFieldv2 input_nacimiento;
    private textfield.TextFieldv2 input_nombre;
    private textfield.TextFieldv2 input_telefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_apellido;
    private javax.swing.JLabel label_direccion;
    private javax.swing.JLabel label_documento;
    private javax.swing.JLabel label_documento1;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_emergenci;
    private javax.swing.JLabel label_nacimiento;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_rh;
    private javax.swing.JLabel label_sexo1;
    private javax.swing.JLabel label_telefono;
    private com.esteb.swing.MyCombobox select_sexo;
    // End of variables declaration//GEN-END:variables
}
