package pl.szymonjedrzejewski.springboot.projekt2.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonjedrzejewski.springboot.projekt2.dao.CustomerDAO;
import pl.szymonjedrzejewski.springboot.projekt2.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDAO customerDAO;

	@Autowired
	public CustomerServiceImpl(CustomerDAO theCustomerDAO) {
		this.customerDAO = theCustomerDAO;
	}

	@Override
	@Transactional
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	@Override
	@Transactional
	public Customer findById(int theId) {
		return customerDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Customer theCustomer) {
		customerDAO.save(theCustomer);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		customerDAO.deleteById(theId);
	}

}
