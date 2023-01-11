package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.dao.StarshipDAO;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Starship;

@Service
public class StarshipServiceImpl implements StarshipService {
	
	private StarshipDAO starshipDAO;

	@Autowired
	public StarshipServiceImpl(StarshipDAO theStarshipDAO) {
		this.starshipDAO = theStarshipDAO;
	}

	@Override
	@Transactional
	public List <Starship> findAll() {
		return starshipDAO.findAll();
	}

	@Override
	@Transactional
	public Starship findById(int theId) {
		return starshipDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Starship starship) {
		starshipDAO.save(starship);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		starshipDAO.deleteById(theId);
	}

	@Override
	@Transactional
	public Iterable <Starship> save (List<Starship> starships) {
		return starshipDAO.save(starships);
	}

	@Override
	public List <Starship> searchBy (String theName) {
		return starshipDAO.searchBy(theName);
	}

}
