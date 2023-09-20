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
import static it.uniroma3.model.Crop.*;
import it.uniroma3.controller.validator.CropValidator;
import it.uniroma3.model.Crop;
import it.uniroma3.service.CropService;
import it.uniroma3.utility.FileStore;
import jakarta.validation.Valid;

@Controller
public class CropController {

	@Autowired
	private CropService cropService;
	
	@Autowired
	private CropValidator cropValidator;
	
	
	/* ===== NEW FILE ===== */
	@GetMapping(value = "/formNewCrop")
	public String formNewCrop(Model model) {
		model.addAttribute("crop", new Crop());
		return "formNewCrop";
	}
	
	@PostMapping("/formNewCrop")
	public String newCrop(@Valid @ModelAttribute("crop") Crop crop, BindingResult bindingResult,
			@RequestParam("file") MultipartFile file, 
						   Model model){
		this.cropValidator.validate(crop, bindingResult);
		if (!bindingResult.hasErrors()) {
			crop.setPath(FileStore.store(file, DIR_FOLDER_IMG));
			this.cropService.save(crop);
			return this.getCrops(model);
		}
		return "formNewCrop";
	}

	/* ===== FILE ===== */
	@GetMapping(value="/crop/{id}")
	public String getCrop(@PathVariable("id") Long id, Model model) {
		model.addAttribute("crop", this.cropService.findById(id));
		return "crop";
	}
	
	/* ===== FILES ===== */
	@GetMapping(value="/crops")
	public String getCrops(Model model) {
		model.addAttribute("crops", this.cropService.findAll());
		return "elencoCrop";
	}
}
