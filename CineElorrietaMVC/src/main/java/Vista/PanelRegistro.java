package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorPanelRegistro;

import java.awt.SystemColor;
import javax.swing.JTextField;

import javax.swing.JOptionPane;

import javax.swing.JPasswordField;

public class PanelRegistro extends JPanel {

	private static final long serialVersionUID = 8145987517742125982L;
	private JLabel lblTextoPanel;
	private JTextField textNIF;
	private JPasswordField passwordContrasena;
	private ControladorPanelRegistro controlador;
	private JButton btnVolver;
	private JButton btnRegistrar;
	private JTextField textDNI;
	private JTextField textNombre;
	private JTextField textApellido;

	public PanelRegistro(ControladorPanelRegistro controladorPanelRegistro) {
		setBackground(SystemColor.activeCaption);

		this.controlador = controladorPanelRegistro;

		setLayout(null);

		lblTextoPanel = new JLabel("PANEL REGISTRO:");
		lblTextoPanel.setFont(new Font("Arial", Font.BOLD, 27));
		lblTextoPanel.setBounds(163, 11, 331, 46);
		add(lblTextoPanel);

		JLabel lblNIF = new JLabel("NIF Local:");
		lblNIF.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNIF.setBounds(33, 211, 101, 23);
		add(lblNIF);

		textNIF = new JTextField();
		textNIF.setFont(new Font("Arial", Font.PLAIN, 15));
		textNIF.setBounds(146, 212, 162, 25);
		add(textNIF);
		textNIF.setColumns(10);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVolver.setBounds(175, 323, 101, 30);
		add(btnVolver);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegistrar.setBounds(48, 323, 101, 30);
		add(btnRegistrar);

		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDNI.setBounds(325, 79, 81, 30);
		add(lblDNI);

		JLabel lblContrasenna = new JLabel("Contrase\u00F1a:");
		lblContrasenna.setFont(new Font("Arial", Font.PLAIN, 20));
		lblContrasenna.setBounds(31, 251, 127, 23);
		add(lblContrasenna);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNombre.setBounds(28, 82, 89, 24);
		add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 20));
		lblApellido.setBounds(28, 128, 106, 20);
		add(lblApellido);

		textDNI = new JTextField();

		textDNI.setBounds(377, 83, 162, 23);
		add(textDNI);
		textDNI.setColumns(10);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Arial", Font.PLAIN, 15));

		textNombre.setBounds(113, 82, 181, 24);
		add(textNombre);
		textNombre.setColumns(10);

		textApellido = new JTextField();
		textApellido.setFont(new Font("Arial", Font.PLAIN, 15));

		textApellido.setBounds(113, 128, 181, 25);
		add(textApellido);
		textApellido.setColumns(10);

		passwordContrasena = new JPasswordField();

		passwordContrasena.setBounds(146, 254, 162, 23);
		add(passwordContrasena);

		initializeEvents();

	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controlador));
		this.btnRegistrar.addActionListener(listenerBotonRegistrar(this.controlador));
	}

	private ActionListener listenerBotonVolver(ControladorPanelRegistro controladorPanelRegistro) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelRegistro.accionadoBottonVolverPanelLogin();
			}
		};
	}

	private ActionListener listenerBotonRegistrar(ControladorPanelRegistro controladorPanelRegistro) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Registrar");

				String nombre = textNombre.getText();
				String dni = textDNI.getText();
				String nif = textNIF.getText();
				String apellido = textApellido.getText();
				@SuppressWarnings("deprecation")
				String password = passwordContrasena.getText();
				String mensaje = controladorPanelRegistro.comprobarCamposRegistro(nombre, apellido, nif, dni, password);

				if (mensaje.equals("")) {
					// insertar datos en empleado
					controladorPanelRegistro.insertarRegistro(dni, nombre, apellido, password, nif);

					JOptionPane.showMessageDialog(null, "Empleado introducido correctamente");
					controladorPanelRegistro.accionadoBottonVolverPanelLogin();
				}
				else {
					JOptionPane.showMessageDialog(null, mensaje);
				}

			}

		};
	}
}