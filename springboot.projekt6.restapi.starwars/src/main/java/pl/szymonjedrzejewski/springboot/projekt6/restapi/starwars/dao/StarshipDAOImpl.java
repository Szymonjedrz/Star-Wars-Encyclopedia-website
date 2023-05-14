package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Starship;

@Repository
public class StarshipDAOImpl implements StarshipDAO {
	
	private EntityManager entityManager;

	@Autowired
	public StarshipDAOImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public List <Starship> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query <Starship> theQuery = currentSession.createQuery("from Starship", Starship.class);
		
		List <Starship> starships = theQuery.getResultList();
		
		return starships;
	}

	@Override
	public Starship findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Starship theStarship = currentSession.get(Starship.class, theId);
		
		return theStarship;
	}

	@Override
	public void save(Starship starship) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(starship);
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Starship theStarship = currentSession.get(Starship.class, theId);
		
		currentSession.delete(theStarship);
	}

	@Override
	public Iterable <Starship> save (List <Starship> starships) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		for (Starship theStarship : starships) {
			currentSession.save(theStarship);
		}
		
		return starships;
	}

	@Override
	public List <Starship> searchBy (String theName) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query <Starship> theQuery = currentSession.createQuery("from Starship where name like :name", Starship.class);
		
		theQuery.setParameter("name", "%" + theName + "%");

		List <Starship> starships = theQuery.getResultList();

		return starships;
	}
}
