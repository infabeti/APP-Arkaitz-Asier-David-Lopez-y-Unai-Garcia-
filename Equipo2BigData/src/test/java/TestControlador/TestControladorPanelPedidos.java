package TestControlador;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;


import org.junit.Test;


import Controlador.Controlador;

import Controlador.ControladorPanelPedidos;


import Modelo.Conexion;

import Modelo.ListaProductos;
import Modelo.Modelo;
import Modelo.Usuario;
import Modelo.FuncionesProductos;
import Modelo.Validaciones;
import Vista.PanelPedidos;
import Vista.Vista;

public class TestControladorPanelPedidos {

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

	private ControladorPanelPedidos controladorPanelPedidos = new ControladorPanelPedidos(modeloMock, vistaMock,
			controladorMock);

	// Test mostrarPanelPedidos
	private PanelPedidos panelPedidosMock = mock(PanelPedidos.class);
	private ControladorPanelPedidos spyControladorPanelPedidos = spy(
			new ControladorPanelPedidos(modeloMock, vistaMock, controladorMock));

	@Test
	public void testConstructorControladorPedidos() {
		assertEquals(controladorPanelPedidos.getControlador(), controladorMock);
		assertEquals(controladorPanelPedidos.getVista(), vistaMock);
		assertEquals(controladorPanelPedidos.getModelo(), modeloMock);
	}

	@Test
	public void testDevolverFechaHora() {

		when(modeloMock.getFechaHoraSys()).thenReturn("999");

		resultadoString = controladorPanelPedidos.devolverFechaHora();
		resultadoEsperadoString = "999";

		assertEquals(resultadoEsperadoString, resultadoString);
	}

	@Test
	public void testConseguirLocal() {

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getNifLocal()).thenReturn("pepe");

		resultadoString = controladorPanelPedidos.conseguirLocal();
		resultadoEsperadoString = "pepe";

		assertEquals(resultadoEsperadoString, resultadoString);
	}

	@Test
	public void testMostrarPanelPedidos() {

		when(modeloMock.getConexion()).thenReturn(conexionMock);

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getNifLocal()).thenReturn("pepe");

		doReturn(panelPedidosMock).when(spyControladorPanelPedidos)
				.makePanelPedidos(any(ControladorPanelPedidos.class));

		spyControladorPanelPedidos.mostrarPanelPedidos();
		verify(vistaMock).mostrarPanel(panelPedidosMock);

	}


	@Test
	public void testAccionadoBottonVolverPanelPrincipal() {

		controladorPanelPedidos = new ControladorPanelPedidos(modeloMock, vistaMock, controladorMock);

		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);

		controladorPanelPedidos.accionadoBottonVolverPanelPrincipal();

		verify(controladorMock, times(1)).navegarPanelPrincipal();

	}



	@Test
	public void TestExisteProducto() {

		String llamadaMetodo = "Hello";

		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);

		when(modeloMock.getListaTemporal().devolverPosProductoString(llamadaMetodo)).thenReturn(5);

		resultadoInt = controladorPanelPedidos.existeProducto(llamadaMetodo);
		resultadoEsperadoInt = 5;

		assertEquals(resultadoEsperadoInt, resultadoInt);

	}

	@Test
	public void TestCogerPrecioString() {

		String llamadaMetodo = "Hello";

		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);

		when(modeloMock.getListaTemporal().precioProductoString(llamadaMetodo)).thenReturn(35.54);

		resultadoDouble = controladorPanelPedidos.cogerPrecioString(llamadaMetodo);

		resultadoEsperadoDouble = 35.54;

		assertEquals(resultadoEsperadoDouble, resultadoDouble, 0);

	}

	@Test
	public void TestAccionadoBotonAnnadirProducto() {
		
		modeloMock.funProd = funcionesProductosMock;
		
		String producto = "Patata";
		String cantidad = "2";
		Double total = 0.0;
		
		String[] resultadoEsperadoArrayString = new String[] {"2 Patata","19.9"}; 
		
		when(funcionesProductosMock.funcionalidadAnadirProducto(producto, cantidad, total)).thenReturn(resultadoEsperadoArrayString);
		
		resultadoArrayString = controladorPanelPedidos.accionadoBotonAnnadirProducto(producto, cantidad);

		assertArrayEquals(resultadoEsperadoArrayString, resultadoArrayString);
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
		
		resultadoArrayString = controladorPanelPedidos.cambiarCantidadProductos(nombreProductoAnadido, cantidadAnadir, nombreProducto);

		assertArrayEquals(resultadoEsperadoArrayString, resultadoArrayString);

	}

	@Test
	public void TestAccionadoBotonEliminar() {

		int pos = 0;
		String eliminar = "1 Piedra";
		
		modeloMock.funProd = funcionesProductosMock;
		
		when(funcionesProductosMock.funcionalidadeliminarProducto(pos, eliminar, pos)).thenReturn(99.0);

		resultadoString = controladorPanelPedidos.accionadoBotonEliminar(pos, eliminar);

		resultadoEsperadoString = "99.0";

		assertEquals(resultadoEsperadoString, resultadoString);

	}
	
	@Test
	public void testPasarListaProductos() {
		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);
		
		when(listaProductosMock.getListaProductosString()).thenReturn(listaProductos);

		resultadoEsperadoArrayString = controladorPanelPedidos.cogerListaProductos();

		assertArrayEquals(resultadoEsperadoArrayString, listaProductos);
	}
	
	@Test
	public void TestDevolverFechaFormateada() {

		String input = "colchon";
				
		when(validacionesMock.devolverFechaFormateada(input)).thenReturn("pedro");
	
		resultadoString = validacionesMock.devolverFechaFormateada(input);

		resultadoEsperadoString = "pedro";
		
		assertEquals(resultadoEsperadoString, resultadoString);

	}
	
	@Test
	public void TestDevolverNombreProducto() {
		
		int i = 2;
		
		modeloMock.funProd = funcionesProductosMock;
		
		when(funcionesProductosMock.devolverNombreProducto(i)).thenReturn("solero");
		
		resultadoString = controladorPanelPedidos.devolverNombreProducto(i);

		resultadoEsperadoString = "solero";

		assertEquals(resultadoEsperadoString, resultadoString);

	}
	
	

	
}
