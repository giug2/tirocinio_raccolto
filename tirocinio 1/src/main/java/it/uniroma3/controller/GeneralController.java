package it.uniroma3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.service.DocumentService;

@Controller
public class GeneralController {
	
	@Autowired
	private DocumentService docService;

	@GetMapping(value = "/") 
	public String home(Model model) {
		model.addAttribute("docs", this.docService.findAll());
		return "index";
	}
}
