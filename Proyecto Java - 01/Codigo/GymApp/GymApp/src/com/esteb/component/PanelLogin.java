
package com.esteb.component;

import Clases.DataBase;
import com.esteb.main.Main;
import com.esteb.main.Menu;
import com.esteb.swing.Button;
import com.esteb.swing.ButtonOutLine;
import com.esteb.swing.MyPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout; 
import com.esteb.swing.MyTextField;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.SwingUtilities;


public class PanelLogin extends javax.swing.JLayeredPane {
    private DataBase basedatos;
    private MyTextField txtEmail;
    private MyPasswordField txtPass;
    private JLabel labelinfo;
    
    public PanelLogin() {
        this.basedatos = new DataBase();
        initComponents();
        InitLogin();
        initResetPass();
        Login.setVisible(true);
        Pass.setVisible(false);
    }
    
    private void InitLogin(){
        Login.setLayout(new MigLayout("wrap", "push[center]push", "push[]10[]10[]10[]10[]35[]push"));
        
        JLabel label = new JLabel("Iniciar Sesión");
        label.setFont(new Font("REM", 1, 38));
        label.setForeground(new Color(255,255,255));
        Login.add(label);
        
        labelinfo = new JLabel("ESTO ESTA INVISIBLE XD");
        labelinfo.setFont(new Font("sansserif", 1, 12));
        labelinfo.setForeground(new Color(21,23,29));
        Login.add(labelinfo);
       
        txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(null);
        txtEmail.setHint("Usuario");
        Login.add(txtEmail, "w 60%");
        
        txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(null);
        txtPass.setHint("Contraseña");
        Login.add(txtPass, "w 60%");
        
        txtPass.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    validarUser();
                }    
            }
        });
        txtEmail.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("ENTER key pressed in the text field");
                    validarUser();
                }
            }
        });
        
        JButton btnOlvide = new JButton("Olvido su contraseña?");
        btnOlvide.setForeground(new Color(100, 100, 100));
        btnOlvide.setFont(new Font("sansserif", 1, 12));
        btnOlvide.setContentAreaFilled(false);
        btnOlvide.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Login.add(btnOlvide);
        btnOlvide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click");
                mostrarRegister(true);
            }
        });
        
        Button btnLogin = new Button();
        btnLogin.setBackground(new Color(36,107,254));
        btnLogin.setForeground(Color.white);
        btnLogin.setText("Continuar");
        Login.add(btnLogin, "w 40%, h 40");
        
        ActionListener login = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarUser();
            }
        };
        btnLogin.addActionListener(login);
        
    }
    
    private void initResetPass(){
        Pass.setLayout(new MigLayout("wrap", "push[center]push", "push[]0[]25[]35[]push"));

        JLabel label = new JLabel("Olvidé mi contraseña");
        label.setFont(new Font("REM", 1, 35));
        label.setForeground(new Color(255,255,255));
        Pass.add(label, "w 50%, span 2, align center");
 
        JLabel labelinfo = new JLabel("Introduzca su cuenta de correo electrónico para restablecer la contraseña");
        labelinfo.setFont(new Font("sansserif", 1, 12));
        labelinfo.setForeground(new Color(100, 100, 100));
        Pass.add(labelinfo, "span 2, align center");

        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(null);
        txtEmail.setHint("Email");
        Pass.add(txtEmail, "w 70%, span 2, align center");
        
        ButtonOutLine btnCancelar = new ButtonOutLine();
        btnCancelar.setBackground(new Color(36,107,254));
        btnCancelar.setForeground(Color.white);
        btnCancelar.setText("Cancelar");
        Pass.add(btnCancelar, "w 30%, h 40, split 3, align center");
        
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarRegister(false);
                txtEmail.setText("");
            }
        });

        Button btnSeparator = new Button();  // Botón invisible para separación
        btnSeparator.setVisible(false);
        Pass.add(btnSeparator, "w 3%, h 40, align center");
        
        Button btnReset = new Button();
        btnReset.setBackground(new Color(36,107,254));
        btnReset.setForeground(Color.white);
        btnReset.setText("Continuar");
        Pass.add(btnReset, "w 30%, h 40, align center");
    }


    public void mostrarRegister(boolean mostrar) {
        if (mostrar) {
            Pass.setVisible(true);
            Login.setVisible(false);
        } else {
            Pass.setVisible(false);
            Login.setVisible(true);
        }
    }
    
    private void validarUser(){
        if (basedatos != null) {
            String email = txtEmail.getText();
            String pass = txtPass.getText();
                if (email.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")) {   
                    Menu ventana = new Menu(basedatos);
                    ((javax.swing.JFrame) SwingUtilities.getWindowAncestor(Login)).dispose();
                }else{
                    System.out.println("DATOS INVALIDOS");
                    labelinfo.setText("Contraseña incorrecta. Vuelve a intentarlo o recupera la contraseña");
                    labelinfo.setForeground(Color.red);
                }
        } else {
            System.out.println("basedatos es nulo");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JPanel();
        Pass = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        Login.setBackground(new java.awt.Color(21, 23, 29));

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(Login, "card3");

        Pass.setBackground(new java.awt.Color(21, 23, 29));

        javax.swing.GroupLayout PassLayout = new javax.swing.GroupLayout(Pass);
        Pass.setLayout(PassLayout);
        PassLayout.setHorizontalGroup(
            PassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        PassLayout.setVerticalGroup(
            PassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(Pass, "card3");
    }// </editor-fold>//GEN-END:initComponents
    
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Login;
    private javax.swing.JPanel Pass;
    // End of variables declaration//GEN-END:variables
}
