/**
 * 
 */
package vn.hanu.restaurant.manager.dao;

import java.util.List;

import vn.hanu.restaurant.manager.entities.Customer;

/**
 * @author Admin
 *
 */
public interface CustomerDao {

	List<Customer> list();

	void save(Customer customer);

	Customer getCustomer(Long id);

	void update(Customer customer);
	
	boolean usernameExist(String username);

}
