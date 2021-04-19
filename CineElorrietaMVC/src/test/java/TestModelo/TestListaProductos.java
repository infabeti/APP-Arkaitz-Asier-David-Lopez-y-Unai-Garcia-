package TestModelo;

import Modelo.ListaProductos;
import Modelo.Producto;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestListaProductos {
	
	private ListaProductos lp = new ListaProductos();
	private Producto mockP1 = mock(Producto.class);
	
	@Test
	public void testAnnadir() {
		boolean test = lp.addProducto(mockP1);
		assertTrue(test);
	}
	
	@Test
	public void testLimpiar() {
		boolean test = lp.limpiarLista();
		assertTrue(test);
	}
	
	@Test
	public void testCogerProducto() {
		lp.addProducto(mockP1);
		Producto test = lp.cogerProducto(0);
		when(mockP1.getNombre()).thenReturn("uno");
		assertTrue(test.equals(mockP1));
	}
	
	@Test
	public void testEliminarProducto() {
		lp.addProducto(mockP1);
		boolean test = lp.eliminarProducto(0);
		assertTrue(test);
	}
	
	@Test
	public void testGetPrecioProducto() {
		lp.addProducto(mockP1);
		when(mockP1.getPrecioVenta()).thenReturn(3.0);
		double test = lp.getPrecioProducto(0);
		assertEquals(3.0, test, 0);
	}
	
	@Test
	public void testGetListaProductoString() {
		lp.addProducto(mockP1);
		when(mockP1.getNombre()).thenReturn("mockP1");
		String[] listaString = lp.getListaProductosString();
		assertEquals("mockP1", listaString[0]);
	}
	
	@Test
	public void testDevolverProductoPorString() {
		lp.addProducto(mockP1);
		when(mockP1.getNombre()).thenReturn("mockP1");
		Producto test = lp.devolverProductoPorString("mockP1");
		assertEquals("mockP1", test.getNombre());
	}
	
	@Test
	public void testDevolverProductoPorStringNull() {
		Producto test = lp.devolverProductoPorString("mock");
		assertNull(test);
	}
	
	@Test
	public void testDevolverPosProductoString() {
		lp.addProducto(mockP1);
		when(mockP1.getNombre()).thenReturn("mockP1");
		int pos = lp.devolverPosProductoString("mockP1");
		assertEquals(pos, 0);
	}
	
	@Test
	public void testDevolverPosProductoStringNoExiste() {
		int pos = lp.devolverPosProductoString("mockP1");
		assertEquals(pos, -1);
	}
	
	@Test
	public void precioProductoPorString() {
		lp.addProducto(mockP1);
		when(mockP1.getNombre()).thenReturn("mockP1");
		when(mockP1.getPrecioVenta()).thenReturn(3.0);
		double test = lp.precioProductoString("mockP1");
		assertEquals(test, 3.0, 0);
	}
	
	@Test
	public void precioProductoPorStringNoExiste() {
		double test = lp.precioProductoString("mock");
		assertEquals(test, -1, 0);
	}
	
}
