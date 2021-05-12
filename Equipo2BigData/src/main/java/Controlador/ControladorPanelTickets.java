package Controlador;

import javax.swing.DefaultListModel;

import Modelo.Modelo;
import Vista.PanelTickets;
import Vista.Vista;

public class ControladorPanelTickets implements ControladorInterfaz{

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelTickets panelTickets;
	private double total;

	public ControladorPanelTickets(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
	}
	
	@Override
	public Modelo getModelo() {
		return modelo;
	}
	@Override
	public Vista getVista() {
		return vista;
	}
	@Override
	public Controlador getControlador() {
		return controlador;
	}

	public void mostrarPanelTickets() {
		this.panelTickets = makePanelTickets(this);
		this.vista.mostrarPanel(this.panelTickets);
	}
	
	public int conseguirStock(String nif, String producto) {
		return modelo.consultasSimples.obtenerStock(nif, producto);
	}
	

	public void insertarTicket(int transaccion, String fecha, String nif,
			DefaultListModel<String> lista) {
		this.modelo.insercionesActividades.insertarActividad(transaccion, devolverFechaFormateada(fecha), "TICKET", nif);
		for (int i = 0; i < lista.getSize(); i++) {
			String textoSpliteado[] = lista.get(i).split(" ");
			insertarProductoActividad(i, transaccion, Integer.parseInt(textoSpliteado[0]), nif);
		}
		this.modelo.insercionesActividades.ejecutarProcedimientoCalcularPrecios(transaccion);
	}

	public void insertarProductoActividad(int nombreProducto, int transaccion, int cantidad, String nif) {
		String producto = devolverNombreProducto(nombreProducto);
		this.modelo.insercionesSimples.insertarProductoActividad(transaccion,
				modelo.consultasSimples.obtenerCodigoAlimentoProducto(producto), cantidad,
				cogerPrecioString(producto), nif, modelo.validaciones.fechaFormateada());
	}

	public String conseguirLocal() {
		return modelo.getUser().getNifLocal();
	}

	public String devolverFechaHora() {
		return modelo.utiles.getFechaHoraSys();
	}
	@Override
	public void accionadoBottonVolverPanelPrincipal() {
		this.controlador.navegarPanelPrincipal();
		modelo.getListaTemporal().limpiarLista();
		this.total = 0.0;
	}

	public String[] cogerListaProductos() {
		try{
			return this.modelo.getListaProductos().convertirListaAString();
		}
		catch(Exception e) {
			String[] listaError = {"Se ha producido un error", "Compruebe que la base de datos esta conectada"};
			return listaError;
		}
	}

	public int existeProducto(String nombreProducto) {
		return modelo.getListaTemporal().devolverPosElementoString(nombreProducto);
	}

	public double cogerPrecioString(String nombreProducto) {
		return modelo.getListaTemporal().precioElementoString(nombreProducto);
	}

	public String[] accionadoBotonAnnadirProducto(String producto, String cantidad) {
		String[] devolver = this.modelo.funProd.funcionalidadAnadirProducto(producto, cantidad, this.total);
		this.total = Double.parseDouble(devolver[1]);
		return devolver;
	}

	public String[] cambiarCantidadProductos(String nombreProductoAnadido, int cantidadAnadir, String nombreProducto) {
		String[] devolver = this.modelo.funProd.cambiarCantidadProductos(nombreProductoAnadido, cantidadAnadir, nombreProducto, this.total, "producto");
		this.total = Double.parseDouble(devolver[1]);
		return devolver;
	}

	public String accionadoBotonEliminar(int pos, String eliminar) {
		this.total = this.modelo.funProd.funcionalidadeliminarProducto(pos, eliminar, this.total);
		return String.valueOf(this.total);
	}

	public String devolverFechaFormateada(String input) {
		return this.modelo.validaciones.devolverFechaFormateada(input);
	}

	public String devolverNombreProducto(int i) {
		return this.modelo.funProd.devolverNombreProducto(i);
	}

	public PanelTickets makePanelTickets(ControladorPanelTickets controladorPanelTickets) {
		return new PanelTickets(controladorPanelTickets);
	}
	
	public int conseguirNumTrans() {
		return this.modelo.consultasSimples.leerNumTransBBDD();
	}
}