package it.uniroma3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.model.Document;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {

	boolean existsByNome(String name);
	
	List<Document> findByEstensione(String estensione);

}
