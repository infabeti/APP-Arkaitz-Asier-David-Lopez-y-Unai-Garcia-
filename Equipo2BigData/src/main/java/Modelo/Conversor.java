package Modelo;

import java.util.ArrayList;
import java.sql.Date;

public class Conversor {
	
	public Conversor() {}
	
	public ListaProductos listaStringAProductos(ArrayList<String[]> listaString) {
		ListaProductos listaP = new ListaProductos();
		for(int i = 0; i<listaString.size(); i++ ) {
			String[] arrayString = listaString.get(i);
			String nombre = arrayString[0];
			double pCompra = Double.parseDouble(arrayString[1]);
			double pVenta = Double.parseDouble(arrayString[2]);
			String tipo = arrayString[3];
			Date feCad = Date.valueOf(arrayString[4]);
			Producto prod = new Producto(nombre, feCad, tipo, pCompra, pVenta);
			listaP.addProducto(prod);
		}
		return listaP;
	}
	
	public ListaPlatos listaStringAPlatos(ArrayList<String[]> listaString) {
		ListaPlatos listaP = new ListaPlatos();
		for(int i = 0; i<listaString.size(); i++) {
			String[] arrayString = listaString.get(i);
			String nombre = arrayString[0];
			double PVP = Double.parseDouble(arrayString[1]);
			Plato plat = new Plato(nombre, PVP);
			listaP.addPlato(plat);
		}
		return listaP;
	}
	
	public ListaProductos listaStringAAlimentos(ArrayList<String[]> listaString) {
		ListaProductos listaP = new ListaProductos();
		for(int i = 0; i<listaString.size(); i++ ) {
			String[] arrayString = listaString.get(i);
			String nombre = arrayString[0];
			double pCompra = Double.parseDouble(arrayString[1]);
			String tipo = arrayString[2];
			Date feCad = Date.valueOf(arrayString[3]);
			Producto prod = new Producto(nombre, feCad, tipo, pCompra);
			listaP.addProducto(prod);
		}
		return listaP;
	}
	
	public Usuario listaStringAUser(String[] listaString) {
		Usuario usuario = new Usuario(listaString[0], listaString[1], listaString[2], listaString[3]);
		return usuario;
	}
	
}
