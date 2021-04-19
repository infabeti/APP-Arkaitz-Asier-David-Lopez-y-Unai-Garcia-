package TestControlador;

import Controlador.*;
import Modelo.Conexion;
import Modelo.ListaProductos;
import Modelo.Modelo;
import Modelo.Usuario;
import Modelo.FuncionesProductos;
import Modelo.Validaciones;
import Vista.PanelFacturas;
import Vista.Vista;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestControladorPanelFacturas {

	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private String resultadoEsperadoString, resultadoString;
	private int resultadoEsperadoInt, resultadoInt;
	private double resultadoEsperadoDouble, resultadoDouble;
	private boolean resultadoBoolean, resultadoEsperadoBoolean;
	private Usuario userMock = mock(Usuario.class);
	private Conexion conexionMock = mock(Conexion.class);
	private ListaProductos listaProductosMock = mock(ListaProductos.class);
	private String[] resultadoEsperadoArrayString, resultadoArrayString;
	private String[] listaProductos;
	private FuncionesProductos funcionesProductosMock = mock(FuncionesProductos.class);
	private Validaciones validacionesMock = mock(Validaciones.class);

	private ControladorPanelFacturas controladorPanelFacturas = new ControladorPanelFacturas(modeloMock, vistaMock,
			controladorMock);

	// Test mostrarPanelFacturas
	private PanelFacturas panelFacturasMock = mock(PanelFacturas.class);
	private ControladorPanelFacturas spyControladorPanelFacturas = spy(
			new ControladorPanelFacturas(modeloMock, vistaMock, controladorMock));

	@Test
	public void testConstructorControladorFacturas() {
		assertEquals(controladorPanelFacturas.getControlador(), controladorMock);
		assertEquals(controladorPanelFacturas.getVista(), vistaMock);
		assertEquals(controladorPanelFacturas.getModelo(), modeloMock);
	}

	@Test
	public void testDevolverFechaHora() {
		when(controladorPanelFacturas.devolverFechaHora()).thenReturn("999");

		resultadoString = controladorPanelFacturas.devolverFechaHora();
		resultadoEsperadoString = "999";

		assertEquals(resultadoEsperadoString, resultadoString);
	}

	@Test
	public void testConseguirLocal() {

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getNifLocal()).thenReturn("pepe");

		resultadoString = controladorPanelFacturas.conseguirLocal();
		resultadoEsperadoString = "pepe";

		assertEquals(resultadoEsperadoString, resultadoString);
	}

	@Test
	public void testMostrarPanelFacturas() {

		when(modeloMock.getConexion()).thenReturn(conexionMock);

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getNifLocal()).thenReturn("pepe");

		doReturn(panelFacturasMock).when(spyControladorPanelFacturas)
				.makePanelFacturas(any(ControladorPanelFacturas.class));

		spyControladorPanelFacturas.mostrarPanelFacturas();
		verify(vistaMock).mostrarPanel(panelFacturasMock);

	}

	@Test
	public void testCogerListaProductos() {
	
		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);
		
		when(listaProductosMock.getListaProductosString()).thenReturn(listaProductos);

		resultadoEsperadoArrayString = controladorPanelFacturas.cogerListaProductos();

		assertArrayEquals(resultadoEsperadoArrayString, listaProductos);
	}

	@Test
	public void testAccionadoBottonVolverPanelPrincipal() {

		controladorPanelFacturas = new ControladorPanelFacturas(modeloMock, vistaMock, controladorMock);

		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);

		controladorPanelFacturas.accionadoBottonVolverPanelPrincipal();

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
		
		resultadoArrayString = controladorPanelFacturas.accionadoBotonAnnadirProducto(producto, cantidad);

		assertArrayEquals(resultadoEsperadoArrayString, resultadoArrayString);
	}

	@Test
	public void TestExisteProducto() {

		String llamadaMetodo = "Hello";

		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);

		when(modeloMock.getListaTemporal().devolverPosProductoString(llamadaMetodo)).thenReturn(5);

		resultadoInt = controladorPanelFacturas.existeProducto(llamadaMetodo);
		resultadoEsperadoInt = 5;

		assertEquals(resultadoEsperadoInt, resultadoInt);

	}

	@Test
	public void TestCogerPrecioString() {

		String llamadaMetodo = "Hello";

		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);

		when(modeloMock.getListaTemporal().precioProductoString(llamadaMetodo)).thenReturn(35.54);

		resultadoDouble = controladorPanelFacturas.cogerPrecioString(llamadaMetodo);

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
		
		resultadoArrayString = controladorPanelFacturas.cambiarCantidadProductos(nombreProductoAnadido, cantidadAnadir, nombreProducto);

		assertArrayEquals(resultadoEsperadoArrayString, resultadoArrayString);

	}

	@Test
	public void TestAccionadoBotonEliminar() {

		int pos = 0;
		String eliminar = "1 Anfeta";

		modeloMock.funProd = funcionesProductosMock;
		
		when(funcionesProductosMock.funcionalidadeliminarProducto(pos, eliminar, pos)).thenReturn(99.0);
	
		resultadoString = controladorPanelFacturas.accionadoBotonEliminar(pos, eliminar);

		resultadoEsperadoString = "99.0";

		assertEquals(resultadoEsperadoString, resultadoString);

	}
	
	@Test
	public void TestDevolverFechaFormateada() {

		String input = "colchon";
		
		when(validacionesMock.devolverFechaFormateada(input)).thenReturn("pedro");
	
		modeloMock.validaciones = validacionesMock;

		resultadoEsperadoString = "pedro";
		
		resultadoString = controladorPanelFacturas.devolverFechaFormateada(input);

		assertEquals(resultadoEsperadoString, resultadoString);

	}
	
	@Test
	public void TestDevolverNombreProducto() {
		
		int i = 2;
		
		modeloMock.funProd = funcionesProductosMock;
		
		when(funcionesProductosMock.devolverNombreProducto(i)).thenReturn("solero");
		
		resultadoString = controladorPanelFacturas.devolverNombreProducto(i);

		resultadoEsperadoString = "solero";

		assertEquals(resultadoEsperadoString, resultadoString);

	}
	
	
	@Test
	public void TestContieneSoloLetras() {
		
		String input = "123";
		
		modeloMock.validaciones = validacionesMock;
		
		when(validacionesMock.contieneSoloLetras(input)).thenReturn(false);
		
		resultadoBoolean = controladorPanelFacturas.contieneSoloLetras(input); 

		resultadoEsperadoBoolean = false;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}

}
