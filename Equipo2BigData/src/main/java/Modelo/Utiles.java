package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
	
	public String[][] arrayDoblesString(String valor,int primeraLongitud, int segundaLongitud) {
		String[][] array = new String[primeraLongitud][segundaLongitud];
		for(int i = 0; i < primeraLongitud; i++) {
			for(int j = 0; j < segundaLongitud; j++){
				array[i][j] = valor;
			}
		}
		return array;
	}
	
	public String[][] listaResultadosAString(ResultadosHistorico[] listaResultados, int maxArray){
		String[][] arrayString = this.arrayDoblesString("",maxArray, 4);
		int cuenta = 0;
		while(cuenta < maxArray && listaResultados[cuenta] != null) {
			arrayString[cuenta][0] = this.modelo.consultasSimples.obtenerNombreCodAl(listaResultados[cuenta].getCodAl1());
			arrayString[cuenta][1] = this.modelo.consultasSimples.obtenerNombreCodAl(listaResultados[cuenta].getCodAl2());
			arrayString[cuenta][2] = listaResultados[cuenta].getFecha();
			arrayString[cuenta][3] = Float.toString(listaResultados[cuenta].getProbabilidad()*100)+"%";
			cuenta++;
		}
		return arrayString;
	}
	
}
