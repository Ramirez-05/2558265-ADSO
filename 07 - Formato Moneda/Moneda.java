import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;



public class Moneda extends JFrame {
    
    JTextField campo_llenar;
    JLabel resultado;


    public Moneda(){
        initcomponents();
    }

    public void  initcomponents(){
        setTitle("Formato Moneda");
        setLocationRelativeTo(null);
        setSize(960, 540);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        Image icono = getToolkit().createImage( ClassLoader.getSystemResource("imagenes/icono_moneda.png") );
        setIconImage(icono);    

        JPanel container = new JPanel();
		container.setBorder( new EmptyBorder(15,15,15,15) );
        GridBagLayout capa_principal = new GridBagLayout();
        container.setLayout(capa_principal);

        GridBagConstraints restriccion = new GridBagConstraints();

        JLabel etiqueta_cantidad = new JLabel("Cantidad");
        restriccion.gridy = 0;
        restriccion.gridx = 0;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 5;
        restriccion.weighty = 10;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(etiqueta_cantidad, restriccion);

        campo_llenar = new JTextField();
        restriccion.gridy = 0;
        restriccion.gridx = 1 ;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 90;
        restriccion.weighty = 10;
        restriccion.insets = new Insets(0, 10, 0, 15);
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(campo_llenar, restriccion);

        JButton btn_1 = new JButton("EJECUTAR");
        restriccion.gridy = 0;
        restriccion.gridx = 2 ;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 5;
        restriccion.weighty = 10;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(btn_1, restriccion);

        resultado = new JLabel("----");
        restriccion.gridy = 1;
        restriccion.gridx = 0;
        restriccion.gridwidth = 3;
        restriccion.gridheight = 1;
        restriccion.weightx = 100;
        restriccion.weighty = 90;
        restriccion.fill = GridBagConstraints.CENTER;
        resultado.setFont(new Font ("Arial", Font.BOLD, 60) );
        container.add(resultado, restriccion);

        add(container);
        revalidate();
        setVisible(true);

        ActionListener eventoRegistrar = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				recreandoFormato();
			}
		};

        btn_1.addActionListener(eventoRegistrar);

        
    }

    public void recreandoFormato(){
        
        int num_1 = Integer.parseInt(campo_llenar.getText());

        

        String cantidadFormateada = String.format("%,d", num_1).replace(",", ".");
        resultado.setText("$"+cantidadFormateada);
        campo_llenar.setText("");
    }


}


