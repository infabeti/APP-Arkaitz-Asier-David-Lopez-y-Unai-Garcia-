package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

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

import Controlador.ControladorPanelAprovisionamiento;

public class PanelAprovisionamiento extends JPanel {

	private static final long serialVersionUID = -8048832364382290273L;
	private ControladorPanelAprovisionamiento controladorPanelAprovisionamiento;
	private JLabel lblTextoPanel;
	private JButton btnVolver;
	private JList listaProductos;
	private JFormattedTextField textFieldCantidad;
	private JButton btnAnnadir;
	private JTextField textFieldLocl;
	private JTextField textFieldNumTrans;
	private JTextField textFieldFecha;
	private JLabel lblProd;

	public PanelAprovisionamiento(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {

		setBackground(new Color(51, 153, 255));

		this.controladorPanelAprovisionamiento = controladorPanelAprovisionamiento;

		setLayout(null);

		textFieldNumTrans = new JTextField();
		textFieldNumTrans.setText(this.controladorPanelAprovisionamiento.conseguirNumTrans());
		textFieldNumTrans.setHorizontalAlignment(SwingConstants.TRAILING);
		textFieldNumTrans.setColumns(10);
		textFieldNumTrans.setEditable(false);
		textFieldNumTrans.setBounds(560, 214, 114, 20);
		add(textFieldNumTrans);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setBounds(358, 545, 117, 25);
		add(btnVolver);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 158, 295, 304);
		add(scrollPane);
		
		listaProductos = new JList(this.controladorPanelAprovisionamiento.pasarListaProductos());
		
		scrollPane.setViewportView(listaProductos);

		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(1); // valor m�nimo
		formatter.setMaximum(99); // valor m�ximo
		formatter.setAllowsInvalid(false);
		// Si quieres comprobar que sea v�lido, cada vez que se pulse una tecla
		formatter.setCommitsOnValidEdit(true);

		textFieldCantidad = new JFormattedTextField(formatter);
		textFieldCantidad.setHorizontalAlignment(SwingConstants.TRAILING);
		textFieldCantidad.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldCantidad.setBounds(270, 473, 40, 20);
		add(textFieldCantidad);
		textFieldCantidad.setText("1");

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Arial", Font.BOLD, 16));
		lblCantidad.setBounds(160, 473, 92, 20);
		add(lblCantidad);

		btnAnnadir = new JButton("A\u00F1adir");
		btnAnnadir.setBounds(338, 473, 117, 20);
		add(btnAnnadir);

		JLabel lblLocal = new JLabel("Local:\r\n");
		lblLocal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLocal.setFont(new Font("Arial", Font.BOLD, 16));
		lblLocal.setBounds(604, 270, 70, 20);
		add(lblLocal);

		JLabel lblNumTrans = new JLabel("N\u00BA Transacci\u00F3n:");
		lblNumTrans.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumTrans.setFont(new Font("Arial", Font.BOLD, 16));
		lblNumTrans.setBounds(524, 158, 150, 20);
		add(lblNumTrans);

		textFieldLocl = new JTextField();
		textFieldLocl.setText(controladorPanelAprovisionamiento.conseguirLocal());
		textFieldLocl.setHorizontalAlignment(SwingConstants.TRAILING);
		textFieldLocl.setColumns(10);
		textFieldLocl.setBounds(560, 326, 114, 20);
		add(textFieldLocl);

		JLabel lblFecha = new JLabel("Fecha y hora: ");
		lblFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFecha.setFont(new Font("Arial", Font.BOLD, 16));
		lblFecha.setBounds(551, 382, 123, 20);
		add(lblFecha);

		textFieldFecha = new JTextField();
		textFieldFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		textFieldFecha.setText(controladorPanelAprovisionamiento.devolverFechaHora());
		textFieldFecha.setEditable(false);
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(560, 438, 114, 20);
		add(textFieldFecha);

		lblProd = new JLabel("Productos:");
		lblProd.setHorizontalAlignment(SwingConstants.CENTER);
		lblProd.setFont(new Font("Arial", Font.BOLD, 16));
		lblProd.setBounds(160, 133, 295, 23);
		add(lblProd);

		JLabel lblBG = new JLabel(new ImageIcon("media\\bg_aprovisionamiento.jpg"));
		lblBG.setBounds(0, 0, 834, 611);
		add(lblBG);

		lblTextoPanel = new JLabel("APROVISIONAMIENTO");
		lblTextoPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoPanel.setFont(new Font("Arial", Font.BOLD, 50));
		lblTextoPanel.setBounds(139, 35, 556, 50);
		add(lblTextoPanel);

		
		comprobarError();
		initializeEvents();

	}
	
	private void comprobarError() {
		if(textFieldNumTrans.getText().equals("Error en BBDD")) {
			btnAnnadir.setEnabled(false);
		}
	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelAprovisionamiento));
		this.btnAnnadir.addActionListener(listenerBotonAnnadir(this.controladorPanelAprovisionamiento));
	}

	private ActionListener listenerBotonVolver(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelAprovisionamiento.accionadoBottonVolverPanelPrincipal();
			}
		};
	}

	private ActionListener listenerBotonAnnadir(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Annadir");
				System.out.println(listaProductos.getSelectedIndex());
				if(listaProductos.getSelectedIndex()!=-1)
				{
					int cantidad = Integer.parseInt(textFieldCantidad.getText());
					int seleccionado = listaProductos.getSelectedIndex();
					String nombreAlimento = (String) listaProductos.getSelectedValue();
					controladorPanelAprovisionamiento.accionadoBotonAnnadir(cantidad, seleccionado, nombreAlimento, Integer.parseInt(textFieldNumTrans.getText()), textFieldLocl.getText());
					JOptionPane.showMessageDialog(null, "Aprovisionado " + cantidad + " " + listaProductos.getSelectedValue() + " Correctamente");
					controladorPanelAprovisionamiento.accionadoBottonVolverPanelPrincipal();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Debes seleccionar un elemento");

				}


			}
		};
	}
}
