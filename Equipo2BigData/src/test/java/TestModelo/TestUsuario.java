package TestModelo;

import Modelo.Usuario;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestUsuario {
	
	private Usuario user = new Usuario("u", "l", "b", "1");
	
	@Test
	public void testNombre() {
		String nombre = user.getNombre();
		assertEquals("u", nombre);
		user.setNombre("n");
		nombre = user.getNombre();
		assertEquals("n", nombre);
	}
	
	@Test
	public void testLocal() {
		String local = user.getLocal();
		assertEquals("l", local);
		user.setLocal("lo");
		local = user.getLocal();
		assertEquals("lo", local);
	}
	
	@Test
	public void testTipoLocal() {
		String tipo = user.getTipoLocal();
		assertEquals("b", tipo);
		user.setTipoLocal("bar");
		tipo = user.getTipoLocal();
		assertEquals("bar", tipo);
	}
	
	@Test
	public void testNIF() {
		String NIF = user.getNifLocal();
		assertEquals("1", NIF);
		user.setNifLocal("12");
		NIF = user.getNifLocal();
		assertEquals("12", NIF);
	}
	
	
}
