/**
 * 
 */
package vn.hanu.restaurant.manager.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import vn.hanu.restaurant.manager.entities.Dish;

/**
 * @author Admin
 *
 */
public interface DishService {
	List<Dish> list();

	void save(Dish dish);

	Dish getDish(Long id);

	void update(Dish dish);

	void delete(Dish dish);

	boolean codeExist(String code);

	String savePhoto(String code, MultipartFile file);
}
