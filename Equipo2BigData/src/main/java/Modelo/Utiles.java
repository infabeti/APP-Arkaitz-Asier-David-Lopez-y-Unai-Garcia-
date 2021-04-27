package Modelo;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import principal.ConsultasListas;

public class Utiles {
	
	private Modelo modelo;
	
	public Utiles(Modelo modelo) {
		this.modelo = modelo;
	}

	public void inicializarListaProductos() {
		ConsultasListas consultasListas = new ConsultasListas(modelo.getConexion());
		ListaProductos listaProductos = modelo.conversor.listaStringAProductos(consultasListas.cogerProductosLocal("2345678J"));
		this.modelo.setListaProductos(listaProductos);
	}

	public String getFechaHoraSys() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm");
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		return dateFormat.format(date);
	}

	public int cogerCantidadString(String linea) {
		int punt = 0;
		for (int i = 0; linea.charAt(i) != ' '; i++) {
			punt = i;
		}
		punt++;
		int cantidad = Integer.parseInt(linea.substring(0, punt));
		return cantidad;
	}
	
}
