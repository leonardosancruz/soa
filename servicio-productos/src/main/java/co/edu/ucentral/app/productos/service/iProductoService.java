package co.edu.ucentral.app.productos.service;

import java.util.List;

import co.edu.ucentral.app.productos.model.Producto;

public interface iProductoService {

	public List<Producto> findAll();

	public Producto findById(Integer id);

	public Producto save(Producto producto);

	public void delete(Integer id);
	
}
