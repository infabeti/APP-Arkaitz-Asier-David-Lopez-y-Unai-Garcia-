package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import Controlador.ControladorPanelPedidos;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;
import java.awt.Color;

public class PanelPedidos extends JPanel {

	private static final long serialVersionUID = -6410388862910126406L;
	private ControladorPanelPedidos controladorPanelPedidos;
	private JLabel lblTextoPanel;
	private JButton btnVolver;
	private JTextField textFieldNumTrans;
	private JTextField textFieldFecha;
	private JTextField textFieldLocal;
	private JTextField textFieldDomicilio;
	private JList productosAlmacenados = new JList();
	private JList listaAnnadidos;
	private JScrollPane scrollPane;
	private DefaultListModel<String> listaPAnnadidos = new DefaultListModel<String>();
	private JFormattedTextField TextFieldCantidad;
	private JButton btnSeleccionar;
	private JLabel lblError;
	private JButton btnEliminar;
	private JTextField textTotal;
	private JButton btnFinalizar;

	public PanelPedidos(ControladorPanelPedidos controladorPanelPedidos) {
		setBackground(new Color(51, 153, 255));

		this.controladorPanelPedidos = controladorPanelPedidos;

		setLayout(null);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setBounds(517, 545, 117, 25);
		add(btnVolver);

		JLabel lblNumTrans = new JLabel("N\u00BA Transacci\u00F3n:");
		lblNumTrans.setFont(new Font("Arial", Font.BOLD, 16));
		lblNumTrans.setBounds(139, 139, 150, 20);
		add(lblNumTrans);

		textFieldNumTrans = new JTextField();
		textFieldNumTrans.setBounds(299, 139, 114, 20);
		add(textFieldNumTrans);
		textFieldNumTrans.setColumns(10);
		textFieldNumTrans.setEditable(false);
		textFieldNumTrans.setText(Integer.toString(this.controladorPanelPedidos.conseguirNumTrans()));
		textFieldNumTrans.setHorizontalAlignment(SwingConstants.TRAILING);

		JLabel lblFecha = new JLabel("Fecha y hora: ");
		lblFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFecha.setFont(new Font("Arial", Font.BOLD, 16));
		lblFecha.setBounds(459, 139, 123, 20);
		add(lblFecha);

		textFieldFecha = new JTextField();
		textFieldFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(589, 139, 106, 20);
		add(textFieldFecha);
		textFieldFecha.setText(this.controladorPanelPedidos.devolverFechaHora());
		textFieldFecha.setEditable(false);

		JLabel lblLocal = new JLabel("Local:\r\n");
		lblLocal.setFont(new Font("Arial", Font.BOLD, 16));
		lblLocal.setBounds(139, 179, 70, 20);
		add(lblLocal);

		textFieldLocal = new JTextField();
		textFieldLocal.setColumns(10);
		textFieldLocal.setBounds(299, 180, 114, 19);
		add(textFieldLocal);
		textFieldLocal.setText(controladorPanelPedidos.conseguirLocal());
		textFieldLocal.setHorizontalAlignment(SwingConstants.TRAILING);

		JLabel lblTipoPed = new JLabel("*Solo rellenar si el pedido es a domicilio:");
		lblTipoPed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoPed.setBounds(139, 461, 300, 20);
		add(lblTipoPed);

		textFieldDomicilio = new JTextField();
		textFieldDomicilio.setColumns(10);
		textFieldDomicilio.setBounds(139, 490, 300, 30);
		add(textFieldDomicilio);

		JLabel lblCantidad = new JLabel("Cantidad: \r\n");
		lblCantidad.setFont(new Font("Arial", Font.BOLD, 16));
		lblCantidad.setBounds(545, 417, 92, 20);
		add(lblCantidad);

		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(1); // valor m�nimo
		formatter.setMaximum(99); // valor m�ximo
		formatter.setAllowsInvalid(false);
		// Si quieres comprobar que sea v�lido, cada vez que se pulse una tecla
		formatter.setCommitsOnValidEdit(true);

		TextFieldCantidad = new JFormattedTextField(formatter);
		TextFieldCantidad.setHorizontalAlignment(SwingConstants.TRAILING);
		TextFieldCantidad.setFont(new Font("Arial", Font.PLAIN, 12));
		TextFieldCantidad.setBounds(655, 417, 40, 20);
		add(TextFieldCantidad);
		TextFieldCantidad.setText("1");

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSeleccionar.setBounds(545, 459, 150, 25);
		add(btnSeleccionar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 244, 300, 160);
		add(scrollPane);

		listaAnnadidos = new JList(listaPAnnadidos);
		scrollPane.setViewportView(listaAnnadidos);

		JLabel lblProd = new JLabel("Productos:");
		lblProd.setHorizontalAlignment(SwingConstants.CENTER);
		lblProd.setFont(new Font("Arial", Font.BOLD, 16));
		lblProd.setBounds(545, 210, 150, 22);
		add(lblProd);

		JLabel lblProdAdd = new JLabel("Productos Seleccionados:");
		lblProdAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdAdd.setFont(new Font("Arial", Font.BOLD, 16));
		lblProdAdd.setBounds(139, 210, 300, 22);
		add(lblProdAdd);

		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.TRAILING);
		lblError.setBounds(436, 180, 259, 19);
		add(lblError);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEliminar.setBounds(139, 415, 117, 25);
		add(btnEliminar);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
		lblTotal.setBounds(275, 417, 50, 20);
		add(lblTotal);

		textTotal = new JTextField();
		textTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		textTotal.setEditable(false);
		textTotal.setBounds(325, 417, 114, 20);
		add(textTotal);
		textTotal.setColumns(10);
		textTotal.setText("0");

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFinalizar.setBounds(200, 545, 117, 25);
		add(btnFinalizar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(545, 244, 150, 160);
		add(scrollPane_1);

		productosAlmacenados = new JList(controladorPanelPedidos.cogerListaProductos());
		scrollPane_1.setViewportView(productosAlmacenados);
		productosAlmacenados.setBackground(Color.WHITE);

		JLabel lblBG = new JLabel(new ImageIcon("media\\bg_pedidos.jpg"));
		lblBG.setBounds(0, 0, 834, 611);
		add(lblBG);
		
				lblTextoPanel = new JLabel("PANEL DE PEDIDOS");
				lblTextoPanel.setHorizontalAlignment(SwingConstants.CENTER);
				lblTextoPanel.setFont(new Font("Arial", Font.BOLD, 50));
				lblTextoPanel.setBounds(139, 35, 556, 50);
				add(lblTextoPanel);

		initializeEvents();

	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelPedidos));
		this.btnSeleccionar.addActionListener(listenerBotonSeleccionar(this.controladorPanelPedidos));
		this.btnFinalizar.addActionListener(listenerBotonFinalizar(this.controladorPanelPedidos));
		this.btnEliminar.addActionListener(listenerBotonEliminar(this.controladorPanelPedidos));
	}

	private ActionListener listenerBotonSeleccionar(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Annadir");
				boolean existeProd = false;
				String producto = "";
				String[] productosAnadir = new String[2];
				String cantidad = TextFieldCantidad.getText();
				try {
					producto = (String) productosAlmacenados.getSelectedValue(); // Necesito hacer aqu� el cast porque
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
						int stock = controladorPanelPedidos.conseguirStock(textFieldLocal.getText(), producto);
						if (Integer.parseInt(cantidad) > stock) {
							JOptionPane.showMessageDialog(null, "No puedes solicitar " + cantidad
									+ " el stock para ese articulo es de " + stock + " unidades");

						} else {
							if (controladorPanelPedidos.existeProducto(producto) == -1) {
								productosAnadir = controladorPanelPedidos.accionadoBotonAnnadirProducto(producto,
										cantidad);
								listaPAnnadidos.addElement(productosAnadir[0]);
								textTotal.setText(productosAnadir[1]);
								lblError.setText("");
							} else {
								int indice = controladorPanelPedidos.existeProducto(producto);
								String yaAnnadido = listaPAnnadidos.get(indice);
								String cantidadEnPanel[] = yaAnnadido.split(" ");
								if ((Integer.parseInt(cantidadEnPanel[0]) + Integer.parseInt(cantidad)) > stock) {
									JOptionPane.showMessageDialog(null,
											"No puedes a�adir esa cantidad, el stock es de " + stock + " unidades y has seleccionado ya " + cantidadEnPanel[0] + " unidades");
								} else {
									productosAnadir = controladorPanelPedidos.cambiarCantidadProductos(yaAnnadido,
											Integer.parseInt(cantidad), producto);
									listaPAnnadidos.set(indice, productosAnadir[0]);
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

	private ActionListener listenerBotonVolver(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelPedidos.accionadoBottonVolverPanelPrincipal();
			}
		};
	}

	private ActionListener listenerBotonFinalizar(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Finalizar");

				if (Double.parseDouble(textTotal.getText()) > 0) {
					String domicilio = textFieldDomicilio.getText();
					// insertar datos en actividad
					controladorPanelPedidos.insertarActividad(Integer.parseInt(textFieldNumTrans.getText()),
							textFieldFecha.getText(), textFieldLocal.getText(),
							domicilio, listaPAnnadidos);

					JOptionPane.showMessageDialog(null, "Pedido introducido correctamente");
					controladorPanelPedidos.accionadoBottonVolverPanelPrincipal();

				} else {
					JOptionPane.showMessageDialog(null, "Debes introducir articulos");
				}

			}

		};
	}

	private ActionListener listenerBotonEliminar(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento eliminar");
				try {
					int pos = listaAnnadidos.getSelectedIndex();
					String total = controladorPanelPedidos.accionadoBotonEliminar(pos, listaPAnnadidos.get(pos));
					listaPAnnadidos.remove(pos);
					textTotal.setText(total);
					lblError.setText("");
				} catch (Exception e) {
					System.out.println("No se pudo borrar el producto seleccionado/No se ha seleccionado ning�n producto");
					lblError.setText("No se pudo eliminar");
				}
			}
		};
	}
}
