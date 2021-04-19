package Modelo;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {
	
	public Validaciones() {}
	
	public boolean comprobarNif(String nif) {
		boolean correcto = false;
		Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
		Matcher matcher = pattern.matcher(nif);
		if (matcher.matches()) {
			correcto = true;
		} else {
			correcto = false;
		}
		return correcto;
	}

	public boolean comprobarFormatoNombre(String nombre) {
		// Comprobar tamano nombre y apellido
		// nombre es un varchar de 20, por ello comprobamos el length
		if (contieneSoloLetras(nombre) && nombre.length() <= 20) {
			if (nombre.length() >= 3) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}

	public boolean comprobarFormatoApellido(String apellido) {
		// Comprobar tamano nombre y apellido
		// nombre es un varchar de 20, por ello comprobamos el length
		if (contieneSoloLetras(apellido) && apellido.length() <= 25) {
			if (apellido.length() >= 2) {
				return true;
			}
			return false;
		} else {

			return false;
		}
	}
	
	public boolean comprobarCamposString(String NIF, String nombre, String apellido) {
		if(comprobarNif(NIF) && comprobarFormatoNombre(nombre) && comprobarFormatoApellido(apellido)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean contieneSoloLetras(String cadena) {
		for (int x = 0; x < cadena.length(); x++) {
			char c = cadena.charAt(x);
			// Si no est� entre a y z, ni entre A y Z, ni es un espacio
			if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
				return false;
			}
		}
		return true;
	}
	
	public String devolverFechaFormateada(String input) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String dateInString = input;
		try {
			java.util.Date date1 = formatter.parse(dateInString);
			return (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error";
	}

}
