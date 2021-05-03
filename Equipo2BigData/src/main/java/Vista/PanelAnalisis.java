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
	private JButton btnTickets;
	private JButton btnComandas;
	private JLabel lblTextoPanel;
	private JButton btnDesconectar;
	private JTextField textFieldLocal;


	public PanelAnalisis(ControladorPanelAnalisis controladorPanelAnalisis, String tipoLocal, String nombreUsuario, String nombreLocal) {
		setBackground(new Color(51, 153, 255));


		this.controladorPanelAnalisis = controladorPanelAnalisis;

		setLayout(null);

		btnTickets = new JButton("Productos relacionados del local");
		btnTickets.setFont(new Font("Arial", Font.BOLD, 15));
		btnTickets.setBounds(395, 173, 300, 25);
		add(btnTickets);

		btnDesconectar = new JButton("Salir");
		btnDesconectar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDesconectar.setBounds(358, 545, 117, 25);
		add(btnDesconectar);

		lblTextoPanel = new JLabel("PANEL AN\u00C1LISIS");
		lblTextoPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoPanel.setFont(new Font("Arial", Font.BOLD, 50));
		lblTextoPanel.setBounds(139, 35, 556, 50);
		add(lblTextoPanel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 247, 556, 186);
		add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);

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

		btnComandas = new JButton("Productos relacionados generales");
		btnComandas.setFont(new Font("Arial", Font.BOLD, 15));
		btnComandas.setBounds(395, 210, 300, 25);
		add(btnComandas);
		initializeEvents();

	}

	private void initializeEvents() {
		this.btnTickets.addActionListener(listenerBotonTickets(this.controladorPanelAnalisis));
		this.btnDesconectar.addActionListener(listenerBotonDesconectar(this.controladorPanelAnalisis));
		this.btnComandas.addActionListener(listenerBotonComandas(this.controladorPanelAnalisis));
	}

	private ActionListener listenerBotonTickets(ControladorPanelAnalisis controladorPanelAnalisis) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Tickets");
				//controladorPanelAnalisis.accionadoBottonMostrarPanelTickets();
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

	private ActionListener listenerBotonComandas(ControladorPanelAnalisis controladorPanelAnalisis) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Comandas");
				//controladorPanelAnalisis.accionadoBottonMostrarPanelComandas();
			}
		};
	}
}
