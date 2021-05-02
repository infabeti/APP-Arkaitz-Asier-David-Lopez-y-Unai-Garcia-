package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import principal.Conexion;
import principal.Consultas;
import principal.SentenciasBBDD;

public class ConsultasListas {
	
	private Conexion conexion;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();
	static final String Transaccion="select max(Transaccion) from actividad";
	
	public ConsultasListas(Conexion conexion) {
		this.conexion =  conexion;
	}
	
	public ArrayList<String[]> cogerProductosLocal(String NIFLocal) {
		ArrayList<String[]> listaProductos = new ArrayList<String[]>();
		
		try {
			PreparedStatement st = null;
			Consultas consultas = new Consultas(this.conexion);
			st = (PreparedStatement) ((java.sql.Connection) conexion.getConn()).prepareStatement(sentenciasBBDD.CONSULTAPRODUCTOLOCAL);
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
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return listaProductos;
	}
	
	public ArrayList<String[]> cogerProductosAprovisionamiento() {
		ArrayList<String[]> listaProductos = new ArrayList<String[]>();
		try {
			Consultas consultas = new Consultas(conexion);
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conexion.getConn())
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
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return listaProductos;
	}
	
	public ArrayList<String[]> cogerListaPlatos(String NIFLocal) {
		ArrayList<String[]> listaPlatos = new ArrayList<String[]>();
		try {
			Consultas consultas = new Consultas(conexion);
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conexion.getConn()).prepareStatement(
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
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return listaPlatos;
	}

}
