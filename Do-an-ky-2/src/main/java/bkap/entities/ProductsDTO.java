package bkap.entities;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductsDTO {
	
	private Integer proId;
	
	@NotEmpty(message = "Proudct name is not null !!")
	private String name;
	
	private String imageUrl;
	
	@NotNull(message = "Price is not null !!")
	private double price;
	
	@NotNull(message = "Discount is not null !!")
	private double discount;
	
	private Integer cateId;
	
	private Integer brandId;

	@NotEmpty(message = "Short description is not null !!")
	private String shortDescription;

	@NotEmpty(message = "Description is not null !!")
	private String description;

	@NotNull(message = "Quanity is not null !!")
	private Integer quanity;

	private boolean status;

	private Date createdAt;

	public ProductsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductsDTO(Integer proId, @NotEmpty(message = "Proudct name is not null !!") String name, String imageUrl,
			@NotNull(message = "Price is not null !!") double price,
			@NotNull(message = "Discount is not null !!") double discount, Integer cateId, Integer brandId,
			@NotEmpty(message = "Short description is not null !!") String shortDescription,
			@NotEmpty(message = "Description is not null !!") String description,
			@NotNull(message = "Quanity is not null !!") Integer quanity, boolean status, Date createdAt) {
		super();
		this.proId = proId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.price = price;
		this.discount = discount;
		this.cateId = cateId;
		this.brandId = brandId;
		this.shortDescription = shortDescription;
		this.description = description;
		this.quanity = quanity;
		this.status = status;
		this.createdAt = createdAt;
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuanity() {
		return quanity;
	}

	public void setQuanity(Integer quanity) {
		this.quanity = quanity;
	}

	public boolean getStatus() {
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

	
}
