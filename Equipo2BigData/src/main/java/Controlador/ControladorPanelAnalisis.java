package Controlador;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

import Modelo.ResultadosHistorico;
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

	public String[][] accionadoBottonMostrarProdLocal(String NIF) {
		String[][] listaString = new String[3][4];
		try{
			String diaHora = this.modelo.escritor.crearCarpeta("historico");
			FileWriter fich = new FileWriter("historico\\AlgoritmoNaiveBayesEspecifico-"+diaHora+"-"+NIF+".csv");
			ResultadosHistorico[] listaResultados = this.modelo.consultasActividades.conseguirDatosNaiveBayesLocal(NIF);
			listaString = modelo.utiles.listaResultadosAString(listaResultados, 3);
			this.modelo.escritor.escribirHistorico(listaString,fich);
		}
		catch(Exception e) {
			String[][] listaError = {{"Se ha producido un error", "Compruebe que la base de datos esta conectada","",""}};
			return listaError;
		}
		return listaString;
	}

	public String[][] accionadoBottonMostrarProdGeneral() {
		String[][] listaString = new String[10][4];
		try {
			String diaHora = this.modelo.escritor.crearCarpeta("historico");
			FileWriter fich = new FileWriter("historico\\AlgoritmoNaiveBayesGeneral-"+diaHora+".csv");
			ResultadosHistorico[] listaResultados = this.modelo.consultasActividades.conseguirDatosNaiveBayesGlobal();
			listaString = modelo.utiles.listaResultadosAString(listaResultados, 10);
			this.modelo.escritor.escribirHistorico(listaString,fich);
		}
		catch(Exception e) {
			String[][] listaError = {{"Se ha producido un error", "Compruebe que la base de datos esta conectada","",""}};
			return listaError;
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
