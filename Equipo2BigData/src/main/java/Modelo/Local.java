package Modelo;

import java.util.ArrayList;

public class Local {
	
	private String NIF;
	private String nombre;
	private String direccion;
	private String tipoNegocio;
	private ArrayList<Actividad> listaAct = new ArrayList<Actividad>();
	private ArrayList<ProductoTienda> listaProd = new ArrayList<ProductoTienda>();
		
	public Local(String NIF, String nombre, String direccion, String tipoNegocio) {
		this.NIF = NIF;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tipoNegocio = tipoNegocio;
	}

	public String getNIF() {
		return this.NIF;
	}

	public void setNIF(String NIF) {
		this.NIF = NIF;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipoNegocio() {
		return this.tipoNegocio;
	}

	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}
	
	public ArrayList<Actividad> getListaAct(){
		return this.listaAct;
	}
	
	public boolean addActividad(Actividad act) {
		boolean ok = listaAct.add(act);
		return ok;
	}
	
	public boolean addProdTienda(ProductoTienda prod) {
		boolean ok = listaProd.add(prod);
		return ok;
	}
	
	public Actividad buscarActividad(int numTransaccion) {
		Actividad act = new Actividad(numTransaccion);
		int indice = listaAct.indexOf(act);
		if(indice >=0) {
			act = listaAct.get(indice);
		}
		else {
			act = null;
		}
		return act;
	}
	
	public ProductoTienda buscarProdTienda(String nombre) {
		Producto prod = new Producto(nombre);
		ProductoTienda prodT = new ProductoTienda(prod,0);
		int indice = listaProd.indexOf(prodT);
		if(indice >= 0) {
			prodT = listaProd.get(indice);
		}
		else {
			prodT = null;
		}
		return prodT;
	}
	
	public boolean eliminarActividad(int numTransaccion) {
		Actividad act = buscarActividad(numTransaccion);
		boolean ok = false;
		if(act != null) {
			ok = listaAct.remove(act);
		}
		return ok;
	}
	
	public boolean eliminarProdTienda(String nombre) {
		ProductoTienda prod = buscarProdTienda(nombre);
		boolean ok = false;
		if(prod != null) {
			ok = listaProd.remove(prod);
		}
		return ok;
	}
		
}
