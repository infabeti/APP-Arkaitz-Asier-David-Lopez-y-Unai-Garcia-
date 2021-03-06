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
import Controlador.ControladorInicio;
import Modelo.ListaProductos;
import Modelo.Modelo;
import Modelo.Usuario;
import Vista.PanelInicio;
import Vista.Vista;
import principal.Conexion;

public class TestControladorPanelInicio {

	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private Conexion conexionMock = mock(Conexion.class);
	private Usuario userMock = mock(Usuario.class);
	private ListaProductos listaProductosMock = mock(ListaProductos.class);

	private ControladorInicio controladorInicio = new ControladorInicio(modeloMock, vistaMock, controladorMock);

	// Test mostrarPanelInicio
	private PanelInicio panelInicioMock = mock(PanelInicio.class);
	private ControladorInicio spyControladorInicio = spy(new ControladorInicio(modeloMock, vistaMock, controladorMock));
	
	
	@Test
	public void testConstructorControladorInicio() {
		assertEquals(controladorInicio.getControlador(), controladorMock);
		assertEquals(controladorInicio.getVista(), vistaMock);
		assertEquals(controladorInicio.getModelo(), modeloMock);
	}

	@Test
	public void testMostrarPanelInicio() {

		when(modeloMock.getConexion()).thenReturn(conexionMock);

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getNifLocal()).thenReturn("pepe");

		doReturn(panelInicioMock).when(spyControladorInicio).makePanelInicio(any(ControladorInicio.class));

		spyControladorInicio.mostrarPanelInicio();
		verify(vistaMock).mostrarPanel(panelInicioMock);

	}
	
	@Test
	public void TestAccionadoBotonAceptarPanelPrincipal() {
		controladorInicio = new ControladorInicio(modeloMock,
				vistaMock, controladorMock);
		
		controladorInicio.accionadoBottonVolverPanelPrincipal();
		
		verify(controladorMock).navegarPanelPrincipal();
	}
	
	@Test
	public void TestaccionadoBottonRegistroPanelInicio() {
		controladorInicio = new ControladorInicio(modeloMock,
				vistaMock, controladorMock);
		
		controladorInicio.accionadoBottonRegistroPanelInicio();
		
		verify(controladorMock).navegarPanelRegistro();
	}
	

}
