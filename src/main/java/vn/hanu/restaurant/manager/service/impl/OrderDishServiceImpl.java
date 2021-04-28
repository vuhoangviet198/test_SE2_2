/**
 * 
 */
package vn.hanu.restaurant.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.hanu.restaurant.manager.dao.OrderDishDao;
import vn.hanu.restaurant.manager.entities.OrderDish;
import vn.hanu.restaurant.manager.service.OrderDishService;

/**
 * @author Admin
 *
 */

@Service
@Transactional
public class OrderDishServiceImpl implements OrderDishService {

	@Autowired
	OrderDishDao orderDishDao;

	@Override
	public List<OrderDish> list() {
		// TODO Auto-generated method stub
		return orderDishDao.list();
	}

	@Override
	public OrderDish getOrderDish(Long id) {
		// TODO Auto-generated method stub
		return orderDishDao.getOrderDish(id);
	}

	@Override
	public void update(OrderDish orderDish) {
		// TODO Auto-generated method stub
		orderDishDao.update(orderDish);
	}

	@Override
	public List<Object[]> listDetail(Long idOrderDish) {
		// TODO Auto-generated method stub
		return orderDishDao.listDetail(idOrderDish);
	}

}
