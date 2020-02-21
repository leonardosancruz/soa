package co.edu.ucentral.app.controller;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.ucentral.app.model.Video;

@Controller
public class ControllerHome {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goInicio() {
		return "inicio";
	}

	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String paginaPrincipal(Model model) {
		List<Video> lista = getLista();
		model.addAttribute("lista", lista);
		System.out.println(lista);
		return "inicio";
	}

	@RequestMapping(value = "/consultar", method = { RequestMethod.GET, RequestMethod.POST })
	public String mostrarDetalle(@RequestParam("id") int id, @RequestParam("titulo") String titulo) {

		System.out.println("id: " + id);
		System.out.println("titulo: " + titulo);
		
		return "mostrar";
	}

	private List<Video> getLista() {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		List<Video> lista = new LinkedList<Video>();

		try {
			lista.add(new Video(10, "Video1", "descripcion video1", formato.parse("10-12-2019"), 1, "video1.png",
					"Activo"));
			lista.add(new Video(20, "Video2", "descripcion video2", formato.parse("10-11-2018"), 1, "video2.png",
					"Inactivo"));
			lista.add(new Video(30, "Video3", "descripcion video3", formato.parse("01-01-2020"), 1, "video3.png",
					"Activo"));
			return lista;
		} catch (Exception e) {
			return null;
		}

	}

}
