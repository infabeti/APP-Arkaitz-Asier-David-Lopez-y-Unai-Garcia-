package Controlador;

import Modelo.Modelo;
import Modelo.Usuario;
import Vista.Vista;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private ControladorPanelPrincipal controladorPanelPrincipal;
	private ControladorPanelAnalisis controladorPanelAnalisis;
	private ControladorPanelPedidos controladorPanelPedidos;
	private ControladorPanelAprovisionamiento controladorPanelAprovisionamiento;
	private ControladorPanelFacturas controladorPanelFacturas;
	private ControladorPanelTickets controladorPanelTickets;
	private ControladorPanelRegistro controladorPanelRegistro;
	private ControladorPanelComandas controladorPanelComandas;
	private ControladorInicio controladorInicio;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorInicio = new ControladorInicio(this.modelo, this.vista, this);
		this.controladorPanelPrincipal = new ControladorPanelPrincipal(this.modelo, this.vista, this);
		this.controladorPanelAnalisis = new ControladorPanelAnalisis(this.modelo, this.vista, this);
		this.controladorPanelPedidos = new ControladorPanelPedidos(this.modelo, this.vista, this);
		this.controladorPanelAprovisionamiento = new ControladorPanelAprovisionamiento(this.modelo, this.vista, this);
		this.controladorPanelFacturas = new ControladorPanelFacturas(this.modelo, this.vista, this);
		this.controladorPanelTickets = new ControladorPanelTickets(this.modelo, this.vista, this);
		this.controladorPanelRegistro = new ControladorPanelRegistro(this.modelo, this.vista, this);
		this.controladorPanelComandas = new ControladorPanelComandas(this.modelo, this.vista, this);
		this.navegarPanelInicio();
	}

	public void navegarPanelInicio() {
		System.out.println("Inicio");
		controladorInicioMostrarPanelInicio();
	}

	public void controladorInicioMostrarPanelInicio() {
		this.controladorInicio.mostrarPanelInicio();
	}

	public void navegarPanelRegistro() {
		System.out.println("Navegar panel de registro");
		controladorPanelRegistroMostrarPanelegistro();
	}

	public void controladorPanelRegistroMostrarPanelegistro() {
		this.controladorPanelRegistro.mostrarPanelRegistro();
	}

	public void navegarPanelPrincipal() {
		System.out.println("Navegar panel principal");
		controladorPanelPrincipalMostrarPanelPrincipal();
	}

	public void controladorPanelPrincipalMostrarPanelPrincipal() {
		this.controladorPanelPrincipal.mostrarPanelPrincipal();
	}

	public void navegarPanelAnalisis() {
		System.out.println("Navegar panel Analisis");
		controladorPanelAnalisisMostrarPanelAnalisis();
	}

	public void controladorPanelAnalisisMostrarPanelAnalisis() {
		this.controladorPanelAnalisis.mostrarPanelAnalisis();
	}

	public void navegarPanelPedidos() {
		System.out.println("Navegar panel Pedidos");
		Usuario user = this.modelo.getUser();
		if (user.getTipoLocal().equalsIgnoreCase("RESTAURANTE") || user.getTipoLocal().equalsIgnoreCase("CAFETERIA")) {
			controladorPanelPedidosMostrarPanelPedidos();
		}
	}

	public void controladorPanelPedidosMostrarPanelPedidos() {
		this.controladorPanelPedidos.mostrarPanelPedidos();
	}

	public void navegarPanelAprovisionamiento() {
		System.out.println("Navegar panel Aprovisionamiento");
		controladorPanelAprovisionamientoMostrarPanelAprovisionamiento();
	}

	public void controladorPanelAprovisionamientoMostrarPanelAprovisionamiento() {
		this.controladorPanelAprovisionamiento.mostrarPanelAprovisionamiento();
	}

	public void navegarPanelFacturas() {
		System.out.println("Navegar panel Facturas");
		controladorPanelFacturasMostrarPanelFacturas();
	}

	public void controladorPanelFacturasMostrarPanelFacturas() {
		this.controladorPanelFacturas.mostrarPanelFacturas();
	}

	public void navegarPanelTickets() {
		System.out.println("Navegar panel Tickets");
		controladorPanelTicketsMostrarPanelTickets();
	}

	public void controladorPanelTicketsMostrarPanelTickets() {
		this.controladorPanelTickets.mostrarPanelTickets();
	}

	public void navegarPanelComandas() {
		System.out.println("Navegar panel Comandas");
		Usuario user = modelo.getUser();
		if (user.getTipoLocal().equalsIgnoreCase("RESTAURANTE")) {
			controladorPanelComandasMostrarPanelComandas();
		}
	}

	public void controladorPanelComandasMostrarPanelComandas() {
		this.controladorPanelComandas.mostrarPanelComandas();
	}

	public ControladorPanelAprovisionamiento makeControladorPanelAprovisionamiento(Modelo modelo, Vista vista,
			Controlador controlador) {
		return new ControladorPanelAprovisionamiento(this.modelo, this.vista, this);
	}

	public ControladorPanelPedidos makeControladorPanelPedidos(Modelo modelo, Vista vista, Controlador controlador) {
		return new ControladorPanelPedidos(this.modelo, this.vista, this);
	}

	public ControladorPanelTickets makeControladorPanelTickets(Modelo modelo, Vista vista, Controlador controlador) {
		return new ControladorPanelTickets(this.modelo, this.vista, this);
	}

	public ControladorPanelFacturas makeControladorPanelFacturas(Modelo modelo, Vista vista, Controlador controlador) {
		return new ControladorPanelFacturas(this.modelo, this.vista, this);
	}

	public ControladorPanelRegistro makeControladorPanelRegistro(Modelo modelo, Vista vista, Controlador controlador) {
		return new ControladorPanelRegistro(this.modelo, this.vista, this);
	}

	public ControladorPanelPrincipal makeControladorPanelPrincipal(Modelo modelo, Vista vista,
			Controlador controlador) {
		return new ControladorPanelPrincipal(this.modelo, this.vista, this);
	}

	public ControladorInicio makeControladorPanelInicio(Modelo modelo, Vista vista, Controlador controlador) {
		return new ControladorInicio(this.modelo, this.vista, this);
	}

	public ControladorPanelComandas makecontroladorPanelComandas(Modelo modelo, Vista vista, Controlador controlador) {
		return new ControladorPanelComandas(this.modelo, this.vista, this);
	}

}
