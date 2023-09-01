
package com.esteb.form;

import Clases.DataBase;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javaswingdev.Notification;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;


public class FormCreateUser extends javax.swing.JPanel {
    
    DataBase basedatos;
    
    public FormCreateUser(DataBase basedatos) {
       this.basedatos = basedatos;
        initComponents();
        mostrarNombres();
        setOpaque(false);

        // Agregar un ActionListener al Select_Suscripcion
        Select_Suscripcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarFechas(); // Llama a la función que actualiza las fechas
            }
        });
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
        input_discapacidad = new textfield.TextFieldv2();
        label_nacimiento = new javax.swing.JLabel();
        input_email = new textfield.TextFieldv2();
        input_emergencia = new textfield.TextFieldv2();
        input_telefono = new textfield.TextFieldv2();
        label_email = new javax.swing.JLabel();
        input_direccion = new textfield.TextFieldv2();
        select_sexo = new com.esteb.swing.MyCombobox();
        Panel_PayData = new com.esteb.swing.RoundPanel(new Color(25,28,36), new Color(25,28,36));
        Select_Suscripcion = new com.esteb.swing.MyCombobox();
        Select_TipoPago = new com.esteb.swing.MyCombobox();
        totalPagar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_crearSuscripcion = new com.esteb.swing.ButtonOutLineCuadraro();
        IncioMembresia = new javax.swing.JLabel();
        label_InicioMem = new javax.swing.JLabel();
        FinMembresia = new javax.swing.JLabel();
        label_FinMen = new javax.swing.JLabel();

        date.setForeground(new java.awt.Color(21, 23, 29));
        date.setDateFormat("dd/MM/yyyy");
        date.setTextRefernce(input_nacimiento);

        label_direccion.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_direccion.setForeground(new java.awt.Color(255, 255, 255));
        label_direccion.setText("Direccion:");

        label_telefono.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_telefono.setForeground(new java.awt.Color(255, 255, 255));
        label_telefono.setText("Telefono:");

        label_emergenci.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_emergenci.setForeground(new java.awt.Color(255, 255, 255));
        label_emergenci.setText("Numero Emergencia:");

        input_nombre.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        label_rh.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_rh.setForeground(new java.awt.Color(255, 255, 255));
        label_rh.setText("RH:");

        input_documento.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N
        input_documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_documentoActionPerformed(evt);
            }
        });

        label_nombre.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_nombre.setForeground(new java.awt.Color(255, 255, 255));
        label_nombre.setText("Nombre:");

        input_nacimiento.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        input_apellido.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        input_RH.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        label_apellido.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_apellido.setForeground(new java.awt.Color(255, 255, 255));
        label_apellido.setText("Apellido:");

        label_documento.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_documento.setForeground(new java.awt.Color(255, 255, 255));
        label_documento.setText("Documento:");

        label_sexo1.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_sexo1.setForeground(new java.awt.Color(255, 255, 255));
        label_sexo1.setText("Discapacidad Fisica:");

        input_discapacidad.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        label_nacimiento.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_nacimiento.setForeground(new java.awt.Color(255, 255, 255));
        label_nacimiento.setText("Fecha Nacimiento:");

        input_email.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        input_emergencia.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        input_telefono.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        label_email.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        label_email.setForeground(new java.awt.Color(255, 255, 255));
        label_email.setText("Correo:");

        input_direccion.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N

        select_sexo.setBackground(new java.awt.Color(25, 28, 36));
        select_sexo.setForeground(new java.awt.Color(255, 255, 255));
        select_sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MASCULINO", "FEMENINO" }));
        select_sexo.setSelectedIndex(-1);
        select_sexo.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N
        select_sexo.setLabeText("Sexo:");
        select_sexo.setLineColor(new java.awt.Color(13, 13, 13));
        select_sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_sexoActionPerformed(evt);
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
                                    .addComponent(input_discapacidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Panel_UserDataLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(label_sexo1)))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        Panel_UserDataLayout.setVerticalGroup(
            Panel_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_UserDataLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
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
                        .addComponent(input_discapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_UserDataLayout.createSequentialGroup()
                        .addComponent(select_sexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addGap(30, 30, 30))
        );

        Select_Suscripcion.setBackground(new java.awt.Color(25, 28, 36));
        Select_Suscripcion.setForeground(new java.awt.Color(255, 255, 255));
        Select_Suscripcion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EASY - Recurrente Mensual", "VIP - Recurrente Mensual", "VIP ANUAL - Pago Ùnico" }));
        Select_Suscripcion.setSelectedIndex(-1);
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
        Select_TipoPago.setFont(new java.awt.Font("Roboto Mono", 0, 14)); // NOI18N
        Select_TipoPago.setLabeText("MEDIO DE PAGO:");
        Select_TipoPago.setLineColor(new java.awt.Color(13, 13, 13));

        totalPagar.setFont(new java.awt.Font("Roboto Mono", 1, 36)); // NOI18N
        totalPagar.setForeground(new java.awt.Color(255, 255, 255));
        totalPagar.setText("$0");

        jLabel2.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TOTAL PAGO:");

        btn_crearSuscripcion.setForeground(new java.awt.Color(255, 255, 255));
        btn_crearSuscripcion.setText("CONFIRMAR-SUSCRIPCION");
        btn_crearSuscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearSuscripcionActionPerformed(evt);
            }
        });

        IncioMembresia.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        IncioMembresia.setForeground(new java.awt.Color(255, 255, 255));
        IncioMembresia.setText("-----------");

        label_InicioMem.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N
        label_InicioMem.setForeground(new java.awt.Color(255, 255, 255));
        label_InicioMem.setText("INICIO MEMBRESÍA:");

        FinMembresia.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        FinMembresia.setForeground(new java.awt.Color(255, 255, 255));
        FinMembresia.setText("-----------");

        label_FinMen.setFont(new java.awt.Font("Roboto Mono", 0, 12)); // NOI18N
        label_FinMen.setForeground(new java.awt.Color(255, 255, 255));
        label_FinMen.setText("FIN DE MEMBRESÍA:");

        javax.swing.GroupLayout Panel_PayDataLayout = new javax.swing.GroupLayout(Panel_PayData);
        Panel_PayData.setLayout(Panel_PayDataLayout);
        Panel_PayDataLayout.setHorizontalGroup(
            Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PayDataLayout.createSequentialGroup()
                .addGroup(Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_PayDataLayout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(btn_crearSuscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_PayDataLayout.createSequentialGroup()
                        .addGroup(Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_PayDataLayout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(Select_Suscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_PayDataLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IncioMembresia)
                                    .addComponent(label_InicioMem))
                                .addGap(41, 41, 41)
                                .addGroup(Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FinMembresia)
                                    .addComponent(label_FinMen))))
                        .addGap(69, 69, 69)
                        .addGroup(Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Select_TipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_PayDataLayout.createSequentialGroup()
                                .addGroup(Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(totalPagar))
                                .addGap(67, 67, 67)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_PayDataLayout.setVerticalGroup(
            Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PayDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Select_Suscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Select_TipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_PayDataLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(totalPagar))
                    .addGroup(Panel_PayDataLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(Panel_PayDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Panel_PayDataLayout.createSequentialGroup()
                                .addComponent(label_InicioMem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IncioMembresia))
                            .addGroup(Panel_PayDataLayout.createSequentialGroup()
                                .addComponent(label_FinMen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FinMembresia)))
                        .addGap(31, 31, 31)
                        .addComponent(btn_crearSuscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Panel_PayData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_UserData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Panel_UserData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Panel_PayData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void input_documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_documentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_documentoActionPerformed
    
    private void btn_crearSuscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearSuscripcionActionPerformed
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
        String discapacidad = input_discapacidad.getText();
        
        String tipo_suscripcion = (String) Select_Suscripcion.getSelectedItem();
        ResultSet diasResultSet = this.basedatos.obtenerDias(tipo_suscripcion);
        
        if (cedula.isEmpty() && nombre.isEmpty() && apellido.isEmpty() && telefono.isEmpty() && correo.isEmpty() && direccion.isEmpty() && rh.isEmpty() && numeroEmergencia.isEmpty()) {
            Frame frame = (Frame) SwingUtilities.getWindowAncestor(this); // Obtener el Frame
            Notification noti = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Datos incompletos. Revisa y vuelve a intentarlo");
            noti.showNotification();
        }else{
            int dias = 0; // Valor por defecto
            int opc = 0; // con esto cogemos id
            try {
                if (diasResultSet.next()) {
                    dias = diasResultSet.getInt("dias");
                    opc = diasResultSet.getInt("id_tipo");
                }
            } catch (SQLException ex) {
                System.out.println("Error al obtener los días: " + ex.getMessage());
            }  

            //String medio_pago = (String) Select_TipoPago.getSelectedItem();

            int opcMedioPago = 0;
            switch (Select_TipoPago.getSelectedIndex()) {
                case 0 -> opcMedioPago = 1;
                case 1 -> opcMedioPago = 2;
                case 2 -> opcMedioPago = 3;
                case 3 -> opcMedioPago = 4;
                case 4 -> opcMedioPago = 5;
            }

            boolean cedulaExistente = this.basedatos.verificarCedulaExistente(cedula);
            if (cedulaExistente) {
                System.out.println("La cédula ya existe en la base de datos.");
                return; // No se procede a insertar la suscripción
            }

            boolean respuesta = this.basedatos.insertarPersona(cedula, nombre, apellido, telefono,correo, direccion, rh, fechaNacimiento,numeroEmergencia,sexo,discapacidad);
            if(!respuesta){
                input_documento.setText("");
                input_nombre.setText("");
                input_apellido.setText("");
                input_telefono.setText("");
                input_email.setText("");
                input_direccion.setText("");
                input_RH.setText("");
                input_nacimiento.setText("");
                input_discapacidad.setText("");

                input_documento.requestFocus();
            }

            boolean respuestaSub = this.basedatos.insertarSub(cedula, dias, opcMedioPago,opc);
            if(!respuestaSub){
                Select_Suscripcion.setSelectedIndex(-1);
                Select_TipoPago.setSelectedIndex(-1);
            }
        }
    }//GEN-LAST:event_btn_crearSuscripcionActionPerformed
    
    
    public void mostrarNombres() {
        ResultSet name = this.basedatos.obtenerNombresTiposSuscripcion();
        
        try {
            if (name!=null && name.getRow()==1) {
                    ArrayList<String> nombres = new ArrayList<String>();
                    nombres.add("----");
                    do{
                        nombres.add( name.getString("nombre") );
                    }while(name.next());
                    
                    Select_Suscripcion.setModel(new DefaultComboBoxModel( nombres.toArray() ));
            } else {
                System.out.println("No se encontraron precios de suscripciones");
            }
        } catch (SQLException ex) {
            System.out.println("Error al extraer datos: " + ex.getMessage());
        }
    }
    
    
    private void actualizarFechas() {
    String seleccion = (String) Select_Suscripcion.getSelectedItem(); // Obtén la opción seleccionada
    
    if (seleccion != null && !seleccion.equals("----")) {
        ResultSet resultados = basedatos.obtenerNombresTiposSuscripcion(); // Realiza la consulta nuevamente
        
        try {
            while (resultados.next()) {
                String nombre = resultados.getString("nombre");
                if (nombre.equals(seleccion)) {
                    String diasStr = resultados.getString("dias");
                    int dias = Integer.parseInt(diasStr);
                    
                    LocalDate fechaActual = LocalDate.now();
                    LocalDate fechaFin = fechaActual.plusDays(dias);
                    
                    String fechaInicioStr = fechaActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    String fechaFinStr = fechaFin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    
                    IncioMembresia.setText( fechaInicioStr);
                    FinMembresia.setText(fechaFinStr);
                    
                    break; // Termina el bucle al encontrar la opción seleccionada
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al extraer datos: " + ex.getMessage());
        }
    }
}
    
    
    
    
    private void select_sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_sexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_select_sexoActionPerformed

    private void Select_SuscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select_SuscripcionActionPerformed
         String nombre = (String) Select_Suscripcion.getSelectedItem();
        ResultSet preciosResultSet = this.basedatos.obtenerPrecios(nombre);
        try {
            if (preciosResultSet.next()) {
                int precio = preciosResultSet.getInt("precio");
                totalPagar.setText(String.valueOf(precio));
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener precios: " + ex.getMessage());
        } finally {
            // Asegúrate de cerrar el ResultSet cuando hayas terminado con él
            if (preciosResultSet != null) {
                try {
                    preciosResultSet.close();
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar ResultSet: " + ex.getMessage());
                }
            }
        }
       
       
       
    }//GEN-LAST:event_Select_SuscripcionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FinMembresia;
    private javax.swing.JLabel IncioMembresia;
    private com.esteb.swing.RoundPanel Panel_PayData;
    private com.esteb.swing.RoundPanel Panel_UserData;
    private com.esteb.swing.MyCombobox Select_Suscripcion;
    private com.esteb.swing.MyCombobox Select_TipoPago;
    private com.esteb.swing.ButtonOutLineCuadraro btn_crearSuscripcion;
    private com.raven.datechoosernormal.DateChoosernormal date;
    private textfield.TextFieldv2 input_RH;
    private textfield.TextFieldv2 input_apellido;
    private textfield.TextFieldv2 input_direccion;
    private textfield.TextFieldv2 input_discapacidad;
    private textfield.TextFieldv2 input_documento;
    private textfield.TextFieldv2 input_email;
    private textfield.TextFieldv2 input_emergencia;
    private textfield.TextFieldv2 input_nacimiento;
    private textfield.TextFieldv2 input_nombre;
    private textfield.TextFieldv2 input_telefono;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_FinMen;
    private javax.swing.JLabel label_InicioMem;
    private javax.swing.JLabel label_apellido;
    private javax.swing.JLabel label_direccion;
    private javax.swing.JLabel label_documento;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_emergenci;
    private javax.swing.JLabel label_nacimiento;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_rh;
    private javax.swing.JLabel label_sexo1;
    private javax.swing.JLabel label_telefono;
    private com.esteb.swing.MyCombobox select_sexo;
    private javax.swing.JLabel totalPagar;
    // End of variables declaration//GEN-END:variables
}
