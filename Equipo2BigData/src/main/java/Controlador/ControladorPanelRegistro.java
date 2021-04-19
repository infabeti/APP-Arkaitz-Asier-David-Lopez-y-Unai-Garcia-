package Controlador;

import Modelo.Modelo;
import Vista.PanelRegistro;
import Vista.Vista;

public class ControladorPanelRegistro {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelRegistro panelRegistro;

	public ControladorPanelRegistro(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public Vista getVista() {
		return vista;
	}

	public Controlador getControlador() {
		return controlador;
	}

	public void mostrarPanelRegistro() {
		this.panelRegistro = makePanelRegistro(this);
		this.vista.mostrarPanel(this.panelRegistro);
	}

	public void accionadoBottonVolverPanelLogin() {
		this.controlador.navegarPanelLogin();
	}

	public void insertarRegistro(String DNI, String Nombre, String Apellido, String contrasena, String nif) {
		this.modelo.getInserciones().insertarRegistro(DNI, Nombre, Apellido, contrasena, nif);
	}

	public String comprobarCamposRegistro(String nombre, String apellido, String nif, String dni, String password) {
		return this.modelo.getRegistro().comprobarCamposRegistro(nombre, apellido, nif, dni, password);
	}

	public PanelRegistro makePanelRegistro(ControladorPanelRegistro controladorPanelRegistro) {
		return new PanelRegistro(controladorPanelRegistro);
	}

}
