/**
 * 
 */
package vn.hanu.restaurant.manager.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import vn.hanu.restaurant.manager.entities.Employee;

/**
 * @author Admin
 *
 */
public interface EmployeeService {
	List<Employee> list();

	String saveImage(String code, MultipartFile file);

	void save(Employee employee);

	Employee getEmployee(Long id);

	void update(Employee employee);

	boolean usernameExist(String username);

	boolean codeExist(String code);
}
