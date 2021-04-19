package TestControlador;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import Controlador.Controlador;

import Controlador.ControladorPanelRegistro;
import Modelo.Conexion;
import Modelo.ListaProductos;
import Modelo.Modelo;

import Modelo.Usuario;

import Vista.PanelRegistro;
import Vista.Vista;

public class TestControladorPanelRegistro {

	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private Usuario userMock = mock(Usuario.class);
	private Conexion conexionMock = mock(Conexion.class);
	private ListaProductos listaProductosMock = mock(ListaProductos.class);

	private ControladorPanelRegistro controladorPanelRegistro = new ControladorPanelRegistro(modeloMock, vistaMock,
			controladorMock);

	// Test mostrarPanelRegistro
	private PanelRegistro panelRegistroMock = mock(PanelRegistro.class);
	private ControladorPanelRegistro spyControladorPanelRegistro = spy(
			new ControladorPanelRegistro(modeloMock, vistaMock, controladorMock));

	@Test
	public void testConstructorControladorRegistro() {
		assertEquals(controladorPanelRegistro.getControlador(), controladorMock);
		assertEquals(controladorPanelRegistro.getVista(), vistaMock);
		assertEquals(controladorPanelRegistro.getModelo(), modeloMock);
	}

	@Test
	public void testMostrarPanelRegistro() {

		when(modeloMock.getConexion()).thenReturn(conexionMock);

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getNifLocal()).thenReturn("pepe");

		doReturn(panelRegistroMock).when(spyControladorPanelRegistro)
				.makePanelRegistro(any(ControladorPanelRegistro.class));

		spyControladorPanelRegistro.mostrarPanelRegistro();
		verify(vistaMock).mostrarPanel(panelRegistroMock);

	}

	@Test
	public void testAccionadoBottonVolverPanelLogin() {

		controladorPanelRegistro = new ControladorPanelRegistro(modeloMock, vistaMock, controladorMock);

		controladorPanelRegistro.accionadoBottonVolverPanelLogin();

		verify(controladorMock).navegarPanelLogin();

	}

}
