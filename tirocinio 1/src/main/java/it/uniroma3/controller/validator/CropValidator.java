package it.uniroma3.controller.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.model.Crop;

@Component
public class CropValidator implements Validator {

//	@Autowired
//	private CropService cropService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Crop.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
//		if(documentService.alreadyExists((Cani) target))
//			errors.reject("duplicate.document");
	}
}
