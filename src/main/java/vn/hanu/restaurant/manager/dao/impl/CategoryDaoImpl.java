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

import vn.hanu.restaurant.manager.dao.CategoryDao;
import vn.hanu.restaurant.manager.entities.CategoryDish;

/**
 * @author Admin
 *
 */

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSessionfactory() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryDish> list() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("from CategoryDish");
		str.append(" order by id desc");
		Query<CategoryDish> query = getSessionfactory().createQuery(str.toString());
		return query.list();
	}

	@Override
	public void save(CategoryDish categoryDish) {
		// TODO Auto-generated method stub
		getSessionfactory().save(categoryDish);
	}

	@Override
	public CategoryDish getCategoryDish(Long id) {
		// TODO Auto-generated method stub
		return getSessionfactory().get(CategoryDish.class, id);
	}

	@Override
	public void update(CategoryDish categoryDish) {
		// TODO Auto-generated method stub
		getSessionfactory().update(categoryDish);
	}

	@Override
	public void delete(CategoryDish categoryDish) {
		// TODO Auto-generated method stub
		getSessionfactory().delete(categoryDish);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean codeExist(String code) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("select count(code) from CategoryDish where code = :code");
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

	@SuppressWarnings("rawtypes")
	@Override
	public boolean checkDelete(Long id) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("select count(*) from Dish where idCategoryDish = :idCategoryDish");
		Query query = getSessionfactory().createQuery(str.toString());
		query.setParameter("idCategoryDish", id);
		Long number = (Long) query.uniqueResult();
		if (number > 0) {
			return true;
		} else if (number == 0) {
			return false;
		}
		return false;
	}

}
