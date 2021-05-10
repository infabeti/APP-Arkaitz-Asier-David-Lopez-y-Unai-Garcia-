package TestControlador;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;

import Controlador.Controlador;
import Controlador.ControladorPanelAnalisis;
import Modelo.Combinacion;
import Modelo.ConsultasActividades;
import Modelo.ConsultasSimples;
import Modelo.Modelo;
import Modelo.Usuario;
import Vista.Vista;
import principal.Conexion;

public class TestControladorPanelAnalisis {
	
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private Usuario userMock = mock(Usuario.class);
	private Conexion conexionMock = mock(Conexion.class);
	private ConsultasSimples consultasSimplesMock = mock(ConsultasSimples.class);
	private ConsultasActividades consultasActividadesMock = mock(ConsultasActividades.class);
	private ControladorPanelAnalisis controladorPanelAnalisis = new ControladorPanelAnalisis(modeloMock, vistaMock, controladorMock);
	private Combinacion combinacionMock = mock(Combinacion.class);
	
	@Before
	public void setNecesarios() {
		modeloMock.consultasSimples = consultasSimplesMock;
		when(consultasSimplesMock.obtenerNombreCodAl(1)).thenReturn("patata");
		when(consultasSimplesMock.obtenerNombreCodAl(2)).thenReturn("banana");
		modeloMock.consultasActividades = consultasActividadesMock;
		when(combinacionMock.getCodAl1()).thenReturn(1);
		when(combinacionMock.getCodAl2()).thenReturn(2);
		when(combinacionMock.getFecha()).thenReturn("1-1-2021");
		when(combinacionMock.getProbabilidad()).thenReturn((float) 1.1);
		when(modeloMock.getUser()).thenReturn(userMock);
	}
	
	@Test
	public void testAccionadoBottonMostrarProductoLocal() {
		String NIF = "23456789J";
		Combinacion[] listaComb = {combinacionMock};
		when(consultasActividadesMock.conseguirDatosNaiveBayes("23456789J")).thenReturn(listaComb);
		String[] listaResultado = controladorPanelAnalisis.accionadoBottonMostrarProdLocal(NIF);
		assertEquals("patata banana 1-1-2021 1.1%", listaResultado[0]);
	}
	
	@Test
	public void testAccionadoBottonMostrarProductoGlobal() {
		Combinacion[] listaComb = {combinacionMock};
		when(consultasActividadesMock.conseguirDatosNaiveBayes("")).thenReturn(listaComb);
		String[] listaResultado = controladorPanelAnalisis.accionadoBottonMostrarProdGeneral();
		assertEquals("patata banana 1-1-2021 1.1%", listaResultado[0]);
	}
	
}
