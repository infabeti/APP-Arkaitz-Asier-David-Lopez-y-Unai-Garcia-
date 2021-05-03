package Controlador;
import Modelo.Modelo;
import Modelo.Usuario;
import Vista.PanelAnalisis;
import Vista.Vista;

public class ControladorPanelAnalisis {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelAnalisis panelAnalisis;

	public ControladorPanelAnalisis(Modelo modelo, Vista vista, Controlador controlador) {
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

	public void mostrarPanelAnalisis() {
		this.panelAnalisis = makePanelAnalisis(this);
		this.vista.mostrarPanel(this.panelAnalisis);
	}
	
	public String conseguirLocal() {
		return this.modelo.getUser().getNifLocal();
	}

	public void accionadoBottonMostrarProdLocal() {
		this.controlador.navegarPanelInicio();
	}

	public void accionadoBottonMostrarProdGeneral() {
		this.controlador.navegarPanelInicio();
	}

	public void accionadoBottonDesconectarPanelAnalisis() {
		this.controlador.navegarPanelInicio();
	}
	
	public PanelAnalisis makePanelAnalisis(ControladorPanelAnalisis controladorPanelAnalisis) {
		Usuario user = this.modelo.getUser();
		return new PanelAnalisis(controladorPanelAnalisis, user.getTipoLocal(), user.getNombre(), user.getLocal());
	}

}
