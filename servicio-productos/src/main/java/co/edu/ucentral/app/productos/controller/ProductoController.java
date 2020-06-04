package co.edu.ucentral.app.productos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.productos.model.Producto;
import co.edu.ucentral.app.productos.service.iProductoService;

@RestController
public class ProductoController {

	@Value("${server.port}")
	private Integer port;

	@Autowired
	private iProductoService productoService;

	@GetMapping("/listar")
	public List<Producto> listar() {

		productoService.findAll().stream().map(producto -> {
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
		return productoService.findAll();
	}

	@GetMapping("/ver/{id}")
	public Producto ver(@PathVariable Integer id) {
		Producto producto = productoService.findById(id);
		producto.setPort(port);
		return producto;
	}

	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) {
		return productoService.save(producto);
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editar(@RequestBody Producto producto, @PathVariable Integer id) {
		Producto productoDB = productoService.findById(id);
		productoDB.setNombre(producto.getNombre());
		productoDB.setPrecio(producto.getPrecio());
		return productoService.save(productoDB);
	}
	
	@DeleteMapping("eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar (@PathVariable Integer id) {
		productoService.delete(id);
	}
}
