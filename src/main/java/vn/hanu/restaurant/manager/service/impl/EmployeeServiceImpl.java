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

import vn.hanu.restaurant.manager.dao.EmployeeDao;
import vn.hanu.restaurant.manager.entities.Employee;
import vn.hanu.restaurant.manager.service.EmployeeService;

/**
 * @author Admin
 *
 */

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	ServletContext context;

	public List<Employee> list() {
		// TODO Auto-generated method stub
		return employeeDao.list();
	}

	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
	}

	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployee(id);
	}

	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);
	}

	public boolean usernameExist(String username) {
		// TODO Auto-generated method stub
		return employeeDao.usernameExist(username);
	}

	public boolean codeExist(String code) {
		// TODO Auto-generated method stub
		return employeeDao.codeExist(code);
	}

	@Override
	public String saveImage(String code, MultipartFile file) {
		// TODO Auto-generated method stub
		String uploadFileSavePath = context.getRealPath("/WEB-INF/assets/images/");
		String originalFileName = file.getOriginalFilename();

		StringBuilder stbFilePath = new StringBuilder(uploadFileSavePath);
		stbFilePath.append(code);
		stbFilePath.append(originalFileName.substring(originalFileName.lastIndexOf('.')));

		File saveFile = new File(stbFilePath.toString());
		try {
			file.transferTo(saveFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return stbFilePath.toString().replace(uploadFileSavePath, StringUtils.EMPTY);
	}

}
