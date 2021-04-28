/**
 * 
 */
package vn.hanu.restaurant.manager.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.hanu.restaurant.manager.dao.LoginDao;
import vn.hanu.restaurant.manager.entities.Employee.TypeEmployee;

/**
 * @author Admin
 *
 */

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSessionfactory() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public TypeEmployee getType(String username, String password) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("select type");
		str.append(" from");
		str.append(" Employee");
		str.append(" where");
		str.append(" username = :username");
		str.append(" and password = :password");
		Query query = getSessionfactory().createQuery(str.toString());
		query.setParameter("username", username);
		query.setParameter("password", password);
		return (TypeEmployee) query.uniqueResult();
	}

	@Override
	public String getUsername(String username, String password) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("select fullname");
		str.append(" from");
		str.append(" Employee");
		str.append(" where");
		str.append(" username = :username");
		str.append(" and password = :password");
		str.append(" and blockStatus = :blockStatus");
		Query query = getSessionfactory().createQuery(str.toString());
		query.setParameter("password", password);
		query.setParameter("username", username);
		query.setParameter("blockStatus", false);
		return (String) query.uniqueResult();
	}

	@Override
	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		boolean flg = true;
		StringBuilder str = new StringBuilder("select count(1)");
		str.append(" from");
		str.append(" Employee");
		str.append(" where");
		str.append(" username = :username");
		str.append(" and password = :password");
		str.append(" and blockStatus = :blockStatus");
		Query query = getSessionfactory().createQuery(str.toString());
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.setParameter("blockStatus", false);
		Long check = (Long) query.uniqueResult();
		if (check > 0) {
			flg = true;
		} else if (check == 0) {
			flg = false;
		}
		return flg;
	}

}
