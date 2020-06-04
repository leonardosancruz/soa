package co.edu.ucentral.app.inventario.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.edu.ucentral.app.inventario.cliente.ProductoClienteRest;
import co.edu.ucentral.app.inventario.model.Inventario;
import co.edu.ucentral.app.inventario.model.Producto;

@Service("serviceFeign")
@Primary
public class InventarioServiceFeign implements IServicioInventario {

	@Autowired
	private ProductoClienteRest clienteFeign;

	@Override
	public List<Inventario> findAll() {
		return clienteFeign.listar().stream().map(p -> new Inventario(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Inventario findById(Integer id, Integer cantidad) {
		return new Inventario(clienteFeign.ver(id), cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		return clienteFeign.crear(producto);
	}

	@Override
	public void delete(Integer id) {
		clienteFeign.eliminar(id);
	}

	@Override
	public Producto update(Producto producto, Integer id) {
		return clienteFeign.update(producto, id);
	}

}
