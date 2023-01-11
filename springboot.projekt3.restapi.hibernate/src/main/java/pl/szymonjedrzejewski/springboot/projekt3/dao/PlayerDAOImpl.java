package pl.szymonjedrzejewski.springboot.projekt3.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.szymonjedrzejewski.springboot.projekt3.entity.Player;

@Repository
public class PlayerDAOImpl implements PlayerDAO {
	
	private EntityManager entityManager;

	@Autowired
	public PlayerDAOImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public List <Player> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query <Player> theQuery = currentSession.createQuery("from Player", Player.class);
		
		List <Player> players = theQuery.getResultList();
		
		return players;
	}

	@Override
	public Player findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Player thePlayer = currentSession.get(Player.class, theId);
		
		return thePlayer;
	}

	@Override
	public void save(Player thePlayer) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(thePlayer);
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Player thePlayer = currentSession.get(Player.class, theId);
		
		currentSession.delete(thePlayer);
	}
}
