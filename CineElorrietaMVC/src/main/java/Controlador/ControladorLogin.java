package Controlador;

import Modelo.Modelo;
import Modelo.Usuario;

import Vista.PanelLogin;

import Vista.Vista;

public class ControladorLogin {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelLogin panelLogin;

	public ControladorLogin(Modelo modelo, Vista vista, Controlador controlador) {
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

	public void mostrarPanelLogin() {
		this.panelLogin = makePanelLogin(this);
		this.vista.mostrarPanel(this.panelLogin);
	}

	public void accionadoBottonAceptarPanelPrincipal() {
		this.controlador.navegarPanelPrincipal();
	}

	public void accionadoBottonRegistroPanelLogin() {
		this.controlador.navegarPanelRegistro();
	}

	public boolean login(String user, String password) {

		Usuario res = this.modelo.getConsultas().login(user, password);

		this.modelo.setUser(res);
		if (res.getNombre().equals("")) {
			return false;
		} else {
			this.modelo.actualizarListaProductosLocal();
			if (this.modelo.getUser().getTipoLocal().equals("RESTAURANTE")) {
				this.modelo.setListaPlatos(this.modelo.getConsultasListas().cogerListaPlatos(this.modelo.getUser().getNifLocal()));
			}
			return true;
		}
	}

	public PanelLogin makePanelLogin(ControladorLogin controladorLogin) {
		return new PanelLogin(controladorLogin);
	}

}
