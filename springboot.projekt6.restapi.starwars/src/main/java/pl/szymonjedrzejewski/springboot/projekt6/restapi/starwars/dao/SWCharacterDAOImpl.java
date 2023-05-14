package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.SWCharacter;

@Repository
public class SWCharacterDAOImpl implements SWCharacterDAO {
	
	private EntityManager entityManager;

	@Autowired
	public SWCharacterDAOImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public List <SWCharacter> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query <SWCharacter> theQuery = currentSession.createQuery("from SWCharacter", SWCharacter.class);
		
		List <SWCharacter> characters = theQuery.getResultList();
		
		return characters;
	}

	@Override
	public SWCharacter findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		SWCharacter theCharacter = currentSession.get(SWCharacter.class, theId);
		
		return theCharacter;
	}

	@Override
	public void save(SWCharacter character) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(character);
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		SWCharacter theCharacter = currentSession.get(SWCharacter.class, theId);
		
		currentSession.delete(theCharacter);
	}

	@Override
	public Iterable <SWCharacter> save (List <SWCharacter> swCharacters) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		for (SWCharacter swCharacter : swCharacters) {
			currentSession.save(swCharacter);
		}
		
		return swCharacters;
	}

	@Override
	public List <SWCharacter> searchBy(String theName) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query <SWCharacter> theQuery = currentSession.createQuery("from SWCharacter where name like :name", SWCharacter.class);
		
		theQuery.setParameter("name", "%" + theName + "%");
		
		List <SWCharacter> characters = theQuery.getResultList();
		
		return characters;
	}
}
