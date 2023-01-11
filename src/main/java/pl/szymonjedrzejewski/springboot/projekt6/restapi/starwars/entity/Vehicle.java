package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vehicles")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "cost_in_credits")
	private String cost_in_credits;
	
	@Column(name = "length")
	private String length;
	
	@Column(name = "max_atmosphering_speed")
	private String max_atmosphering_speed;
	
	@Column(name = "crew")
	private String crew;
	
	@Column(name = "passengers")
	private String passengers;
	
	@Column(name = "cargo_capacity")
	private String cargo_capacity;
	
	@Column(name = "consumables")
	private String consumables;
	
	@Column(name = "vehicle_class")
	private String vehicle_class;
	
	public Vehicle() {
		
	}

	public Vehicle(String name, String model, String manufacturer, String cost_in_credits, String length,
			String max_atmosphering_speed, String crew, String passengers, String cargo_capacity, String consumables,
			String vehicle_class) {
		this.name = name;
		this.model = model;
		this.manufacturer = manufacturer;
		this.cost_in_credits = cost_in_credits;
		this.length = length;
		this.max_atmosphering_speed = max_atmosphering_speed;
		this.crew = crew;
		this.passengers = passengers;
		this.cargo_capacity = cargo_capacity;
		this.consumables = consumables;
		this.vehicle_class = vehicle_class;
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCost_in_credits() {
		return cost_in_credits;
	}

	public void setCost_in_credits(String cost_in_credits) {
		this.cost_in_credits = cost_in_credits;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getMax_atmosphering_speed() {
		return max_atmosphering_speed;
	}

	public void setMax_atmosphering_speed(String max_atmosphering_speed) {
		this.max_atmosphering_speed = max_atmosphering_speed;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public String getPassengers() {
		return passengers;
	}

	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}

	public String getCargo_capacity() {
		return cargo_capacity;
	}

	public void setCargo_capacity(String cargo_capacity) {
		this.cargo_capacity = cargo_capacity;
	}

	public String getConsumables() {
		return consumables;
	}

	public void setConsumables(String consumables) {
		this.consumables = consumables;
	}

	public String getVehicle_class() {
		return vehicle_class;
	}

	public void setVehicle_class(String vehicle_class) {
		this.vehicle_class = vehicle_class;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + ", model=" + model + ", manufacturer=" + manufacturer
				+ ", cost_in_credits=" + cost_in_credits + ", length=" + length + ", max_atmosphering_speed="
				+ max_atmosphering_speed + ", crew=" + crew + ", passengers=" + passengers + ", cargo_capacity="
				+ cargo_capacity + ", consumables=" + consumables + ", vehicle_class=" + vehicle_class + "]";
	}
}
