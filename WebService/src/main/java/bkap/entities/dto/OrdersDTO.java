package bkap.entities.dto;

import java.util.Date;

public class OrdersDTO {
	
	private Integer orderId;
	
	private Integer accId;
	
	private String fullName;

	private String address;

	private String phone;

	private String note;

	private String totalPrice;

	private int status;

	private Date createdAt;

	private Date updatedAt;
	
	public OrdersDTO() {
		// TODO Auto-generated constructor stub
	}

	public OrdersDTO(Integer orderId, Integer accId, String fullName, String address, String phone, String note,
			String totalPrice, int status, Date createdAt, Date updatedAt) {
		super();
		this.orderId = orderId;
		this.accId = accId;
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
		this.note = note;
		this.totalPrice = totalPrice;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getAccId() {
		return accId;
	}

	public void setAccId(Integer accId) {
		this.accId = accId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
}
