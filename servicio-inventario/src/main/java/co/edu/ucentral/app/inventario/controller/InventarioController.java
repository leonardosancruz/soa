package co.edu.ucentral.app.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import co.edu.ucentral.app.inventario.model.Inventario;
import co.edu.ucentral.app.inventario.model.Producto;
import co.edu.ucentral.app.inventario.service.IServicioInventario;

@RestController
public class InventarioController {

	@Autowired
	@Qualifier("serviceFeign")
	private IServicioInventario serviceInventario;

	@GetMapping("/listar")
	public List<Inventario> listar() {
		return serviceInventario.findAll();
	}

	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) {
		return serviceInventario.save(producto);
	}
	
	@PostMapping("/editar/{id}")
	public Producto editar(@RequestBody Producto producto, Integer id) {
		return serviceInventario.update(producto, id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		serviceInventario.delete(id);
	};
	
	@HystrixCommand(fallbackMethod = "metodoAlternativo")
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Inventario ver(@PathVariable Integer id, @PathVariable Integer cantidad) {

		return serviceInventario.findById(id, cantidad);
	}

	public Inventario metodoAlternativo(Integer id, Integer cantidad) {
		Inventario inventario = new Inventario();
		Producto producto = new Producto();

		inventario.setCantidad(cantidad);
		producto.setId(id);
		producto.setNombre("metodoAlternativo");
		producto.setPrecio((double) 500);
		inventario.setProducto(producto);

		return inventario;
	}

}
