package TestControlador;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import Controlador.Controlador;
import Controlador.ControladorPanelTickets;
import Modelo.Conexion;
import Modelo.ListaProductos;
import Modelo.Modelo;
import Modelo.Usuario;
import Modelo.FuncionesProductos;
import Modelo.Validaciones;
import Vista.PanelTickets;
import Vista.Vista;

public class TestControladorPanelTickets {

	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private String resultadoEsperadoString, resultadoString;
	private int resultadoEsperadoInt, resultadoInt;
	private double resultadoEsperadoDouble, resultadoDouble;
	private Usuario userMock = mock(Usuario.class);
	private Conexion conexionMock = mock(Conexion.class);
	private ListaProductos listaProductosMock = mock(ListaProductos.class);
	private String[] resultadoEsperadoArrayString, resultadoArrayString;
	private String[] listaProductos;
	private FuncionesProductos funcionesProductosMock = mock(FuncionesProductos.class);
	private Validaciones validacionesMock = mock(Validaciones.class);

	private ControladorPanelTickets controladorPanelTickets = new ControladorPanelTickets(modeloMock, vistaMock,
			controladorMock);

	// Test mostrarPanelFacturas
	private PanelTickets panelTicketsMock = mock(PanelTickets.class);
	private ControladorPanelTickets spyControladorPanelTickets = spy(
			new ControladorPanelTickets(modeloMock, vistaMock, controladorMock));

	@Test
	public void testConstructorControladorFacturas() {
		assertEquals(controladorPanelTickets.getControlador(), controladorMock);
		assertEquals(controladorPanelTickets.getVista(), vistaMock);
		assertEquals(controladorPanelTickets.getModelo(), modeloMock);
	}

	@Test
	public void testDevolverFechaHora() {
		when(controladorPanelTickets.devolverFechaHora()).thenReturn("999");

		resultadoString = controladorPanelTickets.devolverFechaHora();
		resultadoEsperadoString = "999";

		assertEquals(resultadoEsperadoString, resultadoString);
	}

	@Test
	public void testConseguirLocal() {

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getNifLocal()).thenReturn("pepe");

		resultadoString = controladorPanelTickets.conseguirLocal();
		resultadoEsperadoString = "pepe";

		assertEquals(resultadoEsperadoString, resultadoString);
	}

	@Test
	public void testMostrarPanelFacturas() {

		when(modeloMock.getConexion()).thenReturn(conexionMock);

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getNifLocal()).thenReturn("pepe");

		doReturn(panelTicketsMock).when(spyControladorPanelTickets)
				.makePanelTickets(any(ControladorPanelTickets.class));

		spyControladorPanelTickets.mostrarPanelTickets();
		verify(vistaMock).mostrarPanel(panelTicketsMock);

	}

	@Test
	public void testCogerListaProductos() {
when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);
		
		when(listaProductosMock.getListaProductosString()).thenReturn(listaProductos);

		resultadoEsperadoArrayString = controladorPanelTickets.cogerListaProductos();

		assertArrayEquals(resultadoEsperadoArrayString, listaProductos);
	}

	@Test
	public void testAccionadoBottonVolverPanelPrincipal() {

		controladorPanelTickets = new ControladorPanelTickets(modeloMock, vistaMock, controladorMock);

		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);

		controladorPanelTickets.accionadoBottonVolverPanelPrincipal();

		verify(controladorMock, times(1)).navegarPanelPrincipal();

	}

	@Test
	public void TestAccionadoBotonAnnadirProducto() {
		
		modeloMock.funProd = funcionesProductosMock;
		
		String producto = "Patata";
		String cantidad = "2";
		Double total = 0.0;
		
		String[] resultadoEsperadoArrayString = new String[] {"2 Patata","19.9"}; 
		
		when(funcionesProductosMock.funcionalidadAnadirProducto(producto, cantidad, total)).thenReturn(resultadoEsperadoArrayString);
		
		resultadoArrayString = controladorPanelTickets.accionadoBotonAnnadirProducto(producto, cantidad);

		assertArrayEquals(resultadoEsperadoArrayString, resultadoArrayString);
	}

	@Test
	public void TestExisteProducto() {

		String llamadaMetodo = "Hello";

		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);

		when(modeloMock.getListaTemporal().devolverPosProductoString(llamadaMetodo)).thenReturn(5);

		resultadoInt = controladorPanelTickets.existeProducto(llamadaMetodo);
		resultadoEsperadoInt = 5;

		assertEquals(resultadoEsperadoInt, resultadoInt);

	}

	@Test
	public void TestCogerPrecioString() {

		String llamadaMetodo = "Hello";

		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);

		when(modeloMock.getListaTemporal().precioProductoString(llamadaMetodo)).thenReturn(35.54);

		resultadoDouble = controladorPanelTickets.cogerPrecioString(llamadaMetodo);

		resultadoEsperadoDouble = 35.54;

		assertEquals(resultadoEsperadoDouble, resultadoDouble, 0);

	}

	@Test
	public void TestCambiarCantidadProductos() {

		modeloMock.funProd = funcionesProductosMock;
		
		String nombreProductoAnadido = "Patata";
		int cantidadAnadir = 2;
		Double total = 0.0;
		String nombreProducto = "3 x Patata";
		
		String[] resultadoEsperadoArrayString = new String[] {"2 Patata","19.9"}; 
		
		when(funcionesProductosMock.cambiarCantidadProductos(nombreProductoAnadido, cantidadAnadir, nombreProducto, total, "producto")).thenReturn(resultadoEsperadoArrayString);
		
		resultadoArrayString = controladorPanelTickets.cambiarCantidadProductos(nombreProductoAnadido, cantidadAnadir, nombreProducto);

		assertArrayEquals(resultadoEsperadoArrayString, resultadoArrayString);

	}
	
	@Test
	public void TestAccionadoBotonEliminar() {

		int pos = 0;
		String eliminar = "1 Anfeta";

		modeloMock.funProd = funcionesProductosMock;

		when(funcionesProductosMock.funcionalidadeliminarProducto(pos, eliminar, pos)).thenReturn(99.0);

		resultadoString = controladorPanelTickets.accionadoBotonEliminar(pos, eliminar);

		resultadoEsperadoString = "99.0";

		assertEquals(resultadoEsperadoString, resultadoString);

	}

	@Test
	public void TestDevolverFechaFormateada() {

		String input = "colchon";

		modeloMock.validaciones = validacionesMock;

		when(validacionesMock.devolverFechaFormateada(input)).thenReturn("pedro");

		resultadoString = controladorPanelTickets.devolverFechaFormateada(input);

		resultadoEsperadoString = "pedro";

		assertEquals(resultadoEsperadoString, resultadoString);

	}

	@Test
	public void TestDevolverNombreProducto() {

		int i = 2;

		modeloMock.funProd = funcionesProductosMock;

		when(funcionesProductosMock.devolverNombreProducto(i)).thenReturn("solero");

		resultadoString = controladorPanelTickets.devolverNombreProducto(i);

		resultadoEsperadoString = "solero";

		assertEquals(resultadoEsperadoString, resultadoString);

	}

}
