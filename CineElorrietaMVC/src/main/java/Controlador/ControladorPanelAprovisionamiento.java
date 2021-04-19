package Controlador;

import Modelo.Modelo;
import Modelo.ListaProductos;
import Vista.PanelAprovisionamiento;
import Vista.Vista;

public class ControladorPanelAprovisionamiento {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelAprovisionamiento panelAprovisionamiento;
	private ListaProductos listaP;

	public ControladorPanelAprovisionamiento(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
	}

	public Modelo getModelo() {
		return this.modelo;
	}

	public Vista getVista() {
		return this.vista;
	}

	public Controlador getControlador() {
		return this.controlador;
	}

	public void mostrarPanelAprovisionamiento() {
		this.panelAprovisionamiento = makePanelAprovisionamiento(this);
		this.vista.mostrarPanel(this.panelAprovisionamiento);
	}

	public void accionadoBottonVolverPanelPrincipal() {
		this.controlador.navegarPanelPrincipal();
	}

	public String leerNumTransBBDD() {
		return String.valueOf(this.modelo.getConsultas().leerNumTransBBDD());
	}

	public String conseguirLocal() {

		return this.modelo.getUser().getNifLocal();
	}

	public String devolverFechaHora() {
		return this.modelo.getFechaHoraSys();
	}

	public PanelAprovisionamiento makePanelAprovisionamiento(
			ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		return new PanelAprovisionamiento(controladorPanelAprovisionamiento);
	}
	
	public String devolverFechaFormateada(String input) {
		return this.modelo.validaciones.devolverFechaFormateada(input);
	}

	public String[] pasarListaProductos() {
		listaP = this.modelo.getConsultasListas().cogerProductosAprovisionamiento();
		return listaP.getListaProductosString();
	}

	public void accionadoBotonAnnadir(int cantidad, int indice, String nombre) {
		double precioTotal = this.modelo.getConsultasComprobaciones().consultaComprobarPrecio(nombre) * cantidad;
		this.modelo.insercionesActividades.insertarActividad(modelo.getConsultas().leerNumTransBBDD(), devolverFechaFormateada(modelo.getFechaHoraSys()), precioTotal, "aprovisionamiento", modelo.getUser().getNifLocal());
		this.modelo.insercionesActividades.insertarAprovisionamiento(modelo.getConsultas().leerNumTransBBDD()-1);
		this.modelo.getInserciones().insertarProductoActividad(modelo.getConsultas().leerNumTransBBDD()-1, modelo.getConsultas().obtenerCodigoAlimentoProducto(nombre), cantidad, precioTotal);
	}
}