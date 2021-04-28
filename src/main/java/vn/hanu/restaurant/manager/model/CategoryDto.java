/**
 * 
 */
package vn.hanu.restaurant.manager.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Admin
 *
 */
public class CategoryDto {
	private Long id;
	@NotEmpty(message="Mã danh mục không được để trống")
	private String code;
	@NotEmpty(message="Tên danh mục không được để trống")
	private String name;

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

}
