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

import Controlador.ControladorPanelComandas;

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
		setBackground(new Color(51, 153, 255));

		this.controladorPanelComandas = controladorPanelComandas;

		setLayout(null);

		textFieldFecha = new JTextField();
		textFieldFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(691, 117, 106, 20);
		add(textFieldFecha);
		textFieldFecha.setText(this.controladorPanelComandas.conseguirDatosPanel()[1]);
		textFieldFecha.setEditable(false);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setBounds(517, 545, 117, 25);
		add(btnVolver);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(332, 178, 216, 298);
		add(scrollPane);

		listaProductos = new JList(controladorPanelComandas.cogerListaProductos());
		scrollPane.setViewportView(listaProductos);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(581, 178, 216, 298);
		add(scrollPane_1);

		listaPlatos = new JList(controladorPanelComandas.cogerListaPlatos());
		scrollPane_1.setViewportView(listaPlatos);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(36, 178, 263, 108);
		add(scrollPane_2);

		productosAnadidos = new JList(productosAnadidosString);
		scrollPane_2.setViewportView(productosAnadidos);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(36, 333, 263, 108);
		add(scrollPane_3);

		platosAnadidos = new JList(platosAnadidosString);
		scrollPane_3.setViewportView(platosAnadidos);

		btnAnadirProducto = new JButton("A\u00F1adir producto");
		btnAnadirProducto.setBounds(332, 494, 163, 25);
		add(btnAnadirProducto);

		btnAnadirPlato = new JButton("A\u00F1adir plato");
		btnAnadirPlato.setBounds(581, 494, 163, 25);
		add(btnAnadirPlato);

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFinalizar.setBounds(200, 545, 117, 25);
		add(btnFinalizar);

		btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setBounds(83, 297, 168, 25);
		add(btnEliminarProducto);

		btnEliminarPlato = new JButton("Eliminar Plato");
		btnEliminarPlato.setBounds(83, 452, 168, 25);
		add(btnEliminarPlato);

		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(1); // valor m???nimo
		formatter.setMaximum(99); // valor m???ximo
		formatter.setAllowsInvalid(false);
		// Si quieres comprobar que sea v???lido, cada vez que se pulse una tecla
		formatter.setCommitsOnValidEdit(true);

		textCantidadProductos = new JFormattedTextField(formatter);
		textCantidadProductos.setHorizontalAlignment(SwingConstants.TRAILING);
		textCantidadProductos.setFont(new Font("Arial", Font.PLAIN, 12));
		textCantidadProductos.setBounds(521, 496, 27, 25);
		add(textCantidadProductos);
		textCantidadProductos.setText("1");

		textCantidadPlatos = new JFormattedTextField(formatter);
		textCantidadPlatos.setHorizontalAlignment(SwingConstants.TRAILING);
		textCantidadPlatos.setFont(new Font("Arial", Font.PLAIN, 12));
		textCantidadPlatos.setBounds(770, 496, 27, 25);
		add(textCantidadPlatos);
		textCantidadPlatos.setText("1");

		textTotal = new JTextField();
		textTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		textTotal.setBounds(90, 494, 114, 25);
		add(textTotal);
		textTotal.setColumns(10);
		textTotal.setText("0");
		textTotal.setEditable(false);

		textLocal = new JTextField();
		textLocal.setBounds(434, 117, 114, 20);
		add(textLocal);
		textLocal.setColumns(10);
		textLocal.setText(controladorPanelComandas.conseguirDatosPanel()[0]);
		textLocal.setHorizontalAlignment(SwingConstants.TRAILING);

		textFieldNumTrans = new JTextField();
		textFieldNumTrans.setBounds(185, 117, 114, 20);
		add(textFieldNumTrans);
		textFieldNumTrans.setEditable(false);
		textFieldNumTrans.setColumns(10);
		textFieldNumTrans.setText(Integer.toString(this.controladorPanelComandas.conseguirNumTrans()));
		textFieldNumTrans.setHorizontalAlignment(SwingConstants.TRAILING);

		JLabel lblNumTrans = new JLabel("N\u00BA Transacci\u00F3n:");
		lblNumTrans.setFont(new Font("Arial", Font.BOLD, 16));
		lblNumTrans.setBounds(36, 117, 150, 20);
		add(lblNumTrans);

		JLabel lblLocal = new JLabel("Local:\r\n");
		lblLocal.setFont(new Font("Arial", Font.BOLD, 16));
		lblLocal.setBounds(332, 117, 70, 20);
		add(lblLocal);

		JLabel lblFecha = new JLabel("Fecha y hora: ");
		lblFecha.setFont(new Font("Arial", Font.BOLD, 16));
		lblFecha.setBounds(581, 117, 123, 20);
		add(lblFecha);

		JLabel lblProductos = new JLabel("Productos:");
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setFont(new Font("Arial", Font.BOLD, 16));
		lblProductos.setBounds(332, 148, 216, 23);
		add(lblProductos);

		JLabel lblPlatos = new JLabel("Platos:");
		lblPlatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlatos.setFont(new Font("Arial", Font.BOLD, 16));
		lblPlatos.setBounds(581, 148, 216, 23);
		add(lblPlatos);

		lblError = new JLabel("");
		lblError.setBounds(36, 148, 263, 23);
		add(lblError);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
		lblTotal.setBounds(36, 494, 50, 25);
		add(lblTotal);

		JLabel lblBG = new JLabel(new ImageIcon("media\\bg_comandas.jpg"));
		lblBG.setBounds(0, 0, 834, 611);
		add(lblBG);

		JLabel lblComandas = new JLabel("COMANDAS");
		lblComandas.setHorizontalAlignment(SwingConstants.CENTER);
		lblComandas.setFont(new Font("Arial", Font.BOLD, 50));
		lblComandas.setBounds(36, 35, 761, 50);
		add(lblComandas);

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
				controladorPanelComandas.accionadoBottonVolverPanelPrincipal();
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
					producto = (String) listaProductos.getSelectedValue(); // Necesito hacer aqu??? el cast porque
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
											"No puedes a???adir esa cantidad, el stock es de " + stock
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
								textFieldFecha.getText(), textLocal.getText(),
								productosAnadidosString, platosAnadidosString);

						JOptionPane.showMessageDialog(null, "Comanda introducida correctamente");
						controladorPanelComandas.accionadoBottonVolverPanelPrincipal();

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
