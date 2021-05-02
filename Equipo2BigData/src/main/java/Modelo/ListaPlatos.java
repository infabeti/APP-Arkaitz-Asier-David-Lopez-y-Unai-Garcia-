package Modelo;

import java.util.ArrayList;

public class ListaPlatos implements InterfazListas {
	
	private ArrayList<Plato> listaP;
	
	public ListaPlatos() {
		listaP  = new ArrayList<Plato>();
	}
	
	public ArrayList<Plato> getListaP() {
		return listaP;
	}

	public boolean addPlato(Plato plat) {
		try {
			listaP.add(plat);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean limpiarLista() {
		try {
			listaP.clear();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean eliminarElemento(int pos) {
		try {
			listaP.remove(pos);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Plato cogerPlato(int pos) {
		return listaP.get(pos);
	}
	
	@Override
	public double getPrecioElementoPosicion(int pos) {
		return cogerPlato(pos).getPrecio();
	}
	
	@Override
	public String[] convertirListaAString() {
		String listaPlatosString[] = new String[listaP.size()];
		
		for(int i = 0; i < listaP.size(); i++) {
			listaPlatosString[i] = listaP.get(i).getNombre();
		}
		
		return listaPlatosString;
	}
	
	public Plato devolverPlatoPorString(String nombre) {
		for (int i = 0; i < listaP.size(); i++) {
			if(listaP.get(i).getNombre().equalsIgnoreCase(nombre)) {
				return listaP.get(i);
			}
		}
		return null;
	}
	
	@Override
	public int devolverPosElementoString(String nombre) { //Devuelve la posición de un producto dado su string
		for(int i = 0; i <listaP.size(); i++) {
			if(listaP.get(i).getNombre() == nombre) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public double precioElementoString(String nombre) {
		Plato plat = this.devolverPlatoPorString(nombre);
		if(plat != null) {
			return plat.getPrecio();
		}
		else {
			return -1;
		}
	}
	
}
