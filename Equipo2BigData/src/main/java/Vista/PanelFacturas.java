package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

import Controlador.ControladorPanelFacturas;

public class PanelFacturas extends JPanel {

	private static final long serialVersionUID = -8519282282238553342L;
	private JLabel lblTextoPanel;
	private JButton btnVolver;
	private ControladorPanelFacturas controladorPanelFacturas;
	private JTextField textNIF;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textFieldFecha;
	private JTextField textFieldNumTrans;
	private JTextField textCantidad;
	@SuppressWarnings("rawtypes")
	private JList listaProductos;
	@SuppressWarnings("rawtypes")
	private JList listaAnnadidos;
	private DefaultListModel<String> annadidos = new DefaultListModel<String>();
	private JButton btnAnnadir;
	private JButton btnFinalizar;
	private JLabel lblProdDisp;
	private JLabel lblProductosSeleccionados;
	private JLabel lblError;
	private JTextField textLocal;
	private JLabel lblLocal;
	private JLabel lblFecha;
	private JButton btnEliminar;
	private JLabel lblTotal;
	private JTextField textTotal;

	public PanelFacturas(ControladorPanelFacturas controladorPanelFacturas) {
		setBackground(new Color(51, 153, 255));

		this.controladorPanelFacturas = controladorPanelFacturas;

		setLayout(null);

		textFieldFecha = new JTextField();
		textFieldFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(299, 134, 114, 20);
		add(textFieldFecha);
		textFieldFecha.setText(this.controladorPanelFacturas.devolverFechaHora());
		textFieldFecha.setEditable(false);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setBounds(517, 545, 117, 25);
		add(btnVolver);

		textNIF = new JTextField();
		textNIF.setBounds(582, 134, 113, 20);
		add(textNIF);
		textNIF.setColumns(10);

		textNombre = new JTextField();
		textNombre.setBounds(582, 165, 113, 20);
		add(textNombre);
		textNombre.setColumns(10);

		textApellido = new JTextField();
		textApellido.setBounds(582, 196, 113, 20);
		add(textApellido);
		textApellido.setColumns(10);

		textFieldNumTrans = new JTextField();
		textFieldNumTrans.setBounds(299, 165, 114, 20);
		add(textFieldNumTrans);
		textFieldNumTrans.setEditable(false);
		textFieldNumTrans.setColumns(10);
		textFieldNumTrans.setText(Integer.toString(this.controladorPanelFacturas.conseguirNumTrans()));
		textFieldNumTrans.setHorizontalAlignment(SwingConstants.TRAILING);

		JLabel lblNIF = new JLabel("NIF:");
		lblNIF.setFont(new Font("Arial", Font.BOLD, 16));
		lblNIF.setBounds(476, 134, 67, 20);
		add(lblNIF);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
		lblNombre.setBounds(476, 167, 82, 17);
		add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Arial", Font.BOLD, 16));
		lblApellido.setBounds(476, 198, 82, 17);
		add(lblApellido);

		JLabel lblTransaccion = new JLabel("N\u00BA Transacci\u00F3n:");
		lblTransaccion.setFont(new Font("Arial", Font.BOLD, 16));
		lblTransaccion.setBounds(139, 165, 150, 20);
		add(lblTransaccion);

		JScrollPane scrollPaneProductos = new JScrollPane();
		scrollPaneProductos.setBounds(545, 254, 150, 160);
		add(scrollPaneProductos);

		listaProductos = new JList(controladorPanelFacturas.cogerListaProductos());
		listaProductos.setBackground(Color.WHITE);
		scrollPaneProductos.setViewportView(listaProductos);

		JScrollPane scrollPaneAnnadidos = new JScrollPane();
		scrollPaneAnnadidos.setBounds(139, 254, 300, 160);
		add(scrollPaneAnnadidos);

		listaAnnadidos = new JList(annadidos);
		listaAnnadidos.setBackground(Color.WHITE);
		scrollPaneAnnadidos.setViewportView(listaAnnadidos);

		btnAnnadir = new JButton("Seleccionar");
		btnAnnadir.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAnnadir.setBounds(545, 469, 150, 25);
		add(btnAnnadir);

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFinalizar.setBounds(200, 545, 117, 25);
		add(btnFinalizar);

		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(1); // valor m�nimo
		formatter.setMaximum(99); // valor m�ximo
		formatter.setAllowsInvalid(false);
		// Si quieres comprobar que sea v�lido, cada vez que se pulse una tecla
		formatter.setCommitsOnValidEdit(true);

		textCantidad = new JFormattedTextField(formatter);
		textCantidad.setHorizontalAlignment(SwingConstants.TRAILING);
		textCantidad.setFont(new Font("Arial", Font.PLAIN, 12));
		textCantidad.setBounds(655, 427, 40, 20);
		add(textCantidad);
		textCantidad.setText("1");

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Arial", Font.BOLD, 16));
		lblCantidad.setBounds(545, 427, 92, 20);
		add(lblCantidad);

		lblProdDisp = new JLabel("Productos:");
		lblProdDisp.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdDisp.setFont(new Font("Arial", Font.BOLD, 16));
		lblProdDisp.setBounds(545, 227, 150, 22);
		add(lblProdDisp);

		lblProductosSeleccionados = new JLabel("Productos Seleccionados:");
		lblProductosSeleccionados.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductosSeleccionados.setFont(new Font("Arial", Font.BOLD, 16));
		lblProductosSeleccionados.setBounds(139, 227, 300, 22);
		add(lblProductosSeleccionados);

		lblError = new JLabel("");
		lblError.setBounds(139, 505, 300, 20);
		add(lblError);

		textLocal = new JTextField();
		textLocal.setBounds(299, 196, 114, 20);
		add(textLocal);
		textLocal.setColumns(10);
		textLocal.setText(controladorPanelFacturas.conseguirLocal());
		textLocal.setHorizontalAlignment(SwingConstants.TRAILING);

		lblLocal = new JLabel("Local:");
		lblLocal.setBounds(139, 196, 70, 20);
		lblLocal.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblLocal);

		lblFecha = new JLabel("Fecha y hora: ");
		lblFecha.setBounds(139, 134, 123, 20);
		lblFecha.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblFecha);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEliminar.setBounds(139, 425, 117, 25);
		add(btnEliminar);

		lblTotal = new JLabel("Total:");
		lblTotal.setBounds(139, 471, 50, 20);
		lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblTotal);

		textTotal = new JTextField();
		textTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		textTotal.setEditable(false);
		textTotal.setBounds(189, 471, 114, 20);
		add(textTotal);
		textTotal.setColumns(10);
		textTotal.setText("0");

		JLabel lblBG = new JLabel(new ImageIcon("media\\bg_factura.jpg"));
		lblBG.setBounds(0, 0, 834, 611);
		add(lblBG);
		
				lblTextoPanel = new JLabel("PANEL DE FACTURAS");
				lblTextoPanel.setHorizontalAlignment(SwingConstants.CENTER);
				lblTextoPanel.setFont(new Font("Arial", Font.BOLD, 50));
				lblTextoPanel.setBounds(139, 35, 556, 50);
				add(lblTextoPanel);

		initializeEvents();

	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelFacturas));
		this.btnAnnadir.addActionListener(listenerBotonAnnadir(this.controladorPanelFacturas));
		this.btnEliminar.addActionListener(listenerBotonEliminar(this.controladorPanelFacturas));
		this.btnFinalizar.addActionListener(listenerBotonFinalizar(this.controladorPanelFacturas));
	}

	private ActionListener listenerBotonVolver(ControladorPanelFacturas controladorPanelFacturas) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelFacturas.accionadoBottonVolverPanelPrincipal();
			}
		};
	}

	private ActionListener listenerBotonAnnadir(ControladorPanelFacturas controladorPanelFacturas) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Annadir");
				boolean existeProd = false;
				String producto = "";
				String[] productosAnadir = new String[2];
				String cantidad = textCantidad.getText();
				System.out.println(cantidad);
				try {
					producto = (String) listaProductos.getSelectedValue(); // Necesito hacer aqu� el cast porque
																			// getSelectedValue() devuelve un objeto por
																			// lo que no se le puede pasar directamente
																			// a accionadoBotonAnadirProducto
					if (producto != null) {
						existeProd = true;
					}
				} catch (Exception e) {
					System.out.println("No se ha seleccionado un producto");
					lblError.setText("No se ha escogido un producto");
				}
				if (existeProd) {
					try {
						int stock = controladorPanelFacturas.conseguirStock(textLocal.getText(), producto);
						if (Integer.parseInt(cantidad) > stock) {
							JOptionPane.showMessageDialog(null, "No puedes solicitar " + cantidad
									+ " el stock para ese articulo es de " + stock + " unidades");

						} else {
							if (controladorPanelFacturas.existeProducto(producto) == -1) {
								productosAnadir = controladorPanelFacturas.accionadoBotonAnnadirProducto(producto,
										cantidad);
								annadidos.addElement(productosAnadir[0]);
								textTotal.setText(productosAnadir[1]);
								lblError.setText("");
							} else {
								int indice = controladorPanelFacturas.existeProducto(producto);
								String yaAnnadido = annadidos.get(indice);
								String cantidadEnPanel[] = yaAnnadido.split(" ");

								if ((Integer.parseInt(cantidadEnPanel[0]) + Integer.parseInt(cantidad)) > stock) {
									JOptionPane.showMessageDialog(null,
											"No puedes a�adir esa cantidad, el stock es de " + stock + " unidades y has seleccionado ya " + cantidadEnPanel[0] + " unidades");
								} else {
									productosAnadir = controladorPanelFacturas.cambiarCantidadProductos(yaAnnadido,
											Integer.parseInt(cantidad), producto);
									annadidos.set(indice, productosAnadir[0]);
									textTotal.setText(productosAnadir[1]);
								}
							}
						}
					} catch (Exception e) {
						System.out.println("El campo cantidad no contiene un entero");
						e.printStackTrace();
						lblError.setText("No se ha introducido una cantidad");
					}
				}
			}
		};
	}

	private ActionListener listenerBotonFinalizar(ControladorPanelFacturas controladorPanelFacturas) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Finalizar");
				// Comprobamos si los campos DNI, Nombre, Apellido y si hay algun articulo
				// metido
				if (controladorPanelFacturas.comprobarCampos(Double.parseDouble(textTotal.getText()), textNIF.getText(),
						textNombre.getText(), textApellido.getText())) {
					
					controladorPanelFacturas.insertarFactura(Integer.parseInt(textFieldNumTrans.getText()),
							textFieldFecha.getText(), textLocal.getText() , textNombre.getText(), textApellido.getText(),annadidos,textNIF.getText());

					JOptionPane.showMessageDialog(null, "Factura introducida correctamente");
					
					controladorPanelFacturas.accionadoBottonVolverPanelPrincipal();

				} else {
					if (!controladorPanelFacturas.comprobarCampos(Double.parseDouble(textTotal.getText()), textNIF.getText(), textNombre.getText(), textApellido.getText())) {
						JOptionPane.showMessageDialog(null, "Asegurate que todos los campos son correctos");
					}
				}
				}
		};
		}

	private ActionListener listenerBotonEliminar(ControladorPanelFacturas controladorPanelFacturas) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento eliminar");
				try {
					int pos = listaAnnadidos.getSelectedIndex();
					String total = controladorPanelFacturas.accionadoBotonEliminar(pos, annadidos.get(pos));
					annadidos.remove(pos);
					textTotal.setText(total);
					lblError.setText("");
				} catch (Exception e) {
					System.out.println("No se pudo borrar el producto seleccionado/No se seleccionó ningún producto");
					lblError.setText("No se pudo eliminar");
				}
			}
		};
	}
}
