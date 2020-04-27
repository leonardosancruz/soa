package co.edu.ucentral.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.edu.ucentral.app.model.Clasificacion;
import co.edu.ucentral.app.service.IClasificacionService;

@Controller
@RequestMapping("/clasificaciones")
public class ClasificacionController {

	@Autowired
	private IClasificacionService clasificacionService;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		model.addAttribute("clasificaciones", clasificacionService.selectAll());
		return "clasificaciones/indexClasificacion";

	}

	@GetMapping("/create")
	public String crear(@ModelAttribute Clasificacion clasificacion) {
		return "clasificaciones/createClasificacion";
	}

	@PostMapping("/save")
	public String guardar(@ModelAttribute Clasificacion clasificacion, BindingResult result,
			RedirectAttributes atributes) {

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage());
		}

		if (result.hasErrors()) {
			return "clasificaciones/createClasificacion";
		}
		clasificacionService.insert(clasificacion);
		atributes.addFlashAttribute("mensaje", "Clasificacion Guardada con exito");
		return "redirect:/clasificaciones/index";
	}

	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idClasificacion, Model model) {
		Clasificacion clasificacion = clasificacionService.searchById(idClasificacion);
		model.addAttribute("clasificacion", clasificacion);
		return "clasificaciones/createClasificacion";
	}

	@GetMapping(name = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idClasificacion, RedirectAttributes attributes) {
		clasificacionService.delete(idClasificacion);
		attributes.addFlashAttribute("mensaje", "Registro eliminado con exito");
		return "redirect:/clasificaciones/index";
	}

}
