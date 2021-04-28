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
import vn.hanu.restaurant.manager.entities.TableOrder;
import vn.hanu.restaurant.manager.entities.TableOrder.StatusTable;
import vn.hanu.restaurant.manager.service.TableOrderService;

/**
 * @author Admin
 *
 */

@Controller
public class TableOrderController {

	@Autowired
	TableOrderService tableOrderService;

	@GetMapping("/table-order")
	public String tableOrder(ModelMap model) {
		List<TableOrder> list = tableOrderService.list();
		model.addAttribute("list", list);
		return "table-order/list";
	}

	@GetMapping("/table-order-waiting/{id}")
	public String waiting(@PathVariable Long id) {
		TableOrder tableOrder = tableOrderService.getTableOrder(id);
		tableOrder.setStatus(StatusTable.WAIT);
		tableOrderService.update(tableOrder);
		return "redirect:/table-order";
	}

	@GetMapping("/table-order-eating/{id}")
	public String eating(@PathVariable Long id) {
		TableOrder tableOrder = tableOrderService.getTableOrder(id);
		tableOrder.setStatus(StatusTable.EATING);
		tableOrderService.update(tableOrder);
		return "redirect:/table-order";
	}

	@GetMapping("/table-order-end/{id}")
	public String end(@PathVariable Long id) {
		TableOrder tableOrder = tableOrderService.getTableOrder(id);
		tableOrder.setStatus(StatusTable.END);
		tableOrderService.update(tableOrder);
		return "redirect:/table-order";
	}
}
