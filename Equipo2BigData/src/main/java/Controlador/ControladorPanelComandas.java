package Controlador;
import javax.swing.DefaultListModel;

import Modelo.Modelo;
import Vista.PanelComandas;
import Vista.Vista;

public class ControladorPanelComandas implements ControladorInterfaz {

	
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelComandas panelComandas;
	private double total;
	
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
	
	public ControladorPanelComandas(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;}
	
	public void mostrarPanelComandas() {
		this.panelComandas = makePanelComandas(this);
		this.vista.mostrarPanel(this.panelComandas); }
	@Override
	public void accionadoBottonVolverPanelPrincipal() {
		this.modelo.getListaTemporal().limpiarLista();
		this.modelo.getListaTemporalPlatos().limpiarLista();
		this.controlador.navegarPanelPrincipal();
		this.total = 0.0; }
	
	public PanelComandas makePanelComandas(ControladorPanelComandas controladorPanelComandas) {
		return new PanelComandas(controladorPanelComandas); }
	
	public String[] cogerListaProductos() {
		try {
			return modelo.getListaProductos().convertirListaAString();
		}
		catch(Exception e) {
			String[] listaError = {"Se ha producido un error", "Compruebe que la base de datos esta conectada"};
			return listaError;
		}
	}
	
	public int conseguirStockProductos(String nif, String producto) {
		return modelo.consultasSimples.obtenerStock(nif, producto); }
	
	public String[] cogerListaPlatos() {
		try {
			return modelo.getListaPlatos().convertirListaAString();
		}
		catch(Exception e) {
			String[] listaError = {"Se ha producido un error", "Compruebe que la base de datos esta conectada"};
			return listaError;
		}
	}
	
	public String[] accionadoBotonAnnadirProducto(String producto, String cantidad) {
		String[] devolver = this.modelo.funProd.funcionalidadAnadirProducto(producto, cantidad, this.total);
		this.total = Double.parseDouble(devolver[1]);
		return devolver; }
	
	public int existeProducto(String nombreProducto) {
		return this.modelo.getListaTemporal().devolverPosElementoString(nombreProducto); }
	
	public String[] cambiarCantidadProductos(String nombreProductoAnadido, int cantidadAnadir, String nombreProducto, String tipo) {
		String[] devolver = this.modelo.funProd.cambiarCantidadProductos(nombreProductoAnadido, cantidadAnadir, nombreProducto, this.total, tipo);
		this.total = Double.parseDouble(devolver[1]);
		return devolver; }
	
	public double cogerPrecioString(String nombreProducto) {
		return this.modelo.getListaTemporal().precioElementoString(nombreProducto); }
	
	public String accionadoBotonEliminar(int pos, String eliminar) {
		this.total = this.modelo.funProd.funcionalidadeliminarProducto(pos, eliminar, this.total);
		return String.valueOf(total); }
	
	public int existePlato(String plato) {
		return modelo.getListaTemporalPlatos().devolverPosElementoString(plato); }
	
	public String[] accionadoBotonAnnadirPlato(String plato, String cantidad) {
		String[] devolver = this.modelo.funPlat.funcionalidadAnadirPlato(plato, cantidad, this.total);
		this.total = Double.parseDouble(devolver[1]);
		return devolver; }
	
	public String accionadoBotonEliminarPlato(int pos, String eliminar) {
		this.total = this.modelo.funPlat.funcionalidadeliminarPlato(pos, eliminar, this.total);
		return String.valueOf(total); }
	
	public void insertarProductoActividad(String nombreProducto, int transaccion, int cantidad, double preciofinal, String nif) {
		this.modelo.insercionesSimples.insertarProductoActividad(transaccion, modelo.consultasSimples.obtenerCodigoAlimentoProducto(nombreProducto), cantidad, preciofinal, nif, modelo.validaciones.devolverFechaFormateada(modelo.utiles.getFechaHoraSys())); }
	
	public void insertarPlatoActividad(String nombrePlato, int transaccion, int cantidad) {
		this.modelo.insercionesSimples.insertarPlatoActividad(transaccion, this.modelo.consultasSimples.obtenerCodigoPlato(nombrePlato), cantidad); }
	
	public String[] conseguirDatosPanel() {
		String[] devolver = new String[2];
		devolver[0] = modelo.getUser().getNifLocal();
		devolver[1] = modelo.utiles.getFechaHoraSys();
		return devolver; }
	
	public void insertarComanda(int transaccion, String fecha, String nif, DefaultListModel<String> listaProductos, DefaultListModel<String> listaPlatos) {
		this.modelo.insercionesActividades.insertarActividad(transaccion, this.modelo.validaciones.devolverFechaFormateada(fecha),"COMANDA", nif);
		this.modelo.insercionesActividades.insertarComanda(transaccion);
		for (int i = 0; i < listaProductos.getSize(); i++) {
			String textoSpliteado[] = listaProductos.get(i).split(" ");
			String producto = this.modelo.getListaTemporal().convertirListaAString()[i];
			insertarProductoActividad(producto, transaccion, Integer.parseInt(textoSpliteado[0]),this.modelo.getListaTemporal().precioElementoString(producto), nif);
		}
		for (int i = 0; i < listaPlatos.getSize(); i++) {
			String textoSpliteado[] = listaPlatos.get(i).split(" ");
			insertarPlatoActividad(this.modelo.getListaTemporalPlatos().convertirListaAString()[i], transaccion, Integer.parseInt(textoSpliteado[0]));
		}
		this.modelo.insercionesActividades.ejecutarProcedimientoCalcularPrecios(transaccion);
	}
	
	public int conseguirNumTrans() {
		return this.modelo.consultasSimples.leerNumTransBBDD();
	}
}
