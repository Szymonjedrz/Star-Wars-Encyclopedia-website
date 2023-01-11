package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service;

import java.util.List;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Vehicle;

public interface VehicleService {
	
	public Iterable <Vehicle> findAll();
	
	public Vehicle findById (int theId);
	
	public void save (Vehicle vehicle);
	
	public void deleteById (int theId);

	public Iterable <Vehicle> save(List <Vehicle> vehicles);

	public List<Vehicle> searchBy(String theName);
}
