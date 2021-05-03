package Vista;

import javax.swing.JPanel;


import Controlador.ControladorPanelAnalisis;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;

public class PanelAnalisis extends JPanel {


	private static final long serialVersionUID = -2457862673139031544L;
	private ControladorPanelAnalisis controladorPanelAnalisis;
	private JButton btnProdLocal;
	private JButton btnProdGeneral;
	private JLabel lblTextoPanel;
	private JButton btnDesconectar;
	private JTextField textFieldLocal;
	private JScrollPane scrollPane;
	private JList listaProductos;


	public PanelAnalisis(ControladorPanelAnalisis controladorPanelAnalisis, String tipoLocal, String nombreUsuario, String nombreLocal) {
		setBackground(new Color(51, 153, 255));


		this.controladorPanelAnalisis = controladorPanelAnalisis;

		setLayout(null);

		btnProdLocal = new JButton("Productos relacionados del local");
		btnProdLocal.setFont(new Font("Arial", Font.BOLD, 15));
		btnProdLocal.setBounds(395, 173, 300, 25);
		add(btnProdLocal);

		btnDesconectar = new JButton("Salir");
		btnDesconectar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDesconectar.setBounds(358, 545, 117, 25);
		add(btnDesconectar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 247, 556, 186);
		add(scrollPane);
		
		listaProductos = new JList();
		scrollPane.setViewportView(listaProductos);

		textFieldLocal = new JTextField();
		textFieldLocal.setText(controladorPanelAnalisis.conseguirLocal());
		textFieldLocal.setHorizontalAlignment(SwingConstants.TRAILING);
		textFieldLocal.setColumns(10);
		textFieldLocal.setBounds(139, 210, 114, 25);
		add(textFieldLocal);

		JLabel lblLocal = new JLabel("NIF del Local:\r\n");
		lblLocal.setFont(new Font("Arial", Font.BOLD, 16));
		lblLocal.setBounds(139, 173, 114, 25);
		add(lblLocal);

		btnProdGeneral = new JButton("Productos relacionados generales");
		btnProdGeneral.setFont(new Font("Arial", Font.BOLD, 15));
		btnProdGeneral.setBounds(395, 210, 300, 25);
		add(btnProdGeneral);

		JLabel lblBG = new JLabel(new ImageIcon("media\\bg_analisis.jpg"));
		lblBG.setBounds(0, 0, 834, 611);
		add(lblBG);
		
				lblTextoPanel = new JLabel("PANEL DE AN\u00C1LISIS");
				lblTextoPanel.setHorizontalAlignment(SwingConstants.CENTER);
				lblTextoPanel.setFont(new Font("Arial", Font.BOLD, 50));
				lblTextoPanel.setBounds(139, 35, 556, 50);
				add(lblTextoPanel);
		
		initializeEvents();

	}

	private void initializeEvents() {
		this.btnProdLocal.addActionListener(listenerBotonProdLocal(this.controladorPanelAnalisis));
		this.btnDesconectar.addActionListener(listenerBotonDesconectar(this.controladorPanelAnalisis));
		this.btnProdGeneral.addActionListener(listenerBotonProdGeneral(this.controladorPanelAnalisis));
	}

	private ActionListener listenerBotonProdLocal(ControladorPanelAnalisis controladorPanelAnalisis) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Productos relacionados del local");
				//listaProductos.addElement("Texto de prueba: Productos Locales");
				controladorPanelAnalisis.accionadoBottonMostrarProdLocal();
			}
		};
	}

	private ActionListener listenerBotonProdGeneral(ControladorPanelAnalisis controladorPanelAnalisis) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Productos relacionados generales");
				//listaProductos.addElement("Texto de prueba: Productos Generales");
				controladorPanelAnalisis.accionadoBottonMostrarProdGeneral();
			}
		};
	}

	private ActionListener listenerBotonDesconectar(ControladorPanelAnalisis controladorPanelAnalisis) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Desconectar");
				controladorPanelAnalisis.accionadoBottonDesconectarPanelAnalisis();
			}
		};
	}
}
