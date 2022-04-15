package bkap.entities;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class AccountsDTO {

	private Integer accId;

	@NotEmpty(message = "Account name is null")
	private String accName;

	@NotEmpty(message = "Fullname is null")
	private String fullName;

	@NotEmpty(message = "Email is null")
	private String email;

	@NotEmpty(message = "Address is null")
	private String address;

	@NotEmpty(message = "Phone is null")
	private String phone;

	@NotEmpty(message = "Password is null")
	private String password;

	private boolean status;

	private String rememberToken;

	private Date createdAt;

	public AccountsDTO() {
		// TODO Auto-generated constructor stub
	}

	public AccountsDTO(Integer accId, @NotEmpty(message = "Account name is null") String accName,
			@NotEmpty(message = "Fullname is null") String fullName, @NotEmpty(message = "Email is null") String email,
			@NotEmpty(message = "Address is null") String address, @NotEmpty(message = "Phone is null") String phone,
			@NotEmpty(message = "Password is null") String password, boolean status, String rememberToken,
			Date createdAt) {
		super();
		this.accId = accId;
		this.accName = accName;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.password = password;
		this.status = status;
		this.rememberToken = rememberToken;
		this.createdAt = createdAt;
	}

	public Integer getAccId() {
		return accId;
	}

	public void setAccId(Integer accId) {
		this.accId = accId;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRememberToken() {
		return rememberToken;
	}

	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
