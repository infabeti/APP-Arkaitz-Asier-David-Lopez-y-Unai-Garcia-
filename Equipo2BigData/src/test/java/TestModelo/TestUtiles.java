package TestModelo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;

import Modelo.ConsultasSimples;
import Modelo.Modelo;
import Modelo.ResultadosHistorico;
import Modelo.Utiles;

public class TestUtiles {
	
	private Modelo modeloMock = mock(Modelo.class);
	private Utiles utiles = new Utiles(modeloMock);
	private ResultadosHistorico resultadosHistoricoMock = mock(ResultadosHistorico.class);
	private ConsultasSimples consultasSimplesMock = mock(ConsultasSimples.class);
	
	@Test
	public void testCogerCantidadString() {
		String prueba = "3 patata";
		int resultado = utiles.cogerCantidadString(prueba);
		assertEquals(3, resultado);
	}
	
	@Test
	public void testRellenarArrayDobleString() {
		String[][] resultadoEsperado = {{"hola"},{"hola"}};
		String[][] listaPrueba = utiles.arrayDoblesString("hola", 2, 1);
		assertEquals(resultadoEsperado[0][0], listaPrueba[0][0]);
		assertEquals(resultadoEsperado[1][0], listaPrueba[1][0]);
	}
	
	@Test
	public void testListaResultadosAString() {
		modeloMock.consultasSimples = consultasSimplesMock;
		when(resultadosHistoricoMock.getCodAl1()).thenReturn(1);
		when(resultadosHistoricoMock.getCodAl2()).thenReturn(2);
		when(resultadosHistoricoMock.getFecha()).thenReturn("2020-1-1");
		when(resultadosHistoricoMock.getProbabilidad()).thenReturn((float) 0.4);
		when(consultasSimplesMock.obtenerNombreCodAl(1)).thenReturn("patata");
		when(consultasSimplesMock.obtenerNombreCodAl(2)).thenReturn("platano");
		ResultadosHistorico[] listaPrueba = {resultadosHistoricoMock,null,null};
		String[][] listaResultado = utiles.listaResultadosAString(listaPrueba, 3);
		assertEquals(listaResultado[0][0], "patata");
		assertEquals(listaResultado[0][1], "platano");
		assertEquals(listaResultado[0][2], "2020-1-1");
		assertEquals(listaResultado[0][3], "40.0%");
	}
}
