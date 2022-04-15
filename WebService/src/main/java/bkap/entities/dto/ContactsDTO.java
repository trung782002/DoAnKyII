package bkap.entities.dto;

import java.util.Date;

public class ContactsDTO {
	
	private Integer id;

	private Integer accId;

	private String fullName;

	private String email;	

	private String phone;

	private String message;

	private boolean status;

	private Date createdAt;
	
	public ContactsDTO() {
		// TODO Auto-generated constructor stub
	}

	public ContactsDTO(Integer id, Integer accId, String fullName, String email, String phone, String message,
			boolean status, Date createdAt) {
		super();
		this.id = id;
		this.accId = accId;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.message = message;
		this.status = status;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getStatus() {
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
