package be.vdab.groenetenen.controllers;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.groenetenen.services.WerknemerService;

@Controller
@RequestMapping("werknemers")
class WerknemerController {
	private final WerknemerService werknemerService;

	WerknemerController(WerknemerService werknemerService) {
		this.werknemerService = werknemerService;
	}

	@GetMapping
	ModelAndView lijst(Pageable pageable) {
		return new ModelAndView("werknemers", "page", werknemerService.findAll(pageable));
	}

}
