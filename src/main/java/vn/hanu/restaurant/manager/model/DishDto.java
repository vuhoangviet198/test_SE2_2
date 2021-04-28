/**
 * 
 */
package vn.hanu.restaurant.manager.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Admin
 *
 */
public class DishDto {

	private Long id;
	@NotEmpty(message="Mã món ăn không được để trống")
	private String code;
	@NotEmpty(message="Tên món ăn không được để trống")
	private String name;
	private String photo;
	@NotNull(message="Giá không được để trống")
	private float price;
	@NotEmpty(message="Mô tả không được để trống")
	private String description;
	@NotNull(message="Danh mục không được để trống")
	private Long idCategoryDish;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the idCategoryDish
	 */
	public Long getIdCategoryDish() {
		return idCategoryDish;
	}

	/**
	 * @param idCategoryDish
	 *            the idCategoryDish to set
	 */
	public void setIdCategoryDish(Long idCategoryDish) {
		this.idCategoryDish = idCategoryDish;
	}

}
