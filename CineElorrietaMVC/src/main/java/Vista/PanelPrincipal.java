package Vista;

import javax.swing.JPanel;


import Controlador.ControladorPanelPrincipal;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;

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
		setBackground(SystemColor.activeCaption);

		
			this.controladorPanelPrincipal = controladorPanelPrincipal;
			
			setLayout(null);
			
			btnPedidos = new JButton("Pedidos");
			btnPedidos.setFont(new Font("Arial", Font.BOLD, 15));
			btnPedidos.setBounds(380, 284, 127, 57);
			add(btnPedidos);
			
			btnTickets = new JButton("Tickets");
			btnTickets.setFont(new Font("Arial", Font.BOLD, 15));
			btnTickets.setBounds(50, 196, 127, 57);
			add(btnTickets);
			
			btnFacturas = new JButton("Facturas");
			btnFacturas.setFont(new Font("Arial", Font.BOLD, 15));
			btnFacturas.setBounds(215, 196, 127, 57);
			add(btnFacturas);
			
			btnAprovisionamiento = new JButton("Aprovisionamiento");
			btnAprovisionamiento.setFont(new Font("Arial", Font.BOLD, 15));
			btnAprovisionamiento.setBounds(50, 283, 292, 59);
			add(btnAprovisionamiento);
			
			btnComandas = new JButton("Comandas");
			btnComandas.setFont(new Font("Arial", Font.BOLD, 15));
			btnComandas.setBounds(380, 196, 127, 57);
			add(btnComandas);
			
			lblTextoPanel = new JLabel("PANEL PRINCIPAL");
			lblTextoPanel.setFont(new Font("Arial", Font.PLAIN, 31));
			lblTextoPanel.setBounds(0, 4, 450, 67);
			add(lblTextoPanel);
			
			btnDesconectar = new JButton("Desconectar");
			btnDesconectar.setBounds(243, 472, 127, 23);
			add(btnDesconectar);
			
			lblTipoLocal = new JLabel("TIPO LOCAL: ");
			lblTipoLocal.setFont(new Font("Arial", Font.BOLD, 15));
			lblTipoLocal.setBounds(30, 96, 121, 30);
			add(lblTipoLocal);
			
			lblTipoLocalTexto = new JLabel("");
			lblTipoLocalTexto.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTipoLocalTexto.setBounds(138, 96, 226, 30);
			lblTipoLocalTexto.setText(tipoLocal);
			add(lblTipoLocalTexto);
			
			lblNomLocal = new JLabel("LOCAL:");
			lblNomLocal.setFont(new Font("Arial", Font.BOLD, 15));
			lblNomLocal.setBounds(30, 67, 65, 30);
			add(lblNomLocal);
			
			lblNomLocalTexto = new JLabel("");
			lblNomLocalTexto.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNomLocalTexto.setBounds(90, 67, 292, 30);
			lblNomLocalTexto.setText(nombreLocal);
			add(lblNomLocalTexto);
			
			lblUsuario = new JLabel("USUARIO:");
			lblUsuario.setFont(new Font("Arial", Font.BOLD, 15));
			lblUsuario.setBounds(464, 67, 121, 30);
			add(lblUsuario);
			
			lblUsuarioTexto = new JLabel("");
			lblUsuarioTexto.setFont(new Font("Arial", Font.PLAIN, 15));
			lblUsuarioTexto.setBounds(542, 67, 357, 30);
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
				JOptionPane.showMessageDialog(null, "Desconectado correctamente");				
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
