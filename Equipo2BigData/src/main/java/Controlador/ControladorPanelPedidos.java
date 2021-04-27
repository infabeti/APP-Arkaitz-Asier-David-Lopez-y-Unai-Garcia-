package Controlador;

import Modelo.Modelo;
import javax.swing.DefaultListModel;
import Vista.PanelPedidos;
import Vista.Vista;
import principal.Consultas;
import principal.Inserciones;
import principal.InsercionesActividades;

public class ControladorPanelPedidos  implements ControladorInterfaz {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelPedidos panelPedidos;
	private double total;
	private Inserciones inserciones;
	private InsercionesActividades insercionesActividades;
	private Consultas consultas;

	public ControladorPanelPedidos(Modelo modelo, Vista vista, Controlador controlador) {
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

	public int conseguirStock(String nif, String producto) {
		consultas = new Consultas(modelo.getConexion());
		return this.consultas.obtenerStock(nif, producto);
	}
	
	public String conseguirLocal() {
		return this.modelo.getUser().getNifLocal();
	}

	public void mostrarPanelPedidos() {
		this.panelPedidos = makePanelPedidos(this);
		this.vista.mostrarPanel(this.panelPedidos);
	}
	@Override
	public void accionadoBottonVolverPanelPrincipal() {
		this.controlador.navegarPanelPrincipal();
		this.modelo.getListaTemporal().limpiarLista();
		this.total = 0.0;
	}

	public String[] cogerListaProductos() {
		return this.modelo.getListaProductos().getListaProductosString();
	}

	public String devolverFechaHora() {
		return this.modelo.utiles.getFechaHoraSys();
	}

	public int existeProducto(String nombreProducto) {
		return this.modelo.getListaTemporal().devolverPosProductoString(nombreProducto);
	}

	public double cogerPrecioString(String nombreProducto) {
		return this.modelo.getListaTemporal().precioProductoString(nombreProducto);
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

	public void insertarProductoActividad(int nombreProducto, int transaccion, int cantidad, String nif) {
		String producto = devolverNombreProducto(nombreProducto);
		inserciones = new Inserciones(modelo.getConexion());
		inserciones.insertarProductoActividad(transaccion, this.consultas.obtenerCodigoAlimentoProducto(producto), cantidad, cogerPrecioString(producto), nif, modelo.validaciones.fechaFormateada());
	}

	public void insertarActividad(int transaccion, String fecha, String nif, String domicilio, DefaultListModel<String> lista) {
		insercionesActividades = new InsercionesActividades(modelo.getConexion());
		insercionesActividades.insertarActividad(transaccion, devolverFechaFormateada(fecha), "PEDIDO", nif);
		insercionesActividades.insertarPedido(transaccion, domicilio);
		for (int i = 0; i < lista.getSize(); i++) {
			String textoSpliteado[] = lista.get(i).split(" ");
			insertarProductoActividad(i, transaccion, Integer.parseInt(textoSpliteado[0]), nif);
		}
		insercionesActividades.ejecutarFuncion(transaccion);
	}

	public PanelPedidos makePanelPedidos(ControladorPanelPedidos controladorPanelPedidos) {
		return new PanelPedidos(controladorPanelPedidos);
	}
}