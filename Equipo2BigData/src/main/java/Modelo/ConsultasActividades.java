package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import principal.Consultas;
import principal.Inserciones;
import principal.SentenciasBBDD;

public class ConsultasActividades {
	
	private Modelo modelo;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();
	private Consultas consultas = new Consultas();
	private Inserciones inserciones = new Inserciones();
	
	public ConsultasActividades(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public ResultadosHistorico[] conseguirDatosNaiveBayesLocal(String NIF) {
		Connection conn = modelo.getConexion().getConn();
		ResultadosHistorico[] listaResultados = new ResultadosHistorico[3];
		try {
			ejecutarNaiveBayesLocal(NIF);
			PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.OBTENERHISTORICOLOCAL);
			st.setString(1, NIF);
			ResultSet rs = consultas.realizarConsulta(st);
			int cuenta = 0;
			while(rs.next()) {
				int codAl1 = rs.getInt(1);
				int codAl2 = rs.getInt(2);
				String fecha = rs.getDate(3).toString();
				float probabilidad = rs.getFloat(4);
				ResultadosHistorico comb = new ResultadosHistorico(codAl1, codAl2, fecha, probabilidad);
				listaResultados[cuenta] = comb;
				cuenta++;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Ha habido un error al conectar con la base de datos");
			Arrays.fill(listaResultados, null);
		}
		return listaResultados;
	}
	
	public ResultadosHistorico[] conseguirDatosNaiveBayesGlobal() {
		Connection conn = modelo.getConexion().getConn();
		ResultadosHistorico[] listaResultados = new ResultadosHistorico[3];
		try {
			ejecutarNaiveBayesGlobal();
			PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.OBTENERHISTORICOGLOBAL);
			ResultSet rs = consultas.realizarConsulta(st);
			int cuenta = 0;
			while(rs.next()) {
				int codAl1 = rs.getInt(1);
				int codAl2 = rs.getInt(2);
				String fecha = rs.getDate(3).toString();
				float probabilidad = rs.getFloat(4);
				ResultadosHistorico comb = new ResultadosHistorico(codAl1, codAl2, fecha, probabilidad);
				listaResultados[cuenta] = comb;
				cuenta++;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Ha habido un error al conectar con la base de datos");
			Arrays.fill(listaResultados, null);
		}
		return listaResultados;
	}
	
	public void ejecutarNaiveBayesLocal(String NIF) {
		try {
			int max = this.conseguirProductoMaximo();
			try {
				Connection conn = modelo.getConexion().getConn();
				for(int i = 1 ; i<=max;i++) {
					for(int j = 1 ; j<=max;j++) {
						if(i!=j) {
								CallableStatement cs = conn.prepareCall(sentenciasBBDD.NAIVEESPECIFICO);
								cs.setString(1, NIF);
								cs.setInt(2, i);
								cs.setInt(3, j);
								inserciones.ejecutarFuncion(cs);
								cs.close();
							}
						}
					}
				conn.close();
			}
			catch(Exception e) {
				System.out.println("Ha habido un error al ejecutar la funcion");
			}
		}
		catch(Exception e) {
			System.out.println("Ha habido un error al conectarse a la base de datos");
		}	
	}
	
	public void ejecutarNaiveBayesGlobal () {
		try {
			int max = this.conseguirProductoMaximo();
			try {
				Connection conn = modelo.getConexion().getConn();
				for(int i = 1 ; i<=max;i++) {
					for(int j = 1 ; j<=max;j++) {
						if(i!=j) {
							CallableStatement cs = conn.prepareCall(sentenciasBBDD.NAIVEGLOBAL);
							cs.setInt(1, i);
							cs.setInt(2, j);
							inserciones.ejecutarFuncion(cs);
							cs.close();
						}
					}
				}
			conn.close();
		}
		catch(Exception e) {
			System.out.println("Ha habido un error al ejecutar la funcion");
		}
	}
	catch(Exception e) {
		System.out.println("Ha habido un error al conectarse a la base de datos");
	}	
	}
	
	public int conseguirProductoMaximo() {
		Connection conn = this.modelo.getConexion().getConn();
		try {
			PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(sentenciasBBDD.CANTIDADPRODUCTOS);
			ResultSet rs = consultas.realizarConsulta(st);
			rs.next();
			int max = rs.getInt("maximo");
			conn.close();
			return max;
		}
		catch(Exception e) {
			return 0;
		}
	}
}