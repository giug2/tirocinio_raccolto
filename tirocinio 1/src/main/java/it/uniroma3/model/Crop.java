package it.uniroma3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Crop {

	public static final String DIR_FOLDER_IMG = "document/profili/";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String crop;
    private String croplabel;
    private String path;
   

    
    
    public Crop(){
    }
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCrop() {
		return crop;
	}
	public void setCrop(String crop) {
		this.crop = crop;
	}
	
	public String getCroplabel() {
		return croplabel;
	}
	
	public void setCroplabel(String croplabel) {
		this.croplabel = croplabel;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
