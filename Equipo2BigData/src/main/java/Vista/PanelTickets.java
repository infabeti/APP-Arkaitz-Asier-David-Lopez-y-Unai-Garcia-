package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorPanelTickets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Color;

public class PanelTickets extends JPanel {

	private static final long serialVersionUID = -4866340972661290326L;
	private ControladorPanelTickets controladorPanelTickets;
	private JLabel lblTextoPanel;
	private JButton btnVolver;
	private JTextField textFieldNumTrans;
	private JButton btnFinalizar;
	private JLabel lblTransaccion;
	private JList listaProductos;
	private JButton btnAnadir;
	private JList listaAnnadidos;
	private JScrollPane scrollPane;
	private DefaultListModel<String> listaPAnnadidos = new DefaultListModel<String>();
	private JScrollPane scrollPane_1;
	private JFormattedTextField TextFieldCantidad;
	private JLabel lblCantidad;
	private JTextField textLocal;
	private JButton btnEliminar;
	private JLabel lblTotal;
	private JTextField textTotal;
	private JTextField textFieldFecha;

	public PanelTickets(ControladorPanelTickets controladorPanelTickets) {
		setBackground(new Color(51, 153, 255));

		this.controladorPanelTickets = controladorPanelTickets;

		setLayout(null);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setBounds(517, 545, 117, 25);
		add(btnVolver);

		textFieldNumTrans = new JTextField();
		textFieldNumTrans.setBounds(299, 139, 114, 20);
		add(textFieldNumTrans);
		textFieldNumTrans.setColumns(10);
		textFieldNumTrans.setText("0");
		textFieldNumTrans.setHorizontalAlignment(SwingConstants.TRAILING);

		lblTransaccion = new JLabel("N\u00BA Transacci\u00F3n:");
		lblTransaccion.setFont(new Font("Arial", Font.BOLD, 16));
		lblTransaccion.setBounds(139, 139, 150, 20);
		add(lblTransaccion);

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFinalizar.setBounds(200, 545, 117, 25);
		add(btnFinalizar);

		btnAnadir = new JButton("Seleccionar\r\n");
		btnAnadir.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAnadir.setBounds(545, 459, 150, 25);
		add(btnAnadir);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 244, 300, 160);
		add(scrollPane);

		listaAnnadidos = new JList(listaPAnnadidos);
		listaAnnadidos.setBackground(Color.WHITE);
		scrollPane.setViewportView(listaAnnadidos);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(545, 244, 150, 160);
		add(scrollPane_1);

		listaProductos = new JList(controladorPanelTickets.cogerListaProductos());
		listaProductos.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(listaProductos);

		lblCantidad = new JLabel("Cantidad:");
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

		JLabel lblProdDisp = new JLabel("Productos:");
		lblProdDisp.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdDisp.setFont(new Font("Arial", Font.BOLD, 16));
		lblProdDisp.setBounds(545, 210, 150, 22);
		add(lblProdDisp);

		JLabel lblProductosSeleccionados = new JLabel("Productos Seleccionados:");
		lblProductosSeleccionados.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductosSeleccionados.setFont(new Font("Arial", Font.BOLD, 16));
		lblProductosSeleccionados.setBounds(139, 210, 300, 22);
		add(lblProductosSeleccionados);

		textLocal = new JTextField();
		textLocal.setBounds(299, 179, 114, 20);
		add(textLocal);
		textLocal.setColumns(10);
		textLocal.setText(controladorPanelTickets.conseguirLocal());
		textLocal.setHorizontalAlignment(SwingConstants.TRAILING);

		textFieldFecha = new JTextField();
		textFieldFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(589, 139, 106, 20);
		add(textFieldFecha);
		textFieldFecha.setText(this.controladorPanelTickets.devolverFechaHora());
		textFieldFecha.setEditable(false);

		JLabel lblLocal = new JLabel("Local:");
		lblLocal.setBounds(139, 179, 70, 20);
		lblLocal.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblLocal);

		JLabel lblFecha = new JLabel("Fecha y hora: ");
		lblFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFecha.setBounds(459, 139, 123, 20);
		lblFecha.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblFecha);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEliminar.setBounds(139, 415, 117, 25);
		add(btnEliminar);

		lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
		lblTotal.setBounds(139, 461, 50, 20);
		add(lblTotal);

		textTotal = new JTextField();
		textTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		textTotal.setEditable(false);
		textTotal.setBounds(189, 461, 114, 20);
		add(textTotal);
		textTotal.setColumns(10);
		textTotal.setText("0");

		JLabel lblBG = new JLabel(new ImageIcon("media\\bg_ticket.jpg"));
		lblBG.setBounds(0, 0, 834, 611);
		add(lblBG);

		lblTextoPanel = new JLabel("PANEL DE TICKETS");
		lblTextoPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoPanel.setFont(new Font("Arial", Font.BOLD, 50));
		lblTextoPanel.setBounds(139, 35, 556, 50);
		add(lblTextoPanel);

		initializeEvents();

	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelTickets));
		this.btnAnadir.addActionListener(listenerBotonAnadir(this.controladorPanelTickets));
		this.btnEliminar.addActionListener(listenerBotonEliminar(this.controladorPanelTickets));
		this.btnFinalizar.addActionListener(listenerBotonFinalizar(this.controladorPanelTickets));

	}

	private ActionListener listenerBotonFinalizar(ControladorPanelTickets controladorPanelTickets) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Finalizar");
				if (Double.parseDouble(textTotal.getText()) > 0) {
					// insertar datos en actividad
					controladorPanelTickets.insertarTicket(Integer.parseInt(textFieldNumTrans.getText()),
							textFieldFecha.getText(), textLocal.getText(),
							listaPAnnadidos);

					JOptionPane.showMessageDialog(null, "Ticket introducido correctamente");
					controladorPanelTickets.accionadoBottonVolverPanelPrincipal();

				} else {
					JOptionPane.showMessageDialog(null, "Debes introducir articulos");
				}

			}

		};
	}

	private ActionListener listenerBotonVolver(ControladorPanelTickets controladorPanelTickets) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelTickets.accionadoBottonVolverPanelPrincipal();
			}
		};
	}

	private ActionListener listenerBotonAnadir(ControladorPanelTickets controladorPanelTickets) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Annadir");
				boolean existeProd = false;
				String producto = "";
				String[] productosAnadir = new String[2];
				String cantidad = TextFieldCantidad.getText();
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
				}
				if (existeProd) {
					try {
						int stock = controladorPanelTickets.conseguirStock(textLocal.getText(), producto);
						if (Integer.parseInt(cantidad) > stock) {
							JOptionPane.showMessageDialog(null, "No puedes solicitar " + cantidad
									+ " el stock para ese articulo es de " + stock + " unidades");

						} else {
							if (controladorPanelTickets.existeProducto(producto) == -1) {
								productosAnadir = controladorPanelTickets.accionadoBotonAnnadirProducto(producto,
										cantidad);
								listaPAnnadidos.addElement(productosAnadir[0]);
								textTotal.setText(productosAnadir[1]);
							} else {
								int indice = controladorPanelTickets.existeProducto(producto);
								String yaAnnadido = listaPAnnadidos.get(indice);
								String cantidadEnPanel[] = yaAnnadido.split(" ");

								if ((Integer.parseInt(cantidadEnPanel[0]) + Integer.parseInt(cantidad)) > stock) {
									JOptionPane.showMessageDialog(null,
											"No puedes a�adir esa cantidad, el stock es de " + stock + " unidades y has seleccionado ya " + cantidadEnPanel[0] + " unidades");
								} else {
									productosAnadir = controladorPanelTickets.cambiarCantidadProductos(yaAnnadido,
											Integer.parseInt(cantidad), producto);
									listaPAnnadidos.set(indice, productosAnadir[0]);
									textTotal.setText(productosAnadir[1]);
								}
							}
						}
					} catch (Exception e) {
						System.out.println("El campo cantidad no contiene un entero");
						e.printStackTrace();
					}
				}
			}
		};
	}

	private ActionListener listenerBotonEliminar(ControladorPanelTickets controladorPanelTickets) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento eliminar");
				try {
					/*
					 * Este es el m�nimo de l�gica necesaria en la vista para eliminar un
					 * elemento Primero se coge el �ndice seleccionado, luego se le pasa al
					 * controlador junto al string que representa El producto a eliminar y el total
					 * actual Se elimina el producto de la lista y luego se cambia el total por el
					 * devuelto por el controlador
					 */
					int pos = listaAnnadidos.getSelectedIndex();
					String total = controladorPanelTickets.accionadoBotonEliminar(pos, listaPAnnadidos.get(pos));
					listaPAnnadidos.remove(pos);
					textTotal.setText(total);
				} catch (Exception e) {
					System.out.println("No se pudo borrar el producto seleccionado/No se ha seleccionado ningun producto");
				}
			}
		};
	}
}
