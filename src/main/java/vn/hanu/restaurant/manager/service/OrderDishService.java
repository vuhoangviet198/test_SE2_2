/**
 * 
 */
package vn.hanu.restaurant.manager.service;

import java.util.List;

import vn.hanu.restaurant.manager.entities.OrderDish;

/**
 * @author Admin
 *
 */
public interface OrderDishService {
	List<OrderDish> list();
	
	List<Object[]> listDetail(Long idOrderDish);

	OrderDish getOrderDish(Long id);

	void update(OrderDish orderDish);
}
