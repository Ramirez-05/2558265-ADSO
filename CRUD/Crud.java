import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;


public class Crud extends JFrame{
    
    public Crud(){
        initComponnets();
    }

    private void initComponnets() {

        setTitle("Usuarios");
        setSize(454, 395);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contPrincipal = new JPanel();
        contPrincipal.setLayout(new GridBagLayout());
        contPrincipal.setBorder(BorderFactory.createEmptyBorder(6, 10, 10, 10));
        GridBagConstraints restriccion = new GridBagConstraints();

        JLabel titlePrincipal = new JPanel();

        setResizable(false);
        setVisible(true);
        revalidate();
        repaint();


    }


}
