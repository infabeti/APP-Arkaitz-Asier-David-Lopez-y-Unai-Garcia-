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
import Controlador.ControladorLogin;
import Modelo.Conexion;
import Modelo.ListaProductos;
import Modelo.Modelo;
import Modelo.Usuario;
import Vista.PanelLogin;
import Vista.Vista;

public class TestControladorPanelLogin {

	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private Conexion conexionMock = mock(Conexion.class);
	private Usuario userMock = mock(Usuario.class);
	private ListaProductos listaProductosMock = mock(ListaProductos.class);

	private ControladorLogin controladorLogin = new ControladorLogin(modeloMock, vistaMock, controladorMock);

	// Test mostrarPanelLogin
	private PanelLogin panelLoginMock = mock(PanelLogin.class);
	private ControladorLogin spyControladorLogin = spy(new ControladorLogin(modeloMock, vistaMock, controladorMock));
	
	
	@Test
	public void testConstructorControladorLogin() {
		assertEquals(controladorLogin.getControlador(), controladorMock);
		assertEquals(controladorLogin.getVista(), vistaMock);
		assertEquals(controladorLogin.getModelo(), modeloMock);
	}

	@Test
	public void testMostrarPanelLogin() {

		when(modeloMock.getConexion()).thenReturn(conexionMock);

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getNifLocal()).thenReturn("pepe");

		doReturn(panelLoginMock).when(spyControladorLogin).makePanelLogin(any(ControladorLogin.class));

		spyControladorLogin.mostrarPanelLogin();
		verify(vistaMock).mostrarPanel(panelLoginMock);

	}
	
	@Test
	public void TestAccionadoBotonAceptarPanelPrincipal() {
		controladorLogin = new ControladorLogin(modeloMock,
				vistaMock, controladorMock);
		
		controladorLogin.accionadoBottonAceptarPanelPrincipal();
		
		verify(controladorMock).navegarPanelPrincipal();
	}
	
	@Test
	public void TestaccionadoBottonRegistroPanelLogin() {
		controladorLogin = new ControladorLogin(modeloMock,
				vistaMock, controladorMock);
		
		controladorLogin.accionadoBottonRegistroPanelLogin();
		
		verify(controladorMock).navegarPanelRegistro();
	}
	

}
