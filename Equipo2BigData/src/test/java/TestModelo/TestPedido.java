package TestModelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;

import Modelo.Pedido;

public class TestPedido {
	
	private Date fecha = new Date(0);
	private Pedido p1 = new Pedido(1,fecha, "Local1");
	private Pedido p2 = new Pedido(2, fecha, "Local2", "Domicilio");
	private boolean comprobarBoolean;
	private String comprobarString;
	
	@Test
	public void testEsDomicilioTrue() {
		comprobarBoolean = p2.esDomicilio();
		assertTrue(comprobarBoolean);
	}
	
	@Test
	public void testEsDomicilioFalse() {
		comprobarBoolean = p1.esDomicilio();
		assertFalse(comprobarBoolean);
	}
	
	@Test
	public void testGetDomicilio() {
		comprobarString = p2.getDomicilio();
		assertEquals("Domicilio", comprobarString);
	}
	
	@Test
	public void testSetDomicilio() {
		p2.setDomicilio("dom");
		comprobarString = p2.getDomicilio();
		assertEquals("dom", comprobarString);
	}
	
}
