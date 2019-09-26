package be.vdab.groenetenen.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.groenetenen.domain.Filiaal;
import be.vdab.groenetenen.forms.VanTotPostcodeForm;
import be.vdab.groenetenen.services.FiliaalService;

@Controller
@RequestMapping("filialen")
class FiliaalController {
	private final FiliaalService filiaalService;

	FiliaalController(FiliaalService filiaalService) {
		this.filiaalService = filiaalService;
	}

	@GetMapping("vantotpostcodeform")
	ModelAndView vanTotPostcodeForm() {
		return new ModelAndView("vantotpostcode").addObject(new VanTotPostcodeForm(null, null));
	}

	@GetMapping("vantotpostcode")
	ModelAndView vanTotPostcode(@Valid VanTotPostcodeForm form, Errors errors) {
		ModelAndView modelAndView = new ModelAndView("vantotpostcode");
		if (!errors.hasErrors()) {
			modelAndView.addObject("filialen", filiaalService.findByPostcode(form.getVan(), form.getTot()));
		}
		return modelAndView;
	}

	@GetMapping("{optionalFiliaal}")
	ModelAndView read(@PathVariable Optional<Filiaal> optionalFiliaal) {
		ModelAndView modelAndView = new ModelAndView("filiaal");
		optionalFiliaal.ifPresent(filiaal -> modelAndView.addObject(filiaal));
		return modelAndView;
	}

}
