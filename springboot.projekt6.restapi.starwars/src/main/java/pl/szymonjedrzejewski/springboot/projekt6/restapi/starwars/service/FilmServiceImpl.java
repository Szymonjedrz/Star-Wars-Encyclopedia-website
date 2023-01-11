package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.dao.FilmDAO;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Film;

@Service
public class FilmServiceImpl implements FilmService {
	
	private FilmDAO filmDAO;

	@Autowired
	public FilmServiceImpl(FilmDAO theFilmDAO) {
		this.filmDAO = theFilmDAO;
	}

	@Override
	@Transactional
	public Iterable <Film> findAll() {
		return filmDAO.findAll();
	}

	@Override
	@Transactional
	public Film findById(int theId) {
		return filmDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Film film) {
		filmDAO.save(film);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		filmDAO.deleteById(theId);
	}

	@Override
	@Transactional
	public Iterable <Film> save(List <Film> films) {
        return filmDAO.save(films);
    }

	@Override
	@Transactional
	public List<Film> searchBy(String theName) {
		return filmDAO.searchBy(theName);
	}
}
