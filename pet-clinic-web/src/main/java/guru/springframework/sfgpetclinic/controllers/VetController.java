package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/vets")
public class VetController {

	private final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@RequestMapping({"", "/", "/index", "index.html"})
	public String listVets(Model model) {
		log.debug("[VetController] - listVets has been called");
		
		model.addAttribute("vets", vetService.findAll());
		
		return "vets/index";
	}
}
