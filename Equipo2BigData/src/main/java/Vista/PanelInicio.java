package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
	private ControladorInicio controlador;
	private JButton btnPoblacion;

	public PanelInicio(ControladorInicio controladorInicio) {
		setBackground(new Color(51, 153, 255));

		this.controlador = controladorInicio;

		setLayout(null);
		
		btnPoblacion = new JButton(" Poblaci\u00F3n de Datos");
		btnPoblacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPoblacion.setBounds(144, 270, 200, 70);
		add(btnPoblacion);
		
		JButton btnAnalisis = new JButton("An\u00E1lisis de Datos");
		btnAnalisis.setEnabled(false);
		btnAnalisis.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAnalisis.setBounds(488, 270, 200, 70);
		add(btnAnalisis);

		JLabel lblBG = new JLabel(new ImageIcon("media\\bg_inicio.jpg"));
		lblBG.setBounds(0, 0, 834, 611);
		add(lblBG);
		
				lblTextoPanel = new JLabel("INICIO");
				lblTextoPanel.setHorizontalAlignment(SwingConstants.CENTER);
				lblTextoPanel.setFont(new Font("Arial", Font.BOLD, 50));
				lblTextoPanel.setBounds(139, 35, 556, 50);
				add(lblTextoPanel);

		initializeEvents();
	}

	private void initializeEvents() {
		this.btnPoblacion.addActionListener(listenerBotonAceptar(this.controlador));

	}

	private ActionListener listenerBotonAceptar(ControladorInicio controladorInicio) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton INICIO");
				if (controlador.login("75623142C", "12345")) {
					controlador.accionadoBottonVolverPanelPrincipal();
				} else {
					JOptionPane.showMessageDialog(null, "Fallo al iniciar");

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

