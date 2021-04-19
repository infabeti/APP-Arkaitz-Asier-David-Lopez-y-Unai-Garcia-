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

import Controlador.ControladorPanelPrincipal;
import Modelo.Conexion;
import Modelo.ListaProductos;
import Modelo.Modelo;
import Modelo.Usuario;

import Vista.PanelPrincipal;
import Vista.Vista;

public class TestControladorPanelPrincipal {

	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private Conexion conexionMock = mock(Conexion.class);
	private Usuario userMock = mock(Usuario.class);
	private ListaProductos listaProductosMock = mock(ListaProductos.class);
	
	private ControladorPanelPrincipal controladorPanelPrincipal = new ControladorPanelPrincipal(modeloMock, vistaMock,
			controladorMock);

		// Test mostrarPanelPrincipal
		private PanelPrincipal panelPrincipalMock = mock(PanelPrincipal.class);
		private ControladorPanelPrincipal spyControladorPanelPrincipal = spy(
				new ControladorPanelPrincipal(modeloMock, vistaMock, controladorMock));
	
	@Test
	public void testConstructorControladorPrincipal() {
		assertEquals(controladorPanelPrincipal.getControlador(), controladorMock);
		assertEquals(controladorPanelPrincipal.getVista(), vistaMock);
		assertEquals(controladorPanelPrincipal.getModelo(), modeloMock);
	}
	
	@Test
	public void testMostrarPanelPrincipal() {
		when(modeloMock.getConexion()).thenReturn(conexionMock);

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getNifLocal()).thenReturn("pepe");

		doReturn(panelPrincipalMock).when(spyControladorPanelPrincipal)
				.makePanelPrincipal(any(ControladorPanelPrincipal.class));

		spyControladorPanelPrincipal.mostrarPanelPrincipal();
		verify(vistaMock).mostrarPanel(panelPrincipalMock);
	}
	
	@Test
	public void testAccionadoBottonMostrarPanelAprovisionamiento() {
		
		controladorPanelPrincipal = new ControladorPanelPrincipal(modeloMock,
				vistaMock, controladorMock);
			
		controladorPanelPrincipal.accionadoBottonMostrarPanelAprovisionamiento();
			
		verify(controladorMock).navegarPanelAprovisionamiento();

	}
	
	@Test
	public void testAccionadoBottonMostrarPanelComandas() {
		
		controladorPanelPrincipal = new ControladorPanelPrincipal(modeloMock,
				vistaMock, controladorMock);
			
		controladorPanelPrincipal.accionadoBottonMostrarPanelComandas();
			
		verify(controladorMock).navegarPanelComandas();

	}
	
	@Test
	public void testAccionadoBottonMostrarPanelPedidos() {
		
		controladorPanelPrincipal = new ControladorPanelPrincipal(modeloMock,
				vistaMock, controladorMock);
			
		controladorPanelPrincipal.accionadoBottonMostrarPanelPedidos();
			
		verify(controladorMock).navegarPanelPedidos();

	}
	
	@Test
	public void testAccionadoBottonMostrarPanelTickets() {
		
		controladorPanelPrincipal = new ControladorPanelPrincipal(modeloMock,
				vistaMock, controladorMock);
			
		controladorPanelPrincipal.accionadoBottonMostrarPanelTickets();
			
		verify(controladorMock).navegarPanelTickets();

	}
	
	@Test
	public void testAccionadoBottonMostrarPanelFacturas() {
		
		controladorPanelPrincipal = new ControladorPanelPrincipal(modeloMock,
				vistaMock, controladorMock);
			
		controladorPanelPrincipal.accionadoBottonMostrarPanelFacturas();
			
		verify(controladorMock).navegarPanelFacturas();

	}
	
	@Test
	public void testAccionadoBottonDesconectarPanelPrincipal() {
		
		controladorPanelPrincipal = new ControladorPanelPrincipal(modeloMock,
				vistaMock, controladorMock);
			
		controladorPanelPrincipal.accionadoBottonDesconectarPanelPrincipal();
			
		verify(controladorMock).navegarPanelLogin();

	}
	
	
	
}
