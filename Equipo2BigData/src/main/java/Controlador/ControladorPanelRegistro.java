package Controlador;

import Modelo.Modelo;
import Vista.PanelRegistro;
import Vista.Vista;
import principal.Inserciones;

public class ControladorPanelRegistro {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelRegistro panelRegistro;
	private Inserciones inserciones;

	public ControladorPanelRegistro(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
		this.inserciones = new Inserciones(modelo.getConexion());
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

	public void accionadoBottonVolverPanelInicio() {
		this.controlador.navegarPanelInicio();
	}

	public void insertarRegistro(String DNI, String Nombre, String Apellido, String contrasena, String nif) {
		inserciones.insertarRegistro(DNI, Nombre, Apellido, contrasena, nif);
	}

	public String comprobarCamposRegistro(String nombre, String apellido, String nif, String dni, String password) {
		return this.modelo.getRegistro().comprobarCamposRegistro(nombre, apellido, nif, dni, password);
	}

	public PanelRegistro makePanelRegistro(ControladorPanelRegistro controladorPanelRegistro) {
		return new PanelRegistro(controladorPanelRegistro);
	}

}
