package Modelo;

public class Modelo {

	private ListaProductos listaProductos = new ListaProductos();
	private ListaPlatos listaPlatos = new ListaPlatos();
	private Usuario user;
	public FuncionesProductos funProd;
	public FuncionesPlatos funPlat;
	private Registro registro;
	public Validaciones validaciones;
	private principal.Conexion conexion = new principal.Conexion("3306");
	private ListaProductos listaTemporal = new ListaProductos();
	private ListaPlatos listaTemporalPlatos = new ListaPlatos();
	public java.sql.Connection conexionConn = conexion.getConn();
	public Conversor conversor = new Conversor();
	public Utiles utiles;
	public ConsultasSimples consultasSimples;
	public ConsultasComprobaciones consultasComprobaciones;
	public ConsultasListas consultasListas;
	public InsercionesSimples insercionesSimples;
	public InsercionesActividades insercionesActividades;
	
	public Registro getRegistro() {
		return registro;
	}

	public Modelo() {
		user = new Usuario();
		funProd = new FuncionesProductos(this);
		funPlat = new FuncionesPlatos(this);
		registro = new Registro(this);
		validaciones = new Validaciones(this);
		utiles = new Utiles(this);
		consultasSimples = new ConsultasSimples(this);
		consultasComprobaciones = new ConsultasComprobaciones(this);
		consultasListas = new ConsultasListas(this);
		insercionesSimples = new InsercionesSimples(this);
		insercionesActividades = new InsercionesActividades(this);
	}

	public void setConexion(principal.Conexion conexion) {
		this.conexion = conexion;
	}

	public principal.Conexion getConexion() {
		return this.conexion;
	}

	public void setListaTemporal(ListaProductos listaTemporal) {
		this.listaTemporal = listaTemporal;
	}

	public ListaProductos getListaTemporal() {
		return this.listaTemporal;
	}
	
	public void setListaTemporalPlatos(ListaPlatos listaTemporalPlatos) {
		this.listaTemporalPlatos = listaTemporalPlatos;
	}
	
	public ListaPlatos getListaTemporalPlatos() {
		return this.listaTemporalPlatos;
	}

	public ListaProductos getListaProductos() {
		return this.listaProductos;
	}
	
	public void setListaProductos(ListaProductos listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	public ListaPlatos getListaPlatos() {
		return this.listaPlatos;
	}
	
	public void setListaPlatos(ListaPlatos listaPlatos) {
		this.listaPlatos = listaPlatos;
	}

	public Usuario getUser() {
		return this.user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
}
