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

@Entity
@Table(name = "Accounts")
public class Accounts {
	@Id
	@Column(name = "AccId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accId;
	
	@Column(name = "AccName")
	private String accName;
	
	@Column(name = "FullName")
	private String fullName;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Phone")
	private String phone;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Status")
	private boolean status;
	
	@Column(name = "RememberToken")
	private String rememberToken;
	
	@Column(name = "CreatedAt")
	private Date createdAt;
	
	@OneToMany(mappedBy = "objAccountOfAccountRole")
	private Set<Account_Roles> listAccountRoles;
	
	@OneToMany(mappedBy = "objAccountOfReview")
	private Set<Reviews> listReviews;
	
	@OneToMany(mappedBy = "objAccountOfCart")
	private Set<Carts> listCarts;
	
	@OneToMany(mappedBy = "objAccountOfOrder")
	private Set<Orders> listOrders;
	
	public Accounts() {
		// TODO Auto-generated constructor stub
	}

	public Accounts(Integer accId, String accName, String fullName, String email, String address, String phone,
			String password, boolean status, String rememberToken, Date createdAt, Set<Account_Roles> listAccountRoles,
			Set<Reviews> listReviews, Set<Carts> listCarts, Set<Orders> listOrders) {
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
		this.listReviews = listReviews;
		this.listCarts = listCarts;
		this.listOrders = listOrders;
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

	public Set<Account_Roles> getListAccountRoles() {
		return listAccountRoles;
	}

	public void setListAccountRoles(Set<Account_Roles> listAccountRoles) {
		this.listAccountRoles = listAccountRoles;
	}

	public Set<Reviews> getListReviews() {
		return listReviews;
	}

	public void setListReviews(Set<Reviews> listReviews) {
		this.listReviews = listReviews;
	}

	public Set<Carts> getListCarts() {
		return listCarts;
	}

	public void setListCarts(Set<Carts> listCarts) {
		this.listCarts = listCarts;
	}

	public Set<Orders> getListOrders() {
		return listOrders;
	}

	public void setListOrders(Set<Orders> listOrders) {
		this.listOrders = listOrders;
	}

	
}
