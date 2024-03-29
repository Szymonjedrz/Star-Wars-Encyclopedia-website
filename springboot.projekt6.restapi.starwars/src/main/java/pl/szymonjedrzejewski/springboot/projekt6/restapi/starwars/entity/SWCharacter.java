package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "characters")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SWCharacter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "height")
	private String height;
	
	@Column(name = "mass")
	private String mass;
	
	@Column(name = "hair_color")
	private String hair_color;
	
	@Column(name = "skin_color")
	private String skin_color;
	
	@Column(name = "eye_color")
	private String eye_color;
	
	@Column(name = "birth_year")
	private String birth_year;
	
	@Column(name = "gender")
	private String gender;

	@Column(name = "species")
	private String species;
	
	@Column(name = "homeworld")
	private String homeworld;
	
//	@Column(name = "films")
//	private String[] films;
//	
//	@Column(name = "vehicles")
//	private String[] vehicles;
//	
//	@Column(name = "starships")
//	private String[] starships;
//	
//	@Column(name = "created")
//	private String created;
//	
//	@Column(name = "edited")
//	private String edited;
//	
//	@Column(name = "url")
//	private String url;

	public SWCharacter() {
		
	}

	public SWCharacter(String name, String height, String mass, String hair_color, String skin_color, String eye_color, String birth_year, String gender, String species, String homeworld) {
		this.name = name;
		this.height = height;
		this.mass = mass;
		this.hair_color = hair_color;
		this.skin_color = skin_color;
		this.eye_color = eye_color;
		this.birth_year = birth_year;
		this.gender = gender;
		this.species = species;
		this.homeworld = homeworld;
	}

	//	public SWCharacter(String name, String height, String mass, String hair_color, String skin_color, String eye_color,
//			String birth_year, String gender, String homeworld, String[] films, String[] species, String[] vehicles,
//			String[] starships, String created, String edited, String url) {
//		this.name = name;
//		this.height = height;
//		this.mass = mass;
//		this.hair_color = hair_color;
//		this.skin_color = skin_color;
//		this.eye_color = eye_color;
//		this.birth_year = birth_year;
//		this.gender = gender;
//		this.homeworld = homeworld;
//		this.films = films;
//		this.species = species;
//		this.vehicles = vehicles;
//		this.starships = starships;
//		this.created = created;
//		this.edited = edited;
//		this.url = url;
//	}

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

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getMass() {
		return mass;
	}

	public void setMass(String mass) {
		this.mass = mass;
	}

	public String getHair_color() {
		return hair_color;
	}

	public void setHair_color(String hair_color) {
		this.hair_color = hair_color;
	}

	public String getSkin_color() {
		return skin_color;
	}

	public void setSkin_color(String skin_color) {
		this.skin_color = skin_color;
	}

	public String getEye_color() {
		return eye_color;
	}

	public void setEye_color(String eye_color) {
		this.eye_color = eye_color;
	}

	public String getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getHomeworld() {
		return homeworld;
	}

	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}

//	public String[] getFilms() {
//		return films;
//	}
//
//	public void setFilms(String[] films) {
//		this.films = films;
//	}
//
//	public String[] getVehicles() {
//		return vehicles;
//	}
//
//	public void setVehicles(String[] vehicles) {
//		this.vehicles = vehicles;
//	}
//
//	public String[] getStarships() {
//		return starships;
//	}
//
//	public void setStarships(String[] starships) {
//		this.starships = starships;
//	}
//
//	public String getCreated() {
//		return created;
//	}
//
//	public void setCreated(String created) {
//		this.created = created;
//	}
//
//	public String getEdited() {
//		return edited;
//	}
//
//	public void setEdited(String edited) {
//		this.edited = edited;
//	}
//
//	public String getUrl() {
//		return url;
//	}
//
//	public void setUrl(String url) {
//		this.url = url;
//	}

//	@Override
//	public String toString() {
//		return "SWCharacter [id=" + id + ", name=" + name + ", height=" + height + ", mass=" + mass + ", hair_color="
//				+ hair_color + ", skin_color=" + skin_color + ", eye_color=" + eye_color + ", birth_year=" + birth_year
//				+ ", gender=" + gender + ", homeworld=" + homeworld + ", films=" + Arrays.toString(films) + ", species="
//				+ Arrays.toString(species) + ", vehicles=" + Arrays.toString(vehicles) + ", starships="
//				+ Arrays.toString(starships) + ", created=" + created + ", edited=" + edited + ", url=" + url + "]";
//	}

	@Override
	public String toString() {
		return "SWCharacter{" +
				"id=" + id +
				", name='" + name + '\'' +
				", height='" + height + '\'' +
				", mass='" + mass + '\'' +
				", hair_color='" + hair_color + '\'' +
				", skin_color='" + skin_color + '\'' +
				", eye_color='" + eye_color + '\'' +
				", birth_year='" + birth_year + '\'' +
				", gender='" + gender + '\'' +
				", species='" + species + '\'' +
				", homeworld='" + homeworld + '\'' +
				'}';
	}
}
