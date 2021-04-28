/**
 * 
 */
package vn.hanu.restaurant.manager.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Admin
 *
 */

@Entity
@Table(name = "table_order")
public class TableOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String customer;
	@Column(name = "quantity_table")
	private Long quantityTable;
	private LocalDate date;
	@Column(name = "time_start")
	private Long timeStart;
	@Column(name = "time_off")
	private Long timeOff;
	@Enumerated(EnumType.STRING)
	private StatusTable status;

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
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the timeStart
	 */
	public Long getTimeStart() {
		return timeStart;
	}

	/**
	 * @param timeStart
	 *            the timeStart to set
	 */
	public void setTimeStart(Long timeStart) {
		this.timeStart = timeStart;
	}

	/**
	 * @return the timeOff
	 */
	public Long getTimeOff() {
		return timeOff;
	}

	/**
	 * @param timeOff
	 *            the timeOff to set
	 */
	public void setTimeOff(Long timeOff) {
		this.timeOff = timeOff;
	}

	/**
	 * @return the status
	 */
	public StatusTable getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(StatusTable status) {
		this.status = status;
	}

	public enum StatusTable {
		WAIT, EATING, END;
	}
}
