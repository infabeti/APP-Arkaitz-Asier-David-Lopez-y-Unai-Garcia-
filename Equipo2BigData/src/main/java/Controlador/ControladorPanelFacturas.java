package Controlador;

import Modelo.Modelo;
import javax.swing.DefaultListModel;
import Vista.PanelFacturas;
import Vista.Vista;
import principal.Inserciones;
import principal.InsercionesActividades;
import principal.Consultas;
import principal.ConsultasComprobaciones;

public class ControladorPanelFacturas implements ControladorInterfaz {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelFacturas panelFacturas;
	private double total;
	private InsercionesActividades insercionesActividades;
	private Inserciones inserciones;
	private Consultas consultas;
	private ConsultasComprobaciones consultasComprobaciones;

	public ControladorPanelFacturas(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
		this.inserciones = new Inserciones(modelo.getConexion());
		this.insercionesActividades = new InsercionesActividades(modelo.getConexion());
		this.consultas = new Consultas(modelo.getConexion());
		this.consultasComprobaciones = new ConsultasComprobaciones(modelo.getConexion());
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

	public String devolverFechaHora() {
		return this.modelo.getFechaHoraSys();
	}
	
	public int conseguirStock(String nif, String producto) {
		return this.consultas.obtenerStock(nif, producto);
	}

	public String conseguirLocal() {
		return this.modelo.getUser().getNifLocal();
	}

	public String leerNumTransBBDD() {
		return String.valueOf(this.consultas.leerNumTransBBDD());
	}

	public void mostrarPanelFacturas() {
		this.panelFacturas = makePanelFacturas(this);
		this.vista.mostrarPanel(this.panelFacturas);
	}

	public String[] cogerListaProductos() {
		return this.modelo.getListaProductos().getListaProductosString();
	}
	@Override
	public void accionadoBottonVolverPanelPrincipal() {
		this.controlador.navegarPanelPrincipal();
		this.modelo.getListaTemporal().limpiarLista();
		this.total = 0.0;
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

	public int existeProducto(String nombreProducto) {
		return this.modelo.getListaTemporal().devolverPosProductoString(nombreProducto);
	}

	public double cogerPrecioString(String nombreProducto) {
		return this.modelo.getListaTemporal().precioProductoString(nombreProducto);
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

	public boolean contieneSoloLetras(String cadena) {
		return this.modelo.validaciones.contieneSoloLetras(cadena);
	}

	public void insertarProductoActividad(int nombreProducto, int transaccion, int cantidad) {
		String producto = devolverNombreProducto(nombreProducto);
		inserciones.insertarProductoActividad(transaccion,
				this.consultas.obtenerCodigoAlimentoProducto(producto), cantidad, cogerPrecioString(producto), "12345678A", modelo.validaciones.devolverFechaFormateada(modelo.getFechaHoraSys()));
	}

	public boolean comprobarCampos(double total, String nif, String nombre, String apellido) {
		return total > 0 && this.modelo.validaciones.comprobarCamposString(nif, nombre, apellido);
	}

	public void insertarFactura(int transaccion, String fecha, double totalOperacion, String nifLocal, String nombre,
			String apellido, DefaultListModel<String> lista, String nifComprador) {
		insercionesActividades.insertarActividad(transaccion, devolverFechaFormateada(fecha), totalOperacion, "FACTURA",
				nifLocal);
		if (this.consultasComprobaciones.comprobarSiExisteComprador(nifComprador)) {
			System.out.println("El comprador ya existe, no se hace la insert en la tabla comprador");
		} else {
			inserciones.insertarComprador(nifComprador, nombre, apellido);
		}
		insercionesActividades.insertarFactura(transaccion, nifComprador);
		for (int i = 0; i < lista.getSize(); i++) {
			String textoSpliteado[] = lista.get(i).split(" ");
			insertarProductoActividad(i, transaccion, Integer.parseInt(textoSpliteado[0]));
		}
	}

	public PanelFacturas makePanelFacturas(ControladorPanelFacturas controladorPanelFacturas) {
		return new PanelFacturas(controladorPanelFacturas);
	}
}