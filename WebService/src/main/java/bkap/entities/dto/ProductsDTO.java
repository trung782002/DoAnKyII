package bkap.entities.dto;

import java.util.Date;

public class ProductsDTO {
	
	private Integer proId;
	
	private String name;
	
	private String imageUrl;
	
	private Double price;
	
	private Double discount;
	
	private Integer cateId;
	
	private Integer brandId;

	private String shortDescription;

	private String description;

	private Integer quanity;

	private boolean status;

	private Date createdAt;

	public ProductsDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductsDTO(Integer proId, String name, String imageUrl, Double price, Double discount, Integer cateId,
			Integer brandId, String shortDescription, String description, Integer quanity, boolean status,
			Date createdAt) {
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
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
