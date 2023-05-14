package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Species;

@Repository
public class SpiecesDAOImpl implements SpeciesDAO {
	
	private EntityManager entityManager;

	@Autowired
	public SpiecesDAOImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public List <Species> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query <Species> theQuery = currentSession.createQuery("from Species", Species.class);
		
		List <Species> species = theQuery.getResultList();
		
		return species;
	}

	@Override
	public Species findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Species theSpecies = currentSession.get(Species.class, theId);
		
		return theSpecies;
	}

	@Override
	public void save(Species species) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(species);
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Species theSpecies = currentSession.get(Species.class, theId);
		
		currentSession.delete(theSpecies);
	}

	@Override
	public Iterable <Species> save (List <Species> species) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		for (Species theSpecies : species) {
			currentSession.save(theSpecies);
		}
		
		return species;
	}

	@Override
	public List <Species> searchBy (String theName) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query <Species> theQuery = currentSession.createQuery("from Species where name like :name", Species.class);
		
		theQuery.setParameter("name", "%" + theName + "%");
		
		List <Species> species = theQuery.getResultList();
		
		return species;
	}
}
