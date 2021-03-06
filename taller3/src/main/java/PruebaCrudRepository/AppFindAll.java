package PruebaCrudRepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.edu.ucentral.app.model.Clasificacion;
import co.edu.ucentral.app.repository.ClasificacionRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		ClasificacionRepository repo = context.getBean("clasificacionRepository", ClasificacionRepository.class);
		Iterable<Clasificacion> it=repo.findAll();
		for(Clasificacion c:it) {
			System.out.println(c.getNombre());
		}
		
		context.close();
	}

}
