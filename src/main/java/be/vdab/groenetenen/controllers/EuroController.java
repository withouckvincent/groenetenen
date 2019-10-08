package be.vdab.groenetenen.controllers;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.groenetenen.exceptions.KanKoersNietLezenException;
import be.vdab.groenetenen.services.EuroService;

@Controller
@RequestMapping("euro")
class EuroController {
	private final EuroService euroService;

	EuroController(EuroService euroService) {
		this.euroService = euroService;
	}

	@GetMapping("{euro}/naardollar")
	ModelAndView naarDollar(@PathVariable BigDecimal euro) {
		ModelAndView modelAndView = new ModelAndView("naarDollar");
		try {
			modelAndView.addObject("dollar", euroService.naarDollar(euro));
		} catch (KanKoersNietLezenException ex) {
		}
		return modelAndView;
	}
}
