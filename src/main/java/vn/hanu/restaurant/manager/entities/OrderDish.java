/**
 * 
 */
package vn.hanu.restaurant.manager.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Admin
 *
 */

@Entity
@Table(name = "Order_Dish")
public class OrderDish {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "customer_id")
	private Long customerId;
	@Column(name = "total_money")
	private float totalMoney;
	private Date date;
	private String fullName;
	private String address;
	private String phone;
	@Enumerated(EnumType.STRING)
	private StatusOrderDish status;
	@Column(name = "ins_date")
	private Date insDate;
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false, name = "customer_id")
	private Customer customer;

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
	public Date getInsDate() {
		return insDate;
	}

	/**
	 * @param insDate
	 *            the insDate to set
	 */
	public void setInsDate(Date insDate) {
		this.insDate = insDate;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public enum StatusOrderDish {
		OPEN, ACCEPT, INPROGRESS, DONE;
	}

}
