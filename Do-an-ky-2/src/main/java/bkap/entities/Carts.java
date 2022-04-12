package bkap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Carts")
public class Carts {
	@Id
	@Column(name = "CartId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	@Column(name = "Quantity")
	@NotNull(message = "Quantity Price is not null !!")
	private Integer quantity;
	@Column(name = "TotalPrice")
	private Double totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "AccId", referencedColumnName = "AccId")
	private Accounts objCart;
	
	@ManyToOne
	@JoinColumn(name = "ProId", referencedColumnName = "ProId")
	private Products objProduct;

	public Carts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carts(Integer cartId, Integer quantity, Double totalPrice, Accounts objCart, Products objProduct) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.objCart = objCart;
		this.objProduct = objProduct;
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

	public Accounts getObjCart() {
		return objCart;
	}

	public void setObjCart(Accounts objCart) {
		this.objCart = objCart;
	}

	public Products getObjProduct() {
		return objProduct;
	}

	public void setObjProduct(Products objProduct) {
		this.objProduct = objProduct;
	}
	
	
}
