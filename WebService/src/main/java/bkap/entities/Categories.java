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
@Table(name = "Categories")
public class Categories {
	@Id
	@Column(name = "CateId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cateId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Status")
	private boolean status;
	
	@Column(name = "CreatedAt")
	private Date createdAt;
	
	@OneToMany(mappedBy = "objCategoryOfProduct")
	private Set<Products> listProducts;
	
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categories(Integer cateId, String name, boolean status, Date createdAt, Set<Products> listProducts) {
		super();
		this.cateId = cateId;
		this.name = name;
		this.status = status;
		this.createdAt = createdAt;
		this.listProducts = listProducts;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set<Products> getListProducts() {
		return listProducts;
	}

	public void setListProducts(Set<Products> listProducts) {
		this.listProducts = listProducts;
	}

	
}
