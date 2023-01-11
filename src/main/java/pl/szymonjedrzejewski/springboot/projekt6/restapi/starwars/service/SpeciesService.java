package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service;

import java.util.List;

import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Species;

public interface SpeciesService {

	public List <Species> findAll();
	
	public Species findById (int theId);
	
	public void save (Species species);
	
	public void deleteById (int theId);
	
	public Iterable <Species> save (List <Species> species);

	public List<Species> searchBy(String theName);
}