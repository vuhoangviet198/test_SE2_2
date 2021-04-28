/**
 * 
 */
package vn.hanu.restaurant.manager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Admin
 *
 */

@Entity
public class Dish {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String name;
	private String photo;
	private float price;
	private String description;
	@Column(name = "id_category_dish")
	private Long idCategoryDish;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(insertable = false, updatable = false, name = "id_category_dish")
	private CategoryDish categoryDish;

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

	/**
	 * @return the categoryDish
	 */
	public CategoryDish getCategoryDish() {
		return categoryDish;
	}

	/**
	 * @param categoryDish
	 *            the categoryDish to set
	 */
	public void setCategoryDish(CategoryDish categoryDish) {
		this.categoryDish = categoryDish;
	}

}
