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

	public ConsultasComprobaciones(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public boolean comprobarSiExisteNIF(String nif) {
		Connection conn = modelo.getConexion().getConn();
		PreparedStatement st = null;
		try {
			st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.CONSULTANIF);
			Consultas consultas = new Consultas();
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
		PreparedStatement st = null;
		try {
			st = (PreparedStatement) ((java.sql.Connection) conn)
					.prepareStatement(sentenciasBBDD.EXISTECOMPRADOR);
			Consultas consultas = new Consultas();
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
		PreparedStatement st = null;
		try {
			st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.CONSULATDNI);
			Consultas consultas = new Consultas();
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
			Consultas consultas = new Consultas();
			Connection conn = modelo.getConexion().getConn();
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.CONSEGUIRPRECIOPRODUCTO);
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
