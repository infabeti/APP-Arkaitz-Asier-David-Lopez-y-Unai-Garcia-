package Controlador;
import Modelo.Combinacion;
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

	public String[] accionadoBottonMostrarProdLocal(String NIF) {
		Combinacion[] listaCombinaciones = this.modelo.consultasActividades.conseguirDatosNaiveBayes(NIF);
		String[] listaString = new String[3];
		int cuenta = 0;
		while(cuenta < 3 && listaCombinaciones[cuenta] != null) {
			String nombreA1 = this.modelo.consultasSimples.obtenerNombreCodAl(listaCombinaciones[cuenta].getCodAl1());
			String nombreA2 = this.modelo.consultasSimples.obtenerNombreCodAl(listaCombinaciones[cuenta].getCodAl2());
			String fecha = listaCombinaciones[cuenta].getFecha();
			float probabilidad = listaCombinaciones[cuenta].getProbabilidad();
			listaString[cuenta] = nombreA1 + " " + nombreA2 + " " + fecha + " " + probabilidad;
			cuenta++;
		}
		return listaString;
	}

	public String[] accionadoBottonMostrarProdGeneral() {
		Combinacion[] listaCombinaciones = this.modelo.consultasActividades.conseguirDatosNaiveBayes("");
		String[] listaString = new String[10];
		int cuenta = 0;
		while(cuenta < 10 && listaCombinaciones[cuenta] != null) {
			String nombreA1 = this.modelo.consultasSimples.obtenerNombreCodAl(listaCombinaciones[cuenta].getCodAl1());
			String nombreA2 = this.modelo.consultasSimples.obtenerNombreCodAl(listaCombinaciones[cuenta].getCodAl2());
			String fecha = listaCombinaciones[cuenta].getFecha();
			float probabilidad = listaCombinaciones[cuenta].getProbabilidad();
			listaString[cuenta] = nombreA1 + " " + nombreA2 + " " + fecha + " " + probabilidad;
			cuenta++;
		}
		return listaString;
	}

	public void accionadoBottonDesconectarPanelAnalisis() {
		this.controlador.navegarPanelInicio();
	}
	
	public PanelAnalisis makePanelAnalisis(ControladorPanelAnalisis controladorPanelAnalisis) {
		Usuario user = this.modelo.getUser();
		return new PanelAnalisis(controladorPanelAnalisis, user.getTipoLocal(), user.getNombre(), user.getLocal());
	}

}
