
package com.esteb.component;

import Clases.DataBase;
import com.esteb.main.Main;
import com.esteb.main.Menu;
import com.esteb.swing.Button;
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
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingUtilities;


public class PanelLogin extends javax.swing.JLayeredPane {
    private DataBase basedatos;
    
    public PanelLogin() {
        this.basedatos = new DataBase();
        initComponents();
        InitLogin();
        Login.setVisible(true);
        Register.setVisible(false);
    }
    
    private void InitLogin(){
        Login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]35[]push"));
        
        JLabel label = new JLabel("Iniciar Sesión");
        label.setFont(new Font("REM", 1, 38));
        label.setForeground(new Color(255,255,255));
        Login.add(label);
       
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(null);
        txtEmail.setHint("Usuario");
        Login.add(txtEmail, "w 60%");
        
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(null);
        txtPass.setHint("Contraseña");
        Login.add(txtPass, "w 60%");
        
        JButton btnOlvide = new JButton("Olvido su contraseña?");
        btnOlvide.setForeground(new Color(100, 100, 100));
        btnOlvide.setFont(new Font("sansserif", 1, 12));
        btnOlvide.setContentAreaFilled(false);
        btnOlvide.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Login.add(btnOlvide);
        
        Button btnLogin = new Button();
        btnLogin.setBackground(new Color(36,107,254));
        btnLogin.setForeground(Color.white);
        btnLogin.setText("Continuar");
        Login.add(btnLogin, "w 40%, h 40");
        
        ActionListener login = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (basedatos != null) {
                    int cantidadSuscripciones = basedatos.contarSuscripciones();
                    String email = txtEmail.getText();
                    String pass = txtPass.getText();

                    if (email.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")) {   
                        Menu ventana = new Menu(basedatos);
                        ((javax.swing.JFrame) SwingUtilities.getWindowAncestor(Login)).dispose();
                    }else{
                        System.out.println("DATOS INVALIDOS");
                    }
                } else {
                    System.out.println("basedatos es nulo");
                }
            }
        };
        btnLogin.addActionListener(login);
        
    }
    
    
    
   /* 
    private void InitRegister(){
        Register.setLayout(new MigLayout("fillx", "push[center]push", "push[]45[]10[]10[]10[]25[]push"));

        JLabel label = new JLabel("Crear Cuenta");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        Register.add(label, "span");

        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(null);
        txtUser.setHint("Nombre");
        Register.add(txtUser, "w 40%, split 3"); // Agregar "split 2" para dividir la celda

        MyTextField txtApellido = new MyTextField();
        txtApellido.setPrefixIcon(null);
        txtApellido.setHint("Apellido");
        Register.add(txtApellido, "w 40%, wrap"); // Agregar "wrap" aquí

        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(null);
        txtEmail.setHint("Correo");
        Register.add(txtEmail, "w 80%, span"); // Agregar "span" para ocupar toda la celda
        
        MyTextField txtDocumento = new MyTextField();
        txtDocumento.setPrefixIcon(null);
        txtDocumento.setHint("Documento");
        Register.add(txtDocumento, "w 80%, span"); 
        
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(null);
        txtPass.setHint("Contrasena");
        Register.add(txtPass, "w 80%, span");
        
        Button btnRegister = new Button();
        btnRegister.setBackground(new Color(0, 126, 122));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setText("REGISTRAR");
        Register.add(btnRegister, "w 40%, h 40");
    }*/


    

    public void mostrarRegister(boolean mostrar){
        if(mostrar){
            Register.setVisible(true);
            Login.setVisible(false);
        }else{
            Register.setVisible(false);
            Login.setVisible(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JPanel();
        Register = new javax.swing.JPanel();

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

        Register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout RegisterLayout = new javax.swing.GroupLayout(Register);
        Register.setLayout(RegisterLayout);
        RegisterLayout.setHorizontalGroup(
            RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        RegisterLayout.setVerticalGroup(
            RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(Register, "card2");
    }// </editor-fold>//GEN-END:initComponents
    
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Login;
    private javax.swing.JPanel Register;
    // End of variables declaration//GEN-END:variables
}
