package Main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class LoginV1 extends JFrame{
    
    JTextField campo_correo;
    JTextField campo_password;
    JButton btn_ingresar;
    
    public LoginV1 (){
        initComponents();
    }
    
    public void initComponents(){
        setTitle("Iniciar Sesion");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
            
    
}
