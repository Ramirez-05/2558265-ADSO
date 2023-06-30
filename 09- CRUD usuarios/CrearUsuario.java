import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;


public class CrearUsuario extends JFrame {

    private JTextField campoCedula;
    private JTextField campoNombre;
    private JTextField campoApellido;
    private JTextField campoTelefono;
    private JTextField campoDireccion;
    private JTextField campoCorreo;

    private Persona[] arrayPersonas;

    private Dimension imgSize;

    private int indicePersonasRegistradas;



    public CrearUsuario(Persona[] arrayPersonas, int indicePersonasRegistradas) {
        this.arrayPersonas = arrayPersonas;
        this.indicePersonasRegistradas = indicePersonasRegistradas;
        imgSize = new Dimension(30, 30);
        initComponents();
    }

    private void initComponents() {
        setTitle("Usuarios");
        setSize(357, 410);
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
        contenedorFormulario.setBorder(new EmptyBorder(17,15, 0, 17));
        contenedorFormulario.setLayout(new GridBagLayout());
        contenedorFormulario.setBackground(colorPersonalizado2);
        GridBagConstraints restricionesFormulario = new GridBagConstraints();
        //////////////////////////////////////////////////

        JLabel tituloCedula = new JLabel("Cedula: ");
        tituloCedula.setFont(new Font("Arial", Font.BOLD, 18));
        tituloCedula.setForeground(letras);
        restricionesFormulario.gridy = 0;
        restricionesFormulario.gridx = 0;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.HORIZONTAL;
        restricionesFormulario.insets = new Insets(0, 0, 6, 0);
        contenedorFormulario.add(tituloCedula, restricionesFormulario);

        campoCedula = new JTextField();
        campoCedula.setFont(new Font("Arial", Font.BOLD, 18));
        campoCedula.setForeground(Color.BLACK);
        campoCedula.setPreferredSize(new Dimension(200, 32));
        restricionesFormulario.gridy = 0;
        restricionesFormulario.gridx = 1;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 1;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.HORIZONTAL;
        restricionesFormulario.insets = new Insets(0, 0, 6, 0);
        contenedorFormulario.add(campoCedula, restricionesFormulario);

        JLabel tituloNombre = new JLabel("Nombres: ");
        tituloNombre.setFont(new Font("Arial", Font.BOLD, 18));
        tituloNombre.setForeground(letras);
        restricionesFormulario.gridy = 1;
        restricionesFormulario.gridx = 0;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 10;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(tituloNombre, restricionesFormulario);

        campoNombre = new JTextField();
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
        contenedorFormulario.add(campoNombre, restricionesFormulario);

        JLabel tituloApellido = new JLabel("Apellidos: ");
        tituloApellido.setFont(new Font("Arial", Font.BOLD, 18));
        tituloApellido.setForeground(letras);
        restricionesFormulario.gridy = 2;
        restricionesFormulario.gridx = 0;
        restricionesFormulario.gridwidth = 1;
        restricionesFormulario.gridheight = 1;
        restricionesFormulario.weightx = 10;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(tituloApellido, restricionesFormulario);

        campoApellido = new JTextField();
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
        restricionesFormulario.weightx = 10;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(tituloTelefono, restricionesFormulario);

        campoTelefono = new JTextField();
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
        restricionesFormulario.weightx = 10;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(tituloDireccion, restricionesFormulario);

        campoDireccion = new JTextField();
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
        restricionesFormulario.weightx = 10;
        restricionesFormulario.weighty = 0;
        restricionesFormulario.fill = GridBagConstraints.BOTH;
        contenedorFormulario.add(tituloCorreo, restricionesFormulario);

        campoCorreo = new JTextField();
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

        JPanel contenedorBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 10));
        contenedorBotones.setBackground(colorPersonalizado2);
        contenedorBotones.setBorder(new EmptyBorder(0, 0, 12, 0));

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
                Crud Crud = new Crud(arrayPersonas, indicePersonasRegistradas);
                Crud.setVisible(true);
                dispose();
            }
        });

        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarUser();
            }
        });
    }

    public void registrarUser(){
        String cedula = campoCedula.getText();
        String nombre = campoNombre.getText();
        String apellido = campoApellido.getText();
        String telefono = campoTelefono.getText();
        String direccion = campoDireccion.getText();
        String correo = campoCorreo.getText();

        // Validar campos
            if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || correo.isEmpty()) {
                ErrorRegistro error = new ErrorRegistro();
                error.setVisible(true);

                campoCedula.setBorder(new LineBorder(Color.RED, 1));
                campoNombre.setBorder(new LineBorder(Color.RED, 1));
                campoApellido.setBorder(new LineBorder(Color.RED, 1));
                campoTelefono.setBorder(new LineBorder(Color.RED, 1));
                campoDireccion.setBorder(new LineBorder(Color.RED, 1));
                campoCorreo.setBorder(new LineBorder(Color.RED, 1));
            }

            if (indicePersonasRegistradas < arrayPersonas.length) {
                arrayPersonas[indicePersonasRegistradas] = new Persona(indicePersonasRegistradas, cedula, nombre, apellido, telefono, direccion, correo);
                indicePersonasRegistradas++;

                // Limpiar campos
                campoCedula.setText("");
                campoNombre.setText("");
                campoApellido.setText("");
                campoTelefono.setText("");
                campoDireccion.setText("");
                campoCorreo.setText("");

            }
        
    }
}
