package TestControlador;

import Controlador.Controlador;
import Controlador.ControladorLogin;
import Controlador.ControladorPanelAprovisionamiento;
import Controlador.ControladorPanelComandas;
import Controlador.ControladorPanelFacturas;
import Controlador.ControladorPanelPedidos;
import Controlador.ControladorPanelRegistro;
import Controlador.ControladorPanelTickets;
import Modelo.Conexion;
import Modelo.Consultas;
import Modelo.ConsultasListas;
import Modelo.ListaPlatos;
import Modelo.ListaProductos;
import Modelo.Modelo;
import Modelo.Usuario;
import Vista.Vista;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class TestControlador {

	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private ControladorPanelPedidos controladorPanelPedidosMock = mock(ControladorPanelPedidos.class);
	private ControladorPanelRegistro controladorPanelRegistroMock = mock(ControladorPanelRegistro.class);
	private ControladorPanelAprovisionamiento controladorPanelAprovisionamientoMock = mock(
			ControladorPanelAprovisionamiento.class);
	private ControladorLogin controladorLoginMock = mock(ControladorLogin.class);
	private ControladorPanelTickets controladorPanelTicketsMock = mock(ControladorPanelTickets.class);
	private ControladorPanelFacturas controladorPanelFacturasMock = mock(ControladorPanelFacturas.class);
	private ControladorPanelComandas controladorPanelComandasMock = mock(ControladorPanelComandas.class);
	private Controlador spyControlador;
	private Usuario userMock = mock(Usuario.class);
	private Consultas consultasMock = mock(Consultas.class);
	private ConsultasListas consultasListasMock = mock(ConsultasListas.class);
	private Conexion conexionMock = mock(Conexion.class);
	private ListaPlatos listaPlatosMock = mock(ListaPlatos.class);
	private ListaProductos listaProductosMock = mock(ListaProductos.class);
	private String[] arrString = new String[] { "a", "b" };

	@Test
	public void navegarPanelLogin() {

		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorLoginMock).when(spyControlador).makeControladorPanelLogin(any(Modelo.class),
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

		spyControlador.navegarPanelLogin();

		verify(spyControlador).controladorLoginMostrarPanelLogin();
	}

	@Test
	public void navegarPanelRegistro() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorLoginMock).when(spyControlador).makeControladorPanelLogin(any(Modelo.class),
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
		doReturn(controladorLoginMock).when(spyControlador).makeControladorPanelLogin(any(Modelo.class),
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

		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		when(consultasMock.leerNumTransBBDD()).thenReturn(66);

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		spyControlador.navegarPanelPedidos();

		verify(spyControlador).controladorPanelPedidosMostrarPanelPedidos();
	}

	@Test
	public void navegarPanelPedidosCAFETERIA() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorLoginMock).when(spyControlador).makeControladorPanelLogin(any(Modelo.class),
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

		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		when(consultasMock.leerNumTransBBDD()).thenReturn(66);

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		spyControlador.navegarPanelPedidos();

		verify(spyControlador).controladorPanelPedidosMostrarPanelPedidos();
	}

	@Test
	public void navegarPanelPedidosBAR() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorLoginMock).when(spyControlador).makeControladorPanelLogin(any(Modelo.class),
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

		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		when(consultasMock.leerNumTransBBDD()).thenReturn(66);
		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		spyControlador.navegarPanelPedidos();

		// NO PUEDO VERIFICAR QUE ENTRE YA QUE NO DEBE ENTRAR
	}

	@Test
	public void navegarPanelTickets() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorLoginMock).when(spyControlador).makeControladorPanelLogin(any(Modelo.class),
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

		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		when(consultasMock.leerNumTransBBDD()).thenReturn(66);
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
		doReturn(controladorLoginMock).when(spyControlador).makeControladorPanelLogin(any(Modelo.class),
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
		doReturn(controladorLoginMock).when(spyControlador).makeControladorPanelLogin(any(Modelo.class),
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

		when(modeloMock.getConsultas()).thenReturn(consultasMock);
		
		when(modeloMock.getConsultasListas()).thenReturn(consultasListasMock);

		when(consultasMock.leerNumTransBBDD()).thenReturn(66);
		when(consultasListasMock.cogerProductosAprovisionamiento()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getTipoLocal()).thenReturn("test");

		spyControlador.navegarPanelAprovisionamiento();

		verify(spyControlador).controladorPanelAprovisionamientoMostrarPanelAprovisionamiento();
	}

	@Test
	public void navegarPanelFacturas() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorLoginMock).when(spyControlador).makeControladorPanelLogin(any(Modelo.class),
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

		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		when(consultasMock.leerNumTransBBDD()).thenReturn(66);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getTipoLocal()).thenReturn("test");

		spyControlador.navegarPanelFacturas();

		verify(spyControlador).controladorPanelFacturasMostrarPanelFacturas();
	}

	@Test
	public void navegarPanelComandas() {
		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorLoginMock).when(spyControlador).makeControladorPanelLogin(any(Modelo.class),
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

		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		when(consultasMock.leerNumTransBBDD()).thenReturn(66);
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
		doReturn(controladorLoginMock).when(spyControlador).makeControladorPanelLogin(any(Modelo.class),
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

		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		when(consultasMock.leerNumTransBBDD()).thenReturn(66);

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);

		when(modeloMock.getUser()).thenReturn(userMock);

		when(userMock.getTipoLocal()).thenReturn("test");

		spyControlador.navegarPanelComandas();

		// NO TENGO QUE VERIFICAR QUE ENTRE YA QUE NO PUEDE HACERLO
	}

}
