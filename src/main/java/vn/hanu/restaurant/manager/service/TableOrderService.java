/**
 * 
 */
package vn.hanu.restaurant.manager.service;

import java.util.List;

import vn.hanu.restaurant.manager.entities.TableOrder;
import vn.hanu.restaurant.manager.entities.TableOrderDetail;

/**
 * @author Admin
 *
 */
public interface TableOrderService {
	void save(TableOrder tableOrder);

	Long getIdByCode(String code);
	
	void save(TableOrderDetail tableOrderDetail);
	
	List<TableOrder> list();
	
	TableOrder getTableOrder(Long id);

	void update(TableOrder tableOrder);
}
