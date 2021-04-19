package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorInicio;

import java.awt.SystemColor;
import javax.swing.JTextField;

import javax.swing.JOptionPane;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PanelInicio extends JPanel {

	private static final long serialVersionUID = 1277387748273811115L;
	private JLabel lblTextoPanel;
	private JTextField textFieldNomUsuario;
	private JPasswordField textFieldpassword;
	private ControladorInicio controlador;
	private JButton btnAceptar;
	private JButton btnRegistro;

	public PanelInicio(ControladorInicio controladorInicio) {
		setBackground(new Color(51, 153, 255));

		this.controlador = controladorInicio;

		setLayout(null);

		lblTextoPanel = new JLabel("INICIO");
		lblTextoPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoPanel.setFont(new Font("Arial", Font.BOLD, 50));
		lblTextoPanel.setBounds(209, 35, 412, 46);
		add(lblTextoPanel);

		textFieldNomUsuario = new JTextField();
		textFieldNomUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldNomUsuario.setBounds(34, 32, 234, 46);
		textFieldNomUsuario.setColumns(10);
		textFieldNomUsuario.setText("75623142C");
		add(textFieldNomUsuario);

		textFieldpassword = new JPasswordField();
		textFieldpassword.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldpassword.setColumns(10);
		textFieldpassword.setBounds(34, 89, 234, 46);
		textFieldpassword.setText("12345");
		add(textFieldpassword);

		btnAceptar = new JButton("Login");
		btnAceptar.setFont(new Font("Arial", Font.PLAIN, 24));
		btnAceptar.setBounds(34, 146, 136, 46);
		add(btnAceptar);

		btnRegistro = new JButton("Registro");
		btnRegistro.setFont(new Font("Arial", Font.PLAIN, 20));
		btnRegistro.setBounds(34, 203, 141, 41);
		add(btnRegistro);
		
		JButton btnPoblacion = new JButton(" Poblaci\u00F3n de Datos");
		btnPoblacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPoblacion.setBounds(143, 280, 200, 70);
		add(btnPoblacion);
		
		JButton btnAnalisis = new JButton("An\u00E1lisis de Datos");
		btnAnalisis.setEnabled(false);
		btnAnalisis.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAnalisis.setBounds(486, 280, 200, 70);
		add(btnAnalisis);

		initializeEvents();

	}

	private void initializeEvents() {
		this.btnAceptar.addActionListener(listenerBotonAceptar(this.controlador));
		this.btnRegistro.addActionListener(listenerBotonRegistro(this.controlador));

	}

	private ActionListener listenerBotonAceptar(ControladorInicio controladorInicio) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton LOGIN");

				String userName = textFieldNomUsuario.getText();
				@SuppressWarnings("deprecation")
				String password = textFieldpassword.getText();

				if (controlador.login(userName, password)) {

					JOptionPane.showMessageDialog(null, "Logueado correctamente");
					controlador.accionadoBottonAceptarPanelPrincipal();
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");

				}

			}
		};
	}

	private ActionListener listenerBotonRegistro(ControladorInicio controladorInicio) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Registro");
				controladorInicio.accionadoBottonRegistroPanelInicio();
			}
		};
	}
}

