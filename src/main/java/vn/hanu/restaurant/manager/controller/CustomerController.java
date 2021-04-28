/**
 * 
 */
package vn.hanu.restaurant.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vn.hanu.restaurant.manager.entities.Customer;
import vn.hanu.restaurant.manager.service.CustomerService;

/**
 * @author Admin
 *
 */

@Controller
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@GetMapping("/customer")
	public String customer(ModelMap model) {
		List<Customer> list = customerService.list();
		model.addAttribute("list", list);
		return "customer/list";
	}

	@GetMapping("/customer-open-block/{id}")
	public String openBlock(@PathVariable Long id) {
		Customer customer = customerService.getCustomer(id);
		customer.setBlockStatus(false);
		customerService.update(customer);
		return "redirect:/customer";
	}

	@GetMapping("/customer-block/{id}")
	public String block(@PathVariable Long id) {
		Customer customer = customerService.getCustomer(id);
		customer.setBlockStatus(true);
		customerService.update(customer);
		return "redirect:/customer";
	}

}
