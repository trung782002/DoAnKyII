package bkap.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Orders")
public class Orders {
	@Id
	@Column(name = "OrderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	@Column(name = "FullName")
	@NotEmpty(message = "FullName is not null !!")
	private String fullName;
	@Column(name = "Address")
	@NotEmpty(message = "Address is not null !!")
	private String address;
	@Column(name = "Phone")
	@NotEmpty(message = "Phone is not null !!")
	private String phone;
	@Column(name = "Note")
	private String note;
	@Column(name = "TotalPrice")
	private String totalPrice;
	@Column(name = "Status")
	private boolean status;
	@Column(name = "CreatedAt")
	private Date createdAt;
	@Column(name = "UpdatedAt")
	private Date updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "AccId", referencedColumnName = "AccId")
	private Accounts objAccountOfOrder;
	
	@OneToMany(mappedBy = "objOrderDetail")
	private Set<OrderDetails> listAccountOrderDetails;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Integer orderId, String fullName, String address, String phone, String note, String totalPrice,
			boolean status, Date createdAt, Date updatedAt, Accounts objAccountOfOrder,
			Set<OrderDetails> listAccountOrderDetails) {
		super();
		this.orderId = orderId;
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
		this.note = note;
		this.totalPrice = totalPrice;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.objAccountOfOrder = objAccountOfOrder;
		this.listAccountOrderDetails = listAccountOrderDetails;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Accounts getObjAccountOfOrder() {
		return objAccountOfOrder;
	}

	public void setObjAccountOfOrder(Accounts objAccountOfOrder) {
		this.objAccountOfOrder = objAccountOfOrder;
	}

	public Set<OrderDetails> getListAccountOrderDetails() {
		return listAccountOrderDetails;
	}

	public void setListAccountOrderDetails(Set<OrderDetails> listAccountOrderDetails) {
		this.listAccountOrderDetails = listAccountOrderDetails;
	}
	
	
}
