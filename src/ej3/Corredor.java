package ej3;

public class Corredor {
	private String equipo;
	private  String nombre;
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Corredor(String nombre,String equipo ) {
		super();
		this.nombre = nombre;
		this.equipo = equipo;
	}
}
