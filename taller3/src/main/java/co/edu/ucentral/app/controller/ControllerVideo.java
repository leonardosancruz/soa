package co.edu.ucentral.app.controller;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.edu.ucentral.app.model.Video;
import co.edu.ucentral.app.service.IVideosService;

@Controller
@RequestMapping("/videos")
public class ControllerVideo {

	@Autowired
	private IVideosService serviceVideos;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Video> lista = serviceVideos.selectAll();
		model.addAttribute("videos", lista);
		
		System.out.println("index: " + model);
		return "videos/indexVideo";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Video video, Model model) {
		model.addAttribute("statuses",serviceVideos.selectEstatus());
		model.addAttribute("clasificaciones",serviceVideos.selectClasificacion());
		List<Video> lista = serviceVideos.selectAll();
		model.addAttribute("lista", lista);
		System.out.println("create: " + lista);
		return "videos/createVideo";
	}

	@PostMapping("/save")
	public String guardar(Video video, BindingResult result, RedirectAttributes atributes) {

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage());
		}

		if (result.hasErrors()) {
			return "videos/createVideo";
		}
		System.out.println("save: " + video);
		serviceVideos.insert(video);
		atributes.addFlashAttribute("mensaje", "Video guardado con exito");

		return "redirect:/videos/index";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
