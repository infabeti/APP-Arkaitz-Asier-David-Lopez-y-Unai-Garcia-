package TestModelo;

import Modelo.*;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestProductoTienda {
	
	private Producto mockP1 = mock(Producto.class);
	private Producto mockP2 = mock(Producto.class);
	private ProductoTienda pt1 = new ProductoTienda(mockP1, 3);
	private ProductoTienda pt2 = new ProductoTienda(mockP2,0);
	
	
	@Test
	public void testCantidad() {
		int cantidad = pt1.getCantidad();
		assertEquals(cantidad, 3);
		pt1.setCantidad(88);
		assertEquals(88, pt1.getCantidad());
	}
	
	@Test
	public void testProducto() {
		when(mockP1.getNombre()).thenReturn("Hawai");
		String nombre = mockP1.getNombre();
		assertEquals(nombre, "Hawai");
		pt1.setProd(mockP1);
		assertEquals(mockP1, pt1.getProd());
	}
	
	
	@Test
	public void testAddCantidad() {
		int esperado = 5;
		int res = pt1.addCantidad(2);
		assertEquals(esperado, res);
		esperado = 13;
		res = pt1.addCantidad(8);
		assertEquals(esperado, res);
	}
	
	@Test
	public void testRestarCantidad() {
		int esperado = 1;
		int res = pt1.restarCantidad(2);
		assertEquals(esperado, res);
	}
	
	@Test
	public void testEquals() {
		when(mockP1.getNombre()).thenReturn("uno");
		when(mockP2.getNombre()).thenReturn("dos");
		boolean test = pt1.equals(pt2);
		assertFalse(test);
		test = pt1.equals(pt1);
		assertTrue(test);
		ProductoTienda pt3 = pt1;
		test = pt1.equals(pt3);
		assertTrue(test);
	}
	
	@Test
	public void testToString() {
		when(pt1.toString()).thenReturn("Facil");
		String resultadoString = pt1.toString();
		String resultadoEsperadoString = "Facil Cantidad:3";
		
		assertEquals(resultadoEsperadoString, resultadoString);
	}
}
