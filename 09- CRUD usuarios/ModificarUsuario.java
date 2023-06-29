import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class ModificarUsuario extends JFrame {

    Persona arrayPersonas[];

    public ModificarUsuario(Persona arrayPersonas[]) {
        this.arrayPersonas = arrayPersonas;
        initComponents();
    }

    private void initComponents() {
        setTitle("Usuarios");
        setSize(460, 456);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color colorPersonalizado1 = new Color(0, 0, 102);
        Color colorPersonalizado2 = new Color(153, 153, 255);
        Color colorPersonalizado3 = Color.WHITE;
        Color colorBotones = new Color(0, 0, 153);

        Color letras = new Color(51, 50, 46);

        ////////////// CONTENEDOR PRINCIPAL //////////////
        JPanel contenedorPrincipal = new JPanel(new BorderLayout());
        contenedorPrincipal.setBackground(colorPersonalizado3);
        //////////////////////////////////////////////////

        ////////////// CONTENEDOR DEL TITULO //////////////
        JPanel contenedorTitulo = new JPanel();
        contenedorTitulo.setLayout(new GridBagLayout());
        contenedorTitulo.setBackground(colorPersonalizado1);
        //////////////////////////////////////////////////

        JLabel tituloPricncipal = new JLabel("MODIFICAR USUARIO");
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

        ////////////////// PANEL FILA DE BUSQUEDA ///////////////////////
        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setLayout(new GridBagLayout());
        panelBusqueda.setBackground(colorPersonalizado2);
        panelBusqueda.setBorder(new EmptyBorder(20, 30, 0, 30));
        GridBagConstraints restriccionesBusqueda = new GridBagConstraints();
        //////////////////////////////////////////////////////////////////

        JLabel tituloCedula = new JLabel("Cedula: ");
        tituloCedula.setFont(new Font("Arial", Font.BOLD, 18));
        tituloCedula.setForeground(letras);
        restriccionesBusqueda.gridy = 0;
        restriccionesBusqueda.gridx = 0;
        restriccionesBusqueda.gridwidth = 1;
        restriccionesBusqueda.gridheight = 1;
        restriccionesBusqueda.weightx = 1;
        restriccionesBusqueda.weighty = 0;
        restriccionesBusqueda.fill = GridBagConstraints.HORIZONTAL;
        restriccionesBusqueda.insets = new Insets(0, 0, 6, 0);
        panelBusqueda.add(tituloCedula, restriccionesBusqueda);

        JTextField campoCedula = new JTextField();
        campoCedula.setFont(new Font("Arial", Font.BOLD, 18));
        campoCedula.setForeground(Color.BLACK);
        campoCedula.setPreferredSize(new Dimension(170, 30));
        restriccionesBusqueda.gridy = 0;
        restriccionesBusqueda.gridx = 1;
        restriccionesBusqueda.gridwidth = 1;
        restriccionesBusqueda.gridheight = 1;
        restriccionesBusqueda.weightx = 1;
        restriccionesBusqueda.weighty = 0;
        restriccionesBusqueda.fill = GridBagConstraints.HORIZONTAL;
        restriccionesBusqueda.insets = new Insets(0, 0, 6, 0);
        panelBusqueda.add(campoCedula, restriccionesBusqueda);

        JButton botonBuscar = new JButton("BUSCAR");
        botonBuscar.setFont(new Font("Arial", Font.BOLD, 18));
        botonBuscar.setForeground(Color.WHITE);
        botonBuscar.setBackground(colorBotones);
        botonBuscar.setPreferredSize(new Dimension(100, 37));
        botonBuscar.setBorder(new EmptyBorder(20, 10, 20, 10));
        restriccionesBusqueda.gridy = 0;
        restriccionesBusqueda.gridx = 2;
        restriccionesBusqueda.gridwidth = 1;
        restriccionesBusqueda.gridheight = 1;
        restriccionesBusqueda.weightx = 1;
        restriccionesBusqueda.weighty = 0;
        restriccionesBusqueda.fill = GridBagConstraints.HORIZONTAL;
        restriccionesBusqueda.insets = new Insets(0, 7, 6, 0);
        panelBusqueda.add(botonBuscar, restriccionesBusqueda);

        panelIntermedio.add(panelBusqueda, BorderLayout.NORTH);

    JLabel tituloExtra = new JLabel("Usuario encontrado: ");
    tituloExtra.setForeground(letras);
    tituloExtra.setFont(new Font("Arial", Font.PLAIN, 14));


    tituloExtra.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE), // Borde superior
        BorderFactory.createEmptyBorder(18, 3, 3, 3)  // Relleno interno
    ));


    restriccionesBusqueda.gridy = 1;
    restriccionesBusqueda.gridx = 0;
    restriccionesBusqueda.gridwidth = 6;
    restriccionesBusqueda.gridheight = 1;
    restriccionesBusqueda.weightx = 1;
    restriccionesBusqueda.weighty = 0;
    restriccionesBusqueda.fill = GridBagConstraints.BOTH;
    restriccionesBusqueda.insets = new Insets(3, 0, 3, 0);

    panelBusqueda.add(tituloExtra, restriccionesBusqueda);



        /////////// CONTENEDOR DE FORMULARIO /////////////////
        JPanel contenedorFormulario = new JPanel();
        contenedorFormulario.setBorder(new EmptyBorder(0,70, 0, 70));
        contenedorFormulario.setLayout(new GridBagLayout());
        contenedorFormulario.setBackground(colorPersonalizado2);
        GridBagConstraints restricionesFormulario = new GridBagConstraints();
        //////////////////////////////////////////////////        

        JLabel tituloNombre = new JLabel("Nombres: ");
        tituloNombre.setFont(new Font("Arial", Font.BOLD, 18));
        tituloNombre.setForeground(letras);
        restricionesFormulario.gridy = 1;
        restricionesFormulario.gridx = 0;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        restricionesFormulario.insets = new Insets(0, 0, 6, 0);
        contenedorFormulario.add(tituloNombre, restricionesFormulario);

        JTextField campoNombre = new JTextField();
        campoNombre.setFont(new Font("Arial", Font.BOLD, 18));
        campoNombre.setForeground(Color.BLACK);
        campoNombre.setPreferredSize(new Dimension(200, 32));
        restricionesFormulario.gridy = 1;
        restricionesFormulario.gridx = 1;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.HORIZONTAL;
        restricionesFormulario.insets = new Insets(0, 0, 6, 0);
        contenedorFormulario.add(campoNombre, restricionesFormulario);

        JLabel tituloApellido = new JLabel("Apellidos: ");
        tituloApellido.setFont(new Font("Arial", Font.BOLD, 18));
        tituloApellido.setForeground(letras);
        restricionesFormulario.gridy = 2;
        restricionesFormulario.gridx = 0;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(tituloApellido, restricionesFormulario);

        JTextField campoApellido = new JTextField();
        campoApellido.setFont(new Font("Arial", Font.BOLD, 18));
        campoApellido.setForeground(Color.BLACK);
        campoApellido.setPreferredSize(new Dimension(200, 32));
        restricionesFormulario.gridy = 2;
        restricionesFormulario.gridx = 1;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.HORIZONTAL;
        contenedorFormulario.add(campoApellido, restricionesFormulario);

        JLabel tituloTelefono = new JLabel("Telefono: ");
        tituloTelefono.setFont(new Font("Arial", Font.BOLD, 18));
        tituloTelefono.setForeground(letras);
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
        campoTelefono.setPreferredSize(new Dimension(200, 32));
        restricionesFormulario.gridy = 3;
        restricionesFormulario.gridx = 1;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.HORIZONTAL;
        contenedorFormulario.add(campoTelefono, restricionesFormulario);

        JLabel tituloDireccion = new JLabel("Direccion: ");
        tituloDireccion.setFont(new Font("Arial", Font.BOLD, 18));
        tituloDireccion.setForeground(letras);
        restricionesFormulario.gridy = 4;
        restricionesFormulario.gridx = 0;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(tituloDireccion, restricionesFormulario);

        JTextField campoDireccion = new JTextField();
        campoDireccion.setFont(new Font("Arial", Font.BOLD, 18));
        campoDireccion.setForeground(Color.BLACK);
        campoDireccion.setPreferredSize(new Dimension(200, 32));
        restricionesFormulario.gridy = 4;
        restricionesFormulario.gridx = 1;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.HORIZONTAL;
        contenedorFormulario.add(campoDireccion, restricionesFormulario);

        JLabel tituloCorreo = new JLabel("Email: ");
        tituloCorreo.setFont(new Font("Arial", Font.BOLD, 18));
        tituloCorreo.setForeground(letras);
        restricionesFormulario.gridy = 5;
        restricionesFormulario.gridx = 0;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(tituloCorreo, restricionesFormulario);

        JTextField campoCorreo = new JTextField();
        campoCorreo.setFont(new Font("Arial", Font.BOLD, 18));
        campoCorreo.setForeground(Color.BLACK);
        campoCorreo.setPreferredSize(new Dimension(200, 30));
        restricionesFormulario.gridy = 5;
        restricionesFormulario.gridx = 1;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.HORIZONTAL;
        contenedorFormulario.add(campoCorreo, restricionesFormulario);



        ///////////////////////// PANEL PARA BOTONES /////////////////////////////////
        JPanel contenedorBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 10));
        contenedorBotones.setBackground(colorPersonalizado2);
        contenedorBotones.setBorder(new EmptyBorder(0, 0, 8, 0));
        //////////////////////////////////////////////////////////////////////////////

        Color ColorBtnCancelar = new Color(145, 150, 144);
        
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBorder(new EmptyBorder(9, 0, 9, 0));
        btnCancelar.setPreferredSize(new Dimension(140, 37));
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 18));
        btnCancelar.setForeground(letras);
        btnCancelar.setBackground(ColorBtnCancelar);
        btnCancelar.setFocusPainted(false);
        contenedorBotones.add(btnCancelar);

        JButton btnRegistrar = new JButton("REGISTRAR");
        btnRegistrar.setBorder(new EmptyBorder(9, 0, 9, 0));
        btnRegistrar.setPreferredSize(new Dimension(140, 37));
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 18));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setBackground(colorBotones);
        btnRegistrar.setFocusPainted(false);
        contenedorBotones.add(btnRegistrar);
        panelIntermedio.add(contenedorFormulario, BorderLayout.CENTER);
        panelIntermedio.add(contenedorBotones, BorderLayout.SOUTH);
        contenedorPrincipal.add(panelIntermedio, BorderLayout.CENTER);
        add(contenedorPrincipal);
        setResizable(false);
        setVisible(true);

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Crud Crud = new Crud(arrayPersonas);
                Crud.setVisible(true);
                dispose();
            }
        });

        
    }

    public void eventoCrearuser() {
        // Agrega aquí la lógica para el evento de crear usuario
    }


}
