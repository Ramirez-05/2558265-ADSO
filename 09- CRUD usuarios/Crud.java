import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Crud extends JFrame {
    
    private Persona[] arrayPersonas;
    private int indicePerosnasRegistradas;
    
    public Crud(Persona arrayPersonas[], int indicePerosnasRegistradas) {
        this.arrayPersonas = arrayPersonas;
        this.indicePerosnasRegistradas = indicePerosnasRegistradas;
        
        initComponnets();
    }

    private void initComponnets() {
        setTitle("Usuarios");
        setSize(451, 393);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Image icono_crud = getToolkit().createImage(ClassLoader.getSystemResource("IMG/icono_almacenes.png"));
        setIconImage(icono_crud);

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

        JLabel tituloPricncipal = new JLabel("Menú");
        tituloPricncipal.setBorder(new EmptyBorder(7, 0, 7, 0));
        tituloPricncipal.setFont(new Font("Arial", Font.BOLD, 48));
        tituloPricncipal.setForeground(Color.WHITE);
        contenedorTitulo.add(tituloPricncipal);

        contenedorPrincipal.add(contenedorTitulo, BorderLayout.NORTH);

        /////////// PANEL PARA EL ESPACIO EN BLANCO ////////
        JPanel panelIntermedio = new JPanel(new BorderLayout());
        panelIntermedio.setBorder(new EmptyBorder(6,0, 0, 0));
        panelIntermedio.setBackground(colorPersonalizado3);
        //////////////////////////////////////////////////

        /////////// CONTENEDOR DE BOTONES /////////////////
        JPanel contenedorBotones = new JPanel();
        contenedorBotones.setLayout(new GridBagLayout());
        contenedorBotones.setBackground(colorPersonalizado2);
        GridBagConstraints restriccionBotones = new GridBagConstraints();
        //////////////////////////////////////////////////

        JButton btnCrearUsuario = new JButton("Crear Usuario");
        btnCrearUsuario.setBorder(BorderFactory.createEmptyBorder(7, 50, 7, 50));
        btnCrearUsuario.setFont(new Font("Arial", Font.BOLD, 20));
        btnCrearUsuario.setForeground(Color.WHITE);
        btnCrearUsuario.setBackground(colorBotones);
        btnCrearUsuario.setFocusPainted(false);
        restriccionBotones.gridy = 0;
        restriccionBotones.gridx = 0;
        restriccionBotones.gridwidth = 1;
        restriccionBotones.gridheight = 1;
        restriccionBotones.weightx = 1;
        restriccionBotones.weighty = 0;
        restriccionBotones.insets = new Insets(0, 0, 8, 10);
        restriccionBotones.anchor = GridBagConstraints.CENTER;
        contenedorBotones.add(btnCrearUsuario, restriccionBotones);

        JButton btnEditarUsuario = new JButton("Modificar Usuario");
        btnEditarUsuario.setBorder(BorderFactory.createEmptyBorder(7, 31, 7, 33));
        btnEditarUsuario.setFont(new Font("Arial", Font.BOLD, 20));
        btnEditarUsuario.setForeground(Color.WHITE);
        btnEditarUsuario.setBackground(colorBotones);
        btnEditarUsuario.setFocusPainted(false);
        restriccionBotones.gridy = 1;
        restriccionBotones.gridx = 0;
        restriccionBotones.gridwidth = 1;
        restriccionBotones.gridheight = 1;
        restriccionBotones.weightx = 1;
        restriccionBotones.weighty = 0;
        restriccionBotones.anchor = GridBagConstraints.CENTER;
        contenedorBotones.add(btnEditarUsuario, restriccionBotones);

        JButton btnEliminarUsuario = new JButton("Eliminar Usuario");
        btnEliminarUsuario.setBorder(BorderFactory.createEmptyBorder(7, 37, 8, 38));
        btnEliminarUsuario.setFont(new Font("Arial", Font.BOLD, 20));
        btnEliminarUsuario.setForeground(Color.WHITE);
        btnEliminarUsuario.setBackground(colorBotones);
        btnEliminarUsuario.setFocusPainted(false);
        restriccionBotones.gridy = 2;
        restriccionBotones.gridx = 0;
        restriccionBotones.gridwidth = 1;
        restriccionBotones.gridheight = 1;
        restriccionBotones.weightx = 1;
        restriccionBotones.weighty = 0;
        restriccionBotones.anchor = GridBagConstraints.CENTER;
        contenedorBotones.add(btnEliminarUsuario, restriccionBotones);

        JButton btnListarUsuarios = new JButton("Listar Usuarios");
        btnListarUsuarios.setBorder(BorderFactory.createEmptyBorder(7, 43, 7, 43));
        btnListarUsuarios.setFont(new Font("Arial", Font.BOLD, 20));
        btnListarUsuarios.setForeground(Color.WHITE);
        btnListarUsuarios.setBackground(colorBotones);
        btnListarUsuarios.setFocusPainted(false);
        restriccionBotones.gridy = 3;
        restriccionBotones.gridx = 0;
        restriccionBotones.gridwidth = 1;
        restriccionBotones.gridheight = 1;
        restriccionBotones.weightx = 1;
        restriccionBotones.weighty = 0;
        restriccionBotones.anchor = GridBagConstraints.CENTER;
        contenedorBotones.add(btnListarUsuarios, restriccionBotones);

        Crud ventanaMenu = this;

        btnCrearUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaMenu.setVisible(false);
                CrearUsuario crearUsuario = new CrearUsuario( ventanaMenu, arrayPersonas,indicePerosnasRegistradas);
                crearUsuario.setVisible(true);
            }
        });

        btnEditarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaMenu.setVisible(false);
                ModificarUsuario modificarUsuario = new ModificarUsuario(ventanaMenu, arrayPersonas,indicePerosnasRegistradas);
                modificarUsuario.setVisible(true);
            }
        });

        btnEliminarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaMenu.setVisible(false);
                EliminarUsuario eliminarUsuario = new EliminarUsuario( ventanaMenu, arrayPersonas,indicePerosnasRegistradas);
                eliminarUsuario.setVisible(true);
            }
        });

        btnListarUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaMenu.setVisible(false);
                ListarUsuarios listarUsuarios = new ListarUsuarios( ventanaMenu, arrayPersonas,indicePerosnasRegistradas);
                listarUsuarios.setVisible(true);
            }
        });



        panelIntermedio.add(contenedorBotones, BorderLayout.CENTER);
        contenedorPrincipal.add(panelIntermedio, BorderLayout.CENTER);
        add(contenedorPrincipal);
        setResizable(false);
        setVisible(true);
    }



}
