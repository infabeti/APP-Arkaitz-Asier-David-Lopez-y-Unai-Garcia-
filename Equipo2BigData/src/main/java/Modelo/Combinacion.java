package Modelo;

public class Combinacion {
	
	private int codAl1;
	private int codAl2;
	private String fecha;
	private float probabilidad;
	
	public Combinacion(int codAl1, int codAl2, String fecha, float probabilidad) {
		this.codAl1 = codAl1;
		this.codAl2 = codAl2;
		this.fecha = fecha;
		this.probabilidad = probabilidad;
	}

	public int getCodAl1() {
		return codAl1;
	}

	public void setCodAl1(int codAl1) {
		this.codAl1 = codAl1;
	}

	public int getCodAl2() {
		return codAl2;
	}

	public void setCodAl2(int codAl2) {
		this.codAl2 = codAl2;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(float probabilidad) {
		this.probabilidad = probabilidad;
	}
	
	@Override
	public String toString() {
		return (this.codAl1 + " " + this.codAl2 + " " + this.fecha + " " + this.probabilidad);
	}
}
