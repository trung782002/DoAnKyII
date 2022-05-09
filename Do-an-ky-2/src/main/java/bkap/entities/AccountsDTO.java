package bkap.entities;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AccountsDTO {

	private Integer accId;
	
	@NotEmpty(message = "Please enter your account name.")
	private String accName;

	@NotEmpty(message = "Please enter your fullname.")
	private String fullName;

	//@NotEmpty(message = "Please enter your email.")
	@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "Email wrong format")
	private String email;

	@NotEmpty(message = "Please enter your address.")
	private String address;

	@NotEmpty(message = "Please enter your phone.")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Phone wrong format.")
	private String phone;

	@NotEmpty(message = "Please enter password.")
	private String password;

	private boolean status;

	private String rememberToken;

	private Date createdAt;

	public AccountsDTO() {
		// TODO Auto-generated constructor stub
	}

	public AccountsDTO(Integer accId, String accName, String fullName, String email, String address, String phone,
			String password, boolean status, String rememberToken, Date createdAt) {
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

	public boolean isStatus() {
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
