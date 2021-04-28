/**
 * 
 */
package vn.hanu.restaurant.manager.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.hanu.restaurant.manager.dao.DishDao;
import vn.hanu.restaurant.manager.entities.Dish;

/**
 * @author Admin
 *
 */

@Repository
public class DishDaoImpl implements DishDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSessionfactory() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dish> list() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("from Dish");
		str.append(" order by id desc");
		Query<Dish> query = getSessionfactory().createQuery(str.toString());
		return query.list();
	}

	@Override
	public void save(Dish dish) {
		// TODO Auto-generated method stub
		getSessionfactory().save(dish);
	}

	@Override
	public Dish getDish(Long id) {
		// TODO Auto-generated method stub
		return getSessionfactory().get(Dish.class, id);
	}

	@Override
	public void update(Dish dish) {
		// TODO Auto-generated method stub
		getSessionfactory().update(dish);
	}

	@Override
	public void delete(Dish dish) {
		// TODO Auto-generated method stub
		getSessionfactory().delete(dish);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean codeExist(String code) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("select count(code) from Dish where code = :code");
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
