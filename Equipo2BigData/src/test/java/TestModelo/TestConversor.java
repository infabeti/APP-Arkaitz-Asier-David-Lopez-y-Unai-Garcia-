package TestModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;

import Modelo.Conversor;
import Modelo.ListaPlatos;
import Modelo.ListaProductos;
import Modelo.Usuario;
import java.util.ArrayList;

public class TestConversor {
	
	private Conversor conversor = new Conversor();
	private Usuario usuarioMock = mock(Usuario.class);
	private ArrayList<String[]> arrayListMock = mock(ArrayList.class);
	private String[] arrayString = new String[5];
	private String[] arrayString2 = new String[2];
	private String[] arrayString3 = new String[4];
	private ListaProductos listaProductosMock = mock(ListaProductos.class);
	private ListaPlatos listaPlatosMock = mock(ListaPlatos.class);
	
	@Test
	public void TestListaStringAProductos() {
		when(arrayListMock.size()).thenReturn(1);
		when(arrayListMock.get(0)).thenReturn(arrayString);
		arrayString[0] = "prueba";
		arrayString[1] = "0.1";
		arrayString[2] = "0.2";
		arrayString[3] = "BEBIDA";
		arrayString[4] = "2020-02-01";
		listaProductosMock = conversor.listaStringAProductos(arrayListMock);
	}
	
	@Test
	public void TestListaStringAPlatos() {
		when(arrayListMock.size()).thenReturn(1);
		when(arrayListMock.get(0)).thenReturn(arrayString2);
		arrayString2[0] = "prueba";
		arrayString2[1] = "0.1";
		listaPlatosMock = conversor.listaStringAPlatos(arrayListMock);
	}
	
	@Test
	public void TestListaStringAAlimentos() {
		when(arrayListMock.size()).thenReturn(1);
		when(arrayListMock.get(0)).thenReturn(arrayString3);
		arrayString3[0] = "prueba";
		arrayString3[1] = "0.1";
		arrayString3[2] = "BEBIDA";
		arrayString3[3] = "2020-02-01";
		listaProductosMock = conversor.listaStringAAlimentos(arrayListMock);
	}
}
