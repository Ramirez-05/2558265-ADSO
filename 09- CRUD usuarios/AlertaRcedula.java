import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class AlertaRCedula extends JFrame {

    private Dimension imgsize;

    public AlertaRCedula() {
        this.imgsize = new Dimension(60, 60);
        initComponents();
    }

    private void initComponents() {
        setTitle("Usuarios");
        setSize(350, 170);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color colorPersonalizado1 = new Color(0, 0, 102);

        Image icono_crud = getToolkit().createImage(ClassLoader.getSystemResource("IMG/icono_almacenes.png"));
        setIconImage(icono_crud);


        ////////////// CONTENEDOR PRINCIPAL //////////////
        JPanel contenedorPrincipal = new JPanel();
        contenedorPrincipal.setLayout(new GridBagLayout());
        contenedorPrincipal.setBorder(new EmptyBorder(14, 25, 11, 25));
        GridBagConstraints restriccion = new GridBagConstraints();
        //////////////////////////////////////////////////

        ImageIcon img_bandera = new ImageIcon("IMG/icono_error.png");
        ImageIcon icono_bandera = new ImageIcon(img_bandera.getImage().getScaledInstance(imgsize.width, imgsize.height, Image.SCALE_SMOOTH));

        JLabel label_icono = new JLabel(icono_bandera);
        restriccion.gridy = 0;
        restriccion.gridx = 0;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 2;
        restriccion.weightx = 0.0;
        restriccion.weighty = 0.0;
        contenedorPrincipal.add(label_icono, restriccion);

        JLabel titulo = new JLabel("CEDULA EXISTE");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        restriccion.gridy = 0;
        restriccion.gridx = 1;
        restriccion.gridwidth = 2; 
        restriccion.gridheight = 1;
        restriccion.weightx = 1;
        restriccion.weighty = 0;
        contenedorPrincipal.add(titulo, restriccion);

        JLabel mensaje = new JLabel("Se ha modificado el usuario");
        mensaje.setFont(new Font("Arial", Font.PLAIN, 12));
        restriccion.gridy = 1;
        restriccion.gridx = 1;
        restriccion.gridwidth = 2; 
        restriccion.gridheight = 1;
        restriccion.weightx = 1;
        restriccion.weighty = 0;
        restriccion.insets = new Insets(0, 0, 10, 0); 
        contenedorPrincipal.add(mensaje, restriccion);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBorder(new EmptyBorder(10, 12, 10, 12));
        btnAceptar.setPreferredSize(new Dimension(100, 32));
        btnAceptar.setBackground(colorPersonalizado1);
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setFocusPainted(false);
        btnAceptar.setFont(new Font("Arial", Font.BOLD, 13));
        restriccion.gridy = 2;
        restriccion.gridx = 0;
        restriccion.gridwidth = 3; 
        restriccion.gridheight = 1;
        restriccion.weightx = 1;
        restriccion.weighty = 1;
        restriccion.insets = new Insets(0, 12, 0, 0); 
        restriccion.fill = GridBagConstraints.CENTER; 
        contenedorPrincipal.add(btnAceptar, restriccion);

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        add(contenedorPrincipal);
        setResizable(false);
        setVisible(true);
    }

}
