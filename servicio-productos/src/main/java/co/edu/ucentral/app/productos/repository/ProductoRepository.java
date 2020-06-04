package co.edu.ucentral.app.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.app.productos.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
