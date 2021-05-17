package TestModelo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;

import Modelo.Conversor;
import Modelo.ListaPlatos;
import Modelo.ListaProductos;
import Modelo.Plato;
import Modelo.Producto;
import Modelo.Usuario;

public class TestConversor {
	
	private Conversor conversor = new Conversor();
	private Usuario usuarioMock = mock(Usuario.class);
	private ArrayList<String[]> arrayListMock = mock(ArrayList.class);
	private String[] arrayString = new String[5];
	private String[] arrayString2 = new String[2];
	private String[] arrayString3 = new String[4];
	private ListaProductos listaProductosMock = mock(ListaProductos.class);
	private ListaPlatos listaPlatosMock = mock(ListaPlatos.class);
	private Producto productoMock = mock(Producto.class);
	private Plato platoMock = mock(Plato.class);
	
	@Test
	public void TestListaStringAProductos() {
		when(arrayListMock.size()).thenReturn(1);
		when(arrayListMock.get(0)).thenReturn(arrayString);
		when(listaProductosMock.cogerProducto(0)).thenReturn(productoMock);
		arrayString[0] = "prueba";
		arrayString[1] = "0.1";
		arrayString[2] = "0.2";
		arrayString[3] = "BEBIDA";
		arrayString[4] = "2020-02-01";
		listaProductosMock = conversor.listaStringAProductos(arrayListMock);
		
		
		when(productoMock.getNombre()).thenReturn("prueba");
		when(productoMock.getPrecioVenta()).thenReturn(0.1);
		when(productoMock.getPrecioCompra()).thenReturn(0.2);
		when(productoMock.getTipo()).thenReturn("BEBIDA");
		
		assertEquals(productoMock.getNombre(), "prueba");
		assertEquals(productoMock.getPrecioVenta(), 0.1, 0);
		assertEquals(productoMock.getPrecioCompra(), 0.2, 0);
		assertEquals(productoMock.getTipo(), "BEBIDA");
	}
	
	@Test
	public void TestListaStringAPlatos() {
		when(arrayListMock.size()).thenReturn(1);
		when(arrayListMock.get(0)).thenReturn(arrayString2);
		when(listaPlatosMock.cogerPlato(0)).thenReturn(platoMock);
		arrayString2[0] = "prueba";
		arrayString2[1] = "0.1";
		listaPlatosMock = conversor.listaStringAPlatos(arrayListMock);
		
		when(platoMock.getNombre()).thenReturn("prueba");
		when(platoMock.getPrecio()).thenReturn(0.1);
		
		assertEquals(platoMock.getNombre(), "prueba");
		assertEquals(platoMock.getPrecio(), 0.1, 0);
	}
	
	@Test
	public void TestListaStringAAlimentos() {
		when(arrayListMock.size()).thenReturn(1);
		when(arrayListMock.get(0)).thenReturn(arrayString3);
		when(listaProductosMock.cogerProducto(0)).thenReturn(productoMock);
		arrayString3[0] = "prueba";
		arrayString3[1] = "0.1";
		arrayString3[2] = "BEBIDA";
		arrayString3[3] = "2020-02-01";
		listaProductosMock = conversor.listaStringAAlimentos(arrayListMock);
		
		when(productoMock.getNombre()).thenReturn("prueba");
		when(productoMock.getPrecioVenta()).thenReturn(0.1);
		when(productoMock.getTipo()).thenReturn("BEBIDA");
		
		assertEquals(productoMock.getNombre(), "prueba");
		assertEquals(productoMock.getPrecioVenta(), 0.1, 0);
		assertEquals(productoMock.getTipo(), "BEBIDA");
	}
	
	@Test
	public void TestListaStringAUser() {
		arrayString[0] = "pepito";
		arrayString[1] = "grillo";
		arrayString[2] = "restaurante";
		arrayString[3] = "12345678A";
		Usuario usuario = conversor.listaStringAUser(arrayString);
		
		assertEquals(arrayString[0], usuario.getNombre());
		assertEquals(arrayString[1], usuario.getLocal());
		assertEquals(arrayString[2], usuario.getTipoLocal());
		assertEquals(arrayString[3], usuario.getNifLocal());
	}
}
