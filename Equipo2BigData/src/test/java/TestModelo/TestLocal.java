package TestModelo;

import Modelo.*;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class TestLocal {
	
	
	private Actividad mockA1 = mock(Actividad.class);
	private Actividad mockA2 = mock(Actividad.class);
	private Producto mockp1 = mock(Producto.class);
	private ProductoTienda mockPt1 = mock(ProductoTienda.class);
	private ProductoTienda mockPt2 = mock(ProductoTienda.class);
	private Local loc = new Local("46564187J", "Primero", "Calle Pepito", "Restaurante");
	
	@Test
	public void testAnnadirActividad() {
		boolean test = loc.addActividad(mockA1);
		assertTrue(test);
		test = loc.addActividad(mockA2);
		assertTrue(test);
	}
	
	@Test
	public void testBuscarActividad() {
		loc.addActividad(mockA1);
		when(mockA1.getNumTransaccion()).thenReturn(11);
		Actividad test = loc.buscarActividad(11);
		assertEquals(mockA1.getNumTransaccion(), test.getNumTransaccion());
		test = loc.buscarActividad(98);
		assertNull(test);
	}
	
	@Test
	public void testEliminarActividad() {
		loc.addActividad(mockA1);
		when(mockA1.getNumTransaccion()).thenReturn(11);
		boolean test = loc.eliminarActividad(11);
		assertTrue(test);
		test = loc.eliminarActividad(11);
		assertFalse(test);
	}
	
	@Test
	public void testAnnadirProd() {
		boolean test = loc.addProdTienda(mockPt1);
		assertTrue(test);
		test = loc.addProdTienda(mockPt2);
		assertTrue(test);
	}
	
	@Test
	public void testBuscarProd() {
		loc.addProdTienda(mockPt1);
		when(mockp1.getNombre()).thenReturn("Prod1");
		when(mockPt1.getProd()).thenReturn(mockp1);
		ProductoTienda test = loc.buscarProdTienda("Prod1");
		assertEquals(mockPt1.getProd().getNombre(),test.getProd().getNombre());
		test = loc.buscarProdTienda("asdfasdfsdf");
		assertNull(test);
	}
	
	
	@Test
	public void testEliminarProd() {
		loc.addProdTienda(mockPt1);
		when(mockp1.getNombre()).thenReturn("Prod1");
		when(mockPt1.getProd()).thenReturn(mockp1);
		boolean test = loc.eliminarProdTienda("Prod1");
		assertTrue(test);
		test = loc.eliminarProdTienda("Prod1");
		assertFalse(test);
	}
}
