package TestControlador;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import Controlador.Controlador;
import Controlador.ControladorPanelAprovisionamiento;
import Modelo.Conexion;
import Modelo.ListaProductos;
import Modelo.Modelo;
import Modelo.Usuario;
import Vista.PanelAprovisionamiento;

import Vista.Vista;

public class TestControladorPanelAprovisionamiento {

	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private Conexion conexionMock = mock(Conexion.class);
	private Usuario userMock = mock(Usuario.class);
	private ListaProductos listaProductosMock = mock(ListaProductos.class);
	
	private ControladorPanelAprovisionamiento controladorPanelAprovisionamiento = new ControladorPanelAprovisionamiento(modeloMock, vistaMock,
			controladorMock);

	// Test mostrarPanel
	private PanelAprovisionamiento panelAprovisionamientoMock = mock(PanelAprovisionamiento.class);
	private ControladorPanelAprovisionamiento spyControladorPanelAprovisionamiento= spy(
			new ControladorPanelAprovisionamiento(modeloMock, vistaMock, controladorMock));

	@Test
	public void testConstructorControladorAprovisionamiento() {
		assertEquals(controladorPanelAprovisionamiento.getControlador(), controladorMock);
		assertEquals(controladorPanelAprovisionamiento.getVista(), vistaMock);
		assertEquals(controladorPanelAprovisionamiento.getModelo(), modeloMock);
	}
	
	@Test
	public void testMostrarPanelAprovisionamiento() {

		when(modeloMock.getConexion()).thenReturn(conexionMock);

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getNifLocal()).thenReturn("pepe");

		doReturn(panelAprovisionamientoMock).when(spyControladorPanelAprovisionamiento)
				.makePanelAprovisionamiento(any(ControladorPanelAprovisionamiento.class));

		spyControladorPanelAprovisionamiento.mostrarPanelAprovisionamiento();
		verify(vistaMock).mostrarPanel(panelAprovisionamientoMock);

	}
	
	@Test
	public void TestAccionadoBottonVolverPanelPrincipal() {

		controladorPanelAprovisionamiento = new ControladorPanelAprovisionamiento(modeloMock, vistaMock, controladorMock);

		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);

		controladorPanelAprovisionamiento.accionadoBottonVolverPanelPrincipal();

		verify(controladorMock, times(1)).navegarPanelPrincipal();
	}
	
	
	
}
