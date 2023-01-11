package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service;

import java.util.List;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Film;

public interface FilmService {
	
	public Iterable <Film> findAll();
	
	public Film findById (int theId);
	
	public void save (Film film);
	
	public void deleteById (int theId);

	public Iterable <Film> save(List <Film> films);

	public List<Film> searchBy(String theName);
}
