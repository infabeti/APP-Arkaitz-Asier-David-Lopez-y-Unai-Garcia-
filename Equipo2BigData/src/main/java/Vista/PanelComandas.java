package Vista;

import javax.swing.JPanel;

import Controlador.ControladorPanelComandas;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PanelComandas extends JPanel {

	private static final long serialVersionUID = -2457862673139031544L;
	private ControladorPanelComandas controladorPanelComandas;
	private JButton btnVolver;
	private JButton btnAnadirProducto;
	private JButton btnAnadirPlato;
	private JButton btnFinalizar;
	private JButton btnEliminarProducto;
	private JButton btnEliminarPlato;
	private JList listaProductos;
	private JList listaPlatos;
	private JList productosAnadidos;
	private JList platosAnadidos;
	private DefaultListModel<String> productosAnadidosString = new DefaultListModel<String>();
	private DefaultListModel<String> platosAnadidosString = new DefaultListModel<String>();
	private JFormattedTextField textCantidadProductos;
	private JFormattedTextField textCantidadPlatos;
	private JTextField textTotal;
	private JTextField textFieldNumTrans;
	private JTextField textFieldFecha;
	private JTextField textLocal;
	private JLabel lblError;

	public PanelComandas(ControladorPanelComandas controladorPanelComandas) {
		setBackground(SystemColor.activeCaption);

		this.controladorPanelComandas = controladorPanelComandas;

		setLayout(null);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(67, 574, 117, 25);
		add(btnVolver);

		JLabel lblComandas = new JLabel("COMANDAS");
		lblComandas.setFont(new Font("Dialog", Font.BOLD, 48));
		lblComandas.setBounds(12, 12, 469, 63);
		add(lblComandas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(367, 194, 216, 298);
		add(scrollPane);

		listaProductos = new JList(controladorPanelComandas.cogerListaProductos());
		scrollPane.setViewportView(listaProductos);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(610, 194, 216, 298);
		add(scrollPane_1);

		listaPlatos = new JList(controladorPanelComandas.cogerListaPlatos());
		scrollPane_1.setViewportView(listaPlatos);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(67, 182, 263, 108);
		add(scrollPane_2);

		productosAnadidos = new JList(productosAnadidosString);
		scrollPane_2.setViewportView(productosAnadidos);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(67, 337, 263, 108);
		add(scrollPane_3);

		platosAnadidos = new JList(platosAnadidosString);
		scrollPane_3.setViewportView(platosAnadidos);

		btnAnadirProducto = new JButton("Anadir producto");
		btnAnadirProducto.setBounds(377, 510, 163, 25);
		add(btnAnadirProducto);

		btnAnadirPlato = new JButton("Anadir plato");
		btnAnadirPlato.setBounds(628, 510, 156, 25);
		add(btnAnadirPlato);

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(226, 574, 117, 25);
		add(btnFinalizar);

		btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setBounds(109, 301, 168, 25);
		add(btnEliminarProducto);

		btnEliminarPlato = new JButton("Eliminar Plato");
		btnEliminarPlato.setBounds(109, 456, 168, 25);
		add(btnEliminarPlato);

		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(1); // valor mï¿½nimo
		formatter.setMaximum(99); // valor mï¿½ximo
		formatter.setAllowsInvalid(false);
		// Si quieres comprobar que sea vï¿½lido, cada vez que se pulse una tecla
		formatter.setCommitsOnValidEdit(true);

		textCantidadProductos = new JFormattedTextField(formatter);
		textCantidadProductos.setFont(new Font("Arial", Font.PLAIN, 12));
		textCantidadProductos.setBounds(549, 512, 27, 20);
		add(textCantidadProductos);
		textCantidadProductos.setText("1");

		textCantidadPlatos = new JFormattedTextField(formatter);
		textCantidadPlatos.setFont(new Font("Arial", Font.PLAIN, 12));
		textCantidadPlatos.setBounds(794, 512, 27, 20);
		add(textCantidadPlatos);
		textCantidadPlatos.setText("1");

		textTotal = new JTextField();
		textTotal.setBounds(143, 503, 114, 19);
		add(textTotal);
		textTotal.setColumns(10);
		textTotal.setText("0");
		textTotal.setEditable(false);

		textLocal = new JTextField();
		textLocal.setBounds(205, 128, 125, 25);
		add(textLocal);
		textLocal.setColumns(10);
		textLocal.setText(controladorPanelComandas.conseguirDatosPanel()[0]);
		textLocal.setEditable(false);
		textLocal.setHorizontalAlignment(SwingConstants.CENTER);

		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(463, 86, 117, 25);
		add(textFieldFecha);
		textFieldFecha.setText(this.controladorPanelComandas.conseguirDatosPanel()[1]);
		textFieldFecha.setEditable(false);

		textFieldNumTrans = new JTextField();
		textFieldNumTrans.setBounds(205, 86, 125, 25);
		add(textFieldNumTrans);
		textFieldNumTrans.setColumns(10);
		textFieldNumTrans.setText(controladorPanelComandas.conseguirDatosPanel()[2]);
		textFieldNumTrans.setEditable(false);
		textFieldNumTrans.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNumTrans = new JLabel("Numero de transacci\u00F3n: \r\n");
		lblNumTrans.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNumTrans.setBounds(22, 86, 187, 23);
		add(lblNumTrans);

		JLabel lblLocal = new JLabel("Local:\r\n");
		lblLocal.setFont(new Font("Arial", Font.PLAIN, 17));
		lblLocal.setBounds(21, 125, 113, 23);
		add(lblLocal);

		JLabel lblFecha = new JLabel("Fecha y hora: ");
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 17));
		lblFecha.setBounds(352, 88, 113, 23);
		add(lblFecha);

		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setFont(new Font("Arial", Font.PLAIN, 17));
		lblProductos.setBounds(416, 160, 113, 23);
		add(lblProductos);

		JLabel lblPlatos = new JLabel("Platos");
		lblPlatos.setFont(new Font("Arial", Font.PLAIN, 17));
		lblPlatos.setBounds(676, 160, 113, 23);
		add(lblPlatos);

		lblError = new JLabel("");
		lblError.setBounds(425, 590, 332, 31);
		add(lblError);

		initializeEvents();
	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolverPanelPrincipal(controladorPanelComandas));
		this.btnAnadirProducto.addActionListener(listenerBotonAnadirProducto(controladorPanelComandas));
		this.btnAnadirPlato.addActionListener(listenerBotonAnadirPlato(controladorPanelComandas));
		this.btnFinalizar.addActionListener(listenerBotonFinalizar(controladorPanelComandas));
		this.btnEliminarProducto.addActionListener(listenerBotonEliminar(controladorPanelComandas));
		this.btnEliminarPlato.addActionListener(listenerBotonEliminarPlato(controladorPanelComandas));
	}

	private ActionListener listenerBotonVolverPanelPrincipal(ControladorPanelComandas controladorPanelComandas) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Pedidos");
				controladorPanelComandas.accionadoBotonVolverPanelPrincipal();
			}
		};
	}

	private ActionListener listenerBotonAnadirProducto(ControladorPanelComandas controladorPanelComandas) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Annadir");
				boolean existeProd = false;
				String producto = "";
				String[] productosAnadir = new String[2];
				String cantidad = textCantidadProductos.getText();
				System.out.println(cantidad);
				try {
					producto = (String) listaProductos.getSelectedValue(); // Necesito hacer aquï¿½ el cast porque
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
						int stock = controladorPanelComandas.conseguirStockProductos(textLocal.getText(), producto);
						if (Integer.parseInt(cantidad) > stock) {
							JOptionPane.showMessageDialog(null, "No puedes solicitar " + cantidad
									+ " el stock para ese articulo es de " + stock + " unidades");

						} else {
							if (controladorPanelComandas.existeProducto(producto) == -1) {
								productosAnadir = controladorPanelComandas.accionadoBotonAnnadirProducto(producto,
										cantidad);
								productosAnadidosString.addElement(productosAnadir[0]);
								textTotal.setText(productosAnadir[1]);
								lblError.setText("");
							} else {
								int indice = controladorPanelComandas.existeProducto(producto);
								String yaAnnadido = productosAnadidosString.get(indice);
								String cantidadEnPanel[] = yaAnnadido.split(" ");

								if ((Integer.parseInt(cantidadEnPanel[0]) + Integer.parseInt(cantidad)) > stock) {
									JOptionPane.showMessageDialog(null,
											"No puedes añadir esa cantidad, el stock es de " + stock
													+ " unidades y has seleccionado ya " + cantidadEnPanel[0]
													+ " unidades");
								} else {
									productosAnadir = controladorPanelComandas.cambiarCantidadProductos(yaAnnadido,
											Integer.parseInt(cantidad), producto, "producto");
									productosAnadidosString.set(indice, productosAnadir[0]);
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

	private ActionListener listenerBotonAnadirPlato(ControladorPanelComandas controladorPanelComandas) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Anadir Plato");
				boolean existePlato = false;
				String plato = "";
				String[] platosAnadir = new String[2];
				String cantidad = textCantidadPlatos.getText();
				try {
					plato = (String) listaPlatos.getSelectedValue();
					if (plato != null) {
						existePlato = true;
					}

				} catch (Exception e) {
					System.out.println("No se ha seleccionado un producto");
				}
				try {
					if (controladorPanelComandas.existePlato(plato) == -1 && existePlato) {
						platosAnadir = controladorPanelComandas.accionadoBotonAnnadirPlato(plato, cantidad);
						platosAnadidosString.addElement(platosAnadir[0]);
						textTotal.setText(platosAnadir[1]);
					} else if (controladorPanelComandas.existePlato(plato) != -1 && existePlato) {
						int indice = controladorPanelComandas.existePlato(plato);
						String yaAnnadido = platosAnadidosString.get(indice);
						platosAnadir = controladorPanelComandas.cambiarCantidadProductos(yaAnnadido,
								Integer.parseInt(cantidad), plato, "plato");
						platosAnadidosString.set(indice, platosAnadir[0]);
						textTotal.setText(platosAnadir[1]);
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("El campo cantidad no contiene un entero");
				}
			}
		};
	}

	private ActionListener listenerBotonEliminar(ControladorPanelComandas controladorPanelComandas) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento eliminar");
				try {
					int pos = productosAnadidos.getSelectedIndex();
					String total = controladorPanelComandas.accionadoBotonEliminar(pos,
							productosAnadidosString.get(pos));
					productosAnadidosString.remove(pos);
					textTotal.setText(total);
				} catch (Exception e) {
					System.out.println("No se pudo borrar el producto seleccionado o No se seleccionado ningun producto");
				}
			}
		};
	}

	private ActionListener listenerBotonEliminarPlato(ControladorPanelComandas controladorPanelComandas) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento eliminar");
				try {
					int pos = platosAnadidos.getSelectedIndex();
					String total = controladorPanelComandas.accionadoBotonEliminarPlato(pos,
							platosAnadidosString.get(pos));
					platosAnadidosString.remove(pos);
					textTotal.setText(total);
				} catch (Exception e) {
					System.out.println("No se pudo borrar el producto seleccionado o No se seleccionado ningun producto");
				}
			}
		};
	}

	private ActionListener listenerBotonFinalizar(ControladorPanelComandas controladorPanelComandas) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Pedidos");
				System.out.println("Ejecutando evento Boton Finalizar");
				try {

					if (Double.parseDouble(textTotal.getText()) > 0) {
						// insertar datos en actividad
						controladorPanelComandas.insertarComanda(Integer.parseInt(textFieldNumTrans.getText()),
								textFieldFecha.getText(), Double.parseDouble(textTotal.getText()), textLocal.getText(),
								productosAnadidosString, platosAnadidosString);

						JOptionPane.showMessageDialog(null, "Comanda introducida correctamente");
						controladorPanelComandas.accionadoBotonVolverPanelPrincipal();

					} else {
						JOptionPane.showMessageDialog(null, "Debes introducir articulos");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error al introducir la comanda");
				}

			}
		};
	}
}
