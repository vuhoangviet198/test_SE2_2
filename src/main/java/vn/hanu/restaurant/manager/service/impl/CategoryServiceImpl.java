/**
 * 
 */
package vn.hanu.restaurant.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.hanu.restaurant.manager.dao.CategoryDao;
import vn.hanu.restaurant.manager.entities.CategoryDish;
import vn.hanu.restaurant.manager.service.CategoryService;

/**
 * @author Admin
 *
 */

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	@Override
	public List<CategoryDish> list() {
		// TODO Auto-generated method stub
		return categoryDao.list();
	}

	@Override
	public void save(CategoryDish categoryDish) {
		// TODO Auto-generated method stub
		categoryDao.save(categoryDish);
	}

	@Override
	public CategoryDish getCategoryDish(Long id) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryDish(id);
	}

	@Override
	public void update(CategoryDish categoryDish) {
		// TODO Auto-generated method stub
		categoryDao.update(categoryDish);
	}

	@Override
	public void delete(CategoryDish categoryDish) {
		// TODO Auto-generated method stub
		categoryDao.delete(categoryDish);
	}

	@Override
	public boolean codeExist(String code) {
		// TODO Auto-generated method stub
		return categoryDao.codeExist(code);
	}

	@Override
	public boolean checkDelete(Long id) {
		// TODO Auto-generated method stub
		return categoryDao.checkDelete(id);
	}
}
