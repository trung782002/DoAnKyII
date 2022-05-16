package bkap.entities.dto;

import java.util.Date;

public class AccountsDTO {
	
	private Integer accId;
	
	private String email;
	
	private String fullName;
	
	private String phone;
	
	private String address;
	
	private String password;
	
	private boolean status;
	
	private Date createdAt;
	
	public AccountsDTO() {
		// TODO Auto-generated constructor stub
	}

	public AccountsDTO(Integer accId, String email, String fullName, String phone, String address, String password,
			boolean status, Date createdAt) {
		super();
		this.accId = accId;
		this.email = email;
		this.fullName = fullName;
		this.phone = phone;
		this.address = address;
		this.password = password;
		this.status = status;
		this.createdAt = createdAt;
	}

	public Integer getAccId() {
		return accId;
	}

	public void setAccId(Integer accId) {
		this.accId = accId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
