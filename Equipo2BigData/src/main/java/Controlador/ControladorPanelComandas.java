package Controlador;
import javax.swing.DefaultListModel;
import Modelo.Modelo;
import Vista.Vista;
import Vista.PanelComandas;
import principal.Inserciones;
import principal.InsercionesActividades;
import principal.Consultas;

public class ControladorPanelComandas {
	
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelComandas panelComandas;
	private double total;
	private InsercionesActividades insercionesActividades;
	private Inserciones inserciones;
	private Consultas consultas;
	
	public Modelo getModelo() {return this.modelo;}
	public Vista getVista() {return this.vista;}
	public Controlador getControlador() {return this.controlador;}
	
	public ControladorPanelComandas(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
		this.insercionesActividades = new InsercionesActividades(modelo.getConexion());
		this.inserciones = new Inserciones(modelo.getConexion());
		this.consultas = new Consultas(modelo.getConexion());}
	
	public void mostrarPanelComandas() {
		this.panelComandas = makePanelComandas(this);
		this.vista.mostrarPanel(this.panelComandas); }
	
	public void accionadoBotonVolverPanelPrincipal() {
		this.modelo.getListaTemporal().limpiarLista();
		this.modelo.getListaTemporalPlatos().limpiarLista();
		this.controlador.navegarPanelPrincipal();
		this.total = 0.0; }
	
	public PanelComandas makePanelComandas(ControladorPanelComandas controladorPanelComandas) {
		return new PanelComandas(controladorPanelComandas); }
	
	public String[] cogerListaProductos() {
		return modelo.getListaProductos().getListaProductosString(); }
	
	public int conseguirStockProductos(String nif, String producto) {
		return this.consultas.obtenerStock(nif, producto); }
	
	public String[] cogerListaPlatos() {
		return modelo.getListaPlatos().getListaPlatosString(); }
	
	public String[] accionadoBotonAnnadirProducto(String producto, String cantidad) {
		String[] devolver = this.modelo.funProd.funcionalidadAnadirProducto(producto, cantidad, this.total);
		this.total = Double.parseDouble(devolver[1]);
		return devolver; }
	
	public int existeProducto(String nombreProducto) {
		return this.modelo.getListaTemporal().devolverPosProductoString(nombreProducto); }
	
	public String[] cambiarCantidadProductos(String nombreProductoAnadido, int cantidadAnadir, String nombreProducto, String tipo) {
		String[] devolver = this.modelo.funProd.cambiarCantidadProductos(nombreProductoAnadido, cantidadAnadir, nombreProducto, this.total, tipo);
		this.total = Double.parseDouble(devolver[1]);
		return devolver; }
	
	public double cogerPrecioString(String nombreProducto) {
		return this.modelo.getListaTemporal().precioProductoString(nombreProducto); }
	
	public String accionadoBotonEliminar(int pos, String eliminar) {
		this.total = this.modelo.funProd.funcionalidadeliminarProducto(pos, eliminar, this.total);
		return String.valueOf(total); }
	
	public int existePlato(String plato) {
		return modelo.getListaTemporalPlatos().devolverPosPlatoString(plato); }
	
	public String[] accionadoBotonAnnadirPlato(String plato, String cantidad) {
		String[] devolver = this.modelo.funPlat.funcionalidadAnadirPlato(plato, cantidad, this.total);
		this.total = Double.parseDouble(devolver[1]);
		return devolver; }
	
	public String accionadoBotonEliminarPlato(int pos, String eliminar) {
		this.total = this.modelo.funPlat.funcionalidadeliminarPlato(pos, eliminar, this.total);
		return String.valueOf(total); }
	
	public void insertarProductoActividad(String nombreProducto, int transaccion, int cantidad, double preciofinal) {
		inserciones.insertarProductoActividad(transaccion, this.consultas.obtenerCodigoAlimentoProducto(nombreProducto), cantidad, preciofinal, "12345678A", modelo.validaciones.devolverFechaFormateada(modelo.getFechaHoraSys())); }
	
	public void insertarPlatoActividad(String nombrePlato, int transaccion, int cantidad) {
		inserciones.insertarPlatoActividad(transaccion, this.consultas.obtenerCodigoPlato(nombrePlato), cantidad); }
	
	public String[] conseguirDatosPanel() {
		String[] devolver = new String[3];
		devolver[0] = modelo.getUser().getNifLocal();
		devolver[1] = modelo.getFechaHoraSys();
		devolver[2] = String.valueOf(this.consultas.leerNumTransBBDD());
		return devolver; }
	
	public void insertarComanda(int transaccion, String fecha, double totalOperacion, String nif, DefaultListModel<String> listaProductos, DefaultListModel<String> listaPlatos) {
		insercionesActividades.insertarActividad(transaccion, this.modelo.validaciones.devolverFechaFormateada(fecha), totalOperacion,"COMANDA", nif);
		insercionesActividades.insertarComanda(transaccion);
		for (int i = 0; i < listaProductos.getSize(); i++) {
			String textoSpliteado[] = listaProductos.get(i).split(" ");
			String producto = this.modelo.getListaTemporal().getListaProductosString()[i];
			insertarProductoActividad(producto, transaccion, Integer.parseInt(textoSpliteado[0]),this.modelo.getListaTemporal().precioProductoString(producto));
		}
		for (int i = 0; i < listaPlatos.getSize(); i++) {
			String textoSpliteado[] = listaPlatos.get(i).split(" ");
			insertarPlatoActividad(this.modelo.getListaTemporalPlatos().getListaPlatosString()[i], transaccion, Integer.parseInt(textoSpliteado[0]));
		}
	}
}
