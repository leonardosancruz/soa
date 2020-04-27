package PruebaCrudRepository;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.edu.ucentral.app.model.Clasificacion;
import co.edu.ucentral.app.repository.ClasificacionRepository;

public class AppUpdate {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		ClasificacionRepository repo = context.getBean("clasificacionRepository", ClasificacionRepository.class);
		Optional<Clasificacion> opt = repo.findById(1);
		if(opt.isPresent()) {
			Clasificacion clasificacion = opt.get();
			clasificacion.setNombre("Clasificaicon x");
			repo.save(clasificacion);
		}

		context.close();
	}

}
