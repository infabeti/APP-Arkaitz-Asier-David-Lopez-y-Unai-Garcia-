package Modelo;

public interface InterfazListas {
	
	public boolean limpiarLista();
	
	public boolean eliminarElemento(int pos);
	
	public double getPrecioElementoPosicion(int pos);
	
	public String[] convertirListaAString();
	
	public int devolverPosElementoString(String nombre);
	
	public double precioElementoString(String nombre);
}
