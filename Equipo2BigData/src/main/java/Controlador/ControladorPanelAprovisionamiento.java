package Controlador;

import java.util.ArrayList;

import Modelo.ListaProductos;
import Modelo.Modelo;
import Vista.PanelAprovisionamiento;
import Vista.Vista;

public class ControladorPanelAprovisionamiento  implements ControladorInterfaz {

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
		return this.modelo.utiles.getFechaHoraSys();
	}

	public PanelAprovisionamiento makePanelAprovisionamiento(
			ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		return new PanelAprovisionamiento(controladorPanelAprovisionamiento);
	}

	public String[] pasarListaProductos() {
		ArrayList<String[]> listaArray = this.modelo.consultasListas.cogerProductosAprovisionamiento();
		if(listaArray == null) {
			String [] listaDevolver = {"Se ha producido un error", "Compruebe que la base de datos", "Esta conectada"};
			return listaDevolver;
		}
		else {
			listaP = modelo.conversor.listaStringAAlimentos(listaArray);
			return listaP.convertirListaAString();
		}
	}

	public void accionadoBotonAnnadir(int cantidad, int indice, String nombre, int numTrans, String nif) {
		double precioTotal = modelo.consultasComprobaciones.consultaComprobarPrecio(nombre) * cantidad;
		this.modelo.insercionesActividades.insertarActividad(numTrans, modelo.validaciones.fechaFormateada(), "aprovisionamiento", nif);
		this.modelo.insercionesActividades.insertarAprovisionamiento(numTrans);
		this.modelo.insercionesSimples.insertarProductoActividad(numTrans, modelo.consultasSimples.obtenerCodigoAlimentoProducto(nombre), cantidad, precioTotal, nif, modelo.validaciones.fechaFormateada() );
		this.modelo.insercionesActividades.ejecutarProcedimientoCalcularPrecios(numTrans);
	}
	
	public String conseguirNumTrans() {
		int numero = this.modelo.consultasSimples.leerNumTransBBDD();
		String devolver = "";
		if(numero == 0) {
			devolver = "Error en BBDD";
		}
		else {
			devolver = Integer.toString(numero);
		}
		return devolver;
	}
}