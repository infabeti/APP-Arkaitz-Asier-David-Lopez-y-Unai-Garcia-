package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import principal.Consultas;
import principal.SentenciasBBDD;

public class ConsultasListas {
	
	private Modelo modelo;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();
	private Consultas consultas = new Consultas();
	
	public ConsultasListas(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public ArrayList<String[]> cogerProductosLocal(String NIFLocal) {
		ArrayList<String[]> listaProductos = new ArrayList<String[]>();
		try {
			Connection conn = modelo.getConexion().getConn();
			PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.CONSULTAPRODUCTOLOCAL);
			st.setString(1, NIFLocal);
			ResultSet rs = consultas.realizarConsulta(st);
			
			int cuenta = 0;
			String nombre, pCompra, pVenta, tipo, feCad = "";
			while (rs.next()) {
				String[] datosProducto = new String[5];
				nombre = rs.getString("a.nombre");
				datosProducto[0] = nombre;
				pCompra = Double.toString(rs.getDouble("a.PCompra"));
				datosProducto[1] = pCompra;
				pVenta = Double.toString(rs.getDouble("p.PVenta"));
				datosProducto[2] = pVenta;
				tipo = rs.getString("a.Tipo");
				datosProducto[3] = tipo;
				feCad = rs.getDate("a.FeCad").toString();
				datosProducto[4] = feCad;
				listaProductos.add(cuenta, datosProducto);
				cuenta++;
			}
			conn.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return null;
		}
		return listaProductos;
	}
	
	public ArrayList<String[]> cogerProductosAprovisionamiento() {
		ArrayList<String[]> listaProductos = new ArrayList<String[]>();
		try {
			Connection conn = this.modelo.getConexion().getConn();
			PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conn)
					.prepareStatement(sentenciasBBDD.ALIMENTOORDENADO);
			ResultSet rs = consultas.realizarConsulta(st);
			String nombre, pCompra, tipo, feCad = "";
			while (rs.next()) {
				String[] datosProducto = new String[4];
				nombre = rs.getString("a.nombre");
				datosProducto[0] = nombre;
				pCompra = Double.toString(rs.getDouble("a.PCompra"));
				datosProducto[1] = pCompra;
				tipo = rs.getString("a.Tipo");
				datosProducto[2] = tipo;
				feCad = rs.getDate("a.FeCad").toString();
				datosProducto[3] = feCad;
				listaProductos.add(datosProducto);
			}
			conn.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return listaProductos;
		}
		return listaProductos;
	}
	
	public ArrayList<String[]> cogerListaPlatos(String NIFLocal) {
		ArrayList<String[]> listaPlatos = new ArrayList<String[]>();
		try {
			Connection conn = this.modelo.getConexion().getConn();
			PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(
					sentenciasBBDD.PLATOJOINCARTA);
			st.setString(1, NIFLocal);
			ResultSet rs = consultas.realizarConsulta(st);
			while (rs.next()) {
				String[] datosPlato = new String[2];
				String nombre = rs.getString("p.Nombre");
				datosPlato[0] = nombre;
				String pvp = Double.toString(rs.getDouble("p.pvp"));
				datosPlato[1] = pvp;
				listaPlatos.add(datosPlato);
			}
			conn.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return listaPlatos;
		}
		return listaPlatos;
	}

}
