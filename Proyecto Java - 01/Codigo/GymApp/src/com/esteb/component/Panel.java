
package com.esteb.component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import com.esteb.swing.ButtonOutLine;
import java.awt.Color;
import java.awt.*;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;

public class Panel extends javax.swing.JPanel {
    private ActionListener event;
    private MigLayout layout;
    
    public Panel() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]20[]30[]push");
        setLayout(layout);
        init();
    }
    
    private void init(){
        JLabel title = new JLabel("Bienvenido!");
        title.setFont(new Font("REM", 1, 30));
        title.setForeground(Color.white);
        add(title);
        
        JLabel txtAux = new JLabel("<html><div style='text-align: center;'>Aquí podrás gestionar y supervisar de manera eficiente todas las actividades relacionadas con los usuarios. ¡Comienza a administrar con facilidad y lleva el control de todo en un solo lugar!!</div></html>");
        txtAux.setFont(new Font("Inconsolata", 1, 12));
        txtAux.setForeground(new Color(194, 194, 194));
        add(txtAux);
        
        ButtonOutLine btnMas = new ButtonOutLine();
        btnMas.setBackground(new Color(36,107,254));
        btnMas.setForeground(Color.white);
        btnMas.setText("Saber Más");
        
        btnMas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "https://youtu.be/zHdwVVra1zk?t=170";
                System.out.println("SI SIRVO PERO NO SE QUE VOY A HACER :)");
                JOptionPane.showMessageDialog(null, "No sabia que poner sjksjs");
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        add(btnMas, "w 40%, h 40");  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        GradientPaint gra = new GradientPaint(0, 0,new Color(15, 18, 35), 0, getHeight(), new Color(25, 30, 58));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs); 
    }
    
    public void addEvent(ActionListener event){
        this.event = event;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
