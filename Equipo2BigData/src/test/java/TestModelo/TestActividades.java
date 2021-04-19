package TestModelo;

import static org.junit.Assert.*;

import org.junit.Test;
import java.sql.Date;

import Modelo.*;

//@RunWith(MockitoJUnitRunner.class)

public class TestActividades { //Testea los m�todos no constructores, getters o setters de las clases que heredan de actividad (de momento solo esDomicilio())
	
	private Date fecha = new Date(0); //Fecha de tipo Date para insertar en las actividades
	private Actividad act = new Actividad(11, fecha, "Primero");
	private Actividad act2 = new Actividad(11);
	private Actividad act3 = new Actividad(22);
	private Actividad act4 = null;
	
	@Test
	public void testConstructor() {
		assertEquals(11, act.getNumTransaccion());
		assertEquals(fecha, act.getFecha());
		assertEquals("Primero", act.getLocal());
	}
	
	@Test
	public void testConstructor2() {
		assertEquals(11,act2.getNumTransaccion());
		assertNull(act2.getFecha());
		assertNull(act2.getLocal());
	}
	
	@Test
	public void testSetNumTransaccion() {
		act.setNumTransaccion(22);
		assertEquals(22, act.getNumTransaccion());
	}
	
	@Test
	public void testSetFecha() {
		Date fecha2 = new Date(1000);
		act.setFecha(fecha2);
		assertEquals(fecha2, act.getFecha());
	}
	
	@Test
	public void testSetLocal() {
		act.setLocal("loc");
		assertEquals("loc", act.getLocal());
	}
	
	@Test
	public void testEqualsTrue() {
		boolean res = act.equals(act2);
		assertTrue(res);
	}
	
	@Test
	public void testEqualsFalse() {
		boolean res = act.equals(act3);
		assertFalse(res);
	}
	
	@Test
	public void testEqualsNulo() {
		boolean res = act.equals(act4);
		assertFalse(res);
	}
	
	@Test
	public void testEqualsNoEsActividad() {
		String str = "";
		boolean res = act.equals(str);
		assertFalse(res);
	}
	
	@Test
	public void testToString() {
		String test = "Primero 11 1970-01-01";
		assertEquals(test, act.toString());
	}
}
