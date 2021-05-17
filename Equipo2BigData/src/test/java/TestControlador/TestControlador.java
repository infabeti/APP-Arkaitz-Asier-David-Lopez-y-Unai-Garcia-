package TestControlador;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Controlador.Controlador;
import Controlador.ControladorInicio;
import Controlador.ControladorPanelAnalisis;
import Controlador.ControladorPanelAprovisionamiento;
import Controlador.ControladorPanelComandas;
import Controlador.ControladorPanelFacturas;
import Controlador.ControladorPanelPedidos;
import Controlador.ControladorPanelRegistro;
import Controlador.ControladorPanelTickets;
import Modelo.ConsultasListas;
import Modelo.ConsultasSimples;
import Modelo.Conversor;
import Modelo.ListaPlatos;
import Modelo.ListaProductos;
import Modelo.Modelo;
import Modelo.Usuario;
import Modelo.Utiles;
import Vista.Vista;
import principal.Conexion;

public class TestControlador {

	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private ControladorPanelPedidos controladorPanelPedidosMock = mock(ControladorPanelPedidos.class);
	private ControladorPanelRegistro controladorPanelRegistroMock = mock(ControladorPanelRegistro.class);
	private ControladorPanelAprovisionamiento controladorPanelAprovisionamientoMock = mock(
			ControladorPanelAprovisionamiento.class);
	private ControladorInicio controladorInicioMock = mock(ControladorInicio.class);
	private ControladorPanelTickets controladorPanelTicketsMock = mock(ControladorPanelTickets.class);
	private ControladorPanelFacturas controladorPanelFacturasMock = mock(ControladorPanelFacturas.class);
	private ControladorPanelComandas controladorPanelComandasMock = mock(ControladorPanelComandas.class);
	private ControladorPanelAnalisis controladorPanelAnalisisMock = mock(ControladorPanelAnalisis.class);
	private Controlador spyControlador;
	private Usuario userMock = mock(Usuario.class);
	private Conexion conexionMock = mock(Conexion.class);
	private ConsultasListas consultasListasMock = mock(ConsultasListas.class);
	private ConsultasSimples consultasSimplesMock = mock(ConsultasSimples.class);
	private ListaPlatos listaPlatosMock = mock(ListaPlatos.class);
	private ListaProductos listaProductosMock = mock(ListaProductos.class);
	private ArrayList<String[]> arrayListMock = mock(ArrayList.class);
	private String[] arrString = new String[] { "a", "b" };
	private Utiles utilesMock = mock(Utiles.class);
	private Conversor conversorMock = mock(Conversor.class);
	
	@Before
	public void setNecesarios() {
		modeloMock.setConexion(conexionMock);
		modeloMock.utiles = utilesMock;
		modeloMock.consultasSimples = consultasSimplesMock;
		when(consultasSimplesMock.leerNumTransBBDD()).thenReturn(0);
	}

	@Test
	public void navegarPanelInicio() {

		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorInicioMock).when(spyControlador).makeControladorPanelInicio(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPedidosMock).when(spyControlador).makeControladorPanelPedidos(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelRegistroMock).when(spyControlador).makeControladorPanelRegistro(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelAprovisionamientoMock).when(spyControlador)
				.makeControladorPanelAprovisionamiento(any(Modelo.class), any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelTicketsMock).when(spyControlador).makeControladorPanelTickets(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelFacturasMock).when(spyControlador).makeControladorPanelFacturas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		spyControlador.navegarPanelInicio();

		verify(spyControlador).controladorInicioMostrarPanelInicio();
	}

	@Test
	public void navegarPanelRegistro() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorInicioMock).when(spyControlador).makeControladorPanelInicio(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPedidosMock).when(spyControlador).makeControladorPanelPedidos(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelRegistroMock).when(spyControlador).makeControladorPanelRegistro(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelAprovisionamientoMock).when(spyControlador)
				.makeControladorPanelAprovisionamiento(any(Modelo.class), any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelTicketsMock).when(spyControlador).makeControladorPanelTickets(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelFacturasMock).when(spyControlador).makeControladorPanelFacturas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		spyControlador.navegarPanelRegistro();

		verify(spyControlador).controladorPanelRegistroMostrarPanelegistro();
	}

	@Test
	public void navegarPanelPedidosRESTAURANTE() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorInicioMock).when(spyControlador).makeControladorPanelInicio(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPedidosMock).when(spyControlador).makeControladorPanelPedidos(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelRegistroMock).when(spyControlador).makeControladorPanelRegistro(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelAprovisionamientoMock).when(spyControlador)
				.makeControladorPanelAprovisionamiento(any(Modelo.class), any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelTicketsMock).when(spyControlador).makeControladorPanelTickets(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelFacturasMock).when(spyControlador).makeControladorPanelFacturas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getTipoLocal()).thenReturn("restaurante");

		when(modeloMock.getConexion()).thenReturn(conexionMock);

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		spyControlador.navegarPanelPedidos();

		verify(spyControlador).controladorPanelPedidosMostrarPanelPedidos();
	}

	@Test
	public void navegarPanelPedidosCAFETERIA() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorInicioMock).when(spyControlador).makeControladorPanelInicio(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPedidosMock).when(spyControlador).makeControladorPanelPedidos(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelRegistroMock).when(spyControlador).makeControladorPanelRegistro(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelAprovisionamientoMock).when(spyControlador)
				.makeControladorPanelAprovisionamiento(any(Modelo.class), any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelTicketsMock).when(spyControlador).makeControladorPanelTickets(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelFacturasMock).when(spyControlador).makeControladorPanelFacturas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getTipoLocal()).thenReturn("cafeteria");

		when(modeloMock.getConexion()).thenReturn(conexionMock);

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		spyControlador.navegarPanelPedidos();

		verify(spyControlador).controladorPanelPedidosMostrarPanelPedidos();
	}

	@Test
	public void navegarPanelPedidosBAR() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorInicioMock).when(spyControlador).makeControladorPanelInicio(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPedidosMock).when(spyControlador).makeControladorPanelPedidos(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelRegistroMock).when(spyControlador).makeControladorPanelRegistro(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelAprovisionamientoMock).when(spyControlador)
				.makeControladorPanelAprovisionamiento(any(Modelo.class), any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelTicketsMock).when(spyControlador).makeControladorPanelTickets(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelFacturasMock).when(spyControlador).makeControladorPanelFacturas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelComandasMock).when(spyControlador).makecontroladorPanelComandas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getTipoLocal()).thenReturn("bar");

		when(modeloMock.getConexion()).thenReturn(conexionMock);

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		spyControlador.navegarPanelPedidos();

		verify(spyControlador, never()).controladorPanelPedidosMostrarPanelPedidos();
	}

	@Test
	public void navegarPanelTickets() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorInicioMock).when(spyControlador).makeControladorPanelInicio(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPedidosMock).when(spyControlador).makeControladorPanelPedidos(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelRegistroMock).when(spyControlador).makeControladorPanelRegistro(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelAprovisionamientoMock).when(spyControlador)
				.makeControladorPanelAprovisionamiento(any(Modelo.class), any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelTicketsMock).when(spyControlador).makeControladorPanelTickets(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelFacturasMock).when(spyControlador).makeControladorPanelFacturas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelComandasMock).when(spyControlador).makecontroladorPanelComandas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		when(modeloMock.getConexion()).thenReturn(conexionMock);

		// Objeto tipo listaproductos
		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getTipoLocal()).thenReturn("test");

		spyControlador.navegarPanelTickets();

		verify(spyControlador).controladorPanelTicketsMostrarPanelTickets();
	}

	@Test
	public void navegarPanelPrincipal() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorInicioMock).when(spyControlador).makeControladorPanelInicio(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPedidosMock).when(spyControlador).makeControladorPanelPedidos(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelRegistroMock).when(spyControlador).makeControladorPanelRegistro(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelAprovisionamientoMock).when(spyControlador)
				.makeControladorPanelAprovisionamiento(any(Modelo.class), any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelTicketsMock).when(spyControlador).makeControladorPanelTickets(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelFacturasMock).when(spyControlador).makeControladorPanelFacturas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelComandasMock).when(spyControlador).makecontroladorPanelComandas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getTipoLocal()).thenReturn("test");

		spyControlador.navegarPanelPrincipal();

		verify(spyControlador).controladorPanelPrincipalMostrarPanelPrincipal();
	}

	@Test
	public void navegarPanelAprovisionamiento() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorInicioMock).when(spyControlador).makeControladorPanelInicio(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPedidosMock).when(spyControlador).makeControladorPanelPedidos(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelRegistroMock).when(spyControlador).makeControladorPanelRegistro(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelAprovisionamientoMock).when(spyControlador)
				.makeControladorPanelAprovisionamiento(any(Modelo.class), any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelTicketsMock).when(spyControlador).makeControladorPanelTickets(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelFacturasMock).when(spyControlador).makeControladorPanelFacturas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelComandasMock).when(spyControlador).makecontroladorPanelComandas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		when(modeloMock.getConexion()).thenReturn(conexionMock);
		
		modeloMock.consultasListas = consultasListasMock;

		when(consultasListasMock.cogerProductosAprovisionamiento()).thenReturn(arrayListMock);
		
		modeloMock.conversor = conversorMock;
		
		when(conversorMock.listaStringAAlimentos(arrayListMock)).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getTipoLocal()).thenReturn("test");

		spyControlador.navegarPanelAprovisionamiento();

		verify(spyControlador).controladorPanelAprovisionamientoMostrarPanelAprovisionamiento();
	}

	@Test
	public void navegarPanelFacturas() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorInicioMock).when(spyControlador).makeControladorPanelInicio(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPedidosMock).when(spyControlador).makeControladorPanelPedidos(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelRegistroMock).when(spyControlador).makeControladorPanelRegistro(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelAprovisionamientoMock).when(spyControlador)
				.makeControladorPanelAprovisionamiento(any(Modelo.class), any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelTicketsMock).when(spyControlador).makeControladorPanelTickets(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelFacturasMock).when(spyControlador).makeControladorPanelFacturas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelComandasMock).when(spyControlador).makecontroladorPanelComandas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		when(modeloMock.getConexion()).thenReturn(conexionMock);

		// Objeto tipo listaproductos
		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getTipoLocal()).thenReturn("test");

		spyControlador.navegarPanelFacturas();

		verify(spyControlador).controladorPanelFacturasMostrarPanelFacturas();
	}

	@Test
	public void navegarPanelComandas() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorInicioMock).when(spyControlador).makeControladorPanelInicio(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPedidosMock).when(spyControlador).makeControladorPanelPedidos(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelRegistroMock).when(spyControlador).makeControladorPanelRegistro(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelAprovisionamientoMock).when(spyControlador)
				.makeControladorPanelAprovisionamiento(any(Modelo.class), any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelTicketsMock).when(spyControlador).makeControladorPanelTickets(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelFacturasMock).when(spyControlador).makeControladorPanelFacturas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelComandasMock).when(spyControlador).makecontroladorPanelComandas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		when(modeloMock.getConexion()).thenReturn(conexionMock);

		// Objeto tipo listaproductos
		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getTipoLocal()).thenReturn("restaurante");

		when(controladorPanelComandasMock.cogerListaPlatos()).thenReturn(arrString);

		when(modeloMock.getListaPlatos()).thenReturn(listaPlatosMock);

		spyControlador.navegarPanelComandas();

		verify(spyControlador).controladorPanelComandasMostrarPanelComandas();
	}

	@Test
	public void navegarPanelComandasNORESTAURANTE() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorInicioMock).when(spyControlador).makeControladorPanelInicio(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPedidosMock).when(spyControlador).makeControladorPanelPedidos(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelRegistroMock).when(spyControlador).makeControladorPanelRegistro(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelAprovisionamientoMock).when(spyControlador)
				.makeControladorPanelAprovisionamiento(any(Modelo.class), any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelTicketsMock).when(spyControlador).makeControladorPanelTickets(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelFacturasMock).when(spyControlador).makeControladorPanelFacturas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelComandasMock).when(spyControlador).makecontroladorPanelComandas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		when(modeloMock.getConexion()).thenReturn(conexionMock);


		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getTipoLocal()).thenReturn("test");

		spyControlador.navegarPanelComandas();

		verify(spyControlador, never()).controladorPanelComandasMostrarPanelComandas();
	}
	
	@Test
	public void navegarPanelAnalisis() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorInicioMock).when(spyControlador).makeControladorPanelInicio(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPedidosMock).when(spyControlador).makeControladorPanelPedidos(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelRegistroMock).when(spyControlador).makeControladorPanelRegistro(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelAprovisionamientoMock).when(spyControlador)
				.makeControladorPanelAprovisionamiento(any(Modelo.class), any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelTicketsMock).when(spyControlador).makeControladorPanelTickets(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelFacturasMock).when(spyControlador).makeControladorPanelFacturas(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelAnalisisMock).when(spyControlador).makeControladorPanelAnalisis(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		
		when(modeloMock.getConexion()).thenReturn(conexionMock);


		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getTipoLocal()).thenReturn("test");

		spyControlador.navegarPanelAnalisis();

		verify(spyControlador).controladorPanelAnalisisMostrarPanelAnalisis();
	}

}
