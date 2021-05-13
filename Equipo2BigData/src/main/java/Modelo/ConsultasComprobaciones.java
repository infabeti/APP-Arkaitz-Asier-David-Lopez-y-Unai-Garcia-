package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import principal.Consultas;
import principal.SentenciasBBDD;

public class ConsultasComprobaciones {
	
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();
	private Modelo modelo;
	private Consultas consultas = new Consultas();

	public ConsultasComprobaciones(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public boolean comprobarSiExisteNIF(String nif) {
		Connection conn = modelo.getConexion().getConn();
		try {
			PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.CONSULTANIF);
			st.setString(1, nif);
			ResultSet rs = consultas.realizarConsulta(st);
			boolean resultado = rs.next();
			conn.close();
			return resultado;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean comprobarSiExisteComprador(String nif) {
		Connection conn = modelo.getConexion().getConn();
		try {
			PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conn)
					.prepareStatement(sentenciasBBDD.EXISTECOMPRADOR);
			st.setString(1, nif);
			ResultSet rs = consultas.realizarConsulta(st);
			boolean resultado = rs.next();
			conn.close();
			return resultado;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean comprobarSiExisteDNI(String nif) {
		Connection conn = modelo.getConexion().getConn();
		try {
			PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.CONSULATDNI);
			st.setString(1, nif);
			ResultSet rs = consultas.realizarConsulta(st);
			boolean resultado = rs.next();
			conn.close();
			return resultado;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public double consultaComprobarPrecio(String nombre) {
		try {
			Connection conn = modelo.getConexion().getConn();
			PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.CONSEGUIRPRECIOPRODUCTO);
			st.setString(1, nombre);
			ResultSet rs = consultas.realizarConsulta(st);
			try {
				rs.next();
				double resultado = rs.getDouble("PCompra");
				conn.close();
				return resultado;
			} catch (Exception e) {
				return 0.0;
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return 0.0;
		}
	}

}
