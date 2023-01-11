package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Film;

@Repository
public class FilmDAOImpl implements FilmDAO {
	
	private EntityManager entityManager;

	@Autowired
	public FilmDAOImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public List <Film> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query <Film> theQuery = currentSession.createQuery("from Film", Film.class);
		
		List <Film> films = theQuery.getResultList();
		
		return films;
	}

	@Override
	public Film findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Film theFilm = currentSession.get(Film.class, theId);
		
		return theFilm;
	}

	@Override
	public void save(Film film) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(film);
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Film theFilm = currentSession.get(Film.class, theId);
		
		currentSession.delete(theFilm);
	}

	@Override
	public Iterable <Film> save (List <Film> films) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		for (Film film : films) {
			currentSession.save(film);
		}
		
		return films;
	}

	@Override
	public List <Film> searchBy(String theName) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query <Film> theQuery = currentSession.createQuery("from Film where title=:title", Film.class);
		
		theQuery.setParameter("title", theName);
		
		List <Film> films = theQuery.getResultList();
		
		return films;
	}
}
