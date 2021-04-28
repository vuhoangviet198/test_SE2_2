/**
 * 
 */
package vn.hanu.restaurant.manager.controller;

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

import vn.hanu.restaurant.manager.entities.Dish;
import vn.hanu.restaurant.manager.model.DishDto;
import vn.hanu.restaurant.manager.service.CategoryService;
import vn.hanu.restaurant.manager.service.DishService;
import vn.hanu.restaurant.manager.utils.DataTransformUtil;

/**
 * @author Admin
 *
 */

@Controller
public class DishController {

	@Autowired
	DishService dishService;

	@Autowired
	CategoryService categoryService;

	@GetMapping("/dish")
	public String dish(ModelMap model) {
		List<Dish> list = dishService.list();
		model.addAttribute("list", list);
		return "dish/list";
	}

	@GetMapping("/dish-create")
	public String save(ModelMap model) {
		model.addAttribute("dishDto", new DishDto());
		model.addAttribute("listCategory", categoryService.list());
		return "dish/create";
	}

	@PostMapping("/dish-create")
	public String save(ModelMap model, @RequestParam(required = false) MultipartFile file, @Valid DishDto dishDto,
			BindingResult bindingResult) {
		model.addAttribute("listCategory", categoryService.list());
		if (bindingResult.hasErrors()) {
			return "dish/create";
		}
		if (dishDto.getCode() != null && !dishDto.getCode().equals("")) {
			if (dishService.codeExist(dishDto.getCode())) {
				bindingResult.rejectValue("code", "errors.existCode");
				return "dish/create";
			}
		}
		Dish dish = (Dish) DataTransformUtil.transform(dishDto, Dish.class);
		if (file != null && !file.isEmpty()) {
			dish.setPhoto(dishService.savePhoto(file.getOriginalFilename(), file));
		}
		dishService.save(dish);
		return "redirect:/dish";
	}

	@GetMapping("/dish-update/{id}")
	public String update(ModelMap model, @PathVariable Long id) {
		Dish dish = dishService.getDish(id);
		DishDto dishDto = (DishDto) DataTransformUtil.transform(dish, DishDto.class);
		model.addAttribute("listCategory", categoryService.list());
		model.addAttribute("dishDto", dishDto);
		return "dish/update";
	}

	@PostMapping("/dish-update")
	public String update(ModelMap model, @RequestParam(required = false) MultipartFile file, @Valid DishDto dishDto,
			BindingResult bindingResult) {
		model.addAttribute("listCategory", categoryService.list());
		if (bindingResult.hasErrors()) {
			return "dish/update";
		}
		Dish dish = (Dish) DataTransformUtil.transform(dishDto, Dish.class);
		if (file != null && !file.isEmpty()) {
			dish.setPhoto(dishService.savePhoto(file.getOriginalFilename(), file));
		} else {
			dish.setPhoto(dishDto.getPhoto());
		}
		dishService.update(dish);
		return "redirect:/dish";
	}

	@GetMapping("/dish-delete/{id}")
	public String delete(ModelMap model, @PathVariable Long id) {
		Dish dish = dishService.getDish(id);
		dishService.delete(dish);
		return "redirect:/dish";
	}

}
