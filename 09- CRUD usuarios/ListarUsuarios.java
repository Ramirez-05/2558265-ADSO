import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;


public class ListarUsuarios extends JFrame {

    private Persona arrayPersonas[];
    private JLabel arraylabels[] = new JLabel[100];

    public ListarUsuarios(Persona arrayPersonas[]) {
        this.arrayPersonas = arrayPersonas;
        initComponents();
    }

    private void initComponents() {
        setTitle("Usuarios");
        setSize(375, 432);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color colorPersonalizado1 = new Color(0, 0, 102);
        Color colorPersonalizado2 = new Color(153, 153, 255);
        Color colorPersonalizado3 = Color.WHITE;
        Color colorBotones = new Color(231, 239, 245);
        Color letras = new Color(51, 50, 46);

        




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
			arraylabels[i].setHorizontalAlignment( JLabel.RIGHT );

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


        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Crud ventana = new Crud(arrayPersonas);
            }
        });




        

        add(contenedorPrincipal);

        setResizable(false);
        setVisible(true);
    }

}

