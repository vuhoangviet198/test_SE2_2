/**
 * 
 */
package vn.hanu.restaurant.manager.dao;

import vn.hanu.restaurant.manager.entities.Employee.TypeEmployee;

/**
 * @author Admin
 *
 */
public interface LoginDao {
	TypeEmployee getType(String username, String password);

	String getUsername(String username, String password);

	boolean checkLogin(String username, String password);
}
