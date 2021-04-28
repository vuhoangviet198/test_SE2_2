/**
 * 
 */
package vn.hanu.restaurant.manager.model;

import java.util.List;

/**
 * @author Admin
 *
 */
public class OrderTableDto {

	private String code;
	private String customer;
	private Long quantityTable;
	private String date;
	private Long startTime;
	private Long offTime;
	private List<Long> idtable;

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
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the quantityTable
	 */
	public Long getQuantityTable() {
		return quantityTable;
	}

	/**
	 * @param quantityTable
	 *            the quantityTable to set
	 */
	public void setQuantityTable(Long quantityTable) {
		this.quantityTable = quantityTable;
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
	 * @return the startTime
	 */
	public Long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the offTime
	 */
	public Long getOffTime() {
		return offTime;
	}

	/**
	 * @param offTime
	 *            the offTime to set
	 */
	public void setOffTime(Long offTime) {
		this.offTime = offTime;
	}

	/**
	 * @return the idtable
	 */
	public List<Long> getIdtable() {
		return idtable;
	}

	/**
	 * @param idtable
	 *            the idtable to set
	 */
	public void setIdtable(List<Long> idtable) {
		this.idtable = idtable;
	}

}
