package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.dao.SpeciesDAO;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Species;

@Service
public class SpeciesServiceImpl implements SpeciesService {
	
	private SpeciesDAO speciesDAO;

	@Autowired
	public SpeciesServiceImpl(SpeciesDAO theSpeciesDAO) {
		this.speciesDAO = theSpeciesDAO;
	}

	@Override
	@Transactional
	public List<Species> findAll() {
		return speciesDAO.findAll();
	}

	@Override
	@Transactional
	public Species findById(int theId) {
		return speciesDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Species species) {
		speciesDAO.save(species);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		speciesDAO.deleteById(theId);
	}

	@Override
	@Transactional
	public Iterable<Species> save(List<Species> species) {
		return speciesDAO.save(species);
	}

	@Override
	@Transactional
	public List <Species> searchBy(String theName) {
		return speciesDAO.searchBy(theName);
	}
}
