package pruebaRelaciones;


import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.edu.ucentral.app.model.Clasificacion;
import co.edu.ucentral.app.model.Video;
import co.edu.ucentral.app.repository.ClasificacionRepository;


public class AppClasificacionVideos {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		ClasificacionRepository repo = context.getBean("clasificacionRepository", ClasificacionRepository.class);
		Optional <Clasificacion> clasificacion = repo.findById(2);
		Clasificacion clasif = (Clasificacion) clasificacion.get();
		for(Video v: clasif.getVideos()) {
			System.out.println(v);
		}
		
		context.close();



	}

}
