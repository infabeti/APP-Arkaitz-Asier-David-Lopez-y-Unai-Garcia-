package Modelo;

public class Registro {
	
	private Modelo modelo;
	
	public Registro(Modelo modelo) {
		this.modelo = modelo;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public boolean comprobarBBDDnif(String nif) {
		return this.modelo.getConsultasComprobaciones().comprobarSiExisteNIF(nif);
	}

	public boolean comprobarBBDDdni(String dni) {
		return this.modelo.getConsultasComprobaciones().comprobarSiExisteDNI(dni);
	}

	public boolean comprobarNif(String nif) {
		return this.modelo.validaciones.comprobarNif(nif);
	}

	public String comprobarCamposRegistro(String nombre, String apellido, String nif, String dni, String password) {

		boolean okNombre = comprobarFormatoNombre(nombre);
		boolean okApellido = comprobarFormatoApellido(apellido);
		boolean okNif = comprobarNif(nif);
		boolean  okDni = comprobarNif(dni);
		boolean  okComprobarBBDDnif= comprobarBBDDnif(nif);
		boolean  okComprobarBBDDdni= comprobarBBDDdni(dni);
		boolean  okPass= comprobarContraNoVacia(password);
		String devolver = "";
		
		if (okNombre && okApellido && okNif && okDni && okComprobarBBDDnif && !okComprobarBBDDdni && okPass){
			return devolver;
		} else {
			if (okNombre == false) {
				devolver += "El nombre no puede contener caracteres que no sean letras ni puede ser mayor de 20 caracteres ni menor que 3";
			}
			else if (okApellido == false) {
				devolver += "\nEl Apellido no puede contener caracteres que no sean letras ni puede ser mayor de 25 caracteres ni menor que 2";
			}
			else if (okDni == false) {
				devolver += "\nEl dni introducido es incorrecto";
			}
			else if (okNif == false) {
				devolver += "\nEl nif introducido es incorrecto";
			}
			else if (okComprobarBBDDnif == false) {
				devolver += "\nEl nif introducido no pertenece a ningun local";
			}
			else if (okComprobarBBDDdni) {
				devolver += "\nEl dni introducido ya existe en la BBDD";
			}
			else if (okPass == false) {
				devolver += "\nla contrase�a tiene que tener un minimo de 5 caracteres";
			}
			return devolver;
		}
	}

	public boolean comprobarFormatoNombre(String nombre) {
		return this.modelo.validaciones.comprobarFormatoNombre(nombre);
	}

	public boolean comprobarContraNoVacia(String pass) {		
		return pass.length() >= 5;
	}

	public boolean comprobarFormatoApellido(String apellido) {
		return this.modelo.validaciones.comprobarFormatoApellido(apellido);
	}

	public boolean contieneSoloLetras(String cadena) {
		return this.modelo.validaciones.contieneSoloLetras(cadena);
	}
	
}
