package Controlador;

import Modelo.Modelo;
import Modelo.Usuario;
import Vista.PanelInicio;
import Vista.Vista;
import principal.Consultas; import principal.ConsultasListas;

public class ControladorInicio implements ControladorInterfaz {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelInicio panelInicio;
	private Consultas consultas;
	private ConsultasListas consultasListas;

	public ControladorInicio(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
	}
	@Override
	public Modelo getModelo() {
		return modelo;
	}
	@Override
	public Vista getVista() {
		return vista;
	}
	@Override
	public Controlador getControlador() {
		return controlador;
	}

	public void mostrarPanelInicio() {
		this.panelInicio = makePanelInicio(this);
		this.vista.mostrarPanel(this.panelInicio);
	}
	@Override
	public void accionadoBottonVolverPanelPrincipal() {
		this.controlador.navegarPanelPrincipal();
	}

	public void accionadoBottonRegistroPanelInicio() {
		this.controlador.navegarPanelRegistro();
	}

	public boolean login(String user, String password) {
		consultas = new Consultas(modelo.getConexion());
		consultasListas = new ConsultasListas(modelo.getConexion());

		Usuario res = modelo.conversor.listaStringAUser(this.consultas.login(user, password));

		this.modelo.setUser(res);
		if (res.getNombre().equals("")) {
			return false;
		} else {
			this.modelo.utiles.inicializarListaProductos();
			if (this.modelo.getUser().getTipoLocal().equals("RESTAURANTE")) {
				this.modelo.setListaPlatos(modelo.conversor.listaStringAPlatos(this.consultasListas.cogerListaPlatos(this.modelo.getUser().getNifLocal())));
			}
			return true;
		}
	}

	public PanelInicio makePanelInicio(ControladorInicio controladorInicio) {
		return new PanelInicio(controladorInicio);
	}

}
