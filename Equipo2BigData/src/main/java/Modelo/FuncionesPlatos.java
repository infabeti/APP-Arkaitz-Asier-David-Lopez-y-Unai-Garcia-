package Modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FuncionesPlatos {

	private Modelo modelo;
	
	public FuncionesPlatos(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public double cantidadTotalPlatos(String cantidad, String producto, double total) {
		ListaPlatos listaPlatos = this.modelo.getListaPlatos();
		int cantidadInt = Integer.parseInt(cantidad);
		double precioTotalProducto = cantidadInt * listaPlatos.precioProductoString(producto);
		total = total + precioTotalProducto;
		BigDecimal bd = BigDecimal.valueOf(total);
	    bd = bd.setScale(2, RoundingMode.HALF_DOWN);
	    total = bd.doubleValue();
		return total;
	}
	
	public String funcionalidadAnnadirPlato(String plato) {
		ListaPlatos listaPlatos = modelo.getListaPlatos();
		Plato plat = listaPlatos.devolverPlatoPorString(plato);
		ListaPlatos listaTemporal = modelo.getListaTemporalPlatos();
		listaTemporal.addPlato(plat);
		return plat.toString();
	}
	
	public double funcionalidadeliminarPlato(int pos, String eliminar, double total) {
		ListaPlatos listaPlatos = modelo.getListaTemporalPlatos();
		int cantidad = modelo.cogerCantidadString(eliminar);
		double precio = listaPlatos.getPrecioPlato(pos);
		total = total - (precio * cantidad);
		BigDecimal bd = BigDecimal.valueOf(total);
	    bd = bd.setScale(2, RoundingMode.HALF_DOWN);
	    total = bd.doubleValue();
		listaPlatos.eliminarPlato(pos);
		return total;
	}
	
	public String[] funcionalidadAnadirPlato(String plato, String cantidad, double total) {
		String[] devolver = new String[2];
		devolver[0] = cantidad + " " + funcionalidadAnnadirPlato(plato);
		devolver[1] = String.valueOf(cantidadTotalPlatos(cantidad, plato, total));
		return devolver;
	}
	
}
