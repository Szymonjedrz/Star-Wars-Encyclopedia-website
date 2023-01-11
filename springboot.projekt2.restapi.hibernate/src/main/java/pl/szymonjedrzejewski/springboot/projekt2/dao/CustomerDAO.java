package pl.szymonjedrzejewski.springboot.projekt2.dao;

import java.util.List;
import pl.szymonjedrzejewski.springboot.projekt2.entity.Customer;

public interface CustomerDAO {
	
	public List <Customer> findAll();
	
	public Customer findById (int theId);
	
	public void save (Customer theCustomer);
	
	public void deleteById (int theId);
}
