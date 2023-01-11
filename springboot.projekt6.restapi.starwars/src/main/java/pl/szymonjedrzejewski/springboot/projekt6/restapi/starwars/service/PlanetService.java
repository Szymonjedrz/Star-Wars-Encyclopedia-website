package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service;

import java.util.List;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Planet;

public interface PlanetService {
	
	public Iterable <Planet> findAll();
	
	public Planet findById (int theId);
	
	public void save (Planet planet);
	
	public void deleteById (int theId);

	public Iterable <Planet> save(List <Planet> planets);

	public List<Planet> searchBy(String theName);
}
