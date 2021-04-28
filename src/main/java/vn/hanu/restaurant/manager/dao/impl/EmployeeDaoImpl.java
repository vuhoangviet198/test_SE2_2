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

import vn.hanu.restaurant.manager.dao.EmployeeDao;
import vn.hanu.restaurant.manager.entities.Employee;

/**
 * @author Admin
 *
 */

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSessionfactory() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> list() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("from Employee");
		str.append(" order by id desc");
		Query<Employee> query = getSessionfactory().createQuery(str.toString());
		return query.list();
	}

	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employee.setDateJoin(new Date());
		employee.setBlockStatus(false);
		getSessionfactory().save(employee);
	}

	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		return getSessionfactory().get(Employee.class, id);
	}

	public void update(Employee employee) {
		// TODO Auto-generated method stub
		getSessionfactory().update(employee);
	}

	@SuppressWarnings("rawtypes")
	public boolean usernameExist(String username) {
		// TODO Auto-generated method stub
		boolean exist = false;
		StringBuilder str = new StringBuilder("select count(username) from Employee where username = :username");
		Query query = getSessionfactory().createQuery(str.toString());
		query.setParameter("username", username);
		Long number = (Long) query.uniqueResult();
		if (number > 0 || number < 0) {
			exist = true;
			return exist;
		} else {
			exist = false;
			return exist;
		}
	}

	@SuppressWarnings("rawtypes")
	public boolean codeExist(String code) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("select count(code) from Employee where code = :code");
		Query query = getSessionfactory().createQuery(str.toString());
		query.setParameter("code", code);
		Long number = (Long) query.uniqueResult();
		if (number > 0) {
			return true;
		} else if (number == 0) {
			return false;
		}
		return false;
	}

}
