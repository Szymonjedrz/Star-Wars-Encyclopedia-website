package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.dao;

import java.util.List;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.SWCharacter;

public interface SWCharacterDAO {
	
	public List <SWCharacter> findAll();
	
	public SWCharacter findById (int theId);
	
	public void save (SWCharacter swCharacter);
	
	public void deleteById (int theId);
	
	public Iterable <SWCharacter> save (List <SWCharacter> swCharacters);

	public List <SWCharacter> searchBy (String theName);
}
