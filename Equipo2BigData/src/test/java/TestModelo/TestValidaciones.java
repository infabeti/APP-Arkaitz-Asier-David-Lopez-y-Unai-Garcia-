package TestModelo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Modelo.Validaciones;

public class TestValidaciones {
	
	private Validaciones validaciones = new Validaciones();
	private String resultadoString, resultadoEsperadoString;
	private boolean resultadoBoolean, resultadoEsperadoBoolean;
	
	
	@Test
	public void TestDevolverFechaFormateada() {

		resultadoString = validaciones.devolverFechaFormateada("01/03/2021 21:12");

		resultadoEsperadoString = "2021-03-01 21:12";

		assertEquals(resultadoEsperadoString, resultadoString);

	}
	
	@Test
	public void TestComprobarNifTRUE() {

		String nif = "12345678M";

		resultadoBoolean = validaciones.comprobarNif(nif);

		resultadoEsperadoBoolean = true;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}

	@Test
	public void TestComprobarNifFALSE() {

		String nif = "ESTO NO ES UN NIF POR LO QUE ME DEVOLVERA FALSO";

		resultadoBoolean = validaciones.comprobarNif(nif);

		resultadoEsperadoBoolean = false;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}

	@Test
	public void TestComprobarFormatoNombreTODOTRUE() {

		String nombre = "Pepito";

		resultadoBoolean = validaciones.comprobarFormatoNombre(nombre);

		resultadoEsperadoBoolean = true;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}

	@Test
	public void TestComprobarFormatoNombreTODOFALSE() {

		String nombre = "1a";

		resultadoBoolean = validaciones.comprobarFormatoNombre(nombre);

		resultadoEsperadoBoolean = false;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}

	@Test
	public void TestComprobarFormatoNombreTRUEFALSE() {

		String nombre = "asdasdasdasdasdasdasdasdasdasdasdasdad";

		resultadoBoolean = validaciones.comprobarFormatoNombre(nombre);

		resultadoEsperadoBoolean = false;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}

	@Test
	public void TestComprobarFormatoNombreSEGUNDOIFFALSO() {

		String nombre = "ab";

		resultadoBoolean = validaciones.comprobarFormatoNombre(nombre);

		resultadoEsperadoBoolean = false;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}

	@Test
	public void TestComprobarFormatoApellidoTODOTRUE() {

		String apellido = "Pepito";
		
		resultadoBoolean = validaciones.comprobarFormatoApellido(apellido);

		resultadoEsperadoBoolean = true;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}

	@Test
	public void TestComprobarFormatoApellidoTODOFALSE() {

		String apellido = "P1";

		resultadoBoolean = validaciones.comprobarFormatoApellido(apellido);

		resultadoEsperadoBoolean = false;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}

	@Test
	public void TestComprobarFormatoApellidoTRUEFALSE() {

		String apellido = "ALFJKSDYHWBFMDKWENJJJFIJRHDUFIWELFNUIFGIOENFGOGNM";

		resultadoBoolean = validaciones.comprobarFormatoApellido(apellido);

		resultadoEsperadoBoolean = false;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}

	@Test
	public void TestComprobarFormatoApellidoSEGUNDOIFFALSO() {

		String apellido = "A";

		resultadoBoolean = validaciones.comprobarFormatoApellido(apellido);

		resultadoEsperadoBoolean = false;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}

	@Test
	public void TestContieneSoloLetrasTRUE() {

		String input = "hola";

		resultadoBoolean = validaciones.contieneSoloLetras(input);

		resultadoEsperadoBoolean = true;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}

	@Test
	public void TestContieneSoloLetrasFALSE() {

		String input = "123";

		resultadoBoolean = validaciones.contieneSoloLetras(input);

		resultadoEsperadoBoolean = false;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}
	
	@Test
	public void TestComprobarCamposStringTODOTRUE() {

		String NIF = "78945632C";
		String nombre = "Joni";
		String apellido = "Mela";
		

		resultadoBoolean = validaciones.comprobarCamposString(NIF, nombre, apellido);

		resultadoEsperadoBoolean = true;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}
	
	@Test
	public void TestComprobarCamposStringTODOFALSE() {

		String NIF = "A1D3";
		String nombre = "12 ";
		String apellido = "2 ";
		

		resultadoBoolean = validaciones.comprobarCamposString(NIF, nombre, apellido);

		resultadoEsperadoBoolean = false;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}
	
	@Test
	public void TestComprobarCamposStringFALSETRUETRUE() {

		String NIF = "A1D3";
		String nombre = "Abraham";
		String apellido = "Burguesa";
		

		resultadoBoolean = validaciones.comprobarCamposString(NIF, nombre, apellido);

		resultadoEsperadoBoolean = false;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}
	
	@Test
	public void TestComprobarCamposStringTRUEFALSETRUE() {

		String NIF = "78965478S";
		String nombre = "1";
		String apellido = "Burguesa";
		

		resultadoBoolean = validaciones.comprobarCamposString(NIF, nombre, apellido);

		resultadoEsperadoBoolean = false;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}
	
	@Test
	public void TestComprobarCamposStringTRUETRUEFALSE() {

		String NIF = "78965478S";
		String nombre = "Arrengamie";
		String apellido = "1";
		

		resultadoBoolean = validaciones.comprobarCamposString(NIF, nombre, apellido);

		resultadoEsperadoBoolean = false;

		assertEquals(resultadoEsperadoBoolean, resultadoBoolean);

	}

}
