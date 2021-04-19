package Controlador;

import Modelo.Modelo;
import Modelo.Usuario;

import Vista.PanelInicio;

import Vista.Vista;

public class ControladorInicio {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelInicio panelInicio;

	public ControladorInicio(Modelo modelo, Vista vista, Controlador controlador) {
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

	public void mostrarPanelInicio() {
		this.panelInicio = makePanelInicio(this);
		this.vista.mostrarPanel(this.panelInicio);
	}

	public void accionadoBottonAceptarPanelPrincipal() {
		this.controlador.navegarPanelPrincipal();
	}

	public void accionadoBottonRegistroPanelInicio() {
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

	public PanelInicio makePanelInicio(ControladorInicio controladorInicio) {
		return new PanelInicio(controladorInicio);
	}

}
