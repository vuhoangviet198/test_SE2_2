/**
 * 
 */
package vn.hanu.restaurant.manager.dao;

import java.util.List;

import vn.hanu.restaurant.manager.entities.Employee;

/**
 * @author Admin
 *
 */
public interface EmployeeDao {

	List<Employee> list();

	void save(Employee employee);

	Employee getEmployee(Long id);

	void update(Employee employee);

	boolean usernameExist(String username);

	boolean codeExist(String code);

}
