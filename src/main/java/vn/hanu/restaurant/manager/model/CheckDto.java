/**
 * 
 */
package vn.hanu.restaurant.manager.model;

/**
 * @author Admin
 *
 */
public class CheckDto {

	private Long timeStart;
	private Long timeOff;
	private String dateOrder;

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
	 * @return the dateOrder
	 */
	public String getDateOrder() {
		return dateOrder;
	}

	/**
	 * @param dateOrder
	 *            the dateOrder to set
	 */
	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}

}
