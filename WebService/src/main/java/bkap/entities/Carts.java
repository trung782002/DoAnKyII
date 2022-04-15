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
@Table(name = "Carts")
public class Carts {
	@Id
	@Column(name = "CartId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	
	@Column(name = "Quantity")
	private Integer quantity;
	
	@Column(name = "TotalPrice")
	private Double totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "AccId", referencedColumnName = "AccId")
	private Accounts objAccountOfCart;
	
	@ManyToOne
	@JoinColumn(name = "ProId", referencedColumnName = "ProId")
	private Products objProductOfCart;

	public Carts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carts(Integer cartId, Integer quantity, Double totalPrice, Accounts objAccountOfCart,
			Products objProductOfCart) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.objAccountOfCart = objAccountOfCart;
		this.objProductOfCart = objProductOfCart;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Accounts getObjAccountOfCart() {
		return objAccountOfCart;
	}

	public void setObjAccountOfCart(Accounts objAccountOfCart) {
		this.objAccountOfCart = objAccountOfCart;
	}

	public Products getObjProductOfCart() {
		return objProductOfCart;
	}

	public void setObjProductOfCart(Products objProductOfCart) {
		this.objProductOfCart = objProductOfCart;
	}

	
}
