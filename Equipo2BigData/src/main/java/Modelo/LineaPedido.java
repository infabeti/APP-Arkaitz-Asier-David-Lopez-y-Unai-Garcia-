package Modelo;

public class LineaPedido {

	private int cantidad;
	private double total;
	private Producto producto;

	public LineaPedido(Producto producto, int cantidad, double total) {

		this.producto = producto;
		this.cantidad = cantidad;
		this.total = total;
	}	

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	 @Override
	 public String toString() {
		return this.getCantidad() + " x " + this.producto.getNombre() + " " + this.getTotal() + "€";
		 
	 }

}
