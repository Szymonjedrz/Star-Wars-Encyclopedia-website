package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.dao.SWCharacterDAO;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.SWCharacter;

@Service
public class SWCharacterServiceImpl implements SWCharacterService {
	
	private SWCharacterDAO swCharacterDAO;

	@Autowired
	public SWCharacterServiceImpl(SWCharacterDAO theSWCharacterDAO) {
		this.swCharacterDAO = theSWCharacterDAO;
	}

	@Override
	@Transactional
	public Iterable <SWCharacter> findAll() {
		return swCharacterDAO.findAll();
	}

	@Override
	@Transactional
	public SWCharacter findById(int theId) {
		return swCharacterDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(SWCharacter swCharacter) {
		swCharacterDAO.save(swCharacter);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		swCharacterDAO.deleteById(theId);
	}

	@Override
	@Transactional
	public Iterable <SWCharacter> save(List <SWCharacter> swCharacters) {
        return swCharacterDAO.save(swCharacters);
    }

	@Override
	@Transactional
	public List<SWCharacter> searchBy(String theName) {
		return swCharacterDAO.searchBy(theName);
	}

}
