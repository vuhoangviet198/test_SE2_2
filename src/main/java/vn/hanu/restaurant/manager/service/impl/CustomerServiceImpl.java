/**
 * 
 */
package vn.hanu.restaurant.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.hanu.restaurant.manager.dao.CustomerDao;
import vn.hanu.restaurant.manager.entities.Customer;
import vn.hanu.restaurant.manager.service.CustomerService;

/**
 * @author Admin
 *
 */

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Override
	public List<Customer> list() {
		// TODO Auto-generated method stub
		return customerDao.list();
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.save(customer);
	}

	@Override
	public Customer getCustomer(Long id) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(id);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.update(customer);
	}

	@Override
	public boolean usernameExist(String username) {
		// TODO Auto-generated method stub
		return customerDao.usernameExist(username);
	}

}
