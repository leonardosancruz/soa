package pruebaMetodoAndAnotacionQuery;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.edu.ucentral.app.model.Video;
import co.edu.ucentral.app.repository.VideoRepository;

public class AppMetodoQuery {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		VideoRepository repo = context.getBean("videoRepository", VideoRepository.class);
		List <Video> lista = repo.findByStatus("Inactiva");
		
		for(Video v:lista) {
			System.out.println(v);
		}
		context.close();
	}
}
