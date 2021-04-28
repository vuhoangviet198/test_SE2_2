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
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String code;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private Date birthday;
	private String fullname;
	private String image;
	private String hometown;
	@Column(name = "base_salary")
	private float baseSalary;
	@Enumerated(EnumType.STRING)
	private Job job;
	@Column(name = "block_status")
	private boolean blockStatus;
	@Enumerated(EnumType.STRING)
	private TypeEmployee type;
	@Column(name = "date_join")
	private Date dateJoin;
	@Column(name = "date_out")
	private Date dateOut;

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
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * @param fullname
	 *            the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the hometown
	 */
	public String getHometown() {
		return hometown;
	}

	/**
	 * @param hometown
	 *            the hometown to set
	 */
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	/**
	 * @return the baseSalary
	 */
	public float getBaseSalary() {
		return baseSalary;
	}

	/**
	 * @param baseSalary
	 *            the baseSalary to set
	 */
	public void setBaseSalary(float baseSalary) {
		this.baseSalary = baseSalary;
	}

	/**
	 * @return the job
	 */
	public Job getJob() {
		return job;
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setJob(Job job) {
		this.job = job;
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
	 * @return the type
	 */
	public TypeEmployee getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(TypeEmployee type) {
		this.type = type;
	}

	/**
	 * @return the dateJoin
	 */
	public Date getDateJoin() {
		return dateJoin;
	}

	/**
	 * @param dateJoin
	 *            the dateJoin to set
	 */
	public void setDateJoin(Date dateJoin) {
		this.dateJoin = dateJoin;
	}

	/**
	 * @return the dateOut
	 */
	public Date getDateOut() {
		return dateOut;
	}

	/**
	 * @param dateOut
	 *            the dateOut to set
	 */
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}

	public enum Gender {
		MALE, FEMALE;
	}

	public enum Job {
		CHEF, WAITER, SECURITY, CASHIER, SHIPER, MANAGER;
	}

	public enum TypeEmployee {
		EMPLOYEE, ADMIN;
	}
}
