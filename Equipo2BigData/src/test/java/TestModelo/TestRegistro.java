package TestModelo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import Modelo.ConsultasComprobaciones;
import Modelo.Modelo;
import Modelo.Registro;
import Modelo.Validaciones;

public class TestRegistro {

	private Modelo modeloMock = mock(Modelo.class);
	private Validaciones validacionesMock = mock(Validaciones.class);
	private Registro registro = new Registro(modeloMock);
	private ConsultasComprobaciones consultasComprobacionesMock = mock(ConsultasComprobaciones.class);
	
	@Test
	public void testConstructor() {
		assertEquals(modeloMock ,registro.getModelo());
		
	}
	
	@Test
	public void testcomprobarBBDDnif() {
		String nif = "78965321S";
		
		when(modeloMock.getConsultasComprobaciones()).thenReturn(consultasComprobacionesMock);
		when(consultasComprobacionesMock.comprobarSiExisteNIF(nif)).thenReturn(true);

		
		assertEquals(true , registro.comprobarBBDDnif(nif));
		
	}
	
	@Test
	public void testcomprobarBBDDdni() {
		String dni = "18932321S";
		
		when(modeloMock.getConsultasComprobaciones()).thenReturn(consultasComprobacionesMock);
		when(consultasComprobacionesMock.comprobarSiExisteDNI(dni)).thenReturn(false);

		
		assertEquals(false , registro.comprobarBBDDdni(dni));
		
	}
	
	@Test
	public void testcomprobarNif() {
		String dni = "18932321S";
				
		modeloMock.validaciones = validacionesMock;
		
		when(validacionesMock.comprobarNif(dni)).thenReturn(false);

		
		assertEquals(false , registro.comprobarNif(dni));
		
	}
	
	@Test
	public void testContieneSoloLetras() {
		String input = "abc";
		
		modeloMock.validaciones = validacionesMock;
		
		when(validacionesMock.contieneSoloLetras(input)).thenReturn(false);

		
		assertEquals(false , registro.contieneSoloLetras(input));
		
	}
	
	@Test
	public void testcomprobarCamposRegistroTRUE() {
		
		String nombre = "jon";
		String apellido = "Lugoa";
		String nif = "78956321s";
		String dni = "45658965f"; 
		String password = "llegoal80";
		
		modeloMock.validaciones = validacionesMock;
		
		when(validacionesMock.comprobarNif(dni)).thenReturn(false);
		
		when(modeloMock.getConsultasComprobaciones()).thenReturn(consultasComprobacionesMock);

		
		when(registro.comprobarFormatoNombre(nombre)).thenReturn(true);
		when(registro.comprobarFormatoApellido(apellido)).thenReturn(true);
		when(registro.comprobarNif(nif)).thenReturn(true);
		when(registro.comprobarNif(dni)).thenReturn(true);
		when(registro.comprobarBBDDdni(dni)).thenReturn(false);
		when(registro.comprobarBBDDnif(nif)).thenReturn(true);
		

		String resultado = registro.comprobarCamposRegistro(nombre, apellido, nif, dni, password);
		
		assertEquals("", resultado);
		
	}
	
	@Test
	public void testcomprobarCamposRegistroCOMPROBARBBDDNIF() {
		
		String nombre = "jon";
		String apellido = "Lugoa";
		String nif = "78956321s";
		String dni = "45658965f"; 
		String password = "llegoal80";
		
		modeloMock.validaciones = validacionesMock;
		
		when(validacionesMock.comprobarNif(dni)).thenReturn(false);
		
		when(modeloMock.getConsultasComprobaciones()).thenReturn(consultasComprobacionesMock);

		
		when(registro.comprobarFormatoNombre(nombre)).thenReturn(true);
		when(registro.comprobarFormatoApellido(apellido)).thenReturn(true);
		when(registro.comprobarNif(nif)).thenReturn(true);
		when(registro.comprobarNif(dni)).thenReturn(true);
		when(registro.comprobarBBDDdni(dni)).thenReturn(false); //TENEMOS PUESTO COMO !=
		when(registro.comprobarBBDDnif(nif)).thenReturn(false);
		

		registro.comprobarCamposRegistro(nombre, apellido, nif, dni, password);
				
	}
	
	@Test
	public void testcomprobarCamposRegistroTOOFALSE() {
		
		String nombre = "jon";
		String apellido = "Lugoa";
		String nif = "78956321s";
		String dni = "45658965f"; 
		String password = "llegoal80";
		
		modeloMock.validaciones = validacionesMock;
		
		when(validacionesMock.comprobarNif(dni)).thenReturn(false);
		
		when(modeloMock.getConsultasComprobaciones()).thenReturn(consultasComprobacionesMock);

		
		when(registro.comprobarFormatoNombre(nombre)).thenReturn(false);
		when(registro.comprobarFormatoApellido(apellido)).thenReturn(false);
		when(registro.comprobarNif(nif)).thenReturn(false);
		when(registro.comprobarNif(dni)).thenReturn(false);
		when(registro.comprobarBBDDdni(dni)).thenReturn(true); //TENEMOS PUESTO COMO !=
		when(registro.comprobarBBDDnif(nif)).thenReturn(false);
		

		registro.comprobarCamposRegistro(nombre, apellido, nif, dni, password);
				
	}
	
	@Test
	public void testcomprobarCamposRegistroCOMPROBARAPELLIDO() {
		
		String nombre = "jon";
		String apellido = "Lugoa";
		String nif = "78956321s";
		String dni = "45658965f"; 
		String password = "llegoal80";
		
		modeloMock.validaciones = validacionesMock;
		
		when(validacionesMock.comprobarNif(dni)).thenReturn(false);
		
		when(modeloMock.getConsultasComprobaciones()).thenReturn(consultasComprobacionesMock);

		
		when(registro.comprobarFormatoNombre(nombre)).thenReturn(true);
		when(registro.comprobarFormatoApellido(apellido)).thenReturn(false);
		when(registro.comprobarNif(nif)).thenReturn(true);
		when(registro.comprobarNif(dni)).thenReturn(true);
		when(registro.comprobarBBDDdni(dni)).thenReturn(false); //TENEMOS PUESTO COMO !=
		when(registro.comprobarBBDDnif(nif)).thenReturn(true);
		

		registro.comprobarCamposRegistro(nombre, apellido, nif, dni, password);
				
	}
	
	@Test
	public void testcomprobarCamposRegistroCOMPROBARDNI() {
		
		String nombre = "jon";
		String apellido = "Lugoa";
		String nif = "78956321s";
		String dni = "45658965f"; 
		String password = "llegoal80";
		
		modeloMock.validaciones = validacionesMock;
		
		when(validacionesMock.comprobarNif(dni)).thenReturn(false);
		
		when(modeloMock.getConsultasComprobaciones()).thenReturn(consultasComprobacionesMock);

		
		when(registro.comprobarFormatoNombre(nombre)).thenReturn(true);
		when(registro.comprobarFormatoApellido(apellido)).thenReturn(true);
		when(registro.comprobarNif(nif)).thenReturn(true);
		when(registro.comprobarNif(dni)).thenReturn(false);
		when(registro.comprobarBBDDdni(dni)).thenReturn(false); //TENEMOS PUESTO COMO !=
		when(registro.comprobarBBDDnif(nif)).thenReturn(true);
		

		registro.comprobarCamposRegistro(nombre, apellido, nif, dni, password);
				
	}
	
	@Test
	public void testcomprobarCamposRegistroCOMPROBARNIF() {
		
		String nombre = "jon";
		String apellido = "Lugoa";
		String nif = "78956321s";
		String dni = "45658965f"; 
		String password = "llegoal80";
		
		modeloMock.validaciones = validacionesMock;
		
		when(validacionesMock.comprobarNif(dni)).thenReturn(false);
		
		when(modeloMock.getConsultasComprobaciones()).thenReturn(consultasComprobacionesMock);

		
		when(registro.comprobarFormatoNombre(nombre)).thenReturn(true);
		when(registro.comprobarFormatoApellido(apellido)).thenReturn(true);
		when(registro.comprobarNif(nif)).thenReturn(false);
		when(registro.comprobarNif(dni)).thenReturn(true);
		when(registro.comprobarBBDDdni(dni)).thenReturn(false); //TENEMOS PUESTO COMO !=
		when(registro.comprobarBBDDnif(nif)).thenReturn(true);
		

		registro.comprobarCamposRegistro(nombre, apellido, nif, dni, password);
				
	}
	
	@Test
	public void testcomprobarCamposRegistroCOMPROBARBBDDDNI() {
		
		String nombre = "jon";
		String apellido = "Lugoa";
		String nif = "78956321s";
		String dni = "45658965f"; 
		String password = "asadasdasdasdasdasdasdsa";
		
		modeloMock.validaciones = validacionesMock;
		
		when(validacionesMock.comprobarNif(dni)).thenReturn(false);
		
		when(modeloMock.getConsultasComprobaciones()).thenReturn(consultasComprobacionesMock);

		
		when(registro.comprobarFormatoNombre(nombre)).thenReturn(true);
		when(registro.comprobarFormatoApellido(apellido)).thenReturn(true);
		when(registro.comprobarNif(nif)).thenReturn(true);
		when(registro.comprobarNif(dni)).thenReturn(true);
		when(registro.comprobarBBDDdni(dni)).thenReturn(true); //TENEMOS PUESTO COMO !=
		when(registro.comprobarBBDDnif(nif)).thenReturn(true);
		

		registro.comprobarCamposRegistro(nombre, apellido, nif, dni, password);
				
	}
	
	@Test
	public void testcomprobarCamposRegistroCONTRA() {
		
		String nombre = "jon";
		String apellido = "Lugoa";
		String nif = "78956321s";
		String dni = "45658965f"; 
		String password = "a";
		
		modeloMock.validaciones = validacionesMock;
		
		when(validacionesMock.comprobarNif(dni)).thenReturn(false);
		
		when(modeloMock.getConsultasComprobaciones()).thenReturn(consultasComprobacionesMock);

		
		when(registro.comprobarFormatoNombre(nombre)).thenReturn(true);
		when(registro.comprobarFormatoApellido(apellido)).thenReturn(true);
		when(registro.comprobarNif(nif)).thenReturn(true);
		when(registro.comprobarNif(dni)).thenReturn(true);
		when(registro.comprobarBBDDdni(dni)).thenReturn(false); //TENEMOS PUESTO COMO !=
		when(registro.comprobarBBDDnif(nif)).thenReturn(true);
		

		registro.comprobarCamposRegistro(nombre, apellido, nif, dni, password);
				
	}
	
}
