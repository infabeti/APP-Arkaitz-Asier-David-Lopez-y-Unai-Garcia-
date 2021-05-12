package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import principal.Consultas;
import principal.SentenciasBBDD;

public class ConsultasSimples {
	
	private Modelo modelo;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();

	public ConsultasSimples(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public String[] login(String dni, String password) {
		try {
			Connection conn = this.modelo.getConexion().getConn();
			Consultas consultas = new Consultas();
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.CONSULTALOGUEAR);
			st.setString(1, dni);
			st.setString(2, password);
			ResultSet rs = consultas.realizarConsulta(st);
			if (rs.next()) {
				String nombre = rs.getString("nombre");
				String local = rs.getString("es.nombre");
				String tipoNegocio = rs.getString("tipoNegocio");
				String NIF = rs.getString("NIF");
				String[] user = {nombre, local, tipoNegocio, NIF};
				conn.close();
				return user;
			} else {
				String[] user = {"", "", "", ""};
				conn.close();
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
			Connection conn = this.modelo.getConexion().getConn();
			Consultas consultas = new Consultas();
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conn)
					.prepareStatement(sentenciasBBDD.CONSEGUIRCANTIDADSTOCK);
			st.setString(1, codigoAlimento);
			st.setString(2, nif);
			ResultSet rs = consultas.realizarConsulta(st);
			while (rs.next()) {
				cantidadActual = rs.getInt("cantidad");
			}
			conn.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return cantidadActual;
	}
	
	public String obtenerCodigoAlimentoProducto(String producto) {
		try {
			Connection conn = this.modelo.getConexion().getConn();
			Consultas consultas = new Consultas();
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.CONSULTAALIMENTO);
			ResultSet rs = consultas.realizarConsulta(st);
			try {
				while (rs.next()) {
					if (rs.getString("nombre").equalsIgnoreCase(producto)) {
						String devolver = rs.getString("codigoalimento");
						conn.close();
						return devolver;
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
			Connection conn = this.modelo.getConexion().getConn();
			Consultas consultas = new Consultas();
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conn)
					.prepareStatement(sentenciasBBDD.CONSULTAPLATO);
			ResultSet rs = consultas.realizarConsulta(st);
			try {
				while (rs.next()) {
					if (rs.getString("nombre").equalsIgnoreCase(plato)) {
						String devolver = rs.getString("codigoplato");
						conn.close();
						return devolver;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return "0";
	}
	
	public int leerNumTransBBDD() {
		try {
			Connection conn = this.modelo.getConexion().getConn();
			Consultas consultas = new Consultas();
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conn)
					.prepareStatement(sentenciasBBDD.CONSULTAACTIVIDAD);
			ResultSet rs = consultas.realizarConsulta(st);
			int numero = 1;
			try {
				while (rs.next()) {
					numero++;
				}
				conn.close();
				return numero;
			} catch (Exception e) {
				e.printStackTrace();
				conn.close();
				return 0;
			}
		} catch (SQLException sqlException) {
			return 0;
		}
	}
	
	public String obtenerNombreCodAl(int codAl) {
		String devolver = "";
		try {
			Connection conn = this.modelo.getConexion().getConn();
			Consultas consultas = new Consultas();
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conn)
					.prepareStatement(sentenciasBBDD.NOMBRECODIGO);
			st.setInt(1, codAl);
			ResultSet rs = consultas.realizarConsulta(st);
			try {
				rs.next();
				devolver = rs.getString(1);
				conn.close();
				return devolver;
			} catch (Exception e) {
				e.printStackTrace();
				conn.close();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return devolver;
	}

}
