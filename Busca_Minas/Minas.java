import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Minas extends JFrame {
    
    private JButton[][] arraybtns;


    public Minas(){
        arraybtns = new JButton[9][9];

        initComponnets();
    }

    private void initComponnets() {

        setTitle("BuscaMinas");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contPrincipal = new JPanel();
        contPrincipal.setLayout(new GridBagLayout());
		contPrincipal.setBorder( BorderFactory.createEmptyBorder(6, 10, 10, 10) );
		GridBagConstraints restriccion = new GridBagConstraints();

        JLabel primerCuadro = new JLabel("020");
        primerCuadro.setFont( new Font("Arial", Font.BOLD, 32) );
        primerCuadro.setBackground(Color.BLACK);
        primerCuadro.setOpaque(true);
        primerCuadro.setForeground(Color.RED);
        primerCuadro.setBorder(new EmptyBorder(5, 10, 5, 10));

        restriccion.gridy = 0;
        restriccion.gridx = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 3; 
        restriccion.weighty = 1;
        restriccion.weightx = 1;
        contPrincipal.add(primerCuadro, restriccion);
    

        // Crear el botón y establecer la imagen como icono
        JButton btnReiniciar = new JButton();
        ImageIcon icono = new ImageIcon("img/icono_happy.png");
        ImageIcon iconoReiniciar = new ImageIcon(icono.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnReiniciar.setFocusPainted(false);
        btnReiniciar.setIcon(iconoReiniciar);
        btnReiniciar.setBorder(new EmptyBorder(10, 10, 10, 10));

        restriccion.gridy = 0;
        restriccion.gridx = 3;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 3; 
        restriccion.weightx = 1;
        restriccion.weighty = 1;
        contPrincipal.add(btnReiniciar, restriccion);

        JLabel segundoCuadro = new JLabel("000");
        segundoCuadro.setFont( new Font("Arial", Font.BOLD, 32) );
        segundoCuadro.setBackground(Color.BLACK);
        segundoCuadro.setOpaque(true);
        segundoCuadro.setForeground(Color.RED);
        segundoCuadro.setBorder(new EmptyBorder(5, 10, 5, 10));

        restriccion.gridy = 0;
        restriccion.gridx = 6;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 3; 
        restriccion.weighty = 1;
        restriccion.weightx = 1;
        contPrincipal.add(segundoCuadro, restriccion);

        for(int i=0; i<9; i++){
            for(int j=0; j<9;j++){
                arraybtns[i][j] = new JButton();

                restriccion.gridy = i+1;
                restriccion.gridx = j;
                restriccion.gridheight = 1;
                restriccion.gridwidth = 1; 
                restriccion.weighty = 2;
                restriccion.weightx = 20;
                restriccion.fill = GridBagConstraints.BOTH;
                contPrincipal.add(arraybtns[i][j], restriccion);

            }
        }

        add(contPrincipal);
    	setResizable(false);
		setVisible(true);
		revalidate();
		repaint();

        ActionListener eventoBuscarClient = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				reiniciarjuego();
			}
		};

    }


    public void reiniciarjuego(){
        System.out.println("Reiniciando juego");
    }

}
