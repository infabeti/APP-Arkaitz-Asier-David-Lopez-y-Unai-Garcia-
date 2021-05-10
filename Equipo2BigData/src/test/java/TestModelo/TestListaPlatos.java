package TestModelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;

import Modelo.ListaPlatos;
import Modelo.Plato;

public class TestListaPlatos {

	private ArrayList<Plato> listaP = new ArrayList<Plato>();
	private ListaPlatos lp;
	private Plato platoMock = mock(Plato.class);
	private boolean resultadoBoolean;
	private double resultadoEsperadoDouble, resultadoDouble;
	private String resultadoEsperadoString, resultadoString;
	private int resultadoInt, resultadoEsperadoInt;


	@Test
	public void testConstructor() {
		lp = new ListaPlatos();
		assertEquals(lp.getListaP(), listaP);
	}
	
	@Test
	public void TestAddPlatoTRUE() {
		lp = new ListaPlatos();		
		resultadoBoolean = lp.addPlato(platoMock);
		assertTrue(resultadoBoolean);

	}
	
	@Test
	public void testLimpiarLista() {
		lp = new ListaPlatos();		
		resultadoBoolean = lp.limpiarLista();
		assertTrue(resultadoBoolean);
	}
	
	@Test
	public void testEliminarPlato() {
		lp = new ListaPlatos();	
		lp.addPlato(platoMock);
		resultadoBoolean = lp.eliminarElemento(0);
		assertTrue(resultadoBoolean);
	}
	
	@Test
	public void testCogerPlato() {
		lp = new ListaPlatos();	
		lp.addPlato(platoMock);
		Plato test = lp.cogerPlato(0);
		when(platoMock.getNombre()).thenReturn("uno");
		assertTrue(test.equals(platoMock));
	}
	
	@Test
	public void testGetPrecio() {
		lp = new ListaPlatos();	
		lp.addPlato(platoMock);
		resultadoEsperadoDouble = 3.0;
		when(platoMock.getPrecio()).thenReturn(3.0);
		resultadoDouble = lp.getPrecioElementoPosicion(0);
		assertEquals(resultadoEsperadoDouble, resultadoDouble, 0);
	}
	
	@Test
	public void testGetListaPlatosString() {
		lp = new ListaPlatos();	
		lp.addPlato(platoMock);
		resultadoEsperadoString = "pepito";
		when(platoMock.getNombre()).thenReturn(resultadoEsperadoString);
		String[] listaString = lp.convertirListaAString();
		resultadoString = listaString[0];
		assertEquals(resultadoEsperadoString, resultadoString);
	}
	
	@Test
	public void testDevolverPlatoPorString() {
		lp = new ListaPlatos();	
		lp.addPlato(platoMock);
		
		String input = "hola";
		
		when(platoMock.getNombre()).thenReturn(input);
		Plato test = lp.devolverPlatoPorString(input);
		
		resultadoEsperadoString = input;
		resultadoString = test.getNombre();
		
		assertEquals(resultadoEsperadoString, resultadoString);
	}
	
	@Test
	public void testDevolverPlatoPorStringNULL() {
		lp = new ListaPlatos();	
		lp.addPlato(platoMock);
			
		when(platoMock.getNombre()).thenReturn("a");
		
		assertNull(lp.devolverPlatoPorString("b"));
	}
	
	@Test
	public void testDevolverPosPlatoString() {
		lp = new ListaPlatos();	
		lp.addPlato(platoMock);
		
		String input = "cebolla";
		
		when(platoMock.getNombre()).thenReturn(input);
		resultadoInt = lp.devolverPosElementoString(input);
		resultadoEsperadoInt = 0;
		assertEquals(resultadoEsperadoInt, resultadoInt);
	}
	
	@Test
	public void testDevolverPosPlatoStringRETURNMENOS1() {
		lp = new ListaPlatos();	
		lp.addPlato(platoMock);
		
		String input = "cebolla";
		
		when(platoMock.getNombre()).thenReturn(input);
		resultadoInt = lp.devolverPosElementoString("AA");
		resultadoEsperadoInt = -1;
		
		assertEquals(resultadoEsperadoInt, resultadoInt);
		
		//RETURNEO -1
	}
	
	@Test
	public void precioPlatoPorString() {
		lp = new ListaPlatos();	
		lp.addPlato(platoMock);
		
		String input = "pepino";
		resultadoEsperadoDouble = 3.0;
		
		when(platoMock.getNombre()).thenReturn(input);
		when(platoMock.getPrecio()).thenReturn(resultadoEsperadoDouble);
		resultadoDouble = lp.precioElementoString(input);
		
		assertEquals(resultadoEsperadoDouble, resultadoEsperadoDouble, 0);
	}
	
	@Test
	public void precioPlatoPorStringRETURNMENOS1() {
		lp = new ListaPlatos();	
		lp.addPlato(platoMock);
		
		String input = "pepino";
		resultadoEsperadoDouble = 3.0;
		
		when(platoMock.getNombre()).thenReturn(input);
		when(platoMock.getPrecio()).thenReturn(resultadoEsperadoDouble);
		resultadoDouble = lp.precioElementoString("AA");
		
		assertEquals(resultadoEsperadoDouble, resultadoEsperadoDouble, 0);
	}
	
	
	
	
	
	
	
	
}
