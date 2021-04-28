/**
 * 
 */
package vn.hanu.restaurant.manager.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.hanu.restaurant.manager.entities.TableOrder;
import vn.hanu.restaurant.manager.entities.TableOrderDetail;
import vn.hanu.restaurant.manager.entities.Tables;
import vn.hanu.restaurant.manager.entities.TableOrder.StatusTable;
import vn.hanu.restaurant.manager.model.CheckDto;
import vn.hanu.restaurant.manager.model.OrderTableDto;
import vn.hanu.restaurant.manager.model.TableDto;
import vn.hanu.restaurant.manager.service.TableOrderService;
import vn.hanu.restaurant.manager.service.TableService;
import vn.hanu.restaurant.manager.utils.DataTransformUtil;

/**
 * @author Admin
 *
 */

@Controller
public class TableController {

	@Autowired
	TableService tableService;

	@Autowired
	TableOrderService tableOrderService;

	@GetMapping("/table")
	public String table(ModelMap model) {
		List<Tables> list = tableService.list();
		model.addAttribute("list", list);
		model.addAttribute("checkDto", new CheckDto());
		model.addAttribute("orderTableDto", new OrderTableDto());
		return "table/list";
	}

	@GetMapping("/check")
	public String check(ModelMap model, @RequestParam(required = false) Long timeStart,
			@RequestParam(required = false) Long timeOff, @RequestParam(required = false) String dateOrder) {
		CheckDto checkDto = new CheckDto();
		checkDto.setDateOrder(dateOrder);
		checkDto.setTimeOff(timeOff);
		checkDto.setTimeStart(timeStart);
		model.addAttribute("checkDto", checkDto);
		List<Tables> list = tableService.check(timeStart, timeOff, dateOrder);
		Long count = tableService.count(timeStart, timeOff, dateOrder);
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("orderTableDto", new OrderTableDto());
		return "table/list";
	}

	@GetMapping("/table-create")
	public String save(ModelMap model) {
		model.addAttribute("tableDto", new TableDto());
		return "table/create";
	}

	@PostMapping("/table-create")
	public String save(ModelMap model, @Valid TableDto tableDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "table/create";
		}
		if (tableDto.getCode() != null && !tableDto.getCode().equals("")) {
			if (tableService.codeExist(tableDto.getCode())) {
				bindingResult.rejectValue("code", "errors.existCode");
				return "table/create";
			}
		}
		Tables table = (Tables) DataTransformUtil.transform(tableDto, Tables.class);
		tableService.save(table);
		return "redirect:/table";
	}

	@GetMapping("/table-update/{id}")
	public String update(ModelMap model, @PathVariable Long id) {
		Tables table = tableService.getTable(id);
		TableDto tableDto = (TableDto) DataTransformUtil.transform(table, TableDto.class);
		model.addAttribute("tableDto", tableDto);
		return "table/update";
	}

	@PostMapping("/table-update")
	public String update(ModelMap model, @Valid TableDto tableDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "table/update";
		}
		Tables table = (Tables) DataTransformUtil.transform(tableDto, Tables.class);
		tableService.update(table);
		return "redirect:/table";
	}

	@GetMapping("/table-delete/{id}")
	public String delete(ModelMap model, @PathVariable Long id) {
		Tables table = tableService.getTable(id);
		tableService.delete(table);
		return "redirect:/table";
	}

	@PostMapping("/order-table-create")
	public String orderTable(ModelMap model, @Valid OrderTableDto orderTableDto, BindingResult bindingResult)
			throws ParseException {
		if (bindingResult.hasErrors()) {
			return "table/list";
		}
		List<Long> idtable = orderTableDto.getIdtable();
		TableOrder tableOrder = new TableOrder();
		tableOrder.setCustomer(orderTableDto.getCustomer());
		tableOrder.setCode(orderTableDto.getCode());
		if (orderTableDto.getDate() != null && !orderTableDto.getDate().equals("")) {
			LocalDate date = LocalDate.parse(orderTableDto.getDate()).plusDays(1);
			tableOrder.setDate(date);
		}
		tableOrder.setQuantityTable((long) idtable.size());
		tableOrder.setStatus(StatusTable.WAIT);
		tableOrder.setTimeOff(orderTableDto.getOffTime());
		tableOrder.setTimeStart(orderTableDto.getStartTime());
		tableOrderService.save(tableOrder);
		Long idTableOrder = tableOrderService.getIdByCode(orderTableDto.getCode());
		for (Long tableId : idtable) {
			TableOrderDetail tableOrderDetail = new TableOrderDetail();
			tableOrderDetail.setIdTable(tableId);
			tableOrderDetail.setIdTableOrder(idTableOrder);
			tableOrderService.save(tableOrderDetail);
		}
		return "redirect:/table";
	}

}
