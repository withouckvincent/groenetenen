package be.vdab.groenetenen.controllers;

import java.util.Locale;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.vdab.groenetenen.domain.Filiaal;
import be.vdab.groenetenen.forms.VanTotPostcodeForm;
import be.vdab.groenetenen.services.FiliaalService;

@Controller
//@RequestMapping("filialen") //
@RequestMapping(path = "filialen", produces = MediaType.TEXT_HTML_VALUE)
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
	ModelAndView vanTotPostcode(@Valid VanTotPostcodeForm form, Errors errors, Locale locale) { // taal van gebruiker
																								// lezen met Locale
		System.out.println(locale.getDisplayLanguage()); // taal

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

	@GetMapping("perid")
	String findById() {
		return "filiaalPerId";
	}

	private static final String REDIRECT_NA_AFSCHRIJVEN = "redirect:/filialen/{id}";
	@PostMapping("{id}/afschrijven")
	String afschrijven(@PathVariable long id, RedirectAttributes redirectAttributes) {
		filiaalService.afschrijven(id);
		redirectAttributes.addAttribute("id", id);
		return REDIRECT_NA_AFSCHRIJVEN;
	}

}
