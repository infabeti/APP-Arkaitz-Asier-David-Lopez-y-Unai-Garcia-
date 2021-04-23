package Controlador;

import Modelo.Modelo;
import Modelo.ListaProductos;
import Vista.PanelAprovisionamiento;
import Vista.Vista;
import principal.InsercionesActividades;
import principal.Inserciones;
import principal.Consultas;
import principal.ConsultasListas;
import principal.ConsultasComprobaciones;

public class ControladorPanelAprovisionamiento  implements ControladorInterfaz {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelAprovisionamiento panelAprovisionamiento;
	private ListaProductos listaP;
	private Consultas consultas;
	private ConsultasListas consultasListas;
	private ConsultasComprobaciones consultasComprobaciones;

	public ControladorPanelAprovisionamiento(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
	}
	@Override
	public Modelo getModelo() {
		return this.modelo;
	}
	@Override
	public Vista getVista() {
		return this.vista;
	}
	@Override
	public Controlador getControlador() {
		return this.controlador;
	}
	
	public void mostrarPanelAprovisionamiento() {
		this.panelAprovisionamiento = makePanelAprovisionamiento(this);
		this.vista.mostrarPanel(this.panelAprovisionamiento);
	}
	@Override
	public void accionadoBottonVolverPanelPrincipal() {
		this.controlador.navegarPanelPrincipal();
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

	public String[] pasarListaProductos() {
		consultasListas = new ConsultasListas(modelo.getConexion());
		listaP = modelo.conversor.listaStringAProductos(consultasListas.cogerProductosAprovisionamiento());
		return listaP.getListaProductosString();
	}

	public void accionadoBotonAnnadir(int cantidad, int indice, String nombre, int numTrans, String nifLocal) {
		InsercionesActividades insercionesActividades = new InsercionesActividades(modelo.getConexion());
		double precioTotal = consultasComprobaciones.consultaComprobarPrecio(nombre) * cantidad;
		insercionesActividades.insertarActividad(consultas.leerNumTransBBDD(), modelo.validaciones.fechaFormateada(), precioTotal, "aprovisionamiento", modelo.getUser().getNifLocal());
		insercionesActividades.insertarAprovisionamiento(consultas.leerNumTransBBDD()-1);
		Inserciones inserciones = new Inserciones(modelo.getConexion());
		inserciones.insertarProductoActividad(numTrans, consultas.obtenerCodigoAlimentoProducto(nombre), cantidad, precioTotal, nifLocal, modelo.validaciones.fechaFormateada() );
	}
}