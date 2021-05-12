package Controlador;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import Modelo.Combinacion;
import Modelo.Modelo;
import Modelo.Usuario;
import Modelo.Escritor;
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
		Path path = Paths.get("historico");
		String[][] listaString = new String[3][4];
		this.modelo.utiles.rellenarArrayDobleString(listaString, "",3,4);
		try{
			if (!Files.exists(path)) 		           
				{Files.createDirectory(path);}
			DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HHmmss");
			Calendar cal = Calendar.getInstance();
			String DiaHora =dateFormat.format(cal.getTime());
			FileWriter fich = new FileWriter("historico\\AlgoritmoNaiveBayesEspecifico-"+DiaHora+"-"+NIF+".csv");
		
			Combinacion[] listaCombinaciones = this.modelo.consultasActividades.conseguirDatosNaiveBayes(NIF);
			int cuenta = 0;
			while(cuenta < 3 && listaCombinaciones[cuenta] != null) {
				listaString[cuenta][0] = this.modelo.consultasSimples.obtenerNombreCodAl(listaCombinaciones[cuenta].getCodAl1());
				listaString[cuenta][1] = this.modelo.consultasSimples.obtenerNombreCodAl(listaCombinaciones[cuenta].getCodAl2());
				listaString[cuenta][2] = listaCombinaciones[cuenta].getFecha();
				listaString[cuenta][3] = Float.toString(listaCombinaciones[cuenta].getProbabilidad()*100)+"%";	
				cuenta++;
			}
			this.modelo.escritor.escribirHistoricoLocal(listaString,NIF,fich);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return listaString;
	}

	public String[][] accionadoBottonMostrarProdGeneral() {
		String[][] listaString = new String[10][4];
		this.modelo.utiles.rellenarArrayDobleString(listaString, "",10,4);
		try {
			Path path = Paths.get("historico");

			if (!Files.exists(path)) 		           
				Files.createDirectory(path);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HHmmss");
			Calendar cal = Calendar.getInstance();
			String DiaHora =dateFormat.format(cal.getTime());
			FileWriter fich = new FileWriter("historico\\AlgoritmoNaiveBayesGeneral-"+DiaHora+".csv");
			Combinacion[] listaCombinaciones = this.modelo.consultasActividades.conseguirDatosNaiveBayes("");
			int cuenta = 0;
			while(cuenta < 10 && listaCombinaciones[cuenta] != null) {
				listaString[cuenta][0] = this.modelo.consultasSimples.obtenerNombreCodAl(listaCombinaciones[cuenta].getCodAl1());
				listaString[cuenta][1] = this.modelo.consultasSimples.obtenerNombreCodAl(listaCombinaciones[cuenta].getCodAl2());
				listaString[cuenta][2] = listaCombinaciones[cuenta].getFecha();
				listaString[cuenta][3] = Float.toString(listaCombinaciones[cuenta].getProbabilidad()*100)+"%";
				cuenta++;
			}
			this.modelo.escritor.escribirHistoricoGeneral(listaString, fich);
		}
			
		catch(Exception e) {
			e.printStackTrace();
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
