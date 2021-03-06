package co.edu.ucentral.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Videos")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private Date date;
	// @Transient
	@ManyToOne
	@JoinColumn(name = "idCategoria")
	private Clasificacion categoria;
	private String path = "software.png";
	private String status;
	// @Transient
	@OneToOne
	@JoinColumn(name = "idDetalle")
	private Detalle detalle;

	public Video() {

	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Clasificacion getCategoria() {
		return categoria;
	}

	public void setCategoria(Clasificacion categoria) {
		this.categoria = categoria;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + ", categoria="
				+ categoria + ", path=" + path + ", status=" + status + ", detalle=" + detalle + "]";
	}

}
