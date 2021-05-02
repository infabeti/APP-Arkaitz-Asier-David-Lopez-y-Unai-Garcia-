package Controlador;

import Modelo.Modelo;
import Vista.Vista;

	
public interface ControladorInterfaz {
	
	void accionadoBottonVolverPanelPrincipal();
	
	public Modelo getModelo();
	
	public Vista getVista();
	
	public Controlador getControlador();
	
	

}
