package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Vehicle;

@Repository
public class VehicleDAOImpl implements VehicleDAO {
	
	private EntityManager entityManager;

	@Autowired
	public VehicleDAOImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public List <Vehicle> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query <Vehicle> theQuery = currentSession.createQuery("from Vehicle", Vehicle.class);
		
		List <Vehicle> vehicles = theQuery.getResultList();
		
		return vehicles;
	}

	@Override
	public Vehicle findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Vehicle theVehicle = currentSession.get(Vehicle.class, theId);
		
		return theVehicle;
	}

	@Override
	public void save(Vehicle vehicle) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(vehicle);
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Vehicle theVehicle = currentSession.get(Vehicle.class, theId);
		
		currentSession.delete(theVehicle);
	}

	@Override
	public Iterable <Vehicle> save (List <Vehicle> vehicles) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		for (Vehicle theVehicle : vehicles) {
			currentSession.save(theVehicle);
		}
		
		return vehicles;
	}

	@Override
	public List <Vehicle> searchBy (String theName) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query <Vehicle> theQuery = currentSession.createQuery("from Vehicle where name like :name", Vehicle.class);
		
		theQuery.setParameter("name", "%" + theName + "%");
		
		List <Vehicle> vehicles = theQuery.getResultList();
		
		return vehicles;
	}
}
