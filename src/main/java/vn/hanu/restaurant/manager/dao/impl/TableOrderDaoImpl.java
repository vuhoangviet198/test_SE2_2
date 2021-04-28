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

import vn.hanu.restaurant.manager.dao.TableOrderDao;
import vn.hanu.restaurant.manager.entities.TableOrder;
import vn.hanu.restaurant.manager.entities.TableOrderDetail;

/**
 * @author Admin
 *
 */

@Repository
public class TableOrderDaoImpl implements TableOrderDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSessionfactory() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(TableOrder tableOrder) {
		// TODO Auto-generated method stub
		getSessionfactory().save(tableOrder);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Long getIdByCode(String code) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("select id");
		str.append(" from");
		str.append(" TableOrder");
		str.append(" where code = :code");
		Query query = getSessionfactory().createQuery(str.toString());
		query.setParameter("code", code);
		return (Long) query.uniqueResult();
	}

	@Override
	public void save(TableOrderDetail tableOrderDetail) {
		// TODO Auto-generated method stub
		getSessionfactory().save(tableOrderDetail);
	}

	@Override
	public List<TableOrder> list() {
		// TODO Auto-generated method stub
		return getSessionfactory().createQuery("from TableOrder", TableOrder.class).list();
	}

	@Override
	public TableOrder getTableOrder(Long id) {
		// TODO Auto-generated method stub
		return getSessionfactory().get(TableOrder.class, id);
	}

	@Override
	public void update(TableOrder tableOrder) {
		// TODO Auto-generated method stub
		getSessionfactory().update(tableOrder);
	}

}
