package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import principal.Conexion;
import principal.Consultas;
import principal.SentenciasBBDD;

public class ConsultasComprobaciones {
	
	private Conexion conexion;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();

	public ConsultasComprobaciones(Conexion conexion) {
		this.conexion = conexion;
	}
	
	public boolean comprobarSiExisteNIF(String nif) {

		PreparedStatement st = null;
		try {
			st = (PreparedStatement) ((java.sql.Connection) conexion.getConn()).prepareStatement(sentenciasBBDD.CONSULTANIF);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return consultaReal(st, nif);
	}

	public boolean comprobarSiExisteComprador(String nif) {
		PreparedStatement st = null;
		try {
			st = (PreparedStatement) ((java.sql.Connection) conexion.getConn())
					.prepareStatement(sentenciasBBDD.EXISTECOMPRADOR);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return consultaReal(st, nif);
	}

	public boolean comprobarSiExisteDNI(String nif) {
		PreparedStatement st = null;
		try {
			st = (PreparedStatement) ((java.sql.Connection) conexion.getConn()).prepareStatement(sentenciasBBDD.CONSULATDNI);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return consultaReal(st, nif);
	}

	public boolean consultaReal(PreparedStatement st, String nif) {
		try {
			Consultas consultas = new Consultas(conexion);
			st.setString(1, nif);
			ResultSet rs = consultas.realizarConsulta(st);

			return rs.next();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return false;
	}
	
	public double consultaComprobarPrecio(String nombre) {
		try {
			Consultas consultas = new Consultas(conexion);
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conexion.getConn()).prepareStatement(sentenciasBBDD.CONSEGUIRPRECIOPRODUCTO);
			st.setString(1, nombre);
			ResultSet rs = consultas.realizarConsulta(st);
			try {
				rs.next();
				return rs.getDouble("PCompra");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return 0.0;
	}

}
