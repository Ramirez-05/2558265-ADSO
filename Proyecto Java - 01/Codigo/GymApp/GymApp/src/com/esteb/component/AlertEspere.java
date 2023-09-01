
package com.esteb.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import raven.glasspanepopup.GlassPanePopup;


public class AlertEspere extends javax.swing.JPanel {
    private String[] messages = {
        "ANDO HACIENCO COSITAS INTERNAS PORFAVOR ESPERAME",
        "ESTA DEMORANDO MAS DE LO ESPERADO :(",
        "LAMENTO EL TIEMPO QUE ESTAS ESPERANDO PERO NO ES NORMAL :("
    };
    
    private int messageIndex = 0;
    private String info;
    private Timer timer;
  
    public AlertEspere() {
        initComponents();
        setOpaque(false);
        // Crea un SimpleAttributeSet con alineación centrada
        SimpleAttributeSet centerAlignment = new SimpleAttributeSet();
        StyleConstants.setAlignment(centerAlignment, StyleConstants.ALIGN_CENTER);

        // Aplica el estilo al JTextPane
        StyledDocument doc = txt.getStyledDocument();
        doc.setParagraphAttributes(0, doc.getLength(), centerAlignment, false);
        
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setSelectionColor(new Color(48, 141, 236));
        txt.setOpaque(false);
        txt.setEnabled(false);

        // Utiliza SwingWorker para actualizar el texto en segundo plano
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i < messages.length; i++) {
                    if (isCancelled()) {
                        break;
                    }
                    txt.setText(messages[i]);
                     // Espera 2 segundos
                    if(i==1){
                        Thread.sleep(5000);
                    }else if(i==2){
                        Thread.sleep(6000);
                    }else{
                        Thread.sleep(3000);
                    }
                }
                return null;
            }

            @Override
            protected void done() {
            }
        };
        worker.execute();
    }
    
    @Override
    protected void paintComponent(Graphics grphcs){
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        g2.dispose();
        super.paintComponent(grphcs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt = new javax.swing.JTextPane();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 25, 25, 25));

        jLabel1.setBackground(new java.awt.Color(214, 217, 223));
        jLabel1.setFont(new java.awt.Font("Roboto Mono", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(79, 79, 79));
        jLabel1.setText("DAME TIEMPO :D");

        txt.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        txt.setForeground(new java.awt.Color(132, 132, 132));
        txt.setText("    ANDO HACIENCO COSITAS INTERNAS PORFAVOR ESPERAME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /*public void eventOK(ActionListener event){
        btnConfirmar.addActionListener(event);
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextPane txt;
    // End of variables declaration//GEN-END:variables
}
