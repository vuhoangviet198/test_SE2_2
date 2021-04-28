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

import vn.hanu.restaurant.manager.dao.OrderDishDao;
import vn.hanu.restaurant.manager.entities.OrderDish;
import vn.hanu.restaurant.manager.entities.OrderDish.StatusOrderDish;

/**
 * @author Admin
 *
 */
@Repository
public class OrderDishDaoImpl implements OrderDishDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSessionfactory() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDish> list() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("from OrderDish");
		str.append(" where status not in :status");
		str.append(" order by id desc");
		Query<OrderDish> query = getSessionfactory().createQuery(str.toString());
		query.setParameter("status", StatusOrderDish.OPEN);
		return query.list();
	}

	@Override
	public void update(OrderDish orderDish) {
		// TODO Auto-generated method stub
		getSessionfactory().update(orderDish);
	}

	@Override
	public OrderDish getOrderDish(Long id) {
		// TODO Auto-generated method stub
		return getSessionfactory().get(OrderDish.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> listDetail(Long idOrderDish) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("select d.name,d.photo,d.price,odd.quantity");
		str.append(" from");
		str.append(" Dish d join OrderDishDetail odd on d.id=odd.dishId");
		str.append(" join OrderDish od on od.id=odd.orderDishId");
		str.append(" where");
		str.append(" od.id = :idOrderDish");
		Query<Object[]> query = getSessionfactory().createQuery(str.toString());
		query.setParameter("idOrderDish", idOrderDish);
		return query.list();
	}

}
