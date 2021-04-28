/**
 * 
 */
package vn.hanu.restaurant.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.hanu.restaurant.manager.dao.TableDao;
import vn.hanu.restaurant.manager.entities.Tables;
import vn.hanu.restaurant.manager.service.TableService;

/**
 * @author Admin
 *
 */

@Service
@Transactional
public class TableServiceImpl implements TableService {

	@Autowired
	TableDao tableDao;

	@Override
	public List<Tables> list() {
		// TODO Auto-generated method stub
		return tableDao.list();
	}

	@Override
	public List<Tables> check(Long timeStart, Long timeOff, String dateOrder) {
		// TODO Auto-generated method stub
		return tableDao.check(timeStart, timeOff, dateOrder);
	}

	@Override
	public Long count(Long timeStart, Long timeOff, String dateOrder) {
		// TODO Auto-generated method stub
		return tableDao.count(timeStart, timeOff, dateOrder);
	}

	@Override
	public void save(Tables table) {
		// TODO Auto-generated method stub
		tableDao.save(table);
	}

	@Override
	public Tables getTable(Long id) {
		// TODO Auto-generated method stub
		return tableDao.getTable(id);
	}

	@Override
	public void update(Tables table) {
		// TODO Auto-generated method stub
		tableDao.update(table);
	}

	@Override
	public void delete(Tables table) {
		// TODO Auto-generated method stub
		tableDao.delete(table);
	}

	@Override
	public boolean codeExist(String code) {
		// TODO Auto-generated method stub
		return tableDao.codeExist(code);
	}

}
