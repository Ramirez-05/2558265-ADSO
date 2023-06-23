import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Minas extends JFrame {
    
    private JButton[][] arraybtns;
    private int[][] tableroNumerico;
    private int fila = 9;
    private int columna = 9;
    private int cantidadMinas = 15;
    private int minasGeneradas = 0;

    private Dimension buttonSize;

    private JButton btnReiniciar;


    public Minas(){
        arraybtns = new JButton[fila][columna];
        tableroNumerico = new int[fila][columna];
        buttonSize = new Dimension(20, 20);
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
            
                arraybtns [i][j].setPreferredSize(buttonSize); 

                restriccion.gridy = i+1;
                restriccion.gridx = j;
                restriccion.gridheight = 1;
                restriccion.gridwidth = 1; 
                restriccion.weighty = 2;
                restriccion.weightx = 20;
                restriccion.fill = GridBagConstraints.BOTH;
                contPrincipal.add(arraybtns[i][j], restriccion);

                final int fila = i;
                final int columna = j;
                ActionListener evento = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        destaparCasilla( fila, columna);
                    }                    
                };
                this.arraybtns[i][j].addActionListener(evento);
            }
        }

        generarMinas();

        add(contPrincipal);
    	setResizable(false);
		setVisible(true);
		revalidate();
		repaint();

        ActionListener evento_happy = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarjuego();
            }
        };
        btnReiniciar.addActionListener(evento_happy);
    }

    public void reiniciarjuego(){

        //reiniciar botones
        for (int i = 0; i<this.arraybtns.length; i++) {
            for (int j = 0; j<this.arraybtns[0].length; j++) {
                this.tableroNumerico[i][j] = 0;
                this.arraybtns[i][j].setEnabled(true);
            }
        }

        generarMinas();
    }

    public void generarMinas() {
        minasGeneradas = 0;

        // Llenar el tablero con 0
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                tableroNumerico[i][j] = 0;
            }
        }

        // Asignar las minas
        while (minasGeneradas < cantidadMinas) {
            int filaAleatoria = (int) (Math.random() * fila);
            int columnaAleatoria = (int) (Math.random() * columna);

            if (tableroNumerico[filaAleatoria][columnaAleatoria] == 0) {
                tableroNumerico[filaAleatoria][columnaAleatoria] = 9;
                minasGeneradas++;
            }
        }

        completarNumerosAlrededor();

        for (int i = 0; i<this.tableroNumerico.length; i++) {
            for (int j = 0; j<this.tableroNumerico[0].length; j++) {
                System.out.print("["+this.tableroNumerico[i][j]+"]");
            }
            System.out.println();
        }
    }

    public void destaparCasilla(int fila, int columna){

        if(tableroNumerico[fila][columna] == 0 ){
            ImageIcon img_blanco = new ImageIcon("img/icono_espacio.png");
            ImageIcon icono_blanco = new ImageIcon(img_blanco.getImage().getScaledInstance(buttonSize.width,buttonSize.height, Image.SCALE_SMOOTH));
            this.arraybtns[fila][columna].setDisabledIcon(icono_blanco);
            this.arraybtns[fila][columna].setIcon(icono_blanco);
            this.arraybtns[fila][columna].setEnabled(false);

            //destaparCasillasAlrededor(fila, columna);

        }

        if(tableroNumerico[fila][columna] == 1 ){
            ImageIcon img_uno = new ImageIcon("img/icono_num_1.png");
            ImageIcon icono_uno = new ImageIcon(img_uno.getImage().getScaledInstance(buttonSize.width,buttonSize.height, Image.SCALE_SMOOTH));
            this.arraybtns[fila][columna].setDisabledIcon(icono_uno);
            this.arraybtns[fila][columna].setIcon(icono_uno);
            this.arraybtns[fila][columna].setEnabled(false);
        }

        if(tableroNumerico[fila][columna] == 2 ){
            ImageIcon img_dos = new ImageIcon("img/icono_num_2.png");
            ImageIcon icono_dos = new ImageIcon(img_dos.getImage().getScaledInstance(buttonSize.width,buttonSize.height, Image.SCALE_SMOOTH));
            this.arraybtns[fila][columna].setDisabledIcon(icono_dos);
            this.arraybtns[fila][columna].setIcon(icono_dos);
            this.arraybtns[fila][columna].setEnabled(false);
        }

        if(tableroNumerico[fila][columna] == 3 ){
            ImageIcon img_tres = new ImageIcon("img/icono_num_3.png");
            ImageIcon icono_tres = new ImageIcon(img_tres.getImage().getScaledInstance(buttonSize.width,buttonSize.height, Image.SCALE_SMOOTH));
            this.arraybtns[fila][columna].setDisabledIcon(icono_tres);
            this.arraybtns[fila][columna].setIcon(icono_tres);
            this.arraybtns[fila][columna].setEnabled(false);
        }

        if(tableroNumerico[fila][columna] == 4 ){
            ImageIcon img_cuatro = new ImageIcon("img/icono_num_4.png");
            ImageIcon icono_cuatro = new ImageIcon(img_cuatro.getImage().getScaledInstance(buttonSize.width,buttonSize.height, Image.SCALE_SMOOTH));
            this.arraybtns[fila][columna].setDisabledIcon(icono_cuatro);
            this.arraybtns[fila][columna].setIcon(icono_cuatro);
            this.arraybtns[fila][columna].setEnabled(false);
        }

        if(tableroNumerico[fila][columna] == 5 ){
            ImageIcon img_cinco = new ImageIcon("img/icono_num_5.png");
            ImageIcon icono_cinco = new ImageIcon(img_cinco.getImage().getScaledInstance(buttonSize.width,buttonSize.height, Image.SCALE_SMOOTH));
            this.arraybtns[fila][columna].setDisabledIcon(icono_cinco);
            this.arraybtns[fila][columna].setIcon(icono_cinco);
            this.arraybtns[fila][columna].setEnabled(false);
        }

        if(tableroNumerico[fila][columna] == 6 ){
            ImageIcon img_seis = new ImageIcon("img/icono_num_6.png");
            ImageIcon icono_seis = new ImageIcon(img_seis.getImage().getScaledInstance(buttonSize.width,buttonSize.height, Image.SCALE_SMOOTH));
            this.arraybtns[fila][columna].setDisabledIcon(icono_seis);
            this.arraybtns[fila][columna].setIcon(icono_seis);
            this.arraybtns[fila][columna].setEnabled(false);
        }

        if(tableroNumerico[fila][columna] == 7 ){
            ImageIcon img_siete = new ImageIcon("img/icono_num_7.png");
            ImageIcon icono_siete = new ImageIcon(img_siete.getImage().getScaledInstance(buttonSize.width,buttonSize.height, Image.SCALE_SMOOTH));
            this.arraybtns[fila][columna].setDisabledIcon(icono_siete);
            this.arraybtns[fila][columna].setIcon(icono_siete);
            this.arraybtns[fila][columna].setEnabled(false);
        }

        if(tableroNumerico[fila][columna] == 8 ){
            ImageIcon img_ocho = new ImageIcon("img/icono_num_8.png");
            ImageIcon icono_ocho = new ImageIcon(img_ocho.getImage().getScaledInstance(buttonSize.width,buttonSize.height, Image.SCALE_SMOOTH));
            this.arraybtns[fila][columna].setDisabledIcon(icono_ocho);
            this.arraybtns[fila][columna].setIcon(icono_ocho);
            this.arraybtns[fila][columna].setEnabled(false);
        }

        if(tableroNumerico[fila][columna] == 9 ){
            ImageIcon img_mina = new ImageIcon("img/icono_bomba.png");
            ImageIcon icono_mina = new ImageIcon(img_mina.getImage().getScaledInstance(buttonSize.width,buttonSize.height, Image.SCALE_SMOOTH));
            this.arraybtns[fila][columna].setDisabledIcon(icono_mina);
            this.arraybtns[fila][columna].setIcon(icono_mina);
            this.arraybtns[fila][columna].setEnabled(false);
        }


    }
    
    public void destaparCasillasAlrededor(int fila, int columna) {
        // Arriba
        if (fila - 1 >= 0 && this.arraybtns[fila - 1][columna].isEnabled()) {
            destaparCasilla(fila - 1, columna);
        }
        
        // Abajo
        if (fila + 1 < this.arraybtns[0].length && this.arraybtns[fila + 1][columna].isEnabled()) {
            destaparCasilla(fila + 1, columna);
        }
        
        // Izquierda
        if (columna - 1 >= 0 && this.arraybtns[fila][columna - 1].isEnabled()) {
            destaparCasilla(fila, columna - 1);
        }
        
        // Derecha
        if (columna + 1 < this.arraybtns[0].length && this.arraybtns[fila][columna + 1].isEnabled()) {
            destaparCasilla(fila, columna + 1);
        }
        
        // Arriba-Izquierda
        if (fila - 1 >= 0 && columna - 1 >= 0 && this.arraybtns[fila - 1][columna - 1].isEnabled()) {
            destaparCasilla(fila - 1, columna - 1);
        }
        
        // Arriba-Derecha
        if (fila - 1 >= 0 && columna + 1 < this.arraybtns[0].length && this.arraybtns[fila - 1][columna + 1].isEnabled()) {
            destaparCasilla(fila - 1, columna + 1);
        }
        
        // Abajo-Izquierda
        if (fila + 1 < this.arraybtns[0].length && columna - 1 >= 0 && this.arraybtns[fila + 1][columna - 1].isEnabled()) {
            destaparCasilla(fila + 1, columna - 1);
        }
        
        // Abajo-Derecha
        if (fila + 1 < this.arraybtns[0].length && columna + 1 < this.arraybtns[0].length && this.arraybtns[fila + 1][columna + 1].isEnabled()) {
            destaparCasilla(fila + 1, columna + 1);
        }
    }

    public void completarNumerosAlrededor(){
        int limite_filas = this.tableroNumerico.length;
        int limite_columnas = this.tableroNumerico[0].length;
        
        for (int i = 0; i<limite_filas; i++) {
            for (int j = 0; j<limite_columnas; j++) {
                if(this.tableroNumerico[i][j]==0){
                    int contador = 0;
                    
                    if( i-1>=0 && j-1>=0 && this.tableroNumerico[i-1][j-1]==9 ){
                        contador++;
                    }
                    
                    if ( i-1>=0 && this.tableroNumerico[i-1][j]==9) {
                        contador++;
                    }
                    
                    if ( i-1>=0 && j+1<limite_columnas && this.tableroNumerico[i-1][j+1]==9 ) {
                        contador++;
                    }
                    
                    if ( j-1>=0 && this.tableroNumerico[i][j-1]==9 ) {
                        contador++;
                    }
                    
                    if ( j+1<limite_columnas && this.tableroNumerico[i][j+1]==9 ) {
                        contador++;
                    }
                    
                    if ( i+1<limite_filas && j-1>=0 && this.tableroNumerico[i+1][j-1]==9 ) {
                        contador++;
                    }
                    
                    if ( i+1<limite_filas && this.tableroNumerico[i+1][j]==9 ) {
                        contador++;
                    }
                    
                    if ( i+1<limite_filas && j+1<limite_columnas && this.tableroNumerico[i+1][j+1]==9 ) {
                        contador++;
                    }
                    
                    this.tableroNumerico[i][j]=contador;
                }
            }
        }
        
    }

}

