package PruebaCrudRepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.edu.ucentral.app.repository.ClasificacionRepository;

public class AppDelete {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		ClasificacionRepository repo = context.getBean("clasificacionRepository", ClasificacionRepository.class);
		
		if(repo.existsById(1)) {
			repo.deleteById(1);
		}
		context.close();

	}

}
