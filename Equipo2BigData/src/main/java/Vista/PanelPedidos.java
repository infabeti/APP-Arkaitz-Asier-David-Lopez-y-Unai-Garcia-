package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.DefaultListModel;
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
		setBackground(SystemColor.activeCaption);

		this.controladorPanelPedidos = controladorPanelPedidos;

		setLayout(null);

		lblTextoPanel = new JLabel("PANEL PEDIDOS");
		lblTextoPanel.setFont(new Font("Arial", Font.BOLD, 20));
		lblTextoPanel.setBounds(195, 0, 187, 46);
		add(lblTextoPanel);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setBounds(513, 545, 117, 25);
		add(btnVolver);

		JLabel lblNumTrans = new JLabel("N\u00BA Transacci\u00F3n:");
		lblNumTrans.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNumTrans.setBounds(17, 75, 187, 23);
		add(lblNumTrans);

		textFieldNumTrans = new JTextField();
		textFieldNumTrans.setBounds(207, 73, 125, 30);
		add(textFieldNumTrans);
		textFieldNumTrans.setColumns(10);
		textFieldNumTrans.setText(controladorPanelPedidos.leerNumTransBBDD());
		textFieldNumTrans.setEditable(false);
		textFieldNumTrans.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblFecha = new JLabel("Fecha y hora: ");
		lblFecha.setFont(new Font("Arial", Font.BOLD, 16));
		lblFecha.setBounds(457, 139, 123, 20);
		add(lblFecha);

		textFieldFecha = new JTextField();
		textFieldFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(587, 139, 106, 20);
		add(textFieldFecha);
		textFieldFecha.setText(this.controladorPanelPedidos.devolverFechaHora());
		textFieldFecha.setEditable(false);

		JLabel lblLocal = new JLabel("Local:\r\n");
		lblLocal.setFont(new Font("Arial", Font.PLAIN, 17));
		lblLocal.setBounds(17, 117, 113, 23);
		add(lblLocal);

		textFieldLocal = new JTextField();
		textFieldLocal.setColumns(10);
		textFieldLocal.setBounds(207, 115, 125, 30);
		add(textFieldLocal);
		textFieldLocal.setText(controladorPanelPedidos.conseguirLocal());
		textFieldLocal.setEditable(false);
		textFieldLocal.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblTipoPed = new JLabel("* Solo rellenar si el pedido es a domicilio:");
		lblTipoPed.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTipoPed.setBounds(17, 165, 385, 23);
		add(lblTipoPed);

		textFieldDomicilio = new JTextField();
		textFieldDomicilio.setColumns(10);
		textFieldDomicilio.setBounds(17, 200, 487, 30);
		add(textFieldDomicilio);

		JLabel lblCantidad = new JLabel("Cantidad: \r\n");
		lblCantidad.setFont(new Font("Arial", Font.BOLD, 16));
		lblCantidad.setBounds(543, 415, 92, 20);
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
		TextFieldCantidad.setBounds(653, 415, 40, 20);
		add(TextFieldCantidad);
		TextFieldCantidad.setText("1");

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSeleccionar.setBounds(543, 459, 150, 25);
		add(btnSeleccionar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 271, 194, 110);
		add(scrollPane);

		listaAnnadidos = new JList(listaPAnnadidos);
		scrollPane.setViewportView(listaAnnadidos);

		JLabel lblProd = new JLabel("Productos:");
		lblProd.setHorizontalAlignment(SwingConstants.CENTER);
		lblProd.setFont(new Font("Arial", Font.BOLD, 16));
		lblProd.setBounds(543, 210, 150, 22);
		add(lblProd);

		JLabel lblProdAdd = new JLabel("Productos a\u00F1adidos\r\n");
		lblProdAdd.setFont(new Font("Arial", Font.PLAIN, 17));
		lblProdAdd.setBounds(268, 240, 187, 23);
		add(lblProdAdd);

		lblError = new JLabel("");
		lblError.setBounds(477, 303, 330, 15);
		add(lblError);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEliminar.setBounds(137, 415, 117, 25);
		add(btnEliminar);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
		lblTotal.setBounds(137, 461, 50, 20);
		add(lblTotal);

		textTotal = new JTextField();
		textTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		textTotal.setEditable(false);
		textTotal.setBounds(187, 461, 114, 20);
		add(textTotal);
		textTotal.setColumns(10);
		textTotal.setText("0");

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFinalizar.setBounds(198, 545, 117, 25);
		add(btnFinalizar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(543, 244, 150, 160);
		add(scrollPane_1);

		productosAlmacenados = new JList(controladorPanelPedidos.cogerListaProductos());
		scrollPane_1.setViewportView(productosAlmacenados);
		productosAlmacenados.setBackground(Color.WHITE);

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
							textFieldFecha.getText(), Double.parseDouble(textTotal.getText()), textFieldLocal.getText(),
							domicilio, listaPAnnadidos);

					JOptionPane.showMessageDialog(null, "Ticket introducido correctamente");
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
					System.out.println("No se pudo borrar el producto seleccionado/No se seleccionó ningún producto");
					lblError.setText("No se pudo eliminar");
				}
			}
		};
	}
}
