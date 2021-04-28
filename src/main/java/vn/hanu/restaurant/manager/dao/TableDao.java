/**
 * 
 */
package vn.hanu.restaurant.manager.dao;

import java.util.List;

import vn.hanu.restaurant.manager.entities.Tables;

/**
 * @author Admin
 *
 */
public interface TableDao {

	List<Tables> list();
	
	List<Tables> check(Long timeStart, Long timeOff, String dateOrder);

	Long count(Long timeStart, Long timeOff, String dateOrder);

	void save(Tables table);

	Tables getTable(Long id);

	void update(Tables table);

	void delete(Tables table);

	boolean codeExist(String code);

}
