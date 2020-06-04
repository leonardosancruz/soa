package co.edu.ucentral.app.inventario.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.edu.ucentral.app.inventario.model.Inventario;
import co.edu.ucentral.app.inventario.model.Producto;

@Service
public class ServicioInventarioImpl implements IServicioInventario {

	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Inventario> findAll() {
		List<Producto> producto = Arrays
				.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));

		List<Inventario> listaInventario = new LinkedList();
		Inventario inventario;
		for (Producto temp : producto) {
			inventario = new Inventario(temp,3);
			temp.setPrecio(inventario.getTotal());
			listaInventario.add(inventario);
		}

		return listaInventario;
	}

	@Override
	public Inventario findById(Integer id, Integer cantidad) {

		Map<String, String> variables = new HashMap<String, String>();
		variables.put("id", id.toString());
		Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, variables);

		Inventario Inventario = new Inventario(producto, cantidad);
		producto.setPrecio(Inventario.getTotal());
		
		return Inventario;
	}

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto update(Producto producto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}
