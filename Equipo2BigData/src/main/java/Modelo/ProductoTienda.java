package Modelo;

public class ProductoTienda {
	
	private Producto prod;
	private int cantidad = 0;
	
	
	public ProductoTienda(Producto prod, int cantidad) {
		this.prod = prod;
		this.cantidad = cantidad;
	}

	public Producto getProd() {
		return this.prod;
	}

	public void setProd(Producto prod) {
		this.prod = prod;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public int addCantidad(int cantidad) { //Suma cantidad a la cantidad del producto y devuelve el nuevo stock
		this.cantidad = this.cantidad + cantidad;
		return this.cantidad;
	}
	
	public int restarCantidad(int cantidad) { 
		/*
		 * Resta cantidad a la cantidad del producto y devuelve el nuevo stock. Nunca puede ser menos de 0.
		 * Si la cantidad resultante fuese < 0, devuelve el stock que falta en negativo.
		 */
		int devolver = 0;
		if(this.cantidad < cantidad) {
			this.cantidad = 0;
			devolver = this.cantidad - cantidad;
		}
		else {
			this.cantidad = this.cantidad - cantidad;
			devolver = this.cantidad;
		}
		return devolver;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) { 
            return true; 
        }
		
		if (!(o instanceof ProductoTienda)) { 
            return false; 
        }
		
		ProductoTienda prod = (ProductoTienda) o;
		
		return this.getProd().getNombre() == prod.getProd().getNombre();
		
	}
	
	@Override
	public String toString() {
		return this.prod.toString() + " Cantidad:" + cantidad;
	}
	
}
