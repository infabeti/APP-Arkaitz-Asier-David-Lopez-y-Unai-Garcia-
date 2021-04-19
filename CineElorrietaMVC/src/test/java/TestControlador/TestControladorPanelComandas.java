package TestControlador;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import static org.junit.Assert.*;
import Controlador.Controlador;
import Controlador.ControladorPanelComandas;
import Modelo.Conexion;
import Modelo.ListaPlatos;
import Modelo.ListaProductos;
import Modelo.Modelo;
import Modelo.Usuario;
import Modelo.FuncionesProductos;
import Modelo.FuncionesPlatos;
import Modelo.Consultas;
import Vista.PanelComandas;
import Vista.Vista;

public class TestControladorPanelComandas {

	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private Conexion conexionMock = mock(Conexion.class);
	private Usuario userMock = mock(Usuario.class);
	private ListaProductos listaProductosMock = mock(ListaProductos.class);
	private ListaPlatos listaPlatosMock = mock(ListaPlatos.class);
	private FuncionesProductos funcionesProductosMock = mock(FuncionesProductos.class);
	private FuncionesPlatos funcionesPlatosMock = mock(FuncionesPlatos.class);
	private String[] resultadoArrayString, resultadoEsperadoArrayString;
	private Consultas consultasMock = mock(Consultas.class);
	
	private ControladorPanelComandas controladorPanelComandas = new ControladorPanelComandas(modeloMock, vistaMock,
			controladorMock);
	
	// Test mostrarPanel
		private PanelComandas panelComandasMock = mock(PanelComandas.class);
		private ControladorPanelComandas spyControladorPanelComandas= spy(
				new ControladorPanelComandas(modeloMock, vistaMock, controladorMock));

	
	@Test
	public void TestAccionadoBottonVolverPanelPrincipal() {

		controladorPanelComandas = new ControladorPanelComandas(modeloMock, vistaMock, controladorMock);

		when(modeloMock.getListaTemporalPlatos()).thenReturn(listaPlatosMock);
		
		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);
		
		when(listaPlatosMock.limpiarLista()).thenReturn(true);		

		controladorPanelComandas.accionadoBotonVolverPanelPrincipal();

		verify(controladorMock).navegarPanelPrincipal();
	}
	
	@Test
	public void testMostrarPanelComandas() {

		when(modeloMock.getConexion()).thenReturn(conexionMock);

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getNifLocal()).thenReturn("pepe");

		doReturn(panelComandasMock).when(spyControladorPanelComandas)
				.makePanelComandas(any(ControladorPanelComandas.class));

		spyControladorPanelComandas.mostrarPanelComandas();
		verify(vistaMock).mostrarPanel(panelComandasMock);

	}
	
	@Test
	public void testAccionadoBotonAnadirProducto() {
		
		modeloMock.funProd = funcionesProductosMock;
		
		String producto = "Patata";
		String cantidad = "2";
		Double total = 0.0;
		
		String[] resultadoEsperadoArrayString = new String[] {"2 Patata","19.9"}; 
		
		when(funcionesProductosMock.funcionalidadAnadirProducto(producto, cantidad, total)).thenReturn(resultadoEsperadoArrayString);
		
		resultadoArrayString = controladorPanelComandas.accionadoBotonAnnadirProducto(producto, cantidad);

		assertArrayEquals(resultadoEsperadoArrayString, resultadoArrayString);
	}
	
	@Test
	public void testExisteProducto() {
		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);
		
		when(listaProductosMock.devolverPosProductoString("patata")).thenReturn(2);
		
		int resultado = controladorPanelComandas.existeProducto("patata");
		
		assertEquals(2, resultado);
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
		
		resultadoArrayString = controladorPanelComandas.cambiarCantidadProductos(nombreProductoAnadido, cantidadAnadir, nombreProducto, "producto");

		assertArrayEquals(resultadoEsperadoArrayString, resultadoArrayString);

	}
	
	@Test
	public void TestCogerPrecioString() {
		String nombreProducto = "Patata";
		
		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);
		
		when(listaProductosMock.precioProductoString(nombreProducto)).thenReturn(2.0);
		
		double resultado = controladorPanelComandas.cogerPrecioString(nombreProducto);
		
		assertEquals(2.0, resultado, 0);
	}
	
	@Test
	public void TestAccionadoBotonEliminar() {
		int pos = 1;
		String eliminar = "elim";
		double total = 0.0;
		
		modeloMock.funProd = funcionesProductosMock;
		
		when(funcionesProductosMock.funcionalidadeliminarProducto(pos, eliminar,total)).thenReturn(2.0);
		
		String resultado = controladorPanelComandas.accionadoBotonEliminar(pos, eliminar);
		
		assertEquals("2.0", resultado);
	}
	
	@Test
	public void testExistePlato() {
		when(modeloMock.getListaTemporalPlatos()).thenReturn(listaPlatosMock);
		
		when(listaPlatosMock.devolverPosPlatoString("patata")).thenReturn(2);
		
		int resultado = controladorPanelComandas.existePlato("patata");
		
		assertEquals(2, resultado);
	}
	
	@Test
	public void testAccionadoBotonAnadirPlato() {
		
		modeloMock.funPlat = funcionesPlatosMock;
		
		String plato = "Patata";
		String cantidad = "2";
		Double total = 0.0;
		
		String[] resultadoEsperadoArrayString = new String[] {"2 Patata","19.9"}; 
		
		when(funcionesPlatosMock.funcionalidadAnadirPlato(plato, cantidad, total)).thenReturn(resultadoEsperadoArrayString);
		
		resultadoArrayString = controladorPanelComandas.accionadoBotonAnnadirPlato(plato, cantidad);

		assertArrayEquals(resultadoEsperadoArrayString, resultadoArrayString);
	}
	
	
	@Test
	public void TestAccionadoBotonEliminarPlato() {
		int pos = 1;
		String eliminar = "elim";
		double total = 0.0;
		
		modeloMock.funPlat = funcionesPlatosMock;
		
		when(funcionesPlatosMock.funcionalidadeliminarPlato(pos, eliminar,total)).thenReturn(0.0);
		
		String resultado = controladorPanelComandas.accionadoBotonEliminarPlato(pos, eliminar);
		
		assertEquals("0.0", resultado);
	}
	
	@Test
	public void TestConseguirDatosPanel() {
		when(modeloMock.getUser()).thenReturn(userMock);
		when(userMock.getNifLocal()).thenReturn("1");
		when(modeloMock.getFechaHoraSys()).thenReturn("2");
		when(modeloMock.getConsultas()).thenReturn(consultasMock);
		when(consultasMock.leerNumTransBBDD()).thenReturn(3);
		
		resultadoEsperadoArrayString = new String[] {"1","2","3"};
		
		resultadoArrayString = controladorPanelComandas.conseguirDatosPanel();
		
		assertArrayEquals(resultadoEsperadoArrayString, resultadoArrayString);
	}
}
