/**
 * 
 */
package vn.hanu.restaurant.manager.service;

import vn.hanu.restaurant.manager.entities.Employee.TypeEmployee;

/**
 * @author Admin
 *
 */
public interface LoginService {
	TypeEmployee getType(String username, String password);

	String getUsername(String username, String password);

	boolean checkLogin(String username, String password);
}
