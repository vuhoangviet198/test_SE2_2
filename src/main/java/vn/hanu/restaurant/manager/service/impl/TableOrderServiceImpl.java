/**
 * 
 */
package vn.hanu.restaurant.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.hanu.restaurant.manager.dao.TableOrderDao;
import vn.hanu.restaurant.manager.entities.TableOrder;
import vn.hanu.restaurant.manager.entities.TableOrderDetail;
import vn.hanu.restaurant.manager.service.TableOrderService;

/**
 * @author Admin
 *
 */

@Service
@Transactional
public class TableOrderServiceImpl implements TableOrderService {

	@Autowired
	TableOrderDao tableOrderDao;

	@Override
	public void save(TableOrder tableOrder) {
		// TODO Auto-generated method stub
		tableOrderDao.save(tableOrder);
	}

	@Override
	public Long getIdByCode(String code) {
		// TODO Auto-generated method stub
		return tableOrderDao.getIdByCode(code);
	}

	@Override
	public void save(TableOrderDetail tableOrderDetail) {
		// TODO Auto-generated method stub
		tableOrderDao.save(tableOrderDetail);
	}

	@Override
	public List<TableOrder> list() {
		// TODO Auto-generated method stub
		return tableOrderDao.list();
	}

	@Override
	public TableOrder getTableOrder(Long id) {
		// TODO Auto-generated method stub
		return tableOrderDao.getTableOrder(id);
	}

	@Override
	public void update(TableOrder tableOrder) {
		// TODO Auto-generated method stub
		tableOrderDao.update(tableOrder);
	}

}
