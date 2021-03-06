package PruebaJpaRepository;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import co.edu.ucentral.app.model.Clasificacion;
import co.edu.ucentral.app.repository.ClasificacionRepository;

public class AppSorting {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		ClasificacionRepository repo = context.getBean("clasificacionRepository", ClasificacionRepository.class);
		List<Clasificacion> lista = repo.findAll(Sort.by("nombre").descending().and(Sort.by("id").ascending()));
		for(Clasificacion c: lista) {
			System.out.println(c.getNombre() + " " + c.getId());
		}
		context.close();

	}

}
