package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Plato;

public class TestPlato {

	private Plato pl = new Plato("Espaguetis carbonara", 9.99);
	
	
	@Test
	public void testNombre() {
		String nombre = pl.getNombre();
		assertEquals(nombre, "Espaguetis carbonara");
		pl.setNombre("macarroni");
		nombre = pl.getNombre();
		assertEquals(nombre, "macarroni");
	}
	
	@Test
	public void testPrecio() {
		Double precio = pl.getPrecio();
		assertEquals(precio, 9.99, 0);
		pl.setPrecio(12.34);
		precio = pl.getPrecio();
		assertEquals(precio, 12.34, 0);
	}
	
	@Test
	public void testToString() {
		String resultadoString = pl.toString();
		String resultadoEsperadoString = " - Espaguetis carbonara 9.99€";
		
		assertEquals(resultadoEsperadoString, resultadoString);
	}
	
}
