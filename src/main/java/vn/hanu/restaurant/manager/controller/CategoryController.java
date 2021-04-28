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

import vn.hanu.restaurant.manager.entities.CategoryDish;
import vn.hanu.restaurant.manager.model.CategoryDto;
import vn.hanu.restaurant.manager.service.CategoryService;
import vn.hanu.restaurant.manager.utils.DataTransformUtil;

/**
 * @author Admin
 *
 */

// test test_SE2
@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/category")
	public String category(ModelMap model) {
		List<CategoryDish> list = categoryService.list();
		model.addAttribute("list", list);
		return "category/list";
	}

	@GetMapping("/category-create")
	public String save(ModelMap model) {
		model.addAttribute("categoryDto", new CategoryDto());
		return "category/create";
	}

	@PostMapping("/category-create")
	public String save(@Valid CategoryDto categoryDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "category/create";
		}
		if (categoryDto.getCode() != null && !categoryDto.getCode().equals("")) {
			if (categoryService.codeExist(categoryDto.getCode())) {
				bindingResult.rejectValue("code", "errors.existCode");
				return "category/create";
			}
		}
		CategoryDish categoryDish = (CategoryDish) DataTransformUtil.transform(categoryDto, CategoryDish.class);
		categoryService.save(categoryDish);
		return "redirect:/category";
	}

	@GetMapping("/category-update/{id}")
	public String update(ModelMap model, @PathVariable Long id) {
		CategoryDish categoryDish = categoryService.getCategoryDish(id);
		CategoryDto categoryDto = (CategoryDto) DataTransformUtil.transform(categoryDish, CategoryDto.class);
		model.addAttribute("categoryDto", categoryDto);
		return "category/update";
	}

	@PostMapping("/category-update")
	public String update(@Valid CategoryDto categoryDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "category/update";
		}
		CategoryDish categoryDish = (CategoryDish) DataTransformUtil.transform(categoryDto, CategoryDish.class);
		categoryService.update(categoryDish);
		return "redirect:/category";
	}

	@GetMapping("/category-delete/{id}")
	public String delete(ModelMap model, @PathVariable Long id) {
		if (categoryService.checkDelete(id)) {
			model.addAttribute("message", "Danh mục này vẫn còn món ăn, bạn không thể xóa");
			List<CategoryDish> list = categoryService.list();
			model.addAttribute("list", list);
			return "category/list";
		}
		CategoryDish categoryDish = categoryService.getCategoryDish(id);
		categoryService.delete(categoryDish);
		return "redirect:/category";
	}
}
