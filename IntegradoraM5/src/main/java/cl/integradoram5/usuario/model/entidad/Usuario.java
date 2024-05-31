package cl.integradoram5.usuario.model.entidad;

public class Usuario {
	private int id;
	private String nombre;
	private int saldoDisponible;
	
	
	public Usuario() {}
	
	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
	}	
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", saldoDisponible=" + saldoDisponible + "]";
	}

	public Usuario(String nombre, int saldoDisponible) {
		super();
		this.nombre = nombre;
		this.saldoDisponible = saldoDisponible;
	}

	public Usuario(int id, String nombre, int saldoDisponible) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.saldoDisponible = saldoDisponible;
	}
	
	public int getId() {
		return id;
	}

	public int setId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(int saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}
}
