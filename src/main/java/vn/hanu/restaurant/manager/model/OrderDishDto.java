/**
 * 
 */
package vn.hanu.restaurant.manager.model;

import vn.hanu.restaurant.manager.entities.OrderDish.StatusOrderDish;

/**
 * @author Admin
 *
 */
public class OrderDishDto {
	private Long id;
	private Long customerId;
	private float totalMoney;
	private String date;
	private String fullName;
	private String address;
	private String phone;
	private StatusOrderDish status;
	private String insDate;

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
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the totalMoney
	 */
	public float getTotalMoney() {
		return totalMoney;
	}

	/**
	 * @param totalMoney
	 *            the totalMoney to set
	 */
	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the status
	 */
	public StatusOrderDish getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(StatusOrderDish status) {
		this.status = status;
	}

	/**
	 * @return the insDate
	 */
	public String getInsDate() {
		return insDate;
	}

	/**
	 * @param insDate
	 *            the insDate to set
	 */
	public void setInsDate(String insDate) {
		this.insDate = insDate;
	}

}
