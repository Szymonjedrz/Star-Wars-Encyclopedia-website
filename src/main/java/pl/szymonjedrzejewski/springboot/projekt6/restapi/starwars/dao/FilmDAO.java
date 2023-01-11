package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.dao;

import java.util.List;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Film;

public interface FilmDAO {
	
	public List <Film> findAll();
	
	public Film findById (int theId);
	
	public void save (Film film);
	
	public void deleteById (int theId);
	
	public Iterable <Film> save(List <Film> films);

	public List<Film> searchBy(String theName);
}
