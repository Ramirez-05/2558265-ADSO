import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.lang.reflect.Array;


public class Factura extends JFrame {
    
    public Factura(){
        initcomponents();
    } 

    public void initcomponents(){

        setTitle("Factura");
        setLocationRelativeTo(null);
        setSize(614, 778);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        //Image icono = getToolkit().createImage( ClassLoader.getSystemResource("imagenes/icono_moneda.png") );
        //setIconImage(icono);    

        JPanel container = new JPanel();
        container.setBorder( new EmptyBorder(0,16,0,16) );
        GridBagLayout capa_principal = new GridBagLayout();
        container.setLayout(capa_principal);

        GridBagConstraints restriccion = new GridBagConstraints();

        // DATOS CLIENTE

        JLabel title_factura = new JLabel("DATOS CLIENTE: ");
        restriccion.gridy = 0;
        restriccion.gridx = 0;
        restriccion.gridwidth = 4;
        restriccion.gridheight = 1;
        restriccion.weightx = 100;
        restriccion.weighty = 1;
        restriccion.insets = new Insets(9, 0, 0, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        title_factura.setFont(new Font ("Arial", Font.BOLD, 20) );
        container.add(title_factura, restriccion);

        JLabel etiqueta_cedula = new JLabel("CEDULA: ");
        restriccion.gridy = 1;
        restriccion.gridx = 0;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 10;
        restriccion.weighty = 1;
        restriccion.fill = GridBagConstraints.BOTH;
        etiqueta_cedula.setFont(new Font ("Arial", Font.BOLD, 12));
        container.add(etiqueta_cedula, restriccion);

        JTextField campo_cedula = new JTextField();
        restriccion.gridy = 1;
        restriccion.gridx = 1 ;
        restriccion.gridwidth = 2;
        restriccion.gridheight = 1;
        restriccion.weightx = 80;
        restriccion.weighty = 1;
        restriccion.insets = new Insets(0, 0, 0, 13);
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(campo_cedula, restriccion);

        JButton btn_1 = new JButton("BUSCAR");
        restriccion.gridy = 1;
        restriccion.gridx = 3 ;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 10;
        restriccion.weighty = 1;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(btn_1, restriccion);

        JLabel etiqueta_nombre = new JLabel("NOMBRES: ");
        restriccion.gridy = 2;
        restriccion.gridx = 0;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 10;
        restriccion.weighty = 1;
        restriccion.fill = GridBagConstraints.BOTH;
        restriccion.insets = new Insets(5, 0, 0, 0);
        etiqueta_nombre.setFont(new Font ("Arial", Font.BOLD, 12));
        container.add(etiqueta_nombre, restriccion);

        JLabel campo_nombre = new JLabel();
        restriccion.gridy = 2;
        restriccion.gridx = 1 ;
        restriccion.gridwidth = 3;
        restriccion.gridheight = 1;
        restriccion.weightx = 90;
        restriccion.weighty = 1;
        restriccion.insets = new Insets(5, 5, 0, 5);
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(campo_nombre, restriccion);

        JLabel etiqueta_direccion = new JLabel("DIRECCION: ");
        restriccion.gridy = 3;
        restriccion.gridx = 0;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 10;
        restriccion.weighty = 1;
        restriccion.fill = GridBagConstraints.BOTH;
        restriccion.insets = new Insets(5, 0, 0, 0);
        etiqueta_direccion.setFont(new Font ("Arial", Font.BOLD, 12));
        container.add(etiqueta_direccion, restriccion);

        JLabel campo_direccion = new JLabel();
        restriccion.gridy = 3;
        restriccion.gridx = 1 ;
        restriccion.gridwidth = 3;
        restriccion.gridheight = 1;
        restriccion.weightx = 90;
        restriccion.weighty = 1;
        restriccion.insets = new Insets(5, 5, 0, 5);
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(campo_direccion, restriccion);

        // DATOS VENDEDOR

        JLabel title_vendedor = new JLabel("DATOS VENDEDOR: ");
        restriccion.gridy = 4;
        restriccion.gridx = 0;
        restriccion.gridwidth = 4;
        restriccion.gridheight = 1;
        restriccion.weightx = 100;
        restriccion.weighty = 1;
        restriccion.insets = new Insets(11, 0, 0, 0);

        restriccion.fill = GridBagConstraints.BOTH;
        title_vendedor.setFont(new Font ("Arial", Font.BOLD, 20) );
        container.add(title_vendedor, restriccion);

        JLabel etiqueta_cd_client = new JLabel("CEDULA: ");
        restriccion.gridy = 5;
        restriccion.gridx = 0;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 10;
        restriccion.weighty = 1;
        restriccion.insets = new Insets(5, 0, 0, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        etiqueta_cd_client.setFont(new Font ("Arial", Font.BOLD, 12));
        container.add(etiqueta_cd_client, restriccion);

        JTextField campo_cd_client = new JTextField();
        restriccion.gridy = 5;
        restriccion.gridx = 1 ;
        restriccion.gridwidth = 2;
        restriccion.gridheight = 1;
        restriccion.weightx = 80;
        restriccion.weighty = 1;
        restriccion.insets = new Insets(0, 0, 0, 13);
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(campo_cd_client, restriccion);

        JButton btn_2 = new JButton("BUSCAR");
        restriccion.gridy = 5;
        restriccion.gridx = 3 ;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 10;
        restriccion.weighty = 1;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(btn_2, restriccion);

        JLabel etiqueta_name_client = new JLabel("NOMBRES: ");
        restriccion.gridy = 6;
        restriccion.gridx = 0;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 10;
        restriccion.weighty = 1;
        restriccion.fill = GridBagConstraints.BOTH;
        restriccion.insets = new Insets(5, 0, 0, 0);
        etiqueta_name_client.setFont(new Font ("Arial", Font.BOLD, 12));
        container.add(etiqueta_name_client, restriccion);

        JLabel campo_name_client = new JLabel();
        restriccion.gridy = 6;
        restriccion.gridx = 1 ;
        restriccion.gridwidth = 3;
        restriccion.gridheight = 1;
        restriccion.weightx = 90;
        restriccion.weighty = 1;
        restriccion.insets = new Insets(5, 5, 0, 5);
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(campo_name_client, restriccion);

        JLabel title_productos = new JLabel("LISTA DE PRODUCTOS FACTURADOS : ");
        restriccion.gridy = 7;
        restriccion.gridx = 0;
        restriccion.gridwidth = 4;
        restriccion.gridheight = 1;
        restriccion.weightx = 100;
        restriccion.weighty = 1;
        restriccion.insets = new Insets(11, 0, 0, 0);

        restriccion.fill = GridBagConstraints.BOTH;
        title_productos.setFont(new Font ("Arial", Font.BOLD, 20) );
        container.add(title_productos, restriccion);

        JLabel title_id = new JLabel("ID");
        restriccion.gridy = 8;
        restriccion.gridx = 0;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 15;
        restriccion.weighty = 1;
        title_id.setHorizontalAlignment(SwingConstants.CENTER);
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(title_id, restriccion);

        JLabel title_nombre = new JLabel("NOMBRE");
        restriccion.gridy = 8;
        restriccion.gridx = 1;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 75;
        restriccion.weighty = 1;
        title_nombre.setHorizontalAlignment(SwingConstants.CENTER);
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(title_nombre, restriccion);

        JLabel title_cant = new JLabel("CANT ");
        restriccion.gridy = 8;
        restriccion.gridx = 2;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 10;
        restriccion.weighty = 1;
        title_cant.setHorizontalAlignment(SwingConstants.CENTER);
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(title_cant, restriccion);

        JTextField campo_ide = new JTextField();
        restriccion.gridy = 9;
        restriccion.gridx = 0 ;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 5;
        restriccion.weighty = 1;
        campo_ide.setEnabled(false);
        campo_ide.setOpaque(false);
        campo_ide.setBackground(new Color(0, 0, 0, 0));
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(campo_ide, restriccion);

        JTextField campo_name_produc = new JTextField();
        restriccion.gridy = 9;
        restriccion.gridx = 1 ;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 80;
        restriccion.weighty = 1;
        campo_name_produc.setEnabled(false);
        campo_name_produc.setOpaque(false);
        campo_name_produc.setBackground(new Color(0, 0, 0, 0));
        restriccion.insets = new Insets(0, 0, 0, 1);
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(campo_name_produc, restriccion);

        JTextField campo_cant = new JTextField();
        restriccion.gridy = 9;
        restriccion.gridx = 2 ;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 5;
        restriccion.weighty = 1;
        campo_cant.setEnabled(false);
        campo_cant.setOpaque(false);
        campo_cant.setBackground(new Color(0, 0, 0, 0));
        restriccion.insets = new Insets(0, 1, 0, 5);
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(campo_cant, restriccion);

        JButton btn_3 = new JButton("ADD");
        restriccion.gridy = 9;
        restriccion.gridx = 3 ;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 10;
        restriccion.weighty = 1;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(btn_3, restriccion);

        JTextArea area = new JTextArea("----");
        area.setBorder( new EmptyBorder(0,515,0,10) );
        area.setEditable(false);
        restriccion.gridy = 10;
        restriccion.gridx = 0 ;
        restriccion.gridwidth = 4;
        restriccion.gridheight = 1;
        restriccion.weightx = 100;
        restriccion.weighty = 20;
        restriccion.anchor = GridBagConstraints.SOUTHEAST;
        restriccion.insets = new Insets(14, 6, 0, 6);
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(area, restriccion);

        JLabel totalLabel = new JLabel("Total = $0");
        totalLabel.setOpaque(true);
        totalLabel.setBackground(Color.WHITE);
        totalLabel.setFont(new Font ("Arial", Font.BOLD, 20) );
        totalLabel.setBorder( new EmptyBorder(8,445,8,10) );
        restriccion.gridy = 11;
        restriccion.gridx = 0;
        restriccion.gridwidth = 100;
        restriccion.gridheight = 2;
        restriccion.weightx = 0;
        restriccion.weighty = 0;
        restriccion.insets = new Insets(0, 6, 18, 6);
        container.add(totalLabel, restriccion);



        add(container);
        revalidate();
        setVisible(true);

        KeyListener eventoKey = new KeyListener(){
            public void keyPressed(KeyEvent e){
            }
        
            public void keyReleased(KeyEvent e){
                int num_1 = Integer.parseInt(campo_cedula.getText());
                
                int num_2 = Integer.parseInt(campo_cd_client.getText());

                






            }
        
            public void keyTyped(KeyEvent e){
            }
        };
        







    }

}



