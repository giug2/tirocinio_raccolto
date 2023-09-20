package it.uniroma3.repository;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.model.Crop;

@Repository
public interface CropRepository extends CrudRepository<Crop, Long> {

//	boolean existsByCrop(String name);
	
//	List<Document> findByEstensione(String estensione);

}
