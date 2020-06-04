package co.edu.ucentral.app.inventario.service;

import java.util.List;

import co.edu.ucentral.app.inventario.model.Inventario;
import co.edu.ucentral.app.inventario.model.Producto;

public interface IServicioInventario {
	
	public List<Inventario> findAll();

	public Inventario findById(Integer id, Integer cantidad);
	
	public Producto save(Producto producto);
	
	public Producto update(Producto producto, Integer id);
	
	public void delete(Integer id);
}
