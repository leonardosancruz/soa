package co.edu.ucentral.app.service;

import java.util.List;

import co.edu.ucentral.app.model.Clasificacion;

public interface IClasificacionService {
	public List<Clasificacion> selectAll();

	public Clasificacion searchById(int idClasificacion);

	public void insert(Clasificacion clasificacion);

	public void update(Clasificacion clasificacion);

	public void delete(int idClasificacion);

}
