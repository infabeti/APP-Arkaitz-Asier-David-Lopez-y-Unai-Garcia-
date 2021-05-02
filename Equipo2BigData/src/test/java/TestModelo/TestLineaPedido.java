package TestModelo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import org.junit.Test;

import Modelo.LineaPedido;
import Modelo.Producto;


public class TestLineaPedido {
	private Producto productoMock = mock(Producto.class);
	LineaPedido lp = new LineaPedido(productoMock, 2, 19.95);

	@Test
	public void testConstructor() {
		
		assertEquals(2, lp.getCantidad());
		assertEquals(19.95, lp.getTotal(),0);
		assertEquals(productoMock,lp.getProducto());
	}
	
	@Test
	public void testToString() {
		String test = "2 x null 19.95€";
		assertEquals(test, lp.toString());
	}
	
	@Test
	public void testSetProducto() {
		lp.setProducto(productoMock);
		assertEquals(productoMock, lp.getProducto());
	}
	
	@Test
	public void testSetCantidad() {
		lp.setCantidad(9);
		assertEquals(9, lp.getCantidad());
	}
	
	@Test
	public void testSetTotal() {
		lp.setTotal(99.36);
		assertEquals(99.36, lp.getTotal(), 0);
	}
	
}
