/**
 * 
 */
package vn.hanu.restaurant.manager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Admin
 *
 */

@Entity
@Table(name = "Order_Dish_Detail")
public class OrderDishDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "order_dish_id")
	private Long orderDishId;
	@Column(name = "dish_id")
	private Long dishId;
	private Long quantity;
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false, name = "dish_id")
	private Dish dish;
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false, name = "order_dish_id")
	private OrderDish orderDish;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the orderDishId
	 */
	public Long getOrderDishId() {
		return orderDishId;
	}

	/**
	 * @param orderDishId
	 *            the orderDishId to set
	 */
	public void setOrderDishId(Long orderDishId) {
		this.orderDishId = orderDishId;
	}

	/**
	 * @return the dishId
	 */
	public Long getDishId() {
		return dishId;
	}

	/**
	 * @param dishId
	 *            the dishId to set
	 */
	public void setDishId(Long dishId) {
		this.dishId = dishId;
	}

	/**
	 * @return the quantity
	 */
	public Long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the dish
	 */
	public Dish getDish() {
		return dish;
	}

	/**
	 * @param dish
	 *            the dish to set
	 */
	public void setDish(Dish dish) {
		this.dish = dish;
	}

	/**
	 * @return the orderDish
	 */
	public OrderDish getOrderDish() {
		return orderDish;
	}

	/**
	 * @param orderDish
	 *            the orderDish to set
	 */
	public void setOrderDish(OrderDish orderDish) {
		this.orderDish = orderDish;
	}

}
