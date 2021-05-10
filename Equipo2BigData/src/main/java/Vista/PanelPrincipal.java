package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controlador.ControladorPanelPrincipal;

public class PanelPrincipal extends JPanel {


	private static final long serialVersionUID = -2457862673139031544L;
	private ControladorPanelPrincipal controladorPanelPrincipal;
	private JButton btnPedidos;
	private JButton btnTickets;
	private JButton btnFacturas;
	private JButton btnAprovisionamiento;
	private JButton btnComandas;
	private JLabel lblTextoPanel;
	private JButton btnDesconectar;
	private JLabel lblTipoLocal,lblTipoLocalTexto;
	private JLabel lblNomLocal;
	private JLabel lblNomLocalTexto;
	private JLabel lblUsuario;
	private JLabel lblUsuarioTexto;


	public PanelPrincipal(ControladorPanelPrincipal controladorPanelPrincipal, String tipoLocal, String nombreUsuario, String nombreLocal) {
		setBackground(new Color(51, 153, 255));


		this.controladorPanelPrincipal = controladorPanelPrincipal;

		setLayout(null);

		btnPedidos = new JButton("Pedidos");
		btnPedidos.setFont(new Font("Arial", Font.BOLD, 15));
		btnPedidos.setBounds(568, 376, 127, 57);
		add(btnPedidos);

		btnTickets = new JButton("Tickets");
		btnTickets.setFont(new Font("Arial", Font.BOLD, 15));
		btnTickets.setBounds(139, 288, 127, 57);
		add(btnTickets);

		btnFacturas = new JButton("Facturas");
		btnFacturas.setFont(new Font("Arial", Font.BOLD, 15));
		btnFacturas.setBounds(353, 288, 127, 57);
		add(btnFacturas);

		btnAprovisionamiento = new JButton("Aprovisionamiento");
		btnAprovisionamiento.setFont(new Font("Arial", Font.BOLD, 15));
		btnAprovisionamiento.setBounds(139, 375, 341, 59);
		add(btnAprovisionamiento);

		btnComandas = new JButton("Comandas");
		btnComandas.setFont(new Font("Arial", Font.BOLD, 15));
		btnComandas.setBounds(568, 288, 127, 57);
		add(btnComandas);

		btnDesconectar = new JButton("Salir");
		btnDesconectar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDesconectar.setBounds(358, 545, 117, 25);
		add(btnDesconectar);

		lblTipoLocal = new JLabel("TIPO LOCAL: ");
		lblTipoLocal.setFont(new Font("Arial", Font.BOLD, 16));
		lblTipoLocal.setBounds(139, 214, 106, 30);
		add(lblTipoLocal);

		lblTipoLocalTexto = new JLabel("");
		lblTipoLocalTexto.setFont(new Font("Arial", Font.BOLD, 15));
		lblTipoLocalTexto.setBounds(255, 214, 180, 30);
		lblTipoLocalTexto.setText(tipoLocal);
		add(lblTipoLocalTexto);

		lblNomLocal = new JLabel("LOCAL:");
		lblNomLocal.setFont(new Font("Arial", Font.BOLD, 16));
		lblNomLocal.setBounds(139, 173, 65, 30);
		add(lblNomLocal);

		lblNomLocalTexto = new JLabel("");
		lblNomLocalTexto.setFont(new Font("Arial", Font.BOLD, 15));
		lblNomLocalTexto.setBounds(209, 173, 180, 30);
		lblNomLocalTexto.setText(nombreLocal);
		add(lblNomLocalTexto);

		lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 16));
		lblUsuario.setBounds(605, 173, 90, 30);
		add(lblUsuario);

		lblUsuarioTexto = new JLabel("");
		lblUsuarioTexto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsuarioTexto.setFont(new Font("Arial", Font.BOLD, 15));
		lblUsuarioTexto.setBounds(515, 214, 180, 30);
		lblUsuarioTexto.setText(nombreUsuario);
		add(lblUsuarioTexto);
		initializeEvents();

		if(tipoLocal.equals("BAR")) {
			btnComandas.setVisible(false);
			btnPedidos.setVisible(false);
		}
		else if(tipoLocal.equals("CAFETERIA")) {
			btnComandas.setVisible(false);
		}

		JLabel lblBG = new JLabel(new ImageIcon("media\\bg_main.jpg"));
		lblBG.setBounds(0, 0, 834, 611);
		add(lblBG);

		lblTextoPanel = new JLabel("PANEL PRINCIPAL");
		lblTextoPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoPanel.setFont(new Font("Arial", Font.BOLD, 50));
		lblTextoPanel.setBounds(139, 35, 556, 50);
		add(lblTextoPanel);

	}

	private void initializeEvents() {
		this.btnPedidos.addActionListener(listenerBotonPedidos(this.controladorPanelPrincipal));
		this.btnAprovisionamiento.addActionListener(listenerBotonAprovisionamiento(this.controladorPanelPrincipal));
		this.btnTickets.addActionListener(listenerBotonTickets(this.controladorPanelPrincipal));
		this.btnFacturas.addActionListener(listenerBotonFacturas(this.controladorPanelPrincipal));
		this.btnDesconectar.addActionListener(listenerBotonDesconectar(this.controladorPanelPrincipal));
		this.btnComandas.addActionListener(listenerBotonComandas(this.controladorPanelPrincipal));
	}

	private ActionListener listenerBotonPedidos(ControladorPanelPrincipal controladorPanelPrincipal) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Pedidos");
				controladorPanelPrincipal.accionadoBottonMostrarPanelPedidos();
			}
		};
	}

	private ActionListener listenerBotonAprovisionamiento(ControladorPanelPrincipal controladorPanelPrincipal) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Aprovisionamiento");
				controladorPanelPrincipal.accionadoBottonMostrarPanelAprovisionamiento();
			}
		};
	}

	private ActionListener listenerBotonTickets(ControladorPanelPrincipal controladorPanelPrincipal) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Tickets");
				controladorPanelPrincipal.accionadoBottonMostrarPanelTickets();
			}
		};
	}

	private ActionListener listenerBotonDesconectar(ControladorPanelPrincipal controladorPanelPrincipal) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Desconectar");
				controladorPanelPrincipal.accionadoBottonDesconectarPanelPrincipal();
			}
		};
	}
	private ActionListener listenerBotonFacturas(ControladorPanelPrincipal controladorPanelPrincipal) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Facturas");
				controladorPanelPrincipal.accionadoBottonMostrarPanelFacturas();
			}
		};
	}

	private ActionListener listenerBotonComandas(ControladorPanelPrincipal controladorPanelPrincipal) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Comandas");
				controladorPanelPrincipal.accionadoBottonMostrarPanelComandas();
			}
		};
	}
}
