import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class EliminarUsuario extends JFrame {
    
    private Persona arrayPersonas[];
    private int indicePerosnasRegistradas;

    private JTextField campoCedula;
    private JTextField campoNombre;
    private JTextField campoApellido;
    private JTextField campoTelefono;
    private JTextField campoDireccion;
    private JTextField campoCorreo;
    private JButton btnEliminar;

    
    public EliminarUsuario(Persona arrayPersonas[], int indicePerosnasRegistradas) {
        this.arrayPersonas = arrayPersonas;
        this.indicePerosnasRegistradas = indicePerosnasRegistradas;
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
        
        Color ColorBtnEliminar = new Color(204, 0, 0);
        Color ColorBtnCancelar = new Color(145, 150, 144);

        ////////////// CONTENEDOR PRINCIPAL //////////////
        JPanel contenedorPrincipal = new JPanel(new BorderLayout());
        contenedorPrincipal.setBackground(colorPersonalizado3);
        //////////////////////////////////////////////////

        ////////////// CONTENEDOR DEL TITULO //////////////
        JPanel contenedorTitulo = new JPanel();
        contenedorTitulo.setLayout(new GridBagLayout());
        contenedorTitulo.setBackground(colorPersonalizado1);
        //////////////////////////////////////////////////

        JLabel tituloPricncipal = new JLabel("ELIMINAR USUARIO");
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

        campoCedula = new JTextField();
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

        campoNombre = new JTextField();
        campoNombre.setFont(new Font("Arial", Font.BOLD, 16));
        campoNombre.setForeground(Color.BLACK);
        campoNombre.setBackground(ColorBtnCancelar);
        campoNombre.setPreferredSize(new Dimension(200, 32));
        campoNombre.setEnabled(false);
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

        campoApellido = new JTextField();
        campoApellido.setFont(new Font("Arial", Font.BOLD, 16));
        campoApellido.setForeground(Color.BLACK);
        campoApellido.setBackground(ColorBtnCancelar);
        campoApellido.setPreferredSize(new Dimension(200, 32));
        campoApellido.setEnabled(false);
        campoApellido.setEnabled(false);
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

        campoTelefono = new JTextField();
        campoTelefono.setFont(new Font("Arial", Font.BOLD, 16));
        campoTelefono.setForeground(Color.BLACK);
        campoTelefono.setBackground(ColorBtnCancelar);
        campoTelefono.setPreferredSize(new Dimension(200, 32));
        campoTelefono.setEnabled(false);
        campoTelefono.setEnabled(false);
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

        campoDireccion = new JTextField();
        campoDireccion.setFont(new Font("Arial", Font.BOLD, 16));
        campoDireccion.setForeground(Color.BLACK);
        campoDireccion.setBackground(ColorBtnCancelar);
        campoDireccion.setPreferredSize(new Dimension(200, 32));
        campoDireccion.setEnabled(false);
        campoDireccion.setEnabled(false);
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

        campoCorreo = new JTextField();
        campoCorreo.setFont(new Font("Arial", Font.BOLD, 16));
        campoCorreo.setForeground(Color.BLACK);
        campoCorreo.setBackground(ColorBtnCancelar);
        campoCorreo.setPreferredSize(new Dimension(200, 30));
        campoCorreo.setEnabled(false);
        campoCorreo.setEnabled(false);
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

        
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBorder(new EmptyBorder(9, 0, 9, 0));
        btnCancelar.setPreferredSize(new Dimension(140, 37));
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 18));
        btnCancelar.setForeground(letras);
        btnCancelar.setBackground(ColorBtnCancelar);
        btnCancelar.setFocusPainted(false);
        contenedorBotones.add(btnCancelar);


        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBorder(new EmptyBorder(9, 0, 9, 0));
        btnEliminar.setPreferredSize(new Dimension(140, 37));
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 18));
        btnEliminar.setEnabled(false);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setBackground(ColorBtnEliminar);
        btnEliminar.setFocusPainted(false);
        contenedorBotones.add(btnEliminar);

        
        panelIntermedio.add(contenedorFormulario, BorderLayout.CENTER);
        panelIntermedio.add(contenedorBotones, BorderLayout.SOUTH);
        contenedorPrincipal.add(panelIntermedio, BorderLayout.CENTER);
        add(contenedorPrincipal);
        setResizable(false);
        setVisible(true);

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Crud Crud = new Crud(arrayPersonas,indicePerosnasRegistradas);
                Crud.setVisible(true);
                dispose();
            }
        });

        KeyListener eventoBuscarPersona = new KeyListener() { 
			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				buscarPersona();
                System.out.println("Buscando persona...");
			}

			public void keyTyped(KeyEvent e) {
			}
		};

        campoCedula.addKeyListener(eventoBuscarPersona);

        ActionListener eventoEliminarPerosna = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				EliminarPerosna();
			}
		};

        btnEliminar.addActionListener(eventoEliminarPerosna);


    }

    public void buscarPersona() {
        String cedula = campoCedula.getText();

        for (int i = 0; i < arrayPersonas.length; i++) {
            if (arrayPersonas[i] != null && arrayPersonas[i].getCedula().equals(cedula)) {
                
                campoNombre.setText(arrayPersonas[i].getNombre());
                campoApellido.setText(arrayPersonas[i].getApellido());
                campoTelefono.setText(arrayPersonas[i].getTelefono());
                campoDireccion.setText(arrayPersonas[i].getDireccion());
                campoCorreo.setText(arrayPersonas[i].getCorreo());

                btnEliminar.setEnabled(true);


            }else if(cedula.isEmpty()){
                campoNombre.setEditable(false);
                campoApellido.setEditable(false);
                campoTelefono.setEditable(false);
                campoDireccion.setEditable(false);
                campoCorreo.setEditable(false);

                campoNombre.setText("");
                campoApellido.setText("");
                campoTelefono.setText("");
                campoDireccion.setText("");
                campoCorreo.setText("");

                btnEliminar.setEnabled(false);

            }
            
        }
    }

    public void EliminarPerosna(){
        String cedula = campoCedula.getText();

        for (int i = 0; i < arrayPersonas.length; i++) {
            if (arrayPersonas[i] != null && arrayPersonas[i].getCedula().equals(cedula)) {
                arrayPersonas[i] = null;
                indicePerosnasRegistradas--;
                
                Crud Crud = new Crud(arrayPersonas,indicePerosnasRegistradas);
                Crud.setVisible(true);

                EliminarPerosna eliminar = new EliminarPerosna();
                eliminar.setVisible(false);

                dispose();
            }
        }
    }


}
