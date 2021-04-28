/**
 * 
 */
package vn.hanu.restaurant.manager.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import vn.hanu.restaurant.manager.entities.OrderDish;
import vn.hanu.restaurant.manager.model.OrderDishDto;
import vn.hanu.restaurant.manager.service.OrderDishService;

/**
 * @author Admin
 *
 */

@Controller
public class OrderDishController {

	@Autowired
	OrderDishService orderDishService;
	
	@GetMapping("/order-dish")
	public String order(ModelMap model) {
		List<OrderDish> list = orderDishService.list();
		model.addAttribute("list", list);
		return "order-dish/list";
	}
	
	@GetMapping("/order-dish-update/{id}")
	public String update(ModelMap model, @PathVariable Long id) {
		OrderDish orderDish = orderDishService.getOrderDish(id);
		OrderDishDto orderDishDto = new OrderDishDto();
		if (orderDish.getDate() != null && !orderDish.getDate().equals("")) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String date = dateFormat.format(orderDish.getDate());
			orderDishDto.setDate(date);
		}
		if (orderDish.getInsDate() != null && !orderDish.getInsDate().equals("")) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String insDate = dateFormat.format(orderDish.getInsDate());
			orderDishDto.setInsDate(insDate);
		}
		orderDishDto.setAddress(orderDish.getAddress());
		orderDishDto.setCustomerId(orderDish.getCustomerId());
		orderDishDto.setFullName(orderDish.getFullName());
		orderDishDto.setId(id);
		orderDishDto.setPhone(orderDish.getPhone());
		orderDishDto.setStatus(orderDish.getStatus());
		orderDishDto.setTotalMoney(orderDish.getTotalMoney());
		model.addAttribute("orderDishDto", orderDishDto);
		model.addAttribute("listDetail",orderDishService.listDetail(id));
		return "order-dish/update";
	}
	
	@PostMapping("/order-dish-update")
	public String update(OrderDishDto orderDishDto) throws ParseException {
		OrderDish orderDish = new OrderDish();
		if (orderDishDto.getDate() != null && !orderDishDto.getDate().equals("")) {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(orderDishDto.getDate());
			orderDish.setDate(date);
		}
		if (orderDishDto.getInsDate() != null && !orderDishDto.getInsDate().equals("")) {
			Date insDate = new SimpleDateFormat("yyyy-MM-dd").parse(orderDishDto.getInsDate());
			orderDish.setInsDate(insDate);
		}
		orderDish.setAddress(orderDishDto.getAddress());
		orderDish.setCustomerId(orderDishDto.getCustomerId());
		orderDish.setFullName(orderDishDto.getFullName());
		orderDish.setId(orderDishDto.getId());
		orderDish.setPhone(orderDishDto.getPhone());
		orderDish.setStatus(orderDishDto.getStatus());
		orderDish.setTotalMoney(orderDishDto.getTotalMoney());
		orderDishService.update(orderDish);
		return "redirect:/order-dish";
	}

}
