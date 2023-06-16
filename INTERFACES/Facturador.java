import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Facturador extends JFrame{

	// Atributos
    private Persona[] arrayClient;
    private Persona[] arraySeller;
    private Productos[] arrayProducts;
	private JLabel[] arraylabels = new JLabel[30];
    private boolean isClient;
    private boolean isSeller;
	private int indexlabel;
	private int acum_general;



	private JLabel etq_datos_cliente;
	private JLabel etq_cedula_cliente;
	private JLabel etq_nombres_cliente;
	private JLabel etq_direccion_cliente;
	private JLabel etq_datos_vendedor;
	private JLabel etq_vendedor_cliente;
	private JLabel etq_nombres_vendedor;
	private JLabel etq_datos_productos;
	private JLabel etq_id_producto;
	private JLabel etq_nombre_producto;
	private JLabel etq_cant_producto;
	private JLabel etq_btn_producto;
	private JLabel etq_resultado;
	private JLabel etq_total;
	private JTextField input_cedula_cliente;
	private JTextField input_nombres_cliente;
	private JTextField input_direccion_cliente;
	private JTextField input_cedula_vendedor;
	private JTextField input_nombres_vendedor;
	private JTextField input_id_producto;
	private JTextField input_nombre_producto;
	private JTextField input_cant_producto;
	private JButton btn_buscar_cliente;
	private JButton btn_buscar_vendedor;
	private JButton btn_add_producto;

	// Metodos
    public Facturador(Persona[] arrayClient, Persona[] arraySeller, Productos[] arrayProducts){
        this.arrayClient = arrayClient;
        this.arraySeller = arraySeller;
		this.arrayProducts = arrayProducts;
        this.isClient = true;
        this.isSeller = true;
		this.indexlabel = 0;
        initComponents();
    } 


	public void initComponents(){

		Toolkit sistema = Toolkit.getDefaultToolkit();
		Dimension tamanio = sistema.getScreenSize();

		setTitle("FACTURA");
		setSize( ((int) (tamanio.width*0.4)) , ((int) (tamanio.height*0.9)) );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setLocationRelativeTo(null);
		
		JPanel contPrincipal = new JPanel();
		contPrincipal.setLayout(new GridBagLayout());
		contPrincipal.setBorder( BorderFactory.createEmptyBorder(20, 20, 20, 10) );
		GridBagConstraints restriccion = new GridBagConstraints();

		etq_datos_cliente = new JLabel("DATOS CLIENTE:");
		etq_datos_cliente.setFont( new Font("Arial", Font.BOLD, 20) );
		etq_datos_cliente.setBorder( BorderFactory.createEmptyBorder(0, 0, 10, 0) );
		restriccion.gridy = 0;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 4;
		restriccion.weighty = 2;
		restriccion.weightx = 100;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_datos_cliente, restriccion );

		etq_cedula_cliente = new JLabel("CEDULA:");
		restriccion.gridy = 1;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_cedula_cliente, restriccion );

		input_cedula_cliente = new JTextField();
		input_cedula_cliente.setBorder( BorderFactory.createEmptyBorder(0, 10, 0, 10) );
		restriccion.gridy = 1;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 2;
		restriccion.weighty = 2;
		restriccion.weightx = 80;
		restriccion.insets = new Insets(0, 10, 0, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( input_cedula_cliente, restriccion );

		btn_buscar_cliente = new JButton("BUSCAR");
		restriccion.gridy = 1;
		restriccion.gridx = 3;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( btn_buscar_cliente, restriccion );

		etq_nombres_cliente = new JLabel("NOMBRES:");
		restriccion.gridy = 2;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(10, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_nombres_cliente, restriccion );

		input_nombres_cliente = new JTextField();
		input_nombres_cliente.setBorder( BorderFactory.createEmptyBorder(5, 10, 5, 10) );
		restriccion.gridy = 2;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 3;
		restriccion.weighty = 2;
		restriccion.weightx = 90;
		restriccion.insets = new Insets(10, 10, 10, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		input_nombres_cliente.setEditable(false);
		contPrincipal.add( input_nombres_cliente, restriccion );

		etq_direccion_cliente = new JLabel("DIRECCION:");
		restriccion.gridy = 3;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_direccion_cliente, restriccion );

		input_direccion_cliente = new JTextField();
		input_direccion_cliente.setBorder( BorderFactory.createEmptyBorder(5, 10, 5, 10) );
		restriccion.gridy = 3;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 3;
		restriccion.weighty = 2;
		restriccion.weightx = 90;
		restriccion.insets = new Insets(0, 10, 10, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		input_direccion_cliente.setEditable(false);
		contPrincipal.add( input_direccion_cliente, restriccion );

		etq_datos_vendedor = new JLabel("DATOS VENDEDOR:");
		etq_datos_vendedor.setFont( new Font("Arial", Font.BOLD, 20) );
		etq_datos_vendedor.setBorder( BorderFactory.createEmptyBorder(0, 0, 10, 0) );
		restriccion.gridy = 4;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 4;
		restriccion.weighty = 2;
		restriccion.weightx = 100;
		restriccion.insets = new Insets(10, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_datos_vendedor, restriccion );

		etq_vendedor_cliente = new JLabel("CEDULA:");
		restriccion.gridy = 5;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_vendedor_cliente, restriccion );

		input_cedula_vendedor = new JTextField();
		input_cedula_vendedor.setBorder( BorderFactory.createEmptyBorder(0, 10, 0, 10) );
		restriccion.gridy = 5;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 2;
		restriccion.weighty = 2;
		restriccion.weightx = 80;
		restriccion.insets = new Insets(0, 10, 0, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( input_cedula_vendedor, restriccion );

		btn_buscar_vendedor = new JButton("BUSCAR");
		restriccion.gridy = 5;
		restriccion.gridx = 3;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( btn_buscar_vendedor, restriccion );

		etq_nombres_vendedor = new JLabel("NOMBRES:");
		restriccion.gridy = 6;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(10, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_nombres_vendedor, restriccion );

		input_nombres_vendedor = new JTextField();
		input_nombres_vendedor.setBorder( BorderFactory.createEmptyBorder(5, 10, 5, 10) );
		restriccion.gridy = 6;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 3;
		restriccion.weighty = 2;
		restriccion.weightx = 90;
		restriccion.insets = new Insets(10, 10, 10, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		input_nombres_vendedor.setEditable(false);
		contPrincipal.add( input_nombres_vendedor, restriccion );

		etq_datos_productos = new JLabel("LISTA PRODUCTOS FACTURADOS:");
		etq_datos_productos.setFont( new Font("Arial", Font.BOLD, 20) );
		etq_datos_productos.setBorder( BorderFactory.createEmptyBorder(0, 0, 10, 0) );
		restriccion.gridy = 7;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 4;
		restriccion.weighty = 2;
		restriccion.weightx = 100;
		restriccion.insets = new Insets(10, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_datos_productos, restriccion );

		etq_id_producto = new JLabel("ID");
		etq_id_producto.setHorizontalAlignment( JLabel.CENTER );
		restriccion.gridy = 8;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_id_producto, restriccion );

		etq_nombre_producto = new JLabel("NOMBRE");
		etq_nombre_producto.setHorizontalAlignment( JLabel.CENTER );
		restriccion.gridy = 8;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 70;
		restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_nombre_producto, restriccion );

		etq_cant_producto = new JLabel("CANT.");
		etq_cant_producto.setHorizontalAlignment( JLabel.CENTER );
		restriccion.gridy = 8;
		restriccion.gridx = 2;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_cant_producto, restriccion );

		etq_btn_producto = new JLabel();
		restriccion.gridy = 8;
		restriccion.gridx = 3;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_btn_producto, restriccion );


		input_id_producto = new JTextField();
		input_id_producto.setHorizontalAlignment(JLabel.CENTER);
		restriccion.gridy = 9;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		input_id_producto.setEditable(false);
		input_id_producto.setEnabled(false);
		input_id_producto.setDisabledTextColor(Color.black);
		contPrincipal.add( input_id_producto, restriccion );

		input_nombre_producto = new JTextField();
		input_nombre_producto.setHorizontalAlignment(JLabel.CENTER);
		restriccion.gridy = 9;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 70;
		restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		input_nombre_producto.setEditable(false);
		input_nombre_producto.setEnabled(false);
		input_nombre_producto.setDisabledTextColor(Color.black);
		contPrincipal.add( input_nombre_producto, restriccion );

		input_cant_producto = new JTextField();
		input_cant_producto.setHorizontalAlignment(JLabel.CENTER);
		restriccion.gridy = 9;
		restriccion.gridx = 2;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		input_cant_producto.setEditable(false);
		input_cant_producto.setEnabled(false);
		input_cant_producto.setDisabledTextColor(Color.black);
		contPrincipal.add( input_cant_producto, restriccion );

		btn_add_producto = new JButton("ADD");
		restriccion.gridy = 9;
		restriccion.gridx = 3;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(0, 10, 0, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( btn_add_producto, restriccion );


		JPanel contenedorItems = new JPanel();
		contenedorItems.setLayout(new GridBagLayout());
		contenedorItems.setBackground(Color.white);
		
		JScrollPane scrollPane = new JScrollPane(contenedorItems);
		scrollPane.setBorder(null);

		restriccion.gridy = 10;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 4;
		restriccion.weighty = 89;
		restriccion.weightx = 100;
		restriccion.fill = GridBagConstraints.BOTH;
		restriccion.insets = new Insets(12, 0, 0, 0);
		contPrincipal.add(scrollPane, restriccion);

		int alturaLabel = 23;

		for (int i = 0; i < arraylabels.length; i++) {
			arraylabels[i] = new JLabel();

			// Crear el borde con una línea inferior gris
			Border bordeInferior = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY);

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

		etq_total = new JLabel("Total: $ 0");
		etq_total.setHorizontalAlignment( JLabel.RIGHT );
		etq_total.setFont( new Font("Arial", Font.BOLD, 20) );
		etq_total.setOpaque(true);
		etq_total.setBackground( Color.white );
		etq_total.setBorder( BorderFactory.createEmptyBorder(5, 10, 5, 10) );
		restriccion.gridy = 11;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 4;
		restriccion.weighty = 2;
		restriccion.weightx = 89;
		restriccion.fill = GridBagConstraints.BOTH;
		restriccion.insets = new Insets(0, 0, 0, 10);
		contPrincipal.add( etq_total, restriccion );


		add( contPrincipal );
		setResizable(false);
		setVisible(true);
		revalidate();
		repaint();

        KeyListener eventoBuscarClientes = new KeyListener() {

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    buscarClientes();
                }
            }

            public void keyTyped(KeyEvent e) {
            }
    	};

		KeyListener eventoBuscarVendedor = new KeyListener() {
			
			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscarVendedor();
				}
			}

			public void keyTyped(KeyEvent e) {
			}
		};

		KeyListener eventoBuscarProducto = new KeyListener() { 
			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				buscarProducto();
			}

			public void keyTyped(KeyEvent e) {
			}
		};

 		KeyListener eventoAddProducto = new KeyListener() {
			
			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					int id_producto = Integer.parseInt(input_id_producto.getText());
					int cant_producto = Integer.parseInt(input_cant_producto.getText());
					int indicador = 0;
					boolean estado = true;

					for(int i = 0; i < arrayProducts.length; i++){
						if(arrayProducts[i].getCodigo() == id_producto){
							indicador = i;
							estado = false;
							break;
						}
					}

					if(!estado){
						
						int total = arrayProducts[indicador].getPrecio() * cant_producto;

						acum_general += total;

						arraylabels[indexlabel] = new JLabel(arrayProducts[indicador].getNombre_producto()+" x "+cant_producto+" => "+total);
						arraylabels[indexlabel].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
						arraylabels[indexlabel].setPreferredSize(new Dimension(arraylabels[indexlabel].getPreferredSize().width, alturaLabel)); // Establecer tamaño fijo

						restriccion.gridy = indexlabel;
						restriccion.gridx = 0;
						restriccion.gridheight = 1;
						restriccion.gridwidth = 4;
						restriccion.weighty = 1;
						restriccion.weightx = 100;
						restriccion.fill = GridBagConstraints.BOTH;
						restriccion.insets = new Insets(0, 0, 0, 0);
						arraylabels[indexlabel].setHorizontalAlignment( JLabel.RIGHT );
						arraylabels[indexlabel].setBorder( new EmptyBorder(0,0,0,6));
						
						contenedorItems.add(arraylabels[indexlabel], restriccion);

						contenedorItems.revalidate();
						contenedorItems.repaint();

						input_id_producto.setText("");
						input_cant_producto.setText("");
						input_id_producto.requestFocus();

						indexlabel++;

						etq_total.setText("Total: $ "+acum_general);
							
						}
				}
				
			}
	

			public void keyTyped(KeyEvent e) {
			}
		};


		input_cedula_cliente.addKeyListener(eventoBuscarClientes);

		input_cedula_vendedor.addKeyListener(eventoBuscarVendedor);

		input_id_producto.addKeyListener(eventoBuscarProducto);

		input_cant_producto.addKeyListener(eventoAddProducto);


		ActionListener eventoBuscarClient = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				buscarClientes();
			}
		};

		ActionListener eventoBuscarSeller = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				buscarVendedor();
			}
		};

		ActionListener eventoBuscarProduct = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int id_producto = Integer.parseInt(input_id_producto.getText());
				int cant_producto = Integer.parseInt(input_cant_producto.getText());
				int indicador = 0;
				boolean estado = true;

				for(int i = 0; i < arrayProducts.length; i++){
					if(arrayProducts[i].getCodigo() == id_producto){
						indicador = i;
						estado = false;
						break;
					}
				}

				if(!estado){
					
					int total = arrayProducts[indicador].getPrecio() * cant_producto;

					acum_general += total;

					arraylabels[indexlabel] = new JLabel(arrayProducts[indicador].getNombre_producto()+" x "+cant_producto+" => "+total);
					arraylabels[indexlabel].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
					arraylabels[indexlabel].setPreferredSize(new Dimension(arraylabels[indexlabel].getPreferredSize().width, alturaLabel)); // Establecer tamaño fijo

					restriccion.gridy = indexlabel;
					restriccion.gridx = 0;
					restriccion.gridheight = 1;
					restriccion.gridwidth = 4;
					restriccion.weighty = 1;
					restriccion.weightx = 100;
					restriccion.fill = GridBagConstraints.BOTH;
					restriccion.insets = new Insets(0, 0, 0, 0);
					arraylabels[indexlabel].setHorizontalAlignment( JLabel.RIGHT );

					contenedorItems.add(arraylabels[indexlabel], restriccion);

					contenedorItems.revalidate();
					contenedorItems.repaint();

					input_id_producto.setText("");
					input_cant_producto.setText("");
					input_id_producto.requestFocus();

					indexlabel++;

					etq_total.setText("Total: $ "+acum_general);
						
					}
			}
		};

		btn_buscar_cliente.addActionListener(eventoBuscarClient);

		btn_buscar_vendedor.addActionListener(eventoBuscarSeller);

		btn_add_producto.addActionListener(eventoBuscarProduct);

	}
	/* ------------------------------------- */
	/* METODOS ADICIONALES                   */
	/* ------------------------------------- */

    public void buscarClientes(){
        int cedula_cliente = Integer.parseInt(input_cedula_cliente.getText());
        int indicador = 0;
        boolean estado = true;

        for(int i = 0; i < arrayClient.length; i++){
            if(arrayClient[i].getCedula() == cedula_cliente){
                indicador = i;
                estado = false;
				isClient = false;

                break;
            }
        }

        if(!estado){
            input_nombres_cliente.setText(arrayClient[indicador].getNombre()+" "+arrayClient[indicador].getApellido());
            input_direccion_cliente.setText(arrayClient[indicador].getDireccion());

			input_cedula_vendedor.requestFocus();
        }else{
            input_nombres_cliente.setText("");
            input_direccion_cliente.setText("");
        }

        input_cedula_cliente.setText("");

		if(!isSeller && !isClient){
			input_id_producto.setEditable(true);
			input_id_producto.setEnabled(true);
			input_id_producto.setDisabledTextColor(Color.white);

			input_cant_producto.setEditable(true);
			input_cant_producto.setEnabled(true);
			input_cant_producto.setDisabledTextColor(Color.white);

			input_id_producto.requestFocus();

		}
	}

	public void buscarVendedor(){
		int cedula_vendedor = Integer.parseInt(input_cedula_vendedor.getText());
		int indicador = 0;
		boolean estado = true;

		for(int i = 0; i < arraySeller.length; i++){
			if(arraySeller[i].getCedula() == cedula_vendedor){
				indicador = i;
				estado = false;
				isSeller = false;
				break;
			}
		}

		if(!estado){
			input_nombres_vendedor.setText(arraySeller[indicador].getNombre()+" "+arraySeller[indicador].getApellido());
		}else{
			input_nombres_vendedor.setText("");
		}

		input_cedula_vendedor.setText("");

		if(!isSeller && !isClient){
			input_id_producto.setEditable(true);
			input_id_producto.setEnabled(true);
			input_id_producto.setDisabledTextColor(Color.white);

			input_cant_producto.setEditable(true);
			input_cant_producto.setEnabled(true);
			input_cant_producto.setDisabledTextColor(Color.white);

			input_id_producto.requestFocus();
		}

	}
	
	public void buscarProducto(){
		int id_producto = Integer.parseInt(input_id_producto.getText());
		int indicador = 0;
		boolean estado = true;

		for(int i = 0; i < arrayProducts.length; i++){
			if(arrayProducts[i].getCodigo() == id_producto){
				indicador = i;
				estado = false;
				break;
			}
		}

		if(!estado){
			input_nombre_producto.setText(arrayProducts[indicador].getNombre_producto());
			input_cant_producto.requestFocus();
		}


	}

	
}

