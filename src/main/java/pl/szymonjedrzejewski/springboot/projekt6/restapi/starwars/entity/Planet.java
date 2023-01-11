package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "planets")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Planet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "rotation_period")
	private String rotation_period;
	
	@Column(name = "orbital_period")
	private String orbital_period;
	
	@Column(name = "diameter")
	private String diameter;
	
	@Column(name = "climate")
	private String climate;
	
	@Column(name = "gravity")
	private String gravity;
	
	@Column(name = "terrain")
	private String terrain;
	
	@Column(name = "surface_water")
	private String surface_water;
	
	@Column(name = "population")
	private String population;

	public Planet() {
		
	}

	public Planet(String name, String rotation_period, String orbital_period, String diameter, String climate,
			String gravity, String terrain, String surface_water, String population) {
		this.name = name;
		this.rotation_period = rotation_period;
		this.orbital_period = orbital_period;
		this.diameter = diameter;
		this.climate = climate;
		this.gravity = gravity;
		this.terrain = terrain;
		this.surface_water = surface_water;
		this.population = population;
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

	public String getRotation_period() {
		return rotation_period;
	}

	public void setRotation_period(String rotation_period) {
		this.rotation_period = rotation_period;
	}

	public String getOrbital_period() {
		return orbital_period;
	}

	public void setOrbital_period(String orbital_period) {
		this.orbital_period = orbital_period;
	}

	public String getDiameter() {
		return diameter;
	}

	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getGravity() {
		return gravity;
	}

	public void setGravity(String gravity) {
		this.gravity = gravity;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public String getSurface_water() {
		return surface_water;
	}

	public void setSurface_water(String surface_water) {
		this.surface_water = surface_water;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Planet [id=" + id + ", name=" + name + ", rotation_period=" + rotation_period + ", orbital_period="
				+ orbital_period + ", diameter=" + diameter + ", climate=" + climate + ", gravity=" + gravity
				+ ", terrain=" + terrain + ", surface_water=" + surface_water + ", population=" + population + "]";
	}
}
