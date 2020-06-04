package co.edu.ucentral.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ucentral.app.model.Clasificacion;
@Repository
public interface ClasificacionRepository extends JpaRepository<Clasificacion, Integer> {

}
