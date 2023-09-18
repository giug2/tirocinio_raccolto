package it.uniroma3.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.model.Document;
import it.uniroma3.service.DocumentService;

@Component
public class DocumentValidator implements Validator {

	@Autowired
	private DocumentService documentService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Document.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(documentService.alreadyExists((Document) target))
			errors.reject("duplicate.document");
	}
}
