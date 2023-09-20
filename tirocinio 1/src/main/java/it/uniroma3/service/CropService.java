package it.uniroma3.service;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Crop;
import it.uniroma3.repository.CropRepository;

@Service
public class CropService {

	@Autowired
	private CropRepository cropRepository;
	
//	public boolean alreadyExists(Cani target) {
//		return caneRepository.existsByCrop(target.getCrop());
//	}

	public Crop findById(Long id) {
		return cropRepository.findById(id).get();
	}
	
//	public List<Document> findByType(String type) {
//		return documentRepository.findByEstensione(type);
//	}

	@Transactional
	public void save(Crop crop) {
		cropRepository.save(crop);
	}
	
	public List<Crop> findAll() {
		return (List<Crop>) cropRepository.findAll();
	}
}
