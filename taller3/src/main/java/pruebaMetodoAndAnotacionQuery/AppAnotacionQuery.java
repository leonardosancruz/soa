package pruebaMetodoAndAnotacionQuery;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.edu.ucentral.app.model.Video;
import co.edu.ucentral.app.repository.VideoRepository;

public class AppAnotacionQuery {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		VideoRepository repo = context.getBean("videoRepository", VideoRepository.class);
		Video video = repo.encontrarVideoPorTitulo("Video2");
		
		System.out.println(video);
		context.close();
	}

}
