/**
 * 
 */
package vn.hanu.restaurant.manager.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.hanu.restaurant.manager.entities.Employee.TypeEmployee;
import vn.hanu.restaurant.manager.model.CustomerDto;
import vn.hanu.restaurant.manager.model.EmployeeDto;
import vn.hanu.restaurant.manager.service.LoginService;

/**
 * @author Admin
 *
 */

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@GetMapping("/")
	public String login(ModelMap model) {
		model.addAttribute("employeeDto", new EmployeeDto());
		System.out.println("------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("new source");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------");
		return "login";
	}

	@PostMapping("/loginProcess")
	public String loginProcess(@RequestParam(required = false) String username,
			@RequestParam(required = false) String password, @Valid EmployeeDto employeeDto,
			BindingResult bindingResult, HttpSession session, ModelMap model) {
		boolean checkLogin = loginService.checkLogin(username, password);
		if (!checkLogin) {
			model.addAttribute("message", "Có lỗi khi đăng nhập");
			return "login";
		} else {
			String typeAccount = loginService.getType(username, password).toString();
			String usernameLogin = loginService.getUsername(username, password);
			session.setAttribute("typeAccount", typeAccount);
			session.setAttribute("usernameLogin", usernameLogin);
			return "redirect:/employee";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("typeAccount");
		session.removeAttribute("usernameLogin");
		return "redirect:/";
	}
}
