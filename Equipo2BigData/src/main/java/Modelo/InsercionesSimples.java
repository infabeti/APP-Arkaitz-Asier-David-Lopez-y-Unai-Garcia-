package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import principal.Conexion;
import principal.Consultas;
import principal.Inserciones;
import principal.SentenciasBBDD;

public class InsercionesSimples {
	
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();
	private Conexion conexion;
	private InsercionesActividades insercionesActividades;

	public InsercionesSimples(Conexion conexion) {
		this.conexion =  conexion;
		insercionesActividades = new InsercionesActividades(conexion);
	}

	public void insertarProductoActividad(int transaccion, String codigoAlimento, int cantidad, double precioFinal, String nifLocal, String fechaFormateada) {
		try {
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) this.conexion.getConn())
					.prepareStatement(sentenciasBBDD.INSERTARPRODUCTOACTIVIDAD);
			st.setString(1, codigoAlimento);
			st.setInt(2, transaccion);
			st.setInt(3, cantidad);
			st.setDouble(4, precioFinal);
			try {
				Inserciones inserciones = new Inserciones(conexion);
				inserciones.realizarInsercion(st);
				try {
					Consultas consultas = new Consultas(conexion);
					PreparedStatement st2 = null;
					st2 = (PreparedStatement) ((java.sql.Connection) this.conexion.getConn())
							.prepareStatement(sentenciasBBDD.COMPROBARSIESAPROVISIONAMIENTO);
					st2.setInt(1, transaccion);
					ResultSet rs = consultas.realizarConsulta(st2);
					rs.next();
					if (rs.getString("tipo").equalsIgnoreCase("aprovisionamiento")) {
						actualizarStockMenorQueCinco(codigoAlimento, nifLocal, transaccion, fechaFormateada);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (precioFinal != 0) {
					actualizarStockMenorQueCinco(codigoAlimento, nifLocal, transaccion, fechaFormateada);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	public void actualizarStockMenorQueCinco(String codigoAlimento, String nifLocal, int numTransaccion, String fechaFormateada) {

		try {
			Consultas consultas = new Consultas(conexion);
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) this.conexion.getConn())
					.prepareStatement(sentenciasBBDD.CODIGOALIMENTO);
			st.setString(1, codigoAlimento);
			st.setString(2, nifLocal);

			try {
				ResultSet rs = consultas.realizarConsulta(st);
				rs.next();
				int cantidad = rs.getInt("cantidad");
				if (cantidad < 5) {
					try {
						PreparedStatement st1 = null;
						st1 = (PreparedStatement) ((java.sql.Connection) this.conexion.getConn())
								.prepareStatement(sentenciasBBDD.PRECIOALIMENTO);
						st1.setString(1, codigoAlimento);
						ResultSet rs1 = consultas.realizarConsulta(st1);
						rs1.next();
						double pcompra = rs1.getDouble("PCompra");
						insercionesActividades.insertarActividad(numTransaccion+1, fechaFormateada, "aprovisionamiento", nifLocal);
						insercionesActividades.insertarAprovisionamiento(numTransaccion+1);
						insertarProductoActividad(numTransaccion+1, codigoAlimento, 50, pcompra, nifLocal, fechaFormateada);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	public void updateStock(String nif, String codigoAlimento, int cantidad) {

		try {
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) this.conexion.getConn())
					.prepareStatement(sentenciasBBDD.ACTUALIZARSTOCK);
			st.setInt(1, (cantidad + 50));
			st.setString(2, nif);
			st.setString(3, codigoAlimento);

			try {
				Inserciones inserciones = new Inserciones(conexion);
				inserciones.realizarInsercion(st);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	public void insertarComprador(String nif, String nombre, String apellido) {
		try {
			PreparedStatement st = null;

			st = (PreparedStatement) ((java.sql.Connection) this.conexion.getConn())
					.prepareStatement(sentenciasBBDD.INSERTARCOMPRADOR);
			st.setString(1, nif);
			st.setString(2, nombre);
			st.setString(3, apellido);
			try {
				Inserciones inserciones = new Inserciones(conexion);
				inserciones.realizarInsercion(st);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	public boolean insertarRegistro(String dni, String Nombre, String Apellido, String contrasena, String nif) {
		try {
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) this.conexion.getConn())
					.prepareStatement(sentenciasBBDD.INSERTAREMPLEADO);
			try {
				st.setString(1, dni);
				st.setString(2, Nombre);
				st.setString(3, Apellido);
				st.setString(4, contrasena);
				st.setString(5, nif);
				Inserciones inserciones = new Inserciones(conexion);
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

	public void insertarPlatoActividad(int transaccion, String codigoPlato, int cantidad) {
		try {
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) this.conexion.getConn())
					.prepareStatement("insert into lineaplato (codigoplato,transaccion,cantidad)" + " values("
							+ codigoPlato + "," + transaccion + "," + cantidad + ");");
			try {
				Inserciones inserciones = new Inserciones(conexion);
				inserciones.realizarInsercion(st);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

}
