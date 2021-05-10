package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import principal.Consultas;
import principal.Inserciones;
import principal.SentenciasBBDD;

public class ConsultasActividades {
	
	private Modelo modelo;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();
	
	public ConsultasActividades(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public Combinacion[] conseguirDatosNaiveBayes(String NIF) {
		Connection conn = modelo.getConexion().getConn();
		PreparedStatement st = null;
		Combinacion[] listaCombinaciones = new Combinacion[10]; //10 porque el máximo de combinaciones que se puede devolver es 10
		try {
			ejecutarNaiveBayes(NIF);
			if(NIF.equals("")) {
				st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.OBTENERHISTORICOGLOBAL);
			}
			else {
				st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.OBTENERHISTORICOLOCAL);
				st.setString(1, NIF);
			}
			Consultas consultas = new Consultas();
			ResultSet rs = consultas.realizarConsulta(st);
			int cuenta = 0;
			while(rs.next()) {
				int codAl1 = rs.getInt(1);
				int codAl2 = rs.getInt(2);
				String fecha = rs.getDate(3).toString();
				float probabilidad = rs.getFloat(4);
				Combinacion comb = new Combinacion(codAl1, codAl2, fecha, probabilidad);
				listaCombinaciones[cuenta] = comb;
				cuenta++;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCombinaciones;
	}
	
	public void ejecutarNaiveBayes(String NIF) {
		Connection conn = modelo.getConexion().getConn();
		PreparedStatement st = null;
		try {
			st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.CANTIDADPRODUCTOS);
			Consultas consultas = new Consultas();
			Inserciones inserciones = new Inserciones(modelo.getConexion());
			ResultSet rs = consultas.realizarConsulta(st);
			int max = rs.getInt("maximo");
			conn.close();
			st.close();
			try {
				conn = modelo.getConexion().getConn();
				CallableStatement cs = null;
				for(int i = 0; i<=max;i++) {
					for(int j = 0; i<=max;i++) {
						if(i!=j) {
							if(NIF.equals("")) {
								cs = conn.prepareCall(sentenciasBBDD.NAIVEGLOBAL);
								cs.setInt(1, i);
								cs.setInt(2, j);
								inserciones.ejecutarFuncion(cs);
							}
							else {
								cs = conn.prepareCall(sentenciasBBDD.NAIVEESPECIFICO);
								cs.setString(1, NIF);
								cs.setInt(2, i);
								cs.setInt(3, j);
								inserciones.ejecutarFuncion(cs);
							}
						}
					}
				}
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}
}