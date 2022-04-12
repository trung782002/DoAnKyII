package bkap.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Accounts")
public class Accounts {
	@Id
	@Column(name = "AccId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accId;
	
	@Column(name = "AccName")
	@NotEmpty(message = "AccName is null")
	private String accName;
	
	@Column(name = "FullName")
	@NotEmpty(message = "FullName is null")
	private String fullName;
	
	@Column(name = "Email")
	@NotEmpty(message = "Email is null")
	private String email;
	
	@Column(name = "Address")
	@NotEmpty(message = "Address is null")
	private String address;
	
	@Column(name = "Phone")
	@NotEmpty(message = "Phone is null")
	private String phone;
	
	@Column(name = "Password")
	@NotEmpty(message = "Password is null")
	private String password;
	
	@Column(name = "Status")
	private Boolean status;
	
	@Column(name = "RememberToken")
	private String rememberToken;
	
	@Column(name = "CreatedAt")
	private Date createdAt;
	
	@OneToMany(mappedBy = "objAccount")
	private Set<Account_Roles> listAccountRoles;
	
	@OneToMany(mappedBy = "objReview")
	private Set<Reviews> listAccountReview;
	
	@OneToMany(mappedBy = "objCart")
	private Set<Carts> listAccountCarts;
	
	@OneToMany(mappedBy = "objAccountOfOrder")
	private Set<Orders> listAccountOrders;
	
	public Accounts() {
		// TODO Auto-generated constructor stub
	}

	public Accounts(Integer accId, String accName, String fullName, String email, String address, String phone,
			String password, Boolean status, String rememberToken, Date createdAt, Set<Account_Roles> listAccountRoles,
			Set<Reviews> listAccountReview, Set<Carts> listAccountCarts, Set<Orders> listAccountOrders) {
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
		this.listAccountRoles = listAccountRoles;
		this.listAccountReview = listAccountReview;
		this.listAccountCarts = listAccountCarts;
		this.listAccountOrders = listAccountOrders;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
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

	public Set<Account_Roles> getListAccountRoles() {
		return listAccountRoles;
	}

	public void setListAccountRoles(Set<Account_Roles> listAccountRoles) {
		this.listAccountRoles = listAccountRoles;
	}

	public Set<Reviews> getListAccountReview() {
		return listAccountReview;
	}

	public void setListAccountReview(Set<Reviews> listAccountReview) {
		this.listAccountReview = listAccountReview;
	}

	public Set<Carts> getListAccountCarts() {
		return listAccountCarts;
	}

	public void setListAccountCarts(Set<Carts> listAccountCarts) {
		this.listAccountCarts = listAccountCarts;
	}

	public Set<Orders> getListAccountOrders() {
		return listAccountOrders;
	}

	public void setListAccountOrders(Set<Orders> listAccountOrders) {
		this.listAccountOrders = listAccountOrders;
	}
	
	
	
}
