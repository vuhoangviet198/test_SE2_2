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
import javax.persistence.Table;

/**
 * @author Admin
 *
 */

@Entity
@Table(name = "table_order_detail")
public class TableOrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "id_table")
	private Long idTable;
	@Column(name = "id_table_order")
	private Long idTableOrder;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(insertable = false, updatable = false, name = "id_table")
	private Tables table;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(insertable = false, updatable = false, name = "id_table_order")
	private TableOrder tableOrder;

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
	 * @return the idTable
	 */
	public Long getIdTable() {
		return idTable;
	}

	/**
	 * @param idTable
	 *            the idTable to set
	 */
	public void setIdTable(Long idTable) {
		this.idTable = idTable;
	}

	/**
	 * @return the idTableOrder
	 */
	public Long getIdTableOrder() {
		return idTableOrder;
	}

	/**
	 * @param idTableOrder
	 *            the idTableOrder to set
	 */
	public void setIdTableOrder(Long idTableOrder) {
		this.idTableOrder = idTableOrder;
	}

	/**
	 * @return the table
	 */
	public Tables getTable() {
		return table;
	}

	/**
	 * @param table
	 *            the table to set
	 */
	public void setTable(Tables table) {
		this.table = table;
	}

	/**
	 * @return the tableOrder
	 */
	public TableOrder getTableOrder() {
		return tableOrder;
	}

	/**
	 * @param tableOrder
	 *            the tableOrder to set
	 */
	public void setTableOrder(TableOrder tableOrder) {
		this.tableOrder = tableOrder;
	}

}
