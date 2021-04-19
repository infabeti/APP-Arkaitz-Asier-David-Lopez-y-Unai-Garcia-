package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;

import Modelo.ListaPlatos;
import Modelo.ListaProductos;
import Modelo.Modelo;
import Modelo.Plato;
import Modelo.FuncionesPlatos;

public class TestFuncionesPlatos {
	
	private Modelo modeloMock = mock(Modelo.class);
	private String resultadoEsperadoString, resultadoString;
	private String[] resultadoArrayString;
	private double resultadoEsperadoDouble, resultadoDouble;
	private ListaPlatos listaPlatosMock = mock(ListaPlatos.class);
	private Plato platoMock = mock(Plato.class);
	private FuncionesPlatos funcionesPlatos = new FuncionesPlatos(modeloMock);
	
	@Test
	public void TestAnnadirPlato() {

		when(modeloMock.getListaPlatos()).thenReturn(listaPlatosMock);

		String input = "Macarroni";
		
		when(listaPlatosMock.devolverPlatoPorString(input)).thenReturn(platoMock);

		when(modeloMock.getListaTemporalPlatos()).thenReturn(listaPlatosMock);

		when(listaPlatosMock.addPlato(platoMock)).thenReturn(true);

		when(platoMock.toString()).thenReturn("mentos");

		resultadoString = funcionesPlatos.funcionalidadAnnadirPlato(input);

		resultadoEsperadoString = "mentos";

		assertEquals(resultadoEsperadoString, resultadoString);
	}
	
	@Test
	public void TestEliminarPlato() {

		int pos = 0;
		String eliminar = "1 Pepito";
		double total = 19.0;

		when(modeloMock.getListaTemporalPlatos()).thenReturn(listaPlatosMock);

		when(modeloMock.cogerCantidadString(eliminar)).thenReturn(1);

		when(listaPlatosMock.getPrecioPlato(pos)).thenReturn(16.0);

		resultadoDouble = funcionesPlatos.funcionalidadeliminarPlato(pos, eliminar, total);

		resultadoEsperadoDouble = 3.0;

		assertEquals(resultadoEsperadoDouble, resultadoDouble, 0.01);

	}
	
	@Test
	public void TestAccionadoBotonAnadirPlato() {
		String plato = "prod";
		String cantidad = "3";
		double total = 0.0;
		
		when(modeloMock.getListaPlatos()).thenReturn(listaPlatosMock);
		when(listaPlatosMock.devolverPlatoPorString(plato)).thenReturn(platoMock);
		when(modeloMock.getListaTemporalPlatos()).thenReturn(listaPlatosMock);
		when(platoMock.toString()).thenReturn("string");
		when(listaPlatosMock.precioProductoString(plato)).thenReturn(3.0);
		
		resultadoArrayString = funcionesPlatos.funcionalidadAnadirPlato(plato, cantidad, total);
		
		String [] resultadoEsperadoArrayString = new String[2];
		resultadoEsperadoArrayString[0] = "3 string";
		resultadoEsperadoArrayString[1] = "9.0";
		
		assertArrayEquals(resultadoEsperadoArrayString, resultadoArrayString);
	}
	
}
