package Modelo;

import java.sql.Date;

public class Actividad {

	private int numTransaccion;
	private Date fecha;
	private String local;

	public Actividad(int numTransaccion, Date fecha, String local) {
		this.numTransaccion = numTransaccion;
		this.fecha = fecha;
		this.local = local;
	}

	public int getNumTransaccion() {
		return this.numTransaccion;
	}

	public void setNumTransaccion(int numTransaccion) {
		this.numTransaccion = numTransaccion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getLocal() {
		return this.local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Actividad(int numTransaccion) { // Este constructor existe únicamente para crear una Actividad que solo
											// tiene el número de transacción y usarla para buscar en la lista ligada
		this.numTransaccion = numTransaccion;
	}

	@Override
	public boolean equals(Object o) {
		boolean ok = false;

		if (o != null && o instanceof Actividad) {
			ok = this.numTransaccion == ((Actividad) o).getNumTransaccion();
		}

		return ok;
	}

	@Override
	public String toString() {
		return this.local + " " + this.numTransaccion + " " + this.fecha;
	}
}
