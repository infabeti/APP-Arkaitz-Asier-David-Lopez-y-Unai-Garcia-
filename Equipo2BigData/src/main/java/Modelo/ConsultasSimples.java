package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import principal.Conexion;
import principal.SentenciasBBDD;
import principal.Consultas;

public class ConsultasSimples {
	
	private Conexion conexion;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();

	public ConsultasSimples(Conexion conexion) {
		this.conexion = conexion;
	}
	
	public String[] login(String dni, String password) {
		try {
			Consultas consultas = new Consultas(conexion);
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conexion.getConn()).prepareStatement(sentenciasBBDD.CONSULTALOGUEAR);
			st.setString(1, dni);
			st.setString(2, password);
			ResultSet rs = consultas.realizarConsulta(st);
			if (rs.next()) {
				String nombre = rs.getString("nombre");
				String local = rs.getString("es.nombre");
				String tipoNegocio = rs.getString("tipoNegocio");
				String NIF = rs.getString("NIF");
				String[] user = {nombre, local, tipoNegocio, NIF};
				return user;
			} else {
				String[] user = {"", "", "", ""};
				return user;
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		String[] user = {"", "", "", ""};
		return user;
	}
	
	public int obtenerStock(String nif, String codigoAlimento) {
		int cantidadActual = 0;
		try {
			Consultas consultas = new Consultas(this.conexion);
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) this.conexion.getConn())
					.prepareStatement(sentenciasBBDD.CONSEGUIRCANTIDADSTOCK);
			st.setString(1, codigoAlimento);
			st.setString(2, nif);
			ResultSet rs = consultas.realizarConsulta(st);
			while (rs.next()) {
				cantidadActual = rs.getInt("cantidad");
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return cantidadActual;
	}
	
	public String obtenerCodigoAlimentoProducto(String producto) {
		try {
			Consultas consultas = new Consultas(conexion);
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conexion.getConn()).prepareStatement(sentenciasBBDD.CONSULTAALIMENTO);
			ResultSet rs = consultas.realizarConsulta(st);
			try {
				while (rs.next()) {
					if (rs.getString("nombre").equalsIgnoreCase(producto)) {
						return rs.getString("codigoalimento");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return null;
	}

	public String obtenerCodigoPlato(String plato) {
		try {
			Consultas consultas = new Consultas(conexion);
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conexion.getConn())
					.prepareStatement(sentenciasBBDD.CONSULTAPLATO);
			ResultSet rs = consultas.realizarConsulta(st);
			try {
				while (rs.next()) {
					if (rs.getString("nombre").equalsIgnoreCase(plato)) {
						return rs.getString("codigoplato");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return null;
	}

}
