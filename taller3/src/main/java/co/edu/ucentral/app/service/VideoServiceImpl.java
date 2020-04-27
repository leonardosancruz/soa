package co.edu.ucentral.app.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.ucentral.app.model.Clasificacion;
import co.edu.ucentral.app.model.Detalle;
import co.edu.ucentral.app.model.Video;

@Service
public class VideoServiceImpl implements IVideoService {

	private List<Video> lista=null;
	public VideoServiceImpl() {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Video>();
		
		try {
			Video video = new Video();
			video.setId(10);
			video.setName("Video1");
			video.setDescription("descripcion video 1");
			video.setDate(formato.parse("10-12-2019"));
			video.setStatus("Activo");
			video.setCategoria(new Clasificacion(1, "Categoria A"));
			video.setPath("java.png");
			Detalle detalle = new Detalle();
			detalle.setAutor("autor");
			detalle.setFechaFilmacion(new Date());
			detalle.setResumen("Resumen ");
			video.setDetalle(detalle);
			lista.add(video);
			
		
		} catch (Exception e) {
		
		}
		
	}
	@Override
	public List<Video> selectAll() {
		
		return lista;
	}

	@Override
	public Video searchById(int idVideo) {
		for(Video v: lista) {
			if(idVideo== v.getId()) {
				return v;
			}
		}
		return null;
	}

	@Override
	public void insert(Video video) {
		lista.add(video);
		
	}

	@Override
	public List<String> crearEstatus() {
		List <String> statuses = new LinkedList<String>();
		statuses.add("Activa");
		statuses.add("Inactiva");
		return statuses;
	}

	@Override
	public List<Clasificacion> selectClasificacion() {
		List <Clasificacion> lista = new LinkedList<Clasificacion>();
		lista.add(new Clasificacion(1,"Clasificacion A"));
		lista.add(new Clasificacion(2,"Clasificacion B"));
		lista.add(new Clasificacion(3,"Clasificacion C"));
		lista.add(new Clasificacion(4,"Clasificacion D"));
		return lista;
	}

}
