package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import principal.Conexion;
import principal.Inserciones;
import principal.SentenciasBBDD;

public class InsercionesActividades {

	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();
	private Modelo modelo;

	public InsercionesActividades(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public void insertarActividad(int transaccion, String fecha, String tipo, String nif) {
		try {
			Connection conn = this.modelo.getConexion().getConn();
			PreparedStatement st = null;

			st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.INSERTARACTIVIDAD);
			st.setInt(1, transaccion);
			st.setString(2, fecha);
			st.setDouble(3, 0);
			st.setString(4, tipo);
			st.setString(5, nif);
			try {
				Inserciones inserciones = new Inserciones(this.modelo.getConexion());
				inserciones.realizarInsercion(st);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
	public void insertarPedido(int transaccion, String domicilio) {
		try {
			Connection conn = this.modelo.getConexion().getConn();
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.INSERTARPEDIDO);
			try {
				st.setInt(1, transaccion);
				if (domicilio.equalsIgnoreCase("")) {
					st.setNull(2, Types.NULL);
				} else {
					st.setString(2, domicilio);
				}
				Inserciones inserciones = new Inserciones(this.modelo.getConexion());
				inserciones.realizarInsercion(st);
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
	public void insertarFactura(int transaccion, String nif) {
		try {
			Connection conn = this.modelo.getConexion().getConn();
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.INSERTARFACTURA);
			st.setInt(1, transaccion);
			st.setString(2, nif);
			try {
				Inserciones inserciones = new Inserciones(this.modelo.getConexion());
				inserciones.realizarInsercion(st);
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
	public boolean insertarComanda(int transaccion) {
		try {
			Connection conn = this.modelo.getConexion().getConn();
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.INSERTARCOMANDA);
			try {
				st.setInt(1, transaccion);	
				Inserciones inserciones = new Inserciones(this.modelo.getConexion());
				inserciones.realizarInsercion(st);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return false;
		}
	}
	public boolean insertarAprovisionamiento(int transaccion) {
		try {
			Connection conn = this.modelo.getConexion().getConn();
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.INSERTARAPROVISIONAMIENTO);
			try {
				st.setInt(1, transaccion);
				Inserciones inserciones = new Inserciones(this.modelo.getConexion());
				inserciones.realizarInsercion(st);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return false;
		}
	}

	public void ejecutarFuncion(int transaccion) {
		Inserciones inserciones = new Inserciones(this.modelo.getConexion());
		inserciones.ejecutarFuncion(transaccion);
	}
	
}
