package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.dao.PlanetDAO;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Planet;

@Service
public class PlanetServiceImpl implements PlanetService {
	
	private PlanetDAO planetDAO;

	@Autowired
	public PlanetServiceImpl(PlanetDAO thePlanetDAO) {
		this.planetDAO = thePlanetDAO;
	}

	@Override
	@Transactional
	public Iterable <Planet> findAll() {
		return planetDAO.findAll();
	}

	@Override
	@Transactional
	public Planet findById(int theId) {
		return planetDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Planet planet) {
		planetDAO.save(planet);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		planetDAO.deleteById(theId);
	}

	@Override
	@Transactional
	public Iterable <Planet> save(List <Planet> planets) {
        return planetDAO.save(planets);
    }

	@Override
	@Transactional
	public List<Planet> searchBy(String theName) {
		return planetDAO.searchBy(theName);
	}
}
