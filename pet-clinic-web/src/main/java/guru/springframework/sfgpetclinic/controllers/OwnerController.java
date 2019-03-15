package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.services.OwnerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/owners")
public class OwnerController {
	
	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@RequestMapping({"", "/", "/index", "index.html"})
	public String listOwners(Model model) {
		log.debug("[OwnerController] - listOwners has been called");
		
		model.addAttribute("owners", ownerService.findAll());
		
		return "owners/index";
	}
	
	@RequestMapping("/find")
	public String findOwners() {
		log.debug("[OwnerController] - findOwners has been called");
		
		return "notimplemented";
	}
}
