package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Planet;

@Repository
public class PlanetDAOImpl implements PlanetDAO {
	
	private EntityManager entityManager;

	@Autowired
	public PlanetDAOImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public List <Planet> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query <Planet> theQuery = currentSession.createQuery("from Planet", Planet.class);
		
		List <Planet> planets = theQuery.getResultList();
		
		return planets;
	}

	@Override
	public Planet findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Planet thePlanet = currentSession.get(Planet.class, theId);
		
		return thePlanet;
	}

	@Override
	public void save(Planet planet) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(planet);
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Planet thePlanet = currentSession.get(Planet.class, theId);
		
		currentSession.delete(thePlanet);
	}

	@Override
	public Iterable <Planet> save (List <Planet> planets) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		for (Planet planet : planets) {
			currentSession.save(planet);
		}
		
		return planets;
	}

	@Override
	public List <Planet> searchBy(String theName) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query <Planet> theQuery = currentSession.createQuery("from Planet where name like :name", Planet.class);
		
		theQuery.setParameter("name", "%" + theName + "%");
		
		List <Planet> planets = theQuery.getResultList();
		
		return planets;
	}
}
