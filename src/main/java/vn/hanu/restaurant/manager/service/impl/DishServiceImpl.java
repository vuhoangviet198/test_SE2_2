/**
 * 
 */
package vn.hanu.restaurant.manager.service.impl;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import vn.hanu.restaurant.manager.dao.DishDao;
import vn.hanu.restaurant.manager.entities.Dish;
import vn.hanu.restaurant.manager.service.DishService;

/**
 * @author Admin
 *
 */

@Service
@Transactional
public class DishServiceImpl implements DishService {

	@Autowired
	DishDao dishDao;

	@Autowired
	ServletContext context;

	@Override
	public List<Dish> list() {
		// TODO Auto-generated method stub
		return dishDao.list();
	}

	@Override
	public void save(Dish dish) {
		// TODO Auto-generated method stub
		dishDao.save(dish);
	}

	@Override
	public Dish getDish(Long id) {
		// TODO Auto-generated method stub
		return dishDao.getDish(id);
	}

	@Override
	public void update(Dish dish) {
		// TODO Auto-generated method stub
		dishDao.update(dish);
	}

	@Override
	public void delete(Dish dish) {
		// TODO Auto-generated method stub
		dishDao.delete(dish);
	}

	@Override
	public boolean codeExist(String code) {
		// TODO Auto-generated method stub
		return dishDao.codeExist(code);
	}

	@Override
	public String savePhoto(String fileName, MultipartFile file) {
		// TODO Auto-generated method stub
		String uploadFileSavePath = context.getRealPath("/WEB-INF/assets/images/");

		StringBuilder stbFilePath = new StringBuilder(uploadFileSavePath);
		stbFilePath.append(fileName);

		File saveFile = new File(stbFilePath.toString());
		try {
			file.transferTo(saveFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return stbFilePath.toString().replace(uploadFileSavePath, StringUtils.EMPTY);
	}

}
