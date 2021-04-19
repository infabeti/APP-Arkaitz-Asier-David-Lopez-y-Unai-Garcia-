package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorLogin;

import java.awt.SystemColor;
import javax.swing.JTextField;

import javax.swing.JOptionPane;

import javax.swing.JPasswordField;

public class PanelLogin extends JPanel {

	private static final long serialVersionUID = 1277387748273811115L;
	private JLabel lblTextoPanel;
	private JTextField textFieldNomUsuario;
	private JPasswordField textFieldpassword;
	private ControladorLogin controlador;
	private JButton btnAceptar;
	private JButton btnRegistro;

	public PanelLogin(ControladorLogin controladorLogin) {
		setBackground(SystemColor.activeCaption);

		this.controlador = controladorLogin;

		setLayout(null);

		lblTextoPanel = new JLabel("PANEL LOGIN");
		lblTextoPanel.setFont(new Font("Arial", Font.BOLD, 50));
		lblTextoPanel.setBounds(226, 11, 412, 46);
		add(lblTextoPanel);

		JLabel lbldni = new JLabel("DNI: ");
		lbldni.setFont(new Font("Arial", Font.PLAIN, 28));
		lbldni.setBounds(181, 129, 141, 23);
		add(lbldni);

		textFieldNomUsuario = new JTextField();
		textFieldNomUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldNomUsuario.setBounds(363, 120, 234, 46);
		textFieldNomUsuario.setColumns(10);
		textFieldNomUsuario.setText("75623142C");
		add(textFieldNomUsuario);

		JLabel lblLocal = new JLabel("Contrase\u00F1a:");
		lblLocal.setFont(new Font("Arial", Font.PLAIN, 28));
		lblLocal.setBounds(181, 214, 169, 23);
		add(lblLocal);

		textFieldpassword = new JPasswordField();
		textFieldpassword.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldpassword.setColumns(10);
		textFieldpassword.setBounds(363, 205, 234, 46);
		textFieldpassword.setText("12345");
		add(textFieldpassword);

		btnAceptar = new JButton("Login");
		btnAceptar.setFont(new Font("Arial", Font.PLAIN, 24));
		btnAceptar.setBounds(393, 284, 136, 46);
		add(btnAceptar);

		btnRegistro = new JButton("Registro");
		btnRegistro.setFont(new Font("Arial", Font.PLAIN, 20));
		btnRegistro.setBounds(116, 499, 141, 41);
		add(btnRegistro);
		
		JLabel lblReg = new JLabel("\u00BFAun no estas registrado?");
		lblReg.setFont(new Font("Arial", Font.PLAIN, 20));
		lblReg.setBounds(73, 465, 277, 23);
		add(lblReg);

		initializeEvents();

	}

	private void initializeEvents() {
		this.btnAceptar.addActionListener(listenerBotonAceptar(this.controlador));
		this.btnRegistro.addActionListener(listenerBotonRegistro(this.controlador));

	}

	private ActionListener listenerBotonAceptar(ControladorLogin controladorLogin) {
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

	private ActionListener listenerBotonRegistro(ControladorLogin controladorLogin) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Registro");
				controladorLogin.accionadoBottonRegistroPanelLogin();
			}
		};
	}
}

