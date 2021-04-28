/**
 * 
 */
package vn.hanu.restaurant.manager.dao;

import java.util.List;

import vn.hanu.restaurant.manager.entities.Dish;

/**
 * @author Admin
 *
 */
public interface DishDao {

	List<Dish> list();

	void save(Dish dish);

	Dish getDish(Long id);

	void update(Dish dish);

	void delete(Dish dish);

	boolean codeExist(String code);

}
