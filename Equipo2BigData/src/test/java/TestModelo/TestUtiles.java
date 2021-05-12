package TestModelo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import org.junit.Test;

import Modelo.Modelo;
import Modelo.Utiles;

public class TestUtiles {
	
	Modelo modeloMock = mock(Modelo.class);
	Utiles utiles = new Utiles(modeloMock);
	
	@Test
	public void testCogerCantidadString() {
		String prueba = "3 patata";
		int resultado = utiles.cogerCantidadString(prueba);
		assertEquals(3, resultado);
	}
	
	@Test
	public void testRellenarArrayDobleString() {
		String[][] listaPrueba = new String[2][1];
		String[][] resultadoEsperado = {{"hola"},{"hola"}};
		listaPrueba = utiles.rellenarArrayDobleString(listaPrueba, "hola", 2, 1);
		assertEquals(resultadoEsperado[0][0], listaPrueba[0][0]);
		assertEquals(resultadoEsperado[1][0], listaPrueba[1][0]);
	}
}
