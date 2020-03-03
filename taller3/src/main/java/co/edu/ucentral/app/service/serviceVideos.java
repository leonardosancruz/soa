package co.edu.ucentral.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.ucentral.app.model.Video;

@Service
public class serviceVideos implements IVideosService {

	private List<Video> lista;
	
	public serviceVideos() {
		lista = new LinkedList<Video>();

		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

		try {
			lista.add(new Video(10, "Video1", "descripcion video1", formato.parse("10-12-2019"), 1, "video1.png",
					"Activo"));
			lista.add(new Video(20, "Video2", "descripcion video2", formato.parse("10-11-2018"), 1, "video2.png",
					"Inactivo"));
			lista.add(new Video(30, "Video3", "descripcion video3", formato.parse("01-01-2020"), 1, "video3.png",
					"Activo"));

		} catch (Exception e) {

		}
	}


	@Override
	public List<Video> selectAll() {

		return lista;
	}

	@Override
	public void insert(Video video) {

		lista.add(video);
	}

}
