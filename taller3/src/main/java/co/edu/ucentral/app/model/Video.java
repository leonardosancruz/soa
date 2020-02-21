package co.edu.ucentral.app.model;

import java.util.Date;

public class Video {
	private int id;
	private String name;
	private String description;
	private Date date;
	private int categoria;
	private String path;
	private String status;

	public Video(int id, String name, String description, Date date, int categoria, String path, String status) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.categoria = categoria;
		this.path = path;
		this.status = status;
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

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
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
		return "Video [id=" + id + ", name=" + name + ", date=" + date + ", path=" + path + ", status=" + status + "]";
	}

}
