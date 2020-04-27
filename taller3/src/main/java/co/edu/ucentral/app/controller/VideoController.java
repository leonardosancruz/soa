package co.edu.ucentral.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import co.edu.ucentral.app.service.IVideoService;

@Controller
@RequestMapping("/videos")
public class VideoController {

	@Autowired
	private IVideoService videoService;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Video> lista = videoService.selectAll();
		model.addAttribute("videos", lista);
		return "videos/indexVideos";
	}

	@GetMapping("/create")
	public String crear(@ModelAttribute Video video, Model model) {
		model.addAttribute("statuses", videoService.crearEstatus());
		model.addAttribute("clasificaciones", videoService.selectClasificacion());
		return "videos/createVideo";
	}

	@PostMapping("/save")
	public String guardar(@ModelAttribute Video video, BindingResult result, RedirectAttributes atributes) {

		System.out.println("objeto video: " + video);
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage());
		}

		if (result.hasErrors()) {
			return "videos/createVideo";
		}
		videoService.insert(video);
		atributes.addFlashAttribute("mensaje", "Video Guardado con exito");
		return "redirect:/videos/index";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
