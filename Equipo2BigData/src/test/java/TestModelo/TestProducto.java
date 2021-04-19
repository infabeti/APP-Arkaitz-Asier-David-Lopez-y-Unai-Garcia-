package TestModelo;

import java.sql.Date;
import Modelo.Producto;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestProducto {
	
	private Date fecha = new Date(0);
	private Producto prod = new Producto("prod", fecha, "v", 3.0, 4.5);
	
	@Test
	public void testNombre() {
		String nombre = prod.getNombre();
		assertEquals(nombre, "prod");
		prod.setNombre("producto");
		nombre = prod.getNombre();
		assertEquals(nombre, "producto");
	}
	
	@Test
	public void testFecha() {
		Date test = prod.getFechaCaducidad();
		assertEquals(fecha, test);
	}
	
	@Test
	public void testTipoProducto() {
		String tipo = prod.getTipo();
		assertEquals(tipo, "v");
		prod.setTipo("vegetal");
		tipo = prod.getTipo();
		assertEquals(tipo, "vegetal");
	}
	
	@Test
	public void testPrecioCompra() {
		double precioC = prod.getPrecioCompra();
		assertEquals(precioC, 3.0, 0);
		prod.setPrecioCompra(2.0);
		precioC = prod.getPrecioCompra();
		assertEquals(precioC, 2.0, 0);
	}
	
	@Test
	public void testPrecioVenta() {
		double precioV = prod.getPrecioVenta();
		assertEquals(precioV, 4.5, 0);
		prod.setPrecioVenta(5.0);
		precioV = prod.getPrecioVenta();
		assertEquals(precioV, 5.0, 0);
	}
	
	@Test
	public void testToString() {
		String resultadoString = prod.toString();
		String resultadoEsperadoString = " - prod x 4.5€";
		
		assertEquals(resultadoEsperadoString, resultadoString);
	}
}
