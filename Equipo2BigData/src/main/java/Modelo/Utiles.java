package Modelo;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utiles {
	
	private Modelo modelo;
	
	public Utiles(Modelo modelo) {
		this.modelo = modelo;
	}

	public void inicializarListaProductos() {
		ListaProductos listaProductos = modelo.conversor.listaStringAProductos(this.modelo.consultasListas.cogerProductosLocal(modelo.getUser().getNifLocal()));
		if (listaProductos == null) {
			listaProductos = new ListaProductos();
			Producto prod = new Producto("Error en la base de datos");
			listaProductos.addProducto(prod);
		}
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
	
	public String[][] rellenarArrayDobleString(String[][] array, String valor,int primeraLongitud, int segundaLongitud) {
		for(int i = 0; i < primeraLongitud; i++) {
			for(int j = 0; j < segundaLongitud; j++){
				array[i][j] = valor;
			}
		}
		return array;
	}
	
}
