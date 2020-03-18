package co.edu.ucentral.app.model;

import java.util.Date;

public class Detalle {

	public String autor;
	private Date fechaFilmacion;

	public Detalle() {}
	
	public Detalle(String autor, Date fechaFilmacion, String resumen) {
		super();
		this.autor = autor;
		this.fechaFilmacion = fechaFilmacion;
		this.resumen = resumen;
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getFechaFilmacion() {
		return fechaFilmacion;
	}

	public void setFechaFilmacion(Date fechaFilmacion) {
		this.fechaFilmacion = fechaFilmacion;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	private String resumen;
}
