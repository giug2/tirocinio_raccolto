package it.uniroma3.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import static it.uniroma3.model.Document.*;
import it.uniroma3.controller.validator.DocumentValidator;
import it.uniroma3.model.Document;
import it.uniroma3.service.DocumentService;
import it.uniroma3.utility.FileStore;
import jakarta.validation.Valid;

@Controller
public class DocumentController {

	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private DocumentValidator documentValidator;
	
	
	/* ===== NEW FILE ===== */
	@GetMapping(value = "/formNewDoc")
	public String formNewDoc(Model model) {
		model.addAttribute("doc", new Document());
		return "formNewDoc";
	}
	
	@PostMapping("/formNewDoc")
	public String newDoc(@Valid @ModelAttribute("doc") Document doc, BindingResult bindingResult,
			@RequestParam("file") MultipartFile file, 
						   Model model){
		this.documentValidator.validate(doc, bindingResult);
		if (!bindingResult.hasErrors()) {
			doc.setElem(FileStore.store(file, DIR_FOLDER_IMG));
			this.documentService.save(doc);
			return this.getDocs(model);
		}
		return "formNewDoc";
	}

	/* ===== FILE ===== */
	@GetMapping(value="/doc/{id}")
	public String getDoc(@PathVariable("id") Long id, Model model) {
		model.addAttribute("doc", this.documentService.findById(id));
		return "document";
	}
	
	/* ===== FILES ===== */
	@GetMapping(value="/docs")
	public String getDocs(Model model) {
		model.addAttribute("docs", this.documentService.findAll());
		return "elencoDocumenti";
	}
	
	/* ===== DOC ===== */
	@GetMapping(value="/doc/elem/{id}")
	public String getElem(@PathVariable("id") Long id, Model model) {
		model.addAttribute("elem", this.documentService.findById(id).getElem());
		return "elemento";
	}
	
}
