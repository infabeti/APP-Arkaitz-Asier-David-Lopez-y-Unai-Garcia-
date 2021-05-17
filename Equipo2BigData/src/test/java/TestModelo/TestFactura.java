package TestModelo;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

import Modelo.Factura;

public class TestFactura {
	
	private Date fecha = new Date(0);
	private Factura f1 = new Factura(11, fecha, "Local", "12345678H", "nombre", "apellido");
	
	@Test
	public void testConstructor() {
		assertEquals("12345678H", f1.getNif());
		assertEquals("nombre", f1.getNombre());
		assertEquals("apellido", f1.getApellido());
	}
	
	@Test
	public void testSetNif() {
		f1.setNif("87654321H");
		assertEquals("87654321H", f1.getNif());
	}
	
	@Test
	public void testSetNombre()
	{
		f1.setNombre("a");
		assertEquals("a", f1.getNombre());
	}
	
	@Test
	public void testSetApellido() {
		f1.setApellido("ape");
		assertEquals("ape", f1.getApellido());
	}
}
