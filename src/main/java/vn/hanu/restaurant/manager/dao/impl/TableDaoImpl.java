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

import vn.hanu.restaurant.manager.dao.TableDao;
import vn.hanu.restaurant.manager.entities.Tables;

/**
 * @author Admin
 *
 */

@Repository
public class TableDaoImpl implements TableDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSessionfactory() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tables> list() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("from Tables");
		str.append(" order by id");
		Query<Tables> query = getSessionfactory().createQuery(str.toString());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tables> check(Long timeStart, Long timeOff, String dateOrder) {
		// TODO Auto-generated method stub 
		StringBuilder str = new StringBuilder("from Tables");
		str.append(" where");
		str.append(" id not in");
		str.append(" (");
		str.append(" select t.id from Tables t");
		str.append(" join TableOrderDetail tod on t.id=tod.idTable");
		str.append(" join TableOrder to on to.id=tod.idTableOrder");
		str.append(" where to.date = cast(:dateOrder as date)");
		str.append(" and (  (to.timeOff >= :timeStart and to.timeOff <= :timeOff)");
		str.append(" 	or");
		str.append(" 	(to.timeStart >= :timeStart and to.timeStart <= :timeOff)");
		str.append(" 	)");
		str.append(" )");
		Query<Tables> query = getSessionfactory().createQuery(str.toString());
		query.setParameter("timeStart", timeStart);
		query.setParameter("timeOff", timeOff);
		query.setParameter("dateOrder", dateOrder);
		return query.list();
	}

	@Override
	public void save(Tables table) {
		// TODO Auto-generated method stub
		getSessionfactory().save(table);
	}

	@Override
	public Tables getTable(Long id) {
		// TODO Auto-generated method stub
		return getSessionfactory().get(Tables.class, id);
	}

	@Override
	public void update(Tables table) {
		// TODO Auto-generated method stub
		getSessionfactory().update(table);
	}

	@Override
	public void delete(Tables table) {
		// TODO Auto-generated method stub
		getSessionfactory().delete(table);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean codeExist(String code) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("select count(code) from Tables where code = :code");
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
	public Long count(Long timeStart, Long timeOff, String dateOrder) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("select count(1) from Tables");
		str.append(" where");
		str.append(" id not in");
		str.append(" (");
		str.append(" select t.id from Tables t");
		str.append(" join TableOrderDetail tod on t.id=tod.idTable");
		str.append(" join TableOrder to on to.id=tod.idTableOrder");
		str.append(" where to.date = cast(:dateOrder as date)");
		str.append(" and (  (to.timeOff >= :timeStart and to.timeOff <= :timeOff)");
		str.append(" 	or");
		str.append(" 	(to.timeStart >= :timeStart and to.timeStart <= :timeOff)");
		str.append(" 	)");
		str.append(" )");
		Query query = getSessionfactory().createQuery(str.toString());
		query.setParameter("timeStart", timeStart);
		query.setParameter("timeOff", timeOff);
		query.setParameter("dateOrder", dateOrder);
		return (Long) query.uniqueResult();
	}

}
