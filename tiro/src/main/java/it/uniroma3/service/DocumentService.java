package it.uniroma3.service;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Document;
import it.uniroma3.repository.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository documentRepository;
	
	public boolean alreadyExists(Document target) {
		return documentRepository.existsByNome(target.getNome());
	}

	public Document findById(Long id) {
		return documentRepository.findById(id).get();
	}

	@Transactional
	public void save(Document document) {
		documentRepository.save(document);
	}
	
	public List<Document> findAll() {
		return (List<Document>) documentRepository.findAll();
	}
}
