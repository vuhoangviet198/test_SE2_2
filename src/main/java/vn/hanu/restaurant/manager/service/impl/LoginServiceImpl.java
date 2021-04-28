/**
 * 
 */
package vn.hanu.restaurant.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.hanu.restaurant.manager.dao.LoginDao;
import vn.hanu.restaurant.manager.entities.Employee.TypeEmployee;
import vn.hanu.restaurant.manager.service.LoginService;

/**
 * @author Admin
 *
 */

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	@Override
	public TypeEmployee getType(String username, String password) {
		// TODO Auto-generated method stub
		return loginDao.getType(username, password);
	}

	@Override
	public String getUsername(String username, String password) {
		// TODO Auto-generated method stub
		return loginDao.getUsername(username, password);
	}

	@Override
	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		return loginDao.checkLogin(username, password);
	}

}
