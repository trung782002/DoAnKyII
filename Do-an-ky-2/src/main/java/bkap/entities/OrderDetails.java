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
	private Orders objOrderOfOrderDetail;
	
	@ManyToOne
	@JoinColumn(name = "ProId", referencedColumnName = "ProId")
	private Products objProductOfOrderDetail;

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(Integer id, Integer quantity, Double price, Orders objOrderOfOrderDetail,
			Products objProductOfOrderDetail) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.objOrderOfOrderDetail = objOrderOfOrderDetail;
		this.objProductOfOrderDetail = objProductOfOrderDetail;
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

	public Orders getObjOrderOfOrderDetail() {
		return objOrderOfOrderDetail;
	}

	public void setObjOrderOfOrderDetail(Orders objOrderOfOrderDetail) {
		this.objOrderOfOrderDetail = objOrderOfOrderDetail;
	}

	public Products getObjProductOfOrderDetail() {
		return objProductOfOrderDetail;
	}

	public void setObjProductOfOrderDetail(Products objProductOfOrderDetail) {
		this.objProductOfOrderDetail = objProductOfOrderDetail;
	}

	
}
