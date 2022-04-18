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

@Entity
@Table(name = "Orders")
public class Orders {
	@Id
	@Column(name = "OrderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	@Column(name = "FullName")
	private String fullName;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Phone")
	private String phone;
	
	@Column(name = "Note")
	private String note;
	
	@Column(name = "TotalPrice")
	private double totalPrice;
	
	@Column(name = "Status")
	private int status;
	
	@Column(name = "CreatedAt")
	private Date createdAt;
	
	@Column(name = "UpdatedAt")
	private Date updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "AccId", referencedColumnName = "AccId")
	private Accounts objAccountOfOrder;
	
	@OneToMany(mappedBy = "objOrderOfOrderDetail")
	private Set<OrderDetails> listOrderDetails;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Integer orderId, String fullName, String address, String phone, String note, double totalPrice,
			int status, Date createdAt, Date updatedAt, Accounts objAccountOfOrder,
			Set<OrderDetails> listOrderDetails) {
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
		this.listOrderDetails = listOrderDetails;
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
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

	public Accounts getObjAccountOfOrder() {
		return objAccountOfOrder;
	}

	public void setObjAccountOfOrder(Accounts objAccountOfOrder) {
		this.objAccountOfOrder = objAccountOfOrder;
	}

	public Set<OrderDetails> getListOrderDetails() {
		return listOrderDetails;
	}

	public void setListOrderDetails(Set<OrderDetails> listOrderDetails) {
		this.listOrderDetails = listOrderDetails;
	}

	
}
