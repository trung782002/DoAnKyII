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
@Table(name = "Brands")
public class Brands {
	@Id
	@Column(name = "BrandId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer brandId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "ImageUrl")
	private String imageUrl;
	
	@Column(name = "Status")
	private boolean status;
	
	@Column(name = "CreatedAt")
	private Date createdAt;
	
	@OneToMany(mappedBy = "objBrandOfProduct")
	private Set<Products> listProducts;

	public Brands() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Brands(Integer brandId, String name, String imageUrl, boolean status, Date createdAt,
			Set<Products> listProducts) {
		super();
		this.brandId = brandId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.status = status;
		this.createdAt = createdAt;
		this.listProducts = listProducts;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
