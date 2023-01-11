package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service;

import java.util.List;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Starship;

public interface StarshipService {
	
	public Iterable <Starship> findAll();
	
	public Starship findById (int theId);
	
	public void save (Starship starship);
	
	public void deleteById (int theId);

	public Iterable <Starship> save (List <Starship> starships);

	public List <Starship> searchBy (String theName);
}
