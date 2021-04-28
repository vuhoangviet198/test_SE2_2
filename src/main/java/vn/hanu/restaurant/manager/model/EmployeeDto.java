/**
 * 
 */
package vn.hanu.restaurant.manager.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import vn.hanu.restaurant.manager.entities.Employee.Gender;
import vn.hanu.restaurant.manager.entities.Employee.Job;
import vn.hanu.restaurant.manager.entities.Employee.TypeEmployee;

/**
 * @author Admin
 *
 */
public class EmployeeDto {
	private Long id;
	private String username;
	private String password;
	@NotEmpty(message = "Mã tài khoản không được để trống")
	private String code;
	private Gender gender;
	@NotEmpty(message = "Ngày sinh không được để trống")
	private String birthday;
	@NotEmpty(message = "Tên nhân viên không được để trống")
	private String fullname;
	private String image;
	@NotEmpty(message = "Quê quán không được để trống")
	private String hometown;
	private float baseSalary;
	private Job job;
	private boolean blockStatus;
	private TypeEmployee type;
	private Date dateJoin;
	private String dateOut;

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
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(String birthday) {
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
	public String getDateOut() {
		return dateOut;
	}

	/**
	 * @param dateOut
	 *            the dateOut to set
	 */
	public void setDateOut(String dateOut) {
		this.dateOut = dateOut;
	}

}
