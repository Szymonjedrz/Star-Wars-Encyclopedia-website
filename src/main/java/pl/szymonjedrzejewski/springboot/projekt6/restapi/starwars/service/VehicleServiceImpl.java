package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.dao.VehicleDAO;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	private VehicleDAO vehicleDAO;

	@Autowired
	public VehicleServiceImpl(VehicleDAO theVehicleDAO) {
		this.vehicleDAO = theVehicleDAO;
	}

	@Override
	@Transactional
	public List <Vehicle> findAll() {
		return vehicleDAO.findAll();
	}

	@Override
	@Transactional
	public Vehicle findById(int theId) {
		return vehicleDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Vehicle vehicle) {
		vehicleDAO.save(vehicle);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		vehicleDAO.deleteById(theId);
	}

	@Override
	@Transactional
	public Iterable <Vehicle> save (List<Vehicle> vehicles) {
		return vehicleDAO.save(vehicles);
	}

	@Override
	@Transactional
	public List <Vehicle> searchBy (String theName) {
		return vehicleDAO.searchBy(theName);
	}

}
