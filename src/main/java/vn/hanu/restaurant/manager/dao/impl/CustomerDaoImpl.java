/**
 * 
 */
package vn.hanu.restaurant.manager.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.hanu.restaurant.manager.dao.CustomerDao;
import vn.hanu.restaurant.manager.entities.Customer;
/**
 * @author Admin
 *
 */

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSessionfactory() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> list() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("from Customer");
		str.append(" order by id desc");
		Query<Customer> query = getSessionfactory().createQuery(str.toString());
		return query.list();
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		customer.setInsDate(new Date());
		customer.setBlockStatus(false);
		getSessionfactory().save(customer);
	}

	@Override
	public Customer getCustomer(Long id) {
		// TODO Auto-generated method stub
		return getSessionfactory().get(Customer.class, id);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		getSessionfactory().update(customer);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean usernameExist(String username) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("select count(username) from Customer where username = :username");
		Query query = getSessionfactory().createQuery(str.toString());
		query.setParameter("username", username);
		Long number = (Long) query.uniqueResult();
		if (number > 0) {
			return true;
		} else if (number == 0) {
			return false;
		}
		return false;
	}

}
