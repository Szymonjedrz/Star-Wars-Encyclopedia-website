package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "species")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Species {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "classification")
	private String classification;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "average_height")
	private String average_height;
	
	@Column(name = "skin_colors")
	private String skin_colors;
	
	@Column(name = "hair_colors")
	private String hair_colors;
	
	@Column(name = "eye_colors")
	private String eye_colors;
	
	@Column(name = "average_lifespan")
	private String average_lifespan;
	
	@Column(name = "homeworld")
	private String homeworld;
	
	@Column(name = "language")
	private String language;
	
	public Species() {
		
	}

	public Species(String name, String classification, String designation, String average_height, String skin_colors,
			String hair_colors, String eye_colors, String average_lifespan, String homeworld, String language) {
		this.name = name;
		this.classification = classification;
		this.designation = designation;
		this.average_height = average_height;
		this.skin_colors = skin_colors;
		this.hair_colors = hair_colors;
		this.eye_colors = eye_colors;
		this.average_lifespan = average_lifespan;
		this.homeworld = homeworld;
		this.language = language;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAverage_height() {
		return average_height;
	}

	public void setAverage_height(String average_height) {
		this.average_height = average_height;
	}

	public String getSkin_colors() {
		return skin_colors;
	}

	public void setSkin_colors(String skin_colors) {
		this.skin_colors = skin_colors;
	}

	public String getHair_colors() {
		return hair_colors;
	}

	public void setHair_colors(String hair_colors) {
		this.hair_colors = hair_colors;
	}

	public String getEye_colors() {
		return eye_colors;
	}

	public void setEye_colors(String eye_colors) {
		this.eye_colors = eye_colors;
	}

	public String getAverage_lifespan() {
		return average_lifespan;
	}

	public void setAverage_lifespan(String average_lifespan) {
		this.average_lifespan = average_lifespan;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHomeworld() {
		return homeworld;
	}

	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}

	@Override
	public String toString() {
		return "Species [id=" + id + ", name=" + name + ", classification=" + classification + ", designation="
				+ designation + ", average_height=" + average_height + ", skin_colors=" + skin_colors + ", hair_colors="
				+ hair_colors + ", eye_colors=" + eye_colors + ", average_lifespan=" + average_lifespan + ", homeworld="
				+ homeworld + ", language=" + language + "]";
	}
}
