package bkap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "OrderDetails")
public class OrderDetails {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "Quantity")
	private Integer quantity;
	@Column(name = "Price")
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "OrderId", referencedColumnName = "OrderId")
	private Orders OrderDetail;
	
	@ManyToOne
	@JoinColumn(name = "ProId", referencedColumnName = "ProId")
	private Products objOrderDetail;

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(Integer id, Integer quantity, Double price, Orders orderDetail, Products objOrderDetail) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		OrderDetail = orderDetail;
		this.objOrderDetail = objOrderDetail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Orders getOrderDetail() {
		return OrderDetail;
	}

	public void setOrderDetail(Orders orderDetail) {
		OrderDetail = orderDetail;
	}

	public Products getObjOrderDetail() {
		return objOrderDetail;
	}

	public void setObjOrderDetail(Products objOrderDetail) {
		this.objOrderDetail = objOrderDetail;
	}
	
	
}
