import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;


public class ListarUsuarios extends JFrame {

    private Persona arrayPersonas[];
    private JLabel arraylabels[] = new JLabel[100];
    private int indicePerosnasRegistradas;

    private Crud ventanaMenu;

    public ListarUsuarios(Crud ventanaMenu, Persona arrayPersonas[], int indicePerosnasRegistradas) {
        this.ventanaMenu = ventanaMenu;
        this.arrayPersonas = arrayPersonas;
        this.indicePerosnasRegistradas = indicePerosnasRegistradas;
        initComponents();
    }

    private void initComponents() {
        setTitle("Usuarios");
        setSize(375, 432);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color colorPersonalizado2 = new Color(153, 153, 255);
        Color letras = new Color(51, 50, 46);

        Image icono_crud = getToolkit().createImage(ClassLoader.getSystemResource("IMG/icono_almacenes.png"));
        setIconImage(icono_crud);


        




        JPanel contenedorPrincipal = new JPanel(new BorderLayout());
        contenedorPrincipal.setBackground(colorPersonalizado2);
        contenedorPrincipal.setBorder(new EmptyBorder(5, 12, 12, 12));

        JLabel tituloPricncipal = new JLabel("LISTA USUARIOS");
        tituloPricncipal.setBorder(new EmptyBorder(5, 76, 7, 0));
        tituloPricncipal.setFont(new Font("Arial", Font.BOLD, 18));
        tituloPricncipal.setForeground(letras);
        contenedorPrincipal.add(tituloPricncipal, BorderLayout.NORTH);

        JPanel contenedorItems = new JPanel(new GridBagLayout());
        contenedorItems.setBackground(Color.WHITE);
        contenedorPrincipal.add(contenedorItems, BorderLayout.CENTER);
        GridBagConstraints restriccion = new GridBagConstraints();

        JScrollPane scrollPane = new JScrollPane(contenedorItems);
        scrollPane.setBorder(null);
        contenedorPrincipal.add(scrollPane, BorderLayout.CENTER);

        int alturaLabel = 50;

		for (int i = 0; i < arraylabels.length; i++) {
			arraylabels[i] = new JLabel();

			// Crear el borde con una línea inferior gris
			Border bordeInferior = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE);

			// Aplicar el borde al JLabel
			arraylabels[i].setBorder(bordeInferior);

			restriccion.gridy = i;
			restriccion.gridx = 0;
			restriccion.gridheight = 1;
			restriccion.gridwidth = 4;
			restriccion.weighty = 1;
			restriccion.weightx = 100;
			restriccion.fill = GridBagConstraints.BOTH;
			restriccion.insets = new Insets(0, 0, 0, 0);

			contenedorItems.add(arraylabels[i], restriccion);

			// Establecer el tamaño preferido del JLabel
			arraylabels[i].setPreferredSize(new Dimension(arraylabels[i].getPreferredSize().width, alturaLabel));
		}


        JPanel contenedorBotones = new JPanel(new FlowLayout());
        contenedorBotones.setBackground(colorPersonalizado2);
        contenedorBotones.setBorder(new EmptyBorder(3, 250, 0, 0));
        contenedorPrincipal.add(contenedorBotones, BorderLayout.SOUTH);

        GridBagConstraints restriccionesBusqueda = new GridBagConstraints();

        JButton botonVolver = new JButton("Atras");
        botonVolver.setForeground(Color.BLACK);
        botonVolver.setFont(new Font("Arial", Font.BOLD, 12));
        botonVolver.setBorder(new EmptyBorder(11, 35, 11, 35));
        contenedorBotones.add(botonVolver, restriccionesBusqueda);

        for (int i = 0; i < arrayPersonas.length; i++) {
            if (arrayPersonas[i] != null) {
                int indexlabel = i; 
                arraylabels[indexlabel] = new JLabel(i+ "  " + arrayPersonas[i].getCedula() + " - " + arrayPersonas[i].getNombre() + " " + arrayPersonas[i].getApellido());
                arraylabels[indexlabel].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE));
                arraylabels[indexlabel].setPreferredSize(new Dimension(arraylabels[indexlabel].getPreferredSize().width, alturaLabel));

                GridBagConstraints restriccionPersona = new GridBagConstraints(); 
                restriccionPersona.gridy = i; 
                restriccionPersona.gridx = 0;
                restriccionPersona.gridheight = 1;
                restriccionPersona.gridwidth = 4;
                restriccionPersona.weighty = 1;
                restriccionPersona.weightx = 100;
                restriccionPersona.fill = GridBagConstraints.BOTH;
                restriccionPersona.insets = new Insets(0, 0, 0, 0);

                contenedorItems.add(arraylabels[indexlabel], restriccionPersona); 
            }
        }

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaMenu.setVisible(true);
                dispose();
            }
        });

        add(contenedorPrincipal);

        setResizable(false);
        setVisible(true);
    }

}

