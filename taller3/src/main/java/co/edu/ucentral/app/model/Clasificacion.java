package co.edu.ucentral.app.model;

public class Clasificacion {
	
	private int id;
	private String nombre;

	public Clasificacion() {
		// TODO Auto-generated constructor stub
	}

	public Clasificacion(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
