/**
 * 
 */
package vn.hanu.restaurant.manager.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.multipart.MultipartFile;

import vn.hanu.restaurant.manager.entities.Employee;
import vn.hanu.restaurant.manager.model.EmployeeDto;
import vn.hanu.restaurant.manager.service.EmployeeService;

/**
 * @author Admin
 *
 */

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employee")
	public String employee(ModelMap model) {
		List<Employee> list = employeeService.list();
		model.addAttribute("list", list);
		return "employee/list";
	}

	@GetMapping("/employee-create")
	public String save(ModelMap model) {
		model.addAttribute("employeeDto", new EmployeeDto());
		return "employee/create";
	}

	@PostMapping("/employee-create")
	public String save(@Valid EmployeeDto employeeDto, BindingResult bindingResult,
			@RequestParam(required = false) MultipartFile file) {
		try {
			if (bindingResult.hasErrors()) {
				return "employee/create";
			}
			Employee employee = new Employee();
			if (employeeDto.getUsername() != null && !employeeDto.getUsername().equals("")) {
				if (employeeService.usernameExist(employeeDto.getUsername())) {
					bindingResult.rejectValue("username", "errors.existUsername");
					return "employee/create";
				}
			} else if (employeeDto.getCode() != null && !employeeDto.getCode().equals("")) {
				if (employeeService.codeExist(employeeDto.getCode())) {
					bindingResult.rejectValue("code", "errors.existCode");
					return "employee/create";
				}
			}
			if (file != null && !file.isEmpty()) {
				employee.setImage(employeeService.saveImage(employeeDto.getCode(), file));
			}
			if (employeeDto.getBirthday() != null && !employeeDto.getBirthday().equals("")) {
				Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(employeeDto.getBirthday());
				employee.setBirthday(birthday);
			}
			if (employeeDto.getDateOut() != null && !employeeDto.getDateOut().equals("")) {
				Date dateOut = new SimpleDateFormat("yyyy-MM-dd").parse(employeeDto.getDateOut());
				employee.setDateOut(dateOut);
			}
			employee.setBaseSalary(employeeDto.getBaseSalary());
			employee.setCode(employeeDto.getCode());
			employee.setFullname(employeeDto.getFullname());
			employee.setGender(employeeDto.getGender());
			employee.setHometown(employeeDto.getHometown());
			employee.setJob(employeeDto.getJob());
			employee.setPassword(employeeDto.getPassword());
			employee.setType(employeeDto.getType());
			employee.setUsername(employeeDto.getUsername());
			employeeService.save(employee);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/employee";
	}

	@SuppressWarnings("unlikely-arg-type")
	@GetMapping("/employee-update/{id}/{code}")
	public String update(ModelMap model, @PathVariable Long id, @PathVariable String code) {
		model.addAttribute("code", code);
		EmployeeDto employeeDto = new EmployeeDto();
		Employee employee = employeeService.getEmployee(id);
		employeeDto.setId(id);
		employeeDto.setBaseSalary(employee.getBaseSalary());
		employeeDto.setCode(employee.getCode());
		employeeDto.setFullname(employee.getFullname());
		employeeDto.setGender(employee.getGender());
		employeeDto.setHometown(employee.getHometown());
		employeeDto.setJob(employee.getJob());
		employeeDto.setPassword(employee.getPassword());
		employeeDto.setType(employee.getType());
		employeeDto.setUsername(employee.getUsername());
		employeeDto.setImage(employee.getImage());
		employeeDto.setBlockStatus(employee.isBlockStatus());
		if (employee.getBirthday() != null && !employee.getBirthday().equals("")) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String birthday = dateFormat.format(employee.getBirthday());
			employeeDto.setBirthday(birthday);
		}
		if (employeeDto.getDateOut() != null && !employeeDto.getDateOut().equals("")) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateOut = dateFormat.format(employee.getDateOut());
			employeeDto.setDateOut(dateOut);
		}
		model.addAttribute("employeeDto", employeeDto);
		return "employee/update";
	}

	@PostMapping("/employee-update-process/{code}")
	public String update(@PathVariable String code, @Valid EmployeeDto employeeDto, BindingResult bindingResult,
			@RequestParam(required = false) MultipartFile file) {
		try {
			if (bindingResult.hasErrors()) {
				return "employee/update";
			}
			Employee employee = new Employee();
			if (employeeDto.getCode() != null && !employeeDto.getCode().equals("")) {
				if (employeeDto.getCode() != code && !employeeDto.getCode().equals(code)) {
					if (employeeService.codeExist(employeeDto.getCode())) {
						bindingResult.rejectValue("code", "errors.existCode");
						return "employee/create";
					}
				}
			}
			if (file != null && !file.isEmpty()) {
				employee.setImage(employeeService.saveImage(employeeDto.getCode(), file));
			} else {
				employee.setImage(employeeDto.getImage());
			}
			Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(employeeDto.getBirthday());
			employee.setBirthday(birthday);
			if (employeeDto.getDateOut() != null && !employeeDto.getDateOut().equals("")) {
				Date dateOut = new SimpleDateFormat("yyyy-MM-dd").parse(employeeDto.getDateOut());
				employee.setDateOut(dateOut);
			}
			employee.setBaseSalary(employeeDto.getBaseSalary());
			employee.setCode(employeeDto.getCode());
			employee.setFullname(employeeDto.getFullname());
			employee.setGender(employeeDto.getGender());
			employee.setHometown(employeeDto.getHometown());
			employee.setJob(employeeDto.getJob());
			employee.setPassword(employeeDto.getPassword());
			employee.setType(employeeDto.getType());
			employee.setUsername(employeeDto.getUsername());
			employee.setBlockStatus(employeeDto.isBlockStatus());
			employee.setId(employeeDto.getId());
			employeeService.update(employee);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/employee";
	}

}
