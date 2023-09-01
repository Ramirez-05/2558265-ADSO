
package com.esteb.main;

import Clases.DataBase;
import net.miginfocom.swing.MigLayout;
import com.esteb.component.Panel;
import com.esteb.component.PanelLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
public class Main extends javax.swing.JFrame {
    private MigLayout layout;
    private Panel cover;
    private PanelLogin login;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private final DecimalFormat df = new DecimalFormat("##0.###");
    DataBase basedatos;
    
    public Main() {
        initComponents();
        init();
        
    }
    
    private void init(){
        setVisible(true);
        setLocationRelativeTo(null);
        layout = new MigLayout("fill, insets 0");
        cover = new Panel();
        login = new PanelLogin();
        /*TimingTarget target = new TimingTargetAdapter(){
            /*@Override
            public void timingEvent(float fraction) {
                double fractioncover;
                double fractionLogin;
                double size = coverSize;
                //INICIO FUNCIONA PARA CREAR EL EFECTO DE ALARGAMIENTO AL HACER EL DESPLAZAMIENTO
                if(fraction<=0.5f){
                    size += fraction * addSize;
                }else{
                    size += addSize - fraction * addSize;
                }
                //FIN
                
                //INICIO
                //DESPLAZAMIENTO
                if (isLogin) {
                    fractioncover = 1f - fraction;
                    fractionLogin = fraction;
                } else {
                    fractioncover = fraction;
                    fractionLogin = 1f - fraction;
                }
                //FIN
                if(fraction>=0.5){
                    login.mostrarRegister(isLogin);
                }
                //INICIO
                //ESTE FRACMENTO DE CODIGO SIRVE PARA LA TRANSFORMACION DE UN NUMERO QUE COMO DECIMAL
                //TIENE UNA , Y SE NECESITA CAMBIAR A UN . PARA GARANTIAZAR LA CONVERCION
                String formattedFraction = df.format(fractioncover);
                String formattedfracyionlogin = df.format(fractionLogin);
                formattedFraction = formattedFraction.replace(',', '.');
                formattedfracyionlogin = formattedfracyionlogin.replace(',', '.');
                fractioncover = Double.parseDouble(formattedFraction);
                fractionLogin = Double.parseDouble(formattedfracyionlogin);
               //FIN
                
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + String.valueOf(fractioncover) + "al 0 n 100%");
                layout.setComponentConstraints(login, "width " + loginSize + "%, pos " + String.valueOf(fractionLogin) + "al 0 n 100%");
                bg.revalidate();
            }?

            @Override
            
        };*/
        
        //Animator animator = new Animator(1000, target);
        //animator.setAcceleration(0.5f);
        //animator.setDeceleration(0.5f);
        //animator.setResolution(0); // para suavisar la animacion
        bg.setLayout(layout);
        bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        bg.add(login, "width "+ 60 +"%, pos 1al 0 n 100%");
        /*cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click");
                if(!animator.isRunning()){
                    animator.start();
                }
            }
        });*/
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        bg.setBackground(new java.awt.Color(0, 0, 0));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
