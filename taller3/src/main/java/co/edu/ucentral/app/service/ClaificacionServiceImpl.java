package co.edu.ucentral.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.app.model.Clasificacion;
import co.edu.ucentral.app.repository.ClasificacionRepository;

@Service
public class ClaificacionServiceImpl implements IClasificacionService{

	@Autowired
	private ClasificacionRepository clasificacionRepo;
	
	@Override
	public List<Clasificacion> selectAll() {
		
		return clasificacionRepo.findAll();
	}

	@Override
	public Clasificacion searchById(int idClasificacion) {
		Optional<Clasificacion> optional = clasificacionRepo.findById(idClasificacion);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void insert(Clasificacion clasificacion) {
		clasificacionRepo.save(clasificacion);
		
	}

	@Override
	public void update(Clasificacion clasificacion) {
		clasificacionRepo.save(clasificacion);
		
	}

	@Override
	public void delete(int idClasificacion) {
		clasificacionRepo.deleteById(idClasificacion);
		
	}

}
