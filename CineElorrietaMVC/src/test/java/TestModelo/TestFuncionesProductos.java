package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import Modelo.ListaProductos;
import Modelo.Modelo;
import Modelo.Producto;
import Modelo.FuncionesProductos;

public class TestFuncionesProductos {
	
	
	private Modelo modeloMock = mock(Modelo.class);
	private String resultadoEsperadoString, resultadoString;
	private String[] resultadoArrayString;
	private double resultadoEsperadoDouble, resultadoDouble;
	private ListaProductos listaProductosMock = mock(ListaProductos.class);
	private Producto productoMock = mock(Producto.class);
	
	private FuncionesProductos funcionesProductos = new FuncionesProductos(modeloMock);
	
	@Test
	public void TestAnnadirProducto() {

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		// Le digo que cuando se llame a ese producto con un string "saludos" y luego le
		// llamo
		when(listaProductosMock.devolverProductoPorString("saludos")).thenReturn(productoMock);

		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);

		when(listaProductosMock.addProducto(productoMock)).thenReturn(true);

		when(productoMock.toString()).thenReturn("hola");

		resultadoString = funcionesProductos.annadirProducto("saludos");

		resultadoEsperadoString = "hola";

		assertEquals(resultadoEsperadoString, resultadoString);
	}
	
	@Test
	public void TestCambiarCantidadProductos() {

		String producto = "1 - Calabaza";

		resultadoString = funcionesProductos.funcionalidadCambioProductos(producto, 4);

		resultadoEsperadoString = "5 - Calabaza";

		assertEquals(resultadoEsperadoString, resultadoString);

	}
	
	@Test
	public void TestCantidadTotal() {

		String primer = "2";
		String segun = "3";
		double tercer = 3;

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(listaProductosMock.precioProductoString(segun)).thenReturn(3.0);

		resultadoDouble = funcionesProductos.cantidadTotal(primer, segun, tercer, "producto");

		resultadoEsperadoDouble = 9.0;

		assertEquals(resultadoEsperadoDouble, resultadoDouble, 0.01);

	}
	
	@Test
	public void TestEliminarProducto() {

		int pos = 0;
		String eliminar = "1 Pepito";
		double total = 19.0;

		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);

		when(modeloMock.cogerCantidadString(eliminar)).thenReturn(1);

		when(listaProductosMock.getPrecioProducto(pos)).thenReturn(16.0);

		resultadoDouble = funcionesProductos.funcionalidadeliminarProducto(pos, eliminar, total);

		resultadoEsperadoDouble = 3.0;

		assertEquals(resultadoEsperadoDouble, resultadoDouble, 0.01);

	}
	
	@Test
	public void TestDevolverNombreProducto() {

		int i = 1;

		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);

		String[] arrStringProductos = { "PepsiCola", "Zapatilla" };

		when(listaProductosMock.getListaProductosString()).thenReturn(arrStringProductos);

		resultadoString = funcionesProductos.devolverNombreProducto(i);

		resultadoEsperadoString = "Zapatilla";

		assertEquals(resultadoEsperadoString, resultadoString);

	}
	
	@Test
	public void TestAccionadoBotonAnadirProducto() {
		String producto = "prod";
		String cantidad = "3";
		double total = 0.0;
		
		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);
		when(listaProductosMock.devolverProductoPorString(producto)).thenReturn(productoMock);
		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);
		when(productoMock.toString()).thenReturn("string");
		when(listaProductosMock.precioProductoString(producto)).thenReturn(3.0);
		
		resultadoArrayString = funcionesProductos.funcionalidadAnadirProducto(producto, cantidad, total);
		
		String [] resultadoEsperadoArrayString = new String[2];
		resultadoEsperadoArrayString[0] = "3 string";
		resultadoEsperadoArrayString[1] = "9.0";
		
		assertArrayEquals(resultadoEsperadoArrayString, resultadoArrayString);
	}
	
	@Test
	public void cambiarCantidadProductos() {
		String nombreProductoAnadido = "1 producto";
		int cantidadAnadir = 3;
		String nombreProducto = "producto";
		double total = 3.0;
		
		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);
		when(listaProductosMock.precioProductoString(nombreProducto)).thenReturn(3.0);
		
		resultadoArrayString = funcionesProductos.cambiarCantidadProductos(nombreProductoAnadido, cantidadAnadir, nombreProducto, total, "producto");
		
		String [] resultadoEsperadoArrayString = new String[2];
		resultadoEsperadoArrayString[0] = "4 producto";
		resultadoEsperadoArrayString[1] = "12.0";
		
		assertArrayEquals(resultadoEsperadoArrayString, resultadoArrayString);
	}

}
