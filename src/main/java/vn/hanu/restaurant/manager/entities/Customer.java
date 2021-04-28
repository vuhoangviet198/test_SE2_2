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

/**
 * @author Admin
 *
 */

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String email;
	@Enumerated(EnumType.STRING)
	private TypeCustomer type;
	@Column(name = "block_status")
	private boolean blockStatus;
	@Column(name = "ins_date")
	private Date insDate;

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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the type
	 */
	public TypeCustomer getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(TypeCustomer type) {
		this.type = type;
	}

	/**
	 * @return the blockStatus
	 */
	public boolean isBlockStatus() {
		return blockStatus;
	}

	/**
	 * @param blockStatus
	 *            the blockStatus to set
	 */
	public void setBlockStatus(boolean blockStatus) {
		this.blockStatus = blockStatus;
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

	public enum TypeCustomer {
		CUSTOMER;
	}

}
