package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import principal.Consultas;
import principal.SentenciasBBDD;

public class ConsultasActividades {
	
	private Modelo modelo;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();
	
	public ConsultasActividades(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public void conseguirDatosActividades() {
		Connection conn = modelo.getConexion().getConn();
		PreparedStatement st = null;
		try {
			//st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.DATOSACTIVIDADES);
			Consultas consultas = new Consultas();
			ResultSet rs = consultas.realizarConsulta(st);
			ArrayList<Actividad> actividades = new ArrayList<Actividad>();
			int transaccion = -1;
			Actividad a = null;
			while(rs.next()) {
				if(rs.getInt("transaccion") != transaccion) {
					a = new Actividad(rs.getInt("a.transaccion"), rs.getDate("a.fecha"), rs.getString("a.NIF"));
					Producto p = new Producto(rs.getString("nombre"));
				}
				else {
					Producto p = new Producto(rs.getString("nombre"));
					a.getListaProductos().addProducto(p);
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
