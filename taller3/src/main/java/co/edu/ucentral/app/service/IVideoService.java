package co.edu.ucentral.app.service;

import java.util.List;

import co.edu.ucentral.app.model.Clasificacion;
import co.edu.ucentral.app.model.Video;

public interface IVideoService {

	public List<Video> selectAll();

	public Video searchById(int idVideo);

	public void insert(Video video);

	public List<String> crearEstatus();

	public List<Clasificacion> selectClasificacion();
}
