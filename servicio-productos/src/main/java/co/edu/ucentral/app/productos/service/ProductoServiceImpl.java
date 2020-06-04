package co.edu.ucentral.app.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.app.productos.model.Producto;
import co.edu.ucentral.app.productos.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements iProductoService {

	@Autowired
	private ProductoRepository productoRepo;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Integer id) {
		// TODO Auto-generated method stub
		return productoRepo.findById(id).orElse(null);
	}

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepo.save(producto);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		productoRepo.deleteById(id);
	}

}
