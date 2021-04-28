/**
 * 
 */
package vn.hanu.restaurant.manager.service;

import java.util.List;

import vn.hanu.restaurant.manager.entities.CategoryDish;

/**
 * @author Admin
 *
 */
public interface CategoryService {
	List<CategoryDish> list();

	void save(CategoryDish categoryDish);

	CategoryDish getCategoryDish(Long id);

	void update(CategoryDish categoryDish);

	void delete(CategoryDish categoryDish);

	boolean codeExist(String code);
	
	boolean checkDelete(Long id);
}
