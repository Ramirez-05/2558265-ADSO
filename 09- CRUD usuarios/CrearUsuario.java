import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class CrearUsuario extends JFrame {

    public CrearUsuario() {
        initComponnets();
    }

    private void initComponnets() {
        setTitle("Usuarios");
        setSize(357, 411);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color colorPersonalizado1 = new Color(0, 0, 102);
        Color colorPersonalizado2 = new Color(153, 153, 255);
        Color colorPersonalizado3 = Color.WHITE;
        Color colorBotones = new Color(0, 0, 153);

        ////////////// CONTENEDOR PRINCIPAL //////////////
        JPanel contenedorPrincipal = new JPanel(new BorderLayout());
        contenedorPrincipal.setBackground(colorPersonalizado3);
        //////////////////////////////////////////////////

        ////////////// CONTENEDOR DEL TITULO //////////////
        JPanel contenedorTitulo = new JPanel();
        contenedorTitulo.setLayout(new GridBagLayout());
        contenedorTitulo.setBackground(colorPersonalizado1);
        //////////////////////////////////////////////////

        JLabel tituloPricncipal = new JLabel("CREAR USUARIO");
        tituloPricncipal.setBorder(new EmptyBorder(9, 0, 9, 0));
        tituloPricncipal.setFont(new Font("Arial", Font.BOLD, 27));
        tituloPricncipal.setForeground(Color.WHITE);
        contenedorTitulo.add(tituloPricncipal);

        contenedorPrincipal.add(contenedorTitulo, BorderLayout.NORTH);

        /////////// PANEL PARA EL ESPACIO EN BLANCO ////////
        JPanel panelIntermedio = new JPanel(new BorderLayout());
        panelIntermedio.setBorder(new EmptyBorder(6,0, 0, 0));
        panelIntermedio.setBackground(colorPersonalizado3);
        ////////////////////////////////////////////////////

        /////////// CONTENEDOR DE FORMULARIO /////////////////
        JPanel contenedorFormulario = new JPanel();
        contenedorFormulario.setBorder(new EmptyBorder(6,18, 0, 18));
        contenedorFormulario.setLayout(new GridBagLayout());
        contenedorFormulario.setBackground(colorPersonalizado2);
        GridBagConstraints restricionesFormulario = new GridBagConstraints();
        //////////////////////////////////////////////////

        JLabel tituloCedula = new JLabel("Cedula: ");
        tituloCedula.setFont(new Font("Arial", Font.BOLD, 18));
        tituloCedula.setForeground(Color.BLACK);
        restricionesFormulario.gridy = 0;
        restricionesFormulario.gridx = 0;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 8;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        restricionesFormulario.insets = new Insets(0, 0, 10, 0);
        contenedorFormulario.add(tituloCedula, restricionesFormulario);

        JTextField campoCedula = new JTextField();
        campoCedula.setFont(new Font("Arial", Font.BOLD, 18));
        campoCedula.setForeground(Color.BLACK);
        restricionesFormulario.gridy = 0;
        restricionesFormulario.gridx = 1;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(campoCedula, restricionesFormulario);

        JLabel tituloNombre = new JLabel("Nombres: ");
        tituloNombre.setFont(new Font("Arial", Font.BOLD, 18));
        tituloNombre.setForeground(Color.BLACK);
        restricionesFormulario.gridy = 1;
        restricionesFormulario.gridx = 0;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 8;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(tituloNombre, restricionesFormulario);

        JTextField campoNombre = new JTextField();
        campoNombre.setFont(new Font("Arial", Font.BOLD, 18));
        campoNombre.setForeground(Color.BLACK);
        restricionesFormulario.gridy = 1;
        restricionesFormulario.gridx = 1;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 80;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(campoNombre, restricionesFormulario);

        JLabel tituloApellido = new JLabel("Apellidos: ");
        tituloApellido.setFont(new Font("Arial", Font.BOLD, 18));
        tituloApellido.setForeground(Color.BLACK);
        restricionesFormulario.gridy = 2;
        restricionesFormulario.gridx = 0;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 8;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(tituloApellido, restricionesFormulario);

        JTextField campoApellido = new JTextField();
        campoApellido.setFont(new Font("Arial", Font.BOLD, 18));
        campoApellido.setForeground(Color.BLACK);
        restricionesFormulario.gridy = 2;
        restricionesFormulario.gridx = 1;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(campoApellido, restricionesFormulario);

        JLabel tituloTelefono = new JLabel("Telefono: ");
        tituloTelefono.setFont(new Font("Arial", Font.BOLD, 18));
        tituloTelefono.setForeground(Color.BLACK);
        restricionesFormulario.gridy = 3;
        restricionesFormulario.gridx = 0;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(tituloTelefono, restricionesFormulario);

        JTextField campoTelefono = new JTextField();
        campoTelefono.setFont(new Font("Arial", Font.BOLD, 18));
        campoTelefono.setForeground(Color.BLACK);
        restricionesFormulario.gridy = 3;
        restricionesFormulario.gridx = 1;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(campoTelefono, restricionesFormulario);

        JLabel tituloDireccion = new JLabel("Direccion: ");
        tituloDireccion.setFont(new Font("Arial", Font.BOLD, 18));
        tituloDireccion.setForeground(Color.BLACK);
        restricionesFormulario.gridy = 4;
        restricionesFormulario.gridx = 0;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 8;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(tituloDireccion, restricionesFormulario);

        JTextField campoDireccion = new JTextField();
        campoDireccion.setFont(new Font("Arial", Font.BOLD, 18));
        campoDireccion.setForeground(Color.BLACK);
        restricionesFormulario.gridy = 4;
        restricionesFormulario.gridx = 1;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(campoDireccion, restricionesFormulario);

        JLabel tituloEmail = new JLabel("Email: ");
        tituloEmail.setFont(new Font("Arial", Font.BOLD, 18));
        tituloEmail.setForeground(Color.BLACK);
        restricionesFormulario.gridy = 5;
        restricionesFormulario.gridx = 0;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 8;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(tituloEmail, restricionesFormulario);

        JTextField campoEmail = new JTextField();
        campoEmail.setFont(new Font("Arial", Font.BOLD, 18));
        campoEmail.setForeground(Color.BLACK);
        restricionesFormulario.gridy = 5;
        restricionesFormulario.gridx = 1;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(campoEmail, restricionesFormulario);

        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 20));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBackground(colorBotones);
        btnCancelar.setFocusPainted(false);
        restricionesFormulario.gridy = 6;
        restricionesFormulario.gridx = 0;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        restricionesFormulario.insets = new Insets(0, 0, 0, 8);
        contenedorFormulario.add(btnCancelar, restricionesFormulario);

        JButton btnRegistrar = new JButton("REGISTRAR");
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 20));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setBackground(colorBotones);
        btnRegistrar.setFocusPainted(false);
        restricionesFormulario.gridy = 6;
        restricionesFormulario.gridx = 1;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(btnRegistrar, restricionesFormulario);

























        panelIntermedio.add(contenedorFormulario, BorderLayout.CENTER);
        contenedorPrincipal.add(panelIntermedio, BorderLayout.CENTER);
        add(contenedorPrincipal);
        setResizable(false);
        setVisible(true);
    }

    public void eventoCrearuser() {


    }

}
