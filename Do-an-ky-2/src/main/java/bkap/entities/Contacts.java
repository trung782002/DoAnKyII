package bkap.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Contacts")
public class Contacts {
	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer brandId;
	@Column(name = "AccId")
	private Integer accId;
	@Column(name = "FullName")
	@NotEmpty(message = "FullName is not null !!")
	private String fullName;
	@Column(name = "Email")
	@NotEmpty(message = "Email is not null !!")
	private String email;	
	@Column(name = "Phone")
	@NotEmpty(message = "Phone is not null !!")
	private String phone;
	@Column(name = "Message")
	@NotEmpty(message = "Message is not null !!")
	private String message;
	@Column(name = "Status")
	private boolean status;
	@Column(name = "CreatedAt")
	private Date createdAt;
	public Contacts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contacts(Integer brandId, Integer accId, String fullName, String email, String phone, String message,
			boolean status, Date createdAt) {
		super();
		this.brandId = brandId;
		this.accId = accId;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.message = message;
		this.status = status;
		this.createdAt = createdAt;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
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
