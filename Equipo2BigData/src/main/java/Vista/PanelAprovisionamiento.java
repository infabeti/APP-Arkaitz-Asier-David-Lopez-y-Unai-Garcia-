package Vista;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorPanelAprovisionamiento;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;
import javax.swing.SwingConstants;

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

		setBackground(SystemColor.activeCaption);

		this.controladorPanelAprovisionamiento = controladorPanelAprovisionamiento;

		setLayout(null);

		lblTextoPanel = new JLabel("PANEL APROVISIONAMIENTO");
		lblTextoPanel.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblTextoPanel.setBounds(0, 0, 450, 67);
		add(lblTextoPanel);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(620, 553, 89, 23);
		add(btnVolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 187, 295, 304);
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
		textFieldCantidad.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldCantidad.setBounds(189, 512, 58, 19);
		add(textFieldCantidad);
		textFieldCantidad.setText("1");
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(109, 515, 70, 15);
		add(lblCantidad);
		
		btnAnnadir = new JButton("A\u00F1adir");
		btnAnnadir.setBounds(257, 510, 117, 25);
		add(btnAnnadir);
		
		JLabel lblLocal = new JLabel("Local:\r\n");
		lblLocal.setFont(new Font("Arial", Font.PLAIN, 17));
		lblLocal.setBounds(22, 111, 113, 23);
		add(lblLocal);
		
		JLabel lblNumTrans = new JLabel("Numero de transacci\u00F3n: \r\n");
		lblNumTrans.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNumTrans.setBounds(22, 69, 187, 23);
		add(lblNumTrans);
		
		textFieldLocl = new JTextField();
		textFieldLocl.setText(controladorPanelAprovisionamiento.conseguirLocal());
		textFieldLocl.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLocl.setEditable(false);
		textFieldLocl.setColumns(10);
		textFieldLocl.setBounds(212, 109, 125, 30);
		add(textFieldLocl);
		
		textFieldNumTrans = new JTextField();
		textFieldNumTrans.setText(controladorPanelAprovisionamiento.leerNumTransBBDD());
		textFieldNumTrans.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumTrans.setEditable(false);
		textFieldNumTrans.setColumns(10);
		textFieldNumTrans.setBounds(212, 67, 125, 30);
		add(textFieldNumTrans);
		
		JLabel lblFecha = new JLabel("Fecha y hora: ");
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 17));
		lblFecha.setBounds(347, 69, 113, 23);
		add(lblFecha);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setText(controladorPanelAprovisionamiento.devolverFechaHora());
		textFieldFecha.setEditable(false);
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(463, 67, 106, 30);
		add(textFieldFecha);
		
		lblProd = new JLabel("PRODUCTOS");
		lblProd.setFont(new Font("Arial", Font.PLAIN, 17));
		lblProd.setBounds(189, 162, 113, 23);
		add(lblProd);

		initializeEvents();

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
					controladorPanelAprovisionamiento.accionadoBotonAnnadir(cantidad, seleccionado, nombreAlimento);
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
