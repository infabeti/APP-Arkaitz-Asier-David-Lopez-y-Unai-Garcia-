package Modelo;

import java.sql.Date;

public class Pedido extends Actividad {

	private String domicilio;
	
	public Pedido(int numTransaccion, Date fecha, String local) {
		super(numTransaccion, fecha, local);
		
	}
	
	public Pedido(int numTransaccion, Date fecha, String local,String domicilio) {
		super(numTransaccion, fecha, local);
		this.domicilio = domicilio;
	}

	public boolean esDomicilio() {
		if(this.domicilio != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	
	
	

}
